package com.rest.maximTehnology.service;

import com.rest.maximTehnology.entity.Task;
import com.rest.maximTehnology.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.Date;
import java.util.List;

@Service
public class TaskService {

    private final TaskRepository taskRepository;

    @Autowired
    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public void saveTask(Task task) {
        taskRepository.save(task);
    }

    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    public void deleteTask(int id) {
        taskRepository.deleteById(id);
    }

    public List<Task> getTasksOfRange(Date firsDate, Date lastDate, boolean status) {
        return taskRepository.findByDateBetweenAndStatus(firsDate, lastDate, status);
    }

    public List<Task> getTasksOfDay(Date date, boolean status) {
        return taskRepository.findByDateAndStatus(date, status);
    }
}
