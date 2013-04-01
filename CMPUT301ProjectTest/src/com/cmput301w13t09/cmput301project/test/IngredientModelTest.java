package com.cmput301w13t09.cmput301project.test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import junit.framework.TestCase;

import org.junit.Test;

import android.test.ActivityInstrumentationTestCase2;

import com.cmput301w13t09.cmput301project.activities.AddNewIngredientView;
import com.cmput301w13t09.cmput301project.models.IngredientModel;

public class IngredientModelTest extends ActivityInstrumentationTestCase2<AddNewIngredientView>{


	
	public IngredientModelTest() {
		super("com.cmput301w13t09.cmput301project.activities", AddNewIngredientView.class);
		// TODO Auto-generated constructor stub
	}

	public void setUp(){
		
	}
	
	@Test
	public void testgetIngredientDesc(){
		IngredientModel i = new IngredientModel("Flour", "powder", 10, "g");
		assertTrue(i.getIngredientDesc().equals("powder"));
	}
		
	@Test
	public void testgetIngredientName(){
		IngredientModel i = new IngredientModel("Rice", "powder", 10, "g");
		assertTrue(i.getIngredientName().equals("Flour"));
	}
	
	@Test
	public void testgetIngredientQuantity(){
		IngredientModel i = new IngredientModel("Bread", "French Bread", 10, "g");
		assertTrue(i.getIngredientquantity() == 10);
	}
	
	@Test
	public void testEquals() {
		IngredientModel i1 = new IngredientModel ("Tomatoes", "half ripe");
		IngredientModel i2 = new IngredientModel ("Pepper", "ground pepper");
		IngredientModel i3 = new IngredientModel ("Pepper", "ground pepper");
		
		//Recipe should be equal to itself
		assertTrue(i1.equals(i1));
		
		//Recipes should be different from each other
		assertFalse(i2.equals(i1));
		
		//Recipes with same info should be equal
		assertTrue(i2.equals(i3));
	}

	
}

