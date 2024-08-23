package sib_sms;

import io.github.cdimascio.dotenv.Dotenv;
import sendinblue.ApiException;

public class App {
    public static void main(String[] args) throws ApiException {
        Dotenv dotenv = Dotenv.load();
        SendinblueSmsProvider sendinblueSmsProvider = new SendinblueSmsProvider(dotenv.get("SIB_KEY"));

        // See SendinblueSmsSender for further info on these params
        String senderId = "Test";
        String recipient = "+33*********";
        String content = "Lorem Ipsum dolor sit amet";

        sendinblueSmsProvider.send(
                senderId,
                recipient,
                content,
                false
        );
    }
}
