package pl.coderslab.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import java.time.LocalDateTime;

@Controller
public class HelloController {

    @GetMapping(path = "/hello", produces = "text/html; charset=UTF-8")
    @ResponseBody
    public String helloWorld() {
        return "Hello World";
    }

    @GetMapping(path = "/hello/{firstName:[a-zA-Z]+}/{lastName:[a-zA-Z]+}")
    @ResponseBody
    public String helloUser(final @PathVariable(name = "firstName") String firstName,
                            final @PathVariable(name = "lastName") String lastName) {

        return "Witaj " + firstName + " " + lastName;
    }

    @GetMapping(path = "/helloView")
    public String helloView(Model model) {

        final LocalDateTime date = LocalDateTime.now();

        final int hour = date.getHour();

        if (hour > 8 && hour < 20) {
            // dzien
            model.addAttribute("color", "black");
            model.addAttribute("backgroundcolor", "white");
        } else {
            // noc
            model.addAttribute("color", "white");
            model.addAttribute("backgroundcolor", "black");
        }

        return "home";
    }
}
