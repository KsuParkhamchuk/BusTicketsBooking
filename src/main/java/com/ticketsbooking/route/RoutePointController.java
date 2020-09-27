package com.ticketsbooking.route;

import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@Setter(onMethod_ = @Autowired)
public class RoutePointController {

    private RoutePointService routePointService;

    @PreAuthorize("hasAuthority('ADMIN')")
    @PostMapping("/route_point/add")
    public void addRoutePoint(@RequestParam String name) {
        try {
            routePointService.save(name);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
