package com.cmput301w13t09.cmput301project.activities;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.cmput301w13t09.cmput301project.R;
import com.cmput301w13t09.cmput301project.RecipeViewAssistant;

/**
 * A fragment representing the display section of the create new recipe.
 */
public class RecipeViewDescriptionSectionFragment extends Fragment {
	private RecipeViewAssistant assistant;
	private TextView textViewName, textViewDescription; 
	
	
	public RecipeViewDescriptionSectionFragment() {
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// Create a new TextView and set its text to the fragment's section
		// number argument value.
		View tabView = inflater.inflate(
				R.layout.view_recipe_description_tab,
				container, false);
		assistant = new RecipeViewAssistant(getActivity());
		assistant.loadFromFile();
		textViewName = (TextView) tabView.findViewById(R.id.recipeViewNameEditText);
		textViewDescription = (TextView) tabView.findViewById(R.id.recipeViewDescriptionEditText);
		textViewName.setText(assistant.getName());
		textViewDescription.setText(assistant.getDescription());
		
		return tabView;
	}
	public void onResumeFragment(){
		assistant.loadFromFile();
		textViewName.setText(assistant.getName());
		textViewDescription.setText(assistant.getDescription());
	}
}
