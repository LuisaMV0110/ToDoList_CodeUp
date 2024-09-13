package com.mindhub.todolist.controllers;

import com.mindhub.todolist.dtos.TaskDTO;
import com.mindhub.todolist.models.Status;
import com.mindhub.todolist.models.Task;
import com.mindhub.todolist.services.TaskService;
import com.mindhub.todolist.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tasks")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @Autowired
    private UserService userService;

    @GetMapping
    public List<TaskDTO> getAll(){
        return taskService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable Long id){
        return new ResponseEntity<>(new TaskDTO(taskService.findById(id)), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> createTask(@RequestBody Task task){

        if(task.getTitle().isBlank()){
            return  ResponseEntity.badRequest().body("Missing title");
        }
        if(task.getDescription().isBlank()){
            return  ResponseEntity.badRequest().body("Missing description");
        }

        TaskDTO taskDTO = new TaskDTO(taskService.createTask(task));
        return new ResponseEntity<>( taskDTO, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateTask(@RequestBody Task task, @PathVariable Long id){
        TaskDTO taskExistingDTO = new TaskDTO(taskService.updateTask(task, id));
        return new ResponseEntity<>( taskExistingDTO, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public  ResponseEntity<?> updateTask(@PathVariable Long id){
        taskService.deleteTask(id);
        return new ResponseEntity<>( "None", HttpStatus.NO_CONTENT);
    }

}
