package com.example.cliffhorwood.gedcomanalysis;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.widget.TextView;

public class ShowSettingsActivity extends Activity {

 @Override
 protected void onCreate(Bundle savedInstanceState) {

  super.onCreate(savedInstanceState);
  setContentView(R.layout.show_settings_layout);

  SharedPreferences sharedPrefs = PreferenceManager.getDefaultSharedPreferences(this);

  StringBuilder builder = new StringBuilder();

  builder.append("\n" + sharedPrefs.getBoolean("perform_updates", false));
  builder.append("\n" + sharedPrefs.getString("updates_interval", "-1"));
  builder.append("\n" + sharedPrefs.getString("welcome_message", "NULL"));

  TextView settingsTextView = (TextView) findViewById(R.id.settings_text_view);
  settingsTextView.setText(builder.toString());

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

