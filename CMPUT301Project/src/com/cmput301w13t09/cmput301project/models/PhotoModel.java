package com.cmput301w13t09.cmput301project.models;

import java.io.ByteArrayOutputStream;
import java.io.Serializable;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

/**
 * Class: PhotoModel
 * 
 * @author Kyle,Marcus,Landre PhotoModel is a class that stores information
 *         about a photo used in recipes. PhotoModel stores the name
 *         (photo_name) and description (photo_desc) of a recipe. PhotoModels
 *         constructor takes in a name and description (desc). PhotoModel
 *         contains the methods getPhotoName() and getPhotoDesc().
 */

public class PhotoModel implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 4315977930836593716L;

	private byte[] photo;

	/**
	 * Constructor
	 * 
	 * @param name
	 *            : Name attached to the photo
	 * @param desc
	 *            : Description attached to the photo
	 */
	public PhotoModel(Bitmap p) {
		ByteArrayOutputStream stream = new ByteArrayOutputStream();
		
		Bitmap image = p;
		image.compress(Bitmap.CompressFormat.PNG, 100, stream);
		photo = stream.toByteArray();
	}

	/**
	 * Returns the name of the photo
	 * 
	 * @return Name of the photo
	 */
	public Bitmap getPhoto() {
		Bitmap p = BitmapFactory.decodeByteArray(photo, 0, photo.length);
		return p;
	}
}
