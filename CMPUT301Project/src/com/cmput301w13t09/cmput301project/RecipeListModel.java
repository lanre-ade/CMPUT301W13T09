package com.cmput301w13t09.cmput301project;

import java.util.ArrayList;

/**
 * Class: RecipeListModel RecipeList is a class that stores a list of recipes.
 * These recipes are from RecipeModel and are stored in ArrayList class. The
 * constructor takes in a single recipe (RecipeModel)and appends it to a blank
 * recipe list. RecipeLists methods are getLength, getRecipeListName,
 * getRecipeListDesc7 getRecipeingredientList, and getRecipePhotoList.
 */

public class RecipeListModel {
	private ArrayList<RecipeModel> recipe_list = new ArrayList<RecipeModel>();

	/**
	 * Constructor TODO Fix this cause it won't work
	 * 
	 * @param recipe
	 *            : The recipe to be added to the list
	 */
	public RecipeListModel(RecipeModel recipe) {
		recipe_list.add(recipe);
	}

	/**
	 * Returns length of recipe list (RecipeListModel)
	 * 
	 * @return size : The size of the list of recipes
	 */
	public int getLength() {
		return recipe_list.size();
	}

	/**
	 * Returns name of recipe (RecipeListModel) based on its position in list
	 * 
	 * @param i
	 *            : Position of recipe in the list
	 * @return Name of recipe
	 */
	public String getRecipeListName(int i) {
		return recipe_list.get(i).getRecipeName();
	}

	/**
	 * Returns description of recipe (RecipeListModel) based on its position in
	 * list
	 * 
	 * @param i
	 *            : Position of recipe in the list
	 * @return Description of recipe
	 */
	public String getRecipeListDesc(int i) {
		return recipe_list.get(i).getRecipeDesc();
	}

	/**
	 * Returns list of ingredients of recipe (RecipeListModel) based on its
	 * position in recipe list
	 * 
	 * @param i
	 *            : Position of recipe in the list
	 * @return List of ingredient that go into this recipe
	 */
	public ingredientListModel getRecipeingredientList(int i) {
		return recipe_list.get(i).getIngredList();
	}

	/**
	 * Returns list of photos of recipe (RecipeListModel) based on its position
	 * in recipe list
	 * 
	 * @param i
	 *            : Position of recipe in the list
	 * @return List of photos attached to a recipe item
	 */
	public PhotoListModel getRecipePhotoList(int i) {
		return recipe_list.get(i).getPhotoList();
	}
}
