package com.example.demo.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.pojo.Drink;

@Repository
public interface DrinkRepo extends JpaRepository<Drink, Integer> {
	public List<Drink> findByNameContainingIgnoreCase(String name);
}
