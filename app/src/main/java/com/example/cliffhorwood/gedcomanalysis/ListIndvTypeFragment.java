package com.example.cliffhorwood.gedcomanalysis;

import com.example.cliffhorwood.gedcomanalysis.Classes.*;

import java.io.BufferedReader;
import java.io.FileReader;
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

public class ListIndvTypeFragment extends Fragment {

	private String strboth    = "Both parents known";
	private String strfather  = "Father only known";
	private String strmother  = "Mother only known";
	private String strneither = "Neither parent known";
	private String str;
	private String strbulk;
	private boolean b;
	private String strINDI;
	
	/** 
	Called once the fragment is associated with its activity.
	public void onAttach() {
		super.onAttach(getActivity());
		Log.e("ListIndvTypeFragment", "onAttach()");		
	}
	*/
	
	/** Called to do initial creation of the fragment. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		Log.e("ListIndvTypeFragment", "onCreate()");
	}
	
	/** Creates and returns the view hierarchy associated with the fragment.  */

	@Override
	public View onCreateView (LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		Log.e("ListIndvTypeFragment", "onCreateView()");
		  View myFragmentView = inflater.inflate(R.layout.families_listview, container, false);		  
		  return myFragmentView;
	}
	
	
	/**  Tells the fragment that its activity has completed its own Activity.onCreate() */
	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);

		Log.e("ListIndvTypeFragment", "onActivityCreated()");
        
		MyMethods myMethods = new MyMethods();
		String sExtStorageDirectory = myMethods.extStorageDir();
		
        Bundle extras = getActivity().getIntent().getExtras();
        final String fname  = extras.getString("fname");
        final String familytype = extras.getString("familytype");        

        // Log.e("familytype", familytype);

    	List FAMlist = new LinkedList();         
        FAMlist      = new ArrayList();          

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
			Log.e("LoadFamlActivity", "onActivityCreated(): " + error.toString());
		}
        
        try {
            BufferedReader in = new BufferedReader(new FileReader(sExtStorageDirectory + fname));

    		while (((str = in.readLine()) != null) && !(b = str.indexOf("INDI") > 0)) {
    			// bypass
    		}

    		// INDI
    		while (b = str.indexOf("INDI") > 0) {
    			// get the INDI id 
    			int position = str.lastIndexOf("@ INDI");
    			String strbulk1 = str.substring(0, position);
    			int strbulk1len = strbulk1.length();
    			strINDI = strbulk1.substring(3, strbulk1len);    			
    			boolean surnexists = false;
    			
    			while (((str = in.readLine()) != null) && !(b = str.indexOf("INDI") > 0)) {
    				if (str.startsWith("2 SURN")) {    					
    					// what if there is no SURN for this INDI
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
			Log.e("LoadFamlActivity", "onActivityCreated(): " + error.toString());
		}
                
        
        ListView lv= (ListView)getView().findViewById(R.id.listview);  // get the inflated view ID element

        // create the grid item mapping
        String[] from = new String[] {"col_1", "col_2", "col_3"};
        int[] to = new int[] { R.id.item2, R.id.item3, R.id.item4 };

        // prepare the list of all records
        List<HashMap<String, String>> fillMaps = new ArrayList<HashMap<String, String>>();

        for(int i = 0; i < FAMlist.size(); i++){
        	
        	String scratch = (String) FAMlist.get(i);
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
    	        intent.setClass(getActivity(), ZActivity.class);
    	        intent.putExtra("fname", fname);
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
