package com.ticketsbooking.security;

import com.ticketsbooking.user.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AuthorizationController {

    @GetMapping("/registration")
    public String getRegistrationPage() {
        return "registration";
    }

    @PostMapping("/registration")
    public void registration(@RequestParam String phoneNumber,@RequestParam String password,
                             @RequestParam String firstName,@RequestParam String middleName,
                             @RequestParam String lastName, Model model) {
        System.out.println(phoneNumber);
    }
}
