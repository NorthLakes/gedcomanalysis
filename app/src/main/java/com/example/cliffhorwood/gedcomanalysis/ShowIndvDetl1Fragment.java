package com.example.cliffhorwood.gedcomanalysis;

import com.example.cliffhorwood.gedcomanalysis.Classes.*;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class ShowIndvDetl1Fragment extends Fragment{

	onNumbersOfIndividualListener mListener;

	private String sFragmentName = this.getClass().getSimpleName();

	int prefix = 6;
	int iCtr = 0;

	String strINDI = "";

	/** Called once the fragment is associated with its activity. */
	@Override
	public void onAttach(Activity activity) {
		super.onAttach(getActivity());
		Log.i(sFragmentName, "onAttach()");
		try {
			mListener = (onNumbersOfIndividualListener) activity;
		} catch (ClassCastException e) {
			throw new ClassCastException(activity.toString() + " must implement onNumbersOfIndividualListener");
		}
	}

	// Container Activity must implement this interface
	public interface onNumbersOfIndividualListener {
		void onNumbersOfIndividual(int iCtr);
	}


	/** Called to do initial creation of the fragment. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		Log.i(sFragmentName, "onCreate()");
	}

	/** Creates and returns the view hierarchy associated with the fragment.  */
	@Override
	public View onCreateView (LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		Log.i(sFragmentName, "onCreateView()");
		View myFragmentView = inflater.inflate(R.layout.indv_listview, container, false);		  
		return myFragmentView;
	}

	/**  Tells the fragment that its activity has completed its own Activity.onCreate() */
	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);

		Log.i(sFragmentName, "onActivityCreated()");
		String str;
		boolean b;

		MyMethods myMethods = new MyMethods();
		// String sExtStorageDirectory = myMethods.extStorageDir();

		Bundle extras = getActivity().getIntent().getExtras();

		final String fname = extras.getString("fname");
		final String iname = extras.getString("iname");
		final String indvtype    = extras.getString("indvtype");
		final String vSurname    = extras.getString("surname");
		final String vFamilyId   = extras.getString("family");
		final String vFamilytype = extras.getString("familytype");

        // Log.i(sFragmentName, "onActivityCreated() - parentactivity: " + parentactivity);
        Log.i(sFragmentName, "onActivityCreated() - fname: " + fname);
        Log.i(sFragmentName, "onActivityCreated() - iname: " + iname);
        Log.i(sFragmentName, "onActivityCreated() - indvtype: " + indvtype);
        Log.i(sFragmentName, "onActivityCreated() - vSurname: " + vSurname);
        Log.i(sFragmentName, "onActivityCreated() - vFamilyId: " + vFamilyId);
        Log.i(sFragmentName, "onActivityCreated() - vFamilytype: " + vFamilytype);

        // String sFullyQualFileName = sExtStorageDirectory + fname;

		String strifullname = iname;
		int poscomma = iname.indexOf(",");
		String formattediname = iname.substring(poscomma + 2, iname.length()); // given names
		formattediname = formattediname + " /" + iname.substring(0, poscomma) + "/";

		// loop through the entire file
		// count how many times the EXACT formatted iname is found
		// create a list of the found ones
		// if  one  ONLY is found then the rest of this code is correct
		// for the below INDI will be needed
		// if more than 1 is found then work out which one/ones satisfies the (eg source) criteria
		// if  one  ONLY satisfies the criteria then the rest of this code is largely correct
		// if more than 1 satisfies the criteria then display a list of them to the user to select one

		List IndvList = new LinkedList();         
		IndvList      = new ArrayList();          

		List newList  = new LinkedList();
		newList       = new ArrayList();

		newList = myMethods.LoadTextFileToArray((ArrayList<String>) newList, fname);

		int i = 0;
		iCtr = 0;
		while (i < newList.size()) {
			str = (String) newList.get(i);
			if (str.endsWith("@ INDI")) {
				strINDI = str.substring(str.indexOf("@") + 1, str.lastIndexOf("@"));
			}
			if (str.startsWith( "1 NAME " + formattediname) ) { 
				iCtr++;
				IndvList.add(formattediname + " : " + strINDI);
			}
			i++;
		}

        Log.i(sFragmentName, "onActivityCreated() - formattediname: " + formattediname + " - strINDI: " + strINDI);

		String striCtr = "Individuals: " + iCtr;

		mListener.onNumbersOfIndividual(iCtr);
	}


	/**	As a fragment is no longer being used, it goes through a reverse series of callbacks:
	 onPause() 	onStop() onDestroyView() onDestroy() onDetach() **/

	/** Fragment is no longer interacting with the user either because its activity is being paused or a fragment operation is modifying it in the activity.  **/
	@Override
	public void onPause() {
		super.onPause();
		Log.i(sFragmentName, "onPause()");
	}

	/** Fragment is no longer visible to the user either because its activity is being stopped or a fragment operation is modifying it in the activity. **/
	@Override
	public void onStop() {
		super.onStop();
		Log.i(sFragmentName, "onStop()");
	}

	/** Allows the fragment to clean up resources associated with its View.  **/
	@Override
	public void onDestroyView() {
		super.onDestroyView();
		Log.i(sFragmentName, "onDestroyView()");
	}

	/** Called to do final cleanup of the fragment's state. **/
	@Override
	public void onDestroy() {
		super.onDestroy();
		Log.i(sFragmentName, "onDestroy()");
	}

	/** Called immediately prior to the fragment no longer being associated with its activity.  **/
	@Override
	public void onDetach() {
		super.onDetach();
		Log.i(sFragmentName, "onDetach()");
	}

}
