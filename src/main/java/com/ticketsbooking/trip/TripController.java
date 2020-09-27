package com.ticketsbooking.trip;

import com.ticketsbooking.user.User;
import com.ticketsbooking.userDetails.UserDetailsImpl;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TripController {

    @GetMapping({"/home","/"})
    public String getHomePage(@AuthenticationPrincipal UserDetailsImpl userImpl, Model model) {
        model.addAttribute("user", userImpl != null ? userImpl.getUser() : null);
        return "home";
    }
}
