package com.example.cliffhorwood.gedcomanalysis;

import com.example.cliffhorwood.gedcomanalysis.Classes.*;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import android.app.ListFragment;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class ListFileAnalysisFragment extends ListFragment{

	private String sFragmentName = this.getClass().getSimpleName();

	/** Called once the fragment is associated with its activity.
	public void onAttach() {
		super.onAttach(getActivity());
		Log.e(sFragmentName, "onAttach()");		
	}
	 **/

	/** Called to do initial creation of the fragment. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		Log.e(sFragmentName, "onCreate()");
	}

	/** Creates and returns the view hierarchy associated with the fragment.
	@Override
	public View onCreateView (LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		Log.e(sFragmentName, "onCreateView()");
		View myFragmentView = inflater.inflate(R.layout.listfilesfragment, container, false);		  
		return myFragmentView;
	}
	 **/

	/**  Tells the fragment that its activity has completed its own Activity.onCreate() */
	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		Log.e(sFragmentName, "onActivityCreated()");

		String str;
		String strbulk;
		String scratch;
		String scratch2;
		String file_gedcom_version;

		int strlen  = 0;
		int numINDI = 0;
		int numFAM  = 0;
		int numSURN = 0;
		int numSOUR = 0;
		int numNOTE = 0;
		int iPrefix = 7;
		int i= 0;

		String gedcom_version =  getResources().getString(R.string.gedcom_version);

		MyMethods myMethods = new MyMethods();
		String sExtStorageDirectory = myMethods.extStorageDir();

		Bundle extras = getActivity().getIntent().getExtras();
		String fname = extras.getString("fname");

		String sFullyQualFileName = sExtStorageDirectory + fname;

		List DISPlist = new LinkedList();
		DISPlist      = new ArrayList();
		List newList  = new LinkedList();
		newList       = new ArrayList();

		newList = myMethods.LoadTextFileToArray((ArrayList<String>) newList, sFullyQualFileName);		

		// check for O HEAD
		Log.e(sFragmentName, "check for O HEAD");

		i = 0;
		boolean foundHEAD = false;

		scratch = (String) newList.get(i);
		if (scratch.equals("0 HEAD"))  {
			foundHEAD = true;
			// DISPlist.add(scratch + " found");	
		}

		if (!foundHEAD) {
			DISPlist.add("0 HEAD not found");	
		}

		// check for O TRLR
		Log.e(sFragmentName, "check for O TRLR");

		i = 0;
		i = newList.size() - 1;
		boolean foundTRLR = false;

		scratch = (String) newList.get(i);
		if (scratch.equals("0 TRLR"))  {
			foundTRLR = true;
			// DISPlist.add(scratch + " found");	
		}

		if (!foundTRLR) {
			DISPlist.add("0 TRLR not found");	
		}

		// check for GEDC and get version else assume the  default version
		Log.e(sFragmentName, "check for 1 GEDC");

		i = 0;
		boolean foundGEDC = false;
		boolean foundGEDCVERS = false;

		while (i < newList.size()) {
			scratch = (String) newList.get(i);
			if ( scratch.equals("1 GEDC"))  {
				foundGEDC = true; 
				DISPlist.add(scratch + " found");	
				scratch = (String) newList.get(i+1);
				if (scratch.startsWith ("2 VERS")) {
					foundGEDCVERS = true;
					i = newList.size() - 1;	// break while loop
					DISPlist.add(scratch + " found");
				}
			}
			i++;
		}

		if ( !foundGEDC ) {
			file_gedcom_version = gedcom_version;
			DISPlist.add("1 GEDC  not found. Version " + gedcom_version  + " assumed.");
		}
		else if ( foundGEDC && !foundGEDCVERS ) {
			file_gedcom_version = gedcom_version;
			DISPlist.add("GEDC 2 VERS not found. Version " + gedcom_version  + " assumed.");
		}	
		else if ( foundGEDC && foundGEDCVERS ) {
			scratch2 = "2 VERS" + " ";
			// int scratch2len = scratch
			scratch = scratch.substring(scratch2.length(), scratch.length());
			file_gedcom_version = scratch;
			DISPlist.add(scratch);
		}	

		// loop through entire file
		Log.e(sFragmentName, "loop through entire file");

		i = 0;

		while (i < newList.size()) {
			scratch = (String) newList.get(i);
			// DISPlist.add(scratch);
			i++;
		}

		String[] simpleArray = new String[ DISPlist.size() ];
		DISPlist.toArray( simpleArray );	

		ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, simpleArray);
		setListAdapter(adapter);
	}

	@Override
	public void onListItemClick(ListView l, View v, int position, long id) {
		Log.e(sFragmentName, "onListItemClick()");

		String item = (String) getListAdapter().getItem(position);
		Bundle extras = getActivity().getIntent().getExtras();
		String fname = extras.getString("fname");

		if (item.startsWith("Individuals - All")) {
			Intent intent = new Intent();
			intent.setClass(getActivity(), ListIndv3Activity.class);
			intent.putExtra("fname", fname);
			intent.putExtra("indvtype", "all");
			intent.putExtra("parentactivity", "ListSummFragment");
			startActivity(intent);	    
		}
		else if (item.startsWith("Individuals - Analysis")) {
			Intent intent = new Intent();
			intent.setClass(getActivity(), ListIndvAnalysisActivity.class);
			intent.putExtra("fname", fname);
			startActivity(intent);	    
		}
		else if (item.startsWith("Families")) {
			Intent intent = new Intent();
			intent.setClass(getActivity(), ListFamlAnalysisActivity.class);
			intent.putExtra("fname", fname);
			startActivity(intent);	    
		}
		else if (item.startsWith("Surnames")) {
			Intent intent = new Intent();
			intent.setClass(getActivity(), ListSurnActivity.class);
			intent.putExtra("fname", fname);
			startActivity(intent);	    
		}
		else if (item.startsWith("Sources")) {
			Intent intent = new Intent();
			intent.setClass(getActivity(), ListSourActivity.class);
			intent.putExtra("fname", fname);
			startActivity(intent);	    
		}
		else if (item.startsWith("Notes")) {
			Intent intent = new Intent();
			intent.setClass(getActivity(), ListNoteActivity.class);
			intent.putExtra("fname", fname);
			startActivity(intent);	    
		}
		else if (item.startsWith("Details")) {
			Intent intent = new Intent();
			intent.setClass(getActivity(), ShowDetlActivity.class);
			intent.putExtra("fname", fname);
			startActivity(intent);	    
		}
		else {
			Intent intent = new Intent();
			intent.setClass(getActivity(), ZActivity.class);
			intent.putExtra("fname", fname);
			startActivity(intent);	    
		}

	}

	/** Makes the fragment visible to the user (based on its containing activity being started).
	@Override
	public void onStart() {
		super.onStart();
		Log.e(sFragmentName, "onStart()");		
	}
	 **/

	/** Makes the fragment interacting with the user (based on its containing activity being resumed).  
	@Override
	public void onResume() {
		super.onResume();
		Log.e(sFragmentName, "onResume()");		
	}
	 **/

	/**
	 * As a fragment is no longer being used, it goes through a reverse series of callbacks:

onPause() fragment is no longer interacting with the user either because its activity is being paused or a fragment operation is modifying it in the activity.

onStop() fragment is no longer visible to the user either because its activity is being stopped or a fragment operation is modifying it in the activity.

onDestroyView() allows the fragment to clean up resources associated with its View.

onDestroy() called to do final cleanup of the fragment's state.

onDetach() called immediately prior to the fragment no longer being associated with its activity.

	 */	 

}
