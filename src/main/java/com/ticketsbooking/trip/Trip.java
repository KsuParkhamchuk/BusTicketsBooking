package com.ticketsbooking.trip;

import com.ticketsbooking.DomainEntity;
import com.ticketsbooking.bus.Bus;
import com.ticketsbooking.route.Route;
import com.ticketsbooking.user.User;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Setter
@Getter
public class Trip extends DomainEntity {

    @Column(name = "departure_date")
    private LocalDateTime departureDate;

    @Column(name = "arrival_date")
    private LocalDateTime arrivalDate;

    @OneToMany
    @Column(name = "passengers")
    private List<User> passangers;

    @Column(name = "price")
    private Double price;

    @OneToOne
    private Route route;

    @OneToOne
    private Bus bus;
}
