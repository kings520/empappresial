package com.empappresial.repo;

import com.empappresial.domain.Goal;
import com.empappresial.domain.User;
import org.springframework.data.repository.CrudRepository;

public interface GoalRepository extends CrudRepository<Goal,Long> {
    Goal findGoalByUser(User user);
}
