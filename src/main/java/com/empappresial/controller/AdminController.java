package com.empappresial.controller;


import com.empappresial.domain.User;
import com.empappresial.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;


/**
 * Created by User-pc on 8/16/2017.
 */
@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private UserService userService;

    //@PreAuthorize("hasAnyRole('Role_Admin')" )
    @RequestMapping({"","/","/index","dashboard","index.html"})
    public String index(Principal principal, Model model){
        User user = userService.findByEmail(principal.getName());
        model.addAttribute("emp",user);
        return "admin/index";
    }

}