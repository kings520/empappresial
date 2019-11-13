package com.empappresial.controller;

import com.empappresial.domain.Goal;
import com.empappresial.domain.User;
import com.empappresial.service.GoalService;
import com.empappresial.service.RoleService;
import com.empappresial.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;

@Controller
@RequestMapping("/manager")
public class ManagerGoalController {

    private final GoalService goalService;
    private final RoleService roleService;
    private final UserService userService;

    public ManagerGoalController(GoalService goalService, RoleService roleService, UserService userService) {
        this.goalService = goalService;
        this.roleService = roleService;
        this.userService = userService;
    }

    @GetMapping("/loadManagerGoal")
    public String loadManagerGoal(Principal principal, Model model){
        User user = userService.findByEmail(principal.getName());
        Goal goals = goalService.findGoalByUser(user);
        model.addAttribute("goals",goals);
        return "manager/list_goal";
    }
}
