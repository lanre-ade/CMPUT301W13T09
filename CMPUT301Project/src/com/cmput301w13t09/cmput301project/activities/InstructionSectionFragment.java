package com.cmput301w13t09.cmput301project.activities;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.AdapterView.OnItemClickListener;

import com.cmput301w13t09.cmput301project.IngredientModel;
import com.cmput301w13t09.cmput301project.InstructionModel;
import com.cmput301w13t09.cmput301project.NewRecipeBuilder;
import com.cmput301w13t09.cmput301project.R;

public class InstructionSectionFragment extends Fragment {
	private ListView instructionListView;
	private ListAdapter instructionListAdapter;
	private NewRecipeBuilder builder;
	private int dialogNumber;
	private Button addInstructionButton;

	public InstructionSectionFragment() {
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// Create a new TextView and set its text to the fragment's section
		// number argument value.
		View tabView = inflater.inflate(
				R.layout.activity_add_new_recipe_instruction_tab, container,
				false);
		instructionListView = (ListView) tabView
				.findViewById(R.id.addNewRecipeInstructionAddList);
		instructionListAdapter = new ArrayAdapter<InstructionModel>(
				getActivity(), android.R.layout.simple_list_item_1,
				builder.getInstructionList());
		instructionListView.setAdapter(instructionListAdapter);

		instructionListView.setOnItemClickListener(new OnItemClickListener() {
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				dialogNumber = position;
				AlertDialog.Builder instructionDialogBuilder = new AlertDialog.Builder(
						getActivity());
				String message = builder.getInstruction(position).toString();
				instructionDialogBuilder.setMessage(message);

				instructionDialogBuilder.setNegativeButton("Cancel",
						new DialogInterface.OnClickListener() {

							@Override
							public void onClick(DialogInterface dialog,
									int which) {
								dialog.dismiss();

							}
						});
				instructionDialogBuilder.setNeutralButton("Delete",
						new DialogInterface.OnClickListener() {

							@Override
							public void onClick(DialogInterface dialog,
									int which) {
								builder.removeInstruction(dialogNumber);
								dialog.dismiss();
								updateList();
							}
						});
				instructionDialogBuilder.setPositiveButton("Confirm",
						new DialogInterface.OnClickListener() {

							@Override
							public void onClick(DialogInterface dialog,
									int which) {

							}
						});

				AlertDialog dialog = instructionDialogBuilder.create();
				dialog.show();
			}
		});

		return tabView;
	}

	protected void updateList() {
		builder.updateRecipe();
		instructionListAdapter = new ArrayAdapter<IngredientModel>(
				getActivity(), android.R.layout.simple_list_item_1,
				builder.getIngredientList());
		instructionListView.setAdapter(instructionListAdapter);
	}
}