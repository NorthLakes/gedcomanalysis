package com.example.cliffhorwood.gedcomanalysis;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.res.Configuration;
import android.os.Bundle;
import android.util.Log;

public class GetIndividualDetailsUsingIDActivity extends Activity {

    String sFullName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
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

            Log.i(this.getLocalClassName(), "parentactivity: " + parentactivity);
            Log.i(this.getLocalClassName(), "fname: " + fname);
            Log.i(this.getLocalClassName(), "iname: " + iname);
            Log.i(this.getLocalClassName(), "indvtype: " + indvtype);
            Log.i(this.getLocalClassName(), "surname: " + surname);
            Log.i(this.getLocalClassName(), "family: " + family);
            Log.i(this.getLocalClassName(), "familytype: " + familytype);

            if (parentactivity.equals("ListIndv3")) {
                ListIndv3Fragment myFragment = new ListIndv3Fragment();
                fragmentTransaction.replace(R.id.listsummfragment, myFragment);
                // fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
            }
            else if (parentactivity.equals("ShowIndvDetl1")) {
                ListIndv3Fragment myFragment = new ListIndv3Fragment();
                fragmentTransaction.replace(R.id.listsummfragment, myFragment);
                // fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
            }
            else if (parentactivity.equals("ShowIndvDetl2")) {
                ListIndv3Fragment myFragment = new ListIndv3Fragment();
                fragmentTransaction.replace(R.id.listsummfragment, myFragment);
                // fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
            }
            else {
                // do nothing
            }

        }

        // Get an instance of FragmentTransaction for the Activity
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        // Add a fragment
        GetIndividualDetailsUsingIDFragment myFragment = new GetIndividualDetailsUsingIDFragment();
        fragmentTransaction.replace(R.id.listdetlfragment, myFragment);
        // fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }

    /** Called when the activity will start interacting with the user. */
    @Override
    public void onResume() {
        super.onPause();
        Log.i(this.getLocalClassName(), "onResume()");
    }

    /** Called when the system is about to start resuming a previous activity. */
    @Override
    public void onPause() {
        super.onPause();
        Log.i(this.getLocalClassName(), "onPause()");
    }

    /** Called when the activity is no longer visible to the user, because another activity has been resumed and is covering this one. */
    @Override
    public void onStop() {
        super.onPause();
        Log.i(this.getLocalClassName(), "onStop()");
    }

    /** The final call you receive before your activity is destroyed. */
    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.i(this.getLocalClassName(), "onDestroy()");
    }

}
