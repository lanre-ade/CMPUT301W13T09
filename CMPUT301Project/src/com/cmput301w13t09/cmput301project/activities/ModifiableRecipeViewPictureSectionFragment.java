package com.cmput301w13t09.cmput301project.activities;

import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.ListView;

import com.cmput301w13t09.cmput301project.R;
import com.cmput301w13t09.cmput301project.helpers.PhotoAdapter;
import com.cmput301w13t09.cmput301project.helpers.RecipeViewAssistant;

public class ModifiableRecipeViewPictureSectionFragment extends Fragment {
	private static final int PICK_IMAGE = 1;
	private static final int CAPUTRE_IMAGE = 10;
	private Button selectPicButton, takePicButton;
	private ListView photoListView;
	private PhotoAdapter pAdapter;
	private RecipeViewAssistant builder;
	private int dialogNumber;
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
		
		photoListView.setOnItemClickListener(new OnItemClickListener() {
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				dialogNumber = position;
				AlertDialog.Builder dialogBuilder= new Builder(getActivity());
				dialogBuilder.setTitle("Delete?");
				dialogBuilder.setNegativeButton("Cancel", new OnClickListener() {
					
					public void onClick(DialogInterface dialog, int which) {
						dialog.dismiss();
					}
				});
				dialogBuilder.setPositiveButton("Delete", new OnClickListener() {
					
					@Override
					public void onClick(DialogInterface dialog, int which) {
						builder.removePhoto(dialogNumber);
						builder.saveToFile();
						updateList();
						dialog.dismiss();
					}
				});
				dialogBuilder.create().show();
				
				
				
			}
		});
		
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
