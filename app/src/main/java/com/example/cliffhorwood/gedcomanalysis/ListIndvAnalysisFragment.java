package com.example.cliffhorwood.gedcomanalysis;

import com.example.cliffhorwood.gedcomanalysis.Classes.MyMethods;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;

import android.app.ListFragment;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class ListIndvAnalysisFragment extends ListFragment{

	private String sFragmentName = this.getClass().getSimpleName();

	private int iPrefix = 7;
	private int iMultipleResidence   =  0;

	private String indvtype = " ";

	/** Called once the fragment is associated with its activity.  **/
	public void onAttach() {
		super.onAttach(getActivity());
		Log.i(sFragmentName, "onAttach()");
	}

	/** Called to do initial creation of the fragment. */
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

	/**  Tells the fragment that its activity has completed its own Activity.onCreate() */
	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		Log.i(sFragmentName, "onActivityCreated()");

		String str = "";
		String strbulk;

		int iBaptism     =  0;
		int iBirth       =  0;
		int iBurial      =  0;
		int iChristening =  0;
		int iDeath       =  0;
		int iEmigration  =  0;
		int iEvent       =  0;
		int iFemale      =  0;
		int iImmigration =  0;
		int iMale        =  0;
		int iMultipleEmigration =  0;
		int iMultipleImmigration =  0;
		int iMultipleNote        =  0;
		int iMultipleOccupation  =  0;
		// int iMultipleResidence   =  0;
		int iMultipleSource      =  0;
		int iOccupation  =  0;
		int iResidence   =  0;
		int iNote        =  0;
		int iSexunkn     =  0;
		int iSource      =  0;
		int iSurnall     =  0;
		int iSurnblnk    =  0;
		int iSurnunkn    =  0;

		int iNumIndv     =  0;

		boolean b;

		MyMethods myMethods = new MyMethods();
		// String sExtStorageDirectory = myMethods.extStorageDir();

		Bundle extras = getActivity().getIntent().getExtras();
		final String fname = extras.getString("fname");
		final String sIndvAnalysisCategory = extras.getString("sIndvAnalysisCategory");

		if ( (sIndvAnalysisCategory == null) || sIndvAnalysisCategory.isEmpty() ) {
			// Log.i(sFragmentName, "2. sIndvAnalysisCategory has been changed to: " + sIndvAnalysisCategory );			
		}

		// String sFullyQualFileName = sExtStorageDirectory + fname;

		List IndvList = new LinkedList();         
		IndvList      = new ArrayList(); 

		List SurnList = new LinkedList();
		SurnList      = new ArrayList();

		List newList  = new LinkedList();
		newList       = new ArrayList();

		newList = myMethods.LoadTextFileToArray((ArrayList<String>) newList, fname);

		if (newList.size() > 0) {

			List IndividualList	= new LinkedList();
			IndividualList		= new ArrayList();
			IndividualList		= myMethods.LoadIndividualsToArray((ArrayList<String>) IndividualList, (ArrayList<String>) newList);	

			if (IndividualList.size() > 0) {

				// process the array

				int i = 0;

				while (i < IndividualList.size()) {

					if (i < IndividualList.size()) {				// get the next line if it exists
						str = (String) IndividualList.get(i);
					}

					boolean surnexists = false;
					boolean chldexists = false;
					boolean birtexists = false;
					boolean deatexists = false;
					boolean ancsexists = false;
					boolean chrsexists = false;
					boolean resiexists = false;
					boolean srceexists = false;
					boolean noteexists = false;
					boolean immiexists = false;
					boolean emmiexists = false;
					boolean bapmexists = false;
					boolean occuexists = false;
					boolean buriexists = false;
					boolean evenexists = false;

					String scratch = " ";

					iMultipleEmigration  = 0;
					iMultipleImmigration = 0;
					iMultipleNote        = 0;
					iMultipleOccupation  = 0;
					iMultipleResidence   = 0;
					iMultipleSource      = 0;					

					while ( !(b = str.endsWith("@ INDI"))  && (i < IndividualList.size())  )  {

						//  process the individual's details

						if (str.startsWith("1 SEX")) {
							// sexexists = true;
							if (str.endsWith("M")) {
								iMale++;
							}
							else if (str.endsWith("F")) {
								iFemale++;
							}
							else {
								iSexunkn++;
							}
						}
						else if (str.startsWith("2 SURN")) {
							surnexists = true;
							scratch = str.substring(iPrefix,str.length());

							int index = Collections.binarySearch(SurnList, scratch);				// If the SURN is not already in the list, add it 
							if (index < 0) {
								SurnList.add(-index-1, scratch);
								iSurnall++;
							}

							if (scratch.toLowerCase(Locale.getDefault()).equals("unknown")) {
								// surnunkn = true;
								iSurnunkn++;
							}
							else if (scratch.equals(" ")) {
								// surnblnk = true;
								iSurnblnk++;
							}
						}
						else if (str.startsWith("1 BAPM")) {
							bapmexists = true;
							iBaptism++;
						}
						else if (str.startsWith("1 BIRT")) {
							birtexists = true;
							iBirth++;
						}
						else if (str.startsWith("1 BURI")) {
							buriexists = true;
							iBurial++;
						}
						else if (str.startsWith("1 CHIL")) {
							chldexists = true;
						}
						else if (str.startsWith("1 CHR")) {
							chrsexists = true;
							iChristening++;
						}
						else if (str.startsWith("1 DEAT")) {
							deatexists = true;
							iDeath++;
						}
						else if( str.startsWith("1 EMIG")) {
							emmiexists = true;
							iEmigration++;
							iMultipleEmigration++;
						}
						else if (str.startsWith("1 EVEN")) {
							evenexists = true;
							// iNumEVEN++;
							iEvent++;
						}
						else if( str.startsWith("1 IMMI")) {
							immiexists = true;
							iImmigration++;
							iMultipleImmigration++;
						}
						else if (str.startsWith("1 NOTE") || str.startsWith("2 NOTE")) {
							noteexists = true;
							iNote++;
							iMultipleNote++;
						}
						else if (str.startsWith("1 OCCU")) {
							occuexists = true;
							iOccupation++;
							iMultipleOccupation++;
						}
						else if (str.startsWith("1 RESI")) {
							resiexists = true;
							iResidence++;
							iMultipleResidence++;
						}
						else if (str.startsWith("1 SOUR") || str.startsWith("2 SOUR")) {
							srceexists = true;
							iSource++;
							iMultipleSource++;
						}
						else {
							// do something else
						}

						//  end process the individual's details

						i++;
						if (i < IndividualList.size()) {				// get the next line if it exists
							str = (String) IndividualList.get(i);
						}

					}					// while (!(b = str.endsWith("@ INDI")))

					if (b = str.endsWith("@ INDI")) {
						iNumIndv++;
					}

					i++;
				}				// while (i < IndividualList.size())

				// end of process the array

			}				// while (i < IndividualList.size())

			else {
				// do something else IndividualList is empty	
			}
		}
		else {
			// do something else newList is empty
		}					// if (newList.size() > 0)

		int iNoBirth = iNumIndv - iBirth;
		int iNoDeath = iNumIndv - iDeath;
		iNumIndv--;
		String sText;

		if (sIndvAnalysisCategory.equals("All") || sIndvAnalysisCategory.equals("Indv")) {
			// sText = getActivity().getResources().getString(R.string.sAllIndividuals) + " : " + iNumIndv;
			if (iNumIndv  >= 0)		{ IndvList.add("All Individuals" + " : " + iNumIndv); }
			// if (iNumIndv  >= 0)		{ IndvList.add( sText); }
			if (iMale     >= 0)		{ IndvList.add("Sex - Male"      + " : " + iMale); }
			if (iFemale   >= 0)		{ IndvList.add("Sex - Female"    + " : " + iFemale); }
			if (iSexunkn  >= 0)		{ IndvList.add("Sex - Unkn"      + " : " + iSexunkn); }
			if (iSurnall  >= 0)		{ IndvList.add("Surnames - All"  + " : " + iSurnall); }
		}

		if (sIndvAnalysisCategory.equals("All") || sIndvAnalysisCategory.equals("Event")) {
			if (iBaptism     >= 0)	{ IndvList.add("Event - baptism"     + " : " + iBaptism); }
			if (iBirth       >= 0)	{ IndvList.add("Event - birth"       + " : " + iBirth); }
			if (iBurial      >= 0)	{ IndvList.add("Event - burial"      + " : " + iBurial); }
			if (iChristening >= 0)	{ IndvList.add("Event - christening" + " : " + iChristening); }
			if (iDeath       >= 0)	{ IndvList.add("Event - death"       + " : " + iDeath); }
			if (iEmigration  >= 0)	{ IndvList.add("Event - emigration" + "  : " + iEmigration); }
			if (iImmigration >= 0)	{ IndvList.add("Event - immigration" + " : " + iImmigration); }
			if (iOccupation  >= 0)	{ IndvList.add("Event - occupation"  + " : " + iOccupation); }
			if (iEvent       >= 0)	{ IndvList.add("Event - other"       + " : " + iEvent); }
			if (iResidence   >= 0)	{ IndvList.add("Event - residence"   + " : " + iResidence); }
		}

		if (sIndvAnalysisCategory.equals("All") || sIndvAnalysisCategory.equals("Information")) {
			if (iNote   >= 0)		{ IndvList.add("Information - note"   + " : " + iNote); }
			if (iSource >= 0)		{ IndvList.add("Information - source" + " : " + iSource); }
		}

		if (sIndvAnalysisCategory.equals("All") || sIndvAnalysisCategory.equals("Missing")) {
			if (iNoBirth  >= 0)		{ IndvList.add("Missing - birth"           + " : " + iNoBirth); }
			if (iNoDeath  >= 0)		{ IndvList.add("Missing - death"           + " : " + iNoDeath); }
			if (iSexunkn  >= 0)		{ IndvList.add("Missing - sex"             + " : " + iSexunkn); }
			if (iSurnblnk >= 0)		{ IndvList.add("Missing - surname"         + " : " + iSurnblnk); }
			if (iSurnunkn >= 0)		{ IndvList.add("Missing - unknown surname" + " : " + iSurnunkn); }
		}

		if (sIndvAnalysisCategory.equals("All") || sIndvAnalysisCategory.equals("Multiple")) {
			if (iMultipleEmigration  >= 0)	{ IndvList.add("Multiple - emigration"  + " : " + iMultipleEmigration); }		
			if (iMultipleImmigration >= 0)	{ IndvList.add("Multiple - immigration" + " : " + iMultipleImmigration); }		
			if (iMultipleNote        >= 0)	{ IndvList.add("Multiple - notes"       + " : " + iMultipleNote); }		
			if (iMultipleOccupation  >= 0)	{ IndvList.add("Multiple - occupations" + " : " + iMultipleOccupation); }		
			if (iMultipleResidence   >= 0)	{ IndvList.add("Multiple - residences"  + " : " + iMultipleResidence); }
			if (iMultipleSource      >= 0)	{ IndvList.add("Multiple - sources"     + " : " + iMultipleSource); }
		}		

		String[] simpleArray = new String[ IndvList.size() ];
		IndvList.toArray( simpleArray );	

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

	@Override
	public void onListItemClick(ListView l, View v, int position, long id) {
		super.onListItemClick(l, v, position, id);

		String item = (String) getListAdapter().getItem(position);

		Bundle extras = getActivity().getIntent().getExtras();
		String fname = extras.getString("fname");

		String sIndvAnalysisCategory = extras.getString("sIndvAnalysisCategory");


		if (item.startsWith("All individuals")) {
			Intent intent = new Intent();
			intent.setClass(getActivity(), ListIndv3Activity.class);
			intent.putExtra("fname", fname);
			intent.putExtra("indvtype", "all");
			intent.putExtra("parentactivity", sFragmentName);
			intent.putExtra("sIndvAnalysisCategory", sIndvAnalysisCategory);				
			startActivity(intent);	    
		}
		else if (item.startsWith("Sex - male")) {
			Intent intent = new Intent();
			intent.setClass(getActivity(), ListIndv3Activity.class);
			intent.putExtra("fname", fname);
			intent.putExtra("indvtype", "male");
			intent.putExtra("parentactivity", sFragmentName);
			intent.putExtra("sIndvAnalysisCategory", sIndvAnalysisCategory);				
			startActivity(intent);	    
		}		
		else if (item.startsWith("Sex - female")) {
			Intent intent = new Intent();
			intent.setClass(getActivity(), ListIndv3Activity.class);
			intent.putExtra("fname", fname);
			intent.putExtra("indvtype", "female");
			intent.putExtra("parentactivity", sFragmentName);			
			intent.putExtra("sIndvAnalysisCategory", sIndvAnalysisCategory);				
			startActivity(intent);	    
		}		
		else if (item.startsWith("Surnames - all")) {
			Intent intent = new Intent();
			intent.setClass(getActivity(), ListSurnActivity.class);
			intent.putExtra("fname", fname);
			intent.putExtra("parentactivity", sFragmentName);			
			intent.putExtra("sIndvAnalysisCategory", sIndvAnalysisCategory);				
			startActivity(intent);	    
		}		
		else if (item.startsWith("Surnames - unknown")) {
			Intent intent = new Intent();
			intent.setClass(getActivity(), ListIndv3Activity.class);
			intent.putExtra("fname", fname);
			intent.putExtra("indvtype", "surnunkn");
			intent.putExtra("parentactivity", sFragmentName);			
			intent.putExtra("sIndvAnalysisCategory", sIndvAnalysisCategory);				
			startActivity(intent);	    
		}	
		
		// Missing
		
		else if (item.startsWith("Missing - birth")) {
			Intent intent = new Intent();
			intent.setClass(getActivity(), ListIndv3Activity.class);
			intent.putExtra("fname", fname);
			intent.putExtra("indvtype", "nobirth");
			intent.putExtra("parentactivity", sFragmentName);		
			intent.putExtra("sIndvAnalysisCategory", sIndvAnalysisCategory);				
			startActivity(intent);	    
		}    
		else if (item.startsWith("Missing - death")) {
			Intent intent = new Intent();
			intent.setClass(getActivity(), ListIndv3Activity.class);
			intent.putExtra("fname", fname);
			intent.putExtra("indvtype", "nodeath");
			intent.putExtra("parentactivity", sFragmentName);	
			intent.putExtra("sIndvAnalysisCategory", sIndvAnalysisCategory);				
			startActivity(intent);	    
		}    
		else if (item.startsWith("Missing - sex")) {
			Intent intent = new Intent();
			intent.setClass(getActivity(), ListIndv3Activity.class);
			intent.putExtra("fname", fname);
			intent.putExtra("indvtype", "nosex");
			intent.putExtra("parentactivity", sFragmentName);	
			intent.putExtra("sIndvAnalysisCategory", sIndvAnalysisCategory);					
			startActivity(intent);	    
		}				
		else if (item.startsWith("Missing - surname")) {
			Intent intent = new Intent();
			intent.setClass(getActivity(), ListIndv3Activity.class);
			intent.putExtra("fname", fname);
			intent.putExtra("indvtype", "surnblnk");
			intent.putExtra("parentactivity", sFragmentName);	
			intent.putExtra("sIndvAnalysisCategory", sIndvAnalysisCategory);					
			startActivity(intent);	    
		}    
		else if (item.startsWith("Missing - unknown surname")) {
			Intent intent = new Intent();
			intent.setClass(getActivity(), ListIndv3Activity.class);
			intent.putExtra("fname", fname);
			intent.putExtra("indvtype", "surnunkn");
			intent.putExtra("parentactivity", sFragmentName);	
			intent.putExtra("sIndvAnalysisCategory", sIndvAnalysisCategory);					
			startActivity(intent);	    
		}  
		
		// Events
		
		else if (item.startsWith("Event - baptism")) {
			Intent intent = new Intent();
			intent.setClass(getActivity(), ListIndv3Activity.class);
			intent.putExtra("fname", fname);
			intent.putExtra("indvtype", "baptism");
			intent.putExtra("parentactivity", sFragmentName);	
			intent.putExtra("sIndvAnalysisCategory", sIndvAnalysisCategory);
			startActivity(intent);	    
		}    
		else if (item.startsWith("Event - birth")) {
			Intent intent = new Intent();
			intent.setClass(getActivity(), ListIndv3Activity.class);
			intent.putExtra("fname", fname);
			intent.putExtra("indvtype", "birth");
			intent.putExtra("parentactivity", sFragmentName);	
			intent.putExtra("sIndvAnalysisCategory", sIndvAnalysisCategory);					
			startActivity(intent);	    
		}    
		else if (item.startsWith("Event - burial")) {
			Intent intent = new Intent();
			intent.setClass(getActivity(), ListIndv3Activity.class);
			intent.putExtra("fname", fname);
			intent.putExtra("indvtype", "burial");
			intent.putExtra("parentactivity", sFragmentName);	
			intent.putExtra("sIndvAnalysisCategory", sIndvAnalysisCategory);					
			startActivity(intent);	    
		}    
		else if (item.startsWith("Event - christening")) {
			Intent intent = new Intent();
			intent.setClass(getActivity(), ListIndv3Activity.class);
			intent.putExtra("fname", fname);
			intent.putExtra("indvtype", "christ");
			intent.putExtra("parentactivity", sFragmentName);	
			intent.putExtra("sIndvAnalysisCategory", sIndvAnalysisCategory);					
			startActivity(intent);	    
		}    
		else if (item.startsWith("Event - death")) {
			Intent intent = new Intent();
			intent.setClass(getActivity(), ListIndv3Activity.class);
			intent.putExtra("fname", fname);
			intent.putExtra("indvtype", "death");
			intent.putExtra("parentactivity", sFragmentName);	
			intent.putExtra("sIndvAnalysisCategory", sIndvAnalysisCategory);					
			startActivity(intent);	    
		}    
		else if (item.startsWith("Event - emigration")) {
			Intent intent = new Intent();
			intent.setClass(getActivity(), ListIndv3Activity.class);
			intent.putExtra("fname", fname);
			intent.putExtra("indvtype", "emigration");
			intent.putExtra("parentactivity", sFragmentName);	
			intent.putExtra("sIndvAnalysisCategory", sIndvAnalysisCategory);					
			startActivity(intent);	    
		}    
		else if (item.startsWith("Event - immigration")) {
			Intent intent = new Intent();
			intent.setClass(getActivity(), ListIndv3Activity.class);
			intent.putExtra("fname", fname);
			intent.putExtra("indvtype", "immigration");
			intent.putExtra("parentactivity", sFragmentName);	
			intent.putExtra("sIndvAnalysisCategory", sIndvAnalysisCategory);					
			startActivity(intent);	    
		}    
		else if (item.startsWith("Event - occupation")) {
			Intent intent = new Intent();
			intent.setClass(getActivity(), ListIndv3Activity.class);
			intent.putExtra("fname", fname);
			intent.putExtra("indvtype", "occupation");
			intent.putExtra("parentactivity", sFragmentName);
			intent.putExtra("sIndvAnalysisCategory", sIndvAnalysisCategory);					
			startActivity(intent);	    
		}    
		else if (item.startsWith("Event - other")) {
			Intent intent = new Intent();
			intent.setClass(getActivity(), ListIndv3Activity.class);
			intent.putExtra("fname", fname);
			intent.putExtra("indvtype", "event");
			intent.putExtra("parentactivity", sFragmentName);	
			intent.putExtra("sIndvAnalysisCategory", sIndvAnalysisCategory);					
			startActivity(intent);	    
		}    
		else if (item.startsWith("Event - residence")) {
			Intent intent = new Intent();
			intent.setClass(getActivity(), ListIndv3Activity.class);
			intent.putExtra("fname", fname);
			intent.putExtra("indvtype", "resid");
			intent.putExtra("parentactivity", sFragmentName);	
			intent.putExtra("sIndvAnalysisCategory", sIndvAnalysisCategory);					
			startActivity(intent);	    
		}   
		
		// Information
		
		else if (item.startsWith("Information - note")) {
			Intent intent = new Intent();
			intent.setClass(getActivity(), ListIndv3Activity.class);
			intent.putExtra("fname", fname);
			intent.putExtra("indvtype", "note");
			intent.putExtra("parentactivity", sFragmentName);			
			intent.putExtra("sIndvAnalysisCategory", sIndvAnalysisCategory);				
			startActivity(intent);	    
		}    
		else if (item.startsWith("Information - residence")) {
			Intent intent = new Intent();
			intent.setClass(getActivity(), ListIndv3Activity.class);
			intent.putExtra("fname", fname);
			intent.putExtra("indvtype", "resid");
			intent.putExtra("parentactivity", sFragmentName);			
			intent.putExtra("sIndvAnalysisCategory", sIndvAnalysisCategory);				
			startActivity(intent);	    
		}    		
		else if (item.startsWith("Information - source")) {
			Intent intent = new Intent();
			intent.setClass(getActivity(), ListIndv3Activity.class);
			intent.putExtra("fname", fname);
			intent.putExtra("indvtype", "source");
			intent.putExtra("parentactivity", sFragmentName);			
			intent.putExtra("sIndvAnalysisCategory", sIndvAnalysisCategory);				
			startActivity(intent);	    
		} 
		
		// Multiple
		
		else if (item.startsWith("Multiple - emigration")) {
			Intent intent = new Intent();
			intent.setClass(getActivity(), ListIndv3Activity.class);
			intent.putExtra("fname", fname);
			intent.putExtra("indvtype", "multiemig");
			intent.putExtra("parentactivity", sFragmentName);			
			intent.putExtra("sIndvAnalysisCategory", sIndvAnalysisCategory);				
			startActivity(intent);	    
		}    		
		else if (item.startsWith("Multiple - immigration")) {
			Intent intent = new Intent();
			intent.setClass(getActivity(), ListIndv3Activity.class);
			intent.putExtra("fname", fname);
			intent.putExtra("indvtype", "multiimmi");
			intent.putExtra("parentactivity", sFragmentName);			
			intent.putExtra("sIndvAnalysisCategory", sIndvAnalysisCategory);				
			startActivity(intent);	    
		}    		
		else if (item.startsWith("Multiple - notes")) {
			Intent intent = new Intent();
			intent.setClass(getActivity(), ListIndv3Activity.class);
			intent.putExtra("fname", fname);
			intent.putExtra("indvtype", "multinotes");
			intent.putExtra("parentactivity", sFragmentName);			
			intent.putExtra("sIndvAnalysisCategory", sIndvAnalysisCategory);				
			startActivity(intent);	    
		}    		
		else if (item.startsWith("Multiple - occupations")) {
			Intent intent = new Intent();
			intent.setClass(getActivity(), ListIndv3Activity.class);
			intent.putExtra("fname", fname);
			intent.putExtra("indvtype", "multioccu");
			intent.putExtra("parentactivity", sFragmentName);			
			intent.putExtra("sIndvAnalysisCategory", sIndvAnalysisCategory);				
			startActivity(intent);	    
		}
		else if (item.startsWith("Multiple - residences")) {
			Intent intent = new Intent();
			intent.setClass(getActivity(), ListIndv3Activity.class);
			intent.putExtra("fname", fname);
			intent.putExtra("indvtype", "multiresid");
			intent.putExtra("parentactivity", sFragmentName);			
			intent.putExtra("sIndvAnalysisCategory", sIndvAnalysisCategory);				
			startActivity(intent);	    
		}    		
		else if (item.startsWith("Multiple - sources")) {
			Intent intent = new Intent();
			intent.setClass(getActivity(), ListIndv3Activity.class);
			intent.putExtra("fname", fname);
			intent.putExtra("indvtype", "multisources");
			intent.putExtra("parentactivity", sFragmentName);			
			intent.putExtra("sIndvAnalysisCategory", sIndvAnalysisCategory);				
			startActivity(intent);	    
		}  
		
		// Else
		
		else {
			Intent intent = new Intent();
			intent.setClass(getActivity(), ZActivity.class);
			intent.putExtra("fname", fname);
			startActivity(intent);	    
		}
	}

	/**
	 * As a fragment is no longer being used, it goes through a reverse series of callbacks:

onPause() fragment is no longer interacting with the user either because its activity is being paused or a fragment operation is modifying it in the activity.

onStop() fragment is no longer visible to the user either because its activity is being stopped or a fragment operation is modifying it in the activity.

onDestroyView() allows the fragment to clean up resources associated with its View.

onDestroy() called to do final cleanup of the fragment's state.

onDetach() called immediately prior to the fragment no longer being associated with its activity.

	 */	 

}
