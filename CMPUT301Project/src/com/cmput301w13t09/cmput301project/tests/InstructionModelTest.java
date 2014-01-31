package com.cmput301w13t09.cmput301project.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import com.cmput301w13t09.cmput301project.models.InstructionModel;

public class InstructionModelTest {

	// private static final long serialVersionUID = 1L;
	@SuppressWarnings("unused")
	private String ingredient_desc;
	@SuppressWarnings("unused")
	private String ingredient_name;
	@SuppressWarnings("unused")
	private float ingredient_quantity;
	@SuppressWarnings("unused")
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
}
