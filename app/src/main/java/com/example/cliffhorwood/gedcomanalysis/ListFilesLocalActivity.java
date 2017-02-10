package com.example.cliffhorwood.gedcomanalysis;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;

public class ListFilesLocalActivity extends Activity {
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Log.i(this.getLocalClassName(), "onCreate()");

        PreferenceManager.setDefaultValues(this, R.xml.preferences, false);        
        SharedPreferences sharedPref = PreferenceManager.getDefaultSharedPreferences(this);        
        String sFileLocation = sharedPref.getString(SettingsActivity.KEY_PREF_FILE_LOCATION, "");
        setContentView(R.layout.list_files);       
   	}		
	
    /** Called after your activity has been stopped, prior to it being started again.*/
    @Override
    public void onRestart() {
    	super.onPause();
        // Log.i(this.getLocalClassName(), "onRestart()");
    }
  
    /** Called when the activity is becoming visible to the user. */    
    @Override
    public void onStart() {
        super.onStart();
        // Log.i(this.getLocalClassName(), "onStart()");
        // Log.d(this.getLocalClassName(), "onStart()");
 		           
        // Need to check if Activity is on a large screen
        boolean mLargePane = false;
        if (getResources().getConfiguration().screenLayout == Configuration.SCREENLAYOUT_SIZE_XLARGE ) {       	
        	mLargePane = true;	// yes, it is large
        }
        
        if (mLargePane) {
            Log.i(this.getLocalClassName(), "xlarge pane"); 
        }
        else {
            Log.i(this.getLocalClassName(), "not xlarge pane"); 
        }
        	        
		// Need to check if Activity is in landscape mode. If yes, display fragments
        // Not applicable for this activity
        boolean mDualPane = false;
		if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {
		  	mDualPane = true;
		}

		if (mDualPane) {
            Log.i(this.getLocalClassName(), "dual pane");
		}
        else {
            Log.i(this.getLocalClassName(), "not dual pane");
        }

        // Get an instance of FragmentTransaction for the Activity
		FragmentManager fragmentManager = getFragmentManager();
		FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

		// Add a fragment
		ListFilesLocalFragment myFragment = new ListFilesLocalFragment();
		fragmentTransaction.replace(R.id.listfilesfragment, myFragment);
		// fragmentTransaction.addToBackStack(null);
		fragmentTransaction.commit();		
    }

    /** Called when the activity will start interacting with the user. */
    @Override
    public void onResume() {
        super.onPause();
        // Log.i(this.getLocalClassName(), "onResume()");
    }

    /** Called when the system is about to start resuming a previous activity. */
    @Override
    public void onPause() {
        super.onPause();
        // Log.i(this.getLocalClassName(), "onPause()");
    }

    /** Called when the activity is no longer visible to the user, because another activity has been resumed and is covering this one. */
    @Override
    public void onStop() {
        super.onPause();
        // Log.i(this.getLocalClassName(), "onStop()");
    }

    /** The final call you receive before your activity is destroyed. */
    @Override
    public void onDestroy() {
        super.onDestroy();
        // Log.i(this.getLocalClassName(), "onDestroy()");
    }
    
}
