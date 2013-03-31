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
 * Class: PhotoAdapter
 * A class that contains an array list of bitmaps and returns them to
 * the grid view of photo picker layout.
 * 
 */

public class PhotoAdapter extends BaseAdapter {
	private Context mContext;
	private PhotoListModel photos;


	public PhotoAdapter(Context c, PhotoListModel p) {
		//super(c, layoutid, p);
			this.mContext = c;
			this.photos = p;
	}

	public void addPhoto(Bitmap photo){
		//adds a bitmap to array list of bitmaps
		photos.add(new PhotoModel(photo));
	}

	public int getCount() {
		return photos.size();
	}

	public Object getItem(int position) {
		return null;
	}

	public long getItemId(int position) {
		return position;
	}
	
	@Override
	// create a new ImageView for each item referenced by the Adapter
	public View getView(int position, View convertView, ViewGroup parent) {
		ImageView imageView;
		View row = convertView;
		LayoutInflater inflater = ((Activity) mContext).getLayoutInflater();
		 if(row == null)
	        {

	            row = inflater.inflate(R.layout.plist_row, null);

	        }

	        
		 imageView = (ImageView) row.findViewById(R.id.listImage);
		 imageView.setImageBitmap(photos.get(position).getPhoto());

	        
	        return row;
		

	}

	public PhotoListModel getPhotoList(){
		return photos;
	}
	
	static class PhotoHolder
    {
        ImageView img;
        
    }


}
