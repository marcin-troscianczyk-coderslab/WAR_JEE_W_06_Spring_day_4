package pl.coderslab.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(path = "/first")
public class ParamController {

    
    @GetMapping(path = "/form")
    public String showForm() {
        return "/views/paramForm.jsp";
    }
    
    @PostMapping(path = "/form", produces = "text/html; charset=UTF-8")
    @ResponseBody
    public String showParam(final @RequestParam(name = "paramName") String param) {
        return "Wartość parametru: " + param;
    }
}
