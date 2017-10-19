package com.thaontm.demo.demoThaoTodo.repository;


import com.thaontm.demo.demoThaoTodo.model.Todo;
import org.springframework.data.repository.CrudRepository;

public interface TodoRepository extends CrudRepository<Todo, Integer> {
}
