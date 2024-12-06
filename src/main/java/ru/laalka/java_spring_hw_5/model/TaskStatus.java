package ru.laalka.java_spring_hw_5.model;

import lombok.ToString;

/**
 * Статусы задач
 */
@ToString
public enum TaskStatus {
    NOT_STARTED, IN_PROGRESS, COMPLETED;
}
