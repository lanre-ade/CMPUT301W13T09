package com.cmput301w13t09.cmput301project;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import android.content.Context;

/**
 * Class: RecipeListModel RecipeList is a class that stores a list of recipes.
 * These recipes are from RecipeModel and are stored in ArrayList class. The
 * constructor takes in a single recipe (RecipeModel)and appends it to a blank
 * recipe list. RecipeLists methods are getLength, getRecipeListName,
 * getRecipeListDesc7 getRecipeingredientList, and getRecipePhotoList.
 */

public class RecipeController {
	private RecipeListModel recipe_list;

	/**
	 * Constructor 
	 * 
	 */
	public RecipeController() {
		this.recipe_list = new RecipeListModel();
	}
	
	/**
	 * 
	 * @param recipe : The Recipe to be appended to the list
	 * @return this so that chain adding can happen.
	 */
	public RecipeController addRecipe(RecipeModel recipe){
		recipe_list.add(recipe);
		return this;
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
	public IngredientListModel getRecipeingredientList(int i) {
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
	/**
	 * 
	 * @return the List of recipes
	 */
	public RecipeListModel getRecipeList(){
		return this.recipe_list;
	}

	/**
	 * 
	 * @param i The index of the recipe to be removed
	 */
	public void remove(int i) {
		this.recipe_list.remove(i);
	}
	
	/**
	 * 
	 * @param ctx Context of call location. Usually use 'this'
	 */
	public void UploadRecipeList(Context ctx) {
		try {
			FileInputStream fileIn = ctx.openFileInput("Recipe.data");
			ObjectInputStream objectInStream = new ObjectInputStream(fileIn);
			recipe_list = (RecipeListModel) objectInStream
					.readObject();
			objectInStream.close();
		} catch (FileNotFoundException FNE) {
			try {
				FileOutputStream temp = ctx.openFileOutput("Recipe.data",
						Context.MODE_PRIVATE);
				ObjectOutputStream objectOutStream = new ObjectOutputStream(
						temp);
				objectOutStream.writeObject(null);
				objectOutStream.close();

			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (NullPointerException NPE) {
			try {
				FileOutputStream temp = ctx.openFileOutput("Recipe.data",
						Context.MODE_PRIVATE);
				ObjectOutputStream objectOutStream = new ObjectOutputStream(
						temp);
				objectOutStream.writeObject(null);
				objectOutStream.close();

			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (ClassNotFoundException cnfe) {
			cnfe.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
