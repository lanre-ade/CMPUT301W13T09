package com.cmput301w13t09.cmput301project.activities;


import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListAdapter;

import com.cmput301w13t09.cmput301project.R;
import com.cmput301w13t09.cmput301project.UploadController;

public class MySharingView extends Activity {
	public Button publishRecipeButton, viewRecipeOnWebButton, queryRecipeButton;
	private UploadController webController;
	private ListAdapter recipeListAdapter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_my_sharing_view);

		publishRecipeButton = (Button) findViewById(R.id.publishRecipe);
		viewRecipeOnWebButton = (Button) findViewById(R.id.viewRecipesonWebButton);
		queryRecipeButton = (Button) findViewById(R.id.QueryRecipebutton);

		
		publishRecipeButton.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				try {
					Intent viewPublishRecipe = new Intent(
							"activities.PublishRecipe");
					startActivity(viewPublishRecipe);
				} catch (Throwable e) {
					e.printStackTrace();
				}

			}
		});
		viewRecipeOnWebButton.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				if (isNetworkAvailable()) {
					try {
						Intent viewOnWebRecipe = new Intent(
								"activities.RecipesOnWeb");
						startActivity(viewOnWebRecipe);
					} catch (Throwable e) {
						e.printStackTrace();
					}
				} else {
					try {
						Intent viewOnWebOffRecipe = new Intent(
								"activities.RecipesOnWebOffline");
						startActivity(viewOnWebOffRecipe);
					} catch (Throwable e) {
						e.printStackTrace();
					}

				}
			}
		});
		queryRecipeButton.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				try {
					Intent viewQueryRecipe = new Intent(
							"activities.QueryRecipes");
					startActivity(viewQueryRecipe);
				} catch (Throwable e) {
					e.printStackTrace();
				}
			}
		});
	}
	private boolean isNetworkAvailable() {
	    ConnectivityManager connectivityManager 
	          = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
	    NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
	    return activeNetworkInfo != null && activeNetworkInfo.isConnected();
	}
}

