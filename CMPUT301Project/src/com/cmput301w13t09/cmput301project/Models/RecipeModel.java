package com.cmput301w13t09.cmput301project.Models;

import java.io.Serializable;


/**
 * @author Kyle, Marcus, and Lanre Class: RecipeModel RecipeModel is a class
 *         that holds recipes used in application. RecipeModel stores a name of
 *         the recipe (recipe_name), description of the recipe (recipe_desc),
 *         list of ingredients (ingredientListModel), and list of photos
 *         (PhotoListModel). The constructor takes in name of the recipe (name),
 *         description of the recipe (desc), list of ingredients (Ilist), and
 *         list of photos (Plist).Contains methods getRecipeDesc, getRecipeName,
 *         getIngredList, and getPhotoList.
 * 
 */

public class RecipeModel implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String recipe_name;
	private String recipe_desc;
	private IngredientListModel ingred_list;
	private InstructionListModel instuc_list;
	private PhotoListModel photo_list;

	/**
	 * Constructor
	 * 
	 * @param name
	 *            : Name of the recipe
	 * @param desc
	 *            : Description of the recipe
	 * @param Ilist
	 *            : List of ingredients
	 * @param Plist
	 *            : List of photos
	 */
	public RecipeModel(String name, String desc, IngredientListModel Ilist,
			InstructionListModel InsList) {
		recipe_desc = desc;
		recipe_name = name;
		ingred_list = Ilist;
		instuc_list = InsList;
		photo_list = new PhotoListModel();
	}

	public RecipeModel(String name, String desc, IngredientListModel Ilist,
			InstructionListModel InsList, PhotoListModel Plist) {
		recipe_desc = desc;
		recipe_name = name;
		ingred_list = Ilist;
		instuc_list = InsList;
		photo_list = Plist;
	}

	/**
	 * Returns the description of a recipe (RecipeModel)
	 * 
	 * @return Description of a recipe
	 */
	public String getRecipeDesc() {
		return recipe_desc;
	}

	/**
	 * Returns the name of a recipe (RecipeModel)
	 * 
	 * @return Name of the recipe
	 */
	public String getRecipeName() {
		return recipe_name;
	}

	/**
	 * Returns ingredient list of a recipe (RecipeModel)
	 * 
	 * @return A list of required ingredients
	 */
	public IngredientListModel getIngredList() {
		return ingred_list;
	}

	/**
	 * Returns photo list of a recipe (RecipeModel)
	 * 
	 * @return list of photos attached to recipe
	 */
	public PhotoListModel getPhotoList() {
		return photo_list;
	}

	/**
	 * 
	 */
	public String toString() {
		return recipe_name;
	}
	/**
	 * Returns InstructionListModel contained in RecipeModel
	 * @return
	 */
	public InstructionListModel getInstucuctionListModel() {
		return instuc_list;
	}
	/**
	 * Sets In InstructionListModel contained in RecipeModel
	 * @param instuc_list
	 */
	public void setInstucuctionListModel(InstructionListModel instuc_list) {
		this.instuc_list = instuc_list;
	}
}
