package com.example.cliffhorwood.gedcomanalysis;

import com.example.cliffhorwood.gedcomanalysis.Classes.*;

import java.io.BufferedReader;
import java.io.FileReader;
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
import android.widget.Toast;

public class ListFamlFragment extends ListFragment{

	private String strboth    = "Both parents known";
	private String strfather  = "Father only known";
	private String strmother  = "Mother only known";
	private String strneither = "Neither parent known";
	
	/** 
	Called once the fragment is associated with its activity.
	public void onAttach() {
		super.onAttach(getActivity());
		Log.e("ListFamlFragment", "onAttach()");		
	}
	*/
	
	/** Called to do initial creation of the fragment. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		Log.e("ListFamlFragment", "onCreate()");
	}
	
	/** Creates and returns the view hierarchy associated with the fragment. 

	// Not needed with ListFragment?
	
	@Override
	public View onCreateView (LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		Log.e("ListFamlFragment", "onCreateView()");
		  View myFragmentView = inflater.inflate(R.layout.families_listview, container, false);		  
		  return myFragmentView;
	}
	*/
	
	/**  Tells the fragment that its activity has completed its own Activity.onCreate() */
	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);

		Log.e("ListFamlFragment", "onActivityCreated()");

        String str;
        String strbulk;
        String strINDI;
        boolean b;
        
		MyMethods myMethods = new MyMethods();
		String sExtStorageDirectory = myMethods.extStorageDir();
		
        Bundle extras           = getActivity().getIntent().getExtras();
        final String fname      = extras.getString("fname");
        final String familytype = extras.getString("familytype");  
        
        // Log.e("ListFamlFragment",familytype);

		List FAMlist = new LinkedList();         
        FAMlist      = new ArrayList();     
        
		// Log.e("ListFamlFragment", "onActivityCreated(): " + "load the FAM into a list/array for processing");
		// Log.e("ListFamlFragment", "Size of FAMlist: " + FAMlist.size());
		        
        try {
            BufferedReader in = new BufferedReader(new FileReader(sExtStorageDirectory + fname));

    		while (((str = in.readLine()) != null) && !(str.endsWith("@ FAM"))) {
    			// bypass
    		}

    		// FAM
    		while (str.endsWith("@ FAM")) {
    			int position = str.lastIndexOf("@ FAM");
    			String strbulk1 = str.substring(0, position);
    			int strbulk1len = strbulk1.length();
    			strbulk = strbulk1.substring(3, strbulk1len);
    			String strFamily = strbulk;

    			boolean husbexists = false;
    			boolean wifeexists = false;
    			String strHUSBtxt = "~";
    			String strWIFEtxt = "~";
    			
    			while (((str = in.readLine()) != null) && !(b = str.startsWith("0"))) {
    				if (str.startsWith("1 HUSB")) {
    					husbexists = true;
    					strHUSBtxt =  str.substring(8,str.length() - 1);
    				}
    				else if (str.startsWith("1 WIFE")) {
    					wifeexists = true;
    					strWIFEtxt =  str.substring(8,str.length() - 1);
     				}
    				else if (str.startsWith("1 CHIL")) {
    					if (!husbexists && !wifeexists) {
    						// strFamily = strFamily + " : ~ : ~ ";
    					}
    				}
    			}

				if (husbexists && wifeexists) {
					boolean resultOfComparison=familytype.equals(strboth);
					if (resultOfComparison) {
		    			strFamily = strFamily + " : " + strHUSBtxt + " : " + strWIFEtxt;
						FAMlist.add(strFamily);    			
					}
				}
				else if (husbexists && !wifeexists) {
					boolean resultOfComparison=familytype.equals(strfather);
					if (resultOfComparison) {
		    			strFamily = strFamily + " : " + strHUSBtxt + " : " + strWIFEtxt;
						FAMlist.add(strFamily);    			
					}    					
				}
				else if (!husbexists && wifeexists) {
					boolean resultOfComparison=familytype.equals(strmother);
					if (resultOfComparison) {
		    			strFamily = strFamily + " : " + strHUSBtxt + " : " + strWIFEtxt;
						FAMlist.add(strFamily);    			
					}    					
				}
				else if (!husbexists && !wifeexists) {
					boolean resultOfComparison=familytype.equals(strneither);
					if (resultOfComparison) {
		    			strFamily = strFamily + " : " + strHUSBtxt + " : " + strWIFEtxt;
						FAMlist.add(strFamily);    									
					}    					
				}
				else {
					// something is wrong
				}
				// Log.e("ListFamlFragment", "strFamily: " + strFamily);
    		}

    		// Log.e("ListFamlFragment", "Size of FAMlist: " + FAMlist.size());
    		            		
    		while ((str = in.readLine()) != null)  {
            	if (str.startsWith("0 TRLR")) {
                    // bypass
            	}
            }
            
            in.close();
        }        
		catch( Exception error ) {
			Log.e("ListFamlFragment", "onActivityCreated() #1: " + error.toString());
		}
                
        // load the INDI into a list/array for processing        
        
        try {
            BufferedReader in = new BufferedReader(new FileReader(sExtStorageDirectory + fname));

    		while (((str = in.readLine()) != null) && !(b = str.indexOf("INDI") > 0)) {
    			// bypass
    		}

    		// INDI
    		while (b = str.indexOf("INDI") > 0) {
    			int position = str.lastIndexOf("@ INDI");
    			String strbulk1 = str.substring(0, position);
    			int strbulk1len = strbulk1.length();
    			strINDI = strbulk1.substring(3, strbulk1len);    			
    			boolean surnexists = false;
    			
    			while (((str = in.readLine()) != null) && !(b = str.indexOf("INDI") > 0)) {
    				if (str.startsWith("2 SURN")) {    					
    					surnexists = true;
    					for(int index=0; index < FAMlist.size(); index++) {
    					   	String scratch = (String) FAMlist.get(index);
    					   	if (b = scratch.indexOf(strINDI) > 0) {
    					   		scratch = scratch.replace(strINDI, str.substring(7, str.length()));
    					   		FAMlist.set(index, scratch);    					            
    					   	}
    					}
    				}
    			}
    			
    			if (!surnexists) {				// no SURN records exists for INDI
					for(int index=0; index < FAMlist.size(); index++) {
					   	String scratch = (String) FAMlist.get(index);
					   	if (b = scratch.indexOf(strINDI) > 0) {
					   		scratch = scratch.replace(strINDI, "Unknown");
					   		FAMlist.set(index, scratch);    					            
					   	}
					}
    			}
    		}
    		
    		while ((str = in.readLine()) != null)  {
            	if (str.startsWith("0 TRLR")) {
                    // bypass
            	}
            }
            
            in.close();
        }        
		catch( Exception error ) {
			Log.e("ListFamlFragment", "onActivityCreated() #2: " + error.toString());
		}
                
		String[] simpleArray = new String[ FAMlist.size() ];
		FAMlist.toArray( simpleArray );	

		ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(),
				android.R.layout.simple_list_item_1, simpleArray);
		setListAdapter(adapter);		
	}	

	@Override
	public void onListItemClick(ListView l, View v, int position, long id) {
	    super.onListItemClick(l, v, position, id);

	    Log.e("ListFamlFragment", "onListItemClick()");
		
		String item = (String) getListAdapter().getItem(position);

		// Create a piece of toast.
		Toast pieceToast = Toast.makeText(getActivity(), item, Toast.LENGTH_SHORT);
		pieceToast.show();

        Bundle extras = getActivity().getIntent().getExtras();
        String fname = extras.getString("fname");

		// default to ZActivity
	    Intent intent = new Intent();
	    intent.setClass(getActivity(), ZActivity.class);
	    intent.putExtra("fname", fname);
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
