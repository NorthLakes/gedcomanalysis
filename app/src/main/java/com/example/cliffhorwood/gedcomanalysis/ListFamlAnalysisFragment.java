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

public class ListFamlAnalysisFragment extends ListFragment{

	private String sFragmentName = this.getClass().getSimpleName();

	private String sBoth	= "Both parents known";
	private String sFather	= "Father only known";
	private String sMother	= "Mother only known";
	private String sNeither	= "Neither parent known";
	private String sFamily	= " ";
	
	private int iBothParents = 0;
	private int iFatherOnly	= 0;
	private int iMotherOnly	= 0;
	private int iNoParents	= 0;	
	private int iChildren	= 0;
	private int iNumIndv	= 0;

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
		boolean b;

		MyMethods myMethods = new MyMethods();
		String sExtStorageDirectory = myMethods.extStorageDir();

		Bundle extras = getActivity().getIntent().getExtras();
		final String fname  = extras.getString("fname");
		final String family = extras.getString("family");        

		String sFullyQualFileName = sExtStorageDirectory + fname;

		List IndvList = new LinkedList();         
		IndvList      = new ArrayList(); 

		List newList  = new LinkedList();
		newList       = new ArrayList();

		newList = myMethods.LoadTextFileToArray((ArrayList<String>) newList, sFullyQualFileName);	

		// process the array

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

			// get the next line if it exists
			i++;
			if (i < newList.size()) {
				str = (String) newList.get(i);
			}

			while (i < newList.size()) {

				String scratch = " ";
				
				boolean bHusbandExists = false;
				boolean bWifeExists = false;
				boolean bChildExists = false;
				// int iChildren = 0;
				String sHusbandTxt = "~";
				String sWifeTxt = "~";

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
						bChildExists = true;
						iChildren++;
						if (!bHusbandExists && !bWifeExists) {
							// sFamily = sFamily + " : ~ : ~ ";
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
						iBothParents++;
					}
					else if  (bHusbandExists && !bWifeExists) {
						iFatherOnly++;
					}
					else if (!bHusbandExists && bWifeExists) {
						iMotherOnly++;
					}
					else if  (!bHusbandExists && !bWifeExists) {
						iNoParents++;
					}
					else {
						Log.e(sFragmentName, "Something wrong with parent counts");
					}
					sFamily = sFamily + " : " + sHusbandTxt + " : " + sWifeTxt;					
				}

				// get the next line if it exists
				i++;
				if (i < newList.size()) {
					str = (String) newList.get(i);
				}

			}

		}

		if (iBothParents >= 0) {
			IndvList.add(sBoth    + " : " + iBothParents);
		}
		if (iFatherOnly >= 0) {
			IndvList.add(sFather  + " : " + iFatherOnly);
		}
		if (iMotherOnly >= 0) {
			IndvList.add(sMother  + " : " + iMotherOnly);
		}
		if (iNoParents >= 0) {
			IndvList.add(sNeither + " : " + iNoParents);
		}

		String[] simpleArray = new String[ IndvList.size() ];
		IndvList.toArray( simpleArray );	

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
		super.onListItemClick(l, v, position, id);

		String item = (String) getListAdapter().getItem(position);

		Bundle extras = getActivity().getIntent().getExtras();
		String fname = extras.getString("fname");

		if (item.startsWith(sBoth)) {
			Intent intent = new Intent();
			intent.setClass(getActivity(), ListFamlTypeActivity.class);
			intent.putExtra("fname", fname);
			intent.putExtra("familytype", sBoth);
			startActivity(intent);	    
		}
		else if (item.startsWith(sFather)) {
			Intent intent = new Intent();
			intent.setClass(getActivity(), ListFamlTypeActivity.class);
			intent.putExtra("fname", fname);
			intent.putExtra("familytype", sFather);
			startActivity(intent);	    
		}
		else if (item.startsWith(sMother)) {
			Intent intent = new Intent();
			intent.setClass(getActivity(), ListFamlTypeActivity.class);
			intent.putExtra("fname", fname);
			intent.putExtra("familytype", sMother);
			startActivity(intent);	    
		}
		else if (item.startsWith(sNeither)) {
			Intent intent = new Intent();
			intent.setClass(getActivity(), ListFamlTypeActivity.class);
			intent.putExtra("fname", fname);
			intent.putExtra("familytype", sNeither);
			startActivity(intent);	    
		}
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
