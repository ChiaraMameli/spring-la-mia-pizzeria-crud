package com.example.demo.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.pojo.Pizza;
import com.example.demo.serv.PizzaService;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/pizza")
public class PizzaController {

	@Autowired
	private PizzaService pizzaService;
	
	@GetMapping("/{id}")
	public String show(@PathVariable("id") int id, Model model) {
		
		Optional<Pizza> optPizza = pizzaService.getPizzaById(id);
		
		Pizza pizza = optPizza.get();		
		model.addAttribute("pizza", pizza);
		
		return "pizza-show";		
	}
	
	@GetMapping("/create")
	public String createPizza(Model model) {
		Pizza pizza = new Pizza();
		model.addAttribute("pizza", pizza);
		return "pizza-create";
	}
	
	@PostMapping("/create")
	public String storePizza(@Valid @ModelAttribute("pizza") Pizza pizza) {
		
		pizzaService.save(pizza);
		
		return "redirect:/";
	}
	
	@GetMapping("/update/{id}")
	public String editPizza(@PathVariable("id") int id, Model model) {
		
		Optional<Pizza> optPizza = pizzaService.getPizzaById(id);
		
		Pizza pizza = optPizza.get();		
		model.addAttribute("pizza", pizza);
		
		return "pizza-update";
	}
	
	@PostMapping("/update")
	public String updatePizza(@Valid @ModelAttribute("pizza") Pizza pizza) {
		
		pizzaService.save(pizza);
		
		return "redirect:/";
	}
	
	@GetMapping("/delete/{id}")
	public String deletePizza(@PathVariable("id") int id) {
		
		pizzaService.delete(id);
		
		return "redirect:/";
	}

}
