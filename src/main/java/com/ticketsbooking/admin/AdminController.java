package com.ticketsbooking.admin;

import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@Setter(onMethod_ = @Autowired)
public class AdminController {

    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping("/admin_page")
    public String getAdminPage(){
        return "adminPage";
    }
}
