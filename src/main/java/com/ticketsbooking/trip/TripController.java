package com.ticketsbooking.trip;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TripController {

    @GetMapping("/home")
    public String getHomePage() {
        return "home";
    }
}
