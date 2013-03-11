package com.cmput301w13t09.cmput301project;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * @author Kyle,Marcus,Landre
 * Class: PhotoListModel PhotoListModel is a class that stores a list of Photos.
 * These Photos are from PhotoModel class and stored in a ArrayList class. The
 * constructor takes in a single Photo and appends it to a blank Photo List
 * (photo_list). The PhotoListModel has methods getLength, getPhotoListDesc,
 * getPhotoListName.
 */
public class PhotoListModel extends ArrayList<PhotoModel> implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
}