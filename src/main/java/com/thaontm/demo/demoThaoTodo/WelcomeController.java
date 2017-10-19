package com.thaontm.demo.demoThaoTodo;

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

//import com.thaontm.demo.demoThaoTodo.repository.CategoryRepository;

@Controller
public class WelcomeController {
    private List<Todo> todos = new ArrayList<>();

    @Autowired
    CategoryRepository categoryRepository;

    @Autowired
    TodoRepository todoRepository;

    @RequestMapping("/")
    public String getCategories(Map<String, Object> model) {
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
}
