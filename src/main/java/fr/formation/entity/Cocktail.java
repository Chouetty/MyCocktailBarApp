package fr.formation.entity;

import java.io.Serializable;

public class Cocktail implements Serializable {
	
	private static final long serialVersionUID = 1L;

	private Integer id;
	private String name;
	private float price;
	private int withAlcohol;
	
	public Cocktail(){
	}

	public Cocktail(final String name, final float price, final int withAlcohol) {
		this.name = name;
		this.price = price;
		this.withAlcohol = withAlcohol;
	}

	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the price
	 */
	public float getPrice() {
		return price;
	}

	/**
	 * @param price the price to set
	 */
	public void setPrice(float price) {
		this.price = price;
	}

	/**
	 * @return the withAlcohol
	 */
	public int getWithAlcohol() {
		return withAlcohol;
	}

	/**
	 * @param withAlcohol the withAlcohol to set
	 */
	public void setWithAlcohol(int withAlcohol) {
		this.withAlcohol = withAlcohol;
	}
	
}
