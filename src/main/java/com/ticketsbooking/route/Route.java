package com.ticketsbooking.route;

import com.ticketsbooking.DomainEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;

@Getter
@Setter
@Entity
public class Route extends DomainEntity {

    @OneToOne
    private RoutePoint departurePoint;

    @OneToOne
    private RoutePoint arrivalPoint;
}
