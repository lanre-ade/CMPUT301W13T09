package com.cmput301w13t09.cmput301project.test;

import android.test.ActivityInstrumentationTestCase2;

import com.cmput301w13t09.cmput301project.activities.MyPantryView;
import com.cmput301w13t09.cmput301project.controllers.IngredientController;
import com.cmput301w13t09.cmput301project.models.IngredientListModel;
import com.cmput301w13t09.cmput301project.models.IngredientModel;

public class IngredientControllerTest extends
		ActivityInstrumentationTestCase2 <MyPantryView>{
	private IngredientController iContr;

	public IngredientControllerTest() {
		super("com.cmput301w13t09.cmput301project.activities", MyPantryView.class);

	}


	protected void setUp() throws Exception {
		super.setUp();
		iContr = new IngredientController(getActivity());
	}

	

	public void testAdd() {
		assertTrue(iContr.getLength() == 0);
		IngredientModel i = new IngredientModel("Flour", "Made from rice", (float) 2.4, "cups");
		iContr.add(i);
		assertNotNull( iContr.getIngredient(0));
		
	}


	public void testGetIngredientList() {
		IngredientListModel list = iContr.getIngredientList();
		assertTrue(list.size() == 0);
		IngredientModel i = new IngredientModel("Flour1", "Made from rice", (float) 2.4, "cups");
		iContr.add(i);
		list = iContr.getIngredientList();
		assertTrue(list.size() == 1);
		
	}


	public void testGetLength() {
		IngredientModel i = new IngredientModel("Flour1", "Made from rice", (float) 2.4, "cups");
		iContr.add(i);
		assertTrue(iContr.getLength() == 1);
	}


	public void testGetIngredientListDesc() {
		IngredientModel i = new IngredientModel("Flour1", "Made from rice", (float) 2.4, "cups");
		iContr.add(i);
		String desc = iContr.getIngredientListDesc(0);
		assertEquals(desc, i.getIngredientDesc());
	}


	public void testGetIngredientListName() {
		IngredientModel i = new IngredientModel("Flour1", "Made from rice", (float) 2.4, "cups");
		iContr.add(i);
		String name = iContr.getIngredientListName(0);
		assertEquals(name, i.getIngredientName());
	}


	public void testGetIngredient() {
		IngredientModel i = new IngredientModel("Flour1", "Made from rice", (float) 2.4, "cups");
		iContr.add(i);
		IngredientModel ingredient = iContr.getIngredient(0);
		assertEquals(i, ingredient);
	}


	public void testEditIngredient() {
		IngredientModel i = new IngredientModel("Flour1", "Made from rice", (float) 2.4, "cups");
		iContr.add(i);
		String a = iContr.getIngredientListDesc(iContr.getLength()-1);
		iContr.editIngredient(iContr.getLength()-1, "Flour1", "Made from corn", (float) 2.4, "cups");
		String b = iContr.getIngredientListDesc(iContr.getLength()-1);
		assertTrue( a.compareTo(b) != 0 );
	}


	public void testRemove() {
		IngredientModel i = new IngredientModel("Flour1", "Made from rice", (float) 2.4, "cups");
		iContr.add(i);
		assertTrue(iContr.getLength() == 1);
		iContr.remove(0);
		assertTrue(iContr.getLength() == 0);
	}


	public void testLoadFromFile() {
		fail("Not yet implemented"); // TODO
	}


	public void testSaveToFile() {
		fail("Not yet implemented"); // TODO
	}

}
