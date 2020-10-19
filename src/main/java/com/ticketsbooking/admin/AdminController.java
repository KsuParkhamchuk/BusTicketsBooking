package com.ticketsbooking.admin;

import com.ticketsbooking.bus.BusRepository;
import com.ticketsbooking.bus.BusService;
import com.ticketsbooking.route.RoutePoint;
import com.ticketsbooking.route.RoutePointRepository;
import com.ticketsbooking.route.RouteRepository;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@Setter(onMethod_ = @Autowired)
public class AdminController {

    private BusRepository busRepository;
    private RoutePointRepository routePointRepository;
    private RouteRepository routeRepository;


    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping("/admin_page")
    public String getAdminPage(Model model){
        var buses = busRepository.findAll();
        var routePoints = routePointRepository.findAll();
        var routes = routeRepository.findAll();
        model.addAttribute("buses",buses);
        model.addAttribute("routePoints",routePoints);
        model.addAttribute("routes",routes);
        return "adminPage";
    }

}
