package fr.formation.entity;

import java.io.Serializable;

public class Ingredient implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private int state;
	private String name;
	
	public Ingredient(){
	}

	public Ingredient(final String name, final int state) {
		this.name = name;
		this.state = state;
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
	 * @return the state
	 */
	public int getState() {
		return state;
	}

	/**
	 * @param state the state to set
	 */
	public void setState(int state) {
		this.state = state;
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
}
