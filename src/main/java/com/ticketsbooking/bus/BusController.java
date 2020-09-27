package com.ticketsbooking.bus;

import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@Setter(onMethod_ = @Autowired)
public class BusController {

    private BusService busService;

    @PreAuthorize("hasAuthority('ADMIN')")
    @PostMapping("/bus/add")
    public void addBus(@RequestParam Integer placeAmount){
        busService.save(placeAmount);
    }
}
