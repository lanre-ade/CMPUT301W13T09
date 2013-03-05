package com.cmput301w13t09.cmput301project;

/* Class: RecipeModel
 * RecipeModel is a class that holds recipes used in application. RecipeModel stores a 
 * name of the recipe (recipe_name), description of the recipe (recipe_desc), list of ingrediants
 * (IngrediantListModel), and list of photos (PhotoListModel). The constructor takes in name 
 * of the recipe (name), description of the recipe (desc), list of ingrediants
 * (Ilist), and list of photos (Plist).Contains methods getRecipeDesc, getRecipeName, getIngredList,
 *  and getPhotoList.
 */

public class RecipeModel {

	private String recipe_name;
	private String recipe_desc;
	private IngrediantListModel ingred_list;
	private PhotoListModel photo_list;

	// Constructor
	public RecipeModel(String name, String desc, IngrediantListModel Ilist,
			PhotoListModel Plist) {
		recipe_desc = desc;
		recipe_name = name;
		ingred_list = Ilist;
		photo_list = Plist;
	}

	// Returns the description of a recipe (RecipeModel)
	public String getRecipeDesc() {
		return recipe_desc;
	}

	// Returns the name of a recipe (RecipeModel)
	public String getRecipeName() {
		return recipe_name;
	}

	// Returns ingrediant list of a recipe (RecipeModel)
	public IngrediantListModel getIngredList() {
		return ingred_list;
	}

	// Returns photo list of a recipe (RecipeModel)
	public PhotoListModel getPhotoList() {
		return photo_list;
	}
}
