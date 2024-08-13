package brevo_sms;

import sendinblue.*;
import sendinblue.auth.*;
import sibApi.TransactionalEmailsApi;
import sibModel.*;

import java.util.*;

import io.github.cdimascio.dotenv.Dotenv;

public class EmailTesting
{
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();

        Dotenv dotenv = Dotenv.load();

        // Configure API key authorization: api-key
        ApiKeyAuth apiKey = (ApiKeyAuth) defaultClient.getAuthentication("api-key");
        apiKey.setApiKey(dotenv.get("SIB_KEY"));

        /*
        AccountApi apiInstance = new AccountApi();
        try {
            GetAccount result = apiInstance.getAccount();
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling AccountApi#getAccount");
            e.printStackTrace();
        }
        */

        try {
            TransactionalEmailsApi api = new TransactionalEmailsApi();
            SendSmtpEmailSender sender = new SendSmtpEmailSender();
            sender.setEmail("***@gmail.com");
            sender.setName("John Doe");
            List<SendSmtpEmailTo> toList = new ArrayList<SendSmtpEmailTo>();
            SendSmtpEmailTo to = new SendSmtpEmailTo();
            to.setEmail("***@gmail.com");
            to.setName("John DEE");
            toList.add(to);
            SendSmtpEmailReplyTo replyTo = new SendSmtpEmailReplyTo();
            replyTo.setEmail("replyto@domain.com");
            replyTo.setName("John Doe");
            SendSmtpEmail sendSmtpEmail = new SendSmtpEmail();
            sendSmtpEmail.setSender(sender);
            sendSmtpEmail.setTo(toList);
            sendSmtpEmail.setHtmlContent("<html><body><h1>This is my first transactional email</h1></body></html>");
            sendSmtpEmail.setSubject("My {{params.subject}}");
            sendSmtpEmail.setReplyTo(replyTo);
            List<SendSmtpEmailTo1> toList1 = new ArrayList<SendSmtpEmailTo1>();
            SendSmtpEmailTo1 to1 = new SendSmtpEmailTo1();
            to1.setEmail("***@gmail.com");
            to1.setName("***");
            toList1.add(to1);
            sendSmtpEmail.setTemplateId(2L);

            try {
                CreateSmtpEmail response = api.sendTransacEmail(sendSmtpEmail);
                System.out.println(response.toString());
            } catch (ApiException e) {
                e.printStackTrace();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
