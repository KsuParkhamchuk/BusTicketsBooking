package com.ticketsbooking.user;

import com.ticketsbooking.DomainEntity;
import com.ticketsbooking.security.Authority;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@Entity
public class User extends DomainEntity {

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "users_authorities",
            joinColumns =
            @JoinColumn(name = "user_id", referencedColumnName = "id"),
            inverseJoinColumns =
            @JoinColumn(name = "authority_id", referencedColumnName = "id"))
    private Set<Authority> authorities;

}
