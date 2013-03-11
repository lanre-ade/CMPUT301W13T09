package com.cmput301w13t09.cmput301project.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.cmput301w13t09.cmput301project.DataChecker;
import com.cmput301w13t09.cmput301project.R;

/**
 * @author Kyle, Marcus, and Landre
 * Class: MainMenuView
 * MainMenuView is a class thats extends Activity. MainMenuView is used for basic navigation around
 * application it is also a view to fill in information to search for a recipe it will then communicate 
 * with the RecipeController and return the correct Recipe from the RecipeList. 
 */
public class MainMenuView extends Activity {
	public Button myPantryButton, myRecipesButton;
	private DataChecker checker;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main_menu_view);
		
		checker = new DataChecker(this);
		checker.checkIfPantryDataExists();
		checker.checkIfRecipeDataExists();
		
		myPantryButton = (Button) findViewById(R.id.myPantry);
		myRecipesButton = (Button) findViewById(R.id.myRecipes);
		
		myPantryButton.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				try {
					Intent viewMyPantry = new Intent("activities.MyPantry");
					startActivity(viewMyPantry);
				} catch(Throwable e) {
					e.printStackTrace();
				}
			}
		});
		
		myRecipesButton.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				try {
					Intent viewMyRecipes = new Intent("activities.MyRecipes");
					startActivity(viewMyRecipes);
				} catch(Throwable e) {
					e.printStackTrace();
				}				
			}
		});
	}
}
