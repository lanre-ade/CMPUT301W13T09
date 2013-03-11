package com.cmput301w13t09.cmput301project.activities;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.cmput301w13t09.cmput301project.R;
import com.cmput301w13t09.cmput301project.R.array;
import com.cmput301w13t09.cmput301project.R.id;
import com.cmput301w13t09.cmput301project.R.layout;

/**
 * @author Kyle, Marcus, and Landre
 * Class: AddNewIngredientView
 * AddNewIngredient is a class that extends an activity. Therefore acts as an activity and is a view for
 * adding ingredients into myPantry. AddNewIngredient provides fields for entering information for ingredients
 * and then classes IngredientController and this will stores the Ingredient in Pantry.data
 */
public class AddNewIngredientView extends Activity {
	public Button doneButton;
	public EditText nameText, quantityText, descriptionText;
	public Spinner unitSelectorSpinner;
	ArrayAdapter<CharSequence> unitSelectorAdapter;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_add_new_ingredient_view);
		
		nameText = (EditText)findViewById(R.id.addNewIngredientEditTextName);
		quantityText = (EditText) findViewById(R.id.addNewIngredientEditTextQuantity);
		descriptionText = (EditText) findViewById(R.id.addNewIngredientEditTextDescription);
		
		unitSelectorSpinner = (Spinner) findViewById(R.id.addNewIngredientSpinnerQuantity);
		unitSelectorAdapter = ArrayAdapter.createFromResource(this, R.array.UnitsArrayList, android.R.layout.simple_spinner_dropdown_item);
		unitSelectorSpinner.setAdapter(unitSelectorAdapter);
		
		
		
	}

}
