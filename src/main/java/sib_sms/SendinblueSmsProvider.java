package sib_sms;

import org.jboss.logging.Logger;
import sendinblue.ApiException;

public class SendinblueSmsProvider {

    private static final Logger LOGGER = Logger.getLogger(SendinblueSmsProvider.class);
    private SendinblueSmsSender sendinblueSmsSender;

    // NOTE: As of now, SendinblueSmsProvider does not implement any Provider class from Keycloak and will hence not be recognized as a provider by Keycloak.

    public SendinblueSmsProvider(String apiKey) {
        sendinblueSmsSender = SendinblueSmsSender.create();
        sendinblueSmsSender.setApiKey(apiKey);
        LOGGER.infof("Instantiated %s", getClass().getSimpleName());
    }

    public void send(String sender, String recipient, String content) throws ApiException {
        sendinblueSmsSender.postToSendinblue(
                sender,
                recipient,
                content
        );
    }
}
