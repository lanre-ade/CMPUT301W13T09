package com.cmput301w13t09.cmput301project.activities;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

import com.cmput301w13t09.cmput301project.IngredientListModel;
import com.cmput301w13t09.cmput301project.IngredientModel;
import com.cmput301w13t09.cmput301project.R;

public class MyPantryView extends Activity {
	
	private static final int ITEM_CLICK = 0, ADD_INGREDIENT = 1;
	
	private ListAdapter ingredientListAdapter;
	private ListView ingredientListView;
	private int dialogNumber;

	private IngredientListModel ingredientList;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_my_pantry_view);
		ingredientList = new IngredientListModel();

		// TODO Remove this stuff it's garbage
		ingredientList.add(new IngredientModel("Cat", "Smells bad"));
		ingredientList.add(new IngredientModel("Fish", "Eats fish"));
		ingredientList.add(new IngredientModel("CatFish",
				"Smells bad and eats fish"));

		ingredientListView = (ListView) findViewById(R.id.myPantryIngredientList);
		ingredientListAdapter = new ArrayAdapter<IngredientModel>(this,
				android.R.layout.simple_list_item_1,
				ingredientList.getIngredientList());
		ingredientListView.setAdapter(ingredientListAdapter);

		ingredientListView.setOnItemClickListener(new OnItemClickListener() {
			@SuppressWarnings("deprecation")
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				

			}
		});

	}
	protected Dialog onCreateDialog(int id) {
		AlertDialog.Builder builder = new AlertDialog.Builder(this);
		switch(id) {
		
		case ITEM_CLICK:
			return null;
			
		case ADD_INGREDIENT:
			return null;
		}
		return null;
	}
}
