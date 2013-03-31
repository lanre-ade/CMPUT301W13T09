package com.cmput301w13t09.cmput301project.Models;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * 
 * @author Kyle, Marcus, and Landre Class: RecipeListModel RecipeListModel is
 *         simply a class that has an arraylist of Recipes. This is used for
 *         easy storage in file used in loading all recipes.
 * 
 */
public class RecipeListModel extends ArrayList<RecipeModel> implements
		Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4208043430486406004L;

}
