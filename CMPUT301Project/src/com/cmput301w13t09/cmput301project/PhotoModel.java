package com.cmput301w13t09.cmput301project;

import java.io.Serializable;

import android.graphics.Bitmap;

/** Class: PhotoModel
 * @author Kyle,Marcus,Landre
 * PhotoModel is a class that stores information about a photo used 
 * in recipes. PhotoModel stores the name (photo_name) and description
 * (photo_desc) of a recipe. PhotoModels constructor takes in a name and 
 * description (desc). PhotoModel contains the methods getPhotoName() and 
 * getPhotoDesc().
 */


public class PhotoModel implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Bitmap photo;
	
	/** Constructor
	 * 
	 * @param name : Name attached to the photo
	 * @param desc : Description attached to the photo
	 */
	public PhotoModel(Bitmap p){
		photo = p;
	}
	
	/** Returns the name of the photo
	 * 
	 * @return Name of the photo
	 */
	public Bitmap getPhoto() {
		return photo;
	}
}
