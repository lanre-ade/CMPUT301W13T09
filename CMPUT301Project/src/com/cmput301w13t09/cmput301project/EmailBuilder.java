package com.cmput301w13t09.cmput301project;

public class EmailBuilder {
	private RecipeModel recipe;
	private String message;

	public EmailBuilder(RecipeModel nrecipe) {
		recipe = nrecipe;
	}

	private void BuildMessage() {
		StringBuilder messageBuilder = new StringBuilder();
		messageBuilder.append(recipe.getRecipeName() + "\n\n");
		messageBuilder.append(recipe.getRecipeDesc() + "\n\n");
		messageBuilder.append("Ingredients:\n");
		IngredientModel ingred;
		for (int i = 0; i < recipe.getIngredList().size(); i++) {
			ingred = recipe.getIngredList().get(i);
			messageBuilder.append("\t" + (i+1) + ": " + ingred.getIngredientName()
					+ " " + ingred.getIngredientquantity() + " "
					+ ingred.getIngredientquantityunit()
					+ "\n\t\t"+ingred.getIngredientDesc()+"\n");
		}
		InstructionModel instr;
		messageBuilder.append("\nInstructions:\n");
		for (int i = 0; i < recipe.getInstucuctionListModel().size(); i++) {
			instr = recipe.getInstucuctionListModel().get(i);
			messageBuilder.append("\t"+(i+1)+": "+instr.toString()+"\n");
		}
		message = messageBuilder.toString();
	}
	public String getMessage(){
		BuildMessage();
		return message;
	}

}
