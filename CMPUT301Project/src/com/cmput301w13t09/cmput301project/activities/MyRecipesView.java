package com.cmput301w13t09.cmput301project.activities;


import android.app.Activity;
import android.app.LoaderManager;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.content.CursorLoader;
import android.content.Intent;

import com.cmput301w13t09.cmput301project.R;
import com.cmput301w13t09.cmput301project.RecipeDBAdapter;

public class MyRecipesView extends Activity {

	
	private ListView recipeListView;
	
	private RecipeDBAdapter _dbHelper;
	private Cursor _cursor;
	private SimpleCursorAdapter adapter;
	//private CursorLoader adaptr;
	//private LoaderManager managr;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.activity_my_recipes_view);
		recipeListView = (ListView) findViewById(R.id.myRecipesList);
		Button b = (Button) findViewById(R.id.createRecipeButton);
		b.setOnClickListener(new OnClickListener() {

		/*
		public void onClick(View v) {
				Intent intent = new Intent(getApplicationContext(),
						CreateRecipeView.class);
				startActivity(intent);
			}
		*/
			
			@Override
			public void onClick(View v) {
				try {
					Intent viewCreateRecipe = new Intent("activities.CreateRecipe");
					startActivity(viewCreateRecipe);
				} catch(Throwable e) {
					e.printStackTrace();
				}
			}
			
		});
		
		_dbHelper = new RecipeDBAdapter(this);
	}
/*
	protected void onStart() {
		super.onStart();
		
		_dbHelper.open();
		//fillData();
	}

	protected void onStop() {
		super.onStop();
		_dbHelper.close();
		_cursor.close();
	}
*/
	
	/**
	 * Fill the recipe list view with recipes
	 */
	@SuppressWarnings("deprecation")
	private void fillData() {

		_cursor = _dbHelper.fetchAllRecipes();
		startManagingCursor(_cursor);

		String[] from = new String[] { RecipeDBAdapter.RECIPE, RecipeDBAdapter.PROCEDURE };
		int[] to = new int[] { R.id.recipe_name, R.id.recipe_desc};

		//adapter = new SimpleCursorAdapter(this, R.layout.recipe_list_row, _cursor,
			//	from, to);
		
		adapter = new SimpleCursorAdapter(this,
	            R.layout.recipe_list_row, _cursor,
	            from, to, 0);
	    recipeListView.setAdapter(adapter);


		stopManagingCursor(_cursor);

	}

}

