package com.cmput301w13t09.cmput301project.activities;

import org.junit.runners.ParentRunner;

import android.app.ActionBar;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.FragmentTransaction;
import android.content.DialogInterface;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Spinner;

import com.cmput301w13t09.cmput301project.IngredientModel;
import com.cmput301w13t09.cmput301project.NewRecipeBuilder;
import com.cmput301w13t09.cmput301project.R;
import com.cmput301w13t09.cmput301project.RecipeController;
import com.cmput301w13t09.cmput301project.OnUpdateSelectedListener;

/**
 * @author Kyle, Marcus, and Landre Class: CreateNewRecipeView CreateNewRecipe
 *         is that extends FragmentActivity and acts a way to gather input data
 *         for Recipes. CreateNewRecipe provides a top menu used for inputing
 *         different types of data. CreateNewRecipe will then use
 *         RecipeController in order to add the recipe to a recipelist and save
 *         that to recipe.data.
 */
public class CreateNewRecipeView extends FragmentActivity implements
		ActionBar.TabListener,  OnUpdateSelectedListener {

	/**
	 * The {@link android.support.v4.view.PagerAdapter} that will provide
	 * fragments for each of the sections. We use a
	 * {@link android.support.v4.app.FragmentPagerAdapter} derivative, which
	 * will keep every loaded fragment in memory. If this becomes too memory
	 * intensive, it may be best to switch to a
	 * {@link android.support.v4.app.FragmentStatePagerAdapter}.
	 */
	SectionsPagerAdapter mSectionsPagerAdapter;
	OnUpdateSelectedListener mOnUpdateSelectedListener;
	/**
	 * The {@link ViewPager} that will host the section contents.
	 */
	ViewPager mViewPager;

	private NewRecipeBuilder rBuilder;
	private RecipeController rController;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_create_new_recipe_view);

		// Set up the action bar.
		final ActionBar actionBar = getActionBar();
		actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);

		// Create the adapter that will return a fragment for each of the three
		// primary sections of the app.
		mSectionsPagerAdapter = new SectionsPagerAdapter(
				getSupportFragmentManager());

		// Set up the ViewPager with the sections adapter.
		mViewPager = (ViewPager) findViewById(R.id.pager);
		mViewPager.setAdapter(mSectionsPagerAdapter);

		// When swiping between different sections, select the corresponding
		// tab. We can also use ActionBar.Tab#select() to do this if we have
		// a reference to the Tab.
		mViewPager
				.setOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener() {
					@Override
					public void onPageSelected(int position) {
						actionBar.setSelectedNavigationItem(position);
					}
				});

		// For each of the sections in the app, add a tab to the action bar.
		for (int i = 0; i < mSectionsPagerAdapter.getCount(); i++) {
			// Create a tab with text corresponding to the page title defined by
			// the adapter. Also specify this Activity object, which implements
			// the TabListener interface, as the callback (listener) for when
			// this tab is selected.
			actionBar.addTab(actionBar.newTab()
					.setText(mSectionsPagerAdapter.getPageTitle(i))
					.setTabListener(this));
		}

		rController = new RecipeController(this);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_create_new_recipe_view, menu);
		return super.onCreateOptionsMenu(menu);
	}

	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case R.id.addNewRecipeDoneButton:
			// rBuilder.setName(desc_Fragment.getName());
			// rBuilder.setDescription(desc_Fragment.getDescription());
			// rBuilder.setIngredientList(ingr_Fragment.getList());

			// rController.loadFromFile();
			// rController.addRecipe(rBuilder.createRecipe());
			// rController.saveToFile();
			return true;
		default:
			// TODO Grab all the data and make a recipe
			//
			return super.onOptionsItemSelected(item);
		}

	}
	public void onUpdateSelected(int i, NewRecipeBuilder build){
		switch(i){
			case 0:
				rBuilder.setName(build.getName());
				rBuilder.setDescription(build.getDescription());
			case 1:
				rBuilder.setIngredientList(build.getIngredientList());
			case 2:
				rBuilder.setInstructionList(build.getInstructionList());
		}
		
	}

	@Override
	public void onTabSelected(ActionBar.Tab tab,
			FragmentTransaction fragmentTransaction) {
		// When the given tab is selected, switch to the corresponding page in
		// the ViewPager.
		mViewPager.setCurrentItem(tab.getPosition());
	}

	@Override
	public void onTabUnselected(ActionBar.Tab tab,
			FragmentTransaction fragmentTransaction) {
	}

	@Override
	public void onTabReselected(ActionBar.Tab tab,
			FragmentTransaction fragmentTransaction) {
	}

	/**
	 * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
	 * one of the sections/tabs/pages.
	 */
	public class SectionsPagerAdapter extends FragmentPagerAdapter {

		public SectionsPagerAdapter(FragmentManager fm) {
			super(fm);
		}

		@Override
		public Fragment getItem(int position) {
			// getItem is called to instantiate the fragment for the given page.
			// Return a DummySectionFragment (defined as a static inner class
			// below) with the page number as its lone argument.
			switch (position) {
			case 0:
				Fragment descriptionFragment = new DescriptionSectionFragment();
				return descriptionFragment;
			case 1:
				Fragment ingredientFragment = new IngredientSectionFragment();
				return ingredientFragment;
			case 2:
				Fragment instructionFragment = new InstructionSectionFragment();
				return instructionFragment;
			}
			return new Fragment();
		}

		@Override
		public int getCount() {
			// Show 3 total pages.
			return 3;
		}

		@Override
		public CharSequence getPageTitle(int position) {
			switch (position) {
			case 0:
				return getString(R.string.createNewRecipe_title_section1)
						.toUpperCase();
			case 1:
				return getString(R.string.createNewRecipe_title_section2)
						.toUpperCase();
			case 2:
				return getString(R.string.createNewRecipe_title_section3)
						.toUpperCase();
			}
			return null;
		}
	}

	/**
	 * A fragment representing the display section of the create new recipe.
	 */
	public static class DescriptionSectionFragment extends Fragment {
		public EditText nameEditText, descriptionEditText;
		private NewRecipeBuilder builder;
//		private OnItemSelectedListener listener;

		public DescriptionSectionFragment() {
		}

		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {
			// Create a new TextView and set its text to the fragment's section
			// number argument value.
			View tabView = inflater.inflate(
					R.layout.activity_add_new_recipe_description_tab,
					container, false);
			nameEditText = (EditText) tabView
					.findViewById(R.id.addNewRecipeNameEditText);
			descriptionEditText = (EditText) tabView
					.findViewById(R.id.addNewRecipeDescriptionEditText);
			return tabView;
		}

	}

	public static class IngredientSectionFragment extends Fragment {
		private Button addIngredientButton;
		private ListView ingredientListView;
		private ListAdapter ingredientListAdapter;
		private NewRecipeBuilder builder;
		private int dialogNumber;
		OnUpdateSelectedListener mCallback;
		
		public IngredientSectionFragment() {
		}

		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {
			// Create a new TextView and set its text to the fragment's section
			// number argument value.
			View tabView = inflater.inflate(R.layout.activity_my_pantry_view,
					container, false);
			addIngredientButton = (Button) tabView
					.findViewById(R.id.myPantryAddIngredientButton);
			builder = new NewRecipeBuilder();
			addIngredientButton.setOnClickListener(new OnClickListener() {

				@Override
				public void onClick(View v) {
					try {
						final Dialog addIngredientDialog = new Dialog(
								getActivity());
						addIngredientDialog
								.setContentView(R.layout.activity_add_new_ingredient_view);
						addIngredientDialog.setTitle("New Ingredient");

						Button addIngredientDialogButtonConfirm = (Button) addIngredientDialog
								.findViewById(R.id.addNewIngredient);
						Button addIngredientDialogButtonCancel = (Button) addIngredientDialog
								.findViewById(R.id.andNewIngredientCancelButton);

						final EditText addIngredientDialodEditTextName = (EditText) addIngredientDialog
								.findViewById(R.id.addNewIngredientEditTextName);
						final EditText addIngredientDialodEditTextDescription = (EditText) addIngredientDialog
								.findViewById(R.id.addNewIngredientEditTextDescription);
						final EditText addIngredientDialodEditTextQuantity = (EditText) addIngredientDialog
								.findViewById(R.id.addNewIngredientEditTextQuantity);
						final Spinner addIngredientDialodSpinnerQuantity = (Spinner) addIngredientDialog
								.findViewById(R.id.addNewIngredientSpinnerQuantity);
						ArrayAdapter<CharSequence> addIngredientDialodSpinnerArrayAdapterQuantity = ArrayAdapter
								.createFromResource(
										getActivity(),
										R.array.UnitsArrayList,
										android.R.layout.simple_spinner_dropdown_item);
						addIngredientDialodSpinnerQuantity
								.setAdapter(addIngredientDialodSpinnerArrayAdapterQuantity);
						addIngredientDialogButtonConfirm
								.setOnClickListener(new OnClickListener() {
									@Override
									public void onClick(View v) {
										builder.addIngredient(new IngredientModel(
												addIngredientDialodEditTextName
														.getText().toString(),
												addIngredientDialodEditTextDescription
														.getText().toString(),
												Float.parseFloat(addIngredientDialodEditTextQuantity
														.getText().toString()),
												addIngredientDialodSpinnerQuantity
														.getSelectedItem()
														.toString()));
										updateList();
										addIngredientDialog.dismiss();

									}
								});
						addIngredientDialogButtonCancel
								.setOnClickListener(new OnClickListener() {
									@Override
									public void onClick(View v) {
										addIngredientDialog.dismiss();
									}
								});
						addIngredientDialog.show();
					} catch (Throwable e) {
						e.printStackTrace();
					}
				}
			});

			ingredientListView = (ListView) tabView
					.findViewById(R.id.myPantryIngredientList);
			ingredientListAdapter = new ArrayAdapter<IngredientModel>(
					getActivity(), android.R.layout.simple_list_item_1,
					builder.getIngredientList());
			ingredientListView.setAdapter(ingredientListAdapter);

			ingredientListView
					.setOnItemClickListener(new OnItemClickListener() {
						public void onItemClick(AdapterView<?> parent,
								View view, int position, long id) {
							dialogNumber = position;
							AlertDialog.Builder ingredientDialogBuilder = new AlertDialog.Builder(
									getActivity());
							String title = builder
									.getIngredientListName(position);
							String message = builder.getIngredient(position)
									.toDialogString();
							ingredientDialogBuilder.setMessage(message);
							ingredientDialogBuilder.setTitle(title);

							ingredientDialogBuilder.setNegativeButton("Cancel",
									new DialogInterface.OnClickListener() {

										@Override
										public void onClick(
												DialogInterface dialog,
												int which) {
											dialog.dismiss();

										}
									});
							ingredientDialogBuilder.setNeutralButton("Edit",
									new DialogInterface.OnClickListener() {

										@Override
										public void onClick(
												DialogInterface dialog,
												int which) {
											final Dialog dialog2 = new Dialog(
													getActivity());
											dialog2.setContentView(R.layout.activity_add_new_ingredient_view);
											final EditText dialognameText = (EditText) dialog2
													.findViewById(R.id.addNewIngredientEditTextName);
											final EditText dialogquantityText = (EditText) dialog2
													.findViewById(R.id.addNewIngredientEditTextQuantity);
											Button dialogdone = (Button) dialog2
													.findViewById(R.id.addNewIngredient);
											Button dialogcancel = (Button) dialog2
													.findViewById(R.id.andNewIngredientCancelButton);
											final EditText dialogdescriptionText = (EditText) dialog2
													.findViewById(R.id.addNewIngredientEditTextDescription);
											dialognameText.setText(builder
													.getIngredientListName(dialogNumber));
											final Spinner unitSelectorSpinner = (Spinner) dialog2
													.findViewById(R.id.addNewIngredientSpinnerQuantity);
											ArrayAdapter<CharSequence> unitSelectorAdapter = ArrayAdapter
													.createFromResource(
															getActivity(),
															R.array.UnitsArrayList,
															android.R.layout.simple_spinner_dropdown_item);
											unitSelectorSpinner
													.setAdapter(unitSelectorAdapter);
											unitSelectorSpinner
													.setSelection(checkPositionInArray(builder
															.getIngredient(
																	dialogNumber)
															.getIngredientquantityunit()));
											dialogdescriptionText.setText(builder
													.getIngredientListDesc(dialogNumber));
											dialogquantityText.setText(String
													.valueOf(builder
															.getIngredient(
																	dialogNumber)
															.getIngredientquantity()));
											dialogcancel
													.setOnClickListener(new View.OnClickListener() {

														@Override
														public void onClick(
																View v) {
															dialog2.cancel();
														}
													});
											dialogdone
													.setOnClickListener(new View.OnClickListener() {

														@Override
														public void onClick(
																View v) {
															builder.editIngredient(
																	dialogNumber,
																	dialognameText
																			.getText()
																			.toString(),
																	dialogdescriptionText
																			.getText()
																			.toString(),
																	Float.parseFloat(dialogquantityText
																			.getText()
																			.toString()),
																	unitSelectorSpinner
																			.getSelectedItem()
																			.toString());
															dialog2.dismiss();
															updateList();
														}
													});

											dialog2.show();
										}
									});
							ingredientDialogBuilder.setPositiveButton("Delete",
									new DialogInterface.OnClickListener() {

										@Override
										public void onClick(
												DialogInterface dialog,
												int which) {
											builder.removeIngredient(dialogNumber);
											dialog.dismiss();
											updateList();

										}
									});

							AlertDialog dialog = ingredientDialogBuilder
									.create();
							dialog.show();
						}
					});
			return tabView;
		}

		protected void updateList() {
			ingredientListAdapter = new ArrayAdapter<IngredientModel>(
					getActivity(), android.R.layout.simple_list_item_1,
					builder.getIngredientList());
			ingredientListView.setAdapter(ingredientListAdapter);
			mCallback.onUpdateSelected(1, builder);
//			((CreateNewRecipeView) getActivity()).addToBuilder(1, builder);
		}


	    @Override
	    public void onAttach(Activity activity) {
	        super.onAttach(activity);
	        
	        // This makes sure that the container activity has implemented
	        // the callback interface. If not, it throws an exception
	        try {
	            mCallback = (OnUpdateSelectedListener) activity;
	        } catch (ClassCastException e) {
	            throw new ClassCastException(activity.toString()
	                    + " must implement OnUpdateSelectedListener");
	        }
	    }


		public int checkPositionInArray(String s) {
			int j = 0;
			for (String str : getResources().getStringArray(
					R.array.UnitsArrayList)) {
				if (s.equals(str))
					return j;
				else
					j++;
			}
			return 0;
		}
	}

	public static class InstructionSectionFragment extends Fragment {
		private NewRecipeBuilder builder;
		public InstructionSectionFragment() {
		}

		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {
			// Create a new TextView and set its text to the fragment's section
			// number argument value.
			View tabView = inflater.inflate(
					R.layout.activity_add_new_recipe_instruction_tab,
					container, false);

			return tabView;
		}
	}
}
