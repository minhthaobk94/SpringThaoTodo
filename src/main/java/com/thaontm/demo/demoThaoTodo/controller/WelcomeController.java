package com.thaontm.demo.demoThaoTodo.controller;

import com.thaontm.demo.demoThaoTodo.model.Category;
import com.thaontm.demo.demoThaoTodo.model.Todo;
import com.thaontm.demo.demoThaoTodo.repository.CategoryRepository;
import com.thaontm.demo.demoThaoTodo.repository.TodoRepository;
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
public class WelcomeController {
    @Autowired
    CategoryRepository categoryRepository;

    @Autowired
    TodoRepository todoRepository;

    @Autowired
    TodoService todoService;

    @Autowired
    CategoryService categoryService;


    @RequestMapping("/")
    public String getCategories(Map<String, Object> model) {
        model.put("catId", categoryRepository.findTopByOrderByIdDesc().getId());
        model.put("categories", categoryService.findAll());
        model.put("todos", categoryRepository.findTopByOrderByIdDesc().getTodos());
        return "welcome";
    }

    @RequestMapping(value = "/categories/remove/{catId}", method = RequestMethod.GET)
    public String removeCategory(Map<String, Object> model, @PathVariable("catId") Integer catId) {
        categoryRepository.delete(catId);
        return "redirect:/";
    }



    @RequestMapping(value = "/categories/{catId}/todos/", method = RequestMethod.GET)
    public String getTodos(Map<String, Object> model, @PathVariable("catId") Integer catId) {
        model.put("catId", catId);
        model.put("categories", categoryRepository.findAll());
        model.put("todos", categoryRepository.findOne(catId).getTodos());
        return "welcome";
    }

    @RequestMapping(value = "/categories/{catId}/todos/add/", method = RequestMethod.POST)
    public String addTodo(Map<String, Object> model, @PathVariable("catId") Integer catId, @RequestParam String title) {
        todoRepository.save(new Todo(title, categoryRepository.findOne(catId)));
        return "redirect:/categories/" + catId + "/todos/";
    }

    @RequestMapping(value = "/categories/{catId}/todos/remove/{id}", method = RequestMethod.GET)
    public String removeTodo(Map<String, Object> model, @PathVariable("catId") Integer catId, @PathVariable("id") Integer id) {
        model.put("catId", catId);
        todoRepository.delete(todoRepository.findOne(id));
        return "redirect:/categories/" + catId + "/todos/";
    }

    @RequestMapping(value = "/categories/{catId}/todos/update/{id}", method = RequestMethod.GET)
    public String showUpdateTodoPage(Map<String, Object> model, @PathVariable("catId") Integer catId, @PathVariable("id") Integer id) {
        model.put("catId", catId);
        model.put("todo", todoRepository.findOne(id));
        return "todo-update";
    }

    @RequestMapping(value = "/categories/{catId}/todos/update/", method = RequestMethod.POST)
    public String updateTodo(Map<String, Object> model, @RequestParam Integer id, @RequestParam String title, @PathVariable("catId") Integer catId) {
        todoRepository.save(new Todo(id, title, categoryRepository.findOne(catId), false));
        return "redirect:/categories/" + catId + "/todos/";
    }
}
