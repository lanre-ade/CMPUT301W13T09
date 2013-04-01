package com.cmput301w13t09.cmput301project.models;

import java.io.Serializable;
import java.util.ArrayList;
/**
 * 
 * @author Kyle, Marcus, and Landre
 * Class: IngredientListModel
 * IngredientListModel is simply a class that has an arraylist of Ingredients. This is used for easy
 * storage in recipes used in creating a recipe. 
 *
 */
public class IngredientListModel extends ArrayList<IngredientModel> implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1526671550325222246L;
}
