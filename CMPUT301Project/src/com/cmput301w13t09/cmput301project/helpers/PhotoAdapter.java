package com.cmput301w13t09.cmput301project.helpers;

//All Credits go to @author Katherine Jasniewski. Wherever you are, thank you :)
//Now i can finally go to bed (>.<)

import com.cmput301w13t09.cmput301project.R;
import com.cmput301w13t09.cmput301project.models.PhotoListModel;
import com.cmput301w13t09.cmput301project.models.PhotoModel;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

/**
 * 
 * Class: PhotoAdapter A class that contains an array list of bitmaps and
 * returns them to the grid view of photo picker layout.
 * 
 */

public class PhotoAdapter extends BaseAdapter {
	private Context mContext;
	private PhotoListModel photos;

	public PhotoAdapter(Context c, PhotoListModel p) {
		// super(c, layoutid, p);
		this.mContext = c;
		this.photos = p;
	}

	/**
	 * adds a bitmap to array of photos
	 * 
	 * @param photo
	 */
	public void addPhoto(Bitmap photo) {
		// adds a bitmap to array list of bitmaps
		photos.add(new PhotoModel(photo));
	}

	/**
	 * returns length of the array of photos
	 */
	public int getCount() {
		return photos.size();
	}

	/**
	 * Gets an certain item at a position
	 */
	public Object getItem(int position) {
		return null;
	}

	/**
	 * Gets the Item id based on position
	 */
	public long getItemId(int position) {
		return position;
	}

	/**
	 * The java doc is located in the CMPUT301Project -> doc -> index.html
	 * located in the project folder
	 * 
	 * If text isnt viewable then copy and pasted it from the javadoc here.
	 * Pasted text from java doc below in case you cannot view the pages in the
	 * java doc.
	 */
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		ImageView imageView;
		View row = convertView;
		LayoutInflater inflater = ((Activity) mContext).getLayoutInflater();
		if (row == null) {

			row = inflater.inflate(R.layout.plist_row, null);

		}

		imageView = (ImageView) row.findViewById(R.id.listImage);
		imageView.setImageBitmap(photos.get(position).getPhoto());

		return row;

	}
	/**
	 * Returns the photo list
	 * @return PhotoListModel
	 */
	public PhotoListModel getPhotoList() {
		return photos;
	}
	/**
	 * Class that holds the ImageView
	 *
	 */
	static class PhotoHolder {
		ImageView img;

	}

}
