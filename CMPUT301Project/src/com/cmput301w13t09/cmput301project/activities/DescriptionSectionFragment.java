package com.cmput301w13t09.cmput301project.activities;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.cmput301w13t09.cmput301project.NewRecipeBuilder;
import com.cmput301w13t09.cmput301project.R;

/**
 * A fragment representing the display section of the create new recipe.
 */
public class DescriptionSectionFragment extends Fragment {
	public EditText nameEditText, descriptionEditText;
	private NewRecipeBuilder builder;
//	private OnItemSelectedListener listener;

	public DescriptionSectionFragment() {
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// Create a new TextView and set its text to the fragment's section
		// number argument value.
		View tabView = inflater.inflate(
				R.layout.activity_add_new_recipe_description_tab,
				container, false);
		nameEditText = (EditText) tabView
				.findViewById(R.id.addNewRecipeNameEditText);
		descriptionEditText = (EditText) tabView
				.findViewById(R.id.addNewRecipeDescriptionEditText);
		return tabView;
	}

}
