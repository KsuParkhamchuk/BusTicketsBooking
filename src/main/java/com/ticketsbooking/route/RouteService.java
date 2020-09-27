package com.ticketsbooking.route;

import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Setter(onMethod_ = @Autowired)
public class RouteService {

    private RouteRepository routeRepository;

    @Transactional
    public void save(RoutePoint departurePoint, RoutePoint arrivalPoint) {
        var route = new Route();
        route.setDeparturePoint(departurePoint);
        route.setArrivalPoint(arrivalPoint);
        routeRepository.save(route);
    }
}
