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
	private ArrayList<ingredientModel> ingred_list = new ArrayList<ingredientModel>();

	/**
	 * Constructor? TODO Fix this cause it won't work
	 * 
	 * @param ingred
	 *            : ....???
	 */
	public ingredientListModel(ingredientModel ingred) {
		ingred_list.add(ingred);
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
	public String getingredientListDesc(int i) {
		return ingred_list.get(i).getingredientDesc();
	}

	/**
	 * Returns name of an ingredient (ingredientModel) based on position in list
	 * (i)
	 * 
	 * @param i
	 *            : Position of recipe in the list
	 * @return Name of the ingredient
	 */
	public String getingredientListName(int i) {
		return ingred_list.get(i).getingredientName();
	}

}
