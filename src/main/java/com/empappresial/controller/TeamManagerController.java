package com.empappresial.controller;


import com.empappresial.domain.Goal;
import com.empappresial.domain.Team;
import com.empappresial.service.GoalService;
import com.empappresial.service.RoleService;
import com.empappresial.service.TeamService;
import com.empappresial.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("manager")
public class TeamManagerController {

    private final TeamService teamService;
    private final GoalService goalService;
    private final UserService userService;
    private final RoleService roleService;

    public TeamManagerController(TeamService teamService, GoalService goalService, UserService userService, RoleService roleService) {
        this.teamService = teamService;
        this.goalService = goalService;
        this.userService = userService;
        this.roleService = roleService;
    }
    @GetMapping("/viewTeam/{id}")
    public String manaagerTeamList(@PathVariable("id") Long id, Model model){
        Goal goal = goalService.findById(id);
        List<Team> teamList = teamService.findTeamByGoal(goal);
        model.addAttribute("team",teamList);
        System.out.println("team:"+teamList);
        return "manager/manaagerteamList";
    }

}
