package com.empappresial.service;

import com.empappresial.domain.Goal;
import com.empappresial.domain.Team;

import java.util.List;

public interface TeamService extends CrudService<Team,Long> {
    List<Team> findTeamByGoal(Goal goal);
}
