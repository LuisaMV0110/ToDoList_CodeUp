package com.mindhub.todolist.controllers;

import com.mindhub.todolist.dtos.CreateUser;
import com.mindhub.todolist.dtos.UserDTO;
import com.mindhub.todolist.models.UserEntity;
import com.mindhub.todolist.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/all")
    public List<UserDTO> getAll(){
        return userService.findAll();
    }

    @GetMapping("/{id}")
    public UserEntity getById(@PathVariable Long id){
        return userService.findById(id);
    }

    @GetMapping("/email")
    public UserEntity getByEmail(@RequestParam String email){

        return userService.findByEmail(email);
    }

    @PostMapping("/new")
    public ResponseEntity<?> createUser(@RequestBody CreateUser createUser){

        if(createUser.Email().isBlank()){
            return  ResponseEntity.badRequest().body("Missing email");
        }
        if(userService.findByEmail(createUser.Email()) != null){
            return  ResponseEntity.badRequest().body("Email is already in use");
        }
        if(createUser.username().isBlank()){
            return  ResponseEntity.badRequest().body("Missing username");
        }
        if(createUser.password().isBlank()){
            return  ResponseEntity.badRequest().body("Missing password");
        }

        UserEntity user = new UserEntity(createUser.username(), createUser.Email(), createUser.password());
        userService.saveUser(user);
        return new ResponseEntity<>("User created ", HttpStatus.CREATED);
    }

}
