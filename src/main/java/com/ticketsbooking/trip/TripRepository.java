package com.ticketsbooking.trip;

import com.ticketsbooking.route.Route;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TripRepository extends JpaRepository<Trip,Long> {

}
