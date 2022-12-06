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

import com.example.demo.pojo.Drink;
import com.example.demo.serv.DrinkService;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/drink")
public class DrinkController {

	@Autowired
	private DrinkService drinkService;
	
	@GetMapping("/{id}")
	public String show(@PathVariable("id") int id, Model model) {
		Optional<Drink> optDrink = drinkService.getDrinkById(id);
		
		Drink drink = optDrink.get();
		model.addAttribute("drink", drink);
		
		return "drink-show";
	}
	
	@GetMapping("/create")
	public String createDrink(Model model) {
		Drink drink = new Drink();
		model.addAttribute("drink", drink);
		return "drink-create";
	}
	
	@PostMapping("/create")
	public String storeDrink(@Valid @ModelAttribute("drink") Drink drink) {
		drinkService.save(drink);
		return "redirect:/";
	}
	
	@GetMapping("/update/{id}")
	public String editDrink(@PathVariable("id") int id, Model model) {
		Optional<Drink> optDrink = drinkService.getDrinkById(id);
		
		Drink drink = optDrink.get();
		model.addAttribute("drink", drink);
		
		return "drink-update";
	}
	
	@PostMapping("/update")
	public String updateDrink(@Valid @ModelAttribute("drink") Drink drink) {
		drinkService.save(drink);
		return "redirect:/";
	}
	
	@GetMapping("/delete/{id}")
	public String deleteDrink(@PathVariable("id") int id) {
		drinkService.delete(id);
		return "redirect:/";
	}
		
}
