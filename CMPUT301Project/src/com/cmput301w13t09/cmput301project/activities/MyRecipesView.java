package com.cmput301w13t09.cmput301project.activities;


import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;

import com.cmput301w13t09.cmput301project.R;
import com.cmput301w13t09.cmput301project.RecipeController;
import com.cmput301w13t09.cmput301project.RecipeModel;

public class MyRecipesView extends Activity {

	private ListAdapter recipeListAdapter;
	private ListView recipeListView;
	private int dialogNumber;
	private RecipeController recipeController;
	private Button addRecipeButton;

	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_my_recipes_view);
		
		recipeController = new RecipeController();
		
		recipeListView = (ListView) findViewById(R.id.myRecipesList);
		recipeListAdapter = new ArrayAdapter<RecipeModel>(this, android.R.layout.simple_list_item_1, recipeController.getRecipeList());
		
		
	}
}

