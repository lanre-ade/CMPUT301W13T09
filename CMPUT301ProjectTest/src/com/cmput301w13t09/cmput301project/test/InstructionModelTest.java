package com.cmput301w13t09.cmput301project.test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import junit.framework.TestCase;

import org.junit.Test;

import android.test.ActivityInstrumentationTestCase2;

import com.cmput301w13t09.cmput301project.activities.CreateNewRecipeView;
import com.cmput301w13t09.cmput301project.activities.ModifiableRecipeViewInstructionSectionFragment;
import com.cmput301w13t09.cmput301project.models.InstructionModel;

public class InstructionModelTest extends ActivityInstrumentationTestCase2<CreateNewRecipeView>{


	public InstructionModelTest() {
		super("com.cmput301w13t09.cmput301project.activities", CreateNewRecipeView.class);
		// TODO Auto-generated constructor stub
	}

	public void setUp(){
		
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
	public void setInstructionModelTest(){
		String newInst = "Add Seasoning";
		InstructionModel inst = new InstructionModel("test");
		inst.setInstruction(newInst);
		assertTrue(inst.toString() == newInst);
		
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
