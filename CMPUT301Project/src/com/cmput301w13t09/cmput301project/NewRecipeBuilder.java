package com.cmput301w13t09.cmput301project;

public class NewRecipeBuilder {
	private IngredientListModel ingr_list;
	private InstructionListModel inst_list;
	private String name, description;
	private PhotoListModel photo_list;
	
	public NewRecipeBuilder(){
		ingr_list = new IngredientListModel();
		inst_list = new InstructionListModel();
		photo_list = new PhotoListModel();
	}

}
