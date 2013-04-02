package com.cmput301w13t09.cmput301project.activities;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

import com.cmput301w13t09.cmput301project.R;
import com.cmput301w13t09.cmput301project.controllers.CacheController;
import com.cmput301w13t09.cmput301project.controllers.IngredientController;
import com.cmput301w13t09.cmput301project.controllers.RecipeController;
import com.cmput301w13t09.cmput301project.controllers.WebController;
import com.cmput301w13t09.cmput301project.models.RecipeListModel;
import com.cmput301w13t09.cmput301project.models.RecipeModel;

public class QueryRecipeView extends Activity {
	private ListAdapter recipeListAdapter;
	private ListView recipeListView;
	private WebController webController;
	private IngredientController ingredController;
	private int dialogNumber;
	private RecipeListModel queryRecipeList;
	private RecipeController recipeController;
	private CacheController cacheController;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		recipeController = new RecipeController(this);
		ingredController = new IngredientController(this);
		setContentView(R.layout.activity_query_recipe_view);
		
		if (android.os.Build.VERSION.SDK_INT > 9) {
			StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder()
					.permitAll().build();
			StrictMode.setThreadPolicy(policy);
		}
		if(isNetworkAvailable()){
			try {
				webController = new WebController();
			} catch (ClientProtocolException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			queryRecipeList = webController.getQueryRecipeList(ingredController);
		}
		else{
			cacheController = new CacheController(this);
			queryRecipeList = cacheController.getQueryRecipeList(ingredController);
		}
		
		
		recipeListView = (ListView) findViewById(R.id.queryRecipelistView);
		recipeListAdapter = new ArrayAdapter<RecipeModel>(this,
				android.R.layout.simple_list_item_1,
				queryRecipeList);

		recipeListView.setAdapter(recipeListAdapter);
		recipeListView.setOnItemClickListener(new OnItemClickListener() {
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				dialogNumber = position;
				AlertDialog.Builder builder = new AlertDialog.Builder(
						QueryRecipeView.this);
				String title = queryRecipeList.get(position).getRecipeName();
				String message = queryRecipeList.get(position).getRecipeDesc();
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
							viewRecipe.putExtra(
									"Recipe", queryRecipeList.get(dialogNumber));
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
								recipeController.addRecipe(queryRecipeList.get(dialogNumber));
								recipeController.saveToFile();
								dialog.dismiss();

							}
						});
				AlertDialog dialog = builder.create();
				dialog.show();
			}
		});
	}

	/**
	 * Checks if networks is available
	 * 
	 * @return boolean
	 */
	private boolean isNetworkAvailable() {
		ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
		NetworkInfo activeNetworkInfo = connectivityManager
				.getActiveNetworkInfo();
		return activeNetworkInfo != null && activeNetworkInfo.isConnected();
	}

}
