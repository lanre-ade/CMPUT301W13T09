package com.cmput301w13t09.cmput301project.activities;




import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.ListView;



import com.cmput301w13t09.cmput301project.R;
import com.cmput301w13t09.cmput301project.helpers.PhotoAdapter;
import com.cmput301w13t09.cmput301project.helpers.RecipeViewAssistant;

public class RecipeViewPictureSectionFragment extends Fragment {

	private PhotoAdapter pAdapter;
	private RecipeViewAssistant builder;
	private ListView photoListView;
	Uri imageFileUri;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View tabView = inflater.inflate(
				R.layout.view_recipe_pictures_tab, container, false);
		builder = new RecipeViewAssistant(getActivity());
		builder.loadFromFile();

		pAdapter = new PhotoAdapter(getActivity(), builder.getPhotoListModel());
		photoListView = (ListView) tabView.findViewById(R.id.listView1);
		photoListView.setAdapter(pAdapter);



		return tabView;
	}
	public void onResume(){
		builder.loadFromFile();
		pAdapter = new PhotoAdapter(getActivity(), builder.getPhotoListModel());
		photoListView.setAdapter(pAdapter);
		super.onResume();
	}

}
