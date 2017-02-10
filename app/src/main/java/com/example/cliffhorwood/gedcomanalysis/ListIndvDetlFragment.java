package com.example.cliffhorwood.gedcomanalysis;

import com.example.cliffhorwood.gedcomanalysis.Classes.*;

import java.io.BufferedReader;
import java.io.FileReader;
import android.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class ListIndvDetlFragment extends Fragment{

	private CharSequence strName;
	private CharSequence strAddress;
	private CharSequence strCont;
	private CharSequence strAddress1;
	private CharSequence strCity;
	private CharSequence strState;
	private CharSequence strPost;
	private CharSequence strCountry;
	private CharSequence strPhone;
	private CharSequence strEmail;
	private CharSequence strSour;
	private CharSequence strVers1;
	private CharSequence strCopr;
	// private CharSequence strGEDC;
	private CharSequence strVers2;
	private CharSequence strForm;
	// private CharSequence strChar;
	private CharSequence strLang;
	private CharSequence strCharSet;
	private CharSequence strFile;
	private CharSequence strDate;
	private CharSequence strTime;
	private CharSequence strName2;
	
	int prefix = 6;

	/** 
	Called once the fragment is associated with its activity.
	public void onAttach() {
		super.onAttach(getActivity());
		Log.e("ListIndvDetlFragment", "onAttach()");		
	}
	*/
	
	/** Called to do initial creation of the fragment. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		Log.e("ListIndvDetlFragment", "onCreate()");

        // String eol = System.getProperty("line.separator");
        String str;
        // String strbulk;
        boolean b;
        
		MyMethods myMethods = new MyMethods();
		String sExtStorageDirectory = myMethods.extStorageDir();
		
        Bundle extras = getActivity().getIntent().getExtras();
        String fname = extras.getString("fname");

        try {
        	
            BufferedReader in = new BufferedReader(new FileReader(sExtStorageDirectory + fname));
			
            while (((str = in.readLine()) != null) && !(str.startsWith("1 GEDC"))) {
            	if (str.startsWith("1 SOUR")) {
            		strSour = str.substring(prefix,str.length());
             	}
             	else if (str.startsWith("2 VERS")) { 
             		Log.e("ListIndvDetlFragment", "processing strVers1");
             		strVers1 = str.substring(prefix,str.length());
             	}
             	else if (str.startsWith("2 NAME")) {            		
             		strName2 = str.substring(prefix,str.length());
              	}
             	else if (str.startsWith("1 DATE")) {            		
             		strDate = str.substring(prefix,str.length());
              	}
             	else if (str.startsWith("2 TIME")) {            		
             		strTime = str.substring(prefix,str.length());
              	}
             	else if (str.startsWith("1 FILE")) {            		
             		strFile = str.substring(prefix,str.length());
              	}
             	else if (str.startsWith("1 COPR")) {            		
             		strCopr = str.substring(prefix,str.length());
               	}
            }

            while (((str = in.readLine()) != null) && !(b = str.indexOf("@ SUBM") > 0)) {                       			
                // bypass 
        		// Log.e("ListIndvDetlFragment", "processing HEAD");

             	if (str.startsWith("1 GEDC")) {            		
                	// strGEDC = str.substring(prefix,str.length());
               	}
             	else if (str.startsWith("2 VERS")) {            		
             		Log.e("ListIndvDetlFragment", "processing strVers2");
                	strVers2 = str.substring(prefix,str.length());
               	}
             	else if (str.startsWith("2 FORM")) {            		
                	strForm = str.substring(prefix,str.length());
               	}
             	else if (str.startsWith("1 CHAR")) {            		
                	strCharSet = str.substring(prefix,str.length());
               	}
             	else if (str.startsWith("1 LANG")) {            		
             	    strLang = str.substring(prefix,str.length());
            	}
            }

            while (((str = in.readLine()) != null) && !(b = str.indexOf("@ INDI") > 0)) {   
        		// Log.e("ListIndvDetlFragment", "processing SUBM");
            	if (str.startsWith("1 NAME")) {
            	   strName = str.substring(prefix,str.length());
            	}
            	else if (str.startsWith("1 ADDR")) {            		
             	   strAddress = str.substring(prefix,str.length());
            	}
            	else if (str.startsWith("2 CONT")) {            		
             	   strCont = str.substring(prefix,str.length());
            	}
            	else if (str.startsWith("2 ADR1")) {            		
             	   strAddress1 = str.substring(prefix,str.length());
            	}
            	else if (str.startsWith("2 CITY")) {            		
             	   strCity = str.substring(prefix,str.length());
            	}
            	else if (str.startsWith("2 STAE")) {            		
             	   strState = str.substring(prefix,str.length());
            	}
            	else if (str.startsWith("2 POST")) {            		
             	   strPost = str.substring(prefix,str.length());
            	}
            	else if (str.startsWith("2 CTRY")) {            		
             	   strCountry = str.substring(prefix,str.length());
            	}
            	else if (str.startsWith("1 EMAIL")) {            		
             	   strEmail = str.substring(prefix + 1,str.length());
            	}
            }

            in.close();
                        
		}
		catch( Exception error ) {
			Log.e("ListDetlActivity", "onActivityCreated(): " + error.toString());
		}
		
	}
	
	/** Creates and returns the view hierarchy associated with the fragment.  */
	@Override
	public View onCreateView (LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		Log.e("ListIndvDetlFragment", "onCreateView() 1");
		View myFragmentView = inflater.inflate(R.layout.individual, container, false);		  

		Log.e("ListIndvDetlFragment", "onCreateView() 2");

        View tv0 = myFragmentView.findViewById(R.id.name);
        ((TextView)tv0).setText(strName);
        
        View tv1 = myFragmentView.findViewById(R.id.address);
        ((TextView)tv1).setText(strAddress);
        
        View tv2 = myFragmentView.findViewById(R.id.cont);
        ((TextView)tv2).setText(strCont);

        View tv3 = myFragmentView.findViewById(R.id.address1);
        ((TextView)tv3).setText(strAddress1);

        View tv4 = myFragmentView.findViewById(R.id.city);
        ((TextView)tv4).setText(strCity);

        View tv5 = myFragmentView.findViewById(R.id.state);
        ((TextView)tv5).setText(strState);

        View tv6 = myFragmentView.findViewById(R.id.post);
        ((TextView)tv6).setText(strPost);

        View tv7 = myFragmentView.findViewById(R.id.country);
        ((TextView)tv7).setText(strCountry);

        View tv8 = myFragmentView.findViewById(R.id.phone);
        ((TextView)tv8).setText(strPhone);

        View tv9 = myFragmentView.findViewById(R.id.email);
        ((TextView)tv9).setText(strEmail);

        View tv10 = myFragmentView.findViewById(R.id.source);
        ((TextView)tv10).setText(strSour);
        
        View tv11 = myFragmentView.findViewById(R.id.vers1);
        ((TextView)tv11).setText(strVers1);
        
        View tv12 = myFragmentView.findViewById(R.id.name2);
        ((TextView)tv12).setText(strName2);

        View tv13 = myFragmentView.findViewById(R.id.date);
        ((TextView)tv13).setText(strDate);

        View tv14 = myFragmentView.findViewById(R.id.time);
        ((TextView)tv14).setText(strTime);

        View tv15 = myFragmentView.findViewById(R.id.file);
        ((TextView)tv15).setText(strFile);

        View tv16 = myFragmentView.findViewById(R.id.copyright);
        ((TextView)tv16).setText(strCopr);

        View tv18 = myFragmentView.findViewById(R.id.vers2);
        ((TextView)tv18).setText(strVers2);

        View tv19 = myFragmentView.findViewById(R.id.form);
        ((TextView)tv19).setText(strForm);
           
        View tv20 = myFragmentView.findViewById(R.id.charset);
        ((TextView)tv20).setText(strCharSet);
           
        View tv21 = myFragmentView.findViewById(R.id.language);
        ((TextView)tv21).setText(strLang);
           
		Log.e("ListIndvDetlFragment", "onCreateView() 3");

		return myFragmentView;
	}
	
	/**  Tells the fragment that its activity has completed its own Activity.onCreate() */
	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		Log.e("ListIndvDetlFragment", "onActivityCreated()");
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
