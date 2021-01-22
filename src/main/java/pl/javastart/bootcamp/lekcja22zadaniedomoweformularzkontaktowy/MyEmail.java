package pl.javastart.bootcamp.lekcja22zadaniedomoweformularzkontaktowy;

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

    public void setName(String name) {
        this.name = name;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
