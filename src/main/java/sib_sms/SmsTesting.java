package sib_sms;

import sendinblue.*;
import sendinblue.auth.*;
import sibApi.TransactionalSmsApi;
import sibModel.*;

import io.github.cdimascio.dotenv.Dotenv;

public class SmsTesting {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();

        Dotenv dotenv = Dotenv.load();

        // Configure API key authorization: api-key
        ApiKeyAuth apiKey = (ApiKeyAuth) defaultClient.getAuthentication("api-key");
        apiKey.setApiKey(dotenv.get("SIB_KEY"));

        try {
            TransactionalSmsApi api = new TransactionalSmsApi(defaultClient);

            SendTransacSms sendTransacSms = new SendTransacSms();
            sendTransacSms.setSender("TestSender");
            sendTransacSms.setRecipient("+33*********");
            sendTransacSms.setContent("Test message content");
            sendTransacSms.setType(SendTransacSms.TypeEnum.TRANSACTIONAL);

            try {
                SendSms result = api.sendTransacSms(sendTransacSms);
                System.out.println(result);
            } catch (ApiException e) {
                System.err.println("Exception when calling TransactionalSmsApi#sendTransacSms");
                e.printStackTrace();
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}