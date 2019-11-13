package com.empappresial.service;

import com.empappresial.domain.Goal;
import com.empappresial.domain.User;

public interface GoalService extends CrudService<Goal,Long> {
   Goal findGoalByUser(User user);
}
