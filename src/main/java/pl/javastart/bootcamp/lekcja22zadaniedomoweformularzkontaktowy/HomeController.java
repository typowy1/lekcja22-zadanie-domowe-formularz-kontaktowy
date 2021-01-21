package pl.javastart.bootcamp.lekcja22zadaniedomoweformularzkontaktowy;

import org.apache.commons.mail.EmailException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class HomeController {

    private MailSender mailSender;

    public HomeController(MailSender mailSender) {
        this.mailSender = mailSender;
    }

    @GetMapping("/")
    public String home() {
        return "home";
    }

    @GetMapping("/regulamin")
    public String regulations() {
        return "regulations";
    }

    @GetMapping("/kontakt")
    public String contact(Model model) {
        model.addAttribute("myEmail", new MyEmail());
        return "contact";
    }

    @PostMapping("/kontakt")
    public String sendingEmail(MyEmail myEmail) throws EmailException {
        mailSender.sendEmail(myEmail);
        return "redirect:/wyslano";
    }

    @GetMapping("/wyslano")
    public String sending() {
        return "wyslano";
    }
}
