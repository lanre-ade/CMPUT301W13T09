package com.cmput301w13t09.cmput301project.test;

import static org.junit.Assert.*;
import junit.framework.TestCase;

import org.junit.Test;

import com.cmput301w13t09.cmput301project.models.IngredientListModel;
import com.cmput301w13t09.cmput301project.models.IngredientModel;

public class IngredientListModelTest extends TestCase{
private IngredientListModel iList;

public void setup() throws Exception{
	iList = new IngredientListModel();
}    

	@Test
	public void testAddIngredient() {
		IngredientModel i = new IngredientModel("Flour", "White Powder");
		assertEquals(0, iList.size());
		boolean res = iList.add(i);
		assertTrue(res);
		assertEquals(1, iList.size());
		assertEquals(i, iList.get(0));
		
	}
	
	public void testDeleteIngredient(){
		IngredientModel i = new IngredientModel("Flour", "White Powder");
		assertEquals(0, iList.size());
		boolean res = iList.add(i);
		assertTrue(res);
		assertEquals(1, iList.size());
		assertEquals(i, iList.get(0));
		
		iList.remove(0);
		assertTrue(iList.size() == 0);
		
	}

}
