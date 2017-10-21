package com.thaontm.demo.demoThaoTodo.controller;

import com.thaontm.demo.demoThaoTodo.model.Category;
import com.thaontm.demo.demoThaoTodo.model.Todo;
import com.thaontm.demo.demoThaoTodo.repository.CategoryRepository;
import com.thaontm.demo.demoThaoTodo.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
public class WelcomeController {
    private List<Todo> todos = new ArrayList<>();

    @Autowired
    CategoryRepository categoryRepository;

    @Autowired
    TodoRepository todoRepository;

    @RequestMapping("/")
    public String getCategories(Map<String, Object> model) {
        model.put("catId", 1);
        model.put("categories", categoryRepository.findAll());
        model.put("todos", categoryRepository.findOne(1).getTodos());
        return "welcome";
    }

    @RequestMapping(value = "/categories/add/", method = RequestMethod.POST)
    public String addCategory(Map<String, Object> model, @RequestParam String title) {
        categoryRepository.save(new Category(title));
        return "redirect:/";
    }

    @RequestMapping(value = "/categories/remove/{catId}", method = RequestMethod.GET)
    public String removeCategory(Map<String, Object> model, @PathVariable("catId") Integer catId) {
        categoryRepository.delete(catId);
        return "redirect:/";
    }

    @RequestMapping(value = "/categories/update/{catId}", method = RequestMethod.GET)
    public String showUpdateCategoryPage(Map<String, Object> model, @PathVariable("catId") Integer catId) {
        model.put("category", categoryRepository.findOne(catId));
        return "category-update";
    }

    @RequestMapping(value = "/categories/update/", method = RequestMethod.POST)
    public String updateCategory(Map<String, Object> model, @RequestParam Integer catId, @RequestParam String title) {
        categoryRepository.save(new Category(catId, title, null));
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
        todoRepository.save(new Todo(id, title, categoryRepository.findOne(catId)));
        return "redirect:/categories/" + catId + "/todos/";
    }

    @RequestMapping(value = "/search/", method = RequestMethod.GET)
    public String search(Map<String, Object> model, @RequestParam String q) {
        if (!q.isEmpty()) {
            model.put("todos", todoRepository.findByTitleContaining(q));
        } else {
            model.put("todos", todoRepository.findAll());
        }
        return "search";
    }
}
