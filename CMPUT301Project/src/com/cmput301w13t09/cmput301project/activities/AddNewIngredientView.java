package com.cmput301w13t09.cmput301project.activities;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.cmput301w13t09.cmput301project.IngredientController;
import com.cmput301w13t09.cmput301project.IngredientModel;
import com.cmput301w13t09.cmput301project.R;

/**
 * @author Kyle, Marcus, and Landre Class: AddNewIngredientView AddNewIngredient
 *         is a class that extends an activity. Therefore acts as an activity
 *         and is a view for adding ingredients into myPantry. AddNewIngredient
 *         provides fields for entering information for ingredients and then
 *         classes IngredientController and this will stores the Ingredient in
 *         Pantry.data
 */
public class AddNewIngredientView extends Activity {
	public Button doneButton, cancelButton;
	public EditText nameText, quantityText, descriptionText;
	public Spinner unitSelectorSpinner;
	public ArrayAdapter<CharSequence> unitSelectorAdapter;
	public IngredientController ingredController;


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_add_new_ingredient_view);

		nameText = (EditText) findViewById(R.id.addNewIngredientEditTextName);
		quantityText = (EditText) findViewById(R.id.addNewIngredientEditTextQuantity);
		descriptionText = (EditText) findViewById(R.id.addNewIngredientEditTextDescription);
		

		unitSelectorSpinner = (Spinner) findViewById(R.id.addNewIngredientSpinnerQuantity);
		unitSelectorAdapter = ArrayAdapter.createFromResource(this,
				R.array.UnitsArrayList,
				android.R.layout.simple_spinner_dropdown_item);
		unitSelectorSpinner.setAdapter(unitSelectorAdapter);

		doneButton = (Button) findViewById(R.id.addNewIngredient);
		cancelButton = (Button) findViewById(R.id.andNewIngredientCancelButton);
		ingredController = new IngredientController(this);
		
		doneButton.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				IngredientModel ingred = new IngredientModel(nameText.getText()
						.toString(), descriptionText.getText().toString(),
						Float.parseFloat(quantityText.getText().toString()),
						unitSelectorSpinner.getSelectedItem().toString());	
				ingredController.add(ingred);
				ingredController.saveToFile();
				end();
			}
		});
		cancelButton.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				finish();
			}
		});
	}
	protected void end(){
		finish();
	}
}
