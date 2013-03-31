package com.cmput301w13t09.cmput301project.test;

import org.junit.Before;
import org.junit.Test;

import android.test.ActivityInstrumentationTestCase2;

import com.cmput301w13t09.cmput301project.activities.MyPantryView;
import com.cmput301w13t09.cmput301project.controllers.IngredientController;
import com.cmput301w13t09.cmput301project.models.IngredientModel;

public class IngredientControllerTest extends
		ActivityInstrumentationTestCase2<MyPantryView> {
	private IngredientController iContr;

	public IngredientControllerTest() {
		super("com.cmput301w13t09.cmput301project.test", MyPantryView.class);

	}

	@Before
	protected void setUp() throws Exception {
		super.setUp();
		iContr = new IngredientController(getActivity());
	}

	@Test
	public void testIngredientController() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public void testAdd() {
		int oldLength = iContr.getLength();
		IngredientModel i = new IngredientModel("Flour", "Made from rice",
				(float) 2.4, "cups");
		iContr.add(i);
		int newLength = iContr.getLength();
		assertTrue(newLength == oldLength + 1);

	}

	@Test
	public void testGetIngredientList() {
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
		IngredientModel i = new IngredientModel("Flour1", "Made from rice",
				(float) 2.4, "cups");
		iContr.add(i);
		String a = iContr.getIngredientListDesc(iContr.getLength() - 1);
		iContr.editIngredient(iContr.getLength() - 1, "Flour1",
				"Made from corn", (float) 2.4, "cups");
		String b = iContr.getIngredientListDesc(iContr.getLength() - 1);
		assertTrue(a.compareTo(b) != 0);
	}

	@Test
	public void testRemove() {
		IngredientModel a = new IngredientModel("Potatoes",
				"Healthy and cheap", 3, "units");
		IngredientModel b = new IngredientModel("Bacon", "Its canadian eh", 1,
				"unit");
		iContr.add(a);
		iContr.add(b);
		int oldLength = iContr.getLength();
		iContr.remove(iContr.getLength() - 1);
		int newLength = iContr.getLength();
		assertTrue(newLength == oldLength - 1);

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
