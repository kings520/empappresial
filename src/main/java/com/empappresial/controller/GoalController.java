package com.empappresial.controller;

import com.empappresial.domain.Goal;
import com.empappresial.domain.Role;
import com.empappresial.domain.User;
import com.empappresial.service.GoalService;
import com.empappresial.service.RoleService;
import com.empappresial.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/admin")
public class GoalController {

    private final GoalService goalService;
    private final RoleService roleService;
    private final UserService userService;

    public GoalController(GoalService goalService, RoleService roleService, UserService userService) {
        this.goalService = goalService;
        this.roleService = roleService;
        this.userService = userService;
    }

    //@PreAuthorize("hasAnyRole('Admin')" )
    @GetMapping("/listGoal")
    public String loadGoals(ModelMap modelMap){
        List<Goal> goals = goalService.findAll();
        modelMap.addAttribute("goals",goals);
        return "admin/listGoal";
    }

   // @PreAuthorize("hasAnyRole('Admin')" )
    @GetMapping("/goalForm")
    public String loadGoalsForm(Model modelMap){
        Role role = roleService.findById(2L);
        List<User> users = userService.getUserByRole(role);
        modelMap.addAttribute("users",users);
        return "admin/addGoal";
    }

   // @PreAuthorize("hasAnyRole('Admin')" )
    @PostMapping("/addGoal")
    public String addGoal(@RequestParam("title") String title,
                          @RequestParam("description") String description,
                          @RequestParam("dueDate") Date dueDate,
                          @RequestParam("status") String status,
                          @RequestParam("startDate") Date startDate,
                          @RequestParam("teamLead") User teamLead){

        Goal task = new Goal();
        task.setTitle(title);
        task.setDescription(description);
        task.setStartDate(startDate);
        task.setEndDate(dueDate);
        task.setStatus(status);
        task.setDateCreated(new Date());
        task.setUser(teamLead);

       goalService.save(task);

        return "redirect:/admin/listGoal";
    }

    //@PreAuthorize("hasAnyRole('Manager')" )

}
