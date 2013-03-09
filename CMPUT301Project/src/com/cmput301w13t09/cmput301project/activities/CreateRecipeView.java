package com.cmput301w13t09.cmput301project.activities;


import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;

import com.cmput301w13t09.cmput301project.R;
import com.cmput301w13t09.cmput301project.Recipe;

public class CreateRecipeView extends Activity implements OnClickListener {

	Button sqlsave;
	EditText rName, rDesc;

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

	private Recipe createRecipe() {

		// TODO: add picture and other attributes
		Recipe recipe = new Recipe("user", rName.getText().toString(), rDesc.getText().toString() );
		
		// recipe.setCreatorID(Preferences.getUserID(getBaseContext()));

		return recipe;
	}
}
