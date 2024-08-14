package sib_sms;

import io.github.cdimascio.dotenv.Dotenv;
import sendinblue.ApiException;

public class App {
    public static void main(String[] args) throws ApiException {
        Dotenv dotenv = Dotenv.load();

        SendinblueSmsProvider sendinblueSmsProvider = new SendinblueSmsProvider(dotenv.get("SIB_KEY"));

        sendinblueSmsProvider.send(
                "SENDER",
                "+33*********",
                "Lorem Ipsum dolor sit amet"
        );
    }
}
