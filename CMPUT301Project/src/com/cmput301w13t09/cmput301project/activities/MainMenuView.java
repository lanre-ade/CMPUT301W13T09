package com.cmput301w13t09.cmput301project.activities;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

import com.cmput301w13t09.cmput301project.DataChecker;
import com.cmput301w13t09.cmput301project.IngredientController;
import com.cmput301w13t09.cmput301project.R;
import com.cmput301w13t09.cmput301project.RecipeController;

/**
 * @author Kyle, Marcus, and Landre
 * Class: MainMenuView
 * MainMenuView is a class thats extends Activity. MainMenuView is used for basic navigation around
 * application it is also a view to fill in information to search for a recipe it will then communicate 
 * with the RecipeController and return the correct Recipe from the RecipeList. 
 */
public class MainMenuView extends Activity {
	public Button myPantryButton, myRecipesButton, searchButton;
	public CheckBox fromMyPantry;
	private RecipeController recipeController;
	private DataChecker checker;
	private EditText searchText;
	private int dialogNumber;
	private IngredientController ingredController;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main_menu_view);
		
		checker = new DataChecker(this);
		checker.checkIfPantryDataExists();
		checker.checkIfRecipeDataExists();
		
		recipeController = new RecipeController(this);
		ingredController = new IngredientController(this);
		
		searchText = (EditText) findViewById(R.id.searchEditText);
		
		myPantryButton = (Button) findViewById(R.id.myPantry);
		myRecipesButton = (Button) findViewById(R.id.myRecipes);
		searchButton = (Button) findViewById(R.id.mainMenuSearchButton);
		
		fromMyPantry = (CheckBox) findViewById(R.id.inPantrySearch);
		
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
		searchButton.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
				if(!fromMyPantry.isChecked()){	
					int position = recipeController.findRecipe(searchText.getText().toString());
					if(position != -1){
						dialogNumber = position;
						AlertDialog.Builder builder = new AlertDialog.Builder(
								MainMenuView.this);
						String title = "Search Successful";
						String message = "Recipe Found: "+recipeController.getRecipeListName(position)+"\n"+recipeController.getRecipeList().get(position).getRecipeDesc();
						builder.setMessage(message);
						builder.setTitle(title);

						builder.setNegativeButton("Cancel",
								new DialogInterface.OnClickListener() {

									@Override
									public void onClick(DialogInterface dialog,
											int which) {
										dialog.dismiss();

									}
								});
						builder.setNeutralButton("View",
								new DialogInterface.OnClickListener() {

									@Override
									public void onClick(DialogInterface dialog,
											int which) {
										try{
											Intent viewRecipe = new Intent("activities.ViewRecipe");
											viewRecipe.putExtra("RECIPE_POSITION", dialogNumber);
											startActivity(viewRecipe);
										} catch (Throwable throwable){
											throwable.printStackTrace();
										}
										dialog.dismiss();

									}
								});
						builder.setPositiveButton("Delete",
								new DialogInterface.OnClickListener() {

									@Override
									public void onClick(DialogInterface dialog,
											int which) {
										recipeController.remove(dialogNumber);
										recipeController.saveToFile();
										dialog.dismiss();

									}
								});

						AlertDialog dialog = builder.create();
						dialog.show();
					}
					else{
						AlertDialog.Builder builder = new AlertDialog.Builder(
								MainMenuView.this);
						String title = "Search Unsuccessful";
						String message = "Recipe does not exist";
						builder.setMessage(message);
						builder.setTitle(title);
						builder.setPositiveButton("Ok",
								new DialogInterface.OnClickListener() {

									@Override
									public void onClick(DialogInterface dialog,
											int which) {
										dialog.dismiss();

									}
								});

						AlertDialog dialog = builder.create();
						dialog.show();
					}
				}
				else{
					int position = recipeController.checkRecipeHasIngredients(recipeController.findRecipe(searchText.getText().toString()),ingredController);
					if(position != -1){
						dialogNumber = position;
						AlertDialog.Builder builder = new AlertDialog.Builder(
								MainMenuView.this);
						String title = "Search Successful";
						String message = "Recipe Found: "+recipeController.getRecipeListName(position)+"\n"+recipeController.getRecipeList().get(position).getRecipeDesc();
						builder.setMessage(message);
						builder.setTitle(title);

						builder.setNegativeButton("Cancel",
								new DialogInterface.OnClickListener() {

									@Override
									public void onClick(DialogInterface dialog,
											int which) {
										dialog.dismiss();

									}
								});
						builder.setNeutralButton("View",
								new DialogInterface.OnClickListener() {

									@Override
									public void onClick(DialogInterface dialog,
											int which) {
										try{
											Intent viewRecipe = new Intent("activities.ViewRecipe");
											viewRecipe.putExtra("RECIPE_POSITION", dialogNumber);
											startActivity(viewRecipe);
										} catch (Throwable throwable){
											throwable.printStackTrace();
										}
										dialog.dismiss();

									}
								});
						builder.setPositiveButton("Delete",
								new DialogInterface.OnClickListener() {

									@Override
									public void onClick(DialogInterface dialog,
											int which) {
										recipeController.remove(dialogNumber);
										recipeController.saveToFile();
										dialog.dismiss();

									}
								});

						AlertDialog dialog = builder.create();
						dialog.show();
					}
					else {
						AlertDialog.Builder builder = new AlertDialog.Builder(
								MainMenuView.this);
						String title = "Search Unsuccessful";
						String message = "Recipe does not exist or Ingredient from Recipe is not in MyPantry";
						builder.setMessage(message);
						builder.setTitle(title);
						builder.setPositiveButton("Ok",
								new DialogInterface.OnClickListener() {

									@Override
									public void onClick(DialogInterface dialog,
											int which) {
										dialog.dismiss();

									}
								});

						AlertDialog dialog = builder.create();
						dialog.show();
					}
				}	
			}
		});
		
	}
}
