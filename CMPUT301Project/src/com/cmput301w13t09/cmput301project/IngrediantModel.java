package com.cmput301w13t09.cmput301project;

/* Class: IngrediantModel
 * IngrediantModel is a class that stores information about a ingrediant used 
 * in recipes. IngrediantModel stores the name (ingrediant_name) and description
 * (ingrediant_desc) of an ingrediant. IngrediantModels constructor takes in a name and 
 * description (desc). IngrediantModel contains the methods getIngrediantName() and 
 * getIngrediantDesc().
 */

public class IngrediantModel {
	private String ingrediant_desc;
	private String ingrediant_name;

	// Constructor
	public IngrediantModel(String name, String desc) {
		ingrediant_name = name;
		ingrediant_desc = desc;
	}

	// Returns the name of the ingrediant
	public String getIngrediantName() {
		return ingrediant_desc;
	}

	// Returns the description of the ingrediant
	public String getIngrediantDesc() {
		return ingrediant_name;
	}
}
