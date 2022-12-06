package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.pojo.Drink;
import com.example.demo.pojo.Pizza;
import com.example.demo.serv.DrinkService;
import com.example.demo.serv.PizzaService;

@SpringBootApplication
public class SpringLaMiaPizzeriaCrudApplication implements CommandLineRunner{
	
	@Autowired
	private PizzaService pizzaService;
	@Autowired
	private DrinkService drinkService;
	
	public static void main(String[] args) {
		SpringApplication.run(SpringLaMiaPizzeriaCrudApplication.class, args);
	}
	
	@Override
	public void run(String... args) throws Exception {
		
		Pizza pizza1 = new Pizza("Margherita", "Buonissima" , 600);
		Pizza pizza2 = new Pizza("Napoli", "Buonissima" , 450);
		Pizza pizza3 = new Pizza("Nutella", "Buonissima" , 700);
		Drink drink1 = new Drink("Coca Cola", "Freschissima", 250);
		Drink drink2 = new Drink("Ichnusa", "Freschissima", 300);
		Drink drink3 = new Drink("Acqua", "Freschissima", 100);
		
		pizzaService.save(pizza1);
		pizzaService.save(pizza2);
		pizzaService.save(pizza3);
		
		drinkService.save(drink1);
		drinkService.save(drink2);
		drinkService.save(drink3);
	}

}