package pl.javastart.bootcamp.lekcja22zadaniedomoweformularzkontaktowy;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;
import org.springframework.stereotype.Service;

@Service
public class MailSender {

    public void sendEmail(MyEmail myEmail) throws EmailException {
        Email email = new SimpleEmail();
        email.setHostName("smtp.gmail.com");
        email.setSmtpPort(465);
        email.setAuthenticator(new DefaultAuthenticator("testjavakurs@gmail.com", "javakurs1!"));
        email.setSSLOnConnect(true);
        email.setFrom(myEmail.getEmail(), myEmail.getName());
        email.addReplyTo(myEmail.getEmail());
        email.setSubject(myEmail.getTitle());
        email.setMsg(myEmail.getMessage());
        email.addTo("testjavakurs@gmail.com");
        email.addTo(myEmail.getEmail());
        System.out.println("Rozpoczęto wysyłanie wiadomości email");
        System.out.println("Dane wiadomości: " + myEmail.getEmail() + " " + myEmail.getName() + " " + myEmail.getTitle() + " " + myEmail.getMessage());
        email.send();
        System.out.println("Wiadomość wysłana");
    }
}
