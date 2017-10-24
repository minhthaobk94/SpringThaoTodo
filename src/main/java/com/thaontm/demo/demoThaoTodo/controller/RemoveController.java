package com.thaontm.demo.demoThaoTodo.controller;

import com.thaontm.demo.demoThaoTodo.service.CategoryService;
import com.thaontm.demo.demoThaoTodo.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Map;

@Controller
public class RemoveController {
    @Autowired
    private CategoryService categoryService;

    @Autowired
    private TodoService todoService;

    @RequestMapping(value = "/categories/remove/{catId}", method = RequestMethod.GET)
    public String removeCategory(Map<String, Object> model, @PathVariable("catId") Integer catId) {
        categoryService.delete(catId);
        return "redirect:/";
    }

    @RequestMapping(value = "/categories/{catId}/todos/remove/{id}", method = RequestMethod.GET)
    public String removeTodo(Map<String, Object> model, @PathVariable("catId") Integer catId, @PathVariable("id") Integer id) {
        model.put("catId", catId);
        todoService.delete(todoService.findOne(id));
        return "redirect:/categories/" + catId + "/todos/";
    }
}
