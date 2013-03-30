package com.cmput301w13t09.cmput301project.activities;

import java.io.IOException;
import org.apache.http.client.ClientProtocolException;

import com.cmput301w13t09.cmput301project.CacheController;
import com.cmput301w13t09.cmput301project.IngredientController;
import com.cmput301w13t09.cmput301project.R;
import com.cmput301w13t09.cmput301project.RecipeController;
import com.cmput301w13t09.cmput301project.RecipeListModel;
import com.cmput301w13t09.cmput301project.RecipeModel;
import com.cmput301w13t09.cmput301project.UploadController;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.os.StrictMode;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

public class QueryRecipeView extends Activity {
	private ListAdapter recipeListAdapter;
	private ListView recipeListView;
	private UploadController webController;
	private IngredientController ingredController;
	private int dialogNumber;
	private RecipeListModel queryrecipelist;
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
				webController = new UploadController();
			} catch (ClientProtocolException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			queryrecipelist = webController.getQueryRecipeList(ingredController);
		}
		else{
			cacheController = new CacheController(this);
			queryrecipelist = cacheController.getQueryRecipeList(ingredController);
		}
		
		
		recipeListView = (ListView) findViewById(R.id.queryRecipelistView);
		recipeListAdapter = new ArrayAdapter<RecipeModel>(this,
				android.R.layout.simple_list_item_1,
				queryrecipelist);

		recipeListView.setAdapter(recipeListAdapter);
		recipeListView.setOnItemClickListener(new OnItemClickListener() {
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				dialogNumber = position;
				AlertDialog.Builder builder = new AlertDialog.Builder(
						QueryRecipeView.this);
				String title = queryrecipelist.get(position).getRecipeName();
				String message = queryrecipelist.get(position).getRecipeDesc();
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
								recipeController.addRecipe(queryrecipelist.get(dialogNumber));
								recipeController.saveToFile();
								dialog.dismiss();

							}
						});
				AlertDialog dialog = builder.create();
				dialog.show();
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_query_recipe_view, menu);
		return true;
	}
	/**
	 * Checks if networks is available
	 * @return boolean
	 */
	private boolean isNetworkAvailable() {
	    ConnectivityManager connectivityManager 
	          = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
	    NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
	    return activeNetworkInfo != null && activeNetworkInfo.isConnected();
	}

}
