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
@Table(name = "users")
public class User extends DomainEntity {

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "password")
    private String password;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "middle_name")
    private String middleName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "passport_serial")
    private String passportSerial;

    @Column(name = "passport_number")
    private String passportNumber;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "users_authorities",
            joinColumns =
            @JoinColumn(name = "user_id", referencedColumnName = "id"),
            inverseJoinColumns =
            @JoinColumn(name = "authority_id", referencedColumnName = "id"))
    private Set<Authority> authorities;

    public boolean isAdmin(){
        for (Authority authority: this.getAuthorities()
             ) {
            if (authority.getName().equals("ADMIN")) {
                return true;
            }
        }
        return false;
    }
}
