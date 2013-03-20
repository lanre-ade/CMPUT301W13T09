package com.cmput301w13t09.cmput301project.activities;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

import com.cmput301w13t09.cmput301project.IngredientModel;
import com.cmput301w13t09.cmput301project.R;
import com.cmput301w13t09.cmput301project.RecipeViewAssistant;

public class RecipeViewIngredientSectionFragment extends Fragment {

	private ListView ingredientListView;
	private ListAdapter ingredientListAdapter;
	private RecipeViewAssistant assistant;

	public RecipeViewIngredientSectionFragment() {
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// Create a new TextView and set its text to the fragment's section
		// number argument value.
		View tabView = inflater.inflate(R.layout.view_recipe_instruction_or_ingredient_tab,
				container, false);
		assistant = new RecipeViewAssistant(getActivity());
		assistant.loadFromFile();
		ingredientListView = (ListView) tabView
				.findViewById(R.id.RecipeViewList);
		ingredientListAdapter = new ArrayAdapter<IngredientModel>(
				getActivity(), android.R.layout.simple_list_item_1,
				assistant.getIngredientList());
		ingredientListView.setAdapter(ingredientListAdapter);

		ingredientListView.setOnItemClickListener(new OnItemClickListener() {
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				AlertDialog.Builder ingredientDialogBuilder = new AlertDialog.Builder(
						getActivity());
				String title = assistant.getIngredientListName(position);
				String message = assistant.getIngredient(position)
						.toDialogString();
				ingredientDialogBuilder.setMessage(message);
				ingredientDialogBuilder.setTitle(title);

				ingredientDialogBuilder.setNegativeButton("Cancel",
						new DialogInterface.OnClickListener() {

							@Override
							public void onClick(DialogInterface dialog,
									int which) {
								dialog.dismiss();

							}
						});
				AlertDialog dialog = ingredientDialogBuilder.create();
				dialog.show();
			}
		});
		return tabView;
	}
}
