package com.thaontm.demo.demoThaoTodo.repository;


import com.thaontm.demo.demoThaoTodo.model.Todo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface TodoRepository extends PagingAndSortingRepository<Todo, Integer> {
    List<Todo> findByTitleContaining(String q);
    int countTodosByTitleContaining(String q);
    Page<Todo> findByTitleContaining(String q, Pageable pageable);
}
