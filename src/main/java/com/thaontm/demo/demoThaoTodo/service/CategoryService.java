package com.thaontm.demo.demoThaoTodo.service;

import com.thaontm.demo.demoThaoTodo.model.Category;

import java.util.List;

public interface CategoryService {
    List<Category> findAll();

    void save(Category category);

    Category findOne(int catId);
}
