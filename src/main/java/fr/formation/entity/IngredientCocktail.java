package fr.formation.entity;

import java.io.Serializable;

public class IngredientCocktail implements Serializable {
	private static final long serialVersionUID = 1L;

	private Cocktail cocktail;
	private Integer id;
	private Ingredient ingredient;
	private Integer quantity;

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (this.getClass() != obj.getClass()) {
			return false;
		}
		final IngredientCocktail other = (IngredientCocktail) obj;
		if (this.cocktail == null) {
			if (other.cocktail != null) {
				return false;
			}
		} else if (!this.cocktail.equals(other.cocktail)) {
			return false;
		}
		if (this.ingredient == null) {
			if (other.ingredient != null) {
				return false;
			}
		} else if (!this.ingredient.equals(other.ingredient)) {
			return false;
		}
		return true;
	}

	/**
	 * @return the cocktail
	 */
	public Cocktail getCocktail() {
		return this.cocktail;
	}

	/**
	 * @return the id
	 */
	public Integer getId() {
		return this.id;
	}

	/**
	 * @return the ingredient
	 */
	public Ingredient getIngredient() {
		return this.ingredient;
	}

	/**
	 * @return the quantity
	 */
	public Integer getQuantity() {
		return this.quantity;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (this.cocktail == null ? 0 : this.cocktail.hashCode());
		result = prime * result + (this.ingredient == null ? 0 : this.ingredient.hashCode());
		return result;
	}

	/**
	 * @param cocktail
	 *            the cocktail to set
	 */
	public void setCocktail(Cocktail cocktail) {
		this.cocktail = cocktail;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * @param ingredient
	 *            the ingredient to set
	 */
	public void setIngredient(Ingredient ingredient) {
		this.ingredient = ingredient;
	}

	/**
	 * @param quantity
	 *            the quantity to set
	 */
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

}
