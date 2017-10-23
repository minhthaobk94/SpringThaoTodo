package com.thaontm.demo.demoThaoTodo.service.iml;

import com.thaontm.demo.demoThaoTodo.model.Todo;
import com.thaontm.demo.demoThaoTodo.repository.TodoRepository;
import com.thaontm.demo.demoThaoTodo.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class TodoServiceIml implements TodoService {

    @Autowired
    TodoRepository todoRepository;

    @Override
    public List<Todo> findAll() {
        return (List<Todo>) todoRepository.findAll();
    }

    @Override
    public Page<Todo> findAll(Pageable pageable) {
        return todoRepository.findAll(pageable);
    }

    @Override
    public List<Todo> findByTitleContaining(String q) {
        return todoRepository.findByTitleContaining(q);
    }

    @Override
    public Page<Todo> findByTitleContaining(String q, Pageable pageable) {
        return todoRepository.findByTitleContaining(q, pageable);
    }
}
