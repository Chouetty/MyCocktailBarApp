package fr.formation.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.formation.dao.CocktailDao;
import fr.formation.dao.IngredientCocktailDao;
import fr.formation.dao.IngredientDao;
import fr.formation.entity.Cocktail;
import fr.formation.entity.Ingredient;
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

	@Transactional
	public void update(final Ingredient ingredient) {
		this.dao.save(ingredient);
	}

	@Transactional
	public void updateIngredientCocktails(final Integer cocktailId,
			final List<IngredientCocktail> ingredientCocktails) {
		final List<IngredientCocktail> dbParts = this.ingredientCocktaildao.findAllByCocktailId(cocktailId);
		final List<IngredientCocktail> toUpdate = new ArrayList<>(ingredientCocktails);
		final List<IngredientCocktail> toAdd = new ArrayList<>(ingredientCocktails);
		final List<IngredientCocktail> toDelete = new ArrayList<>(dbParts);

		toUpdate.retainAll(dbParts);
		toUpdate.forEach((part) -> {
			final IngredientCocktail dbPart = dbParts.get(dbParts.indexOf(part));
			dbPart.setQuantity(part.getQuantity());
			this.ingredientCocktaildao.save(dbPart);
		});

		toAdd.removeAll(dbParts);
		toAdd.forEach((part) -> this.ingredientCocktaildao.save(part));
		toDelete.removeAll(ingredientCocktails);
		toDelete.forEach((part) -> this.ingredientCocktaildao.delete(part));

	}
}
