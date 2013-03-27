package com.cmput301w13t09.cmput301project.activities;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;

import com.cmput301w13t09.cmput301project.IngredientController;
import com.cmput301w13t09.cmput301project.R;
import com.cmput301w13t09.cmput301project.RecipeModel;
import com.cmput301w13t09.cmput301project.UploadController;

import android.os.Bundle;
import android.os.StrictMode;
import android.app.Activity;
import android.view.Menu;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

public class QueryRecipeView extends Activity {
	private ListAdapter recipeListAdapter;
	private ListView recipeListView;
	private UploadController webController;
	private IngredientController ingredController;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		ingredController = new IngredientController(this);
		setContentView(R.layout.activity_query_recipe_view);
		if (android.os.Build.VERSION.SDK_INT > 9) {
			StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder()
					.permitAll().build();
			StrictMode.setThreadPolicy(policy);
		}
		try {
			webController = new UploadController();
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		recipeListView = (ListView) findViewById(R.id.queryRecipelistView);
		recipeListAdapter = new ArrayAdapter<RecipeModel>(this,
				android.R.layout.simple_list_item_1,
				webController.getQueryRecipeList(ingredController));

		recipeListView.setAdapter(recipeListAdapter);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_query_recipe_view, menu);
		return true;
	}

}
