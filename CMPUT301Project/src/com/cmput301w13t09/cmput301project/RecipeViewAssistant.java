package com.cmput301w13t09.cmput301project;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import android.content.Context;
import android.net.Uri;
import android.os.Environment;

/**
 * 
 * @author Marcus, Lanre, Kyle Used to help the recipe views keep their data in
 *         sync
 * 
 */
public class RecipeViewAssistant {
	private Context ctx;
	private IngredientListModel ingr_list;
	private InstructionListModel inst_list;
	private String name, description;
	private RecipeModel recipe;
	private PhotoListModel photo_list;

	// private PhotoListModel photo_list;
	/**
	 * Constructor
	 * 
	 * @param ctx
	 *            : The context of the activity that is using the assistant,
	 *            usually use (this).
	 */
	public RecipeViewAssistant(Context ctx) {
		this.setIngredientList(new IngredientListModel());
		this.setInstructionList(new InstructionListModel());
		this.ctx = ctx;
		// photo_list = new PhotoListModel();
	}

	/**
	 * Adds an ingredient to the recipe's ingredient list
	 * 
	 * @param ing
	 *            : Ingredient to be added to the Ingredient List
	 */
	public void addIngredient(IngredientModel ing) {
		ingr_list.add(ing);
	}

	/**
	 * Removes an ingredient from the ingredient list
	 * 
	 * @param i
	 *            : The position of the ingredient to be removed from the
	 *            ingredient list
	 */
	public void removeIngredient(int i) {
		ingr_list.remove(i);
	}

	/**
	 * Adds an instruction to the recipe's instruction list
	 * 
	 * @param ins
	 *            : Instruction to be added to the Instruction List
	 */
	public void addInstruction(InstructionModel ins) {
		inst_list.add(ins);
	}

	/**
	 * Removes an instruction from the instruction list
	 * 
	 * @param i
	 *            : The position of the instruction to be removed from the
	 *            instruction list
	 */
	public void removeInstruction(int i) {
		inst_list.remove(i);
	}

	/**
	 * Adds a photo to the recipe's photo List
	 * 
	 * @param photoModel
	 *            : Photo to be added to the Photo List
	 */
	public void addPhoto(PhotoModel photoModel) {
		// TODO Auto-generated method stub
		photo_list.add(photoModel);
	}

	/**
	 * Removes a photo from the recipe's photo list
	 * 
	 * @param i
	 *            : Position of the Photo to be removed from the Photo List
	 */
	public void removePhoto(int i) {
		photo_list.remove(i);
	}

	/**
	 * 
	 * @return Name of the recipe
	 */
	public String getName() {
		return name;
	}

	/**
	 * 
	 * @param name
	 *            : Name of the recipe
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * 
	 * @return The description of the recipe
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * 
	 * @param description
	 *            : The description of the recipe
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * 
	 * @return The Ingredient List for the recipe
	 */
	public IngredientListModel getIngredientList() {
		return ingr_list;
	}

	/**
	 * 
	 * @param ingr_list
	 *            The ingredient list for the recipe
	 */
	public void setIngredientList(IngredientListModel ingr_list) {
		this.ingr_list = ingr_list;
	}

	/**
	 * 
	 * @return The instruction list for the recipe
	 */
	public InstructionListModel getInstructionList() {
		return inst_list;
	}

	/**
	 * 
	 * @param inst_lis
	 *            The instruction list for the recipe
	 */
	public void setInstructionList(InstructionListModel inst_lis) {
		this.inst_list = inst_lis;
	}

	/**
	 * 
	 * @return The photo list for the recipe
	 */
	public PhotoListModel getPhotoListModel() {
		return photo_list;
	}

	/**
	 * 
	 * @param p_list
	 *            The photo list for the recipe
	 */
	public void setPhotoList(PhotoListModel p_list) {
		this.photo_list = p_list;
	}

	/**
	 * 
	 * @return Builds a recipe based off what the assistants name, description,
	 *         Ingredient list, and instruction list are
	 */
	public RecipeModel createRecipe() {
		return new RecipeModel(this.name, this.description, this.ingr_list,
				this.inst_list);
	}

	/**
	 * Updates the recipe based off what the assistants name, description,
	 *         Ingredient list, and instruction list are
	 */
	public void updateRecipe() {
		this.recipe = this.createRecipe();
		this.saveToFile();
	}

	/**
	 * Gets the name of and ingredient in the Ingredient list at position i
	 * @param i: the position in the ingredient list for the ingredient
	 * @return The name of the ingredient at position i
	 */
	public String getIngredientListName(int i) {
		return ingr_list.get(i).getIngredientName();
	}

	/**
	 * Gets the Ingredient from the ingredient list at position i
	 * @param i: The position of the ingredient in ingredient list
	 * @return The Ingredient at postion i
	 */
	public IngredientModel getIngredient(int i) {
		return ingr_list.get(i);
	}
	
	/**
	 * Gets the description of and ingredient in the Ingredient list at position i
	 * @param i: the position in the ingredient list for the ingredient
	 * @return The description of the ingredient at position i
	 */
	public String getIngredientListDesc(int i) {
		return ingr_list.get(i).getIngredientDesc();
	}

	/**
	 * Loads the recipe from the temporary file used to pass data between fregments
	 */
	public void loadFromFile() {
		try {
			FileInputStream fileIn = ctx.openFileInput("Recipe.cache");
			ObjectInputStream objectInStream = new ObjectInputStream(fileIn);
			recipe = (RecipeModel) objectInStream.readObject();
			objectInStream.close();
			name = recipe.getRecipeName();
			description = recipe.getRecipeDesc();
			ingr_list = recipe.getIngredList();
			inst_list = recipe.getInstucuctionListModel();
			return;
		} catch (FileNotFoundException FNE) {
			try {
				FileOutputStream temp = ctx.openFileOutput("Recipe.cache",
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
				FileOutputStream temp = ctx.openFileOutput("Recipe.cache",
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
	 * Used to load a recipe from a file with the extension ".recipe"
	 * @param uriIn: The Uri of the ".recipe" file
	 */
	public void loadFromFile(Uri uriIn) {
		try {
			InputStream fileIn = ctx.getContentResolver()
					.openInputStream(uriIn);
			ObjectInputStream objectInStream = new ObjectInputStream(fileIn);
			recipe = (RecipeModel) objectInStream.readObject();
			objectInStream.close();
			fileIn.close();
			name = recipe.getRecipeName();
			description = recipe.getRecipeDesc();
			ingr_list = recipe.getIngredList();
			inst_list = recipe.getInstucuctionListModel();
		} catch (FileNotFoundException FNE) {
			FNE.printStackTrace();
		} catch (NullPointerException NPE) {
			NPE.printStackTrace();
		} catch (ClassNotFoundException cnfe) {
			cnfe.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	/**
	 * Saves RecipeListModel ingred_list to the temporary "Recipe.cache" file for transfer of data between fragments
	 */
	public void saveToFile() {
		try {
			new File("Recipe.cache").delete();
			FileOutputStream fileOut = ctx.openFileOutput("Recipe.cache",
					Context.MODE_PRIVATE);
			ObjectOutputStream objectOutStream = new ObjectOutputStream(fileOut);
			objectOutStream.writeObject(recipe);
			objectOutStream.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Wipes the temporary "Recipe.cache" file
	 */
	public void saveNewToFile() {
		try {
			new File("Recipe.cache").delete();
			FileOutputStream fileOut = ctx.openFileOutput("Recipe.cache",
					Context.MODE_PRIVATE);
			ObjectOutputStream objectOutStream = new ObjectOutputStream(fileOut);
			objectOutStream.writeObject(new RecipeModel("", "",
					new IngredientListModel(), new InstructionListModel()));
			objectOutStream.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Creates a recipe file that can be shared with users through email or other means
	 * @return The path to the file to be shared
	 */
	public String saveToShareFile() {
		try {
			new File(name.replace(" ", "_") + ".recipe").delete();
			File shareFile = new File(
					Environment.getExternalStorageDirectory(), "/"
							+ name.replace(" ", "_") + ".recipe");
			FileOutputStream fileOut = new FileOutputStream(shareFile);
			ObjectOutputStream objectOutStream = new ObjectOutputStream(fileOut);
			objectOutStream.writeObject(recipe);
			objectOutStream.close();
			return shareFile.getAbsolutePath();
		} catch (IOException e) {
			e.printStackTrace();
			return e.toString();
		}
	}
	/**
	 *	Builds a recipe based off what the assistants name, description,
	 *  Ingredient list, and instruction list are.
	 * @return The recipe that was just created
	 */
	public RecipeModel getRecipe() {
		this.createRecipe();
		return recipe;
	}
	
	/**
	 * Gets the instruction for the instruction at position i in the instruction list
	 * @param i: Position of the instruction in the instruction list
	 * @return The instruction at position i
	 */
	public InstructionModel getInstruction(int i) {
		return inst_list.get(i);
	}

	/**
	 * Sets the recipe and updates all the attributes to match the set recipe
	 * @param recipe: The recipe that the assistant is to be set as
	 */
	public void setRecipe(RecipeModel recipe) {
		this.recipe = recipe;
		this.name = recipe.getRecipeName();
		this.description = recipe.getRecipeDesc();
		this.ingr_list = recipe.getIngredList();
		this.inst_list = recipe.getInstucuctionListModel();
	}
	
	/**
	 * Sets the ingredient at position i in the ingredient list to match the variables entered
	 * @param i: Position in the ingredient list that is to be set
	 * @param name: New name of the ingredient
	 * @param description: New description for the ingredient 
	 * @param quantity: New quantity for the ingredient
	 * @param quantityUnit: New unit for the ingredient
	 */

	public void setIngredient(int i, String name, String description,
			float quantity, String quantityUnit) {
			ingr_list.set(i, new IngredientModel(name, description, quantity, quantityUnit));
	}

}
