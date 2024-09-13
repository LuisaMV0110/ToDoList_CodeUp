package com.mindhub.todolist.services.implement;

import com.mindhub.todolist.dtos.TaskDTO;
import com.mindhub.todolist.handlers.UserNotFound;
import com.mindhub.todolist.models.Task;
import com.mindhub.todolist.models.UserEntity;
import com.mindhub.todolist.repositories.TaskRepository;
import com.mindhub.todolist.repositories.UserRepository;
import com.mindhub.todolist.services.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TaskServicesImplement implements TaskService {

    @Autowired
    private TaskRepository taskRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public Task findById(Long id) {
        return taskRepository.findById(id).orElseThrow( () -> new UserNotFound("The task with the ID: " + id + " was not found"));
    }

    @Override
    public Task createTask(Task task) {
        UserEntity user = userRepository.findById(task.getUser().getId()).orElseThrow( () -> new UserNotFound("The task with the ID: " + task.getUser().getId() + " was not found"));

        Task taskN = new Task(
                task.getTitle(),
                task.getDescription(),
                task.getStatus(),
                user
        );

        return  taskRepository.save(taskN);
    }

    @Override
    public Task updateTask(Task task, Long id) {
        Task existingTask = taskRepository.findById(id).orElseThrow(() -> new UserNotFound("The task with the ID: " + id + " was not found"));

        existingTask.setTitle(task.getTitle());
        existingTask.setDescription(task.getDescription());
        existingTask.setStatus(task.getStatus());


        return taskRepository.save(existingTask);

    }

    @Override
    public void deleteTask(Long id) {
        taskRepository.deleteById(id);
    }

    @Override
    public List<TaskDTO> findAll() {
        return taskRepository.findAll().stream().map(TaskDTO::new).collect(Collectors.toList());
    }
}
