package com.ticketsbooking.route;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoutePointRepository extends JpaRepository<RoutePoint, Long> {

    RoutePoint getById(Long id);

    boolean existsByName(String name);
}
