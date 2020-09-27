package com.ticketsbooking.bus;

import com.ticketsbooking.DomainEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
@Getter
@Setter
public class Bus extends DomainEntity {

    @Column(name = "place_amount")
    private Integer placeAmount;
}
