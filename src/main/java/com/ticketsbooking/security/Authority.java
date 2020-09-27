package com.ticketsbooking.security;

import com.ticketsbooking.DomainEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class Authority extends DomainEntity {

    @Column(nullable = false, unique = true)
    private String name;
}
