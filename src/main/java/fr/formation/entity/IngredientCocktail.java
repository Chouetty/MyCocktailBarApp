package fr.formation.entity;

import java.io.Serializable;

public class IngredientCocktail implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer ingredientId;
	private Integer cocktailId;
	private int quantity;
	
	public IngredientCocktail (){
	}

	public IngredientCocktail (final int quantity) {
		this.quantity = quantity;
	}
	/**
	 * @return the ingredientId
	 */
	public Integer getIngredientId() {
		return ingredientId;
	}

	/**
	 * @param ingredientId the ingredientId to set
	 */
	public void setIngredientId(Integer ingredientId) {
		this.ingredientId = ingredientId;
	}

	/**
	 * @return the cocktailId
	 */
	public Integer getCocktailId() {
		return cocktailId;
	}

	/**
	 * @param cocktailId the cocktailId to set
	 */
	public void setCocktailId(Integer cocktailId) {
		this.cocktailId = cocktailId;
	}

	/**
	 * @return the quantity
	 */
	public int getQuantity() {
		return quantity;
	}

	/**
	 * @param quantity the quantity to set
	 */
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
}
