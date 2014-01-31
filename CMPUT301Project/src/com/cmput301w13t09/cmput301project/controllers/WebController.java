package com.cmput301w13t09.cmput301project.controllers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONException;
import org.json.JSONObject;

import android.annotation.SuppressLint;

import com.cmput301w13t09.cmput301project.helpers.ElasticSearchResponse;
import com.cmput301w13t09.cmput301project.helpers.ElasticSearchSearchResponse;
import com.cmput301w13t09.cmput301project.models.RecipeListModel;
import com.cmput301w13t09.cmput301project.models.RecipeModel;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

/**
 * Class: Upload Controller is used to post and get recipes on web service
 * elasticsearch. The Controller initially loads all the recipes in a
 * RecipeListModel which allows for easy manipulation of data. The Controller
 * also enables users to post recipes on the web service and update them as
 * well.
 * 
 * @author Kyle,Marcus, Lanre
 * 
 */
@SuppressLint("DefaultLocale")
public class WebController {
	private RecipeListModel recipe_List;
	private Gson gson = new Gson();
	private HttpClient httpclient = new DefaultHttpClient();

	/**
	 * Constructor
	 * 
	 * @throws ClientProtocolException
	 * @throws IOException
	 */
	public WebController() throws ClientProtocolException, IOException {
		recipe_List = new RecipeListModel();
		this.loadFromWeb();
	}

	/**
	 * Returns name of recipe (RecipeListModel) based on its position in list
	 * 
	 * @param i
	 *            : Position of recipe in the list
	 * @return Name of recipe
	 */
	public String getRecipeListName(int i) {
		return recipe_List.get(i).getRecipeName();
	}

	/**
	 * Gets length of recipelist
	 * 
	 * @return int length of recipelist
	 */
	public int getLength() {
		return recipe_List.size();
	}

	/**
	 * Adds a recipe to recipe_list
	 * 
	 * @param recipe
	 * @return UploadController
	 */
	public WebController addRecipe(RecipeModel recipe) {
		recipe_List.add(recipe);
		return this;
	}

	/**
	 * Updates a recipe on the web service
	 * 
	 * @param recipe
	 * @param i
	 * @throws IllegalStateException
	 * @throws IOException
	 * @throws JSONException
	 */
	public void updateRecipe(RecipeModel recipe, int i) {
		HttpPost httpPost = new HttpPost(
				"http://cmput301.softwareprocess.es:8080/cmput301w13t09/recipelist/"
						+ String.valueOf(i));
		httpPost.setHeader("Content-type", "application/json");
		StringEntity stringentity = null;
		try {
			stringentity = new StringEntity(gson.toJson(recipe));
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch blockS
			e.printStackTrace();
		}
		httpPost.setEntity(stringentity);
		HttpResponse response = null;
		try {
			response = httpclient.execute(httpPost);
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String status = response.getStatusLine().toString();
		System.out.println(status);
	}

	/**
	 * Posts a recipe on the web service
	 * 
	 * @param recipe
	 * @throws IllegalStateException
	 * @throws IOException
	 * @throws JSONException
	 */
	public void insertRecipe(RecipeModel recipe) throws IllegalStateException,
			IOException, JSONException {
		HttpPost httpPost = new HttpPost(
				"http://cmput301.softwareprocess.es:8080/cmput301w13t09/recipelist/"
						+ String.valueOf(this.getRecipeListLength()));
		httpPost.setHeader("Content-type", "application/json");
		StringEntity stringentity = null;
		try {
			stringentity = new StringEntity(gson.toJson(recipe));
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch blockS
			e.printStackTrace();
		}
		httpPost.setEntity(stringentity);
		HttpResponse response = null;
		try {
			response = httpclient.execute(httpPost);
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String status = response.getStatusLine().toString();
		System.out.println(status);
		this.setRecipeListLength(this.getRecipeListLength() + 1);

	}

	/**
	 * Sets the RecipeListLength a value stored on web service used to track
	 * amount of recipes on web service
	 * 
	 * @param i
	 * @throws JSONException
	 */
	public void setRecipeListLength(int i) {
		HttpPost httpPost = new HttpPost(
				"http://cmput301.softwareprocess.es:8080/cmput301w13t09/recipelistlength/value");
		httpPost.setHeader("Content-type", "application/json");
		StringEntity stringentity = null;
		try {
			try {
				stringentity = new StringEntity(new JSONObject().put("Number",
						i).toString());
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch blockS
			e.printStackTrace();
		}
		httpPost.setEntity(stringentity);
		HttpResponse response = null;
		try {
			response = httpclient.execute(httpPost);
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String status = response.getStatusLine().toString();
		System.out.println(status);
	}

	/**
	 * Gets the RecipeListLength a value stored on web service used to track
	 * amount of recipes on webservice
	 * 
	 * @return
	 * @throws IOException
	 */
	public int getRecipeListLength() {
		HttpGet getRequest = new HttpGet(
				"http://cmput301.softwareprocess.es:8080/cmput301w13t09/recipelistlength/value");
		getRequest.addHeader("Content-type", "application/json");
		HttpResponse response = null;
		try {
			response = httpclient.execute(getRequest);
		} catch (ClientProtocolException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		String json = null;
		try {
			json = getEntityContent(response);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return Integer.parseInt(json.split("Number")[1].replace("\"", "")
				.replace(":", "").replace("}", ""));

	}

	/**
	 * Loads all recipes on web service into recipe_list used in constructor
	 * 
	 * @throws ClientProtocolException
	 * @throws IOException
	 */
	public void loadFromWeb() {
		if (getRecipeListLength() > 0) {
			HttpGet searchRequest = new HttpGet(
					"http://cmput301.softwareprocess.es:8080/cmput301w13t09/recipelist/_search");
			searchRequest.setHeader("Content-type", "application/json");
			HttpResponse response = null;
			try {
				response = httpclient.execute(searchRequest);
			} catch (ClientProtocolException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			String status = response.getStatusLine().toString();
			System.out.println(status);
			String json = null;
			try {
				json = getEntityContent(response);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			java.lang.reflect.Type elasticSearchSearchResponseType = new TypeToken<ElasticSearchSearchResponse<RecipeModel>>() {
			}.getType();
			ElasticSearchSearchResponse<RecipeModel> esResponse = gson
					.fromJson(json, elasticSearchSearchResponseType);
			System.err.println(esResponse);
			for (ElasticSearchResponse<RecipeModel> r : esResponse.getHits()) {
				RecipeModel recipe = r.getSource();
				System.err.println(recipe);
				this.addRecipe(recipe);
			}
		}

	}

	/**
	 * Used to gets values from response from HttpResponse and put in string
	 * format
	 * 
	 * @param response
	 * @return
	 * @throws IOException
	 */
	public String getEntityContent(HttpResponse response) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(
				(response.getEntity().getContent())));
		String output;
		System.err.println("Output from Server -> ");
		String json = "";
		while ((output = br.readLine()) != null) {
			System.err.println(output);
			json += output;
		}
		System.err.println("JSON:" + json);
		return json;
	}

	/**
	 * 
	 * @return the List of recipes
	 */
	public RecipeListModel getRecipeList() {
		return this.recipe_List;
	}

	/**
	 * Searches for fname in RecipeList and returns the position in list.
	 * 
	 * @param fname
	 * @return Returns position of name found in RecipeList if not found returns
	 *         -1
	 */

	@SuppressLint("DefaultLocale")
	public int findRecipe(String fname) {
		int position = -1;
		for (int i = 0; i < this.recipe_List.size(); i++) {
			if (checkIfRecipeFound(fname, i)) {
				position = i;
			}
		}
		return position;
	}

	private boolean checkIfRecipeFound(String fname, int i) {
		return fname
				.trim()
				.toLowerCase()
				.equals(this.recipe_List.get(i).getRecipeName().trim()
						.toLowerCase());
	}

	/**
	 * Returns position of name found in RecipeList if ingredients are in
	 * MyPantry otherwise return -1
	 * 
	 * @param position
	 * @param ingredController
	 * @return returns position of name found in RecipeList if ingredients are
	 *         in MyPantry otherwise return -1
	 */
	@SuppressLint("DefaultLocale")
	public int checkRecipeHasIngredients(int position,
			IngredientController ingredController) {
		// If no recipe is found
		if (position == -1) {
			return position;
		}
		int count = 0;
		for (int i = 0; i < this.recipe_List.get(position).getIngredList()
				.size(); i++) {
			int z = 1;
			for (int j = 0; j < ingredController.getIngredientList().size(); j++) {
				if (processRecipeListString(position, i)
						.equals(processIngredientControllerString(ingredController, j))
						&& z == 1) {
					z = 0;
					count++;
				}
			}
		}
		if (count == this.recipe_List.get(position).getIngredList().size()) {
			return position;
		} else {
			return -1;
		}
	}

	private String processIngredientControllerString(
			IngredientController ingredController, int j) {
		return ingredController.getIngredient(j)
				.getIngredientName().trim().toLowerCase();
	}

	private String processRecipeListString(int position, int i) {
		return recipe_List
				.get(position)
				.getIngredList()
				.get(i)
				.getIngredientName()
				.trim()
				.toLowerCase();
	}

	/**
	 * Returns a RecipeList that is all the recipes that have all ingredients in
	 * IngredientController
	 * 
	 * @param ingredController
	 * @return
	 */
	public RecipeListModel getQueryRecipeList(
			IngredientController ingredController) {
		RecipeListModel temp = new RecipeListModel();
		for (int i = 0; i < this.recipe_List.size(); i++) {
			if (this.checkRecipeHasIngredients(i, ingredController) != -1) {
				temp.add(recipe_List.get(i));
			}
		}
		return temp;
	}

	/**
	 * Returns the recipe at position i in the load recipe list
	 * 
	 * @param i
	 *            : position of the recipe in the list
	 * @return recipe at position i
	 */
	public RecipeModel getRecipe(int i) {
		return recipe_List.get(i);
	}

}
