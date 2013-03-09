package com.cmput301w13t09.cmput301project.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.cmput301w13t09.cmput301project.R;

public class MainMenuView extends Activity {
	public Button myPantryButton, myRecipesButton;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main_menu_view);
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
