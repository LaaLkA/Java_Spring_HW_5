package ru.laalka.java_spring_hw_5.service;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.laalka.java_spring_hw_5.model.Task;
import ru.laalka.java_spring_hw_5.model.TaskStatus;
import ru.laalka.java_spring_hw_5.repository.TaskRepository;

import java.util.List;
import java.util.Optional;

/**
 * Сервис работы с задачами
 */
@Service
//@AllArgsConstructor
public class TaskService {

    /**
     * Поле репозитория
     */
    private TaskRepository taskRepository;


    // Затычка (не работает Lombok)
    /**
     * Конструктор с подключением репозитория
     * @param taskRepository репозиторий
     */
    @Autowired
    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }


    /**
     * Метод создание задачи
     * @param task созданная задача
     * @return созданная задача
     */
    public Task createTask(Task task) {
        return taskRepository.save(task);
    }

    /**
     * Метод удаления задачи по идентификатору
     * @param id идентификатор
     */
    public void deleteTask(Long id) {
        Optional<Task> deleteTask = taskRepository.findById(id);
        if (deleteTask.isPresent()) {
            taskRepository.delete(deleteTask.get());
        } else {
            throw new IllegalArgumentException("Task not found");
        }
    }

    /**
     * Метод получения всех задач
     * @return лист задач
     */
    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    /**
     * Метод получения задачи по идентификатору
     * @param id идентификатор
     * @return найденная задача
     */
    public Optional<Task> getTaskById(Long id) {
        return taskRepository.findById(id);
    }

    /**
     * Метод получения задач по статусу
     * @param status статус для фильтрации
     * @return список задач
     */
    public List<Task> findTaskByStatus(TaskStatus status) {
        return taskRepository.findByStatus(status);
    }

    /**
     * Метод обновления задачи
     * @param task обновлённая задача
     * @return обновлённая задача
     */
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
