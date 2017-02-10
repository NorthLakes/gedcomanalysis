package com.example.cliffhorwood.gedcomanalysis;

import android.app.ListFragment;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.cliffhorwood.gedcomanalysis.Classes.MyMethods;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;


public class ListSummFragment extends ListFragment{

	private String sFragmentName = this.getClass().getSimpleName();

	private MyMethods myMethods = new MyMethods();
	private String sExtStorageDirectory = myMethods.extStorageDir();
	// private String[] simpleArray;
	
	// private List DISPlist = new LinkedList();
	private List DISPlist = new ArrayList();
	
	protected InitTaskListSumm _inittasklistsumm;	
	ProgressDialog progressDialog;		

	/** Called once the fragment is associated with its activity.  **/
	public void onAttach() {
		super.onAttach(getActivity());
		// Log.i(sFragmentName, "onAttach()");
	}

	/** Called to do initial creation of the fragment. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		// Log.i(sFragmentName, "onCreate()");
	}

	/** Creates and returns the view hierarchy associated with the fragment.
	@Override
	public View onCreateView (LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		Log.i("ListFilesLocalFragment", "onCreateView()");
		View myFragmentView = inflater.inflate(R.layout.listfilesfragment, container, false);		  
		return myFragmentView;
	}
	 **/

	/**  Tells the fragment that its activity has completed its own Activity.onCreate() */
	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		// Log.i(sFragmentName, "onActivityCreated()");

		// Kick off the background task
		_inittasklistsumm = new InitTaskListSumm();
        _inittasklistsumm.execute( getActivity() );	
	}
	
    /** sub-class of AsyncTask **/
    protected class InitTaskListSumm extends AsyncTask<Context, Integer, String> {
        // -- run intensive processes here
        // -- first param datatype in the class definition matches the param passed to this method 
        // -- last param datatype  in the class definition matches the return type of this method
		 
		@Override
		protected String doInBackground( Context... params ) {
			// Log.i(sFragmentName, "doInBackground()");
			
			/**	Do the non-UI part of the fragment. Get data etc. **/
			try {
				String str;
				int numINDI = 0;
				int numFAM  = 0;
				int numSOUR = 0;
				int numNOTE = 0;

				Bundle extras = getActivity().getIntent().getExtras();
				String fname = extras.getString("fname");
				// File fname = extras.getString("fname");
				// Log.i( sFragmentName, "doInBackground(): fname: " + fname );

				String sFullyQualFileName = sExtStorageDirectory + fname;
				// Log.i( sFragmentName, "doInBackground(): sFullyQualFileName: " + sFullyQualFileName );

				/**
				List DISPlist = new LinkedList();
				DISPlist      = new ArrayList();
				**/
				
				List newList  = new LinkedList();
				newList       = new ArrayList();

				// newList = myMethods.LoadTextFileToArray((ArrayList<String>) newList, sFullyQualFileName);
				newList = myMethods.LoadTextFileToArray((ArrayList<String>) newList, fname);
				// newList = myMethods.LoadTextFileToArray2((ArrayList<String>) newList, fname);

				// Log.i( sFragmentName, "doInBackground(): newList.size: " + newList.size() );
				 
				int i = 0;
				while (i < newList.size()) {

					str = (String) newList.get(i);
                    if ((str.startsWith(getResources().getString(R.string.sINDI_start))) && (str.endsWith(getResources().getString(R.string.sINDI_end)))) {
						numINDI = numINDI + 1;
                        // Log.i(sFragmentName, "doInBackground(): INDI: " + str);
					}   
					else if ((str.startsWith(getResources().getString(R.string.sFAM_start))) && (str.endsWith(getResources().getString(R.string.sFAM_end)))) {
						numFAM = numFAM + 1;
					}
					else if ((str.startsWith(getResources().getString(R.string.sSOUR_start))) && (str.endsWith(getResources().getString(R.string.sSOUR_end)))) {
						numSOUR = numSOUR + 1;
					}   
					else if (str.startsWith(getResources().getString(R.string.sNOTE_start))) {
						numNOTE = numNOTE + 1;
                        // Log.i(sFragmentName, "doInBackground(): NOTE: " + str);
					}
                    // else {
                        // if (i < 100) {
                        //     Log.i(sFragmentName, "doInBackground(): inside loop: str: ###" + str + "###");
                        // }
                    // }
					i++;
				}
				
				// Log.i( sFragmentName, "doInBackground(): end of loop " );

				/**
				DISPlist.add("Individuals - Analysis");
				DISPlist.add("Families - Analysis");
				 **/
				DISPlist.add("Individuals : " + numINDI);
				DISPlist.add("Families    : " + numFAM);
				DISPlist.add("Sources     : " + numSOUR);
				DISPlist.add("Notes       : " + numNOTE);
				DISPlist.add("File - Details");

				/**
				Log.i( sFragmentName, "doInBackground(): DISPlist.size: " + DISPlist.size() );
				Log.i( sFragmentName, "doInBackground(): numINDI:       " + numINDI );
				Log.i( sFragmentName, "doInBackground(): numFAM:        " + numFAM );
				Log.i( sFragmentName, "doInBackground(): numSOUR:       " + numSOUR );
				Log.i( sFragmentName, "doInBackground(): numNOTE:       " + numNOTE );
                 **/

				/**
				simpleArray = new String[ DISPlist.size() ];
				DISPlist.toArray( simpleArray );
				**/
			}
			catch( Exception error ) {
				Log.e( sFragmentName, "doInBackground(): " + "Error: " + error.toString() );
			}			
			return "1";		// OK
		}

		// -- gets called just before thread begins
		@Override
		protected void onPreExecute() {
			super.onPreExecute();  
			// Log.i(sFragmentName, "onPreExecute()");
			
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
			// Log.i(sFragmentName, "onProgressUpdate(): " +  String.valueOf( values[0] ) );
		}

		// -- called if the cancel button is pressed
		@Override
		protected void onCancelled() {
			super.onCancelled();
			// Log.i(sFragmentName, "onCancelled()");
			progressDialog.dismiss();											
		}

		// -- called as soon as doInBackground method completes
		// -- notice that the third param gets passed to this method
		@Override
		protected void onPostExecute( String result ) {
			super.onPostExecute(result);
			// Log.i(sFragmentName, "onPostExecute()");
			
			progressDialog.dismiss();

			// Log.i( sFragmentName, "onPostExecute(): DISPlist.size: " + DISPlist.size() );
			String[] simpleArray = new String[ DISPlist.size() ];
			DISPlist.toArray( simpleArray );
			
			String sParentActivity = getActivity().getLocalClassName();   
			String sActivityName   = sFragmentName.replace("Fragment","Activity");
			
			if (sParentActivity.equals(sActivityName)) {
				ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, simpleArray);
				setListAdapter(adapter);	
			}
			else {
				ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(), R.layout.my_simple_list_item_1, simpleArray);
				setListAdapter(adapter);
			}
		}
	}	
	
	@Override
	public void onListItemClick(ListView l, View v, int position, long id) {

		String item = (String) getListAdapter().getItem(position);
		Bundle extras = getActivity().getIntent().getExtras();
		String fname = extras.getString("fname");

		if (item.startsWith("Individuals")) {
			Intent intent = new Intent();
			intent.setClass(getActivity(), ListIndvAnalysisSummActivity.class);
			intent.putExtra("fname", fname);
			startActivity(intent);	    
		}
		else if (item.startsWith("Families")) {
			Intent intent = new Intent();
			intent.setClass(getActivity(), ListFamlAnalysisActivity.class);
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
		else if (item.startsWith("File")) {
			Intent intent = new Intent();
			intent.setClass(getActivity(), ShowDetlActivity.class);
			intent.putExtra("fname", fname);
			startActivity(intent);	    
		}
		else {
			Intent intent = new Intent();
			intent.setClass(getActivity(), ZActivity.class);
			intent.putExtra("fname", fname);
			startActivity(intent);	    
		}
	}

	/** Makes the fragment visible to the user (based on its containing activity being started). **/
	@Override
	public void onStart() {
		super.onStart();
		// Log.i(sFragmentName, "onStart()");
	}

	/** Makes the fragment interacting with the user (based on its containing activity being resumed).  **/
	@Override
	public void onResume() {
		super.onResume();
		// Log.i(sFragmentName, "onResume()");
	}

	/**	As a fragment is no longer being used, it goes through a reverse series of callbacks:
	onPause() onStop() onDestroyView() onDestroy() onDetach() **/

	/** Fragment is no longer interacting with the user either because its activity is being paused or a fragment operation is modifying it in the activity.  **/
	@Override
	public void onPause() {
		super.onPause();
		// Log.i(sFragmentName, "onPause()");
	}	 

	/** Fragment is no longer visible to the user either because its activity is being stopped or a fragment operation is modifying it in the activity. **/
	@Override
	public void onStop() {
		super.onStop();
		// Log.i(sFragmentName, "onStop()");
	}
 
	/** Allows the fragment to clean up resources associated with its View.  **/
	@Override
	public void onDestroyView() {
		super.onDestroyView();
		// Log.i(sFragmentName, "onDestroyView()");
}	

	/** Called to do final cleanup of the fragment's state. **/
	@Override
	public void onDestroy() {
		super.onDestroy();
		// Log.i(sFragmentName, "onDestroy()");
	}	 

	/** Called immediately prior to the fragment no longer being associated with its activity.  **/  
	@Override
	public void onDetach() {
		super.onDetach();
		// Log.i(sFragmentName, "onDetach()");
	}

}
