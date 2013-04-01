package com.cmput301w13t09.cmput301project.test;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;
import org.json.JSONException;

import com.cmput301w13t09.cmput301project.controllers.UploadController;
import com.cmput301w13t09.cmput301project.models.IngredientListModel;
import com.cmput301w13t09.cmput301project.models.InstructionListModel;
import com.cmput301w13t09.cmput301project.models.RecipeModel;

import junit.framework.TestCase;

public class UpdateAddRecipeToWebTest extends TestCase{

	public void addRecipeToWebTest(){
		
		RecipeModel r = new RecipeModel("testRecipe", "test", new IngredientListModel (),
				new InstructionListModel());
		UploadController u = null;
		boolean b = true;
		try {

			u = new UploadController();
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
	
public void updateRecipeOnWebTest(){
		
		RecipeModel r = new RecipeModel("testRecipe", "test", new IngredientListModel (),
				new InstructionListModel());
		UploadController u = null;
		boolean b = true;
		try {

			u = new UploadController();
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
		
		
		RecipeModel r_update = new RecipeModel("testRecipe2", "test2", new IngredientListModel (),
				new InstructionListModel());

		try {
			u.updateRecipe(r_update, 0);
			
			
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
		assertTrue(u.getRecipe(0).getRecipeName() == "testRecipe2");
	}


}
