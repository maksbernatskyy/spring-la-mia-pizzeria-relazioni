package org.lessons.java.spring_la_mia_pizzeria_crud.controller;

import java.util.List;
import org.lessons.java.spring_la_mia_pizzeria_crud.repository.PizzaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.lessons.java.spring_la_mia_pizzeria_crud.model.Pizza;


@Controller
@RequestMapping("/pizze")
public class PizzaController {

    @Autowired
    private PizzaRepository repository;

    @GetMapping
    public String index(Model model) {
        List<Pizza> result = repository.findAll();
        model.addAttribute("list", result);
        return "/pizze/index";
    }
    
}
