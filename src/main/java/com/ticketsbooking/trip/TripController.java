package com.ticketsbooking.trip;

import com.ticketsbooking.user.User;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TripController {

    @GetMapping("/home")
    public String getHomePage(@AuthenticationPrincipal User user, Model model) {
        model.addAttribute("user", user);
        return "home";
    }
}
