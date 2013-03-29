package com.cmput301w13t09.cmput301project;

import java.io.File;
import java.io.IOException;

import android.content.Context;

/**
 * @author Kyle, Marcus, Landre Class: DataChecker DataChecker is a class that
 *         takes in the context of an activity and checks whether or not a file
 *         has been created or not. If a file doesnt exist it creates it
 */
public class DataChecker {
	private Context ctx;

	public DataChecker(Context tctx) {
		ctx = tctx;
	}

	/**
	 * Function that checks whether Recipe.data exists
	 */
	public void checkIfRecipeDataExists() {
		File file = ctx.getFileStreamPath("Recipe.data");
		if (file.exists())
			return;
		else {
			try {
				file.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return;
		}
	}

	/**
	 * Function that checks whether Pantry.data
	 */
	public void checkIfPantryDataExists() {
		File file = ctx.getFileStreamPath("Pantry.data");
		if (file.exists())
			return;
		else {
			try {
				file.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return;
		}
	}

}
