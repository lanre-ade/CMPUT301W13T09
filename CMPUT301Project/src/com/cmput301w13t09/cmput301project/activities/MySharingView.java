package com.cmput301w13t09.cmput301project.activities;

import com.cmput301w13t09.cmput301project.R;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.widget.Button;

public class MySharingView extends Activity {
	public Button publishRecipeButton, viewRecipeOnWebButton;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_my_sharing_view);

		publishRecipeButton = (Button) findViewById(R.id.publishRecipe);
		viewRecipeOnWebButton = (Button) findViewById(R.id.viewRecipesonWebButton);

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
				try {
					Intent viewPublishRecipe = new Intent("activities.RecipesOnWeb");
					startActivity(viewPublishRecipe);
				} catch (Throwable e) {
					e.printStackTrace();
				}

			}
		});
	}

}
