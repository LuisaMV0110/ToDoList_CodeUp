package com.mindhub.todolist.handlers;

public class UserNotFound  extends  RuntimeException{
    public UserNotFound(String message) {
        super(message);
    }
}
