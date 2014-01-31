package com.cmput301w13t09.cmput301project.test;

import android.test.ActivityInstrumentationTestCase2;

import com.cmput301w13t09.cmput301project.activities.CreateNewRecipeView;
import com.cmput301w13t09.cmput301project.models.IngredientListModel;
import com.cmput301w13t09.cmput301project.models.InstructionListModel;
import com.cmput301w13t09.cmput301project.models.PhotoListModel;
import com.cmput301w13t09.cmput301project.models.RecipeModel;

public class RecipeModelTest extends ActivityInstrumentationTestCase2<CreateNewRecipeView>{
	public RecipeModelTest() {
		super("com.cmput301w13t09.cmput301project.activities", CreateNewRecipeView.class);
		// TODO Auto-generated constructor stub
	}

	String recipe_name = null;
	String recipe_desc = null;
	IngredientListModel ingred_list = null;
	RecipeModel recipe = null;
	InstructionListModel instr_list = null;
	
	
	public void setUp(){
		recipe_name = null;
		recipe_desc = null;
		ingred_list = null;
		recipe = null;
		instr_list = null;
		
	}
	
	public void testRecipeModelStringStringIngredientListModel() {


		//If a recipe is constructed using null, null, null it should be null
		assertTrue(recipe == null);
		
		recipe_name = "test recipe";
		recipe_desc = "used for testing recipe model";
		ingred_list = new IngredientListModel();
		recipe = new RecipeModel(recipe_name, recipe_desc, ingred_list, instr_list);
		//If a recipe is constructed using String, String, IngredientListModel it should no longer be null
		assertTrue(recipe != null);
		assertTrue(recipe.getRecipeName() != null);
		assertTrue(recipe.getRecipeDesc() != null);
		assertTrue(recipe.getIngredList() != null);
		
	}

	
	public void testRecipeModelStringStringIngredientListModelPhotoListModel() {

		RecipeModel recipe = null;
		PhotoListModel photo_list = null;
		
		recipe_name = "test recipe";
		recipe_desc = "used for testing recipe model";
		ingred_list = new IngredientListModel();
		photo_list = new PhotoListModel();
		instr_list = new InstructionListModel();
		
		recipe = new RecipeModel(recipe_name, recipe_desc, ingred_list, instr_list, photo_list);
		//If a recipe is constructed using String, String, IngredientListModel, PhototListModel it should no longer be null
		assertTrue(recipe != null);
		assertTrue(recipe.getRecipeName() != null);
		assertTrue(recipe.getRecipeDesc() != null);
		assertTrue(recipe.getIngredList() != null);
		assertTrue(recipe.getPhotoList() != null);
		
	}

	
	public void testGetRecipeDesc() {
		RecipeModel recipe = 
				new RecipeModel("test", "used for testing recipe model", new IngredientListModel(), new InstructionListModel(), new PhotoListModel());
		
		//recipe.getRecipeDesc should match description in the constructor
		assertTrue(recipe.getRecipeDesc().equals("used for testing recipe model"));
	}

	
	public void testGetRecipeName() {
		RecipeModel recipe = 
				new RecipeModel("test1", "used for testing recipe model", new IngredientListModel(), new InstructionListModel(), new PhotoListModel());
		
		//recipe.getRecipeDesc should match description in the constructor
		assertTrue(recipe.getRecipeName().equals("test1"));
	}


	
	public final void testGetIngredList() {
		fail("Not yet implemented"); // TODO
	}

	
	public final void testGetPhotoList() {
		fail("Not yet implemented"); // TODO
	}


	
	public void testEquals() {
		RecipeModel recipe1 = new RecipeModel ("Italian Food", "Use fancy sounding ingredients", null, null);
		RecipeModel recipe2 = new RecipeModel (null, "Stir for 15 minutes", new IngredientListModel(), new InstructionListModel(), new PhotoListModel());
		RecipeModel recipe1b = new RecipeModel ("Italian Food", "Use fancy sounding ingredients", null, null);
		
		//Recipe should be equal to itself
		assertTrue(recipe1.equals(recipe1));
		
		//Recipes should be different from each other
		assertFalse(recipe1.equals(recipe2));
		

	}

}
