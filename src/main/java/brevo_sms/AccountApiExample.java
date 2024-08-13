package brevo_sms;

import sendinblue.*;
import sendinblue.auth.*;
import sibModel.*;
import sibApi.AccountApi;

import java.io.File;
import java.util.*;

import io.github.cdimascio.dotenv.Dotenv;

public class AccountApiExample
{
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();

        Dotenv dotenv = Dotenv.load();

        // Configure API key authorization: api-key
        ApiKeyAuth apiKey = (ApiKeyAuth) defaultClient.getAuthentication("api-key");
        apiKey.setApiKey(dotenv.get("SIB_KEY"));

        AccountApi apiInstance = new AccountApi();
        try {
            GetAccount result = apiInstance.getAccount();
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling AccountApi#getAccount");
            e.printStackTrace();
        }
    }
}
