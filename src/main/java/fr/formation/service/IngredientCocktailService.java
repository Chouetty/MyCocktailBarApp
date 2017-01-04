package fr.formation.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.formation.dao.IngredientCocktailDao;
import fr.formation.entity.IngredientCocktail;
	

	@Service
	public class IngredientCocktailService {

			@Autowired
			private IngredientCocktailDao dao;

			public List<IngredientCocktail> getAll() {
				return this.dao.findAll();
			}
}
