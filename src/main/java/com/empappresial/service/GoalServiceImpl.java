package com.empappresial.service;

import com.empappresial.domain.Goal;
import com.empappresial.domain.User;
import com.empappresial.repo.GoalRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GoalServiceImpl implements GoalService {

    private final GoalRepository goalRepository;

    public GoalServiceImpl(GoalRepository goalRepository) {
        this.goalRepository = goalRepository;
    }

    @Override
    public List<Goal> findAll() {
        List<Goal> goals = new ArrayList<>();
        goalRepository.findAll().forEach(goals::add);
        return goals;
    }

    @Override
    public Goal save(Goal object) {
        return goalRepository.save(object);
    }

    @Override
    public Goal findById(Long aLong) {
        return goalRepository.findById(aLong).orElse(null);
    }

    @Override
    public void delete(Goal object) {
        goalRepository.delete(object);
    }

    @Override
    public void deleteById(Long aLong) {
        goalRepository.deleteById(aLong);
    }

    @Override
    public Goal findGoalByUser(User user) {
        return goalRepository.findGoalByUser(user);
    }
}
