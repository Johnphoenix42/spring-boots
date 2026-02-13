package com.foodparadise;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AuthController {

    @GetMapping("/signin")
    public String signin(@RequestParam(name = "destination") String destination,
                         @RequestParam(name = "source", required = false) String source,
                         Model model) {
        model.addAttribute("destination", destination);
        model.addAttribute("source", source);
        return "signin";
    }

    @GetMapping("/signup")
    public String signup(@RequestParam(name = "destination", required = false) String destination,
                         @RequestParam(name = "source", required = false) String source,
                         Model model) {
        System.out.println(destination);
        model.addAttribute(destination);
        model.addAttribute(source);
        return "signup";
    }


}
