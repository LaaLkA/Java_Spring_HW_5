package ru.laalka.java_spring_hw_5.controller;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ru.laalka.java_spring_hw_5.model.Task;
import ru.laalka.java_spring_hw_5.service.TaskService;

import java.util.List;
/**
 * Рест контроллер
 */
//@AllArgsConstructor
@RestController
@RequestMapping("/tasks")
public class TaskController {

    /**
     * Поле сервиса
     */
    private TaskService service;


    // Затычка (не работает Lombok)
    /**
     * Конструктор контроллера с подключением сервиса
     * @param service сервис
     */
    @Autowired
    public TaskController(TaskService service) {
        this.service = service;
    }


    /**
     * Метод стартовой страницы
     * @return список задач
     */
    @GetMapping()
    public List<Task> tasks() {
        return service.getAllTasks();
    }

    /**
     * Метод создание задачи
     * @param task задача из тела для сохранения в БД
     * @return сохранённую задачу
     */
    @PostMapping("/create")
    public Task createTask(@RequestBody Task task) {
        return service.createTask(task);
    }
}
