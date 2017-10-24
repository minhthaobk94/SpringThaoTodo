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
public class UpdateController {
    @Autowired
    private CategoryService categoryService;

    @Autowired
    private TodoService todoService;

    @RequestMapping(value = "/categories/update/{catId}", method = RequestMethod.GET)
    public String showUpdateCategoryPage(Map<String, Object> model, @PathVariable("catId") Integer catId) {
        model.put("category", categoryService.findOne(catId));
        return "category-update";
    }

    @RequestMapping(value = "/categories/update/", method = RequestMethod.POST)
    public String updateCategory(Map<String, Object> model, @RequestParam Integer catId, @RequestParam String title) {
        categoryService.save(new Category(catId, title, null));
        return "redirect:/";
    }

    @RequestMapping(value = "/categories/{catId}/todos/update/{id}", method = RequestMethod.GET)
    public String showUpdateTodoPage(Map<String, Object> model, @PathVariable("catId") Integer catId, @PathVariable("id") Integer id) {
        model.put("catId", catId);
        model.put("todo", todoService.findOne(id));
        return "todo-update";
    }

    @RequestMapping(value = "/categories/{catId}/todos/update/", method = RequestMethod.POST)
    public String updateTodo(Map<String, Object> model, @RequestParam Integer id, @RequestParam String title, @PathVariable("catId") Integer catId) {
        todoService.save(new Todo(id, title, categoryService.findOne(catId), false));
        return "redirect:/categories/" + catId + "/todos/";
    }
}
