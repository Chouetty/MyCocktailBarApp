package fr.formation.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.formation.dao.CocktailDao;
import fr.formation.dao.IngredientCocktailDao;
import fr.formation.dao.IngredientDao;
import fr.formation.entity.Cocktail;
import fr.formation.entity.IngredientCocktail;

@Service
public class CocktailService {

	@Autowired
	private CocktailDao dao;
	@Autowired
	private IngredientCocktailDao ingredientCocktaildao;
	@Autowired
	private IngredientDao ingredientdao;

	@Transactional
	public void addIngredientCocktailDao(final Integer cocktailId, final Integer ingredientId, final Integer quantity) {
		final IngredientCocktail cocktailPart = new IngredientCocktail();
		cocktailPart.setCocktail(this.dao.findOne(cocktailId));
		cocktailPart.setIngredient(this.ingredientdao.findOne(ingredientId));
		cocktailPart.setQuantity(quantity);

		this.ingredientCocktaildao.save(cocktailPart);
	}

	@Transactional
	public void create(final Cocktail cocktail) {
		this.dao.save(cocktail);
	}

	@Transactional
	public void delete(final Integer id) {
		this.dao.delete(id);
	}

	public Cocktail get(final Integer id) {
		return this.dao.findOne(id);
	}

	public List<Cocktail> getAll() {
		return this.dao.findAll();
	}

	public List<IngredientCocktail> getIngredientCocktail(final Integer cocktailId) {
		return this.ingredientCocktaildao.findAllByCocktailId(cocktailId);
	}

	@Transactional
	public void update(final Cocktail cocktail) {
		this.dao.save(cocktail);
	}
}
