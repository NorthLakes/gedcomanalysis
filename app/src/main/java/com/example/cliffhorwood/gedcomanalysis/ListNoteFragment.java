package com.example.cliffhorwood.gedcomanalysis;

import com.example.cliffhorwood.gedcomanalysis.Classes.MyMethods;

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

public class ListNoteFragment extends ListFragment{

	private String sFragmentName = this.getClass().getSimpleName();

	/** 
	Called once the fragment is associated with its activity.
	public void onAttach() {
		super.onAttach(getActivity());
		Log.e(sFragmentName, "onAttach()");		
	}
	 */

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
		  View myFragmentView = inflater.inflate(R.layout.listnotefragment, container, false);		  
		  return myFragmentView;
	}
	 */

	/**  Tells the fragment that its activity has completed its own Activity.onCreate() */
	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		Log.e(sFragmentName, "onActivityCreated()");

		String str;
		String strbulk = " ";
		boolean b;

		MyMethods myMethods = new MyMethods();
		String sExtStorageDirectory = myMethods.extStorageDir();

		Bundle extras = getActivity().getIntent().getExtras();
		String fname = extras.getString("fname");
		String sFullyQualFileName = sExtStorageDirectory + fname;


		List newList  = new LinkedList();
		newList       = new ArrayList();

		newList = myMethods.LoadTextFileToArray((ArrayList<String>) newList, sFullyQualFileName);	

		if (newList.size() > 0) {

			List NOTElist = new LinkedList();         // Doubly-linked list
			NOTElist      = new ArrayList();          // List implemented as growable array
			NOTElist		= myMethods.LoadNoteToArray((ArrayList<String>) NOTElist, (ArrayList<String>) newList);	

			if (NOTElist.size() > 0) {

				List DISPlist = new LinkedList();         // Doubly-linked list
				DISPlist      = new ArrayList();          // List implemented as growable array

				// process the array

				int i = 0;
				String sNewString = "";
				
				while (i < NOTElist.size()) {
					str = (String) NOTElist.get(i);					
					if (str.startsWith("0 @N")) {
						if (!sNewString.isEmpty()) {
							DISPlist.add(sNewString);							
						}
						str = str.replace("0 @", "");
						str = str.replace("@ NOTE ", " ");
						sNewString = str;						
					}
					else if (str.startsWith("1 CONC")) {
						str = str.replace("1 CONC", "");	// no leading space
						sNewString = sNewString + str;
					}
					else if (str.startsWith("1 CONT")) {
						str = str.replace("1 CONT", " ");	// leading space
						sNewString = sNewString + str;
					}

					i++;
					if (i < NOTElist.size()) {				// get the next line if it exists
						str = (String) NOTElist.get(i);
					}

				}
				
				if (!sNewString.isEmpty()) {
					DISPlist.add(sNewString);							
				}				

				String[] simpleArray = new String[ DISPlist.size() ];
				DISPlist.toArray( simpleArray );	

				String sParentActivity = getActivity().getLocalClassName();   
				String sActivityName   = sFragmentName.replace("Fragment","Activity");
				Log.e(sFragmentName, "sActivityName: " + sActivityName);
				if (sParentActivity.equals(sActivityName)) {
					ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, simpleArray);
					setListAdapter(adapter);	
				}
				else {
					ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(), R.layout.my_simple_list_item_1, simpleArray);
					setListAdapter(adapter);
				}

			}	
		}		

	}	

	@Override
	public void onListItemClick(ListView l, View v, int position, long id) {
		Log.e(sFragmentName, "onListItemClick()");

		String item = (String) getListAdapter().getItem(position);

		item = item.substring(0,item.lastIndexOf(" : "));

		Bundle extras = getActivity().getIntent().getExtras();
		String fname = extras.getString("fname");

		// We need to launch a new activity - Show Note

		Intent intent = new Intent();
		intent.setClass(getActivity(), ListIndv3Activity.class);
		intent.putExtra("fname", fname);
		intent.putExtra("indvtype", "note");
		intent.putExtra("note", item);
		intent.putExtra("parentactivity", sFragmentName);			
		startActivity(intent);	    	
	}

	/**
	 * As a fragment is no longer being used, it goes through a reverse series of callbacks:

onPause() fragment is no longer interacting with the user either because its activity is being paused or a fragment operation is modifying it in the activity.

onStop() fragment is no longer visible to the user either because its activity is being stopped or a fragment operation is modifying it in the activity.

onDestroyView() allows the fragment to clean up resources associated with its View.

onDestroy() called to do final cleanup of the fragment's state.

onDetach() called immediately prior to the fragment no longer being associated with its activity.

	 */	 

}
