package com.cmput301w13t09.cmput301project;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;


/**
 * RecipeDBAdapter<br>
 * A simple SQLite database helper class. Gives the abilities needed by the main
 * application to access recipes, photos and available data.
 * 
 */
public class RecipeDBAdapter {

	public DBModel databaseModel = new DBModel();
	public static final String ID = "_id";
	public static final String DATE = "date";
	public static final String RECIPE = "recipe";
	public static final String RECIPE_ID = "recipe_id";
	public static final String PHOTO = "photo";
	public static final String INGREDIENT = "ingredient";
	public static final String USER = "user";
	public static final String USER_ID = "user_id";
	public static final String PROCEDURE = "procedure";
	public static final String EMAIL = "email";
	public static final String PASSWORD = "password";
	
	
	private SQLiteDatabase mDb;

	private static final String TABLE_PHOTOS = "photos";
	private static final String TABLE_RECIPES = "recipes";
	private static final String TABLE_USERS = "users";
	private static final String TABLE_INGREDIENTS = "ingredients";



	/**
	 * Constructor - takes the context to allow the database to be
	 * opened/created and gives it to the model
	 * 
	 * @param ctx
	 *            the Context within which to work
	 */
	public RecipeDBAdapter(Context ctx) {
		Log.d("DEBUG", "RecipeDBAdapter(Context)");
		databaseModel.setMCtx(ctx);
	}

	/**
	 * Open the entries database. If it cannot be opened, try to create a new
	 * instance of the database. If it cannot be created, throw an exception to
	 * signal the failure
	 * 
	 * @return this (self reference, allowing this to be chained in an
	 *         initialization call)
	 * @throws SQLException
	 *             if the database could be neither opened or created
	 */
	public RecipeDBAdapter open() throws SQLException {
		return databaseModel.open(this);
	}

	/**
	 * Closes the database
	 */
	public void close() {
		databaseModel.close();
	}

	/**
	 * Create a new entry using the information provided. If the entry is
	 * successfully created return the new rowId for that entry, otherwise
	 * return a -1 to indicate failure.
	 * 
	 * @param date
	 *            the date (in yyyy-MM-dd | hh:mm format)
	 * @param folder
	 *            the folder the photo is in
	 * @param tag
	 *            the tag the photo is under
	 * @param photo
	 *            the photo in byte array format
	 * @return rowId or -1 if failed
	 */
	public long createPhoto(String date, String recipeID, byte[] photo) {
		ContentValues initialValues = new ContentValues();

		initialValues.put(DATE, date);
		initialValues.put(PHOTO, photo);
		initialValues.put(RECIPE_ID, recipeID);

		return mDb.insert(TABLE_PHOTOS, null, initialValues);
	}

	/**
	 * Create a new entry using the information provided. If the entry is
	 * successfully created return the new rowId for that entry, otherwise
	 * return a -1 to indicate failure.
	 * 
	 * @param folder
	 *            the folder
	 * @return rowId or -1 if failed
	 */
	public long createRecipe(Recipe recipe) {
		ContentValues initialValues = new ContentValues();
		initialValues.put(ID, recipe.getID());
		initialValues.put(RECIPE, recipe.getName());
		initialValues.put(DATE, recipe.getDateCreated());
		initialValues.put(USER, recipe.getCreator());
		initialValues.put(PROCEDURE, recipe.getDescription());


		return mDb.insert(TABLE_RECIPES, null, initialValues);
	}

	

	/**
	 * Create a new entry using the information provided. If the entry is
	 * successfully created return the new rowId for that entry, otherwise
	 * return a -1 to indicate failure.
	 * 
	 * @param folder
	 *            the folder
	 * @return rowId or -1 if failed
	 */
	public long createUser(String user, String email, String password, String id) {
		ContentValues initialValues = new ContentValues();

		initialValues.put(ID, id);
		initialValues.put(USER, user);
		initialValues.put(EMAIL, email);
		initialValues.put(PASSWORD, password);

		return mDb.insert(TABLE_USERS, null, initialValues);
	}

	/**
	 * Create a new entry using the information provided. If the entry is
	 * successfully created return the new rowId for that entry, otherwise
	 * return a -1 to indicate failure.
	 * 
	 * @param folder
	 *            the folder
	 * @return rowId or -1 if failed
	 */
	public long createUser(String userID, String username) {
		ContentValues initialValues = new ContentValues();

		initialValues.put(ID, userID);
		initialValues.put(USER, username);
		return mDb.insert(TABLE_USERS, null, initialValues);
	}

	/**
	 * Create a new entry using the information provided. If the entry is
	 * successfully created return the new rowId for that entry, otherwise
	 * return a -1 to indicate failure.
	 * 
	 * @param folder
	 *            the folder
	 * @return rowId or -1 if failed
	 */
	public long createUser(String user, String email, String password) {
		ContentValues initialValues = new ContentValues();

		initialValues.put(USER, user);
		initialValues.put(EMAIL, email);
		initialValues.put(PASSWORD, password);

		return mDb.insert(TABLE_USERS, null, initialValues);
	}

	public long updateUser(String user, String username, String email,
			String password) {
		ContentValues newValues = new ContentValues();

		newValues.put(USER, user);
		newValues.put(EMAIL, email);
		newValues.put(PASSWORD, password);

		return mDb.update(TABLE_USERS, newValues, USER + "='" + user + "'",
				null);
	}

	/**
	 * Create a new entry using the information provided. If the entry is
	 * successfully created return the new rowId for that entry, otherwise
	 * return a -1 to indicate failure.r
	 * @return rowId or -1 if failed
	 */
	public long createIngredient(String date, String ingredient) {
		ContentValues initialValues = new ContentValues();

		initialValues.put(INGREDIENT, ingredient);
		initialValues.put(DATE, date);

		return mDb.insert(TABLE_INGREDIENTS, null, initialValues);
	}
	public long createIngredient(String recipeID, String date, String ingredient) {
		ContentValues initialValues = new ContentValues();

		initialValues.put(RECIPE_ID, recipeID);
		initialValues.put(INGREDIENT, ingredient);
		initialValues.put(DATE, date);

		return mDb.insert(TABLE_INGREDIENTS, null, initialValues);
	}
	

	/**
	 * Delete the entry with the given rowId
	 * 
	 * @param rowId
	 *            id of entry to delete
	 * @return true if deleted, false otherwise
	 */
	public boolean deletePhoto(long rowId) {
		return mDb.delete(TABLE_PHOTOS, ID + "=" + rowId, null) > 0;
	}
	
	/**
	 * Delete the entry with the given rowId
	 * 
	 * @param rowId
	 *            id of entry to delete
	 * @return true if deleted, false otherwise
	 */
	public boolean deleteIngredient(long rowId) {
		return mDb.delete(TABLE_INGREDIENTS, ID + "=" + rowId, null) > 0;
	}
	/**
	 * Delete the entry with the given rowId
	 * 
	 * @param rowId
	 *            id of entry to delete
	 * @return true if deleted, false otherwise
	 */
	public boolean deleteRecipe(long rowId) {
		return mDb.delete(TABLE_RECIPES, ID + "=" + rowId, null) > 0;
	}

	/**
	 * Delete all of the photos in the given folder Id of folder in folder table
	 * is given to streamline deletion process.
	 * 
	 * @param recipe
	 *            name of folder to delete photos from
	 * @return true if deleted, false otherwise
	 */
	public boolean deletePhotosInRecipe(String recipeID) {
		return mDb.delete(TABLE_PHOTOS, RECIPE_ID + "=" + recipeID, null) > 0;
	}

	/**
	 * Return a Cursor over the list of all recipes in the table
	 * 
	 * @return Cursor over all folders
	 */
	public Cursor fetchAllRecipes() {
		return mDb.query(TABLE_RECIPES, new String[] { ID, RECIPE, USER, DATE },
				null, null, null, null, null);
	}
	

	/**
	 * Get the list of text ingredients of a recipe.
	 * 
	 * @param recipeID
	 *            the hexadecimal string ID of a recipe.
	 * @return a cursor over the list of ingredients for a recipe
	 */
	public Cursor ingredient(String recipeID) {

		return mDb.query(TABLE_INGREDIENTS, new String[] { ID, RECIPE_ID, DATE,
				USER, PROCEDURE }, RECIPE_ID + "='" + recipeID + "'", null, null, null,
				null, null);
	}

	/**
	 * Get the cursor for the recipe with the provided recipe ID
	 * 
	 * @param recipeID
	 *            the hexadecimal string ID of the recipe in the table
	 * @return a cursor over a list of recipes with the provided recipe ID
	 */
	public Cursor fetchRecipe(String recipeID) {
		return mDb.query(TABLE_RECIPES, new String[] { ID, RECIPE, DATE, USER,
				PROCEDURE }, ID + "='" + recipeID
				+ "'", null, null, null, null, null);
	}


	/**
	 * Returns a cursor that points to data with the requested tag
	 * 
	 * @param recipe
	 *            retrieve photos with given recipe
	 * @return Cursor that traverses photos with given recipe
	 */
	public Cursor fetchPhotosUnderRecipe(String recipeID) {
		Cursor mCursor = mDb.query(true, TABLE_PHOTOS, new String[] { ID, DATE,
				RECIPE_ID, PHOTO }, RECIPE_ID + "=" + recipeID, null, null, null,
				null, null);

		return mCursor;
	}

	/**
	 * Sets the database
	 * 
	 * @param mDb
	 *            Takes in the SQL database
	 */
	public void setMDb(SQLiteDatabase mDb) {
		this.mDb = mDb;
	}

	/**
	 * Clear all the tables and restart them.
	 */
	public void resetDatabase() {

		for (String table : DBModel.TABLE_NAMES) {
			mDb.execSQL("DROP TABLE IF EXISTS " + table);
			Log.d("RESET", table);
		}

		for (String createTable : DBModel.CREATE_TABLES) {
			mDb.execSQL(createTable);
			Log.d("CREATE", createTable);
		}
	}


}
