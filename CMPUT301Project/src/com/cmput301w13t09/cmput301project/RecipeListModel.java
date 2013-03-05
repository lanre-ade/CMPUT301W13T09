package com.cmput301w13t09.cmput301project;

import java.util.ArrayList;

/* Class: RecipeListModel
 * RecipeList is a class that stores a list of recipes. These recipes are from RecipeModel and are
 * stored in ArrayList class. The constructor takes in a single recipe (RecipeModel)and appends it 
 * to a blank recipe list. RecipeLists methods are getLength, getRecipeListName, getRecipeListDesc7
 * getRecipeIngrediantList, and getRecipePhotoList.
 */

public class RecipeListModel {
	private ArrayList<RecipeModel> recipe_list = new ArrayList<RecipeModel>();

	// Constructor
	public RecipeListModel(RecipeModel recipe) {
		recipe_list.add(recipe);
	}

	// Returns length of recipe list (RecipeListModel)
	public int getLength() {
		return recipe_list.size();
	}

	// Returns name of recipe (RecipeListModel) based on its position in list
	public String getRecipeListName(int i) {
		return recipe_list.get(i).getRecipeName();
	}

	// Returns description of recipe (RecipeListModel) based on its position in
	// list
	public String getRecipeListDesc(int i) {
		return recipe_list.get(i).getRecipeDesc();
	}

	// Returns list of ingrediants of recipe (RecipeListModel) based on its
	// position in recipe list
	public IngrediantListModel getRecipeIngrediantList(int i) {
		return recipe_list.get(i).getIngredList();
	}

	// Returns list of photos of recipe (RecipeListModel) based on its position
	// in recipe list
	public PhotoListModel getRecipePhotoList(int i) {
		return recipe_list.get(i).getPhotoList();
	}
}
