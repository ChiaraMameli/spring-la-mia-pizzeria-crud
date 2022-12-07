package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
	public String storeDrink(@Valid @ModelAttribute("drink") Drink drink, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
		
			if (bindingResult.hasErrors()) {
			
			redirectAttributes.addFlashAttribute("errors", bindingResult.getAllErrors());
			
			return "redirect:/pizza/create";
			}
			
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
	public String updateDrink(@Valid Drink drink, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
		
			if (bindingResult.hasErrors()) {
			
			redirectAttributes.addFlashAttribute("errors", bindingResult.getAllErrors());
			
			return "redirect:/pizza/create";
			}
		drinkService.save(drink);
		return "redirect:/";
	}
	
	@GetMapping("/delete/{id}")
	public String deleteDrink(@PathVariable("id") int id) {
		drinkService.delete(id);
		return "redirect:/";
	}
	
	@GetMapping("/search")
	public String searchDrinkByName(Model model, @RequestParam(name = "q", required = false) String query) {
		
		List<Drink> drinks = query == null 
							? drinkService.findAll()
							: drinkService.findByName(query); 
		
		model.addAttribute("drinks", drinks);
		model.addAttribute("query", query);
		
		return "drink-search";
	}
		
}
