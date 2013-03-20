package com.cmput301w13t09.cmput301project.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import android.content.Context;
import android.test.ActivityInstrumentationTestCase2;

import com.cmput301w13t09.cmput301project.IngredientController;
import com.cmput301w13t09.cmput301project.IngredientListModel;
import com.cmput301w13t09.cmput301project.IngredientModel;
import com.cmput301w13t09.cmput301project.activities.CreateNewRecipeView;

public class IngredientControllerTest extends ActivityInstrumentationTestCase2<CreateNewRecipeView>{

	IngredientController iContr;
	public IngredientControllerTest() {
		super(CreateNewRecipeView.class);
		iContr  = new IngredientController(getActivity());
	}

	@Test
	public void testAdd() {
		IngredientModel i = new IngredientModel("Flour", "Made from rice", (float) 2.4, "cups");
		iContr.add(i);
		assertNotNull( iContr.getIngredient(iContr.getLength()-1));
		
	}

	@Test
	public void testGetIngredientList() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public void testGetLength() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public void testGetIngredientListDesc() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public void testGetIngredientListName() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public void testGetIngredient() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public void testEditIngredient() {
		IngredientModel i = new IngredientModel("Flour1", "Made from rice", (float) 2.4, "cups");
		iContr.add(i);
		String a = iContr.getIngredientListDesc(iContr.getLength()-1);
		iContr.editIngredient(iContr.getLength()-1, "Flour1", "Made from corn", (float) 2.4, "cups");
		String b = iContr.getIngredientListDesc(iContr.getLength()-1);
		assertTrue( a.compareTo(b) != 0 );
	}

	@Test
	public void testRemove() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public void testLoadFromFile() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public void testSaveToFile() {
		fail("Not yet implemented"); // TODO
	}

}
