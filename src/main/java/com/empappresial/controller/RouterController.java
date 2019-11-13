package com.empappresial.controller;

import com.empappresial.domain.User;
import com.empappresial.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;

@Controller
@RequestMapping("router")
public class RouterController {

    @Autowired
    private UserService userService;

    @PreAuthorize("hasAnyRole({'Admin','Employee','Manager'})" )
    @GetMapping("/profile")
    public String loadProfile(Principal principal, Model model){
        User user = userService.findByEmail(principal.getName());
        model.addAttribute("emp",user);
        return "common/profile";
    }
}
