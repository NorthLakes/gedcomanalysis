package com.example.cliffhorwood.gedcomanalysis;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import android.app.ListFragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class ListIndvAnalysisSummFragment extends ListFragment{

	private String sFragmentName = this.getClass().getSimpleName();

	/** Called once the fragment is associated with its activity.  **/
	public void onAttach() {
		super.onAttach(getActivity());
		// Log.i(sFragmentName, "onAttach()");
	}

	/** Called to do initial creation of the fragment. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		// Log.i(sFragmentName, "onCreate()");
	}

	/** Creates and returns the view hierarchy associated with the fragment.
	@Override
	public View onCreateView (LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		Log.i("ListFilesLocalFragment", "onCreateView()");
		View myFragmentView = inflater.inflate(R.layout.listfilesfragment, container, false);		  
		return myFragmentView;
	}
	 **/

	/**  Tells the fragment that its activity has completed its own Activity.onCreate() */
	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		// Log.i(sFragmentName, "onActivityCreated()");

		/**
		String str;
		int numINDI = 0;
		int numFAM  = 0;
		int numSOUR = 0;
		int numNOTE = 0;

		MyMethods myMethods = new MyMethods();
		String sExtStorageDirectory = myMethods.extStorageDir();
        **/

		Bundle extras = getActivity().getIntent().getExtras();
		String fname = extras.getString("fname");

		// String sFullyQualFileName = sExtStorageDirectory + fname;

		List DISPlist = new LinkedList();
		DISPlist      = new ArrayList();

		/**
		List newList  = new LinkedList();
		newList       = new ArrayList();

		newList = myMethods.LoadTextFileToArray((ArrayList<String>) newList, sFullyQualFileName);	

		int i = 0;
		while (i < newList.size()) {
			str = (String) newList.get(i);
			if ((str.startsWith("0 @I")) && (str.indexOf( getResources().getString(R.string.sINDI) ) > 0)) {
				numINDI = numINDI + 1;
			}   
			else if (str.endsWith("@ FAM")) {
				numFAM = numFAM + 1;
			}
			else if ((str.startsWith("0 @S")) && (str.indexOf( getResources().getString(R.string.sSOUR) ) > 0)) {
				numSOUR = numSOUR + 1;
			}   
			else if ((str.startsWith("0 @N")) && (str.indexOf( getResources().getString(R.string.sNOTE) ) > 0)) {
				numNOTE = numNOTE + 1;
			}			      
			i++;
		}

		 **/

		DISPlist.add("Individuals - Event data");
		DISPlist.add("Individuals - Information");
		DISPlist.add("Individuals - Main");
		DISPlist.add("Individuals - Missing data");
		DISPlist.add("Individuals - Multiple events");

		String[] simpleArray = new String[ DISPlist.size() ];
		DISPlist.toArray( simpleArray );	

		String sParentActivity = getActivity().getLocalClassName();   
		String sActivityName   = sFragmentName.replace("Fragment","Activity");

		if (sParentActivity.equals(sActivityName)) {
			ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, simpleArray);
			setListAdapter(adapter);	
		}
		else {
			ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(), R.layout.my_simple_list_item_1, simpleArray);
			setListAdapter(adapter);
		}

	}

	@Override
	public void onListItemClick(ListView l, View v, int position, long id) {

		String item = (String) getListAdapter().getItem(position);
		Bundle extras = getActivity().getIntent().getExtras();
		String fname = extras.getString("fname");

		if (item.startsWith("Individuals - All")) {
			Intent intent = new Intent();
			intent.setClass(getActivity(), ListIndvAnalysisActivity.class);
			intent.putExtra("fname", fname);
			intent.putExtra("sIndvAnalysisCategory", "All");	        
			startActivity(intent);	    
		}
		else if (item.startsWith("Individuals - Event data")) {
			Intent intent = new Intent();
			intent.setClass(getActivity(), ListIndvAnalysisActivity.class);
			intent.putExtra("fname", fname);
			intent.putExtra("sIndvAnalysisCategory", "Event");	        
			startActivity(intent);	    
		}
		else if (item.startsWith("Individuals - Information")) {
			Intent intent = new Intent();
			intent.setClass(getActivity(), ListIndvAnalysisActivity.class);
			intent.putExtra("fname", fname);
			intent.putExtra("sIndvAnalysisCategory", "Information");	        
			startActivity(intent);	    
		}
		else if (item.startsWith("Individuals - Main")) {
			Intent intent = new Intent();
			intent.setClass(getActivity(), ListIndvAnalysisActivity.class);
			intent.putExtra("fname", fname);
			intent.putExtra("sIndvAnalysisCategory", "Indv");	        
			startActivity(intent);	    
		}
		else if (item.startsWith("Individuals - Missing data")) {
			Intent intent = new Intent();
			intent.setClass(getActivity(), ListIndvAnalysisActivity.class);
			intent.putExtra("fname", fname);
			intent.putExtra("sIndvAnalysisCategory", "Missing");	        
			startActivity(intent);	    
		}
		else if (item.startsWith("Individuals - Multiple events")) {
			Intent intent = new Intent();
			intent.setClass(getActivity(), ListIndvAnalysisActivity.class);
			intent.putExtra("fname", fname);
			intent.putExtra("sIndvAnalysisCategory", "Multiple");	        
			startActivity(intent);	    
		}
		else {
			Intent intent = new Intent();
			intent.setClass(getActivity(), ZActivity.class);
			intent.putExtra("fname", fname);
			startActivity(intent);	    
		}

	}

	/** Makes the fragment visible to the user (based on its containing activity being started). **/
	@Override
	public void onStart() {
		super.onStart();
		// Log.i(sFragmentName, "onStart()");
	}

	/** Makes the fragment interacting with the user (based on its containing activity being resumed).  **/
	@Override
	public void onResume() {
		super.onResume();
		// Log.i(sFragmentName, "onResume()");
	}

	/**	As a fragment is no longer being used, it goes through a reverse series of callbacks:
	 onPause() onStop() onDestroyView() onDestroy() onDetach() **/

	/** Fragment is no longer interacting with the user either because its activity is being paused or a fragment operation is modifying it in the activity.  **/
	@Override
	public void onPause() {
		super.onPause();
		// Log.i(sFragmentName, "onPause()");
	}

	/** Fragment is no longer visible to the user either because its activity is being stopped or a fragment operation is modifying it in the activity. **/
	@Override
	public void onStop() {
		super.onStop();
		// Log.i(sFragmentName, "onStop()");
	}

	/** Allows the fragment to clean up resources associated with its View.  **/
	@Override
	public void onDestroyView() {
		super.onDestroyView();
		// Log.i(sFragmentName, "onDestroyView()");
	}

	/** Called to do final cleanup of the fragment's state. **/
	@Override
	public void onDestroy() {
		super.onDestroy();
		// Log.i(sFragmentName, "onDestroy()");
	}

	/** Called immediately prior to the fragment no longer being associated with its activity.  **/
	@Override
	public void onDetach() {
		super.onDetach();
		// Log.i(sFragmentName, "onDetach()");
	}

}
