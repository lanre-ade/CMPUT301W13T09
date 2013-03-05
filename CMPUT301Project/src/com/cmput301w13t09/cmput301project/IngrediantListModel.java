package com.cmput301w13t09.cmput301project;

import java.util.ArrayList;

/* Class: IngrediantListModel
 * IngrediantListModel is a class that stores a list of ingrediants. These ingrediants are from
 * IngrediantModel class and stored in a ArrayList class. The constructor takes in a single ingrediant
 * and appends it to a blank Ingrediant List (ingred_list). The IngrediantListModel has methods
 * getLength, getIngrediantListDesc, getIngrediantListName.
 */
public class IngrediantListModel {
	private ArrayList<IngrediantModel> ingred_list = new ArrayList<IngrediantModel>();

	// Constructor?
	public IngrediantListModel(IngrediantModel ingred) {
		ingred_list.add(ingred);
	}

	// Returns the length of ingred_list (Ingrediant List)
	public int getLength() {
		return ingred_list.size();
	}

	// Returns description of an Ingrediant (IngrediantModel) based on position
	// in list (i)
	public String getIngrediantListDesc(int i) {
		return ingred_list.get(i).getIngrediantDesc();
	}

	// Returns name of an Ingrediant (IngrediantModel) based on position in list
	// (i)
	public String getIngrediantListName(int i) {
		return ingred_list.get(i).getIngrediantName();
	}

}
