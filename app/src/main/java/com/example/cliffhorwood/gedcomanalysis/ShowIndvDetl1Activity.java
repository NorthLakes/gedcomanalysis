package com.example.cliffhorwood.gedcomanalysis;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.res.Configuration;
import android.os.Bundle;
import android.util.Log;

public class ShowIndvDetl1Activity extends Activity 
implements ShowIndvDetl1Fragment.onNumbersOfIndividualListener {

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		Log.i(this.getLocalClassName(), "onCreate()");
		setContentView(R.layout.list_details);
	}

	/** Called after your activity has been stopped, prior to it being started again.*/
	@Override
	public void onRestart() {
		super.onPause();
		Log.i(this.getLocalClassName(), "onRestart()");
	}

	/** Called when the activity is becoming visible to the user. */
	@Override
	public void onStart() {
		super.onStart();
		Log.i(this.getLocalClassName(), "onStart()");

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

             /**

            final String parentactivity = "ListIndv3Fragment";
            final String fname          = "/storage/emulated/0/Download/Horwood family tree.ged";
            final String iname          = "Horwood, Jessica Elise";
            final String indvtype       = "christ";
            final String surname        = "surname";
            final String family         = "family";
            final String familytype     = "familytype";

              **/

            Log.i(this.getLocalClassName(), "parentactivity: " + parentactivity);
            Log.i(this.getLocalClassName(), "fname: " + fname);
            Log.i(this.getLocalClassName(), "iname: " + iname);
            Log.i(this.getLocalClassName(), "indvtype: " + indvtype);
            Log.i(this.getLocalClassName(), "surname: " + surname);
            Log.i(this.getLocalClassName(), "family: " + family);
            Log.i(this.getLocalClassName(), "familytype: " + familytype);

			/** if (parentactivity.equals("ListIndvFragment")) {				
				ListIndvFragment myFragment = new ListIndvFragment();							
				fragmentTransaction.replace(R.id.listsummfragment, myFragment);
				// fragmentTransaction.addToBackStack(null);
				fragmentTransaction.commit();						
			}
			else 
			**/
			if (parentactivity.equals("ListIndv3Fragment")) {				
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
		ShowIndvDetl1Fragment myFragment = new ShowIndvDetl1Fragment();		
		fragmentTransaction.add(myFragment, "Frag01");
		// fragmentTransaction.replace(R.id.listdetlfragment, myFragment);
		// fragmentTransaction.addToBackStack(null);
		fragmentTransaction.commit();			
	}

	public void onNumbersOfIndividual(int iCtr) {
		if (iCtr == 0) {
			
			// Not valid. We should not be here.
			Log.i(this.getLocalClassName(), "There are no individuals. Not valid. We should NOT be here.: " + iCtr);
			
		}
		else if (iCtr == 1) {

			// There is only a single individual.  There is no need to display the candidates for the user to select one.

            // Get an instance of FragmentTransaction for the Activity
            FragmentManager fragmentManager = getFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

            // Add a fragment
            GetIndividualDetailsUsingNameFragment myFragment = new GetIndividualDetailsUsingNameFragment();
            fragmentTransaction.replace(R.id.listdetlfragment, myFragment);
            // fragmentTransaction.addToBackStack(null);
            fragmentTransaction.commit();

            /**
			// Instead go straight to the show individual details.
			Log.i(this.getLocalClassName(), "There is only a single individual: " + iCtr);

			// Get an instance of FragmentTransaction for the Activity
			FragmentManager fragmentManager = getFragmentManager();
			FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

			// Add a fragment				
			ShowIndvDetl3aFragment myFragment = new ShowIndvDetl3aFragment();	
			fragmentTransaction.replace(R.id.listdetlfragment, myFragment);
			// fragmentTransaction.addToBackStack(null);
			fragmentTransaction.commit();
             **/

		}
		else if (iCtr > 1) {

			// There is more than one individual.  Display the candidates for the user to select one.
			Log.i(this.getLocalClassName(), "There is more than one individual: " + iCtr);

			// Get an instance of FragmentTransaction for the Activity
			FragmentManager fragmentManager = getFragmentManager();
			FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

			// Add a fragment				
			ShowIndvDetl2Fragment myFragment = new ShowIndvDetl2Fragment();		
			// fragmentTransaction.add(myFragment, "Frag01");
			fragmentTransaction.replace(R.id.listdetlfragment, myFragment);
			// fragmentTransaction.addToBackStack(null);
			fragmentTransaction.commit();	

		}

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
