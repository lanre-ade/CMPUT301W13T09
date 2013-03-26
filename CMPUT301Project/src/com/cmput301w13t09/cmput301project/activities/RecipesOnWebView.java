package com.cmput301w13t09.cmput301project.activities;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;

import android.app.Activity;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

import com.cmput301w13t09.cmput301project.R;
import com.cmput301w13t09.cmput301project.RecipeModel;
import com.cmput301w13t09.cmput301project.UploadController;

public class RecipesOnWebView extends Activity {
	private ListView recipeListView;
	private ListAdapter recipeListAdapter;
	private UploadController webController;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.activity_recipes_on_web_view);
		if (android.os.Build.VERSION.SDK_INT > 9) {
			StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder()
					.permitAll().build();
			StrictMode.setThreadPolicy(policy);
		}
		try {
			webController = new UploadController();
			recipeListView = (ListView) findViewById(R.id.webserviceRecipelistView);
			recipeListAdapter = new ArrayAdapter<RecipeModel>(this,
					android.R.layout.simple_list_item_1,
					webController.getRecipeList());
			recipeListView.setAdapter(recipeListAdapter);
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 

		recipeListView.setOnItemClickListener(new OnItemClickListener() {
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				;
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_recipes_on_web_view, menu);
		return true;
	}

}
