package com.thaontm.demo.demoThaoTodo.repository;

import com.thaontm.demo.demoThaoTodo.model.Category;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.Set;

public interface CategoryRepository extends PagingAndSortingRepository<Category, Integer> {
    Set<Category> findByTitleContaining(String key);
    Category findTopByOrderByIdDesc();

    @Override
    Iterable<Category> findAll(Sort sort);
}
