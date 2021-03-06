package fr.formation.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.formation.entity.IngredientCocktail;

public interface IngredientCocktailDao extends JpaRepository<IngredientCocktail, Integer> {

	void deleteAllByCocktailId(Integer cocktailId);

	List<IngredientCocktail> findAllByCocktailId(Integer cocktailId);

}
