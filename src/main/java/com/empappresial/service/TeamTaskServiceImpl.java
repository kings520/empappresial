package com.empappresial.service;

import com.empappresial.domain.TeamTask;
import com.empappresial.repo.TeamTaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TeamTaskServiceImpl implements TeamTaskService {

    @Autowired
    private TeamTaskRepository teamTaskRepository;

    @Override
    public List<TeamTask> findAll() {
        List<TeamTask> teamTasks = new ArrayList<>();
        teamTaskRepository.findAll().forEach(teamTasks::add);
        return teamTasks;
    }

    @Override
    public TeamTask save(TeamTask object) {
        return teamTaskRepository.save(object);
    }

    @Override
    public TeamTask findById(Long aLong) {
        return teamTaskRepository.findById(aLong).orElse(null);
    }

    @Override
    public void delete(TeamTask object) {
        teamTaskRepository.delete(object);
    }

    @Override
    public void deleteById(Long aLong) {
        teamTaskRepository.deleteById(aLong);
    }
}
