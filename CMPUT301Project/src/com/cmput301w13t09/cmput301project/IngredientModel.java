package com.cmput301w13t09.cmput301project;

import java.io.Serializable;

/**
 * @author Kyle,Marcus,Landre
 * Class: ingredientModel ingredientModel is a class that stores information
 * about a ingredient used in recipes. ingredientModel stores the name
 * (ingredient_name) and description (ingredient_desc) of an ingredient.
 * ingredientModels constructor takes in a name and description (desc).
 * ingredientModel contains the methods getingredientName() and
 * getingredientDesc().
 */

public class IngredientModel implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String ingredient_desc;
	private String ingredient_name;
	private float ingredient_quantity;
	private String ingredient_quantity_unit;

	/**
	 * Constructor
	 * 
	 * @param name
	 *            : Name of the ingredient
	 * @param desc
	 *            : Description of ingredient
	 */
	public IngredientModel(String name, String desc, float quantity, String unit) {
		this.ingredient_name = name;
		this.ingredient_desc = desc;
		this.ingredient_quantity = quantity;
		this.ingredient_quantity_unit = unit;
	}
	public IngredientModel(String name, String desc){
		this.ingredient_name = name;
		this.ingredient_desc = desc;
		this.ingredient_quantity = 10;
		this.ingredient_quantity_unit = "g";
	}

	/**
	 * Returns the name of the ingredient
	 * 
	 * @return Name of the ingredient
	 */
	public String getIngredientName() {
		return this.ingredient_name;
	}

	/**
	 * Returns the description of the ingredient
	 * 
	 * @return Description of the ingredient
	 */
	public String getIngredientDesc() {
		return this.ingredient_desc;
	}

	/**
	 * Returns the Quantity of the ingredient
	 * 
	 * @return Quantity of the ingredient
	 */
	public float getIngredientquantity(){
		return this.ingredient_quantity;
	}
	/**
	 * Returns the Quantity unit of the ingredientss
	 * @return Quantity unit of the ingredient
	 */
	public String getIngredientquantityunit(){
		return this.ingredient_quantity_unit;
	}
	/**
	 * When anything tries to read this object as a string it will output the
	 * name of the ingredient
	 */
	public String toString() {
		return this.ingredient_name;
	}
	/**
	 * 
	 * @return String formated for Dialog
	 */

	public String toDialogString() {
		return "Quantity: " + ingredient_quantity + " "
				+ ingredient_quantity_unit + "\n\n" + ingredient_desc;

	}
	/**
	 * Sets the name to new value
	 * @param name
	 */
	public void setIngredientName(String name) {
		this.ingredient_name = name;
	}
	/**
	 * Sets the description to new value
	 * @param description
	 */
	public void setIngredientDescription(String description){
		this.ingredient_desc = description;
	}
	/**
	 * Sets the quantity to new value
	 * @param quantity
	 */
	public void setQuantity(float quantity){
		this.ingredient_quantity = quantity;
	}
	/**
	 * Sets the unit to a new value
	 * @param unit
	 */
	public void setUnit(String unit){
		this.ingredient_quantity_unit = unit;
	}
}
