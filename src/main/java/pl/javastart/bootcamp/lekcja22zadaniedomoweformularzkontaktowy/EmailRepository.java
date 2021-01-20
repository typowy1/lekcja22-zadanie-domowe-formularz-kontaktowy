package pl.javastart.bootcamp.lekcja22zadaniedomoweformularzkontaktowy;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

@Repository
public class EmailRepository {

    private List<MyEmail> emails;

    public EmailRepository() {
        emails = new ArrayList<>();
    }

    public void add(MyEmail email) {
        emails.add(email);
    }

    public void sendEmail(MyEmail myEmail) throws EmailException {
        Email email = new SimpleEmail();
        email.setHostName("smtp.gmail.com");
        email.setSmtpPort(465);
        email.setAuthenticator(new DefaultAuthenticator("testjavakurs", "javakurs1!"));
        email.setSSLOnConnect(true);
        email.setFrom(myEmail.getEmail(), myEmail.getName());
        email.setSubject(myEmail.getTitle());
        email.setMsg(myEmail.getMessage());
        email.addTo("testjavakurs@gmail.com");
        System.out.println("Rozpoczęto wysyłanie wiadomości email");
        email.send();
        System.out.println("Wiadomość wysłana");
    }

    public MyEmail getLastEmail() {
        Stream<MyEmail> stream = emails.stream();
        return stream.reduce((first, second) -> second).orElse(null);
    }
}
