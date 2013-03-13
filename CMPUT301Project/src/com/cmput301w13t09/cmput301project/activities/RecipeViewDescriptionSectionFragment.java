package com.cmput301w13t09.cmput301project.activities;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.cmput301w13t09.cmput301project.RecipeViewAssistant;
import com.cmput301w13t09.cmput301project.R;

/**
 * A fragment representing the display section of the create new recipe.
 */
public class RecipeViewDescriptionSectionFragment extends Fragment {
	public EditText nameEditText, descriptionEditText;
	private RecipeViewAssistant builder;
	private Button descriptionSetButton;

	public RecipeViewDescriptionSectionFragment() {
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// Create a new TextView and set its text to the fragment's section
		// number argument value.
		View tabView = inflater.inflate(
				R.layout.activity_add_new_recipe_description_tab,
				container, false);
		builder = new RecipeViewAssistant(getActivity());
		nameEditText = (EditText) tabView
				.findViewById(R.id.addNewRecipeNameEditText);
		descriptionEditText = (EditText) tabView
				.findViewById(R.id.addNewRecipeDescriptionEditText);
		descriptionSetButton = (Button) tabView
				.findViewById(R.id.addNewRecipeDescriptionButtonSet);
		descriptionSetButton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				builder.loadFromFile();
				Toast t = Toast.makeText(getActivity(), "Name and Description set", Toast.LENGTH_SHORT);
				t.show();
				builder.setName(nameEditText.getText().toString());
				builder.setDescription(descriptionEditText.getText().toString());
				builder.updateRecipe();
				builder.saveToFile();
			}
		});
		return tabView;
	}
	public void OnDetach(){
		Toast t = Toast.makeText(getActivity(), "Called On Detach", Toast.LENGTH_LONG);
		t.show();
		builder.setName(nameEditText.getText().toString());
		builder.setDescription(descriptionEditText.getText().toString());
		builder.updateRecipe();
		builder.saveToFile();
	}
	
	public void OnStop(){
		Toast t = Toast.makeText(getActivity(), "Called On Destroy", Toast.LENGTH_LONG);
		t.show();
		builder.setName(nameEditText.getText().toString());
		builder.setDescription(descriptionEditText.getText().toString());
		builder.updateRecipe();
		builder.saveToFile();
	}

}
