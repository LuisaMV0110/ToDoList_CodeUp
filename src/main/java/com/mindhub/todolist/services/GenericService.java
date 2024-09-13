package com.mindhub.todolist.services;

import java.util.List;

public interface GenericService <Entity, DTO>{
    List<DTO> findAll();
}
