package ru.laalka.java_spring_hw_5.controller;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ru.laalka.java_spring_hw_5.model.Task;
import ru.laalka.java_spring_hw_5.service.TaskService;

import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    private TaskService service;

    @Autowired
    public TaskController(TaskService service) {
        this.service = service;
    }

    @GetMapping()
    public List<Task> tasks() {
        return service.getAllTasks();
    }

    @PostMapping("/create")
    public Task createTask(@RequestBody Task task) {
        return service.createTask(task);
    }
}
