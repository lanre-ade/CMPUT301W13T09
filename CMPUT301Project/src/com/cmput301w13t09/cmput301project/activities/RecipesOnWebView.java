package com.cmput301w13t09.cmput301project.activities;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;

import com.cmput301w13t09.cmput301project.R;
import com.cmput301w13t09.cmput301project.RecipeListModel;
import com.cmput301w13t09.cmput301project.RecipeModel;
import com.cmput301w13t09.cmput301project.UploadController;
import com.google.gson.Gson;

import android.os.Bundle;
import android.os.StrictMode;
import android.app.Activity;
import android.view.Menu;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;

public class RecipesOnWebView extends Activity {
	private ListView recipeListView;
	private ListAdapter recipeListAdapter;
	private UploadController webController ;
	private EditText form;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.activity_recipes_on_web_view);
		 if (android.os.Build.VERSION.SDK_INT > 9) {
		      StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
		      StrictMode.setThreadPolicy(policy);
		    }
		form = (EditText) findViewById(R.id.editText1);
		try {
			webController = new UploadController();
			form.setText(webController.createFile());
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		/*
		recipeListView = (ListView) findViewById(R.id.recipesOnWebViewList);
		recipeListAdapter = new ArrayAdapter<RecipeModel>(this,
				android.R.layout.simple_list_item_1,
				webController.getRecipeList());
		recipeListView.setAdapter(recipeListAdapter);
		*/
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_recipes_on_web_view, menu);
		return true;
	}

}
