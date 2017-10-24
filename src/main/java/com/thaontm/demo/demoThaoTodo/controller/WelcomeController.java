package com.thaontm.demo.demoThaoTodo.controller;

import com.thaontm.demo.demoThaoTodo.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Map;

@Controller
public class WelcomeController {
    @Autowired
    CategoryService categoryService;

    @RequestMapping("/")
    public String getCategories(Map<String, Object> model) {
        model.put("catId", categoryService.findTopByOrderByIdDesc().getId());
        model.put("categories", categoryService.findAll());
        model.put("todos", categoryService.findTopByOrderByIdDesc().getTodos());
        return "welcome";
    }

    @RequestMapping(value = "/categories/{catId}/todos/", method = RequestMethod.GET)
    public String getTodos(Map<String, Object> model, @PathVariable("catId") Integer catId) {
        model.put("catId", catId);
        model.put("categories", categoryService.findAll());
        model.put("todos", categoryService.findOne(catId).getTodos());
        return "welcome";
    }
}
