package com.cmput301w13t09.cmput301project.tests;

import static org.junit.Assert.*;
import junit.framework.Assert;
import org.junit.*;

import com.cmput301w13t09.cmput301project.IngredientListModel;
import com.cmput301w13t09.cmput301project.InstructionListModel;
import com.cmput301w13t09.cmput301project.InstructionModel;
import com.cmput301w13t09.cmput301project.PhotoListModel;
import com.cmput301w13t09.cmput301project.RecipeModel;

public class RecipeModelTest {

	@Test
	public void testRecipeModelStringStringIngredientListModel() {
		String recipe_name = null;
		String recipe_desc = null;
		IngredientListModel ingred_list = null;
		RecipeModel recipe = null;
		InstructionListModel instr_list = null;
		InstructionModel instruction = null;
		
		recipe = new RecipeModel(recipe_name, recipe_desc, ingred_list, instr_list);
		//If a recipe is constructed using null, null, null it should be null
		assertTrue(recipe == null);
		
		recipe_name = "test recipe";
		recipe_desc = "used for testing recipe model";
		ingred_list = new IngredientListModel();
		
		//If a recipe is constructed using String, String, IngredientListModel it should no longer be null
		assertTrue(recipe != null);
		assertTrue(recipe.getRecipeName() != null);
		assertTrue(recipe.getRecipeDesc() != null);
		Assert.assertTrue(recipe.getIngredList() != null);
		
	}

	@Test
	public void testRecipeModelStringStringIngredientListModelPhotoListModel() {
		String recipe_name = null;
		String recipe_desc = null;
		IngredientListModel ingred_list = null;
		RecipeModel recipe = null;
		PhotoListModel photo_list = null;
		InstructionListModel instr_list = null;
		InstructionModel instruction = null;
		
		recipe = new RecipeModel(recipe_name, recipe_desc, ingred_list, instr_list, photo_list);
		//If a recipe is constructed using null, null, null, null it should be null
		assertTrue(recipe == null);
		
		recipe_name = "test recipe";
		recipe_desc = "used for testing recipe model";
		ingred_list = new IngredientListModel();
		photo_list = new PhotoListModel();
		instr_list = new InstructionListModel();
		instruction = new InstructionModel();
		
		recipe = new RecipeModel(recipe_name, recipe_desc, ingred_list, instr_list, photo_list);
		//If a recipe is constructed using String, String, IngredientListModel, PhototListModel it should no longer be null
		assertTrue(recipe != null);
		assertTrue(recipe.getRecipeName() != null);
		assertTrue(recipe.getRecipeDesc() != null);
		assertTrue(recipe.getIngredList() != null);
		assertTrue(recipe.getPhotoList() != null);
		
	}

	@Test
	public void testGetRecipeDesc() {
		RecipeModel recipe = 
				new RecipeModel("test", "used for testing recipe model", new IngredientListModel(), new InstructionListModel(), new PhotoListModel());
		
		//recipe.getRecipeDesc should match description in the constructor
		assertTrue(recipe.getRecipeDesc().equals("used for testing recipe model"));
	}

	@Test
	public void testGetRecipeName() {
		RecipeModel recipe = 
				new RecipeModel("test", "used for testing recipe model", new IngredientListModel(), new InstructionListModel(), new PhotoListModel());
		
		//recipe.getRecipeDesc should match description in the constructor
		assertTrue(recipe.getRecipeName().equals("test"));
	}


	@Test
	public final void testGetIngredList() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public final void testGetPhotoList() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public final void testToString() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public void testEquals() {
		RecipeModel recipe1 = new RecipeModel ("Italian Food", "Use fancy sounding ingredients", null, null);
		RecipeModel recipe2 = new RecipeModel (null, "Stir for 15 minutes", new IngredientListModel(), new InstructionListModel(), new PhotoListModel());
		RecipeModel recipe1b = new RecipeModel ("Italian Food", "Use fancy sounding ingredients", null, null);
		
		//Recipe should be equal to itself
		assertTrue(recipe1.equals(recipe1));
		
		//Recipes should be different from each other
		assertFalse(recipe1.equals(recipe2));
		
		//Recipes with same info should be equal
		assertTrue(recipe1.equals(recipe1b));
	}

}
