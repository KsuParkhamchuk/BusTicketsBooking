package com.ticketsbooking.security;

import com.ticketsbooking.user.User;
import com.ticketsbooking.user.UserServiceImpl;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@Setter(onMethod_ = @Autowired)
public class AuthorizationController {

    private UserServiceImpl userService;

    @GetMapping("/registration")
    public String getRegistrationPage() {
        return "registration";
    }

    @PostMapping("/registration")
    public String registration(@RequestParam String phoneNumber,@RequestParam String password, @RequestParam String confirmPassword,
                             @RequestParam String firstName,@RequestParam String middleName,
                             @RequestParam String lastName,@RequestParam String passportSerial,
                             @RequestParam String passportNumber, Model model) {
        if (!password.equals(confirmPassword)) {
            model.addAttribute("passwordMatch", false);
            return "registration";
        }

        try {
            userService.saveUser(phoneNumber,password,firstName,middleName,lastName,passportNumber,passportSerial);
            return "login";
        } catch (Exception e) {
            model.addAttribute("userExist",true);
            return "registration";
        }
    }
}
