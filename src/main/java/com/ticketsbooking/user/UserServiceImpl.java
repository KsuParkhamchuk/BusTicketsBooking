package com.ticketsbooking.user;

import com.ticketsbooking.user.User;
import com.ticketsbooking.user.UserRepository;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Transactional
@Service
@Setter(onMethod_ = @Autowired)
public class UserServiceImpl{

    private UserRepository userRepository;
    private PasswordEncoder passwordEncoder;

    @Transactional
    public void saveUser(String phoneNumber, String password, String firstName, String middleName, String lastName,
                         String passportNumber, String passportSerial) throws Exception {
        if (!userRepository.existsByPhoneNumber(phoneNumber)){
            User user = new User();
            user.setPhoneNumber(phoneNumber);
            user.setPassword(passwordEncoder.encode(password));
            user.setFirstName(firstName);
            user.setLastName(lastName);
            user.setMiddleName(middleName);
            user.setPassportNumber(passportNumber);
            user.setPassportSerial(passportSerial);
            userRepository.save(user);
        } else {
            throw new Exception("user exists");
        }

    }

}
