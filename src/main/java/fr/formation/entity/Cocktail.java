package fr.formation.entity;

import java.io.Serializable;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

public class Cocktail implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer id;

	@NotNull
	@Pattern(regexp = "[^/:;+=@]+")
	private String name;

	@NotNull
	@Min(0)
	private Float price;

	private int withAlcohol;

	public Cocktail() {
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
	 * @param id
	 *            the id to set
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
	 * @param name
	 *            the name to set
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
	 * @param price
	 *            the price to set
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
	 * @param withAlcohol
	 *            the withAlcohol to set
	 */
	public void setWithAlcohol(int withAlcohol) {
		this.withAlcohol = withAlcohol;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cocktail other = (Cocktail) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
