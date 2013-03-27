package com.cmput301w13t09.cmput301project.activities;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.cmput301w13t09.cmput301project.BogoPicGen;
import com.cmput301w13t09.cmput301project.PhotoAdapter;
import com.cmput301w13t09.cmput301project.PhotoModel;
import com.cmput301w13t09.cmput301project.R;
import com.cmput301w13t09.cmput301project.RecipeViewAssistant;

public class ModifiableRecipeViewPictureSectionFragment extends Fragment {
	private static final int PICK_IMAGE = 1;
	private static final int CAPUTRE_IMAGE_REQUEST_CODE = 10;
	private String imagePath;
	private Button selectPicButton, takePicButton, test;
	private ImageView img;
	private ImageButton imgB;
	private PhotoAdapter pAdapter;
	private RecipeViewAssistant builder;
	Uri imageFileUri;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View tabView = inflater.inflate(
				R.layout.activity_add_new_recipe_picture_tab, container, false);
		img = (ImageView) tabView.findViewById(R.id.recipeImage);
		selectPicButton = (Button) tabView
				.findViewById(R.id.selectNewPicButton);
		takePicButton = (Button) tabView.findViewById(R.id.takeNewPicButton);
		test = (Button) tabView.findViewById(R.id.button1);
		test.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Bitmap testPhoto = BogoPicGen.generateBitmap(400, 400);
				 //builder.addPhoto(new PhotoModel(testPhoto));
				if (testPhoto != null) {
					img.setImageBitmap(testPhoto);
				}
			}
		});

		selectPicButton.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent();
				intent.setType("image/*");
				intent.setAction(Intent.ACTION_GET_CONTENT);
				getActivity().startActivityForResult(
						Intent.createChooser(intent, "Select Picture"),
						PICK_IMAGE);

			}
		});

		takePicButton.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
				getActivity().startActivityForResult(intent,
						CAPUTRE_IMAGE_REQUEST_CODE);

			}
		});
		return tabView;
	}

	@Override
	public void onActivityResult(int requestCode, int resultCode, Intent data) {
		// builder.loadFromFile();

		super.onActivityResult(requestCode, resultCode, data);
		Bitmap photo;
		Bitmap testPhoto = BogoPicGen.generateBitmap(400, 400);
		if (requestCode == PICK_IMAGE) {
			photo = (Bitmap) data.getExtras().get("data");

			img.setImageBitmap(photo);
			builder.addPhoto(new PhotoModel(photo));
		}

		if (requestCode == CAPUTRE_IMAGE_REQUEST_CODE) {
			// TextView tv = (TextView) find
			// if (resultCode == RESULT_OK){

			photo = (Bitmap) data.getExtras().get("data");
			img.setImageBitmap(photo);
			// }else if (resultCode == RESULT_CANCELED){
			// tv.setText("Photocancled");
			// }else {
			// tv.setText("Not sure what happened!" + resultCode);
			builder.addPhoto(new PhotoModel(photo));
		}

	}

}
