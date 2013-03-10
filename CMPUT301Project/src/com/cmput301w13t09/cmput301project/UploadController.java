package com.cmput301w13t09.cmput301project;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import android.content.Context;

public class UploadController {

	@SuppressWarnings("unchecked")
	public void UploadRecipeList(Context ctx){
	try {
		FileInputStream fileIn = ctx.openFileInput("Recipe.log");
		ObjectInputStream objectInStream = new ObjectInputStream(fileIn);
		ArrayList<RecipeModel> recipe_list = (ArrayList<RecipeModel>) objectInStream.readObject();
		objectInStream.close();
	} catch (FileNotFoundException FNE) {
		try {
			FileOutputStream temp = ctx.openFileOutput("Recipe.log", Context.MODE_PRIVATE);
			ObjectOutputStream objectOutStream = new ObjectOutputStream(temp);
			objectOutStream.writeObject(null);
			objectOutStream.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
	} catch (NullPointerException NPE) {
		try {
			FileOutputStream temp = ctx.openFileOutput("Recipe.log", Context.MODE_PRIVATE);
			ObjectOutputStream objectOutStream = new ObjectOutputStream(temp);
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
