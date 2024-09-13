package com.mindhub.todolist.services;

import com.mindhub.todolist.dtos.UserDTO;
import com.mindhub.todolist.models.UserEntity;

public interface UserService extends GenericService<UserEntity, UserDTO>{
    UserEntity findByEmail(String email);

    UserEntity findById(Long id);

    void saveUser(UserEntity userEntity);
}
