package com.cmput301w13t09.cmput301project.test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.cmput301w13t09.cmput301project.models.InstructionModel;

public class InstructionModelTest {

	// private static final long serialVersionUID = 1L;
	private String ingredient_desc;
	private String ingredient_name;
	private float ingredient_quantity;
	private String ingredient_quantity_unit;

	public InstructionModelTest() {
	}

	@Test
	public void testInstructionModel() {
		Object a = null;
		a = new InstructionModel("Instruction");
		assertNotNull(a);
	}

	@Test
	public void testInstructionModelString() {
		Object a = new InstructionModel(
				"Boil the rice for 10 minutes \n Add salt \n Boil for another 10 minutes "
						+ "\n Turn down heat");
		assertNotNull(a);
	}

	@Test
	public void testToString() {
		InstructionModel a = new InstructionModel(
				"Boil the rice for 10 minutes \n Add salt \n Boil for another 10 minutes "
						+ "\n Turn down heat");
		String Inst = a.toString();
		assertTrue(Inst == "Boil the rice for 10 minutes \n Add salt \n Boil for another 10 minutes "
				+ "\n Turn down heat");
	}

	@Test
	public void testNullString() {
		String s = null;
		InstructionModel Inst = new InstructionModel(s);
		assertNotNull(Inst);
	}
	
	@Test
	public void testEquals() {
		InstructionModel a = new InstructionModel ("Stir for 5 hours");
		InstructionModel b = new InstructionModel ("Stir for 15 minutes");
		InstructionModel c = new InstructionModel ("Stir for 15 minutes");
		
		//Instruction should be equal to itself
		assertTrue(a.equals(a));
		
		//Dissimilar Instructions should be different from each other
		assertFalse(a.equals(b));
		
		//Instructions with same info should be equal
		assertTrue(b.equals(c));
	}

}
