package com.example.cliffhorwood.gedcomanalysis;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.res.Configuration;
import android.os.Bundle;
import android.util.Log;

public class ShowEventDataActivity extends Activity {
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.e(this.getLocalClassName(), "onCreate()");
        setContentView(R.layout.list_details);
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
			Bundle extras = getIntent().getExtras();
			final String parentactivity = extras.getString("parentactivity");
			final String fname          = extras.getString("fname");
			final String iname          = extras.getString("iname");
			final String indvtype       = extras.getString("indvtype");
			final String surname        = extras.getString("surname");
			final String family         = extras.getString("family");
			final String familytype     = extras.getString("familytype");
			
			/** if (parentactivity.equals("ListIndv")) {				
				ListIndvFragment myFragment = new ListIndvFragment();							
				fragmentTransaction.replace(R.id.listsummfragment, myFragment);
				// fragmentTransaction.addToBackStack(null);
				fragmentTransaction.commit();						
			}
			else 
			**/
			if (parentactivity.equals("ListIndv3")) {				
				ListIndv3Fragment myFragment = new ListIndv3Fragment();								
				fragmentTransaction.replace(R.id.listsummfragment, myFragment);
				// fragmentTransaction.addToBackStack(null);
				fragmentTransaction.commit();						
			}
			else if (parentactivity.equals("ShowIndvDetl1")) {				
				// ShowIndvDetl1Fragment myFragment = new ShowIndvDetl1Fragment();										
				// special case - we want the grandparent not the parent
				ListIndv3Fragment myFragment = new ListIndv3Fragment();	
				fragmentTransaction.replace(R.id.listsummfragment, myFragment);
				// fragmentTransaction.addToBackStack(null);
				fragmentTransaction.commit();						
			}
			else if (parentactivity.equals("ShowIndvDetl2")) {				
				// ShowIndvDetl1Fragment myFragment = new ShowIndvDetl1Fragment();										
				// special case - we want the grandparent not the parent
				ListIndv3Fragment myFragment = new ListIndv3Fragment();	
				fragmentTransaction.replace(R.id.listsummfragment, myFragment);
				// fragmentTransaction.addToBackStack(null);
				fragmentTransaction.commit();						
			}
			else {	
				/**
				ListIndvFragment myFragment = new ListIndvFragment();								
				fragmentTransaction.replace(R.id.listsummfragment, myFragment);
				// fragmentTransaction.addToBackStack(null);
				fragmentTransaction.commit();
				**/						
			}
						
		}
		
        // Get an instance of FragmentTransaction for the Activity
		FragmentManager fragmentManager = getFragmentManager();
		FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

		// Add a fragment				
		// ShowIndvDetlFragment myFragment = new ShowIndvDetlFragment();
		ShowEventDataFragment myFragment = new ShowEventDataFragment();
		fragmentTransaction.replace(R.id.listdetlfragment, myFragment);
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
