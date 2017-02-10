package com.example.cliffhorwood.gedcomanalysis;

import com.example.cliffhorwood.gedcomanalysis.Classes.MyMethods;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;

import android.app.ListFragment;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class ListIndv3Fragment extends ListFragment{

	private String sFragmentName = this.getClass().getSimpleName();

	/** from here **/
	private int iMale = 0;
	private int iFemale = 0;
	private int iSexunkn = 0;

	private int iSurnall = 0;
	private int iSurnunkn = 0;
	private int iSurnblnk = 0;

	private int iNoDesc = 0;
	private int iNoAncs = 0;
	private int iNoBirt = 0;
	private int iNoBuri = 0;
	private int iNoDeat = 0;
	private int iNoChrs = 0;
	private int iNoResi = 0;
	private int iNoSrce = 0;
	private int iNoNote = 0;
	private int iNoImmi = 0;
	private int iNoEmmi = 0;
	private int iNoBapm = 0;
	private int iNoOccu = 0;
	private int iNoEven = 0;
	private int iNoSex  = 0;

	private int iNumIndv = 0;	
	private int iNumEVEN = 0;
	private int iNumNOTE = 0;
	private int iNumRESI = 0;
	private int iNumSOUR = 0;

	private int iPrefix = 7;

	private String indvtype = " ";

	private boolean famsexists;
	private boolean famcexists;

	/** Called once the fragment is associated with its activity.  **/
	public void onAttach() {
		super.onAttach(getActivity());
		Log.i(sFragmentName, "onAttach()");
	}

	/** Called to do initial creation of the fragment. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		Log.i(sFragmentName, "onCreate()");
	}

	@Override
	public View onCreateView (LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		Log.i(sFragmentName, "onCreateView()");
		View myFragmentView = inflater.inflate(R.layout.list, container, false);		  
		return myFragmentView;
	}

	/**  Tells the fragment that its activity has completed its own Activity.onCreate() */
	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);

		Log.i(sFragmentName, "onActivityCreated()");

		String str = "";
		String strbulk;
		String strNAME    = "1 NAME ";
		String sName = " ";
		String sSex  = " ";
		int strNAMElen    = strNAME.length();
		boolean b;

		MyMethods myMethods = new MyMethods();
		// String sExtStorageDirectory = myMethods.extStorageDir();

		Bundle extras = getActivity().getIntent().getExtras();
		final String fname    = extras.getString("fname");
		final String indvtype = extras.getString("indvtype");
		final String vSurname = extras.getString("surname");
		final String vNote    = extras.getString("note");
		final String vFamily  = extras.getString("family");
		final String vSource  = extras.getString("source");

		// String sFullyQualFileName = sExtStorageDirectory + fname;

		List IndvList = new LinkedList();         
		IndvList      = new ArrayList(); 

		List FatherList	= new LinkedList();
		FatherList		= new ArrayList();

		List MotherList	= new LinkedList();
		MotherList		= new ArrayList();

		List ChildList	= new LinkedList();
		ChildList		= new ArrayList();

		List SurnList = new LinkedList();
		SurnList      = new ArrayList();

		List newList  = new LinkedList();
		newList       = new ArrayList();

		newList = myMethods.LoadTextFileToArray((ArrayList<String>) newList, fname);

		if (newList.size() > 0) {

			List IndividualList	= new LinkedList();
			IndividualList		= new ArrayList();
			IndividualList		= myMethods.LoadIndividualsToArray((ArrayList<String>) IndividualList, (ArrayList<String>) newList);	

			if (IndividualList.size() > 0) {

				// process the array

				int i = 0;

				while (i < IndividualList.size()) {

					if (i < IndividualList.size()) {				// get the next line if it exists
						str = (String) IndividualList.get(i);
					}

					boolean aliasname  = false;
					boolean bapmexists = false;	
					boolean birtexists = false;
					boolean buriexists = false;
					// boolean chldexists = false;	
					boolean chrsexists = false;
					boolean deatexists = false;
					boolean emigexists = false;
					boolean evenexists = false;
					boolean famcexists = false;
					boolean famsexists = false;
					boolean immiexists = false;
					boolean noteexists = false;
					boolean occuexists = false;
					boolean resiexists = false;
					// boolean sexexists  = false;
					boolean srceexists = false;
					// boolean surnblnk   = false;
					boolean surnexists = false;
					boolean surnfound  = false;
					boolean surnunkn   = false;

					String scratch = " ";

					while ( !(b = str.endsWith("@ INDI"))  && (i < IndividualList.size())  )  {

						//  process the individual's details

						if (str.startsWith(strNAME)) {
							if (!aliasname) {					// if not alias then process
								int strlen = str.length();
								strbulk = str.substring(strNAMElen,strlen);
								// first middle /surname/
								int k = strbulk.indexOf("/");
								int j = strbulk.length();
								String surname    = strbulk.substring(k + 1, j - 1);
								if (surname.length() == 0) {
									//	surname = "~";				// For situation where surname is blank
								}						
								String firstnames = "Unknown";		// For situation where surname only
								if (k > 1) {						// surname only
									firstnames = strbulk.substring(0, k - 1);            			
								}
								sName = surname + ", " + firstnames;   
								aliasname = true;					// any more names will be alias
							}
						}  			
						else if (str.startsWith("1 SEX")) {
							// sexexists = true;
							sSex = " ";
							if (str.endsWith("M")) {
								iMale++;
								sSex = "M";
							}
							else if (str.endsWith("F")) {
								iFemale++;
								sSex = "F";
							}
							else {
								iSexunkn++;
								sSex = "U";
							}
						}
						else if (str.startsWith("2 SURN")) {
							surnexists = true;
							scratch = str.substring(iPrefix,str.length());
							if (scratch.toLowerCase(Locale.getDefault()).equals("unknown")) {
								surnunkn = true;
								iSurnunkn++;
							}
							else if ( (scratch == null) || (scratch.length() == 0) || (scratch.equals("")) ) {
								// surnblnk = true;
								iSurnblnk++;
							}
							else if (scratch.equalsIgnoreCase(vSurname)) {		// found the exact surname
								surnfound = true;
							}
						}
						else if (str.startsWith("1 BAPM")) {
							bapmexists = true;
						}					
						else if (str.startsWith("1 BIRT")) {
							birtexists = true;
						}
						else if (str.startsWith("1 BURI")) {
							buriexists = true;
						}
						else if (str.startsWith("1 CHIL")) {
							// chldexists = true;
						}
						else if (str.startsWith("1 CHR")) {
							chrsexists = true;
						}
						else if (str.startsWith("1 DEAT")) {
							deatexists = true;
						}
						else if (str.startsWith("1 EMIG")) {
							emigexists = true;
						}					
						else if (str.startsWith("1 EVEN")) {
							evenexists = true;
						}					
						else if ((str.startsWith("1 FAMC")) && (str.indexOf("@" + vFamily + "@") > 0)) {
							famcexists = true;
						}
						else if ((str.startsWith("1 FAMS")) && (str.indexOf("@" + vFamily + "@") > 0)) {
							famsexists = true;
						} 
						else if (str.startsWith("1 IMMI")) {
							immiexists = true;
						}					
						else if (str.startsWith("1 NOTE") || str.startsWith("2 NOTE")) {
							// if (str.indexOf("@" + vNote + "@") > 0) {
								noteexists = true;
							// }
						}
						else if (str.startsWith("1 OCCU")) {
							occuexists = true;
						}					
						else if (str.startsWith("1 RESI")) {
							resiexists = true;
						}
						else if (str.startsWith("1 SOUR") || str.startsWith("2 SOUR")) {							
							// if (str.indexOf("@" + vSource + "@") > 0) {
								srceexists = true;
							// }
						}
						else {
							// do something else
						}

						//  end process the individual's details

						i++;
						if (i < IndividualList.size()) {				// get the next line if it exists
							str = (String) IndividualList.get(i);
						}

					}					// while (!(b = str.endsWith("@ INDI")))

					if (!sName.equals(" ")) {

						if (indvtype.equalsIgnoreCase("ALL")) {
							boolean namefound = false;
							namefound = myMethods.NameExistsInArray((ArrayList<String>) IndvList, sName);	
							if (!namefound) {	
								IndvList.add(sName);
							}
						}
						else if (indvtype.equalsIgnoreCase("SURNAME") && (surnfound)) {
							boolean namefound = false;
							namefound = myMethods.NameExistsInArray((ArrayList<String>) IndvList, sName);	
							if (!namefound) {	
								IndvList.add(sName);
							}
						}
						else if (indvtype.equalsIgnoreCase("MALE")    && sSex.equalsIgnoreCase("M")) {
							boolean namefound = false;
							namefound = myMethods.NameExistsInArray((ArrayList<String>) IndvList, sName);	
							if (!namefound) {	
								IndvList.add(sName);
							}
						}
						else if (indvtype.equalsIgnoreCase("FEMALE")  && sSex.equalsIgnoreCase("F")) {
							boolean namefound = false;
							namefound = myMethods.NameExistsInArray((ArrayList<String>) IndvList, sName);	
							if (!namefound) {	
								IndvList.add(sName);
							}			
						}
						
						// Information
						
						else if (indvtype.equalsIgnoreCase("NOTE") && (noteexists)) {
							boolean namefound = false;
							namefound = myMethods.NameExistsInArray((ArrayList<String>) IndvList, sName);	
							if (!namefound) {	
								IndvList.add(sName);
							}			
						}
						else if (indvtype.equalsIgnoreCase("SOURCE") && (srceexists)) {
							boolean namefound = false;
							namefound = myMethods.NameExistsInArray((ArrayList<String>) IndvList, sName);	
							if (!namefound) {	
								IndvList.add(sName);
							}			
						}	
						
						// Events
						
						else if (indvtype.equalsIgnoreCase("BAPTISM") && (bapmexists) ) {
							boolean namefound = false;
							namefound = myMethods.NameExistsInArray((ArrayList<String>) IndvList, sName);	
							if (!namefound) {	
								IndvList.add(sName);
							}			
						}	
						else if (indvtype.equalsIgnoreCase("BIRTH") && (birtexists)) {
							boolean namefound = false;
							namefound = myMethods.NameExistsInArray((ArrayList<String>) IndvList, sName);	
							if (!namefound) {	
								IndvList.add(sName);
							}			
						}
						else if (indvtype.equalsIgnoreCase("BURIAL") && (buriexists)) {
							boolean namefound = false;
							namefound = myMethods.NameExistsInArray((ArrayList<String>) IndvList, sName);	
							if (!namefound) {	
								IndvList.add(sName);
							}			
						}	
						else if (indvtype.equalsIgnoreCase("CHRIST") && (chrsexists)) {
							boolean namefound = false;
							namefound = myMethods.NameExistsInArray((ArrayList<String>) IndvList, sName);	
							if (!namefound) {	
								IndvList.add(sName);
							}			
						}
						else if (indvtype.equalsIgnoreCase("DEATH") && (deatexists)) {
							boolean namefound = false;
							namefound = myMethods.NameExistsInArray((ArrayList<String>) IndvList, sName);	
							if (!namefound) {
								IndvList.add(sName);
							}			
						}
						else if (indvtype.equalsIgnoreCase("EMIGRATION") && (emigexists)) {
							boolean namefound = false;
							namefound = myMethods.NameExistsInArray((ArrayList<String>) IndvList, sName);	
							if (!namefound) {	
								IndvList.add(sName);
							}			
						}	
						else if (indvtype.equalsIgnoreCase("EVENT") && (evenexists)) {
							boolean namefound = false;
							namefound = myMethods.NameExistsInArray((ArrayList<String>) IndvList, sName);	
							if (!namefound) {	
								IndvList.add(sName);
							}			
						}	
						else if (indvtype.equalsIgnoreCase("IMMIGRATION") && (immiexists)) {
							boolean namefound = false;
							namefound = myMethods.NameExistsInArray((ArrayList<String>) IndvList, sName);	
							if (!namefound) {	
								IndvList.add(sName);
							}			
						}	
						else if (indvtype.equalsIgnoreCase("OCCUPATION") && (occuexists)) {
							boolean namefound = false;
							namefound = myMethods.NameExistsInArray((ArrayList<String>) IndvList, sName);	
							if (!namefound) {	
								IndvList.add(sName);
							}			
						}	
						else if (indvtype.equalsIgnoreCase("RESID") && (resiexists)) {
							boolean namefound = false;
							namefound = myMethods.NameExistsInArray((ArrayList<String>) IndvList, sName);	
							if (!namefound) {	
								IndvList.add(sName);
							}			
						}
						
						// Family 
						
						else if (indvtype.equalsIgnoreCase("FAMILY") && (famsexists ) && sSex.equalsIgnoreCase("M")) {
							boolean namefound = false;
							namefound = myMethods.NameExistsInArray((ArrayList<String>) IndvList, sName);	
							if (!namefound) {	
								FatherList.add(sName);
							}			
						}
						else if (indvtype.equalsIgnoreCase("FAMILY") && (famsexists ) && sSex.equalsIgnoreCase("F")) {
							boolean namefound = false;
							namefound = myMethods.NameExistsInArray((ArrayList<String>) IndvList, sName);	
							if (!namefound) {	
								MotherList.add(sName);
							}			
						}
						else if (indvtype.equalsIgnoreCase("FAMILY") && (famcexists )) {
							boolean namefound = false;
							namefound = myMethods.NameExistsInArray((ArrayList<String>) IndvList, sName);	
							if (!namefound) {	
								ChildList.add(sName);
							}			
						}
						
						// Missing 
						
						else if (indvtype.equalsIgnoreCase("NOBIRTH") && (!birtexists)) {
							boolean namefound = false;
							namefound = myMethods.NameExistsInArray((ArrayList<String>) IndvList, sName);	
							if (!namefound) {	
								IndvList.add(sName);
							}			
						}
						else if (indvtype.equalsIgnoreCase("NODEATH") && (!deatexists)) {
							boolean namefound = false;
							namefound = myMethods.NameExistsInArray((ArrayList<String>) IndvList, sName);	
							if (!namefound) {
								IndvList.add(sName);
							}			
						}
						else if (indvtype.equalsIgnoreCase("NOSEX")  && sSex.equalsIgnoreCase("U") ) {
							boolean namefound = false;
							namefound = myMethods.NameExistsInArray((ArrayList<String>) IndvList, sName);	
							if (!namefound) {	
								IndvList.add(sName);
							}			
						}
						else if (indvtype.equalsIgnoreCase("UNKNOWN") && sSex.equalsIgnoreCase("U")) {
							boolean namefound = false;
							namefound = myMethods.NameExistsInArray((ArrayList<String>) IndvList, sName);	
							if (!namefound) {	
								IndvList.add(sName);
							}
						}
						else if (indvtype.equalsIgnoreCase("SURNUNKN") && (surnexists) && (surnunkn)) {
							boolean namefound = false;
							namefound = myMethods.NameExistsInArray((ArrayList<String>) IndvList, sName);	
							if (!namefound) {	
								IndvList.add(sName);
							}			
						}
						else if ( indvtype.equalsIgnoreCase("SURNBLNK") && (!surnexists) ) {
							boolean namefound = false;
							namefound = myMethods.NameExistsInArray((ArrayList<String>) IndvList, sName);	
							if (!namefound) {	
								IndvList.add(sName);
							}	
						}
						else if ( indvtype.equalsIgnoreCase("SURNBLNK") && (surnexists) ) {
							boolean namefound = false;
							namefound = myMethods.NameExistsInArray((ArrayList<String>) IndvList, sName);	
							if (!namefound) {	
								IndvList.add(sName);
							}	
						}
						
						// Multiple 
						
						else if (indvtype.equalsIgnoreCase("MULTIEMIG") && (emigexists)) {			
							boolean namefound = false;
							namefound = myMethods.NameExistsInArray((ArrayList<String>) IndvList, sName);	
							if (!namefound) {	
								IndvList.add(sName);
							}			
						}
						else if (indvtype.equalsIgnoreCase("MULTIIMMI") && (immiexists)) {			
							boolean namefound = false;
							namefound = myMethods.NameExistsInArray((ArrayList<String>) IndvList, sName);	
							if (!namefound) {	
								IndvList.add(sName);
							}			
						}
						else if (indvtype.equalsIgnoreCase("MULTINOTES") && (noteexists)) {			
							boolean namefound = false;
							namefound = myMethods.NameExistsInArray((ArrayList<String>) IndvList, sName);	
							if (!namefound) {	
								IndvList.add(sName);
							}			
						}
						else if (indvtype.equalsIgnoreCase("MULTIOCCU") && (occuexists)) {			
							boolean namefound = false;
							namefound = myMethods.NameExistsInArray((ArrayList<String>) IndvList, sName);	
							if (!namefound) {	
								IndvList.add(sName);
							}			
						}
						else if (indvtype.equalsIgnoreCase("MULTIRESID") && (resiexists)) {			
							boolean namefound = false;
							namefound = myMethods.NameExistsInArray((ArrayList<String>) IndvList, sName);	
							if (!namefound) {	
								IndvList.add(sName);
							}			
						}
						else if (indvtype.equalsIgnoreCase("MULTISOURCES") && (srceexists)) {			
							boolean namefound = false;
							namefound = myMethods.NameExistsInArray((ArrayList<String>) IndvList, sName);	
							if (!namefound) {	
								IndvList.add(sName);
							}			
						}
						else {
							// do something else
						}	

					}		 // if (!sName.equals(" "))

					i++;
				}						// while (i < IndividualList.size())

				// end process the array

			}
			else {

				// do something else IndividualList is empty	

			}

		}
		else {

			// do something else newList is empty

		}

		/**
		List  FamilyList	= new LinkedList();
		FamilyList			= new ArrayList();
		FamilyList			= myMethods.LoadFamilyToArray((ArrayList<String>)  FamilyList, (ArrayList<String>) newList);	

		List  SourceList	= new LinkedList();
		SourceList			= new ArrayList();
		SourceList			= myMethods.LoadSourceToArray((ArrayList<String>)  SourceList, (ArrayList<String>) newList);	

		List  NoteList		= new LinkedList();
		NoteList			= new ArrayList();
		NoteList			= myMethods.LoadNoteToArray((ArrayList<String>)  NoteList, (ArrayList<String>) newList);	

		 **/

		if (IndvList.isEmpty() && ( !FatherList.isEmpty() || !MotherList.isEmpty() || !ChildList.isEmpty() )) {

			if (!FatherList.isEmpty()) {
				IndvList.addAll(FatherList);
			}
			if (!MotherList.isEmpty()) {
				IndvList.addAll(MotherList);
			}
			if (!ChildList.isEmpty()) {
				IndvList.addAll(ChildList);
			}

		}
		else {
			Collections.sort(IndvList, String.CASE_INSENSITIVE_ORDER); 
		}

		String[] simpleArray = new String[ IndvList.size() ];
		IndvList.toArray( simpleArray );	

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

		Bundle extras      = getActivity().getIntent().getExtras();
		String fname       = extras.getString("fname");
		String indvtype    = extras.getString("indvtype");
		String vSurname    = extras.getString("surname");
		String vFamilyId   = extras.getString("family");
		String vFamilytype = extras.getString("familytype");

		Intent intent = new Intent();
		intent.setClass(getActivity(), ShowIndvDetl1Activity.class);
		intent.putExtra("fname", fname);
		intent.putExtra("iname", item);
		intent.putExtra("indvtype",indvtype);
		intent.putExtra("surname", vSurname);
		intent.putExtra("family", vFamilyId);
		intent.putExtra("familytype", vFamilytype);
		intent.putExtra("parentactivity", sFragmentName );					
		startActivity(intent);	
		
	}

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
