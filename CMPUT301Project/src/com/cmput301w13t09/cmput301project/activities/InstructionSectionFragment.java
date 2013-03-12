package com.cmput301w13t09.cmput301project.activities;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.cmput301w13t09.cmput301project.NewRecipeBuilder;
import com.cmput301w13t09.cmput301project.R;


public class InstructionSectionFragment extends Fragment {
	private NewRecipeBuilder builder;
	public InstructionSectionFragment() {
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// Create a new TextView and set its text to the fragment's section
		// number argument value.
		View tabView = inflater.inflate(
				R.layout.activity_add_new_recipe_instruction_tab,
				container, false);

		return tabView;
	}
}