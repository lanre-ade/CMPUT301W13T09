package com.cmput301w13t09.cmput301project;


	import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.*;

	/**
	 * A class that represents a recipe. Every recipe has a creator, and is to be
	 * fulfilled by a recipe member.
	 * 
	 * @author Katherine Jasniewski
	 * @author Jeanine Bonot
	 * 
	 */
	public class Recipe implements Serializable {

	    public static final String DATABASE_TABLE = "recipes"; // For SQL table
		private static final long serialVersionUID = 1L;

		private final String _creator;

		// Properties that may change
		private String _id;
		private String _name;
		private String _creationDate;
		private String _description;
		private ArrayList<byte[]> _photos; 
		private ArrayList<String[]> _ingredients;
		// SQL ids
		private String _creatorID;

		/**
		 * Creates a new instance of the RecipeElement class.
		 * 
		 * @param creator
		 *            The recipe creator.
		 */


		/**
		 * Creates a new instance of the RecipeElement class.
		 * 
		 * @param creator
		 *            The recipe creator.
		 * @param name
		 *            The recipe name.
		 * @param date
		 *            The recipe creation date.
		 * @param description
		 *            A description of the recipe.
		 */
		public Recipe(String creator, String name, String description,
				boolean requiresText, boolean requiresPhoto) {

			_creationDate = new SimpleDateFormat("MMM dd, yyyy | HH:mm")
					.format(Calendar.getInstance().getTime());

			_creator = creator;
			_name = name;
			_photos = new ArrayList<byte[]>();
			_ingredients = new ArrayList<String[]>();
			_description = description;
		}

		// Setters
		/**
		 * Sets the recipe ID if it has not yet been done so already.
		 * 
		 * @return true if the ID was set, false if the ID has already been set
		 */
		public void setID(String value) {
			_id = value;
		}

		public void setName(String value) {
			_name = value;
		}
		
		public void setCreatorID(String value){
			_creatorID = value;
		}
		
		public void setDate(String value){
			_creationDate = value;
		}

		public void setDescription(String value) {
			_description = value;
		}

		
		public void setPhotos(ArrayList<byte[]> photos){
			_photos = new ArrayList<byte[]>();
			_photos.addAll(photos);
		}
		public void setIngredients(ArrayList<String[]> ingredients){
            _ingredients = new ArrayList<String[]>();
            _ingredients.addAll(ingredients);
        }

		// Getters
		public String getCreator() {
			return _creator;
		}

		public String getCreatorID() {
			return _creatorID;
		}

		/** Gets the recipe ID */
		public String getID() {
			return _id;
		}

		public String getName() {
			return _name;
		}

		public String getDateCreated() {
			return _creationDate;
		}

		public String getDescription() {
			return _description;
		}

		public ArrayList<byte[]> getPhotos(){
			return _photos;
		}
		public ArrayList<String[]> getIngredients(){
	            return _ingredients;
	        }

		/** Gets the string summary for CrowdSourcer */
		public String getSummary() {
			return "<Recipe>" + _name + "<Creator>" + _creator + "<Date>"
					+ _creationDate + "<Description>"
					+ _description;

		}

}
