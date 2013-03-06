package com.cmput301w13t09.cmput301project;

/** Class: PhotoModel
 * PhotoModel is a class that stores information about a photo used 
 * in recipes. PhotoModel stores the name (photo_name) and description
 * (photo_desc) of a recipe. PhotoModels constructor takes in a name and 
 * description (desc). PhotoModel contains the methods getPhotoName() and 
 * getPhotoDesc().
 */


public class PhotoModel {
	private String photo_name;
	private String photo_desc;
	
	/** Constructor
	 * 
	 * @param name : Name attached to the photo
	 * @param desc : Description attached to the photo
	 */
	public PhotoModel(String name, String desc){
		photo_name = name;
		photo_desc = desc;
	}
	
	/** Returns the name of the photo
	 * 
	 * @return Name of the photo
	 */
	public String getPhotoName() {
		return photo_desc;
	}

	/** Returns the description of the photo
	 * 
	 * @return Description of the photo
	 */
	public String getPhotoDesc() {
		return photo_name;
	}
}
