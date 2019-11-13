package com.empappresial.controller;

import com.empappresial.domain.Goal;
import com.empappresial.domain.Role;
import com.empappresial.domain.Team;
import com.empappresial.domain.User;
import com.empappresial.service.GoalService;
import com.empappresial.service.RoleService;
import com.empappresial.service.TeamService;
import com.empappresial.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("admin")
public class TeamController {

    private final TeamService teamService;
    private final GoalService goalService;
    private final UserService userService;
    private final RoleService roleService;

    public TeamController(TeamService teamService, GoalService goalService, UserService userService, RoleService roleService) {
        this.teamService = teamService;
        this.goalService = goalService;
        this.userService = userService;
        this.roleService = roleService;
    }

    @GetMapping("/employeeList/{id}")
    public String loadTeam(@PathVariable("id") Long id, Model model){
        Role role = roleService.findById(3L);
        List<User> users = userService.getUserByRole(role);

       // List<User> users = userService.findAll();
        Goal goal = goalService.findById(id);

        model.addAttribute("users",users);
        model.addAttribute("goal",goal);
        return "admin/assignTeam";
    }

    @PostMapping("/saveTeam")
    public String saveTeam(@ModelAttribute Team team, @RequestParam("goal") Long id){
        Goal goal = goalService.findById(id);
        //g.setTitle(goal);
        team.setGoal(goal);
        team.setDate(new Date());
        teamService.save(team);
        return "redirect:/listGoal";
    }

    @GetMapping("/teamList/{id}")
    public String teamList(@PathVariable("id") Long id,Model model){
        Goal goal = goalService.findById(id);
        List<Team> teamList = teamService.findTeamByGoal(goal);
        model.addAttribute("team",teamList);
        System.out.println("team:"+teamList);
        return "admin/teamList";
    }


}
