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
	private EditText createRecipe_Name, createRecipe_Desc;
	private Button createRecipe_Submit, createRecipe_DeleteIng, createRecipe_AddIng;
	private ListView createRecipelist;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_create_recipe_view);
		// Widgets Setup
		createRecipe_Name = (EditText) findViewById(R.id.CreateRecipeViewNameForm);
		createRecipe_Desc = (EditText) findViewById(R.id.CreateRecipeViewDescForm);
		createRecipe_Submit = (Button) findViewById(R.id.CreateRecipeViewSubmit);
		createRecipe_DeleteIng = (Button) findViewById(R.id.CreateRecipeViewDeleteIngredient);
		createRecipe_AddIng = (Button) findViewById(R.id.CreateRecipeViewAddNewIngredient);
		createRecipelist = (ListView) findViewById(R.id.CreateRecipeViewIngListActual);
		final TextView message = (TextView) findViewById(R.id.CreateRecipeUserMessage);
		
		//ListView Setup
		final ArrayList<String> listArray = new ArrayList<String>();
		listArray.add("hiiii");
		listArray.add("hiiii2");
		listArray.add("hiiii3");
		listArray.add("hiiii4");
		final ArrayAdapter<String> adapter;
		adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, listArray);
		createRecipelist.setAdapter(adapter);
		
		
		createRecipe_AddIng.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				;
			}
		});
		createRecipe_DeleteIng.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				;
			}
		});
		createRecipe_Submit.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				;
			}
		});
	}
	
	
	

}
