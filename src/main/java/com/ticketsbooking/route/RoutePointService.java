package com.ticketsbooking.route;

import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Setter(onMethod_ = @Autowired)
public class RoutePointService {

    private RoutePointRepository routePointRepository;

    @Transactional
    public void save(String name) throws Exception {
        if (routePointRepository.existsByName(name)) {
            throw new Exception("exists with this name");
        }
        var routePoint = new RoutePoint();
        routePoint.setName(name);
        routePointRepository.save(routePoint);
    }
}
