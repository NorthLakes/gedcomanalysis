package com.example.cliffhorwood.gedcomanalysis;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.res.Configuration;
import android.os.Bundle;
import android.util.Log;

public class ListFamlTypeActivity extends Activity {
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.e(this.getLocalClassName(), "onCreate()");
        setContentView(R.layout.list_view);
    }

    /** Called when the activity is becoming visible to the user. */
    @Override
    public void onStart() {
        super.onStart();
        Log.e(this.getLocalClassName(), "onStart()");        
        
		// Need to check if Activity is in landscape mode. If yes, display fragments
        boolean mDualPane = false;
		if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {
		  	mDualPane = true;
		}

		if (mDualPane) {
			
	        // Get an instance of FragmentTransaction for the Activity
			FragmentManager fragmentManager = getFragmentManager();
			FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

			// Add a fragment
			ListFamlAnalysisFragment myFragment = new ListFamlAnalysisFragment();
			fragmentTransaction.replace(R.id.listsummfragment, myFragment);
			// fragmentTransaction.addToBackStack(null);
			fragmentTransaction.commit();		
		}
		
        // Get an instance of FragmentTransaction for the Activity
		FragmentManager fragmentManager = getFragmentManager();
		FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

		// Add a fragment
		ListFamlTypeFragment myFragment = new ListFamlTypeFragment();
		fragmentTransaction.replace(R.id.listviewfragment, myFragment);
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

