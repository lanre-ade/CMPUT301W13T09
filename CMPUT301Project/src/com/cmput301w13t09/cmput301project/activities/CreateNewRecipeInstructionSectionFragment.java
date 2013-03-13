package com.cmput301w13t09.cmput301project.activities;

import android.app.Dialog;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;

import com.cmput301w13t09.cmput301project.InstructionModel;
import com.cmput301w13t09.cmput301project.NewRecipeBuilder;
import com.cmput301w13t09.cmput301project.R;

public class CreateNewRecipeInstructionSectionFragment extends Fragment {
	private ListView instructionListView;
	private ListAdapter instructionListAdapter;
	private NewRecipeBuilder builder;
	private int dialogNumber;
	private Button addInstructionButton;

	public CreateNewRecipeInstructionSectionFragment() {
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// Create a new TextView and set its text to the fragment's section
		// number argument value.
		View tabView = inflater.inflate(
				R.layout.activity_add_new_recipe_instruction_tab, container,
				false);
		builder = new NewRecipeBuilder(getActivity());
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
				final Dialog instructionDialogBuilder = new Dialog(
						getActivity());
				instructionDialogBuilder
						.setContentView(R.layout.activity_create_new_instruction_view_three);
				instructionDialogBuilder.setTitle("Edit Instruction");
				final EditText instructionDialogEditTextInstruction = (EditText) instructionDialogBuilder
						.findViewById(R.id.addNewRecipeInstructionDialogEditText);
				Button instructionDialogButtonConfirm = (Button) instructionDialogBuilder
						.findViewById(R.id.addNewRecipeInstructionDialogConfirm);
				Button instructionDialogButtonCancel = (Button) instructionDialogBuilder
						.findViewById(R.id.addNewRecipeInstructionDialogCancel);
				Button instructionDialogButtonDelete = (Button) instructionDialogBuilder
						.findViewById(R.id.addNewRecipeInstructionDialogDelete);
				instructionDialogEditTextInstruction.setText(builder
						.getInstruction(dialogNumber).toString());

				instructionDialogButtonConfirm
						.setOnClickListener(new View.OnClickListener() {

							@Override
							public void onClick(View v) {
								builder.getInstruction(dialogNumber).setInstruction(instructionDialogEditTextInstruction.getText().toString());
								builder.saveToFile();
								instructionDialogBuilder.dismiss();
								updateList();
							}
						});

				instructionDialogButtonCancel
						.setOnClickListener(new View.OnClickListener() {

							@Override
							public void onClick(View v) {
								instructionDialogBuilder.dismiss();

							}
						});
				instructionDialogButtonDelete
						.setOnClickListener(new View.OnClickListener() {

							@Override
							public void onClick(View v) {
								builder.removeInstruction(dialogNumber);
								instructionDialogBuilder.dismiss();
								updateList();

							}
						});
				instructionDialogBuilder.show();
			}
		});

		addInstructionButton = (Button) tabView
				.findViewById(R.id.addNewRecipeInstructionAddButton);
		addInstructionButton.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				builder.loadFromFile();
				final Dialog addinstructionDialogBuilder = new Dialog(
						getActivity());
				addinstructionDialogBuilder
						.setContentView(R.layout.activity_create_new_instrution_view_two);
				addinstructionDialogBuilder.setTitle("New Instruction");
				final EditText addInstructionDialogEditTextInstruction = (EditText) addinstructionDialogBuilder
						.findViewById(R.id.addNewRecipeInstructionDialogTwoEditText);
				Button addInstructionDialogButtonConfirm = (Button) addinstructionDialogBuilder
						.findViewById(R.id.addNewRecipeInstructionDialogRight);
				Button addInstructionDialogButtonCancel = (Button) addinstructionDialogBuilder
						.findViewById(R.id.addNewRecipeInstructionDialogLeft);
				addInstructionDialogButtonCancel.setText("Cancel");
				addInstructionDialogButtonConfirm.setText("Add Instruction");
				addInstructionDialogButtonConfirm
						.setOnClickListener(new View.OnClickListener() {

							@Override
							public void onClick(View v) {
								builder.addInstruction(new InstructionModel(
										addInstructionDialogEditTextInstruction
												.getText().toString()));
								builder.saveToFile();
								addinstructionDialogBuilder.dismiss();
								updateList();
							}
						});

				addInstructionDialogButtonCancel
						.setOnClickListener(new View.OnClickListener() {

							@Override
							public void onClick(View v) {
								addinstructionDialogBuilder.dismiss();

							}
						});
				addinstructionDialogBuilder.show();
			}
		});
		return tabView;
	}

	protected void updateList() {
		builder.updateRecipe();
		instructionListAdapter = new ArrayAdapter<InstructionModel>(
				getActivity(), android.R.layout.simple_list_item_1,
				builder.getInstructionList());
		instructionListView.setAdapter(instructionListAdapter);
	}

	public int checkPositionInArray(String s) {
		int j = 0;
		for (String str : getResources().getStringArray(R.array.UnitsArrayList)) {
			if (s.equals(str))
				return j;
			else
				j++;
		}
		return 0;
	}
}