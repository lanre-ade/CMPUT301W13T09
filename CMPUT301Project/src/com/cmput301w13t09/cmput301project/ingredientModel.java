package com.cmput301w13t09.cmput301project;

/**
 * Class: ingredientModel ingredientModel is a class that stores information
 * about a ingredient used in recipes. ingredientModel stores the name
 * (ingredient_name) and description (ingredient_desc) of an ingredient.
 * ingredientModels constructor takes in a name and description (desc).
 * ingredientModel contains the methods getingredientName() and
 * getingredientDesc().
 */

public class ingredientModel {
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
	public ingredientModel(String name, String desc) {
		ingredient_name = name;
		ingredient_desc = desc;
	}

	/**
	 * Returns the name of the ingredient
	 * 
	 * @return Name of the ingredient
	 */
	public String getingredientName() {
		return ingredient_desc;
	}

	/**
	 * Returns the description of the ingredient
	 * 
	 * @return Description of the ingredient
	 */
	public String getingredientDesc() {
		return ingredient_name;
	}
}
