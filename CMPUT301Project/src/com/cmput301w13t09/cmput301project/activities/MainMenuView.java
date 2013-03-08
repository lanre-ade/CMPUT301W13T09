package com.cmput301w13t09.cmput301project.activities;

import com.cmput301w13t09.cmput301project.R;
import com.cmput301w13t09.cmput301project.R.layout;
import com.cmput301w13t09.cmput301project.R.menu;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class MainMenuView extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main_menu_view);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_main_menu_view, menu);
		return true;
	}

}
