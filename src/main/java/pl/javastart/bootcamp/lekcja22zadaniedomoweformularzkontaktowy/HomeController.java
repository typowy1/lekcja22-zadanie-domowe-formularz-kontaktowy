package pl.javastart.bootcamp.lekcja22zadaniedomoweformularzkontaktowy;

import org.apache.commons.mail.EmailException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class HomeController {

    private EmailRepository emailRepository;

    public HomeController(EmailRepository emailRepository) {
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
        emailRepository.sendEmail(lastEmail);
        return "redirect:/wyslano";
    }

    @GetMapping("/wyslano")
    public String sending() {
        return "wyslano";
    }

}
