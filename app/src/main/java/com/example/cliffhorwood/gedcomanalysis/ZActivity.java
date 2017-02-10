package com.example.cliffhorwood.gedcomanalysis;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

public class ZActivity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.e(this.getLocalClassName(), "onCreate()");        
        setContentView(R.layout.zmain);
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