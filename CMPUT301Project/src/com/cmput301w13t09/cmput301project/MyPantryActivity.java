package com.cmput301w13t09.cmput301project;

import android.os.Bundle;
import android.app.Activity;
import android.app.ListActivity;
import android.view.Menu;

public class MyPantryActivity extends ListActivity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		//setListAdapter(new ArrayAdapter</*ddfd*/String>(this, android.R.layout.simple_list_item_activated_2, /*My Array */));
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_my_pantry, menu);
		return true;
	}

}
