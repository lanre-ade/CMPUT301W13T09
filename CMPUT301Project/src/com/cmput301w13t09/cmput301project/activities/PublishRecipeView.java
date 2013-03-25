package com.cmput301w13t09.cmput301project.activities;

import com.cmput301w13t09.cmput301project.R;
import com.cmput301w13t09.cmput301project.RecipeController;
import com.cmput301w13t09.cmput301project.RecipeModel;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.AdapterView.OnItemClickListener;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;


public class PublishRecipeView extends Activity {
	private RecipeController recipeController;
	private ListView recipeListView;
	private ListAdapter recipeListAdapter;
	private int dialogNumber;
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_publish_recipe_view);
		
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
				builder.setNeutralButton("Publish",
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
				AlertDialog dialog = builder.create();
				dialog.show();
			}
		});
	}

}
 