package com.ticketsbooking.route;

import com.ticketsbooking.DomainEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;

@Getter
@Setter
@Entity
public class RoutePoint extends DomainEntity {

    @Column(name = "point_name")
    private String name;
}
