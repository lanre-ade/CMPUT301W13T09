package com.cmput301w13t09.cmput301project;

/**
 * Class: ingredientModel ingredientModel is a class that stores information
 * about a ingredient used in recipes. ingredientModel stores the name
 * (ingredient_name) and description (ingredient_desc) of an ingredient.
 * ingredientModels constructor takes in a name and description (desc).
 * ingredientModel contains the methods getingredientName() and
 * getingredientDesc().
 */

public class IngredientModel {
	private String ingredient_desc;
	private String ingredient_name;

	/**
	 * Constructor
	 * 
	 * @param name
	 *            : Name of the ingredient
	 * @param desc
	 *            : Description of ingredient
	 */
	public IngredientModel(String name, String desc) {
		this.ingredient_name = name;
		this.ingredient_desc = desc;
	}

	/**
	 * Returns the name of the ingredient
	 * 
	 * @return Name of the ingredient
	 */
	public String getIngredientName() {
		return this.ingredient_desc;
	}

	/**
	 * Returns the description of the ingredient
	 * 
	 * @return Description of the ingredient
	 */
	public String getIngredientDesc() {
		return this.ingredient_name;
	}
	
	/**
	 * When anything tries to read this object as a string it will output the
	 * name of the ingredient
	 */
	public String toString() {
		return this.ingredient_name;
	}
}
