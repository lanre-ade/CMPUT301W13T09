package com.cmput301w13t09.cmput301project;

import java.io.File;
import java.io.IOException;

import android.content.Context;

public class DataChecker {
	private Context ctx;
	
	public DataChecker(Context tctx){
		ctx = tctx;
	}
	
	public void checkIfRecipeDataExists() {
		File file = ctx.getFileStreamPath("Recipe.data");
		if(file.exists())
			return;
		else{
			try {
				file.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return;
		}
	}
	
	public void checkIfPantryDataExists(){
		File file = ctx.getFileStreamPath("Pantry.data");
		if(file.exists())
			return;
		else{
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
