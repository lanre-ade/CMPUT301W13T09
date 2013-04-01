package com.cmput301w13t09.cmput301project.test;

import org.junit.Before;
import org.junit.Test;

import android.test.ActivityInstrumentationTestCase2;

import com.cmput301w13t09.cmput301project.activities.MyPantryView;
import com.cmput301w13t09.cmput301project.controllers.IngredientController;
import com.cmput301w13t09.cmput301project.models.IngredientModel;

public class IngredientControllerTest extends
		ActivityInstrumentationTestCase2 <MyPantryView>{
	private IngredientController iContr;

	public IngredientControllerTest() {
		super("com.cmput301w13t09.cmput301project.activities", MyPantryView.class);

	}

	@Before
	protected void setUp() throws Exception {
		super.setUp();
		iContr = new IngredientController(getActivity());
	}

	
	@Test
	public void testAdd() {
		assertTrue(iContr.getLength() == 0);
		IngredientModel i = new IngredientModel("Flour", "Made from rice", (float) 2.4, "cups");
		iContr.add(i);
		assertNotNull( iContr.getIngredient(0));
		
	}

	@Test
	public void testGetIngredientList() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public void testGetLength() {
		IngredientModel i = new IngredientModel("Flour1", "Made from rice", (float) 2.4, "cups");
		iContr.add(i);
		assertTrue(iContr.getLength() == 1);
	}

	@Test
	public void testGetIngredientListDesc() {
		IngredientModel i = new IngredientModel("Flour1", "Made from rice", (float) 2.4, "cups");
		iContr.add(i);
		String desc = iContr.getIngredientListDesc(0);
		assertEquals(desc, i.getIngredientDesc());
	}

	@Test
	public void testGetIngredientListName() {
		IngredientModel i = new IngredientModel("Flour1", "Made from rice", (float) 2.4, "cups");
		iContr.add(i);
		String name = iContr.getIngredientListName(0);
		assertEquals(name, i.getIngredientName());
	}

	@Test
	public void testGetIngredient() {
		IngredientModel i = new IngredientModel("Flour1", "Made from rice", (float) 2.4, "cups");
		iContr.add(i);
		IngredientModel ingredient = iContr.getIngredient(0);
		assertEquals(i, ingredient);
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
		IngredientModel i = new IngredientModel("Flour1", "Made from rice", (float) 2.4, "cups");
		iContr.add(i);
		assertTrue(iContr.getLength() == 1);
		iContr.remove(0);
		assertTrue(iContr.getLength() == 0);
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
