package pl.javastart.bootcamp.lekcja22zadaniedomoweformularzkontaktowy;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;
import org.springframework.stereotype.Service;

@Service
public class MailSender {

    private static final String userName = "testjavakurs";
    private static final String password = "javakurs1!";
    private static final String companyMail = "testjavakurs@gmail.com";
    private static final String gmailHostName = "smtp.gmail.com";
    private static final String returningMessage = "Potwierdzenie wysłania maila do testjavakurs.\n" + "Zapytanie: \n";
    private static final String startMessage = "Rozpoczęto wysyłanie wiadomości email";
    private static final String endMessage = "Wiadomość wysłana";
    private static final String dataFromFormMessage = "Dane z formularza: ";

    public void sendEmail(MyEmail myEmail) throws EmailException {
        Email email = new SimpleEmail();
        email.setHostName(gmailHostName);
        email.setSmtpPort(465);
        email.setAuthenticator(new DefaultAuthenticator(userName, password));
        email.setSSLOnConnect(true);
        email.setFrom(myEmail.getEmail(), myEmail.getName());
        email.addReplyTo(myEmail.getEmail());
        email.setSubject(myEmail.getTitle());
        email.setMsg(returningMessage + myEmail.getMessage());
        email.addTo(companyMail);
        email.addTo(myEmail.getEmail());
        System.out.println(startMessage);
        System.out.println(dataFromFormMessage + myEmail.getEmail() + " " + myEmail.getName() + " " + myEmail.getTitle()
                + " " + myEmail.getMessage());
        email.send();
        System.out.println(endMessage);
    }
}
