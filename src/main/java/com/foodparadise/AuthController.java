package com.foodparadise;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AuthController {

    @GetMapping("/signin")
    public String signin(@RequestParam(name = "to") String to,
                         @RequestParam(name = "source", required = false) String source,
                         Model model) {
        model.addAttribute("destination", to);
        System.out.println(model);
        return "signin";
    }

    @GetMapping("/signup")
    public String signup(@RequestParam(name = "to", required = false) String to,
                         @RequestParam(name = "source", required = false) String source,
                         Model model) {
        model.addAttribute(to);
        return "signup";
    }


}
