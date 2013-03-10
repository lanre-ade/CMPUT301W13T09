package com.cmput301w13t09.cmput301project.activities;

import java.util.ArrayList;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import com.cmput301w13t09.cmput301project.R;

public class CreateRecipeView extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_create_recipe_view);
		// Widgets Setup
		final EditText CreateRecipe_Name = (EditText) findViewById(R.id.CreateRecipeViewNameForm);
		final EditText CreateRecipe_Desc = (EditText) findViewById(R.id.CreateRecipeViewDescForm);
		Button CreateRecipe_Submit = (Button) findViewById(R.id.CreateRecipeViewSubmit);
		Button CreateRecipe_DeleteIng = (Button) findViewById(R.id.CreateRecipeViewDeleteIngredient);
		Button CreateRecipe_AddIng = (Button) findViewById(R.id.CreateRecipeViewAddNewIngredient);
		final ListView CreateRecipelist = (ListView) findViewById(R.id.CreateRecipeViewIngListActual);
		final TextView message = (TextView) findViewById(R.id.CreateRecipeUserMessage);
		
		//ListView Setup
		final ArrayList<String> listArray = new ArrayList<String>();
		listArray.add("hiiii");
		listArray.add("hiiii2");
		listArray.add("hiiii3");
		listArray.add("hiiii4");
		final ArrayAdapter<String> adapter;
		adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, listArray);
		CreateRecipelist.setAdapter(adapter);
		
		
		CreateRecipe_AddIng.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				;
			}
		});
		CreateRecipe_DeleteIng.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				;
			}
		});
		CreateRecipe_Submit.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				;
			}
		});
	}
	
	
	

}
