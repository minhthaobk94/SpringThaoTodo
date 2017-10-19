package com.thaontm.demo.demoThaoTodo.repository;

import com.thaontm.demo.demoThaoTodo.model.Category;
import org.springframework.data.repository.CrudRepository;

import java.util.Set;

public interface CategoryRepository extends CrudRepository<Category, Integer> {
    Set<Category> findByTitleContaining(String key);
}
