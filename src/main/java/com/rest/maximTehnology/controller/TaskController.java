package com.rest.maximTehnology.controller;

import com.rest.maximTehnology.entity.Task;
import com.rest.maximTehnology.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/tasks")
public class TaskController {
    private final TaskService taskService;

    @Autowired
    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping
    public List<Task> getTaskOfRange(@RequestParam(name = "date") String dateAsStr, @RequestParam(name = "status") String status) {
        List<Task> allTasks;
        boolean isDone = Boolean.parseBoolean(status);
        boolean delimiter = dateAsStr.contains("-");
        if (delimiter) {
            allTasks = getTasksOfRange(dateAsStr, isDone);
        } else {
            allTasks = getTasksOfDay(dateAsStr, isDone);
        }
        return allTasks;
    }

    @PostMapping
    public void creatTask(@RequestBody Task task) {
        taskService.saveTask(task);
    }

    @PutMapping
    public Task changeTask(@RequestBody Task task) {
        taskService.saveTask(task);
        return task;
    }

    @DeleteMapping("/{id}")
    public String deleteTask(@PathVariable(name = "id") int id) {
        taskService.deleteTask(id);
        return "Task with id " + id + " was deleted";
    }

    private List<Task> getTasksOfDay(String dateAsStr, boolean isDone) {
        List<Task> allTasks;
        try {
            Date date = new SimpleDateFormat("yyyy.MM.dd").parse(dateAsStr);
            allTasks = taskService.getTasksOfDay(date, isDone);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        return allTasks;
    }

    private List<Task> getTasksOfRange(String dateAsStr, boolean isDone) {
        List<Task> allTasks;
        String[] twoDate = dateAsStr.split("-");
        try {
            Date firstDate = new SimpleDateFormat("yyyy.MM.dd").parse(twoDate[0]);
            Date lastDate = new SimpleDateFormat("yyyy.MM.dd").parse(twoDate[1]);
            allTasks = taskService.getTasksOfRange(firstDate, lastDate, isDone);
        } catch (ParseException e) {
            throw new RuntimeException(e);

        }
        return allTasks;
    }

}
