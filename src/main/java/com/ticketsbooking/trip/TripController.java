package com.ticketsbooking.trip;

import com.ticketsbooking.userDetails.UserDetailsImpl;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.swing.text.DateFormatter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Controller
@Setter(onMethod_ = @Autowired)
public class TripController {

    private TripService tripService;

    @GetMapping({"/home","/"})
    public String getHomePage(@AuthenticationPrincipal UserDetailsImpl userImpl, Model model) {
        model.addAttribute("user", userImpl != null ? userImpl.getUser() : null);
        return "home";
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @PostMapping("/trip/add")
    public String addTrip(@RequestParam String departureDate, @RequestParam String arrivalDate,
                          @RequestParam Double price, @RequestParam Long busId, @RequestParam Long routeId) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        var departureDateParsed = LocalDate.parse(departureDate,formatter);
        var arrivalDateParsed = LocalDate.parse(arrivalDate,formatter);
        tripService.save(departureDateParsed,arrivalDateParsed,price,routeId,busId);
        return "redirect:/admin_page";
    }

}
