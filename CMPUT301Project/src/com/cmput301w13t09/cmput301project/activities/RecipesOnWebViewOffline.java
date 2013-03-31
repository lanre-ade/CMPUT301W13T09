package com.cmput301w13t09.cmput301project.activities;

import com.cmput301w13t09.cmput301project.CacheController;
import com.cmput301w13t09.cmput301project.IngredientController;
import com.cmput301w13t09.cmput301project.R;
import com.cmput301w13t09.cmput301project.RecipeController;
import com.cmput301w13t09.cmput301project.RecipeModel;

import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.AdapterView.OnItemClickListener;

public class RecipesOnWebViewOffline extends Activity {
	private ListView recipeListView;
	private ListAdapter recipeListAdapter;
	private int dialogNumber;
	private RecipeController recipeController;
	private EditText searchText;
	private CheckBox fromMyPantry;
	private Button searchButton;
	private IngredientController ingredController;
	private CacheController cacheController;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_recipes_on_web_view_offline);
		searchText = (EditText) findViewById(R.id.WebOfflinesearchEditText);
		fromMyPantry = (CheckBox) findViewById(R.id.WebOfflineinPantrySearch);
		searchButton = (Button) findViewById(R.id.WebOfflineSearchButton);
		recipeController = new RecipeController(this);
		ingredController = new IngredientController(this);
		cacheController = new CacheController(this);
		recipeListView = (ListView) findViewById(R.id.webOfflineserviceRecipelistView);
		recipeListAdapter = new ArrayAdapter<RecipeModel>(this,
				android.R.layout.simple_list_item_1,
				cacheController.getRecipeList());
		recipeListView.setAdapter(recipeListAdapter);

		recipeListView.setOnItemClickListener(new OnItemClickListener() {
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				dialogNumber = position;
				AlertDialog.Builder builder = new AlertDialog.Builder(
						RecipesOnWebViewOffline.this);
				String title = cacheController.getRecipeListName(position);
				String message = cacheController.getRecipeList().get(position)
						.getRecipeDesc();
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
								try {
									Intent viewRecipe = new Intent(
											"activities.RecipeOnlineView");
									viewRecipe.putExtra("Recipe",
											cacheController.getRecipe(dialogNumber));
									startActivity(viewRecipe);
								} catch (Throwable throwable) {
									throwable.printStackTrace();
								}
								dialog.dismiss();

							}
						});
				builder.setPositiveButton("Import Recipe",
						new DialogInterface.OnClickListener() {

							@Override
							public void onClick(DialogInterface dialog,
									int which) {
								recipeController.addRecipe(cacheController
										.getRecipeList().get(dialogNumber));
								recipeController.saveToFile();
								dialog.dismiss();
							}
						});

				AlertDialog dialog = builder.create();
				dialog.show();
			}
		});
		searchButton.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub

				if (!fromMyPantry.isChecked()) {
					int position = cacheController.findRecipe(searchText
							.getText().toString());
					if (position != -1) {
						dialogNumber = position;
						AlertDialog.Builder builder = new AlertDialog.Builder(
								RecipesOnWebViewOffline.this);
						String title = "Search Successful";
						String message = "Recipe Found: "
								+ cacheController.getRecipeListName(position)
								+ "\n"
								+ cacheController.getRecipeList().get(position)
										.getRecipeDesc();
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
										try {
											Intent viewRecipe = new Intent(
													"activities.ViewRecipe");
											viewRecipe.putExtra(
													"RECIPE_POSITION",
													dialogNumber);
											startActivity(viewRecipe);
										} catch (Throwable throwable) {
											throwable.printStackTrace();
										}
										dialog.dismiss();

									}
								});
						builder.setPositiveButton("Import Recipe",
								new DialogInterface.OnClickListener() {

									@Override
									public void onClick(DialogInterface dialog,
											int which) {
										recipeController
												.addRecipe(cacheController
														.getRecipeList().get(
																dialogNumber));
										recipeController.saveToFile();
										dialog.dismiss();

									}
								});

						AlertDialog dialog = builder.create();
						dialog.show();
					} else {
						AlertDialog.Builder builder = new AlertDialog.Builder(
								RecipesOnWebViewOffline.this);
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
				} else {
					int position = cacheController.checkRecipeHasIngredients(
							cacheController.findRecipe(searchText.getText()
									.toString()), ingredController);
					if (position != -1) {
						dialogNumber = position;
						AlertDialog.Builder builder = new AlertDialog.Builder(
								RecipesOnWebViewOffline.this);
						String title = "Search Successful";
						String message = "Recipe Found: "
								+ cacheController.getRecipeListName(position)
								+ "\n"
								+ cacheController.getRecipeList().get(position)
										.getRecipeDesc();
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
										try {
											Intent viewRecipe = new Intent(
													"activities.ViewRecipe");
											viewRecipe.putExtra(
													"RECIPE_POSITION",
													dialogNumber);
											startActivity(viewRecipe);
										} catch (Throwable throwable) {
											throwable.printStackTrace();
										}
										dialog.dismiss();

									}
								});
						builder.setPositiveButton("Import Recipe",
								new DialogInterface.OnClickListener() {

									@Override
									public void onClick(DialogInterface dialog,
											int which) {
										recipeController
												.addRecipe(cacheController
														.getRecipeList().get(
																dialogNumber));
										recipeController.saveToFile();
										dialog.dismiss();

									}
								});

						AlertDialog dialog = builder.create();
						dialog.show();
					} else {
						AlertDialog.Builder builder = new AlertDialog.Builder(
								RecipesOnWebViewOffline.this);
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
