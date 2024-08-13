package brevo_sms;

import sendinblue.*;
import sendinblue.auth.*;
import sibModel.*;
import sibApi.AccountApi;

import java.io.File;
import java.util.*;

import io.github.cdimascio.dotenv.Dotenv;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Dotenv dotenv = Dotenv.load();
        String apiKey = dotenv.get("SIB_KEY");

        System.out.println("SIB_KEY: " + apiKey);
    }
}
