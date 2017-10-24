package com.thaontm.demo.demoThaoTodo.service.iml;

import com.thaontm.demo.demoThaoTodo.model.Category;
import com.thaontm.demo.demoThaoTodo.repository.CategoryRepository;
import com.thaontm.demo.demoThaoTodo.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService{
    @Autowired
    CategoryRepository categoryRepository;
    @Override
    public List<Category> findAll() {
        return (List<Category>) categoryRepository.findAll(new Sort(Sort.Direction.DESC, "id"));
    }

    @Override
    public void save(Category category) {
        categoryRepository.save(category);
    }

    @Override
    public Category findOne(int catId) {
        return categoryRepository.findOne(catId);
    }
}
