package com.ticketsbooking.route;

import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Setter(onMethod_ = @Autowired)
public class RouteService {

    private RouteRepository routeRepository;
    private RoutePointRepository routePointRepository;

    @Transactional
    public void save(Long departurePointId, Long arrivalPointId) {
        var route = new Route();
        var departurePoint = routePointRepository.getById(departurePointId);
        var arrivalPoint = routePointRepository.getById(arrivalPointId);
        route.setDeparturePoint(departurePoint);
        route.setArrivalPoint(arrivalPoint);
        routeRepository.save(route);
    }
}
