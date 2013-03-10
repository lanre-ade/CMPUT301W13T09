package com.cmput301w13t09.cmput301project;

import java.util.ArrayList;

/**
 * Class: ingredientListModel ingredientListModel is a class that stores a list
 * of ingredients. These ingredients are from ingredientModel class and stored
 * in a ArrayList class. The constructor takes in a single ingredient and
 * appends it to a blank ingredient List (ingred_list). The ingredientListModel
 * has methods getLength, getingredientListDesc, getingredientListName.
 */
public class IngredientController {
	private IngredientListModel ingred_list;

	/**
	 * Constructor
	 * 
	 */
	public IngredientController() {
		 this.ingred_list = new IngredientListModel();
	}
	
	/**
	 * 
	 * @param newIngredient : The Ingredient to be added to the list
	 * @return this so that chain adding can happen.
	 */
	public IngredientController add(IngredientModel newIngredient) {
		ingred_list.add(newIngredient);
		return this;
	}
	
	/**
	 * 
	 * @return the ingredient list
	 */
	public IngredientListModel getIngredientList(){
		return this.ingred_list;
	}
	/**
	 * Returns the length of ingred_list (ingredient List)
	 * 
	 * @return length of the ingredient list
	 */
	public int getLength() {
		return ingred_list.size();
	}

	/**
	 * Returns description of an ingredient (ingredientModel) based on position
	 * in list (i)
	 * 
	 * @param i
	 *            : Position of recipe in the list
	 * @return Description of ingredient
	 */
	public String getIngredientListDesc(int i) {
		return ingred_list.get(i).getIngredientDesc();
	}

	/**
	 * Returns name of an ingredient (ingredientModel) based on position in list
	 * (i)
	 * 
	 * @param i
	 *            : Position of recipe in the list
	 * @return Name of the ingredient
	 */
	public String getIngredientListName(int i) {
		return ingred_list.get(i).getIngredientName();
	}

	/**
	 * 
	 * @param i : The position in the list of the ingredient desired
	 * @return The ingredient desired
	 */
	public IngredientModel getIngredient(int i) {
		return ingred_list.get(i);
	}
	
	/**
	 * Removes item from the list at index i
	 * @param i : index of item to be removed
	 */
	public void remove(int i) {
		this.ingred_list.remove(i);
	}
}
