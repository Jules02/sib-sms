package sib_sms;

import sendinblue.ApiClient;
import sendinblue.ApiException;
import sendinblue.Configuration;
import sendinblue.auth.ApiKeyAuth;
import sibApi.TransactionalSmsApi;
import sibModel.SendSms;
import sibModel.SendTransacSms;

import java.util.logging.Logger;

public class SendinblueSmsSender {
    private static final Logger LOGGER = Logger.getLogger(SendinblueSmsSender.class.getPackage().getName());
    private ApiClient apiClient;

    public static SendinblueSmsSender create()
    {
        return new SendinblueSmsSender();
    }

    /**
     * Sends an SMS using Sendinblue (now Brevo) API.
     *
     * @throws Exception with message from Sendinblue's {@link ApiException} (for example:
     *             'Unauthorized' when API key is invalid or
     *             'Not Found' when template couldn't be found.)
     */
    public void postToSendinblue(
            String sender,
            String recipient,
            String content
    ) throws ApiException {
        TransactionalSmsApi api = new TransactionalSmsApi(apiClient);

        SendTransacSms sendTransacSms = new SendTransacSms();
        sendTransacSms.setSender(sender);
        sendTransacSms.setRecipient(recipient);
        sendTransacSms.setContent(content);
        sendTransacSms.setType(SendTransacSms.TypeEnum.TRANSACTIONAL);

        try {
            SendSms result = api.sendTransacSms(sendTransacSms);
            LOGGER.info(result.toString());
        } catch (ApiException e) {
            // NOTE: Ok d'afficher le numéro en clair dans le log ??
            LOGGER.severe(String.format("Unable to send transactional SMS for user '%s'", recipient));
            LOGGER.severe(e.getMessage());
            throw e;
        }
    }

    /**
     * Sets the API key and update the default client.
     *
     * @param apiKey api-key to use sendinblue API
     * @return this instance
     */
    public SendinblueSmsSender setApiKey(String apiKey)
    {
        LOGGER.info("setApiKey(apiKey='*******') has been invoked");

        ApiClient defaultClient = Configuration.getDefaultApiClient();
        ApiKeyAuth apiKeyAuth = (ApiKeyAuth)apiClient.getAuthentication("api-key");
        apiKeyAuth.setApiKey(apiKey);
        return this;
    }
}
