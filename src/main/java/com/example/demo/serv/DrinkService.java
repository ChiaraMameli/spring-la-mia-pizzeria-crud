package com.example.demo.serv;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.pojo.Drink;
import com.example.demo.repo.DrinkRepo;

@Service
public class DrinkService {
	
	@Autowired
	private DrinkRepo drinkRepo;
	
	public void save(Drink drink) {
		drinkRepo.save(drink);
	}
	
	public List<Drink> findAll(){
		return drinkRepo.findAll();
	}
	
	public Optional<Drink> getDrinkById(int id){
		return drinkRepo.findById(id);
	}
	
	public void delete(int id) {
		drinkRepo.deleteById(id);
	}
	
	public List<Drink> findByName(String name) {
		return drinkRepo.findByNameContainingIgnoreCase(name);
	}
}
