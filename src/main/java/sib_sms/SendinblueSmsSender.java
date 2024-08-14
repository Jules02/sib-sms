package sib_sms;

import sendinblue.ApiClient;
import sendinblue.ApiException;
import sendinblue.Configuration;
import sendinblue.auth.ApiKeyAuth;
import sibApi.TransactionalSmsApi;
import sibModel.SendSms;
import sibModel.SendTransacSms;

import org.jboss.logging.Logger;

public class SendinblueSmsSender {

    private static final Logger LOGGER = Logger.getLogger(SendinblueSmsSender.class);
    private ApiClient apiClient;

    public static SendinblueSmsSender create()
    {
        return new SendinblueSmsSender();
    }

    // TODO: Improve exceptions handling

    /**
     * Sends an SMS using Sendinblue (now Brevo) API.
     *
     * @throws ApiException with message from Sendinblue's {@link ApiException} (for example:
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
            LOGGER.infof(result.toString());
        } catch (ApiException e) {
            // NOTE: Ok d'afficher le numéro en clair dans le log ??
            LOGGER.errorf("Unable to send transactional SMS for user '%s'", recipient);
            LOGGER.errorf(e.getMessage());
            throw e;
        }
    }

    /**
     * Sets the API key and update the API client.
     *
     * @param apiKey api-key to use sendinblue API
     */
    public void setApiKey(String apiKey)
    {
        LOGGER.infof("setApiKey(apiKey='*******') has been invoked");

        apiClient = Configuration.getDefaultApiClient();
        ApiKeyAuth apiKeyAuth = (ApiKeyAuth) apiClient.getAuthentication("api-key");
        apiKeyAuth.setApiKey(apiKey);
    }
}
