package com.cmput301w13t09.cmput301project.controllers;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import com.cmput301w13t09.cmput301project.models.IngredientListModel;
import com.cmput301w13t09.cmput301project.models.IngredientModel;

import android.content.Context;

/**
 * @author Kyle, Marcus, and Landre Class: ingredientListController is a class
 *         that stores a list of ingredients. These ingredients are from
 *         ingredientModel class and stored in a ArrayList class. The
 *         constructor takes in a single ingredient and appends it to a blank
 *         ingredient List (ingred_list). The ingredientListModel has methods
 *         getLength, getingredientListDesc, getingredientListName, add, remove,
 *         saveToFile, and LoadFromFile.
 */
public class IngredientController {
	private IngredientListModel ingred_List;
	private Context ctx;

	/**
	 * Constructor
	 * 
	 */
	public IngredientController(Context tcxt) {
		ingred_List = new IngredientListModel();
		this.ctx = tcxt;
		this.loadFromFile();
	}

	/**
	 * 
	 * @param newIngredient
	 *            : The Ingredient to be added to the list
	 * @return this so that chain adding can happen.
	 */
	public IngredientController add(IngredientModel newIngredient) {
		ingred_List.add(newIngredient);
		return this;
	}

	/**
	 * 
	 * @return the ingredient list
	 */
	public IngredientListModel getIngredientList() {
		return this.ingred_List;
	}

	/**
	 * Returns the length of ingred_list (ingredient List)
	 * 
	 * @return length of the ingredient list
	 */
	public int getLength() {
		return ingred_List.size();
	}

	/**
	 * Returns description of an ingredient (ingredientModel) based on position
	 * in list (i)
	 * 
	 * @param i
	 *            : Position of recipe in the list
	 * @return Description of ingredient
	 */
	public String getIngredientListDesc(int i) {
		return ingred_List.get(i).getIngredientDesc();
	}

	/**
	 * Returns name of an ingredient (ingredientModel) based on position in list
	 * (i)
	 * 
	 * @param i
	 *            : Position of recipe in the list
	 * @return Name of the ingredient
	 */
	public String getIngredientListName(int i) {
		return ingred_List.get(i).getIngredientName();
	}

	/**
	 * 
	 * @param i
	 *            : The position in the list of the ingredient desired
	 * @return The ingredient desired
	 */
	public IngredientModel getIngredient(int i) {
		return ingred_List.get(i);
	}

	/**
	 * Edits the ingredient based on the position give and sets new value of
	 * ingredient
	 * 
	 * @param i
	 * @param tname
	 * @param tDescription
	 * @param tQuantity
	 * @param tUnit
	 */
	public void editIngredient(int i, String tname, String tDescription,
			float tQuantity, String tUnit) {
		ingred_List.set(i, new IngredientModel(tname, tDescription, tQuantity,
				tUnit));
	}

	/**
	 * Removes item from the list at index i
	 * 
	 * @param i
	 *            : index of item to be removed
	 */
	public void remove(int i) {
		this.ingred_List.remove(i);
	}

	/**
	 * 
	 * @param ctx
	 *            Context of call location. Usually use 'this'
	 */
	public void loadFromFile() {
		try {

			FileInputStream fileIn = ctx.openFileInput("Pantry.data");
			ObjectInputStream objectInStream = new ObjectInputStream(fileIn);
			ingred_List = (IngredientListModel) objectInStream.readObject();
			objectInStream.close();
		} catch (FileNotFoundException FNE) {
			try {
				FileOutputStream temp = ctx.openFileOutput("Pantry.data",
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
				FileOutputStream temp = ctx.openFileOutput("Pantry.data",
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

	/**
	 * Saves IngredientListModel ingred_list to file Pantry.data
	 */
	public void saveToFile() {
		try {
			new File("Pantry.data").delete();
			FileOutputStream fileOut = ctx.openFileOutput("Pantry.data",
					Context.MODE_PRIVATE);
			ObjectOutputStream objectOutStream = new ObjectOutputStream(fileOut);
			objectOutStream.writeObject(ingred_List);
			objectOutStream.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
