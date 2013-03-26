package com.cmput301w13t09.cmput301project;

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

import android.renderscript.Type;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

public class UploadController {
	private RecipeListModel recipe_list;
	private Gson gson = new Gson();
	private HttpClient httpclient = new DefaultHttpClient();

	public UploadController() throws ClientProtocolException, IOException {
		recipe_list = new RecipeListModel();
		this.loadFromWeb();
	}

	public int getLength() {
		return recipe_list.size();
	}

	public UploadController addRecipe(RecipeModel recipe) {
		recipe_list.add(recipe);
		return this;
	}

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

	public void setRecipeListLength(int i) throws JSONException {
		HttpPost httpPost = new HttpPost(
				"http://cmput301.softwareprocess.es:8080/cmput301w13t09/recipelistlength/value");
		httpPost.setHeader("Content-type", "application/json");
		StringEntity stringentity = null;
		try {
			stringentity = new StringEntity(new JSONObject().put("Number", i)
					.toString());
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

	public int getRecipeListLength() throws IOException {
		HttpGet getRequest = new HttpGet(
				"http://cmput301.softwareprocess.es:8080/cmput301w13t09/recipelistlength/value");
		getRequest.addHeader("Content-type", "application/json");
		HttpResponse response = httpclient.execute(getRequest);
		String json = getEntityContent(response);
		return Integer.parseInt(json.split("Number")[1].replace("\"", "")
				.replace(":", "").replace("}", ""));

	}

	public void loadFromWeb() throws ClientProtocolException, IOException {
		if (getRecipeListLength() > 0) {
			HttpGet searchRequest = new HttpGet(
					"http://cmput301.softwareprocess.es:8080/cmput301w13t09/recipelist/_search");
			searchRequest.setHeader("Content-type", "application/json");
			HttpResponse response = httpclient.execute(searchRequest);
			String status = response.getStatusLine().toString();
			System.out.println(status);
			String json = getEntityContent(response);
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
		return this.recipe_list;
	}

}
