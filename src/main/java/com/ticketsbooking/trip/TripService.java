package com.ticketsbooking.trip;

import com.ticketsbooking.bus.BusRepository;
import com.ticketsbooking.route.RouteRepository;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Service
@Setter(onMethod_ = @Autowired)
public class TripService {

    private TripRepository tripRepository;
    private BusRepository busRepository;
    private RouteRepository routeRepository;

    @Transactional
    public void save(LocalDate departure, LocalDate arrival, Double price, Long routeId, Long busId) {
        var trip = new Trip();
        trip.setDepartureDate(departure);
        trip.setArrivalDate(arrival);
        trip.setPrice(price);
        var bus = busRepository.findById(busId).orElseThrow();
        trip.setBus(bus);
        var route = routeRepository.findById(routeId).orElseThrow();
        trip.setRoute(route);
        tripRepository.save(trip);
    }
}
