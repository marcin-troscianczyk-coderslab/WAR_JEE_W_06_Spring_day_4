package pl.coderslab.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MultiplyController {

    @GetMapping(path = "/multiply")
    public String multiply(Model model, @RequestParam(name = "size", defaultValue = "10") int size) {
        model.addAttribute("size", size);
        return "multiply";
    }
}
