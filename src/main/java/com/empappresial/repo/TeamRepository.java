package com.empappresial.repo;

import com.empappresial.domain.Goal;
import com.empappresial.domain.Team;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TeamRepository extends CrudRepository<Team,Long> {
    List<Team> findTeamByGoal(Goal goal);
}
