package com.example.cliffhorwood.gedcomanalysis;

import android.Manifest;
import android.app.ListFragment;
import android.app.ProgressDialog;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.view.View;
import android.widget.ListView;

import com.example.cliffhorwood.gedcomanalysis.Classes.MyMethods;
import com.example.cliffhorwood.gedcomanalysis.Classes.gedFilter;
import com.example.cliffhorwood.gedcomanalysis.Classes.FileChooser;

import java.io.File;
import java.util.ArrayList;

import org.json.JSONException;

public class ListFilesLocalFragment extends ListFragment{

	private String sFragmentName = this.getClass().getSimpleName();
		
	private MyMethods myMethods = new MyMethods();
	private String sExtStorageDirectory = myMethods.extStorageDir();
	private String[] sdCard;	
	
	// protected InitTaskListFilesLocal _inittasklistfileslocal;
	ProgressDialog progressDialog;
	private int PERMISSION_REQUEST_CODE;

	/** Called once the fragment is associated with its activity.  **/
	public void onAttach() {
		super.onAttach(getActivity());
		Log.i(sFragmentName, "onAttach()");
	}
	
	/** Called to do initial creation of the fragment. **/
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		Log.i(sFragmentName, "onCreate()");
	}

	/** Creates and returns the view hierarchy associated with the fragment.
	@Override
	public View onCreateView (LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		Log.i("ListFilesLocalFragment", "onCreateView()");
		View myFragmentView = inflater.inflate(R.layout.listfilesfragment, container, false);		  
		return myFragmentView;
	}
	 **/

	/**  Tells the fragment that its activity has completed its own Activity.onCreate() **/
	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		Log.i(sFragmentName, "onActivityCreated()");
		
		// Kick off the background task
		// _inittasklistfileslocal = new InitTaskListFilesLocal();
        // _inittasklistfileslocal.execute( getActivity() );

	}
	
    /** sub-class of AsyncTask
    protected class InitTaskListFilesLocal extends AsyncTask<Context, Integer, String> {
        // -- run intensive processes here
        // -- first param datatype in the class definition matches the param passed to this method 
        // -- last param datatype  in the class definition matches the return type of this method
		 
		@Override
		protected String doInBackground( Context... params ) {
			Log.i(sFragmentName, "doInBackground()");

			int permissionCheck = ContextCompat.checkSelfPermission(getActivity(), Manifest.permission.READ_EXTERNAL_STORAGE);
			if (permissionCheck != PackageManager.PERMISSION_GRANTED) {
				ActivityCompat.requestPermissions(getActivity(), new String[]{Manifest.permission.READ_EXTERNAL_STORAGE}, PERMISSION_REQUEST_CODE);
			} else {
				// Your app already has the permission to access files and folders
				// so you can simply open FileChooser here.
                //	Do the non-UI part of the fragment. Get data etc.
                try {
                    ArrayList<String> sdCardList = getDirectoryListing( new File(sExtStorageDirectory), "" );
                    Log.i( sFragmentName, "doInBackground(): sExtStorageDirectory: " + sExtStorageDirectory );
                    Log.i( sFragmentName, "doInBackground(): sdCardList.size before sort: " + sdCardList.size() );

                    Collections.sort(sdCardList);
                    int index = Collections.binarySearch(sdCardList, "sdcard");
                    if (index > 0) {
                        sdCardList.remove(index);
                    }
                    sdCard = sdCardList.toArray(new String[sdCardList.size()]);
                    Log.i( sFragmentName, "doInBackground(): sdCardList.size after sort: " + sdCardList.size() );
                }
                catch( Exception error ) {
                    Log.e( sFragmentName, "doInBackground(): " + error.toString() );
                }

			}
            return "1";		// OK

		}

		// -- gets called just before thread begins
		@Override
		protected void onPreExecute() {
			super.onPreExecute();  
			Log.i(sFragmentName, "onPreExecute()");
			
			progressDialog = new ProgressDialog( getActivity() );
			progressDialog.setCancelable(true);
			progressDialog.setMessage(getResources().getString(R.string.loading2));
			progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
		}

		// -- called from the publish progress 
		// -- notice that the datatype of the second param gets passed to this method
		@Override
		protected void onProgressUpdate(Integer... values) {
			super.onProgressUpdate(values);
			Log.i(sFragmentName, "onProgressUpdate(): " +  String.valueOf( values[0] ) );
		}

		// -- called if the cancel button is pressed
		@Override
		protected void onCancelled() {
			super.onCancelled();
			Log.i(sFragmentName, "onCancelled()");
			
			progressDialog.dismiss();											
		}

		// -- called as soon as doInBackground method completes
		// -- notice that the third param gets passed to this method
		@Override
		protected void onPostExecute( String result ) {
			super.onPostExecute(result);
			Log.i(sFragmentName, "onPostExecute()");
			
			progressDialog.dismiss();			
			String sParentActivity = getActivity().getLocalClassName();   
			String sActivityName   = sFragmentName.replace("Fragment","Activity");			

			if (sParentActivity.equals(sActivityName)) {
				ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, sdCard);
				setListAdapter(adapter);	
			}
			else {
				ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(), R.layout.my_simple_list_item_1, sdCard);
				setListAdapter(adapter);
			}			
		}
	}
        **/

	@Override
	public void onListItemClick(ListView l, View v, int position, long id) {
		// Log.i(sFragmentName, "onListItemClick()");

		String item = (String) getListAdapter().getItem(position);
		Intent intent = new Intent();
		intent.setClass(getActivity(), ListSummActivity.class);
		intent.putExtra("fname", item);
		startActivity(intent);	    
	}

	/** Makes the fragment visible to the user (based on its containing activity being started). **/
	@Override
	public void onStart() {
		super.onStart();
		Log.i(sFragmentName, "onStart()");

		int permissionCheck = ContextCompat.checkSelfPermission(getActivity(), Manifest.permission.READ_EXTERNAL_STORAGE);

		if (permissionCheck != PackageManager.PERMISSION_GRANTED) {
			ActivityCompat.requestPermissions(getActivity(), new String[]{Manifest.permission.READ_EXTERNAL_STORAGE}, PERMISSION_REQUEST_CODE);
		} else {
            // Your app already has the permission to access files and folders
            // so you can simply open FileChooser here.

            new FileChooser(getActivity()).setFileListener(new FileChooser.FileSelectedListener() {
                @Override
                public void fileSelected(final File file) {
                    // do something with the file
                    Intent intent = new Intent();
                    intent.setClass(getActivity(), ListSummActivity.class);
                    intent.putExtra("fname", file.getPath());
                    startActivity(intent);
                }
            }).showDialog();
        }

        //    return "1";		// OK

    }

	/** Makes the fragment interacting with the user (based on its containing activity being resumed).  **/
	@Override
	public void onResume() {
		super.onResume();
		Log.i(sFragmentName, "onResume()");
	}

	/**
	 * Gets the Directory listing for file, in JSON format
	 * @param file The file for which we want to do directory listing
	 * @return ArrayList<String> representation of directory list.
	 *  e.g {"filename":"/sdcard","isdir":true,"children":[{"filename":"a.txt","isdir":false},{..}]}
	 * @throws JSONException
	 */
	private ArrayList<String> getDirectoryListing(File file, String prefix) throws JSONException {
		ArrayList<String> fileInfo = new ArrayList<String>();

		try {
			fileInfo.add(prefix + file.getName());
			if (file.isDirectory()) {
				if (null != file.listFiles(new gedFilter())) {
					for (File child : file.listFiles(new gedFilter())) {
						fileInfo.addAll(getDirectoryListing(child, prefix + ""));
					}
				}
			}
		}
		catch( Exception error ) {
			Log.e(sFragmentName, "getDirectoryListing(): " + error.toString());
		}		
		return fileInfo;		
	}	

	/** Fragment is no longer interacting with the user either because its activity is being paused or a fragment operation is modifying it in the activity.  **/
	@Override
	public void onPause() {
		super.onPause();
		Log.i(sFragmentName, "onPause()");
	}	 

	/** Fragment is no longer visible to the user either because its activity is being stopped or a fragment operation is modifying it in the activity. **/
	@Override
	public void onStop() {
		super.onStop();
		Log.i(sFragmentName, "onStop()");
	}
	 
	/** Allows the fragment to clean up resources associated with its View.  **/
	@Override
	public void onDestroyView() {
		super.onDestroyView();
		Log.i(sFragmentName, "onDestroyView()");
	}
	
	/** Called to do final cleanup of the fragment's state. **/
	@Override
	public void onDestroy() {
		super.onDestroy();
		Log.i(sFragmentName, "onDestroy()");
	}	 

	/** Called immediately prior to the fragment no longer being associated with its activity.  **/  
	@Override
	public void onDetach() {
		super.onDetach();
		Log.i(sFragmentName, "onDetach()");
	}

}
