package com.foodparadise;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller()
public class DashboardController {

    @PostMapping("/auth")
    public String authenticate(@RequestParam(defaultValue = "signin") String type,
                               @RequestParam(defaultValue = "") String destination,
                               AuthForm form,
                               Model model) {
        model.addAttribute("username", form.getEmail());
        //check password
        if (!form.getPassword().matches("\\w+[0-9]*")) {
            model.addAttribute("authMessage", "wrong password");
            if (type.equals("signin")) return "redirect:/signin";
            else return "redirect:/signup";
        }
        return "redirect:/" + destination;
    }

    @GetMapping("/dashboard")
    public String overviewDashboard(@RequestParam(name = "name", required = false, defaultValue = "World") String name,
                                    Model model) {
        model.addAttribute("name", name);
        return "dashboard";
    }

    @GetMapping("/explore")
    public String explore(@RequestParam(name = "name", required = false, defaultValue = "World") String name,
                                    Model model) {
        model.addAttribute("name", name);
        return "dashboard";
    }

    @GetMapping("/dashboard/settings")
    public String dashboardSettings() {
        return "settings";
    }
}
