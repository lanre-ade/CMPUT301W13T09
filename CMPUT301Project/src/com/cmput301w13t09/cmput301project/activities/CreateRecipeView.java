package com.cmput301w13t09.cmput301project.activities;


import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;

import com.cmput301w13t09.cmput301project.R;
import com.cmput301w13t09.cmput301project.Recipe;
import com.cmput301w13t09.cmput301project.RecipeDBAdapter;

public class CreateRecipeView extends Activity implements OnClickListener {

	Button sqlsave;
	EditText rName, rDesc;

	Context context;
	RecipeDBAdapter _dbHelper = new RecipeDBAdapter(context);
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		// this.requestWindowFeature(Window.FEATURE_NO_TITLE);

		setContentView(R.layout.activity_create_recipe_view);
		sqlsave = (Button) findViewById(R.id.button1);
		rName = (EditText) findViewById(R.id.editText1);
		rDesc = (EditText) findViewById(R.id.editText2);
		sqlsave.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		createRecipe();
		finish();

	}

	private void createRecipe() {

		// TODO: add picture and other attributes
		Recipe recipe = new Recipe("user", rName.getText().toString(), rDesc.getText().toString() );
		_dbHelper.open();
		long value = _dbHelper.createRecipe(recipe);
		Log.d("RequestCreateTask", "create: " + value);
		_dbHelper.close();
		// recipe.setCreatorID(Preferences.getUserID(getBaseContext()));

	}
}
