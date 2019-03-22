package pl.coderslab.controller;

import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.time.LocalDateTime;

@RestController
@SessionAttributes("loginStart")
public class SessionController {

    @GetMapping(path = "/checkSession", produces = "text/html; charset=UTF-8")
    public String checkSession(@ModelAttribute("loginStart") ModelMap model, @SessionAttribute(value = "loginStart", required = false) LocalDateTime loginStart) {
        if (loginStart != null) {
            return "Session attribue " + loginStart;
        } else {

            final LocalDateTime attr = LocalDateTime.now();
            model.addAttribute("loginStart", attr);
            //session.setAttribute("loginStart", attr);
            return "Ustawiłem atrybut " + attr;
        }
    }
}
