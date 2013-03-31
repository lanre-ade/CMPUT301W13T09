package com.cmput301w13t09.cmput301project.activities;

import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.app.Dialog;
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

import com.cmput301w13t09.cmput301project.R;
import com.cmput301w13t09.cmput301project.RecipeViewAssistant;
import com.cmput301w13t09.cmput301project.models.InstructionModel;

public class RecipeViewInstructionSectionFragment extends Fragment {
	private ListView instructionListView;
	private ListAdapter instructionListAdapter;
	private RecipeViewAssistant assistant;
	private int dialogNumber;

	public RecipeViewInstructionSectionFragment() {
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// Create a new TextView and set its text to the fragment's section
		// number argument value.
		View tabView = inflater.inflate(
				R.layout.view_recipe_instruction_or_ingredient_tab, container,
				false);
		assistant = new RecipeViewAssistant(getActivity());
		assistant.loadFromFile();
		instructionListView = (ListView) tabView
				.findViewById(R.id.RecipeViewList);
		instructionListAdapter = new ArrayAdapter<InstructionModel>(
				getActivity(), android.R.layout.simple_list_item_1,
				assistant.getInstructionList());
		instructionListView.setAdapter(instructionListAdapter);

		instructionListView.setOnItemClickListener(new OnItemClickListener() {
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				dialogNumber = position;
				Builder instructionDialogBuilder = new AlertDialog.Builder(getActivity());
				instructionDialogBuilder.setTitle("Step:"+(position+1));
				instructionDialogBuilder.setMessage(assistant.getInstruction(dialogNumber).toString());
				instructionDialogBuilder.setNeutralButton("Done", new DialogInterface.OnClickListener() {
					
					public void onClick(DialogInterface dialog, int which) {
						dialog.dismiss();
						
					}
				});
				Dialog dialog = instructionDialogBuilder.create();
				dialog.show();
			}
		});

				return tabView;
	}
	public void onResume(){
		assistant.loadFromFile();
		instructionListAdapter = new ArrayAdapter<InstructionModel>(
				getActivity(), android.R.layout.simple_list_item_1,
				assistant.getInstructionList());
		instructionListView.setAdapter(instructionListAdapter);
		super.onResume();
	}
}