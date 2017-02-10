package com.example.cliffhorwood.gedcomanalysis;

import com.example.cliffhorwood.gedcomanalysis.Classes.*;

import android.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class GetIndividualDetailsUsingNameFragment extends Fragment {

    private String sFragmentName = this.getClass().getSimpleName();

    public GetIndividualDetailsUsingNameFragment() {
        // Required empty public constructor
    }


    /** Called to do initial creation of the fragment. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i(sFragmentName, "onCreate()");

        Bundle extras = getActivity().getIntent().getExtras();

        String fname = extras.getString("fname");
        String iname = extras.getString("iname");
        String indi_id = extras.getString("indi");
        String indvtype = extras.getString("indvtype");

        /**
        Log.i(sFragmentName, "onCreate() - fname: " + fname);
        Log.i(sFragmentName, "onCreate() - iname: " + iname);
        Log.i(sFragmentName, "onCreate() - indi: " + indi_id);
        Log.i(sFragmentName, "onCreate() - indvtype: " + indvtype);
        **/

        String sFullName = iname;
        int poscomma = iname.indexOf(",");
        String formattediname = iname.substring(poscomma + 2, iname.length());			// given names
        formattediname = formattediname + " /" + iname.substring(0, poscomma) + "/";

        /**
        Log.i(sFragmentName, "onCreate() - formattediname: " + formattediname);
        Log.i(sFragmentName, "onCreate() - sFullName: "      + sFullName);
        **/

        String str;

        List newList  = new LinkedList();
        newList       = new ArrayList();

        List IndvList = new LinkedList();
        IndvList      = new ArrayList();

        MyMethods myMethods = new MyMethods();
        newList = myMethods.LoadTextFileToArray((ArrayList<String>) newList, fname);

        // Loop forward through the array until you find the formatted name

        int i = 0;

        while ( i < newList.size() ) {
            str = (String) newList.get(i);
            if ( !str.equals("1 NAME " + formattediname) ) {
                i++;
            }
            else {
                /**
                Log.i(sFragmentName, "Found the formatted name");
                Log.i(sFragmentName, str);
                **/
                break;
            }
        }

        // Go backwards in the array to the start of the individual or FILE_head (beginning of file)

        i--;

        while ( i < newList.size() ) {
            str = (String) newList.get(i);
            if ( !str.startsWith(getResources().getString(R.string.sINDI_start)) )  {
                i--;
            }
            else {
                IndvList.add(str);
                /**
                Log.i(sFragmentName, "Found the individual start");
                Log.i(sFragmentName, str);
                 **/
                break;
            }
        }

        // Loop forward through the array until the end of the individual - INDI_start, SOUR_start, FAM_start, NOTE_start or FILE_trlr (ie EOF) - break the loop
        // Display the individual's detail lines

        i++;

        while ( i < newList.size() )  {
            str = (String) newList.get(i);
            if ( !str.startsWith(getResources().getString(R.string.sINDI_start)) &&
                    !str.startsWith(getResources().getString(R.string.sSOUR_start)) &&
                    !str.startsWith(getResources().getString(R.string.sFAM_start)) &&
                    //!str.startsWith(getResources().getString(R.string.sNOTE_start)) &&
                    !str.startsWith(getResources().getString(R.string.sFILE_trlr)) ) {
                IndvList.add(str);
                // Log.i(sFragmentName, str);

                i++;

            }
            else break;
        }

        // Check the IndvList contents

        int z = 0;

        while ( z < IndvList.size() ) {
            str = (String) IndvList.get(z);
            Log.i(sFragmentName, str);
            z++;
        }
    }

    /** Creates and returns the view hierarchy associated with the fragment. */
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        TextView textView = new TextView(getActivity());
        textView.setText(R.string.hello_blank_fragment);
        return textView;
    }

    /** Called once the fragment is associated with its activity. **/
    public void onAttach() {
        super.onAttach(getActivity());
        Log.i(sFragmentName, "onAttach()");
    }

    /**  Tells the fragment that its activity has completed its own Activity.onCreate() */
    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Log.i(sFragmentName, "onActivityCreated()");
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
