package com.ticketsbooking.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {

    User getByPhoneNumber(String phoneNumber);
    boolean existsByPhoneNumber(String phoneNumber);
}
