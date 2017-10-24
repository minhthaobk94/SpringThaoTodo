package com.thaontm.demo.demoThaoTodo.controller;

import com.thaontm.demo.demoThaoTodo.model.Category;
import com.thaontm.demo.demoThaoTodo.model.Todo;
import com.thaontm.demo.demoThaoTodo.service.CategoryService;
import com.thaontm.demo.demoThaoTodo.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
public class AddController {
    @Autowired
    private CategoryService categoryService;

    @Autowired
    private TodoService todoService;

    @RequestMapping(value = "/categories/add/", method = RequestMethod.POST)
    public String addCategory(Map<String, Object> model, @RequestParam String title) {
        categoryService.save(new Category(title));
        return "redirect:/";
    }

    @RequestMapping(value = "/categories/{catId}/todos/add/", method = RequestMethod.POST)
    public String addTodo(Map<String, Object> model, @PathVariable("catId") Integer catId, @RequestParam String title) {
        todoService.save(new Todo(title, categoryService.findOne(catId)));
        return "redirect:/categories/" + catId + "/todos/";
    }
}
