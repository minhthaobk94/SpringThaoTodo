package com.thaontm.demo.demoThaoTodo.service;

import com.thaontm.demo.demoThaoTodo.model.Todo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface TodoService {
    List<Todo> findAll();
    Page<Todo> findAll(Pageable pageable);
    List<Todo> findByTitleContaining(String q);
    Page<Todo> findByTitleContaining(String q, Pageable pageable);
}
