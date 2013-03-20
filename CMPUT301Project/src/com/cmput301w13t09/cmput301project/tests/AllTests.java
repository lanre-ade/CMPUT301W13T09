package com.cmput301w13t09.cmput301project.tests;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ DataCheckerTest.class, IngredientControllerTest.class,
		IngredientModelTest.class, InstructionModelTest.class,
		PhotoAdapterTest.class, RecipeControllerTest.class,
		RecipeListModelTest.class, RecipeModelTest.class })
public class AllTests {

}
