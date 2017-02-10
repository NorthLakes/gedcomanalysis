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
public class GetIndividualDetailsUsingIDFragment extends Fragment {

    private String sFragmentName = this.getClass().getSimpleName();
    private String sFullName;

    public GetIndividualDetailsUsingIDFragment() {
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

        Log.i(sFragmentName, "onCreate() - fname: " + fname);
        Log.i(sFragmentName, "onCreate() - iname: " + iname);
        Log.i(sFragmentName, "onCreate() - indi: " + indi_id);
        Log.i(sFragmentName, "onCreate() - indvtype: " + indvtype);
        sFullName = iname;
        int poscomma = iname.indexOf(",");
        String formattediname = iname.substring(poscomma + 2, iname.length());			// given names
        formattediname = formattediname + " /" + iname.substring(0, poscomma) + "/";

        Log.i(sFragmentName, "onCreate() - formattediname: " + formattediname);
        Log.i(sFragmentName, "onCreate() - sFullName: "      + sFullName);
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
