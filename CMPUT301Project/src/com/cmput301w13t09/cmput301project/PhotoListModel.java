package com.cmput301w13t09.cmput301project;

import java.util.ArrayList;

/* Class: PhotoListModel
 * PhotoListModel is a class that stores a list of Photos. These Photos are from
 * PhotoModel class and stored in a ArrayList class. The constructor takes in a single Photo
 * and appends it to a blank Photo List (photo_list). The PhotoListModel has methods
 * getLength, getPhotoListDesc, getPhotoListName.
 */
public class PhotoListModel {
	private ArrayList<PhotoModel> photo_list = new ArrayList<PhotoModel>();

	// Constructor?
	public PhotoListModel(PhotoModel photo) {
		photo_list.add(photo);
	}

	// Returns the length of Photo List (photo_list)
	public int getLength() {
		return photo_list.size();
	}

	// Returns description of a Photo (PhotoModel) based on position
	// in list (i)
	public String getPhotoListDesc(int i) {
		return photo_list.get(i).getPhotoDesc();
	}

	// Returns name of a Photo (PhotoModel) based on position in list
	// (i)
	public String getPhotoListName(int i) {
		return photo_list.get(i).getPhotoName();
	}

}