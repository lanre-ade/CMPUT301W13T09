package com.cmput301w13t09.cmput301project.activities;

import java.io.IOException;

import org.json.JSONException;

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
import android.widget.ListAdapter;
import android.widget.ListView;

import com.cmput301w13t09.cmput301project.R;
import com.cmput301w13t09.cmput301project.controllers.RecipeController;
import com.cmput301w13t09.cmput301project.controllers.WebController;
import com.cmput301w13t09.cmput301project.models.RecipeModel;



public class PublishRecipeView extends Activity {
	private RecipeController recipeController;
	private WebController webController;
	private ListView recipeListView;
	private ListAdapter recipeListAdapter;
	private int dialogNumber;
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_publish_recipe_view);
		if (android.os.Build.VERSION.SDK_INT > 9) {
		      StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
		      StrictMode.setThreadPolicy(policy);
		    }
		
		recipeController = new RecipeController(this);
		
		recipeListView = (ListView) findViewById(R.id.recipesListForPublish);
		recipeListAdapter = new ArrayAdapter<RecipeModel>(this,
				android.R.layout.simple_list_item_1,
				recipeController.getRecipeList());
		recipeListView.setAdapter(recipeListAdapter);
		
		recipeListView.setOnItemClickListener(new OnItemClickListener() {
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				dialogNumber = position;
				AlertDialog.Builder builder = new AlertDialog.Builder(
						PublishRecipeView.this);
				String title = recipeController.getRecipeListName(position);
				String message = recipeController.getRecipeList().get(position).getRecipeDesc();
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
				builder.setPositiveButton("Publish",
						new DialogInterface.OnClickListener() {

							@Override
							public void onClick(DialogInterface dialog,
									int which) {
								try {
									webController = new WebController();
									webController.insertRecipe(recipeController.getRecipeList().get(dialogNumber));
								} catch (IllegalStateException e) {
									e.printStackTrace();
								} catch (IOException e) {
									e.printStackTrace();
								} catch (JSONException e) {
									e.printStackTrace();
								}
								dialog.dismiss();

							}
						});
				AlertDialog dialog = builder.create();
				dialog.show();
			}
		});
	}
}
 