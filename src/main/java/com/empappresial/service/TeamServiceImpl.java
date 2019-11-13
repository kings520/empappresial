package com.empappresial.service;

import com.empappresial.domain.Goal;
import com.empappresial.domain.Team;
import com.empappresial.repo.TeamRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TeamServiceImpl implements TeamService {

    private final TeamRepository teamRepository;

    public TeamServiceImpl(TeamRepository teamRepository) {
        this.teamRepository = teamRepository;
    }

    @Override
    public List<Team> findAll() {
        List<Team> teamList = new ArrayList<>();
        teamRepository.findAll().forEach(teamList::add);
        return teamList;
    }

    @Override
    public Team save(Team object) {
        return teamRepository.save(object);
    }

    @Override
    public Team findById(Long aLong) {
        return teamRepository.findById(aLong).orElse(null);
    }

    @Override
    public void delete(Team object) {
        teamRepository.delete(object);
    }

    @Override
    public void deleteById(Long aLong) {
        teamRepository.deleteById(aLong);
    }

    @Override
    public List<Team> findTeamByGoal(Goal goal) {
        return teamRepository.findTeamByGoal(goal);
    }
}
