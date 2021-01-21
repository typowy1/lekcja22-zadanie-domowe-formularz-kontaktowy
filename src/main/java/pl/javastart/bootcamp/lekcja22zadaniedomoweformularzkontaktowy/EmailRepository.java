package pl.javastart.bootcamp.lekcja22zadaniedomoweformularzkontaktowy;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class EmailRepository {

    private List<MyEmail> emails;

    public EmailRepository() {
        emails = new ArrayList<>();
    }

    public void add(MyEmail email) {
        emails.add(email);
    }

    public MyEmail getLastEmail() {
        return emails.stream()
                .reduce((first, second) -> second)
                .orElse(null);
    }
}
