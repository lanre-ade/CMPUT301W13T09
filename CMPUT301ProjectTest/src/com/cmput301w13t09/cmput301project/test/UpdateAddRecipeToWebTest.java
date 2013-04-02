package com.cmput301w13t09.cmput301project.test;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;
import org.json.JSONException;

import android.test.ActivityInstrumentationTestCase2;

import com.cmput301w13t09.cmput301project.activities.RecipeView;
import com.cmput301w13t09.cmput301project.controllers.WebController;
import com.cmput301w13t09.cmput301project.models.IngredientListModel;
import com.cmput301w13t09.cmput301project.models.InstructionListModel;
import com.cmput301w13t09.cmput301project.models.RecipeModel;

public class UpdateAddRecipeToWebTest extends
		ActivityInstrumentationTestCase2<RecipeView> {

	public UpdateAddRecipeToWebTest() {
		super("com.cmput301w13t09.cmput301project.activities", RecipeView.class);
		// TODO Auto-generated constructor stub
	}

	public void testAddRecipeToWeb() {

		RecipeModel r = new RecipeModel("testRecipe", "test",
				new IngredientListModel(), new InstructionListModel());
		WebController u = null;
		boolean b = true;
		try {

			u = new WebController();
			assertTrue(u.getLength() == 0);
			u.insertRecipe(r);

		} catch (ClientProtocolException e) {
			b = false;
			e.printStackTrace();
		} catch (IOException e) {
			b = false;
			e.printStackTrace();
		} catch (IllegalStateException e) {
			b = false;
			e.printStackTrace();
		} catch (JSONException e) {
			b = false;
			e.printStackTrace();
		}
		assertTrue("exceptions encountered", b == true);
		assertTrue(u.getLength() == 1);
	}

	public void testUpdateRecipeOnWeb() {

		RecipeModel r = new RecipeModel("testRecipe", "test",
				new IngredientListModel(), new InstructionListModel());
		WebController u = null;
		boolean b = true;
		try {

			u = new WebController();
			assertTrue(u.getLength() == 0);
			u.insertRecipe(r);

		} catch (ClientProtocolException e) {
			b = false;
			e.printStackTrace();
		} catch (IOException e) {
			b = false;
			e.printStackTrace();
		} catch (IllegalStateException e) {
			b = false;
			e.printStackTrace();
		} catch (JSONException e) {
			b = false;
			e.printStackTrace();
		}
		assertTrue("exceptions encountered", b == true);
		assertTrue(u.getLength() == 1);

		RecipeModel r_update = new RecipeModel("testRecipe2", "test2",
				new IngredientListModel(), new InstructionListModel());

		try {
			u.updateRecipe(r_update, 0);

		} catch (IllegalStateException e) {
			b = false;
			e.printStackTrace();
		}
		assertTrue("exceptions encountered", b == true);
		assertTrue(u.getRecipe(0).getRecipeName() == "testRecipe2");
	}

}
