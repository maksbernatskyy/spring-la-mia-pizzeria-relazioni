package org.lessons.java.spring_la_mia_pizzeria_crud.controller;

import java.util.List;
import org.lessons.java.spring_la_mia_pizzeria_crud.repository.PizzaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.lessons.java.spring_la_mia_pizzeria_crud.model.Pizza;
import org.springframework.web.bind.annotation.RequestParam;




@Controller
@RequestMapping("/pizze")
public class PizzaController {

    // Repository
    @Autowired
    private PizzaRepository repository;

    // Index
    @GetMapping
    public String index(Model model) {
        List<Pizza> result = repository.findAll();
        model.addAttribute("list", result);
        return "/pizze/index";
    }

    // Show
    @GetMapping("/{id}")
    public String show(@PathVariable("id") Integer id, Model model) {
        model.addAttribute("pizza", repository.findById(id).get());
        return "/pizze/show";
    }
    
    // Store
    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("pizza", new Pizza());
        return "/pizze/create";
    }
    
}
