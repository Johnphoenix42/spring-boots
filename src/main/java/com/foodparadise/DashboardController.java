package com.foodparadise;

import com.foodparadise.domain.Customer;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller()
public class DashboardController {

    private final CustomerRepository customerRepository;

    public DashboardController(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @PostMapping("/auth")
    public String authenticate(@RequestParam(defaultValue = "signin") String type,
                               @RequestParam(defaultValue = "") String destination,
                               @RequestParam(defaultValue = "https://localhost:8080/") String source,
                               AuthForm form,
                               RedirectAttributes redirectAttributes) {
        List<Customer> matchingCustomersByEmail = customerRepository.findByEmail(form.getEmail());
        for (Customer customer : matchingCustomersByEmail) {
            if (customer.getPassword().equals(form.getPassword())) {
                redirectAttributes.addAttribute("name", customer.getFirstName() + " " + customer.getLastName());
                return "redirect:/" + destination;
            }
        }
        //if (!form.getPassword().matches("\\w+[0-9]*")) {
        redirectAttributes.addFlashAttribute("authMessage", "wrong password");
        redirectAttributes.addAttribute("destination", destination);
        redirectAttributes.addAttribute("source", source);
        if (type.equals("signin")) return "redirect:/signin";
        else return "redirect:/signup";
    }

    @GetMapping("/dashboard")
    public String overviewDashboard(@RequestParam(name = "name", required = false, defaultValue = "World") String name,
                                    Model model) {
        //model.addAttribute("name", name);
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
