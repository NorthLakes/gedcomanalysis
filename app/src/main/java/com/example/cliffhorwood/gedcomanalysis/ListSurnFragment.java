package com.example.cliffhorwood.gedcomanalysis;

import com.example.cliffhorwood.gedcomanalysis.Classes.MyMethods;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import android.app.ListFragment;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class ListSurnFragment extends ListFragment{
	
	private String sFragmentName = this.getClass().getSimpleName();

	private int iNumIndv = 0;
	private int iPrefix  = 7;
	
	private String strbulk = " ";
	
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

	// Not needed with ListFragment
	
	@Override
	public View onCreateView (LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		Log.e(sFragmentName, "onCreateView()");
		  View myFragmentView = inflater.inflate(R.layout.listsurnfragment, container, false);		  
		  return myFragmentView;
	}
	 */
	
	/**  Tells the fragment that its activity has completed its own Activity.onCreate() */
	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		Log.e(sFragmentName, "onActivityCreated()");

		String str;
		String strbulk = null;
		boolean b;

		MyMethods myMethods = new MyMethods();
		String sExtStorageDirectory = myMethods.extStorageDir();

		Bundle extras = getActivity().getIntent().getExtras();
		String fname = extras.getString("fname");

		String sFullyQualFileName = sExtStorageDirectory + fname;

		List SurnList = new LinkedList();
		SurnList      = new ArrayList();

		/** from here **/
		List newList  = new LinkedList();
		newList       = new ArrayList();

		newList = myMethods.LoadTextFileToArray((ArrayList<String>) newList, sFullyQualFileName);	

		// process the array

		int i = 0;
		if ( newList.size() > i ) {

			// get the first row
			str = (String) newList.get(i);

			// bypass everything until the first individual
			while ( (i < newList.size()) && !(str.endsWith("@ INDI")) ) {
				i++;
				str = (String) newList.get(i);
			}	
			iNumIndv++;

			// get the next line if it exists
			i++;
			if (i < newList.size()) {
				str = (String) newList.get(i);
			}

			while (i < newList.size()) {

				boolean surnexists = false; // this one
				boolean bSkip = false;		// used to skip remainder of INDI once SURN found
				String scratch  = " ";
				String scratch2 = " ";
				String scratch3 = " ";

				while ( (i < newList.size()) && !(b = str.endsWith("@ INDI")) && !(str.startsWith("0 TRLR")) && !(str.endsWith("@ SOUR")) && !(str.endsWith("@ FAM")) && !(str.indexOf("@ NOTE") > 0) ) {

					//  process the individual's details

					if (str.startsWith("2 SURN ") && !bSkip) {	// The first one. Not AKA.
						surnexists = true;
						int strlen = str.length();
						strbulk = str.substring(iPrefix,strlen);  // might have to remove trailing spaces
						// do not process any more  SURN lines for INDI
						bSkip = true;
					}

					//  end process the individual's details

					// get the next line if it exists
					i++;
					if (i < newList.size()) {
						str = (String) newList.get(i);
					}
				}

				if (b = str.endsWith("@ INDI")) {
					iNumIndv++;
					if (surnexists) { 
						// process the surname; 
						if (SurnList.size() == 0) {
							SurnList.add(strbulk + " : 1");
						} 
						else {
							int z = 0;
							boolean surnfound = false;
							while (z < SurnList.size()) {
								scratch = (String) SurnList.get(z);
								// strip of the end bit " : ##n" or use .equals
								int pos = scratch.indexOf(" : ");
								scratch3 = scratch.substring(0, pos).trim();
								Log.e(sFragmentName, "scratch3: " + scratch3);
								// if (scratch.startsWith(strbulk)) { 
								if (scratch3.equals(strbulk)) { 
									surnfound = true;
									// update the count
									pos = scratch.indexOf(" : ");
									scratch2 = scratch.substring(pos + 3, scratch.length());
									int iscratch2 = Integer.parseInt(scratch2);
									iscratch2 = iscratch2 + 1;

									// update the item in the list with the new count
									SurnList.set(z, strbulk + " : " + iscratch2);

									// end the loop
									z = SurnList.size();             					
								}

								z++;
							}
							if (!surnfound) {	// New surname
								SurnList.add(strbulk + " : 1");
							}
						}
					}    			
				}

				// get the next line if it exists
				i++;
				if (i < newList.size()) {
					str = (String) newList.get(i);
				}

			}

		}

		/** to here **/

		Collections.sort(SurnList, String.CASE_INSENSITIVE_ORDER); // should be sorted but do it again regardless

		String[] simpleArray = new String[ SurnList.size() ];
		SurnList.toArray( simpleArray );	

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

	@Override
	public void onListItemClick(ListView l, View v, int position, long id) {
		Log.e(sFragmentName, "onListItemClick()");

		String item = (String) getListAdapter().getItem(position);

		item = item.substring(0,item.lastIndexOf(" : "));

		Bundle extras = getActivity().getIntent().getExtras();
		String fname = extras.getString("fname");

		Intent intent = new Intent();
		intent.setClass(getActivity(), ListIndv3Activity.class);
		intent.putExtra("fname", fname);
		intent.putExtra("indvtype", "surname");
		intent.putExtra("surname", item);
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
