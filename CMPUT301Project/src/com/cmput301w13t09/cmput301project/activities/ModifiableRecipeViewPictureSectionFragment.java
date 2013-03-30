package com.cmput301w13t09.cmput301project.activities;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;

import com.cmput301w13t09.cmput301project.PhotoAdapter;
import com.cmput301w13t09.cmput301project.R;
import com.cmput301w13t09.cmput301project.RecipeViewAssistant;

public class ModifiableRecipeViewPictureSectionFragment extends Fragment {
	private static final int PICK_IMAGE = 1;
	private static final int CAPUTRE_IMAGE = 10;
	private Button selectPicButton, takePicButton;
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

		selectPicButton.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
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
				Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
				getActivity().startActivityForResult(intent, CAPUTRE_IMAGE);

			}
		});
		return tabView;
	}

	public void onResume(){
		super.onResume();
		updateList();
	}
	private void updateList() {
		builder.loadFromFile();
		pAdapter = new PhotoAdapter(getActivity(), builder.getPhotoListModel());
		photoListView.setAdapter(pAdapter);

	}

}
