package com.cmput301w13t09.cmput301project.test;

import android.graphics.Bitmap;
import android.test.ActivityInstrumentationTestCase2;

import com.cmput301w13t09.cmput301project.activities.CreateNewRecipeView;
import com.cmput301w13t09.cmput301project.models.PhotoModel;

public class PhotoModelTest extends ActivityInstrumentationTestCase2<CreateNewRecipeView>{


	public PhotoModelTest() {
		super("com.cmput301w13t09.cmput301project.activities", CreateNewRecipeView.class);
		// TODO Auto-generated constructor stub
	}

	
	public void testPhotoModel() {
		PhotoModel p = null;
		Bitmap b = BogoPicGen.generateBitmap(400, 400);
		p = new PhotoModel(b);
		assertNotNull(p);
	}

	
	public void testGetPhoto() {
		PhotoModel p = null;
		Bitmap b = BogoPicGen.generateBitmap(400, 400);
		p = new PhotoModel(b);
		assertNotNull(p);
		
		Bitmap b_test = p.getPhoto();
		assertNotNull(b_test);
	}

}
