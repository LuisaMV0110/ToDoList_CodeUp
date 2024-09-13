package com.mindhub.todolist.services;

import com.mindhub.todolist.dtos.TaskDTO;
import com.mindhub.todolist.models.Task;

public interface TaskService extends GenericService<Task, TaskDTO>{

    Task findById(Long id);

    Task createTask(Task task);

    Task updateTask(Task task, Long id);

    void deleteTask(Long id);


}
