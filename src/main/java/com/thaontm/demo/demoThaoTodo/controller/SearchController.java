package com.thaontm.demo.demoThaoTodo.controller;

import com.thaontm.demo.demoThaoTodo.service.TodoService;
import com.thaontm.demo.demoThaoTodo.utils.Constants;
import com.thaontm.demo.demoThaoTodo.utils.PaginationUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
public class SearchController {
    @Autowired
    private TodoService todoService;

    @RequestMapping(value = "/search/", method = RequestMethod.GET)
    public String search(Map<String, Object> model, @RequestParam(name = "q", defaultValue = "") String q, @PageableDefault(page = 0, size = Constants.PAGE_SIZE) Pageable pageable) {
        if (!q.isEmpty()) {
            model.put("totalPages", PaginationUtils.calculateTotalPages(todoService.findByTitleContaining(q).size(), Constants.PAGE_SIZE));
            model.put("todos", todoService.findByTitleContaining(q, pageable));
        } else {
            model.put("totalPages", PaginationUtils.calculateTotalPages(todoService.findAll().size(), Constants.PAGE_SIZE));
            model.put("todos", todoService.findAll(pageable));
        }
        model.put("pageSize", Constants.PAGE_SIZE);
        model.put("query", q);
        return "search";
    }
}
