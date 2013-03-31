package com.cmput301w13t09.cmput301project.activities;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;

import com.cmput301w13t09.cmput301project.CacheController;
import com.cmput301w13t09.cmput301project.IngredientController;
import com.cmput301w13t09.cmput301project.R;
import com.cmput301w13t09.cmput301project.RecipeController;
import com.cmput301w13t09.cmput301project.UploadController;
import com.cmput301w13t09.cmput301project.models.RecipeModel;

public class RecipesOnWebView extends Activity {
	private ListView recipeListView;
	private ListAdapter recipeListAdapter;
	private UploadController webController;
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

		setContentView(R.layout.activity_recipes_on_web_view);
		searchText = (EditText) findViewById(R.id.WebsearchEditText);
		fromMyPantry = (CheckBox) findViewById(R.id.WebinPantrySearch);
		searchButton = (Button) findViewById(R.id.WebSearchButton);
		if (android.os.Build.VERSION.SDK_INT > 9) {
			StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder()
					.permitAll().build();
			StrictMode.setThreadPolicy(policy);
		}
		try {
			recipeController = new RecipeController(this);
			ingredController = new IngredientController(this);
			webController = new UploadController();
			cacheController = new CacheController(this);
			cacheController.setRecipeListModel(webController.getRecipeList());
			cacheController.saveToFile();
			recipeListView = (ListView) findViewById(R.id.webserviceRecipelistView);
			recipeListAdapter = new ArrayAdapter<RecipeModel>(this,
					android.R.layout.simple_list_item_1,
					webController.getRecipeList());
			recipeListView.setAdapter(recipeListAdapter);
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		recipeListView.setOnItemClickListener(new OnItemClickListener() {
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				dialogNumber = position;
				AlertDialog.Builder builder = new AlertDialog.Builder(
						RecipesOnWebView.this);
				String title = webController.getRecipeListName(position);
				String message = webController.getRecipeList().get(position)
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
											webController.getRecipe(dialogNumber));
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
								recipeController.addRecipe(webController
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
					int position = webController.findRecipe(searchText
							.getText().toString());
					if (position != -1) {
						dialogNumber = position;
						AlertDialog.Builder builder = new AlertDialog.Builder(
								RecipesOnWebView.this);
						String title = "Search Successful";
						String message = "Recipe Found: "
								+ webController.getRecipeListName(position)
								+ "\n"
								+ webController.getRecipeList().get(position)
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
												.addRecipe(webController
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
								RecipesOnWebView.this);
						String title = "Search Unsuccessful";
						String message = "Recipe does not exist";
						builder.setMessage(message);
						builder.setTitle(title);
						// builder.setPositiveButton("Ok",
						// new DialogInterface.OnClickListener() {
						//
						// @Override
						// public void onClick(DialogInterface dialog,
						// int which) {
						// dialog.dismiss();
						//
						// }
						// });

						AlertDialog dialog = builder.create();
						dialog.show();
					}
				} else {
					int position = webController.checkRecipeHasIngredients(
							webController.findRecipe(searchText.getText()
									.toString()), ingredController);
					if (position != -1) {
						dialogNumber = position;
						AlertDialog.Builder builder = new AlertDialog.Builder(
								RecipesOnWebView.this);
						String title = "Search Successful";
						String message = "Recipe Found: "
								+ webController.getRecipeListName(position)
								+ "\n"
								+ webController.getRecipeList().get(position)
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
												.addRecipe(webController
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
								RecipesOnWebView.this);
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