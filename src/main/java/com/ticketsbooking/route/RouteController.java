package com.ticketsbooking.route;

import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@Setter(onMethod_ = @Autowired)
public class RouteController {

    private RouteService routeService;

    @PreAuthorize("hasAuthority('ADMIN')")
    @PostMapping("/route/add")
    public void addRoute(@RequestParam Long arrivalPointId, @RequestParam Long departurePointId){
        routeService.save(departurePointId,arrivalPointId);
    }
}
