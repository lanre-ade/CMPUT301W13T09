package com.cmput301w13t09.cmput301project;

import com.cmput301w13t09.cmput301project.RecipeDBAdapter;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/** 
 * DatabaseModel<br>
 * Creates the tables in the database and opens and closes it to allow
 * it to be queried.
 */
public class DBModel {
	private DatabaseHelper mDbHelper;
	private Context mCtx;

	/**
	 * Database creation SQL statement.
	 */
	private static final String USERS = "CREATE TABLE users (_id TEXT NOT NULL PRIMARY KEY, "
			+ "user TEXT NOT NULL, "
			+ "email TEXT, "
			+ "password TEXT);";

	private static final String RECIPES = "CREATE TABLE recipes (_id INTEGER NOT NULL primary key autoincrement, "
			+ "recipe TEXT NOT NULL, "
			+ "date TEXT NOT NULL, "
			+ "user TEXT NOT NULL, "
			+ "procedure TEXT NOT NULL);";

	private static final String INGREDIENTS = "CREATE TABLE ingredients(_id INTEGER primary key autoincrement,  "
			+ "recipe_id INTEGER, "
			+ "user TEXT NOT NULL, "
			+ "ingredient TEXT NOT NULL);";

	private static final String PHOTOS = "CREATE TABLE photos(_id INTEGER primary key autoincrement,  "
			+ "recipe_id INTEGER, "
			+ "date TEXT NOT NULL, " + "photo BLOB NOT NULL);";

	public static final String[] CREATE_TABLES = new String[] {//
	USERS, RECIPES, INGREDIENTS, PHOTOS, };

	public static final String[] TABLE_NAMES = new String[] { //
	"users", "recipes", "ingredients", "photos" };

	private static final String DATABASE_NAME = "data";
	
	private static final int DATABASE_VERSION = 5;

	private static final String NAME = "dbAdapter";

	private static class DatabaseHelper extends SQLiteOpenHelper {

		DatabaseHelper(Context context) {

			super(context, DATABASE_NAME, null, DATABASE_VERSION);
		}

		@Override
		public void onCreate(SQLiteDatabase db) {

			for (String createTable : CREATE_TABLES) {
				db.execSQL(createTable);
			}
		}

		@Override
		public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

			Log.w(NAME, "Upgrading database from version " + oldVersion
					+ " to " + newVersion + ", which will destroy all old data");
			for (String table : TABLE_NAMES) {
				db.execSQL("DROP TABLE IF EXISTS " + table);
			}
			onCreate(db);
		}
	}

	/**
	 * Gets the database.
	 * 
	 * @return mDbHelper
	 */
	public DatabaseHelper getMDbHelper() {

		return mDbHelper;
	}

	/**
	 * Sets the database
	 * 
	 * @param mDbHelper
	 */
	public void setMDbHelper(DatabaseHelper mDbHelper) {

		this.mDbHelper = mDbHelper;
	}

	/**
	 * Gets the context of the activity
	 * 
	 * @return mCtx the context of the activity
	 */
	public Context getMCtx() {

		return mCtx;
	}

	/**
	 * Sets the context.
	 * 
	 * @param mCtx
	 *            the context of the activity
	 */
	public void setMCtx(Context mCtx) {

		this.mCtx = mCtx;
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
	public RecipeDBAdapter open(RecipeDBAdapter databaseAdapter)
			throws SQLException {

		mDbHelper = new DatabaseHelper(mCtx);
		databaseAdapter.setMDb(mDbHelper.getWritableDatabase());
		return databaseAdapter;
	}

	/**
	 * Closes the database
	 */
	public void close() {
		mDbHelper.close();
	}


}
