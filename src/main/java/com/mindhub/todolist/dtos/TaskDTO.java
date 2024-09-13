package com.mindhub.todolist.dtos;

import com.mindhub.todolist.models.Status;
import com.mindhub.todolist.models.Task;

public class TaskDTO {
    private Long id;

    private String title, description;

    private Status status;


    public TaskDTO(){}

    public TaskDTO(Task task) {
        this.id = task.getId();
        this.title = task.getTitle();
        this.description = task.getDescription();
        this.status = task.getStatus();
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public Status getStatus() {
        return status;
    }
}
