package com.example.cliffhorwood.gedcomanalysis;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import android.app.ListFragment;
import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class ListFamlSummFragment extends ListFragment{

	/** 
	Called once the fragment is associated with its activity.
	public void onAttach() {
		super.onAttach(getActivity());
		Log.e("ListSummFragment", "onAttach()");		
	}
	*/
	
	/** Called to do initial creation of the fragment. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		Log.e("ListSummFragment", "onCreate()");
	}
	
	/** Creates and returns the view hierarchy associated with the fragment.

	// Not needed with ListFragment?
	
	@Override
	public View onCreateView (LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		Log.e("ListSummFragment", "onCreateView()");
		  View myFragmentView = inflater.inflate(R.layout.listsummfragment, container, false);		  
		  return myFragmentView;
	}
	 */
	
	/**  Tells the fragment that its activity has completed its own Activity.onCreate() */
	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		Log.e("ListSummFragment", "onActivityCreated()");

        String str;
        String strbulk;
        int strlen  = 0;
        int numINDI = 0;
        int numFAM  = 0;
        int numSURN = 0;
        int numSOUR = 0;
        int numNOTE = 0;
        
		String extStorageDirectory = Environment.getExternalStorageDirectory().toString();
		String dirNameSlashed = "/" + extStorageDirectory + "/";
		
        Bundle extras = getActivity().getIntent().getExtras();
        String fname = extras.getString("fname");
		
		List DISPlist = new LinkedList();
		DISPlist      = new ArrayList();
        List SURNlist = new LinkedList();         
        SURNlist      = new ArrayList();          
		
        String strSURN    = "2 SURN ";
		int    strSURNlen = strSURN.length();
		
        try {
        	
            BufferedReader in = new BufferedReader(new FileReader(dirNameSlashed + fname));
			
			while ((str = in.readLine()) != null) {				
			   if ((str.startsWith("0 @I")) && (str.indexOf("INDI") > 0)) {
			      numINDI = numINDI + 1;
			   }   
			   else if (str.endsWith("@ FAM")) {
			      numFAM = numFAM + 1;
			   }
			   else if (str.startsWith("2 SURN")) {
				   strlen = str.length();
				   strbulk = str.substring(strSURNlen,strlen);
				   // If the SURN is not already in the list, add it
				   int index = Collections.binarySearch(SURNlist, strbulk); 
				   if (index < 0) {
					   SURNlist.add(-index-1, strbulk);
					   numSURN = numSURN + 1;
				   }
			   }   
			   else if ((str.startsWith("0 @S")) && (str.indexOf("SOUR") > 0)) {
			      numSOUR = numSOUR + 1;
			   }   
			   else if ((str.startsWith("0 @N")) && (str.indexOf("NOTE") > 0)) {
			      numNOTE = numNOTE + 1;
			   }			      
			} 
			
            in.close();
            			
			DISPlist.add("Families     : "  + numFAM);
			
			String[] simpleArray = new String[ DISPlist.size() ];
			DISPlist.toArray( simpleArray );	

			ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(),
					android.R.layout.simple_list_item_1, simpleArray);
			setListAdapter(adapter);

		}
		catch( Exception error ) {
			Log.e( "ListSummFragment", "onActivityCreated(): " + error.toString() );
		}
	
	}

	@Override
	public void onListItemClick(ListView l, View v, int position, long id) {
		Log.e("ListSummFragment", "onListItemClick()");
		
		String item = (String) getListAdapter().getItem(position);

        Bundle extras = getActivity().getIntent().getExtras();
        String fname = extras.getString("fname");

		/**
		  if (item.startsWith("Individuals")) {
		 
	        Intent intent = new Intent();
	        intent.setClass(getActivity(), ListIndvActivity.class);
	        intent.putExtra("fname", fname);
	        startActivity(intent);	    
		}
		else 
			**/
			if (item.startsWith("Families")) {
	        Intent intent = new Intent();
	        intent.setClass(getActivity(), ListFamlActivity.class);
	        intent.putExtra("fname", fname);
	        startActivity(intent);	    
		}
		else if (item.startsWith("Surnames")) {
	        Intent intent = new Intent();
	        intent.setClass(getActivity(), ListSurnActivity.class);
	        intent.putExtra("fname", fname);
	        startActivity(intent);	    
		}
		else if (item.startsWith("Sources")) {
	        Intent intent = new Intent();
	        intent.setClass(getActivity(), ListSourActivity.class);
	        intent.putExtra("fname", fname);
	        startActivity(intent);	    
		}
		else if (item.startsWith("Notes")) {
	        Intent intent = new Intent();
	        intent.setClass(getActivity(), ListNoteActivity.class);
	        intent.putExtra("fname", fname);
	        startActivity(intent);	    
		}
		else if (item.startsWith("Details")) {
	        Intent intent = new Intent();
	        intent.setClass(getActivity(), ShowDetlActivity.class);
	        intent.putExtra("fname", fname);
	        startActivity(intent);	    
		}
		else {
			// default to individuals
	        Intent intent = new Intent();
	        intent.setClass(getActivity(), ZActivity.class);
	        intent.putExtra("fname", fname);
	        startActivity(intent);	    
		}
		
	}
		
	/** 
	Makes the fragment visible to the user (based on its containing activity being started).
	@Override
	public void onStart() {
		super.onStart();
		Log.e("ListSummFragment", "onStart()");		
	}
	*/	
	/** 
	Makes the fragment interacting with the user (based on its containing activity being resumed).  
	@Override
	public void onResume() {
		super.onResume();
		Log.e("ListSummFragment", "onResume()");		
	}
	*/
	
/**
 * As a fragment is no longer being used, it goes through a reverse series of callbacks:

onPause() fragment is no longer interacting with the user either because its activity is being paused or a fragment operation is modifying it in the activity.

onStop() fragment is no longer visible to the user either because its activity is being stopped or a fragment operation is modifying it in the activity.

onDestroyView() allows the fragment to clean up resources associated with its View.

onDestroy() called to do final cleanup of the fragment's state.

onDetach() called immediately prior to the fragment no longer being associated with its activity.

*/	 
	
}
