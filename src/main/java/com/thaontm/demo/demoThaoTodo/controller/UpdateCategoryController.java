package com.thaontm.demo.demoThaoTodo.controller;

import com.thaontm.demo.demoThaoTodo.model.Category;
import com.thaontm.demo.demoThaoTodo.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
public class UpdateCategoryController {
    @Autowired
    private CategoryService categoryService;

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
}
