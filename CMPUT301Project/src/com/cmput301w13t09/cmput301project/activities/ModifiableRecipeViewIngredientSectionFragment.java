package com.cmput301w13t09.cmput301project.activities;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Spinner;

import com.cmput301w13t09.cmput301project.RecipeViewAssistant;
import com.cmput301w13t09.cmput301project.R;
import com.cmput301w13t09.cmput301project.models.IngredientModel;

public class ModifiableRecipeViewIngredientSectionFragment extends Fragment {

	private Button addIngredientButton;
	private ListView ingredientListView;
	private ListAdapter ingredientListAdapter;
	private RecipeViewAssistant builder;
	private int dialogNumber;

	public ModifiableRecipeViewIngredientSectionFragment() {
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// Create a new TextView and set its text to the fragment's section
		// number argument value.
		View tabView = inflater.inflate(R.layout.activity_my_pantry_view,
				container, false);
		addIngredientButton = (Button) tabView
				.findViewById(R.id.myPantryAddIngredientButton);
		builder = new RecipeViewAssistant(getActivity());
		builder.loadFromFile();
		addIngredientButton.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				try {
					builder.loadFromFile();
					final Dialog addIngredientDialog = new Dialog(getActivity());
					addIngredientDialog
							.setContentView(R.layout.activity_add_new_ingredient_view);
					addIngredientDialog.setTitle("New Ingredient");

					Button addIngredientDialogButtonConfirm = (Button) addIngredientDialog
							.findViewById(R.id.addNewIngredient);
					Button addIngredientDialogButtonCancel = (Button) addIngredientDialog
							.findViewById(R.id.andNewIngredientCancelButton);

					final EditText addIngredientDialodEditTextName = (EditText) addIngredientDialog
							.findViewById(R.id.addNewIngredientEditTextName);
					final EditText addIngredientDialodEditTextDescription = (EditText) addIngredientDialog
							.findViewById(R.id.addNewIngredientEditTextDescription);
					final EditText addIngredientDialodEditTextQuantity = (EditText) addIngredientDialog
							.findViewById(R.id.addNewIngredientEditTextQuantity);
					final Spinner addIngredientDialodSpinnerQuantity = (Spinner) addIngredientDialog
							.findViewById(R.id.addNewIngredientSpinnerQuantity);
					ArrayAdapter<CharSequence> addIngredientDialodSpinnerArrayAdapterQuantity = ArrayAdapter
							.createFromResource(
									getActivity(),
									R.array.UnitsArrayList,
									android.R.layout.simple_spinner_dropdown_item);
					addIngredientDialodSpinnerQuantity
							.setAdapter(addIngredientDialodSpinnerArrayAdapterQuantity);
					addIngredientDialogButtonConfirm
							.setOnClickListener(new OnClickListener() {
								@Override
								public void onClick(View v) {
									if(!addIngredientDialodEditTextQuantity.getText().toString().isEmpty() && !addIngredientDialodEditTextName.getText().toString().isEmpty()){
									builder.addIngredient(new IngredientModel(
											addIngredientDialodEditTextName
													.getText().toString(),
											addIngredientDialodEditTextDescription
													.getText().toString(),
											Float.parseFloat(addIngredientDialodEditTextQuantity
													.getText().toString()),
											addIngredientDialodSpinnerQuantity
													.getSelectedItem()
													.toString()));
									updateList();
									addIngredientDialog.dismiss();
									}
									else{
										  AlertDialog.Builder builder3 = new AlertDialog.Builder(getActivity());
									        builder3.setMessage(R.string.Error_)
									               .setPositiveButton(R.string.Ok, new DialogInterface.OnClickListener() {
									                   public void onClick(DialogInterface dialog3, int id) {
									                       dialog3.dismiss();
									                   }
									               });
									        AlertDialog dialog3 = builder3.create();
											dialog3.show();
									}

								}
							});
					addIngredientDialogButtonCancel
							.setOnClickListener(new OnClickListener() {
								@Override
								public void onClick(View v) {
									addIngredientDialog.dismiss();
								}
							});
					addIngredientDialog.show();
				} catch (Throwable e) {
					e.printStackTrace();
				}
			}
		});

		ingredientListView = (ListView) tabView
				.findViewById(R.id.myPantryIngredientList);
		ingredientListAdapter = new ArrayAdapter<IngredientModel>(
				getActivity(), android.R.layout.simple_list_item_1,
				builder.getIngredientList());
		ingredientListView.setAdapter(ingredientListAdapter);

		ingredientListView.setOnItemClickListener(new OnItemClickListener() {
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				dialogNumber = position;
				AlertDialog.Builder ingredientDialogBuilder = new AlertDialog.Builder(
						getActivity());
				String title = builder.getIngredientListName(position);
				String message = builder.getIngredient(position)
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
				ingredientDialogBuilder.setNeutralButton("Edit",
						new DialogInterface.OnClickListener() {

							@Override
							public void onClick(DialogInterface dialog,
									int which) {
								final Dialog dialog2 = new Dialog(getActivity());
								dialog2.setContentView(R.layout.activity_add_new_ingredient_view);
								final EditText dialognameText = (EditText) dialog2
										.findViewById(R.id.addNewIngredientEditTextName);
								final EditText dialogquantityText = (EditText) dialog2
										.findViewById(R.id.addNewIngredientEditTextQuantity);
								Button dialogdone = (Button) dialog2
										.findViewById(R.id.addNewIngredient);
								Button dialogcancel = (Button) dialog2
										.findViewById(R.id.andNewIngredientCancelButton);
								final EditText dialogdescriptionText = (EditText) dialog2
										.findViewById(R.id.addNewIngredientEditTextDescription);
								dialognameText.setText(builder
										.getIngredientListName(dialogNumber));
								final Spinner unitSelectorSpinner = (Spinner) dialog2
										.findViewById(R.id.addNewIngredientSpinnerQuantity);
								ArrayAdapter<CharSequence> unitSelectorAdapter = ArrayAdapter
										.createFromResource(
												getActivity(),
												R.array.UnitsArrayList,
												android.R.layout.simple_spinner_dropdown_item);
								unitSelectorSpinner
										.setAdapter(unitSelectorAdapter);
								unitSelectorSpinner
										.setSelection(checkPositionInArray(builder
												.getIngredient(dialogNumber)
												.getIngredientquantityunit()));
								dialogdescriptionText.setText(builder
										.getIngredientListDesc(dialogNumber));
								dialogquantityText.setText(String
										.valueOf(builder.getIngredient(
												dialogNumber)
												.getIngredientquantity()));
								dialogcancel
										.setOnClickListener(new View.OnClickListener() {

											@Override
											public void onClick(View v) {
												dialog2.cancel();
											}
										});
								dialogdone
										.setOnClickListener(new View.OnClickListener() {

											@Override
											public void onClick(View v) {
												if(!dialogquantityText.getText().toString().isEmpty() && !dialognameText.getText().toString().isEmpty()){
												builder.setIngredient(
														dialogNumber,
														dialognameText
																.getText()
																.toString(),
														dialogdescriptionText
																.getText()
																.toString(),
														Float.parseFloat(dialogquantityText
																.getText()
																.toString()),
														unitSelectorSpinner
																.getSelectedItem()
																.toString());
												dialog2.dismiss();
												updateList();
												}
												else{
													 AlertDialog.Builder builder3 = new AlertDialog.Builder(getActivity());
												        builder3.setMessage(R.string.Error_)
												               .setPositiveButton(R.string.Ok, new DialogInterface.OnClickListener() {
												                   public void onClick(DialogInterface dialog3, int id) {
												                       dialog3.dismiss();
												                   }
												               });
												        AlertDialog dialog3 = builder3.create();
														dialog3.show();
												}
											}
										});

								dialog2.show();
							}
						});
				ingredientDialogBuilder.setPositiveButton("Delete",
						new DialogInterface.OnClickListener() {

							@Override
							public void onClick(DialogInterface dialog,
									int which) {
								builder.removeIngredient(dialogNumber);
								dialog.dismiss();
								updateList();

							}
						});

				AlertDialog dialog = ingredientDialogBuilder.create();
				dialog.show();
			}
		});
		return tabView;
	}
	

	protected void updateList() {
		builder.updateRecipe();
		ingredientListAdapter = new ArrayAdapter<IngredientModel>(
				getActivity(), android.R.layout.simple_list_item_1,
				builder.getIngredientList());
		ingredientListView.setAdapter(ingredientListAdapter);
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
