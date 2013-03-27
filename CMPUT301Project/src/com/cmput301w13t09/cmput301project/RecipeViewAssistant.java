package com.cmput301w13t09.cmput301project;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import android.content.Context;
import android.os.Environment;

public class RecipeViewAssistant {
	private Context ctx;
	private IngredientListModel ingr_list;
	private InstructionListModel inst_list;
	private String name, description;
	private RecipeModel recipe;
	private PhotoListModel photo_list;

	// private PhotoListModel photo_list;

	public RecipeViewAssistant(Context ctx) {
		this.setIngredientList(new IngredientListModel());
		this.setInstructionList(new InstructionListModel());
		this.ctx = ctx;
		// photo_list = new PhotoListModel();
	}

	public void addIngredient(IngredientModel ing) {
		ingr_list.add(ing);
	}

	public void removeIngredient(int i) {
		ingr_list.remove(i);
	}

	public void addInstruction(InstructionModel ins) {
		inst_list.add(ins);
	}

	public void removeInstruction(int i) {
		inst_list.remove(i);
	}
	public void addPhoto(PhotoModel photoModel) {
		// TODO Auto-generated method stub
		photo_list.add(photoModel);
	}
	public void removePhoto(int i){
		photo_list.remove(i);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public IngredientListModel getIngredientList() {
		return ingr_list;
	}

	public void setIngredientList(IngredientListModel ingr_list) {
		this.ingr_list = ingr_list;
	}

	public InstructionListModel getInstructionList() {
		return inst_list;
	}

	public void setInstructionList(InstructionListModel inst_lis) {
		this.inst_list = inst_lis;
	}
	
	public PhotoListModel getPhotoListModel(){
		return photo_list;
	}
	
	public void setPhotoList(PhotoListModel p_list){
		this.photo_list = p_list;
	}

	public RecipeModel createRecipe() {
		return new RecipeModel(this.name, this.description, this.ingr_list,
				this.inst_list);
	}

	public void updateRecipe() {
		this.recipe = this.createRecipe();
		this.saveToFile();
	}

	public String getIngredientListName(int i) {
		return ingr_list.get(i).getIngredientName();
	}

	public IngredientModel getIngredient(int i) {
		return ingr_list.get(i);
	}

	public String getIngredientListDesc(int i) {
		return ingr_list.get(i).getIngredientDesc();
	}

	public void editIngredient(int i, String tname, String tDescription,
			float tQuantity, String tUnit) {
		ingr_list.set(i, new IngredientModel(tname, tDescription, tQuantity,
				tUnit));
	}

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
	 * Saves RecipeListModel ingred_list to file Recipe.data
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
	public String saveToShareFile() {
		try {
			new File(Environment.getExternalStorageDirectory()+"/"+name.replace(" ", "_")+".recipe").delete();
			File shareFile = new File(Environment.getExternalStorageDirectory()+"/"+name.replace(" ", "_")+".recipe");
			FileOutputStream fileOut = new FileOutputStream(shareFile);
			ObjectOutputStream objectOutStream = new ObjectOutputStream(fileOut);
			objectOutStream.writeObject(new RecipeModel("", "",
					new IngredientListModel(), new InstructionListModel()));
			objectOutStream.close();
			return new File(Environment.getExternalStorageDirectory()+"/"+name.replace(" ", "_")+".recipe").getAbsolutePath();
		} catch (IOException e) {
			e.printStackTrace();
			return e.toString();
		}
//		return "fails";
	}
	public RecipeModel getRecipe() {
		this.createRecipe();
		return recipe;
	}


	public InstructionModel getInstruction(int position) {
		return inst_list.get(position);
	}

	public void setRecipe(RecipeModel recipe) {
		this.recipe = recipe;
		this.name = recipe.getRecipeName();
		this.description = recipe.getRecipeDesc();
		this.ingr_list = recipe.getIngredList();
		this.inst_list = recipe.getInstucuctionListModel();
	}


}
