package com.cmput301w13t09.cmput301project;

public class NewRecipeBuilder {
	private IngredientListModel ingr_list;
	private InstructionListModel inst_list;
	public String name, description;
//	private PhotoListModel photo_list;

	public NewRecipeBuilder() {
		this.setIngredientList(new IngredientListModel());
		this.setInstructionList(new InstructionListModel());
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

	public IngredientListModel getIngredientList() {
		return ingr_list;
	}

	public void setIngredientList(IngredientListModel ingr_list) {
		this.ingr_list = ingr_list;
	}

	public InstructionListModel getInstructionList() {
		return inst_list;
	}

	public void setInstructionList(InstructionListModel inst_list) {
		this.inst_list = inst_list;
	}
	public RecipeModel createRecipe(){
		return new RecipeModel(this.name, this.description, this.ingr_list, this.inst_list);
	}
	public String getIngredientListName(int i){
		return ingr_list.get(i).getIngredientName();
	}
	public IngredientModel getIngredient(int i){
		return ingr_list.get(i);
	}
	public String getIngredientListDesc(int i){
		return ingr_list.get(i).getIngredientDesc();
	}
	public void editIngredient(int i, String tname, String tDescription,float tQuantity, String tUnit){
		ingr_list.set(i, new IngredientModel(tname, tDescription, tQuantity, tUnit));
	}
	
}
