package com.cmput301w13t09.cmput301project.test;

import static org.junit.Assert.*;
import junit.framework.TestCase;

import org.junit.Test;

import android.graphics.Bitmap;

import com.cmput301w13t09.cmput301project.models.PhotoModel;

public class PhotoModelTest extends TestCase{

	public PhotoModelTest() {
	}

	@Test
	public void testPhotoModel() {
		PhotoModel p = null;
		Bitmap b = BogoPicGen.generateBitmap(400, 400);
		p = new PhotoModel(b);
		assertNotNull(p);
	}

	@Test
	public void testGetPhoto() {
		PhotoModel p = null;
		Bitmap b = BogoPicGen.generateBitmap(400, 400);
		p = new PhotoModel(b);
		assertNotNull(p);
		
		Bitmap b_test = p.getPhoto();
		assertEquals(b, b_test);
	}

}
