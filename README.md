# Brevo (ex Sendinblue) transactional SMS sender Java module

Send transactional SMS with Brevo's (ex Sendinblue) API v3 Java Library.

### Configuration

###### 1. Store your Brevo API key

Store your Brevo API key in an .env file at the root of the project using the following command:

```
echo "SIB_KEY=my_secret_key" > .env
```
> [!WARNING]
> do not track this file ;)

###### 2. Build

If you are using Apache Maven, build the project using:
```
mvn clean install
```
A file `target/sib-sms-1.0-SNAPSHOT.jar` should be created. Note that I am using java-17-openjdk.

###### 3. Use it

See `src/main/java/sib_sms/App.java` for usage example.

According to [Brevo's doc](https://developers.brevo.com/docs/transactional-sms-endpoints), follow these requirements for SMS messages attributes:

| Attribute name      | Datatype | Description                                                                                                                                                               | Value                                               |
|---------------------|----------|---------------------------------------------------------------------------------------------------------------------------------------------------------------------------|-----------------------------------------------------|
| sender              | String   | Name of the sender. The number of characters is limited to 11 for alphanumeric characters and 15 for numeric characters                                                    | MyShop                                              |
| recipient           | String   | Mobile number to send SMS with the country code                                                                                                                           | 33689965433                                         |
| content             | String   | Content of the message. If more than 160 characters long, will be sent as multiple text messages                                                                           | Enter this code:CCJJG8 to validate your account     |
| type                | String   | Type of the SMS. Marketing SMS messages are those sent typically with marketing content. Transactional SMS messages are sent to individuals and are triggered in response to some action, such as a sign-up, purchase, etc. | Choice of Transactional and Marketing               |
| tag                 | String   | Tag of the message                                                                                                                                                         | accountValidation                                   |
| webUrl              | Url      | Webhook to call for each event triggered by the message (delivered etc.)                                                                                                   | `http://requestb.in/173lyyx1`                       |
| unicodeEnabled      | Boolean  | Format of the message. It indicates whether the content should be treated as unicode or not.                                                                               | Boolean true or false                               |
| organisationPrefix  | String   | A recognizable prefix will ensure your audience knows who you are. Recommended by U.S. carriers. This will be added as your Brand Name before the message content. Prefer verifying maximum length of 160 characters including this prefix in message content to avoid multiple sending of same sms. | Brand name like **My Company**                      |
