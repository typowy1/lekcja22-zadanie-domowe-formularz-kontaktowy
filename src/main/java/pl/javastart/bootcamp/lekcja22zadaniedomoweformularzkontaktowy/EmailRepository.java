package pl.javastart.bootcamp.lekcja22zadaniedomoweformularzkontaktowy;

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

    public MyEmail getLastEmail() {
        Stream<MyEmail> stream = emails.stream();
        return stream.reduce((first, second) -> second).orElse(null);
    }
}
