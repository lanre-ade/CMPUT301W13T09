package com.cmput301w13t09.cmput301project;
/**
 * 
 * @author Marcus, Lanre, and Kyle
 *  Builds email content from a recipe
 *
 */
public class EmailBuilder {
	private RecipeModel recipe;
	private String message;
	/**
	 * 
	 * @param nrecipe: The recipe that the email content will be based of
	 */
	public EmailBuilder(RecipeModel nrecipe) {
		recipe = nrecipe;
	}
	/**
	 * 	Builds message
	 */
	private void BuildMessage() {
		StringBuilder messageBuilder = new StringBuilder();
		messageBuilder.append("Title:\n\t"+recipe.getRecipeName() + "\n\n");
		messageBuilder.append("Description:\n\t"+recipe.getRecipeDesc() + "\n\n");
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
	/**
	 * 
	 * @return The content of an email based of the provided recipe
	 */
	public String getMessage(){
		BuildMessage();
		return message;
	}

}
