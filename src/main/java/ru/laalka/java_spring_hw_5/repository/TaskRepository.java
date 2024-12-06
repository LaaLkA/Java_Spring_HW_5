package ru.laalka.java_spring_hw_5.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.laalka.java_spring_hw_5.model.Task;
import ru.laalka.java_spring_hw_5.model.TaskStatus;

import java.util.List;

/**
 * Интерфейс репозитория задач
 */
@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {

    /**
     * Метод получения всех задач по статусу
     * @param status статус задачи
     * @return список подходящих задач
     */
    @Query("SELECT t FROM Task t WHERE t.status = :status")
    List<Task> findByStatus(@Param("status") TaskStatus status);

}
