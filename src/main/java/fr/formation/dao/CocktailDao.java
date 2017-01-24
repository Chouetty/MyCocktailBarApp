package fr.formation.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.formation.entity.Cocktail;
import fr.formation.entity.Ingredient;

@Repository
public interface CocktailDao extends JpaRepository<Cocktail, Integer> {

	public void save(Ingredient ingredient);

}
