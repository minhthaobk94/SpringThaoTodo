package com.thaontm.demo.demoThaoTodo.controller;

import com.thaontm.demo.demoThaoTodo.model.Category;
import com.thaontm.demo.demoThaoTodo.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
public class AddCategoryController {

    @Autowired
    private CategoryService categoryService;

    @RequestMapping(value = "/categories/add/", method = RequestMethod.POST)
    public String addCategory(Map<String, Object> model, @RequestParam String title) {
        categoryService.save(new Category(title));
        return "redirect:/";
    }
}
