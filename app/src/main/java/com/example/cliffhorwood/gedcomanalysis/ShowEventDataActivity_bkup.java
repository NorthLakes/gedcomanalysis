package com.example.cliffhorwood.gedcomanalysis;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import com.example.cliffhorwood.gedcomanalysis.R;
import com.example.cliffhorwood.gedcomanalysis.Adapter.ExpandListAdapter;
import com.example.cliffhorwood.gedcomanalysis.Classes.*;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ExpandableListView;


public class ShowEventDataActivity_bkup extends Activity {
	/** Called when the activity is first created. */
	private ExpandListAdapter ExpAdapter;
	private ArrayList<ExpandListGroup> ExpListItems;
	private ExpandableListView ExpandList;
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main_expandlistview);
		ExpandList = (ExpandableListView) findViewById(R.id.ExpList);
		ExpListItems = SetStandardGroups();
		ExpAdapter = new ExpandListAdapter(this, ExpListItems);
		ExpandList.setAdapter(ExpAdapter);
	}

	public ArrayList<ExpandListGroup> SetStandardGroups() {

		ArrayList<ExpandListGroup> list = new ArrayList<ExpandListGroup>();
		ArrayList<ExpandListChild> list2 = new ArrayList<ExpandListChild>();

		int i;	
		int iGroup = 0;
		int iMax;
		String sSetName;
		String sChildName;	

		List INDIVIDUALList = new LinkedList();
		INDIVIDUALList      = new ArrayList();	

		INDIVIDUALList.add("Individual");		
		INDIVIDUALList.add("Full name: ");
		INDIVIDUALList.add("Given names: ");
		INDIVIDUALList.add("Surname: ");
		INDIVIDUALList.add("Also known as: ");
		INDIVIDUALList.add("Sex: ");

		// individual

		list2 = new ArrayList<ExpandListChild>();

		iGroup++;		
		ExpandListGroup gru_01 = new ExpandListGroup();
		sSetName = (String) INDIVIDUALList.get(0);
		gru_01.setName(sSetName);
		iMax = INDIVIDUALList.size();				
		i = 1;				
		while (i < iMax) {			
			ExpandListChild ch_01_i = new ExpandListChild();				
			sChildName = (String) INDIVIDUALList.get(i);
			ch_01_i.setName(sChildName);
			ch_01_i.setTag(null);
			list2.add(ch_01_i);
			i++;
		}				
		gru_01.setItems(list2);


		List EVENTList = new LinkedList();
		EVENTList      = new ArrayList();

		EVENTList.add("Date: ");
		EVENTList.add("Place: ");
		EVENTList.add("Map: Lat: Long: ");
		EVENTList.add("Address: ");
		EVENTList.add("City: ");
		EVENTList.add("State: ");
		EVENTList.add("Post code: ");
		EVENTList.add("Country: ");		

		// baptism

		List BAPTISMList = new LinkedList();
		BAPTISMList      = new ArrayList();

		BAPTISMList.add("Event - baptism");
		BAPTISMList.addAll(EVENTList);

		list2 = new ArrayList<ExpandListChild>();

		iGroup++;		
		ExpandListGroup gru_02 = new ExpandListGroup();
		sSetName = (String) BAPTISMList.get(0);
		gru_02.setName(sSetName);
		iMax = BAPTISMList.size();				
		i = 1;				
		while (i < iMax) {			
			ExpandListChild ch_02_i = new ExpandListChild();				
			sChildName = (String) BAPTISMList.get(i);
			ch_02_i.setName(sChildName);
			ch_02_i.setTag(null);
			list2.add(ch_02_i);
			i++;
		}				
		gru_02.setItems(list2);

		// birth

		List BIRTHList = new LinkedList();
		BIRTHList      = new ArrayList();

		BIRTHList.add("Event - birth");
		BIRTHList.addAll(EVENTList);

		list2 = new ArrayList<ExpandListChild>();

		iGroup++;
		ExpandListGroup gru_04 = new ExpandListGroup();
		sSetName = (String) BIRTHList.get(0);
		gru_04.setName(sSetName);
		iMax = BIRTHList.size();
		i = 1;
		while (i < iMax) {		
			ExpandListChild ch_04_i = new ExpandListChild();	
			sChildName = (String) BIRTHList.get(i);
			ch_04_i.setName(sChildName);
			ch_04_i.setTag(null);
			list2.add(ch_04_i);
			i++;
		}
		gru_04.setItems(list2);

		// burial

		List BURIALList = new LinkedList();
		BURIALList      = new ArrayList();

		BURIALList.add("Event - burial");
		BURIALList.addAll(EVENTList);

		list2 = new ArrayList<ExpandListChild>();

		ExpandListGroup gru_06 = new ExpandListGroup();
		sSetName = (String) BURIALList.get(0);
		gru_06.setName(sSetName);
		iMax = BURIALList.size();
		i = 1;
		while (i < iMax) {		
			ExpandListChild ch_06_i = new ExpandListChild();	
			sChildName = (String) BURIALList.get(i);
			ch_06_i.setName(sChildName);
			ch_06_i.setTag(null);
			list2.add(ch_06_i);
			i++;
		}
		gru_06.setItems(list2);

		// christening

		List CHRISTENINGList = new LinkedList();
		CHRISTENINGList      = new ArrayList();

		CHRISTENINGList.add("Event - christening");
		CHRISTENINGList.addAll(EVENTList);

		list2 = new ArrayList<ExpandListChild>();

		ExpandListGroup gru_08 = new ExpandListGroup();
		sSetName = (String) CHRISTENINGList.get(0);
		gru_08.setName(sSetName);
		iMax = BURIALList.size();
		i = 1;
		while (i < iMax) {		
			ExpandListChild ch_08_i = new ExpandListChild();	
			sChildName = (String) CHRISTENINGList.get(i);
			ch_08_i.setName(sChildName);
			ch_08_i.setTag(null);
			list2.add(ch_08_i);
			i++;
		}
		gru_08.setItems(list2);

		// death

		List DEATHList = new LinkedList();
		DEATHList      = new ArrayList();

		DEATHList.add("Event - death");
		DEATHList.addAll(EVENTList);

		list2 = new ArrayList<ExpandListChild>();

		ExpandListGroup gru_10 = new ExpandListGroup();
		sSetName = (String) DEATHList.get(0);
		gru_10.setName(sSetName);
		iMax = BURIALList.size();
		i = 1;
		while (i < iMax) {		
			ExpandListChild ch_10_i = new ExpandListChild();	
			sChildName = (String) DEATHList.get(i);
			ch_10_i.setName(sChildName);
			ch_10_i.setTag(null);
			list2.add(ch_10_i);
			i++;
		}
		gru_10.setItems(list2);

		// emmigration

		List EMMIGRATIONList = new LinkedList();
		EMMIGRATIONList      = new ArrayList();

		EMMIGRATIONList.add("Event - emmigration");
		EMMIGRATIONList.addAll(EVENTList);

		list2 = new ArrayList<ExpandListChild>();

		ExpandListGroup gru_12 = new ExpandListGroup();
		sSetName = (String) EMMIGRATIONList.get(0);
		gru_12.setName(sSetName);
		iMax = EMMIGRATIONList.size();
		i = 1;
		while (i < iMax) {		
			ExpandListChild ch_12_i = new ExpandListChild();	
			sChildName = (String) EMMIGRATIONList.get(i);
			ch_12_i.setName(sChildName);
			ch_12_i.setTag(null);
			list2.add(ch_12_i);
			i++;
		}
		gru_12.setItems(list2);

		// immigration

		List IMMIGRATIONList = new LinkedList();
		IMMIGRATIONList      = new ArrayList();

		IMMIGRATIONList.add("Event - immigration");
		IMMIGRATIONList.addAll(EVENTList);

		list2 = new ArrayList<ExpandListChild>();

		ExpandListGroup gru_14 = new ExpandListGroup();
		sSetName = (String) IMMIGRATIONList.get(0);
		gru_14.setName(sSetName);
		iMax = IMMIGRATIONList.size();
		i = 1;
		while (i < iMax) {		
			ExpandListChild ch_14_i = new ExpandListChild();	
			sChildName = (String) IMMIGRATIONList.get(i);
			ch_14_i.setName(sChildName);
			ch_14_i.setTag(null);
			list2.add(ch_14_i);
			i++;
		}
		gru_14.setItems(list2);

		// occupation

		List OCCUPATIONList = new LinkedList();
		OCCUPATIONList      = new ArrayList();

		OCCUPATIONList.add("Event - occupation");
		OCCUPATIONList.add("Occupation: ");
		OCCUPATIONList.addAll(EVENTList);

		list2 = new ArrayList<ExpandListChild>();

		ExpandListGroup gru_16 = new ExpandListGroup();
		sSetName = (String) OCCUPATIONList.get(0);
		gru_16.setName(sSetName);
		iMax = OCCUPATIONList.size();
		i = 1;
		while (i < iMax) {		
			ExpandListChild ch_16_i = new ExpandListChild();	
			sChildName = (String) OCCUPATIONList.get(i);
			ch_16_i.setName(sChildName);
			ch_16_i.setTag(null);
			list2.add(ch_16_i);
			i++;
		}
		gru_16.setItems(list2);

		// other

		List OTHERList = new LinkedList();
		OTHERList      = new ArrayList();

		OTHERList.add("Event - other");
		OTHERList.addAll(EVENTList);

		list2 = new ArrayList<ExpandListChild>();

		ExpandListGroup gru_18 = new ExpandListGroup();
		sSetName = (String) OTHERList.get(0);
		gru_18.setName(sSetName);
		iMax = OTHERList.size();
		i = 1;
		while (i < iMax) {		
			ExpandListChild ch_18_i = new ExpandListChild();	
			sChildName = (String) OTHERList.get(i);
			ch_18_i.setName(sChildName);
			ch_18_i.setTag(null);
			list2.add(ch_18_i);
			i++;
		}
		gru_18.setItems(list2);

		// residence

		List RESIDENCEList = new LinkedList();
		RESIDENCEList      = new ArrayList();

		RESIDENCEList.add("Event - residence");
		RESIDENCEList.add("Type: ");
		RESIDENCEList.addAll(EVENTList);

		list2 = new ArrayList<ExpandListChild>();

		ExpandListGroup gru_20 = new ExpandListGroup();
		sSetName = (String) RESIDENCEList.get(0);
		gru_20.setName(sSetName);
		iMax = RESIDENCEList.size();
		i = 1;
		while (i < iMax) {		
			ExpandListChild ch_20_i = new ExpandListChild();	
			sChildName = (String) RESIDENCEList.get(i);
			ch_20_i.setName(sChildName);
			ch_20_i.setTag(null);
			list2.add(ch_20_i);
			i++;
		}
		gru_20.setItems(list2);

		list.add(gru_01);
		list.add(gru_02);
		list.add(gru_04);
		list.add(gru_06);
		list.add(gru_08);
		list.add(gru_10);
		list.add(gru_12);
		list.add(gru_14);
		list.add(gru_16);
		list.add(gru_18);
		list.add(gru_20);

		return list;
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
