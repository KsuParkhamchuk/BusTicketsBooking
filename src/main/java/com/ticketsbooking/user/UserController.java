package com.ticketsbooking.user;

import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@Setter(onMethod_ = @Autowired)
public class UserController {

    @GetMapping("/user_page")
    public String getUserPage() {
        return "userPage";
    }

}
