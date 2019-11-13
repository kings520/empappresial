package com.empappresial.controller;


import com.empappresial.domain.User;
import com.empappresial.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;

@Controller
@RequestMapping("/manager")
public class ManagerController {

    @Autowired
    private UserService userService;

    @RequestMapping({"","/","/index","/index.html","dashboard"})
    public String index(Principal principal, Model model){
        User user = userService.findByEmail(principal.getName());
        model.addAttribute("emp",user);
        return "manager/index";
    }
}
