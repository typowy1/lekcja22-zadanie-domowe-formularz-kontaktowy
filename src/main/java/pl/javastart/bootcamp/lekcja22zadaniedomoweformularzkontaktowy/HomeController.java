package pl.javastart.bootcamp.lekcja22zadaniedomoweformularzkontaktowy;

import org.apache.commons.mail.EmailException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class HomeController {

    private MailSender mailSender;
    private EmailRepository emailRepository;

    public HomeController(MailSender mailSender, EmailRepository emailRepository) {
        this.mailSender = mailSender;
        this.emailRepository = emailRepository;
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
        emailRepository.add(myEmail);
        MyEmail lastEmail = emailRepository.getLastEmail();
        mailSender.sendEmail(lastEmail);
        return "redirect:/wyslano";
    }

    @GetMapping("/wyslano")
    public String sending() {
        return "wyslano";
    }

}
