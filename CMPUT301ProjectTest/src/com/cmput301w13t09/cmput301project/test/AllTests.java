package com.cmput301w13t09.cmput301project.test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ DataCheckerTest.class, IngredientControllerTest.class,
		IngredientListModelTest.class, SearchRecipesTest.class,
		IngredientModelTest.class, InstructionModelTest.class,
		PhotoModelTest.class, RecipeControllerTest.class,
		RecipeListModelTest.class, RecipeModelTest.class,
		UpdateAddRecipeToWebTest.class })
public class AllTests {

}
