package com.mindhub.todolist.services.implement;

import com.mindhub.todolist.dtos.UserDTO;
import com.mindhub.todolist.handlers.UserNotFound;
import com.mindhub.todolist.models.UserEntity;
import com.mindhub.todolist.repositories.UserRepository;
import com.mindhub.todolist.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImplement implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserEntity findByEmail(String email) {
        return userRepository.findByEmail(email);

    }
    @Override
    public UserEntity findById(Long id){
        return userRepository.findById(id).orElseThrow( () -> new UserNotFound("The user with the ID: " + id + " was not found"));

    }

    @Override
    public void saveUser(UserEntity userEntity) {
        userRepository.save(userEntity);
    }

    @Override
    public List<UserDTO> findAll() {
        return userRepository.findAll().stream().map(UserDTO::new).collect(Collectors.toList());
    }
}
