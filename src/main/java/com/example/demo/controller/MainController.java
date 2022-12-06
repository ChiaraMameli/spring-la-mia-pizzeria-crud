package com.example.demo.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.pojo.Drink;
import com.example.demo.pojo.Pizza;
import com.example.demo.serv.DrinkService;
import com.example.demo.serv.PizzaService;

@Controller
public class MainController {
	
	@Autowired
	private PizzaService pizzaService;
	@Autowired
	private DrinkService drinkService;
	
	@GetMapping("/")
	public String getHome(Model model) {
		List<Pizza> pizza = pizzaService.findAll();
		model.addAttribute("pizza", pizza);
		
		List<Drink> drinks = drinkService.findAll();
		model.addAttribute("drinks", drinks);
		
		return "home";
	}
}
