package com.cmput301w13t09.cmput301project.tests;

import static org.junit.Assert.fail;
import junit.framework.Assert;

import org.junit.Test;

import android.content.Context;

import com.cmput301w13t09.cmput301project.IngredientListModel;
import com.cmput301w13t09.cmput301project.InstructionListModel;
import com.cmput301w13t09.cmput301project.PhotoListModel;
import com.cmput301w13t09.cmput301project.RecipeController;
import com.cmput301w13t09.cmput301project.RecipeModel;

public class RecipeControllerTest {
	RecipeController recipe_controller;
	Context ctx;
	
	public RecipeControllerTest() {
	recipe_controller = new RecipeController(ctx);
	}

	
	@Test
	public final void testRecipeController() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public final void testAddRecipe() {
		//no photos or ingredients
		RecipeModel recipe1 = new RecipeModel ("Italian Food", "Use fancy sounding ingredients", null, null);
		//no recipe name
		RecipeModel recipe2 = new RecipeModel (null, "Stir for 15 minutes", new IngredientListModel(), new InstructionListModel(), new PhotoListModel());
		//

		
		recipe_controller.addRecipe(recipe1);
		Assert.assertTrue(recipe_controller.getRecipeList() == null);
		recipe_controller = new RecipeController(ctx);
		recipe_controller.addRecipe(recipe2);
		Assert.assertTrue(recipe_controller.getRecipeList() == null);
		//Assert.assertTrue();
	}

	@Test
	public final void testGetLength() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public final void testGetRecipeListName() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public final void testGetRecipeListDesc() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public final void testGetRecipeingredientList() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public final void testGetRecipePhotoList() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public final void testGetRecipeList() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public final void testRemove() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public final void testLoadFromFile() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public final void testSaveToFile() {
		fail("Not yet implemented"); // TODO
	}

}
