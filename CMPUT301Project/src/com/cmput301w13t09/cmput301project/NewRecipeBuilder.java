package com.cmput301w13t09.cmput301project;

public class NewRecipeBuilder {
	private IngredientListModel ingr_list;
	private InstructionListModel inst_list;
	private String name, description;
//	private PhotoListModel photo_list;

	public NewRecipeBuilder() {
		setIngr_list(new IngredientListModel());
		setInst_list(new InstructionListModel());
//		photo_list = new PhotoListModel();
	}

	public void addIngredient(IngredientModel ing) {
		ingr_list.add(ing);
	}

	public void removeIngredient(int i) {
		ingr_list.remove(i);
	}

	public void addInstruction(InstructionModel ins) {
		inst_list.add(ins);
	}

	public void removeInstruction(int i) {
		inst_list.remove(i);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public IngredientListModel getIngr_list() {
		return ingr_list;
	}

	public void setIngr_list(IngredientListModel ingr_list) {
		this.ingr_list = ingr_list;
	}

	public InstructionListModel getInst_list() {
		return inst_list;
	}

	public void setInst_list(InstructionListModel inst_list) {
		this.inst_list = inst_list;
	}
	
}
