package com.thaontm.demo.demoThaoTodo.repository;


import com.thaontm.demo.demoThaoTodo.model.Todo;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TodoRepository extends CrudRepository<Todo, Integer> {
    List<Todo> findByTitleContaining(String q);
}
