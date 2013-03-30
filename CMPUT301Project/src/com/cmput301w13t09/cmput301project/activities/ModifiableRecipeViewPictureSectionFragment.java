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
import android.widget.ListView;

import com.cmput301w13t09.cmput301project.BogoPicGen;
import com.cmput301w13t09.cmput301project.PhotoAdapter;
import com.cmput301w13t09.cmput301project.PhotoListModel;
import com.cmput301w13t09.cmput301project.PhotoModel;
import com.cmput301w13t09.cmput301project.R;
import com.cmput301w13t09.cmput301project.RecipeViewAssistant;

public class ModifiableRecipeViewPictureSectionFragment extends Fragment {
	private static final int PICK_IMAGE = 1;
	private static final int CAPUTRE_IMAGE = 10;
	private static final int RESULT_OK = -1;
	private String imagePath;
	private Button selectPicButton, takePicButton, test;
	private ListView photoListView;
	private PhotoAdapter pAdapter;
	private RecipeViewAssistant builder;
	Uri imageFileUri;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		builder = new RecipeViewAssistant(getActivity());
		builder.loadFromFile();

		View tabView = inflater.inflate(
				R.layout.activity_add_new_recipe_picture_tab, container, false);

		photoListView = (ListView) tabView.findViewById(R.id.photoListView);
		pAdapter = new PhotoAdapter(getActivity(), builder.getPhotoListModel());
		photoListView.setAdapter(pAdapter);

		selectPicButton = (Button) tabView
				.findViewById(R.id.selectNewPicButton);
		takePicButton = (Button) tabView.findViewById(R.id.takeNewPicButton);
		test = (Button) tabView.findViewById(R.id.button1);
		test.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				builder.loadFromFile();
				Bitmap testPhoto = BogoPicGen.generateBitmap(400, 400);
				builder.addPhoto(new PhotoModel(testPhoto));
				updateList();
				if (testPhoto != null) {

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
						CAPUTRE_IMAGE);

			}
		});
		return tabView;
	}

	@Override
	public void onActivityResult(int requestCode, int resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);
		builder.loadFromFile();
		Bitmap photo;
		if (requestCode == PICK_IMAGE) {
			if (resultCode == RESULT_OK) {
				photo = (Bitmap) data.getExtras().get("data");
				builder.addPhoto(new PhotoModel(photo));
				updateList();
			}
		}

		if (requestCode == CAPUTRE_IMAGE) {

			if (resultCode == RESULT_OK) {

				photo = (Bitmap) data.getExtras().get("data");
				builder.addPhoto(new PhotoModel(photo));
				updateList();
			}

		}
	}

	private void updateList() {
		builder.updateRecipe();
		pAdapter = new PhotoAdapter(getActivity(), builder.getPhotoListModel());
		photoListView.setAdapter(pAdapter);

	}

}
