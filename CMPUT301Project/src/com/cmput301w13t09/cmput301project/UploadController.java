package com.cmput301w13t09.cmput301project;

import java.io.BufferedReader;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;

import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class UploadController {
	private RecipeListModel recipe_list;
	private Gson gson = new Gson();
	private HttpClient httpclient = new DefaultHttpClient();

	public UploadController() throws ClientProtocolException, IOException {
		recipe_list = new RecipeListModel();
		//this.createFile();
		//this.loadFromWeb();
	}

	public String createFile() throws IllegalStateException, IOException {
		HttpPost httpPost = new HttpPost(
				"http://cmput301.softwareprocess.es:8080/CMPUT301W13T09/recipelist");
		StringEntity stringentity = null;
		try {
			stringentity = new StringEntity(
					gson.toJson((new RecipeListModel())));
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		httpPost.setEntity(stringentity);
		httpPost.setHeader("Accept", "application/json");
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
		return status;
		/*System.out.println(status);
		HttpEntity entity = response.getEntity();
		BufferedReader br = new BufferedReader(new InputStreamReader(
				entity.getContent()));
		String output;
		System.err.println("Output from Server -> ");
		while ((output = br.readLine()) != null) {
			System.err.println(output);
		}*/
	}

	public String loadFromWeb() throws ClientProtocolException, IOException {
		HttpGet getRequest = new HttpGet(
				"http://cmput301.softwareprocess.es:8080/CMPUT301W13T09/recipelist");

		getRequest.addHeader("Content-type", "application/json");

		HttpResponse response = httpclient.execute(getRequest);

		String status = response.getStatusLine().toString();
		System.out.println(status);

		String json = getEntityContent(response);
		return status;
		//this.recipe_list = gson.fromJson(json, RecipeListModel.class);
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

	public String jassson() {
		String json = gson.toJson(recipe_list);
		return json;
	}

	public RecipeListModel jassson2() {
		String json = this.jassson();
		RecipeListModel obj = gson.fromJson(json, RecipeListModel.class);
		return obj;

	}

}
