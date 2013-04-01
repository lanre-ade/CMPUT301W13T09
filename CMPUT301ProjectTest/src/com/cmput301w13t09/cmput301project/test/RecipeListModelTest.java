package com.cmput301w13t09.cmput301project.test;

import static org.junit.Assert.*;
import junit.framework.TestCase;

import org.junit.Test;

import com.cmput301w13t09.cmput301project.models.IngredientModel;
import com.cmput301w13t09.cmput301project.models.RecipeListModel;
import com.cmput301w13t09.cmput301project.models.RecipeModel;

public class RecipeListModelTest extends TestCase{
	RecipeListModel rList;
	
	public void setUp() {
		rList = new RecipeListModel();
		
	}

	@Test
	public void AddRecipeTest() {
		RecipeModel r = new RecipeModel("Cake", "Sweet dessert", null, null);
		assertEquals(0, rList.size());
		boolean res = rList.add(r);
		assertTrue(res);
		assertEquals(1, rList.size());
		assertEquals(r, rList.get(0));
	}
	
	@Test
	public void DeleteRecipeTest(){
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
