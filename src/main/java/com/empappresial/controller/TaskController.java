package com.empappresial.controller;

import com.empappresial.domain.Goal;
import com.empappresial.domain.Task;
import com.empappresial.domain.Team;
import com.empappresial.domain.TeamTask;
import com.empappresial.service.GoalService;
import com.empappresial.service.TaskService;
import com.empappresial.service.TeamService;
import com.empappresial.service.TeamTaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("manager")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @Autowired
    private GoalService goalService;

    @Autowired
    private TeamService teamService;

    @Autowired
    private TeamTaskService teamTaskService;

    @GetMapping("addTaskForm/{id}")
    public String addTaskForm(@PathVariable("id") Long id, Model model){
        Goal goal = goalService.findById(id);
        List<Team> teamList = teamService.findTeamByGoal(goal);
        model.addAttribute("goal",goal);
        model.addAttribute("goals",teamList);
        return "manager/add_task";
    }

    @PostMapping("/addTask")
    public String addTask(Model model, @ModelAttribute TeamTask teamTask,@ModelAttribute Task task){
       // Goal goal = goalService.findById(id);

       // task.setGoal(goal);
        task.setDateCreated(new Date());
        taskService.save(task);

        teamTask.setDateAssigned(new Date());
        teamTask.setTask(task);
        teamTaskService.save(teamTask);

        return "redirect:/goal/loadManagerGoal";
    }
}
