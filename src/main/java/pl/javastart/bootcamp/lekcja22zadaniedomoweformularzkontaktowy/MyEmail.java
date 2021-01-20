package pl.javastart.bootcamp.lekcja22zadaniedomoweformularzkontaktowy;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;

public class MyEmail {

    private String name;
    private String title;
    private String email;
    private String message;

    public MyEmail() {
    }

    public MyEmail(String name, String title, String email, String decription) {
        this.name = name;
        this.title = title;
        this.email = email;
        this.message = decription;
    }

    public String getName() {
        return name;
    }

    public String getTitle() {
        return title;
    }

    public String getEmail() {
        return email;
    }

    public String getMessage() {
        return message;
    }
}
