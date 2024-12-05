package ru.laalka.java_spring_hw_5.service;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.laalka.java_spring_hw_5.model.Task;
import ru.laalka.java_spring_hw_5.model.TaskStatus;
import ru.laalka.java_spring_hw_5.repository.TaskRepository;

import java.util.List;
import java.util.Optional;

@Service
public class TaskService {

    private TaskRepository taskRepository;

    @Autowired
    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public Task createTask(Task task) {
        return taskRepository.save(task);
    }

    public void deleteTask(Task task) {
        Optional<Task> deleteTask = taskRepository.findById(task.getId());
        if (deleteTask.isPresent()) {
            taskRepository.delete(deleteTask.get());
        } else {
            throw new IllegalArgumentException("Task not found");
        }
    }

    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    public Optional<Task> getTaskById(Long id) {
        return taskRepository.findById(id);
    }

    public List<Task> findTaskByStatus(TaskStatus status) {
        return taskRepository.findByStatus(status);
    }

    public Task updateTask(Task task) {
        Optional<Task> updateTask = taskRepository.findById(task.getId());
        if (updateTask.isPresent()) {
            Task taskToUpdate = updateTask.get();
            taskToUpdate.setTitle(task.getTitle());
            taskToUpdate.setDescription(task.getDescription());
            taskToUpdate.setStatus(task.getStatus());
        } else {
            throw new IllegalArgumentException("Task not found");
        }
        return taskRepository.save(task);
    }
}
