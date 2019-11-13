package com.empappresial.service;

import com.empappresial.domain.Task;
import com.empappresial.repo.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TaskServiceImpl implements TaskService {

    @Autowired
    private TaskRepository taskRepository;

    @Override
    public List<Task> findAll() {
        List<Task> tasks = new ArrayList<>();
        taskRepository.findAll().forEach(tasks::add);
        return tasks;
    }

    @Override
    public Task save(Task object) {
        return taskRepository.save(object);
    }

    @Override
    public Task findById(Long aLong) {
        return taskRepository.findById(aLong).orElse(null);
    }

    @Override
    public void delete(Task object) {
        taskRepository.delete(object);
    }

    @Override
    public void deleteById(Long aLong) {
        taskRepository.deleteById(aLong);
    }
}
