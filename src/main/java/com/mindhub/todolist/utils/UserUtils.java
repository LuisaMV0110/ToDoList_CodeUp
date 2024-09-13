package com.mindhub.todolist.utils;

import com.mindhub.todolist.models.Status;
import com.mindhub.todolist.models.Task;
import com.mindhub.todolist.models.UserEntity;
import com.mindhub.todolist.repositories.TaskRepository;
import com.mindhub.todolist.repositories.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UserUtils {

    @Bean
    public CommandLineRunner initDataUser(UserRepository userRepository, TaskRepository taskRepository){
        return args -> {
            UserEntity user1 = new UserEntity("Luisa", "luisa@gmail.com", "12345");
            userRepository.save(user1);
        };
    };
}
