package com.example.cliffhorwood.gedcomanalysis;

import com.example.cliffhorwood.gedcomanalysis.Classes.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

public class ListFamlTypeFragment extends Fragment {

	private String sFragmentName = this.getClass().getSimpleName();

	private String sBoth    = "Both parents known";
	private String sFather  = "Father only known";
	private String sMother  = "Mother only known";
	private String sNeither = "Neither parent known";

	private String str;
	private String strbulk;
	private String strINDI;
	private String strFamily;

	private int iNumIndv = 0;

	private boolean b;

	/** 
	Called once the fragment is associated with its activity.
	public void onAttach() {
		super.onAttach(getActivity());
		// Log.e(sFragmentName, "onAttach()");		
	}
	 */

	/** Called to do initial creation of the fragment. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		Log.e(sFragmentName, "onCreate()");
	}

	/** Creates and returns the view hierarchy associated with the fragment.  */
	@Override
	public View onCreateView (LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		Log.e(sFragmentName, "onCreateView()");
		
		String sParentActivity = getActivity().getLocalClassName();   
		String sActivityName   = sFragmentName.replace("Fragment","Activity");
		// Log.e(sFragmentName, "sActivityName: " + sActivityName);
		if (sParentActivity.equals(sActivityName)) {
			View myFragmentView = inflater.inflate(R.layout.families_listview, container, false);
			return myFragmentView;			
		}
		else {
			View myFragmentView = inflater.inflate(R.layout.my_families_listview, container, false);
			return myFragmentView;			
		}				
	}

	/**  Tells the fragment that its activity has completed its own Activity.onCreate() */
	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);

		Log.e(sFragmentName, "onActivityCreated()");

		MyMethods myMethods = new MyMethods();
		String sExtStorageDirectory = myMethods.extStorageDir();

		Bundle extras = getActivity().getIntent().getExtras();
		final String fname  = extras.getString("fname");
		final String familytype = extras.getString("familytype");        

		String sFullyQualFileName = sExtStorageDirectory + fname;

		List FAMlist = new LinkedList();         
		FAMlist      = new ArrayList();          

		List IndvList = new LinkedList();         
		IndvList      = new ArrayList(); 

		List newList  = new LinkedList();
		newList       = new ArrayList();

		newList = myMethods.LoadTextFileToArray((ArrayList<String>) newList, sFullyQualFileName);	

		// process the array for FAMILY

		int i = 0;
		if ( newList.size() > i ) {

			// get the first row
			str = (String) newList.get(i);

			// bypass everything until the first FAMILY
			while ( (i < newList.size()) && !(str.endsWith("@ FAM")) ) {
				i++;
				str = (String) newList.get(i);
			}	
			iNumIndv++;

			// get the FAMILY ID
			int position = str.lastIndexOf("@ FAM");
			String strbulk1 = str.substring(0, position);
			int strbulk1len = strbulk1.length();
			strbulk = strbulk1.substring(3, strbulk1len);
			String strFamily = strbulk;			

			// get the next line if it exists
			i++;
			if (i < newList.size()) {
				str = (String) newList.get(i);
			}

			while (i < newList.size()) {

				String scratch = " ";

				boolean bHusbandExists	= false;
				boolean bWifeExists		= false;
				boolean bChildExists	= false;
				// int iChildren = 0;
				String sHusbandTxt	= "~";
				String sWifeTxt		= "~";

				while ( (i < newList.size()) && !(b = str.endsWith("@ INDI")) && !(str.startsWith("0 TRLR")) && !(str.endsWith("@ SOUR")) && !(str.endsWith("@ FAM")) && !(str.indexOf("@ NOTE") > 0) ) {

					//  process the FAMILY's details

					if (str.startsWith("1 HUSB")) {
						bHusbandExists = true;
						sHusbandTxt =  str.substring(8,str.length() - 1);
					}
					else if (str.startsWith("1 WIFE")) {
						bWifeExists = true;
						sWifeTxt =  str.substring(8,str.length() - 1);
					}
					else if (str.startsWith("1 CHIL")) {
						if (!bHusbandExists && !bWifeExists) {
							// strFamily = strFamily + " : ~ : ~ ";
						}
					}
					else {
						// do nothing
					}

					//  end process the FAMILY's details

					// get the next line if it exists
					i++;
					if (i < newList.size()) {
						str = (String) newList.get(i);
					}
				}

				if (b = str.endsWith("@ FAM")) {

					iNumIndv++;

					if (bHusbandExists && bWifeExists) {
						boolean resultOfComparison=familytype.equals(sBoth);
						if (resultOfComparison) {
							strFamily = strFamily + " : " + sHusbandTxt + " : " + sWifeTxt;
							IndvList.add(strFamily);    			
						}
					}
					else if (bHusbandExists && !bWifeExists) {
						boolean resultOfComparison=familytype.equals(sFather);
						if (resultOfComparison) {
							strFamily = strFamily + " : " + sHusbandTxt + " : " + sWifeTxt;
							IndvList.add(strFamily);    			
						}    					
					}
					else if (!bHusbandExists && bWifeExists) {
						boolean resultOfComparison=familytype.equals(sMother);
						if (resultOfComparison) {
							strFamily = strFamily + " : " + sHusbandTxt + " : " + sWifeTxt;
							IndvList.add(strFamily);    			
						}    					
					}
					else if (!bHusbandExists && !bWifeExists) {
						boolean resultOfComparison=familytype.equals(sNeither);
						if (resultOfComparison) {
							strFamily = strFamily + " : " + sHusbandTxt + " : " + sWifeTxt;
							IndvList.add(strFamily);    									
						}    					
					}
					else {
						// something is wrong
					}
					// get the FAMILY ID
					position = str.lastIndexOf("@ FAM");
					strbulk1 = str.substring(0, position);
					strbulk1len = strbulk1.length();
					strbulk = strbulk1.substring(3, strbulk1len);
					strFamily = strbulk;			

				}

				// get the next line if it exists
				i++;
				if (i < newList.size()) {
					str = (String) newList.get(i);
				}

			}

		}

		//** to here **

		int iCounter = 0;
		while (iCounter < IndvList.size()) {
			String scratch = (String) IndvList.get(iCounter);
			// Log.e(sFragmentName, scratch);
			iCounter++;
		}
		
		// process the array for INDI

		i = 0;								// reset the counter
		if ( newList.size() > i ) {

			// get the first row
			str = (String) newList.get(i);

			// bypass everything until the first INDIVIDUAL
			while ( (i < newList.size()) && !(str.endsWith("@ INDI")) ) {
				i++;
				str = (String) newList.get(i);
			}	
			iNumIndv++;

			if  (str.endsWith("@ INDI") ) {
				// get the first INDI ID
				int position = str.lastIndexOf("@ INDI");
				String strbulk1 = str.substring(0, position);
				int strbulk1len = strbulk1.length();
				strbulk = strbulk1.substring(3, strbulk1len);
				strINDI = strbulk;		
			}
			
			// get the next line if it exists
			i++;
			if (i < newList.size()) {
				str = (String) newList.get(i);
			}
			

			while (i < newList.size()) {

				String scratch = " ";

				boolean bHusbandExists	= false;
				boolean bWifeExists		= false;
				boolean bChildExists	= false;
				boolean surnexists		= false;

				// int iChildren = 0;
				String sHusbandTxt	= "~";
				String sWifeTxt		= "~";

				while ( (i < newList.size()) && !(b = str.endsWith("@ INDI")) && !(str.startsWith("0 TRLR")) && !(str.endsWith("@ SOUR")) && !(str.endsWith("@ FAM")) && !(str.indexOf("@ NOTE") > 0) ) {

					//  process the INDIVIDUAL's details

					if (str.startsWith("2 SURN")) {    					
						// what if there is no SURN for this INDI
						surnexists = true;
						for(int index=0; index < IndvList.size(); index++) {  // loop through the list and replace each instance of the surname
							scratch = (String) IndvList.get(index);

							// break it up into family, father, mother
					
							if (b = scratch.indexOf(strINDI) > 0) {  // if it is the right family
								String scratchFamily = scratch.substring(0,scratch.indexOf(" : "));
								String scratchFather = scratch.substring(scratch.indexOf(" : ") + 3, scratch.lastIndexOf(" :"));
								String scratchMother = scratch.substring(scratch.lastIndexOf(" : ") + 3, scratch.length());
								if (scratchFather.equals(strINDI)) { 
									scratchFather = scratchFather.replace(strINDI, str.substring(7, str.length()));
								}
								if (scratchMother.equals(strINDI)) {
									scratchMother = scratchMother.replace(strINDI, str.substring(7, str.length()));    					   			
								}
								String newScratch = scratchFamily + " : " + scratchFather + " : " + scratchMother;
								IndvList.set(index, newScratch);
							}
						}
					}
					else {
						// do nothing
					}

					//  end process the INDIVIDUAL's details

					// get the next line if it exists
					i++;
					if (i < newList.size()) {
						str = (String) newList.get(i);
					}
				}

				if (b = str.endsWith("@ INDI")) {
					iNumIndv++;

					if (!surnexists) {				// no SURN records exists for INDI
						for(int index=0; index < IndvList.size(); index++) {
							scratch = (String) IndvList.get(index);
							if (b = scratch.indexOf(strINDI) > 0) {
								scratch = scratch.replace(strINDI, "Unknown");
								IndvList.set(index, scratch);    					            
							}
						}
					}

				
					// get the first INDI ID
					int position = str.lastIndexOf("@ INDI");
					String strbulk1 = str.substring(0, position);
					int strbulk1len = strbulk1.length();
					strbulk = strbulk1.substring(3, strbulk1len);
					strINDI = strbulk;										
				}

				// get the next line if it exists
				i++;
				if (i < newList.size()) {
					str = (String) newList.get(i);
				}

			}

		}

		ListView lv= (ListView)getView().findViewById(R.id.listview);  // get the inflated view ID element

		// create the grid item mapping
		String[] from = new String[] {"col_1", "col_2", "col_3"};
		int[] to = new int[] { R.id.item2, R.id.item3, R.id.item4 };

		// prepare the list of all records
		List<HashMap<String, String>> fillMaps = new ArrayList<HashMap<String, String>>();

		for(int z = 0; z < IndvList.size(); z++){        	
			String scratch = (String) IndvList.get(z);
			int pos1 = scratch.indexOf(" : ");
			String scratch1 = scratch.substring(0,pos1);
			int pos2 = scratch.lastIndexOf(" : ");
			String scratch2 = scratch.substring(pos1 + 2,pos2);
			String scratch3 = scratch.substring(pos2 + 2);

			HashMap<String, String> map = new HashMap<String, String>();
			// map.put("rowid", "" + i);
			map.put("col_1", scratch1);
			map.put("col_2", scratch2);
			map.put("col_3", scratch3);
			fillMaps.add(map);
		}        

		// fill in the grid_item layout
		SimpleAdapter adapter = new SimpleAdapter(getActivity(), fillMaps, R.layout.grid_item, from, to);
		lv.setAdapter(adapter);

		
		lv.setOnItemClickListener(new OnItemClickListener() {
			public void onItemClick(AdapterView parent, View view, int position, long id) {

				String Family_id = ((TextView)view.findViewById(R.id.item2)).getText().toString();

				Intent intent = new Intent();
				intent.setClass(getActivity(), ListIndv3Activity.class);
				intent.putExtra("fname", fname);
				intent.putExtra("indvtype", "family");
				intent.putExtra("family", Family_id);
				intent.putExtra("familytype", familytype);
				intent.putExtra("parentactivity", sFragmentName);			
				startActivity(intent);	    

			}
		});

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
