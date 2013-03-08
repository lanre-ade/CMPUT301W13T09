package com.cmput301w13t09.cmput301project;

import java.util.ArrayList;

/**
 * Class: ingredientListModel ingredientListModel is a class that stores a list
 * of ingredients. These ingredients are from ingredientModel class and stored
 * in a ArrayList class. The constructor takes in a single ingredient and
 * appends it to a blank ingredient List (ingred_list). The ingredientListModel
 * has methods getLength, getingredientListDesc, getingredientListName.
 */
public class ingredientListModel {
	private ArrayList<ingredientModel> ingred_list;

	/**
	 * Constructor
	 * 
	 */
	public ingredientListModel() {
		 this.ingred_list = new ArrayList<ingredientModel>();
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

}
