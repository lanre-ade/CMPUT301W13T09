package com.cmput301w13t09.cmput301project.activities;


import android.app.Activity;
import android.app.LoaderManager;
import android.database.Cursor;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.content.CursorLoader;
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
		
		_dbHelper = new RecipeDBAdapter(this);
	}

	protected void onStart() {
		super.onStart();
		
		_dbHelper.open();
		fillData();
	}

	protected void onStop() {
		super.onStop();
		_dbHelper.close();
		_cursor.close();
	}
	/**
	 * Fill the recipe list view with recipes
	 */
	@SuppressWarnings("deprecation")
	private void fillData() {

		_cursor = _dbHelper.fetchAllRecipes();
		startManagingCursor(_cursor);

		String[] from = new String[] { RecipeDBAdapter.ID,
				RecipeDBAdapter.RECIPE, RecipeDBAdapter.USER,
				RecipeDBAdapter.DATE, RecipeDBAdapter.PROCEDURE };
		int[] to = new int[] { R.id.recipe_name, R.id.recipe_name};

		adapter = new SimpleCursorAdapter(this, R.layout.recipe_list_row, _cursor,
				from, to);
		
		adapter = new SimpleCursorAdapter(this,
	            R.layout.recipe_list_row, _cursor,
	            from, to, 0);
	    recipeListView.setAdapter(adapter);


		stopManagingCursor(_cursor);

	}

}

