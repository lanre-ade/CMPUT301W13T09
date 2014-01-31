package com.cmput301w13t09.cmput301project.test;

import android.test.ActivityInstrumentationTestCase2;

import com.cmput301w13t09.cmput301project.activities.CreateNewRecipeView;
import com.cmput301w13t09.cmput301project.models.RecipeListModel;
import com.cmput301w13t09.cmput301project.models.RecipeModel;

public class RecipeListModelTest extends ActivityInstrumentationTestCase2<CreateNewRecipeView>{
	
	
	public RecipeListModelTest() {
		super("com.cmput301w13t09.cmput301project.activities", CreateNewRecipeView.class);
		// TODO Auto-generated constructor stub
	}

	RecipeListModel rList;
	
	public void setUp() {
		rList = new RecipeListModel();
		
	}

	
	public void testAddRecipe() {
		RecipeModel r = new RecipeModel("Cake", "Sweet dessert", null, null);
		assertEquals(0, rList.size());
		boolean res = rList.add(r);
		assertTrue(res);
		assertEquals(1, rList.size());
		assertEquals(r, rList.get(0));
	}
	
	
	public void testDeleteRecipe(){
		RecipeModel r = new RecipeModel("Cake", "Sweet dessert", null, null);
		assertEquals(0, rList.size());
		boolean res = rList.add(r);
		assertTrue(res);
		assertEquals(1, rList.size());
		assertEquals(r, rList.get(0));
		
		rList.remove(0);
		assertTrue(rList.size() == 0);
	}

}
