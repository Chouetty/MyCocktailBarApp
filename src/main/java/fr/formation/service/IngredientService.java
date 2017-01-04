package fr.formation.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import fr.formation.dao.IngredientDao;
import fr.formation.entity.Ingredient;
import fr.formation.entity.IngredientCocktail;

@Service
public class IngredientService {

	@Autowired
	private IngredientDao dao;

	@Transactional
	public void create(final Ingredient ingredient) {
		this.dao.save(ingredient);
	}

	@Transactional
	public void delete(final Integer id) {
		this.dao.delete(id);
	}

	public Ingredient get(final Integer ingredientId) {
		return this.dao.findOne(ingredientId);
	}

	public List<Ingredient> getAll() {
		return this.dao.findAll();
	}

	public List<Ingredient> getAllByCocktail(final List<IngredientCocktail> ingredientCocktails) {
		List<Ingredient> results = null;
		if (CollectionUtils.isEmpty(ingredientCocktails)) {
			results = this.getAll();
		} else {
			final List<Integer> ingredientIds = ingredientCocktails.stream()
					.map((final IngredientCocktail ingredientCocktail) -> ingredientCocktail.getIngredient().getId())
					.collect(Collectors.toList());
			results = this.dao.findAllByIdNotIn(ingredientIds);
		}
		return results;
	}

	public List<IngredientCocktail> getIngredientCocktails(Integer cocktailId) {
		return null;
	}

	@Transactional
	public void update(final Ingredient ingredient) {
		this.dao.save(ingredient);
	}
}
