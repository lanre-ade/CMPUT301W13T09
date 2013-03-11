package com.cmput301w13t09.cmput301project.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import com.cmput301w13t09.cmput301project.IngredientModel;

public class IngredientModelTest {

	public IngredientModelTest() {
	}

	@Test
	public void test() {
		fail("Not yet implemented"); // TODO
	}
	
	@Test
	public void testgetIngredientDesc(){
		IngredientModel ilist = new IngredientModel("Flour", "powder");
		assertTrue(ilist.getIngredientDesc().equals("powder"));
	}
}
