package com.example.cliffhorwood.gedcomanalysis;

import com.example.cliffhorwood.gedcomanalysis.R;
import com.example.cliffhorwood.gedcomanalysis.Adapter.ExpandListAdapter;
import com.example.cliffhorwood.gedcomanalysis.Classes.*;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import android.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;

public class ShowIndvDetl3aFragment extends Fragment{

	private String sFragmentName = this.getClass().getSimpleName();

	private boolean DisplayMissing = true; 		// pass in as intent
	private boolean DisplayChild = false;

	private ExpandListAdapter ExpAdapter;
	private ArrayList<ExpandListGroup> ExpListItems;
	private ExpandableListView ExpandList;

	int prefix = 6;
	int iCtr = 0;

	private CharSequence sFlag;

	private CharSequence sNote1;
	private CharSequence sSource1;
	private String sLastChangedDate;
	private String sLastChangedTime;
	private String sLastChangedDateTime;

	private CharSequence sFamilyChild;
	private CharSequence sFamilySpouse;

	private String sFullName;
	private String sGivenNames;
	private String sSurname;
	private String sAKAFullName  = "";
	private String sSex;
	private CharSequence sAKAGivenNames;
	private CharSequence sAKASurname;

	private String sBaptismDate;
	private String sBaptismPlace;
	private String sBaptismType;
	private String sBaptismMap;
	private String sBaptismLati;
	private String sBaptismLong;
	private String sBaptismAddress;
	private String sBaptismAddressContd;
	private String sBaptismAddress1;
	private String sBaptismAddress1Contd;
	private String sBaptismCity;
	private String sBaptismState;
	private String sBaptismPostCode;
	private String sBaptismCountry;

	private String sBirthDate;
	private String sBirthPlace;
	private String sBirthType;
	private String sBirthMap;
	private String sBirthLati;
	private String sBirthLong;
	private String sBirthAddress;
	private String sBirthAddressContd;
	private String sBirthAddress1;
	private String sBirthAddress1Contd;
	private String sBirthCity;
	private String sBirthState;
	private String sBirthPostCode;
	private String sBirthCountry;

	private String sBurialDate;
	private String sBurialPlace;
	private String sBurialType;
	private String sBurialMap;
	private String sBurialLati;
	private String sBurialLong;
	private String sBurialAddress;
	private String sBurialAddressContd;
	private String sBurialAddress1;
	private String sBurialAddress1Contd;
	private String sBurialCity;
	private String sBurialState;
	private String sBurialPostCode;
	private String sBurialCountry;

	private String sChristeningDate;
	private String sChristeningPlace;
	private String sChristeningType;
	private String sChristeningMap;
	private String sChristeningLati;
	private String sChristeningLong;
	private String sChristeningAddress;
	private String sChristeningAddressContd;
	private String sChristeningAddress1;
	private String sChristeningAddress1Contd;
	private String sChristeningCity;
	private String sChristeningState;
	private String sChristeningPostCode;
	private String sChristeningCountry;

	private String sDeathDate;
	private String sDeathPlace;
	private String sDeathType;
	private String sDeathMap;
	private String sDeathLati;
	private String sDeathLong;
	private String sDeathAddress;
	private String sDeathAddressContd;
	private String sDeathAddress1;
	private String sDeathAddress1Contd;
	private String sDeathCity;
	private String sDeathState;
	private String sDeathPostCode;
	private String sDeathCountry;

	private String sEmigrationDate;
	private String sEmigrationPlace;
	private String sEmigrationType;
	private String sEmigrationMap;
	private String sEmigrationLati;
	private String sEmigrationLong;
	private String sEmigrationAddress;
	private String sEmigrationAddressContd;
	private String sEmigrationAddress1;
	private String sEmigrationAddress1Contd;
	private String sEmigrationCity;
	private String sEmigrationState;
	private String sEmigrationPostCode;
	private String sEmigrationCountry;

	private String sEventDate;
	private String sEventPlace;
	private String sEventType;
	private String sEventMap;
	private String sEventLati;
	private String sEventLong;
	private String sEventAddress;
	private String sEventAddressContd;
	private String sEventAddress1;
	private String sEventAddress1Contd;
	private String sEventCity;
	private String sEventState;
	private String sEventPostCode;
	private String sEventCountry;

	private String sImmigrationDate;
	private String sImmigrationPlace;
	private String sImmigrationType;
	private String sImmigrationMap;
	private String sImmigrationLati;
	private String sImmigrationLong;
	private String sImmigrationAddress;
	private String sImmigrationAddressContd;
	private String sImmigrationAddress1;
	private String sImmigrationAddress1Contd;
	private String sImmigrationCity;
	private String sImmigrationState;
	private String sImmigrationPostCode;
	private String sImmigrationCountry;

	private String sNoteDate;
	private String sNotePlace;
	private String sNoteType;
	private String sNoteMap;
	private String sNoteLati;
	private String sNoteLong;
	private String sNoteAddress;
	private String sNoteAddressContd;
	private String sNoteAddress1;
	private String sNoteAddress1Contd;
	private String sNoteCity;
	private String sNoteState;
	private String sNotePostCode;
	private String sNoteCountry;

	private String sOccupationDate;
	private String sOccupationPlace;
	private String sOccupationType;
	private String sOccupationMap;
	private String sOccupationLati;
	private String sOccupationLong;
	private String sOccupationAddress;
	private String sOccupationAddressContd;
	private String sOccupationAddress1;
	private String sOccupationAddress1Contd;
	private String sOccupationCity;
	private String sOccupationState;
	private String sOccupationPostCode;
	private String sOccupationCountry;
	private String sOccupation;

	private String sOtherDate;
	private String sOtherPlace;
	private String sOtherType;
	private String sOtherMap;
	private String sOtherLati;
	private String sOtherLong;
	private String sOtherAddress;
	private String sOtherAddressContd;
	private String sOtherAddress1;
	private String sOtherAddress1Contd;
	private String sOtherCity;
	private String sOtherState;
	private String sOtherPostCode;
	private String sOtherCountry;

	private String sResidenceDate;
	private String sResidencePlace;
	private String sResidenceType;
	private String sResidenceMap;
	private String sResidenceLati;
	private String sResidenceLong;
	private String sResidenceAddress;
	private String sResidenceAddressContd;
	private String sResidenceAddress1;
	private String sResidenceAddress1Contd;
	private String sResidenceCity;
	private String sResidenceState;
	private String sResidencePostCode;
	private String sResidenceCountry;

	private String sSourceDate;
	private String sSourcePlace;
	private String sSourceType;
	private String sSourceMap;
	private String sSourceLati;
	private String sSourceLong;
	private String sSourceAddress;
	private String sSourceAddressContd;
	private String sSourceAddress1;
	private String sSourceAddress1Contd;
	private String sSourceCity;
	private String sSourceState;
	private String sSourcePostCode;
	private String sSourceCountry;

    // private String sAKAFullName   = "";
    private boolean givnalready = false;
    private boolean surnalready = false;


    /** Called once the fragment is associated with its activity. **/
	public void onAttach() {
		super.onAttach(getActivity());
		Log.i(sFragmentName, "onAttach()");
	}

	/** Called to do initial creation of the fragment. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		Log.i(sFragmentName, "onCreate()");
		String str;
        String firstChar;
		boolean b;

		MyMethods myMethods = new MyMethods();
		// String sExtStorageDirectory = myMethods.extStorageDir();

		Bundle extras   = getActivity().getIntent().getExtras();

		String fname    = extras.getString("fname");
		String iname    = extras.getString("iname");
		String indi_id  = extras.getString("indi");
		String indvtype = extras.getString("indvtype");

		Log.i(sFragmentName, "onCreate() - fname: "    + fname);
        Log.i(sFragmentName, "onCreate() - iname: "    + iname);
        Log.i(sFragmentName, "onCreate() - indi: "     + indi_id);
        Log.i(sFragmentName, "onCreate() - indvtype: " + indvtype);

		// String sFullyQualFileName = sExtStorageDirectory + fname;

		sFullName = iname;
		int poscomma = iname.indexOf(",");
		String formattediname = iname.substring(poscomma + 2, iname.length());			// given names
		formattediname = formattediname + " /" + iname.substring(0, poscomma) + "/";

        Log.i(sFragmentName, "onCreate() - formattediname: " + formattediname);
        Log.i(sFragmentName, "onCreate() - sFullName: "      + sFullName);

		List IndvList = new LinkedList();         
		IndvList      = new ArrayList();          

		List newList  = new LinkedList();
		newList       = new ArrayList();

		newList = myMethods.LoadTextFileToArray((ArrayList<String>) newList, fname);

        // Loop forward through the array until you find the formatted name

       int i = 0;

        while ( i < newList.size() ) {
            str = (String) newList.get(i);
            if ( !str.equals("1 NAME " + formattediname) ) {
                i++;
            }
            else {
                Log.i(sFragmentName, "Found the formatted name");
                Log.i(sFragmentName, str);
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
                Log.i(sFragmentName, "Found the individual start");
                Log.i(sFragmentName, str);
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
                Log.i(sFragmentName, str);

                /**
                 * get the first character of the string
                 * 0 - start of INDI etc
                 * 1 - start of section eg CHR, BIRT, SEX, NOTE RESI
                 * 2 - 2nd line of above
                 * 3 - next line of above
                 *
                 * 0 - break out of loop the individual is finished
                 * 1 - 1st/only line of new section,
                 *     call the relevant details section
                 *     get the next line,
                 *        if it is 2 or 3 call the same section
                 *        if it is 1 loop
                 */
                // firstChar = str.charAt(0);
                firstChar = str.substring(0,1);

                Log.i(sFragmentName, "firstChar: " + firstChar);

                if (firstChar.equals("0"))  {
                    Log.i(sFragmentName, "Should not reach here because we have captured lines starting with 0 abve.");
                }
                else if (firstChar.equals("1")) {
                    Log.i(sFragmentName, "Determine wich section we are looking at");
                    if ( str.startsWith("1 CHR") ) {
                        sFlag = "chr";
                        detailsChristening(str);
                    }
                    else if ( str.startsWith("1 BIRT") ) {

                    }
                    else if ( str.startsWith("1 NAME") ) {

                    }
                    else if ( str.startsWith("1 SEX") ) {

                    }
                    else if ( str.startsWith("1 UID") ) {

                    }
                    else if ( str.startsWith("1 RESI") ) {

                    }
                    else if ( str.startsWith("1 NOTE") ) {

                    }
                    else if ( str.startsWith("1 FAMC") ) {

                    }
                    else {
                        // do nothing yet
                    }
                }
                else if (firstChar.equals("2")) {
                    if ( str.startsWith("2 DATE") ) {
                        if (sFlag == "chr") {
                            detailsChristening(str);
                        }

                    }
                    else if ( str.startsWith("2 PLAC") ) {
                        if (sFlag == "chr") {
                            detailsChristening(str);
                        }

                    }
                    else {
                        // do nothing yet
                    }

                }
                else if (firstChar.equals("3")) {
                    // do nothing yet

                }
                else if (firstChar.equals("4")) {
                    // do nothing yet

                }
                // detailsChristening(str);
                i++;
            }
            else break;
        }


        // process the array again

		i = 0;
		if ( newList.size() > i ) {

			// get the first row
			str = (String) newList.get(i);

			// bypass everything until the first individual
			// if an INDI has been passed in use that otherwise use the formatted name

			if(indi_id != null && !indi_id.isEmpty()) {
				String sCompletestr = "0 @" + indi_id + "@ INDI";
				while ( (i < newList.size()) && !(str.equals(sCompletestr)) ) {
					i++;
					str = (String) newList.get(i);
				}	
			}
			else {
				while ( (i < newList.size()) && !(str.startsWith("1 NAME " + formattediname)) ) {
					i++;
					str = (String) newList.get(i);
				}	
			}

			// get the next line if it exists
			i++;
			if (i < newList.size()) {
				str = (String) newList.get(i);
			}

			while (i < newList.size()) {

				sAKAFullName   = "";
				boolean givnalready = false;
				boolean surnalready = false;

				while ( (i < newList.size()) &&
                        !str.startsWith(getResources().getString(R.string.sINDI_start)) &&
                        !str.startsWith(getResources().getString(R.string.sSOUR_start)) &&
                        !str.startsWith(getResources().getString(R.string.sFAM_start)) &&
                        //!str.startsWith(getResources().getString(R.string.sNOTE_start)) &&
                        !str.startsWith(getResources().getString(R.string.sFILE_trlr)) ) {

					//  process the individual's details

					if (str.startsWith("1 NAME")) {     	// this is an alias <=====================================================================
						sAKAFullName = str.substring(prefix + 1, str.length()).replaceAll("/", "");
					}
					else if (str.startsWith("2 GIVN") && (!givnalready)) {   		
						sGivenNames = str.substring(prefix + 1,str.length());
						givnalready = true;
					}
					else if (str.startsWith("2 GIVN") && (givnalready)) {   		
						sAKAGivenNames = str.substring(prefix + 1,str.length());
					}				
					else if (str.startsWith("2 SURN") && (!surnalready)) {          		
						sSurname = str.substring(prefix + 1,str.length());
						surnalready = true;
					}
					else if (str.startsWith("2 SURN") && (surnalready)) {          		
						sAKASurname = str.substring(prefix + 1,str.length());
					}
					else if (str.startsWith("1 SEX")) {            		
						sSex = str.substring(prefix,str.length());
					}

					// birth details
					else if (str.startsWith("1 BIRT")) {            		
						sFlag = "birth";
					}
					else if ((sFlag == "birth") && (str.startsWith("2 TYPE"))) {            		
						sBirthType = str.substring(prefix,str.length());
					}			
					else if ((sFlag == "birth") && (str.startsWith("2 DATE"))) {            		
						sBirthDate = str.substring(prefix + 1,str.length());
					}
					else if ((sFlag == "birth") && (str.startsWith("2 PLAC"))) {            		
						sBirthPlace = str.substring(prefix + 1,str.length());
					}
					else if ((sFlag == "birth") && (str.startsWith("3 MAP"))) {            		
						sBirthMap = "Map";
					}
					else if ((sFlag == "birth") && (str.startsWith("4 LATI"))) {            		
						sBirthLati = str.substring(prefix,str.length());
					}
					else if ((sFlag == "birth") && (str.startsWith("4 LONG"))) {            		
						sBirthLong = str.substring(prefix,str.length());
					}
					else if ((sFlag == "birth") && (str.startsWith("2 ADDR"))) {            		
						sBirthAddress = str.substring(prefix,str.length());
					}
					else if ((sFlag == "birth") && (str.startsWith("3 CONT"))) {            		
						sBirthAddressContd = str.substring(prefix,str.length());
					}
					else if ((sFlag == "birth") && (str.startsWith("3 ADR1"))) {            		
						sBirthAddress1 = str.substring(prefix,str.length());
					}
					else if ((sFlag == "birth") && (str.startsWith("4 CONT "))) {            		
						sBirthAddress1Contd = str.substring(prefix,str.length());
					}
					else if ((sFlag == "birth") && (str.startsWith("3 CITY"))) {            		
						sBirthCity = str.substring(prefix,str.length());
					}
					else if ((sFlag == "birth") && (str.startsWith("3 STAE"))) {            		
						sBirthState = str.substring(prefix,str.length());
					}
					else if ((sFlag == "birth") && (str.startsWith("3 POST"))) {            		
						sBirthPostCode = str.substring(prefix,str.length());
					}
					else if ((sFlag == "birth") && (str.startsWith("3 CTRY"))) {            		
						sBirthCountry = str.substring(prefix,str.length());
					}

					// death details
					else if (str.startsWith("1 DEAT")) {            		
						sFlag = "death";
					}
					else if ((sFlag == "death") && (str.startsWith("2 TYPE"))) {            		
						sDeathType = str.substring(prefix,str.length());
					}			
					else if ((sFlag == "death") && (str.startsWith("2 DATE"))) {            		
						sDeathDate = str.substring(prefix + 1,str.length());
					}
					else if ((sFlag == "death") && (str.startsWith("2 PLAC"))) {            		
						sDeathPlace = str.substring(prefix + 1,str.length());
					}
					else if ((sFlag == "death") && (str.startsWith("3 MAP"))) {            		
						sDeathMap = "Map";
					}
					else if ((sFlag == "death") && (str.startsWith("4 LATI"))) {            		
						sDeathLati = str.substring(prefix,str.length());
					}
					else if ((sFlag == "death") && (str.startsWith("4 LONG"))) {            		
						sDeathLong = str.substring(prefix,str.length());
					}
					else if ((sFlag == "death") && (str.startsWith("2 ADDR"))) {            		
						sDeathAddress = str.substring(prefix,str.length());
					}
					else if ((sFlag == "death") && (str.startsWith("3 CONT"))) {            		
						sDeathAddressContd = str.substring(prefix,str.length());
					}
					else if ((sFlag == "death") && (str.startsWith("3 ADR1"))) {            		
						sDeathAddress1 = str.substring(prefix,str.length());
					}
					else if ((sFlag == "death") && (str.startsWith("4 CONT "))) {            		
						sDeathAddress1Contd = str.substring(prefix,str.length());
					}
					else if ((sFlag == "death") && (str.startsWith("3 CITY"))) {            		
						sDeathCity = str.substring(prefix,str.length());
					}
					else if ((sFlag == "death") && (str.startsWith("3 STAE"))) {            		
						sDeathState = str.substring(prefix,str.length());
					}
					else if ((sFlag == "death") && (str.startsWith("3 POST"))) {            		
						sDeathPostCode = str.substring(prefix,str.length());
					}
					else if ((sFlag == "death") && (str.startsWith("3 CTRY"))) {            		
						sDeathCountry = str.substring(prefix,str.length());
					}

					// burial details
					else if (str.startsWith("1 BURI")) {            		
						sFlag = "burial";
					}
					else if ((sFlag == "burial") && (str.startsWith("2 TYPE"))) {            		
						sBurialType = str.substring(prefix,str.length());
					}			
					else if ((sFlag == "burial") && (str.startsWith("2 DATE"))) {            		
						sBurialDate = str.substring(prefix + 1,str.length());
					}
					else if ((sFlag == "burial") && (str.startsWith("2 PLAC"))) {            		
						sBurialPlace = str.substring(prefix + 1,str.length());
					}
					else if ((sFlag == "burial") && (str.startsWith("3 MAP"))) {            		
						sBurialMap = "Map";
					}
					else if ((sFlag == "burial") && (str.startsWith("4 LATI"))) {            		
						sBurialLati = str.substring(prefix,str.length());
					}
					else if ((sFlag == "burial") && (str.startsWith("4 LONG"))) {            		
						sBurialLong = str.substring(prefix,str.length());
					}
					else if ((sFlag == "burial") && (str.startsWith("2 ADDR"))) {            		
						sBurialAddress = str.substring(prefix,str.length());
					}
					else if ((sFlag == "burial") && (str.startsWith("3 CONT"))) {            		
						sBurialAddressContd = str.substring(prefix,str.length());
					}
					else if ((sFlag == "burial") && (str.startsWith("3 ADR1"))) {            		
						sBurialAddress1 = str.substring(prefix,str.length());
					}
					else if ((sFlag == "burial") && (str.startsWith("4 CONT "))) {            		
						sBurialAddress1Contd = str.substring(prefix,str.length());
					}
					else if ((sFlag == "burial") && (str.startsWith("3 CITY"))) {            		
						sBurialCity = str.substring(prefix,str.length());
					}
					else if ((sFlag == "burial") && (str.startsWith("3 STAE"))) {            		
						sBurialState = str.substring(prefix,str.length());
					}
					else if ((sFlag == "burial") && (str.startsWith("3 POST"))) {            		
						sBurialPostCode = str.substring(prefix,str.length());
					}
					else if ((sFlag == "burial") && (str.startsWith("3 CTRY"))) {            		
						sBurialCountry = str.substring(prefix,str.length());
					}

					// emigration details
					else if (str.startsWith("1 EMIG")) {            		
						sFlag = "emig";
					}
					else if ((sFlag == "emig") && (str.startsWith("2 TYPE"))) {            		
						sEmigrationType = str.substring(prefix,str.length());
					}			
					else if ((sFlag == "emig") && (str.startsWith("2 DATE"))) {            		
						sEmigrationDate = str.substring(prefix + 1,str.length());
					}
					else if ((sFlag == "emig") && (str.startsWith("2 PLAC"))) {            		
						sEmigrationPlace = str.substring(prefix + 1,str.length());
					}
					else if ((sFlag == "emig") && (str.startsWith("3 MAP"))) {            		
						sEmigrationMap = "Map";
					}
					else if ((sFlag == "emig") && (str.startsWith("4 LATI"))) {            		
						sEmigrationLati = str.substring(prefix,str.length());
					}
					else if ((sFlag == "emig") && (str.startsWith("4 LONG"))) {            		
						sEmigrationLong = str.substring(prefix,str.length());
					}
					else if ((sFlag == "emig") && (str.startsWith("2 ADDR"))) {            		
						sEmigrationAddress = str.substring(prefix,str.length());
					}
					else if ((sFlag == "emig") && (str.startsWith("3 CONT"))) {            		
						sEmigrationAddressContd = str.substring(prefix,str.length());
					}
					else if ((sFlag == "emig") && (str.startsWith("3 ADR1"))) {            		
						sEmigrationAddress1 = str.substring(prefix,str.length());
					}
					else if ((sFlag == "emig") && (str.startsWith("4 CONT "))) {            		
						sEmigrationAddress1Contd = str.substring(prefix,str.length());
					}
					else if ((sFlag == "emig") && (str.startsWith("3 CITY"))) {            		
						sEmigrationCity = str.substring(prefix,str.length());
					}
					else if ((sFlag == "emig") && (str.startsWith("3 STAE"))) {            		
						sEmigrationState = str.substring(prefix,str.length());
					}
					else if ((sFlag == "emig") && (str.startsWith("3 POST"))) {            		
						sEmigrationPostCode = str.substring(prefix,str.length());
					}
					else if ((sFlag == "emig") && (str.startsWith("3 CTRY"))) {            		
						sEmigrationCountry = str.substring(prefix,str.length());
					}

					// immigration details
					else if (str.startsWith("1 IMMI")) {            		
						sFlag = "immi";
					}
					else if ((sFlag == "immi") && (str.startsWith("2 TYPE"))) {            		
						sImmigrationType = str.substring(prefix,str.length());
					}			
					else if ((sFlag == "immi") && (str.startsWith("2 DATE"))) {            		
						sImmigrationDate = str.substring(prefix + 1,str.length());
					}
					else if ((sFlag == "immi") && (str.startsWith("2 PLAC"))) {            		
						sImmigrationPlace = str.substring(prefix + 1,str.length());
					}
					else if ((sFlag == "immi") && (str.startsWith("3 MAP"))) {            		
						sImmigrationMap = "Map";
					}
					else if ((sFlag == "immi") && (str.startsWith("4 LATI"))) {            		
						sImmigrationLati = str.substring(prefix,str.length());
					}
					else if ((sFlag == "immi") && (str.startsWith("4 LONG"))) {            		
						sImmigrationLong = str.substring(prefix,str.length());
					}
					else if ((sFlag == "immi") && (str.startsWith("2 ADDR"))) {            		
						sImmigrationAddress = str.substring(prefix,str.length());
					}
					else if ((sFlag == "immi") && (str.startsWith("3 CONT"))) {            		
						sImmigrationAddressContd = str.substring(prefix,str.length());
					}
					else if ((sFlag == "immi") && (str.startsWith("3 ADR1"))) {            		
						sImmigrationAddress1 = str.substring(prefix,str.length());
					}
					else if ((sFlag == "immi") && (str.startsWith("4 CONT "))) {            		
						sImmigrationAddress1Contd = str.substring(prefix,str.length());
					}
					else if ((sFlag == "immi") && (str.startsWith("3 CITY"))) {            		
						sImmigrationCity = str.substring(prefix,str.length());
					}
					else if ((sFlag == "immi") && (str.startsWith("3 STAE"))) {            		
						sImmigrationState = str.substring(prefix,str.length());
					}
					else if ((sFlag == "immi") && (str.startsWith("3 POST"))) {            		
						sImmigrationPostCode = str.substring(prefix,str.length());
					}
					else if ((sFlag == "immi") && (str.startsWith("3 CTRY"))) {            		
						sImmigrationCountry = str.substring(prefix,str.length());
					}

					// christening details
					else if (str.startsWith("1 CHR")) {            		
						sFlag = "chr";
					}
					else if ((sFlag == "chr") && (str.startsWith("2 TYPE"))) {            		
						sChristeningType = str.substring(prefix,str.length());
					}			
					else if ((sFlag == "chr") && (str.startsWith("2 DATE"))) {            		
						sChristeningDate = str.substring(prefix,str.length());
					}
					else if ((sFlag == "chr") && (str.startsWith("2 PLAC"))) {            		
						sChristeningPlace = str.substring(prefix + 1,str.length());
					}
					else if ((sFlag == "chr") && (str.startsWith("3 MAP"))) {            		
						sChristeningMap = "Map";
					}
					else if ((sFlag == "chr") && (str.startsWith("4 LATI"))) {            		
						sChristeningLati = str.substring(prefix,str.length());
					}
					else if ((sFlag == "chr") && (str.startsWith("4 LONG"))) {            		
						sChristeningLong = str.substring(prefix,str.length());
					}
					else if ((sFlag == "chr") && (str.startsWith("2 ADDR"))) {            		
						sChristeningAddress = str.substring(prefix,str.length());
					}
					else if ((sFlag == "chr") && (str.startsWith("3 CONT"))) {            		
						sChristeningAddressContd = str.substring(prefix,str.length());
					}
					else if ((sFlag == "chr") && (str.startsWith("3 ADR1"))) {            		
						sChristeningAddress1 = str.substring(prefix,str.length());
					}
					else if ((sFlag == "chr") && (str.startsWith("4 CONT "))) {            		
						sChristeningAddress1Contd = str.substring(prefix,str.length());
					}
					else if ((sFlag == "chr") && (str.startsWith("3 CITY"))) {            		
						sChristeningCity = str.substring(prefix,str.length());
					}
					else if ((sFlag == "chr") && (str.startsWith("3 STAE"))) {            		
						sChristeningState = str.substring(prefix,str.length());
					}
					else if ((sFlag == "chr") && (str.startsWith("3 POST"))) {            		
						sChristeningPostCode = str.substring(prefix,str.length());
					}
					else if ((sFlag == "chr") && (str.startsWith("3 CTRY"))) {            		
						sChristeningCountry = str.substring(prefix,str.length());
					}

					// residence details
					else if (str.startsWith("1 RESI")) {            		
						sFlag = "resi";
					}
					else if ((sFlag == "resi") && (str.startsWith("2 TYPE"))) {            		
						sResidenceType = str.substring(prefix,str.length());
					}			
					else if ((sFlag == "resi") && (str.startsWith("2 DATE"))) {            		
						sResidenceDate = str.substring(prefix,str.length());
					}
					else if ((sFlag == "resi") && (str.startsWith("2 PLAC"))) {            		
						sResidencePlace = str.substring(prefix,str.length());
					}
					else if ((sFlag == "resi") && (str.startsWith("3 MAP"))) {  
						sResidenceMap = "Map";
					}
					else if ((sFlag == "resi") && (str.startsWith("4 LATI"))) {            		
						sResidenceLati = str.substring(prefix,str.length());
					}
					else if ((sFlag == "resi") && (str.startsWith("4 LONG"))) {            		
						sResidenceLong = str.substring(prefix,str.length());
					}
					else if ((sFlag == "resi") && (str.startsWith("2 ADDR"))) {            		
						sResidenceAddress = str.substring(prefix,str.length());
					}
					else if ((sFlag == "resi") && (str.startsWith("3 CONT"))) {            		
						sResidenceAddressContd = str.substring(prefix,str.length());
					}
					else if ((sFlag == "resi") && (str.startsWith("3 ADR1"))) {            		
						sResidenceAddress1 = str.substring(prefix,str.length());
					}
					else if ((sFlag == "resi") && (str.startsWith("4 CONT "))) {            		
						sResidenceAddress1Contd = str.substring(prefix,str.length());
					}
					else if ((sFlag == "resi") && (str.startsWith("3 CITY"))) {            		
						sResidenceCity = str.substring(prefix,str.length());
					}
					else if ((sFlag == "resi") && (str.startsWith("3 STAE"))) {            		
						sResidenceState = str.substring(prefix,str.length());
					}
					else if ((sFlag == "resi") && (str.startsWith("3 POST"))) {            		
						sResidencePostCode = str.substring(prefix,str.length());
					}
					else if ((sFlag == "resi") && (str.startsWith("3 CTRY"))) {            		
						sResidenceCountry = str.substring(prefix,str.length());
					}            	           	           	

					// baptism details
					else if (str.startsWith("1 BAPM")) {            		
						sFlag = "bapm";
					}
					else if ((sFlag == "bapm") && (str.startsWith("2 TYPE"))) {            		
						sBaptismType = str.substring(prefix,str.length());
					}			
					else if ((sFlag == "bapm") && (str.startsWith("2 DATE"))) {            		
						sBaptismDate = str.substring(prefix,str.length());
					}
					else if ((sFlag == "bapm") && (str.startsWith("2 PLAC"))) {            		
						sBaptismPlace = str.substring(prefix,str.length());
					}
					else if ((sFlag == "bapm") && (str.startsWith("3 MAP"))) {            		
						sBaptismMap = "Map";
					}
					else if ((sFlag == "bapm") && (str.startsWith("4 LATI"))) {            		
						sBaptismLati = str.substring(prefix,str.length());
					}
					else if ((sFlag == "bapm") && (str.startsWith("4 LONG"))) {            		
						sBaptismLong = str.substring(prefix,str.length());
					}
					else if ((sFlag == "bapm") && (str.startsWith("2 ADDR"))) {            		
						sBaptismAddress = str.substring(prefix,str.length());
					}
					else if ((sFlag == "bapm") && (str.startsWith("3 CONT"))) {            		
						sBaptismAddressContd = str.substring(prefix,str.length());
					}
					else if ((sFlag == "bapm") && (str.startsWith("3 ADR1"))) {            		
						sBaptismAddress1 = str.substring(prefix,str.length());
					}
					else if ((sFlag == "bapm") && (str.startsWith("4 CONT "))) {            		
						sBaptismAddress1Contd = str.substring(prefix,str.length());
					}
					else if ((sFlag == "bapm") && (str.startsWith("3 CITY"))) {            		
						sBaptismCity = str.substring(prefix,str.length());
					}
					else if ((sFlag == "bapm") && (str.startsWith("3 STAE"))) {            		
						sBaptismState = str.substring(prefix,str.length());
					}
					else if ((sFlag == "bapm") && (str.startsWith("3 POST"))) {            		
						sBaptismPostCode = str.substring(prefix,str.length());
					}
					else if ((sFlag == "bapm") && (str.startsWith("3 CTRY"))) {            		
						sBaptismCountry = str.substring(prefix,str.length());
					}            	           	           	

					// occupation details
					else if (str.startsWith("1 OCCU")) {            		
						sFlag = "occu";
						sOccupation = str.substring(prefix,str.length());
					}
					else if ((sFlag == "occu") && (str.startsWith("2 TYPE"))) {            		
						sOccupationType = str.substring(prefix,str.length());
					}			
					else if ((sFlag == "occu") && (str.startsWith("2 DATE"))) {            		
						sOccupationDate = str.substring(prefix,str.length());
					}
					else if ((sFlag == "occu") && (str.startsWith("2 PLAC"))) {            		
						sOccupationPlace = str.substring(prefix,str.length());
					}
					else if ((sFlag == "occu") && (str.startsWith("3 MAP"))) {            		
						sOccupationMap = "Map";
					}
					else if ((sFlag == "occu") && (str.startsWith("4 LATI"))) {            		
						sOccupationLati = str.substring(prefix,str.length());
					}
					else if ((sFlag == "occu") && (str.startsWith("4 LONG"))) {            		
						sOccupationLong = str.substring(prefix,str.length());
					}
					else if ((sFlag == "occu") && (str.startsWith("2 ADDR"))) {            		
						sOccupationAddress = str.substring(prefix,str.length());
					}
					else if ((sFlag == "occu") && (str.startsWith("3 CONT"))) {            		
						sOccupationAddressContd = str.substring(prefix,str.length());
					}
					else if ((sFlag == "occu") && (str.startsWith("3 ADR1"))) {            		
						sOccupationAddress1 = str.substring(prefix,str.length());
					}
					else if ((sFlag == "occu") && (str.startsWith("4 CONT "))) {            		
						sOccupationAddress1Contd = str.substring(prefix,str.length());
					}
					else if ((sFlag == "occu") && (str.startsWith("3 CITY"))) {            		
						sOccupationCity = str.substring(prefix,str.length());
					}
					else if ((sFlag == "occu") && (str.startsWith("3 STAE"))) {            		
						sOccupationState = str.substring(prefix,str.length());
					}
					else if ((sFlag == "occu") && (str.startsWith("3 POST"))) {            		
						sOccupationPostCode = str.substring(prefix,str.length());
					}
					else if ((sFlag == "occu") && (str.startsWith("3 CTRY"))) {            		
						sOccupationCountry = str.substring(prefix,str.length());
					}            	           	           	

					// event details
					else if (str.startsWith("1 EVEN")) {            		
						sFlag = "even";
					}
					else if ((sFlag == "even") && (str.startsWith("2 TYPE"))) {            		
						sEventType = str.substring(prefix,str.length());
					}			
					else if ((sFlag == "even") && (str.startsWith("2 DATE"))) {            		
						sEventDate = str.substring(prefix,str.length());
					}
					else if ((sFlag == "even") && (str.startsWith("2 PLAC"))) {            		
						sEventPlace = str.substring(prefix,str.length());
					}
					else if ((sFlag == "even") && (str.startsWith("3 MAP"))) {            		
						sEventMap = "Map";
					}
					else if ((sFlag == "even") && (str.startsWith("4 LATI"))) {            		
						sEventLati = str.substring(prefix,str.length());
					}
					else if ((sFlag == "even") && (str.startsWith("4 LONG"))) {            		
						sEventLong = str.substring(prefix,str.length());
					}
					else if ((sFlag == "even") && (str.startsWith("2 ADDR"))) {            		
						sEventAddress = str.substring(prefix,str.length());
					}
					else if ((sFlag == "even") && (str.startsWith("3 CONT"))) {            		
						sEventAddressContd = str.substring(prefix,str.length());
					}
					else if ((sFlag == "even") && (str.startsWith("3 ADR1"))) {            		
						sEventAddress1 = str.substring(prefix,str.length());
					}
					else if ((sFlag == "even") && (str.startsWith("4 CONT "))) {            		
						sEventAddress1Contd = str.substring(prefix,str.length());
					}
					else if ((sFlag == "even") && (str.startsWith("3 CITY"))) {            		
						sEventCity = str.substring(prefix,str.length());
					}
					else if ((sFlag == "even") && (str.startsWith("3 STAE"))) {            		
						sEventState = str.substring(prefix,str.length());
					}
					else if ((sFlag == "even") && (str.startsWith("3 POST"))) {            		
						sEventPostCode = str.substring(prefix,str.length());
					}
					else if ((sFlag == "even") && (str.startsWith("3 CTRY"))) {            		
						sEventCountry = str.substring(prefix,str.length());
					}            	           	           	

					// family details             	             	
					else if (str.startsWith("1 FAMC")) {            		
						sFlag = "famc";
						sFamilyChild = str.substring(prefix + 2,str.length() - 1);
					}
					else if (str.startsWith("1 FAMS")) {            		
						sFlag = "fams";
						sFamilySpouse = str.substring(prefix + 2,str.length() - 1);
					}

					// last upDated details
					else if (str.startsWith("1 CHAN")) {            		
						sFlag = "chan";
					}
					else if ((sFlag == "chan") && (str.startsWith("2 DATE"))) {
						sLastChangedDate = str.substring(prefix + 1,str.length()) + " ";
					}
					else if ((sFlag == "chan") && (str.startsWith("3 TIME"))) {            		
						sLastChangedTime = str.substring(prefix + 1,str.length());
					}

					// note details - only works for embedded notes
					else if ( (str.startsWith("1 NOTE")) || (str.startsWith("2 NOTE")) ) {            		
						sFlag = "note";
						sNote1 = str.substring(prefix + 1,str.length() - 1) + " - ";
					}
					else if ((sFlag == "note") && (str.startsWith("1 CONT"))) {
						sNote1 = sNote1 + " " + str.substring(prefix + 1, str.length());
					}
					else if ((sFlag == "note") && (str.startsWith("1 CONC"))) {            		
						sNote1 = sNote1 + " " + str.substring(prefix + 1, str.length());
					}

					// source details - only works for embedded sources
					else if (str.startsWith("1 SOUR") && (str.length() > prefix + 1)) {    
						sFlag = "sour";
						sSource1 = str.substring(prefix + 1,str.length() - 1) + " - ";
					}
					else if ((sFlag == "sour") && (str.startsWith("2 PAGE")) && (str.length() > prefix)) {
						sSource1 = sSource1 + " " + str.substring(prefix + 1, str.length());
					}
					else if ((sFlag == "sour") && (str.startsWith("2 DATA")) && (str.length() > prefix)) {   
						sSource1 = sSource1 + " " + str.substring(prefix + 1, str.length());
					}
					else if ((sFlag == "sour") && (str.startsWith("3 DATE")) && (str.length() > prefix)) {  
						sSource1 = sSource1 + " " + str.substring(prefix + 1, str.length());
					}

					//  end process the individual's details  <=====================================================================

					// get the next line if it exists
					i++;
					if (i < newList.size()) {
						str = (String) newList.get(i);
					}					

				}			// while ( (i < newList.size()) && ......

				if ( (b = str.endsWith("@ INDI")) || (b = str.startsWith("0 TRLR")) || (b =str.endsWith("@ SOUR")) || (b =str.endsWith("@ FAM")) || (b = str.indexOf("@ NOTE") > 0) ) {
					// stop processing
					i= newList.size();
				}

				// get the next line if it exists
				i++;
				if (i < newList.size()) {
					str = (String) newList.get(i);
				}				

			}				// while (i < newList.size())

		}					// if ( newList.size() > i )
	}

	/** Creates and returns the view hierarchy associated with the fragment. */    
	@Override
	public View onCreateView (LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		Log.i(sFragmentName, "onCreateView()");
		View myFragmentView = inflater.inflate(R.layout.main_expandlistview, container, false);		  
		ExpandList = (ExpandableListView) myFragmentView.findViewById(R.id.ExpList);
		ExpListItems = SetStandardGroups();
		ExpAdapter = new ExpandListAdapter(getActivity(), ExpListItems);
		ExpandList.setAdapter(ExpAdapter);

		return myFragmentView;

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

		if ( DisplayMissing ) {

			if ( (sFullName != null) && (sFullName.length() > 0) ) {
				INDIVIDUALList.add("Full name: "		 + sFullName.trim());
			}
			if ( (sGivenNames != null) && (sGivenNames.length() > 0) ) {
				INDIVIDUALList.add("Given names: "		 + sGivenNames.trim());
			}
			if ( (sSurname != null) && (sSurname.length() > 0) ) {
				INDIVIDUALList.add("Surname: "			 + sSurname.trim());
			}
			if ( (sAKAFullName != null) && (sAKAFullName.length() > 0) ) {
				INDIVIDUALList.add("Also known as: "	 + sAKAFullName.trim());
			}
			if ( (sSex != null) && (sSex.length() > 0) ) {
				INDIVIDUALList.add("Sex: "				 + sSex.trim());
			}
			if ( (sLastChangedDate != null) && (sLastChangedDate.length() > 0) ) {
				sLastChangedDateTime = sLastChangedDate;
				if ( (sLastChangedTime != null) && (sLastChangedTime.length() > 0) ) {
					sLastChangedDateTime = sLastChangedDateTime + sLastChangedTime;
				}
				INDIVIDUALList.add("Last changed: " + sLastChangedDateTime.trim());
			}

			if ( (sFullName == null) || (sFullName.length() <= 0) ) {
				INDIVIDUALList.add("Full name: ");
			}
			if ( (sGivenNames == null) || (sGivenNames.length() <= 0) ) {
				INDIVIDUALList.add("Given names: ");
			}
			if ( (sSurname == null) || (sSurname.length() <= 0) ) {
				INDIVIDUALList.add("Surname: ");
			}
			if ( (sAKAFullName == null) || (sAKAFullName.length() <= 0) ) {
				INDIVIDUALList.add("Also known as: ");
			}
			if ( (sSex == null) || (sSex.length() <= 0) ) {
				INDIVIDUALList.add("Sex: ");
			}
			if ( (sLastChangedDate == null) || (sLastChangedDate.length() <= 0) ) {
				sLastChangedDateTime = " ";
				if ( (sLastChangedTime == null) || (sLastChangedTime.length() <= 0) ) {	// changed && to ||
					sLastChangedDateTime = sLastChangedDateTime + " ";
				}
				INDIVIDUALList.add("Last changed: " + sLastChangedDateTime.trim());				
			}

		}
		else {	

			if ( (sFullName != null) && (sFullName.length() > 0) ) {
				INDIVIDUALList.add("Full name: "		 + sFullName.trim());
			}
			if ( (sGivenNames != null) && (sGivenNames.length() > 0) ) {
				INDIVIDUALList.add("Given names: "		 + sGivenNames.trim());
			}
			if ( (sSurname != null) && (sSurname.length() > 0) ) {
				INDIVIDUALList.add("Surname: "			 + sSurname.trim());
			}
			if ( (sAKAFullName != null) && (sAKAFullName.length() > 0) ) {
				INDIVIDUALList.add("Also known as: "	 + sAKAFullName.trim());
			}
			if ( (sSex != null) && (sSex.length() > 0) ) {
				INDIVIDUALList.add("Sex: "				 + sSex.trim());
			}
			if ( (sLastChangedDate != null) && (sLastChangedDate.length() > 0) ) {
				sLastChangedDateTime = sLastChangedDate;
				if ( (sLastChangedTime != null) && (sLastChangedTime.length() > 0) ) {
					sLastChangedDateTime = sLastChangedDateTime + sLastChangedTime;
				}
				INDIVIDUALList.add("Last changed: " + sLastChangedDateTime.trim());
			}			
		}

		// individual

		list2 = new ArrayList<ExpandListChild>();

		iGroup++;		
		ExpandListGroup gru_01 = new ExpandListGroup();
		boolean DisplayGroup_gru_01 = true;
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

		EVENTList.add("Type: ");
		EVENTList.add("Date: ");
		EVENTList.add("Place: ");
		EVENTList.add("Map: Lat: Long: ");
		EVENTList.add("Address: ");
		EVENTList.add("Address Contd: ");
		EVENTList.add("Address 1: ");
		EVENTList.add("Address 1 Contd: ");
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
		boolean DisplayGroup_gru_02 = false;
		sSetName = (String) BAPTISMList.get(0);
		gru_02.setName(sSetName);
		iMax = BAPTISMList.size();				
		i = 1;				
		while (i < iMax) {			
			ExpandListChild ch_02_i = new ExpandListChild();				
			sChildName = (String) BAPTISMList.get(i);

			if ( DisplayMissing ) {				
				DisplayChild = true;
				if (sChildName.startsWith("Date: "))  {
					if      ( (sBaptismDate == null) || (sBaptismDate.length() <= 0) ) {			
						sChildName = sChildName ;
					}
					else if ( (sBaptismDate != null) && (sBaptismDate.length() > 0) ) {
						sChildName = sChildName  + sBaptismDate.trim();						
					}
				}
				else if (sChildName.startsWith("Place: ")) {
					if      ( (sBaptismPlace == null) || (sBaptismPlace.length() <= 0) ) {			
						sChildName = sChildName ;
					}
					else if ( (sBaptismPlace != null) && (sBaptismPlace.length() > 0) ) {
						sChildName = sChildName  + sBaptismPlace.trim();						
					}
				}
				else if (sChildName.startsWith("Map: "))  {
					if      ( (sBaptismLati == null) || (sBaptismLati.length() <= 0) ) {
						sChildName = sChildName.replace("Lat: ", "Lat: "  );						
					}
					else if ( (sBaptismLati != null) && (sBaptismLati.length() > 0) )  {
						sChildName = sChildName.replace("Lat: ", "Lat: " + sBaptismLati.trim());												
					}			
					if      ( (sBaptismLong == null) || (sBaptismLong.length() <= 0) ) {
						sChildName = sChildName.replace("Long: ", " Long: " );						
					}
					else if ( (sBaptismLong != null) && (sBaptismLong.length() > 0) )  {
						sChildName = sChildName.replace("Long: ", " Long: " + sBaptismLong.trim());						
					}
				}
				else if (sChildName.startsWith("Address: ")) {
					if      ( (sBaptismAddress == null) || (sBaptismAddress.length() <= 0) ) {			
						sChildName = sChildName ;
					}
					else if ( (sBaptismAddress != null) && (sBaptismAddress.length() > 0) ) {
						sChildName = sChildName  + sBaptismAddress.trim();						
					}
				}
				else if (sChildName.startsWith("Address Contd: ")) {
					if      ( (sBaptismAddressContd == null) || (sBaptismAddressContd.length() <= 0) ) {			
						sChildName = sChildName ;
					}
					else if ( (sBaptismAddressContd != null) && (sBaptismAddressContd.length() > 0) ) {
						sChildName = sChildName  + sBaptismAddressContd.trim();						
					}
				}
				else if (sChildName.startsWith("Address 1: ")) {
					if      ( (sBaptismAddress1 == null) || (sBaptismAddress1.length() <= 0) ) {			
						sChildName = sChildName ;
					}
					else if ( (sBaptismAddress1 != null) && (sBaptismAddress1.length() > 0) ) {
						sChildName = sChildName  + sBaptismAddress1.trim();						
					}
				}
				else if (sChildName.startsWith("Address 1 Contd: ")) {
					if      ( (sBaptismAddress1Contd == null) || (sBaptismAddress1Contd.length() <= 0) ) {			
						sChildName = sChildName ;
					}
					else if ( (sBaptismAddress1Contd != null) && (sBaptismAddress1Contd.length() > 0) ) {
						sChildName = sChildName  + sBaptismAddress1Contd.trim();						
					}
				}
				else if (sChildName.startsWith("City: ")) {
					if      ( (sBaptismCity == null) || (sBaptismCity.length() <= 0) ) {			
						sChildName = sChildName ;
					}
					else if ( (sBaptismCity != null) && (sBaptismCity.length() > 0) ) {
						sChildName = sChildName  + sBaptismCity.trim();						
					}
				}
				else if (sChildName.startsWith("State: ")) {
					if      ( (sBaptismState == null) || (sBaptismState.length() <= 0) ) {			
						sChildName = sChildName ;
					}
					else if ( (sBaptismState != null) && (sBaptismState.length() > 0) ) {
						sChildName = sChildName  + sBaptismState.trim();						
					}
				}
				else if (sChildName.startsWith("Post code: ")) {
					if      ( (sBaptismPostCode == null) || (sBaptismPostCode.length() <= 0) ) {			
						sChildName = sChildName ;
					}
					else if ( (sBaptismPostCode != null) && (sBaptismPostCode.length() > 0) ) {
						sChildName = sChildName  + sBaptismPostCode.trim();						
					}
				}
				else if (sChildName.startsWith("Country: ")) {
					if      ( (sBaptismCountry == null) || (sBaptismCountry.length() <= 0) ) {			
						sChildName = sChildName ;
					}
					else if ( (sBaptismCountry != null) && (sBaptismCountry.length() > 0) ) {
						sChildName = sChildName  + sBaptismCountry.trim();						
					}
				}				
				else if (sChildName.startsWith("Type: ")) {
					if      ( (sBaptismType == null) || (sBaptismType.length() <= 0) ) {			
						sChildName = sChildName ;
					}
					else if ( (sBaptismType != null) && (sBaptismType.length() > 0) ) {
						sChildName = sChildName  + sBaptismType.trim();						
					}
				}				
			}
			else {
				DisplayChild = false;
				if ( (sChildName.startsWith("Date: "))  && (sBaptismDate != null) && (sBaptismDate.length() > 0) ) {
					sChildName = sChildName  + sBaptismDate.trim();
					DisplayChild = true;
				}
				else if ( (sChildName.startsWith("Place: ")) && (sBaptismPlace != null) && (sBaptismPlace.length() > 0) ) {
					sChildName = sChildName  + sBaptismPlace.trim();
					DisplayChild = true;
				}
				else if ( (sChildName.startsWith("Map: "))  && (sBaptismLati != null) && (sBaptismLati.length() > 0) && (sBaptismLong != null) && (sBaptismLong.length() > 0)    ) {
					sChildName = sChildName.replace("Lat: ", "Lat: " + sBaptismLati.trim() + " " );
					sChildName = sChildName.replace("Long: ", "Long: " + sBaptismLong.trim());
					DisplayChild = true;
				}
				else if ( (sChildName.startsWith("Address: ")) && (sBaptismAddress != null) && (sBaptismAddress.length() > 0) ) {
					sChildName = sChildName  + sBaptismAddress.trim();	
					DisplayChild = true;
				}
				else if ( (sChildName.startsWith("Address Contd: ")) && (sBaptismAddressContd != null) && (sBaptismAddressContd.length() > 0) ) {
					sChildName = sChildName  + sBaptismAddressContd.trim();	
					DisplayChild = true;
				}
				else if ( (sChildName.startsWith("Address 1: ")) && (sBaptismAddress1 != null) && (sBaptismAddress1.length() > 0) ) {
					sChildName = sChildName  + sBaptismAddress1.trim();	
					DisplayChild = true;
				}
				else if ( (sChildName.startsWith("Address 1 Contd: ")) && (sBaptismAddress1Contd != null) && (sBaptismAddress1Contd.length() > 0) ) {
					sChildName = sChildName  + sBaptismAddress1Contd.trim();	
					DisplayChild = true;
				}
				else if ( (sChildName.startsWith("City: ")) && (sBaptismCity != null) && (sBaptismCity.length() > 0) ) {
					sChildName = sChildName  + sBaptismCity.trim();	
					DisplayChild = true;
				}
				else if ( (sChildName.startsWith("State: ")) && (sBaptismState != null) && (sBaptismState.length() > 0) ) {
					sChildName = sChildName  + sBaptismState.trim();	
					DisplayChild = true;
				}
				else if ( (sChildName.startsWith("Post code: ")) && (sBaptismPostCode != null) && (sBaptismPostCode.length() > 0) ) {
					sChildName = sChildName  + sBaptismPostCode.trim();	
					DisplayChild = true;
				}
				else if ( (sChildName.startsWith("Country: ")) && (sBaptismCountry != null) && (sBaptismCountry.length() > 0) ) {
					sChildName = sChildName  + sBaptismCountry.trim();	
					DisplayChild = true;
				}				
				else if ( (sChildName.startsWith("Type: ")) && (sBaptismType != null) && (sBaptismType.length() > 0) ) {
					sChildName = sChildName  + sBaptismType.trim();	
					DisplayChild = true;
				}				
			}

			if (DisplayChild) {
				ch_02_i.setName(sChildName);
				ch_02_i.setTag(null);
				list2.add(ch_02_i);
				DisplayGroup_gru_02 = true;
			}
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
		boolean DisplayGroup_gru_04 = false;
		sSetName = (String) BIRTHList.get(0);
		gru_04.setName(sSetName);
		iMax = BIRTHList.size();
		i = 1;
		while (i < iMax) {		
			ExpandListChild ch_04_i = new ExpandListChild();	
			sChildName = (String) BIRTHList.get(i);

			if ( DisplayMissing ) {				
				DisplayChild = true;
				if (sChildName.startsWith("Date: "))  {
					if      ( (sBirthDate == null) || (sBirthDate.length() <= 0) ) {			
						sChildName = sChildName ;
					}
					else if ( (sBirthDate != null) && (sBirthDate.length() > 0) ) {
						sChildName = sChildName  + sBirthDate.trim();						
					}
				}
				else if (sChildName.startsWith("Place: ")) {
					if      ( (sBirthPlace == null) || (sBirthPlace.length() <= 0) ) {			
						sChildName = sChildName ;
					}
					else if ( (sBirthPlace != null) && (sBirthPlace.length() > 0) ) {
						sChildName = sChildName  + sBirthPlace.trim();						
					}
				}
				else if (sChildName.startsWith("Map: "))  {
					if      ( (sBirthLati == null) || (sBirthLati.length() <= 0) ) {
						sChildName = sChildName.replace("Lat: ", "Lat: "  );						
					}
					else if ( (sBirthLati != null) && (sBirthLati.length() > 0) )  {
						sChildName = sChildName.replace("Lat: ", "Lat: " + sBirthLati.trim());												
					}			
					if      ( (sBirthLong == null) || (sBirthLong.length() <= 0) ) {
						sChildName = sChildName.replace("Long: ", " Long: " );						
					}
					else if ( (sBirthLong != null) && (sBirthLong.length() > 0) )  {
						sChildName = sChildName.replace("Long: ", " Long: " + sBirthLong.trim());						
					}
				}
				else if (sChildName.startsWith("Address: ")) {
					if      ( (sBirthAddress == null) || (sBirthAddress.length() <= 0) ) {			
						sChildName = sChildName ;
					}
					else if ( (sBirthAddress != null) && (sBirthAddress.length() > 0) ) {
						sChildName = sChildName  + sBirthAddress.trim();						
					}
				}
				else if (sChildName.startsWith("Address Contd: ")) {
					if      ( (sBirthAddressContd == null) || (sBirthAddressContd.length() <= 0) ) {			
						sChildName = sChildName ;
					}
					else if ( (sBirthAddressContd != null) && (sBirthAddressContd.length() > 0) ) {
						sChildName = sChildName  + sBirthAddressContd.trim();						
					}
				}
				else if (sChildName.startsWith("Address 1: ")) {
					if      ( (sBirthAddress1 == null) || (sBirthAddress1.length() <= 0) ) {			
						sChildName = sChildName ;
					}
					else if ( (sBirthAddress1 != null) && (sBirthAddress1.length() > 0) ) {
						sChildName = sChildName  + sBirthAddress1.trim();						
					}
				}
				else if (sChildName.startsWith("Address 1 Contd: ")) {
					if      ( (sBirthAddress1Contd == null) || (sBirthAddress1Contd.length() <= 0) ) {			
						sChildName = sChildName ;
					}
					else if ( (sBirthAddress1Contd != null) && (sBirthAddress1Contd.length() > 0) ) {
						sChildName = sChildName  + sBirthAddress1Contd.trim();						
					}
				}
				else if (sChildName.startsWith("City: ")) {
					if      ( (sBirthCity == null) || (sBirthCity.length() <= 0) ) {			
						sChildName = sChildName ;
					}
					else if ( (sBirthCity != null) && (sBirthCity.length() > 0) ) {
						sChildName = sChildName  + sBirthCity.trim();						
					}
				}
				else if (sChildName.startsWith("State: ")) {
					if      ( (sBirthState == null) || (sBirthState.length() <= 0) ) {			
						sChildName = sChildName ;
					}
					else if ( (sBirthState != null) && (sBirthState.length() > 0) ) {
						sChildName = sChildName  + sBirthState.trim();						
					}
				}
				else if (sChildName.startsWith("Post code: ")) {
					if      ( (sBirthPostCode == null) || (sBirthPostCode.length() <= 0) ) {			
						sChildName = sChildName ;
					}
					else if ( (sBirthPostCode != null) && (sBirthPostCode.length() > 0) ) {
						sChildName = sChildName  + sBirthPostCode.trim();						
					}
				}
				else if (sChildName.startsWith("Country: ")) {
					if      ( (sBirthCountry == null) || (sBirthCountry.length() <= 0) ) {			
						sChildName = sChildName ;
					}
					else if ( (sBirthCountry != null) && (sBirthCountry.length() > 0) ) {
						sChildName = sChildName  + sBirthCountry.trim();						
					}
				}				
				else if (sChildName.startsWith("Type: ")) {
					if      ( (sBirthType == null) || (sBirthType.length() <= 0) ) {			
						sChildName = sChildName ;
					}
					else if ( (sBirthType != null) && (sBirthType.length() > 0) ) {
						sChildName = sChildName  + sBirthType.trim();						
					}
				}				
			}
			else {
				DisplayChild = false;
				if ( (sChildName.startsWith("Date: "))  && (sBirthDate != null) && (sBirthDate.length() > 0) ) {
					sChildName = sChildName  + sBirthDate.trim();
					DisplayChild = true;
				}
				else if ( (sChildName.startsWith("Place: ")) && (sBirthPlace != null) && (sBirthPlace.length() > 0) ) {
					sChildName = sChildName  + sBirthPlace.trim();
					DisplayChild = true;
				}
				else if ( (sChildName.startsWith("Map: "))  && (sBirthLati != null) && (sBirthLati.length() > 0) && (sBirthLong != null) && (sBirthLong.length() > 0)    ) {
					sChildName = sChildName.replace("Lat: ", "Lat: " + sBirthLati.trim() + " " );
					sChildName = sChildName.replace("Long: ", "Long: " + sBirthLong.trim());
					DisplayChild = true;
				}
				else if ( (sChildName.startsWith("Address: ")) && (sBirthAddress != null) && (sBirthAddress.length() > 0) ) {
					sChildName = sChildName  + sBirthAddress.trim();	
					DisplayChild = true;
				}
				else if ( (sChildName.startsWith("Address Contd: ")) && (sBirthAddressContd != null) && (sBirthAddressContd.length() > 0) ) {
					sChildName = sChildName  + sBirthAddressContd.trim();	
					DisplayChild = true;
				}
				else if ( (sChildName.startsWith("Address 1: ")) && (sBirthAddress1 != null) && (sBirthAddress1.length() > 0) ) {
					sChildName = sChildName  + sBirthAddress1.trim();	
					DisplayChild = true;
				}
				else if ( (sChildName.startsWith("Address 1 Contd: ")) && (sBirthAddress1Contd != null) && (sBirthAddress1Contd.length() > 0) ) {
					sChildName = sChildName  + sBirthAddress1Contd.trim();	
					DisplayChild = true;
				}
				else if ( (sChildName.startsWith("City: ")) && (sBirthCity != null) && (sBirthCity.length() > 0) ) {
					sChildName = sChildName  + sBirthCity.trim();	
					DisplayChild = true;
				}
				else if ( (sChildName.startsWith("State: ")) && (sBirthState != null) && (sBirthState.length() > 0) ) {
					sChildName = sChildName  + sBirthState.trim();	
					DisplayChild = true;
				}
				else if ( (sChildName.startsWith("Post code: ")) && (sBirthPostCode != null) && (sBirthPostCode.length() > 0) ) {
					sChildName = sChildName  + sBirthPostCode.trim();	
					DisplayChild = true;
				}
				else if ( (sChildName.startsWith("Country: ")) && (sBirthCountry != null) && (sBirthCountry.length() > 0) ) {
					sChildName = sChildName  + sBirthCountry.trim();	
					DisplayChild = true;
				}				
				else if ( (sChildName.startsWith("Type: ")) && (sBirthType != null) && (sBirthType.length() > 0) ) {
					sChildName = sChildName  + sBirthType.trim();	
					DisplayChild = true;
				}				
			}

			if (DisplayChild) {
				ch_04_i.setName(sChildName);
				ch_04_i.setTag(null);
				list2.add(ch_04_i);
				DisplayGroup_gru_04 = true;
			}
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
		boolean DisplayGroup_gru_06 = false;
		sSetName = (String) BURIALList.get(0);
		gru_06.setName(sSetName);
		iMax = BURIALList.size();
		i = 1;
		while (i < iMax) {		
			ExpandListChild ch_06_i = new ExpandListChild();	
			sChildName = (String) BURIALList.get(i);

			if ( DisplayMissing ) {				
				DisplayChild = true;
				if (sChildName.startsWith("Date: "))  {
					if      ( (sBurialDate == null) || (sBurialDate.length() <= 0) ) {			
						sChildName = sChildName ;
					}
					else if ( (sBurialDate != null) && (sBurialDate.length() > 0) ) {
						sChildName = sChildName  + sBurialDate.trim();						
					}
				}
				else if (sChildName.startsWith("Place: ")) {
					if      ( (sBurialPlace == null) || (sBurialPlace.length() <= 0) ) {			
						sChildName = sChildName ;
					}
					else if ( (sBurialPlace != null) && (sBurialPlace.length() > 0) ) {
						sChildName = sChildName  + sBurialPlace.trim();						
					}
				}
				else if (sChildName.startsWith("Map: "))  {
					if      ( (sBurialLati == null) || (sBurialLati.length() <= 0) ) {
						sChildName = sChildName.replace("Lat: ", "Lat: "  );						
					}
					else if ( (sBurialLati != null) && (sBurialLati.length() > 0) )  {
						sChildName = sChildName.replace("Lat: ", "Lat: " + sBurialLati.trim());												
					}			
					if      ( (sBurialLong == null) || (sBurialLong.length() <= 0) ) {
						sChildName = sChildName.replace("Long: ", " Long: " );						
					}
					else if ( (sBurialLong != null) && (sBurialLong.length() > 0) )  {
						sChildName = sChildName.replace("Long: ", " Long: " + sBurialLong.trim());						
					}
				}
				else if (sChildName.startsWith("Address: ")) {
					if      ( (sBurialAddress == null) || (sBurialAddress.length() <= 0) ) {			
						sChildName = sChildName ;
					}
					else if ( (sBurialAddress != null) && (sBurialAddress.length() > 0) ) {
						sChildName = sChildName  + sBurialAddress.trim();						
					}
				}
				else if (sChildName.startsWith("Address Contd: ")) {
					if      ( (sBurialAddressContd == null) || (sBurialAddressContd.length() <= 0) ) {			
						sChildName = sChildName ;
					}
					else if ( (sBurialAddressContd != null) && (sBurialAddressContd.length() > 0) ) {
						sChildName = sChildName  + sBurialAddressContd.trim();						
					}
				}
				else if (sChildName.startsWith("Address 1: ")) {
					if      ( (sBurialAddress1 == null) || (sBurialAddress1.length() <= 0) ) {			
						sChildName = sChildName ;
					}
					else if ( (sBurialAddress1 != null) && (sBurialAddress1.length() > 0) ) {
						sChildName = sChildName  + sBurialAddress1.trim();						
					}
				}
				else if (sChildName.startsWith("Address 1 Contd: ")) {
					if      ( (sBurialAddress1Contd == null) || (sBurialAddress1Contd.length() <= 0) ) {			
						sChildName = sChildName ;
					}
					else if ( (sBurialAddress1Contd != null) && (sBurialAddress1Contd.length() > 0) ) {
						sChildName = sChildName  + sBurialAddress1Contd.trim();						
					}
				}
				else if (sChildName.startsWith("City: ")) {
					if      ( (sBurialCity == null) || (sBurialCity.length() <= 0) ) {			
						sChildName = sChildName ;
					}
					else if ( (sBurialCity != null) && (sBurialCity.length() > 0) ) {
						sChildName = sChildName  + sBurialCity.trim();						
					}
				}
				else if (sChildName.startsWith("State: ")) {
					if      ( (sBurialState == null) || (sBurialState.length() <= 0) ) {			
						sChildName = sChildName ;
					}
					else if ( (sBurialState != null) && (sBurialState.length() > 0) ) {
						sChildName = sChildName  + sBurialState.trim();						
					}
				}
				else if (sChildName.startsWith("Post code: ")) {
					if      ( (sBurialPostCode == null) || (sBurialPostCode.length() <= 0) ) {			
						sChildName = sChildName ;
					}
					else if ( (sBurialPostCode != null) && (sBurialPostCode.length() > 0) ) {
						sChildName = sChildName  + sBurialPostCode.trim();						
					}
				}
				else if (sChildName.startsWith("Country: ")) {
					if      ( (sBurialCountry == null) || (sBurialCountry.length() <= 0) ) {			
						sChildName = sChildName ;
					}
					else if ( (sBurialCountry != null) && (sBurialCountry.length() > 0) ) {
						sChildName = sChildName  + sBurialCountry.trim();						
					}
				}				
				else if (sChildName.startsWith("Type: ")) {
					if      ( (sBurialType == null) || (sBurialType.length() <= 0) ) {			
						sChildName = sChildName ;
					}
					else if ( (sBurialType != null) && (sBurialType.length() > 0) ) {
						sChildName = sChildName  + sBurialType.trim();						
					}
				}				
			}
			else {
				DisplayChild = false;
				if ( (sChildName.startsWith("Date: "))  && (sBurialDate != null) && (sBurialDate.length() > 0) ) {
					sChildName = sChildName  + sBurialDate.trim();
					DisplayChild = true;
				}
				else if ( (sChildName.startsWith("Place: ")) && (sBurialPlace != null) && (sBurialPlace.length() > 0) ) {
					sChildName = sChildName  + sBurialPlace.trim();
					DisplayChild = true;
				}
				else if ( (sChildName.startsWith("Map: "))  && (sBurialLati != null) && (sBurialLati.length() > 0) && (sBurialLong != null) && (sBurialLong.length() > 0)    ) {
					sChildName = sChildName.replace("Lat: ", "Lat: " + sBurialLati.trim() + " " );
					sChildName = sChildName.replace("Long: ", "Long: " + sBurialLong.trim());
					DisplayChild = true;
				}
				else if ( (sChildName.startsWith("Address: ")) && (sBurialAddress != null) && (sBurialAddress.length() > 0) ) {
					sChildName = sChildName  + sBurialAddress.trim();	
					DisplayChild = true;
				}
				else if ( (sChildName.startsWith("Address Contd: ")) && (sBurialAddressContd != null) && (sBurialAddressContd.length() > 0) ) {
					sChildName = sChildName  + sBurialAddressContd.trim();	
					DisplayChild = true;
				}
				else if ( (sChildName.startsWith("Address 1: ")) && (sBurialAddress1 != null) && (sBurialAddress1.length() > 0) ) {
					sChildName = sChildName  + sBurialAddress1.trim();	
					DisplayChild = true;
				}
				else if ( (sChildName.startsWith("Address 1 Contd: ")) && (sBurialAddress1Contd != null) && (sBurialAddress1Contd.length() > 0) ) {
					sChildName = sChildName  + sBurialAddress1Contd.trim();	
					DisplayChild = true;
				}
				else if ( (sChildName.startsWith("City: ")) && (sBurialCity != null) && (sBurialCity.length() > 0) ) {
					sChildName = sChildName  + sBurialCity.trim();	
					DisplayChild = true;
				}
				else if ( (sChildName.startsWith("State: ")) && (sBurialState != null) && (sBurialState.length() > 0) ) {
					sChildName = sChildName  + sBurialState.trim();	
					DisplayChild = true;
				}
				else if ( (sChildName.startsWith("Post code: ")) && (sBurialPostCode != null) && (sBurialPostCode.length() > 0) ) {
					sChildName = sChildName  + sBurialPostCode.trim();	
					DisplayChild = true;
				}
				else if ( (sChildName.startsWith("Country: ")) && (sBurialCountry != null) && (sBurialCountry.length() > 0) ) {
					sChildName = sChildName  + sBurialCountry.trim();	
					DisplayChild = true;
				}				
				else if ( (sChildName.startsWith("Type: ")) && (sBurialType != null) && (sBurialType.length() > 0) ) {
					sChildName = sChildName  + sBurialType.trim();	
					DisplayChild = true;
				}				
			}

			if (DisplayChild) {
				ch_06_i.setName(sChildName);
				ch_06_i.setTag(null);
				list2.add(ch_06_i);
				DisplayGroup_gru_06 = true;
			}
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
		boolean DisplayGroup_gru_08 = false;
		sSetName = (String) CHRISTENINGList.get(0);
		gru_08.setName(sSetName);
		iMax = BURIALList.size();
		i = 1;
		while (i < iMax) {		
			ExpandListChild ch_08_i = new ExpandListChild();	
			sChildName = (String) CHRISTENINGList.get(i);

			if ( DisplayMissing ) {				
				DisplayChild = true;
				if (sChildName.startsWith("Date: "))  {
					if      ( (sChristeningDate == null) || (sChristeningDate.length() <= 0) ) {			
						sChildName = sChildName ;
					}
					else if ( (sChristeningDate != null) && (sChristeningDate.length() > 0) ) {
						sChildName = sChildName  + sChristeningDate.trim();						
					}
				}
				else if (sChildName.startsWith("Place: ")) {
					if      ( (sChristeningPlace == null) || (sChristeningPlace.length() <= 0) ) {			
						sChildName = sChildName ;
					}
					else if ( (sChristeningPlace != null) && (sChristeningPlace.length() > 0) ) {
						sChildName = sChildName  + sChristeningPlace.trim();						
					}
				}
				else if (sChildName.startsWith("Map: "))  {
					if      ( (sChristeningLati == null) || (sChristeningLati.length() <= 0) ) {
						sChildName = sChildName.replace("Lat: ", "Lat: "  );						
					}
					else if ( (sChristeningLati != null) && (sChristeningLati.length() > 0) )  {
						sChildName = sChildName.replace("Lat: ", "Lat: " + sChristeningLati.trim());												
					}			
					if      ( (sChristeningLong == null) || (sChristeningLong.length() <= 0) ) {
						sChildName = sChildName.replace("Long: ", " Long: " );						
					}
					else if ( (sChristeningLong != null) && (sChristeningLong.length() > 0) )  {
						sChildName = sChildName.replace("Long: ", " Long: " + sChristeningLong.trim());						
					}
				}
				else if (sChildName.startsWith("Address: ")) {
					if      ( (sChristeningAddress == null) || (sChristeningAddress.length() <= 0) ) {			
						sChildName = sChildName ;
					}
					else if ( (sChristeningAddress != null) && (sChristeningAddress.length() > 0) ) {
						sChildName = sChildName  + sChristeningAddress.trim();						
					}
				}
				else if (sChildName.startsWith("Address Contd: ")) {
					if      ( (sChristeningAddressContd == null) || (sChristeningAddressContd.length() <= 0) ) {			
						sChildName = sChildName ;
					}
					else if ( (sChristeningAddressContd != null) && (sChristeningAddressContd.length() > 0) ) {
						sChildName = sChildName  + sChristeningAddressContd.trim();						
					}
				}
				else if (sChildName.startsWith("Address 1: ")) {
					if      ( (sChristeningAddress1 == null) || (sChristeningAddress1.length() <= 0) ) {			
						sChildName = sChildName ;
					}
					else if ( (sChristeningAddress1 != null) && (sChristeningAddress1.length() > 0) ) {
						sChildName = sChildName  + sChristeningAddress1.trim();						
					}
				}
				else if (sChildName.startsWith("Address 1 Contd: ")) {
					if      ( (sChristeningAddress1Contd == null) || (sChristeningAddress1Contd.length() <= 0) ) {			
						sChildName = sChildName ;
					}
					else if ( (sChristeningAddress1Contd != null) && (sChristeningAddress1Contd.length() > 0) ) {
						sChildName = sChildName  + sChristeningAddress1Contd.trim();						
					}
				}
				else if (sChildName.startsWith("City: ")) {
					if      ( (sChristeningCity == null) || (sChristeningCity.length() <= 0) ) {			
						sChildName = sChildName ;
					}
					else if ( (sChristeningCity != null) && (sChristeningCity.length() > 0) ) {
						sChildName = sChildName  + sChristeningCity.trim();						
					}
				}
				else if (sChildName.startsWith("State: ")) {
					if      ( (sChristeningState == null) || (sChristeningState.length() <= 0) ) {			
						sChildName = sChildName ;
					}
					else if ( (sChristeningState != null) && (sChristeningState.length() > 0) ) {
						sChildName = sChildName  + sChristeningState.trim();						
					}
				}
				else if (sChildName.startsWith("Post code: ")) {
					if      ( (sChristeningPostCode == null) || (sChristeningPostCode.length() <= 0) ) {			
						sChildName = sChildName ;
					}
					else if ( (sChristeningPostCode != null) && (sChristeningPostCode.length() > 0) ) {
						sChildName = sChildName  + sChristeningPostCode.trim();						
					}
				}
				else if (sChildName.startsWith("Country: ")) {
					if      ( (sChristeningCountry == null) || (sChristeningCountry.length() <= 0) ) {			
						sChildName = sChildName ;
					}
					else if ( (sChristeningCountry != null) && (sChristeningCountry.length() > 0) ) {
						sChildName = sChildName  + sChristeningCountry.trim();						
					}
				}				
				else if (sChildName.startsWith("Type: ")) {
					if      ( (sChristeningType == null) || (sChristeningType.length() <= 0) ) {			
						sChildName = sChildName ;
					}
					else if ( (sChristeningType != null) && (sChristeningType.length() > 0) ) {
						sChildName = sChildName  + sChristeningType.trim();						
					}
				}				
			}
			else {
				DisplayChild = false;
				if ( (sChildName.startsWith("Date: "))  && (sChristeningDate != null) && (sChristeningDate.length() > 0) ) {
					sChildName = sChildName  + sChristeningDate.trim();
					DisplayChild = true;
				}
				else if ( (sChildName.startsWith("Place: ")) && (sChristeningPlace != null) && (sChristeningPlace.length() > 0) ) {
					sChildName = sChildName  + sChristeningPlace.trim();
					DisplayChild = true;
				}
				else if ( (sChildName.startsWith("Map: "))  && (sChristeningLati != null) && (sChristeningLati.length() > 0) && (sChristeningLong != null) && (sChristeningLong.length() > 0)    ) {
					sChildName = sChildName.replace("Lat: ", "Lat: " + sChristeningLati.trim() + " " );
					sChildName = sChildName.replace("Long: ", "Long: " + sChristeningLong.trim());
					DisplayChild = true;
				}
				else if ( (sChildName.startsWith("Address: ")) && (sChristeningAddress != null) && (sChristeningAddress.length() > 0) ) {
					sChildName = sChildName  + sChristeningAddress.trim();	
					DisplayChild = true;
				}
				else if ( (sChildName.startsWith("Address Contd: ")) && (sChristeningAddressContd != null) && (sChristeningAddressContd.length() > 0) ) {
					sChildName = sChildName  + sChristeningAddressContd.trim();	
					DisplayChild = true;
				}
				else if ( (sChildName.startsWith("Address 1: ")) && (sChristeningAddress1 != null) && (sChristeningAddress1.length() > 0) ) {
					sChildName = sChildName  + sChristeningAddress1.trim();	
					DisplayChild = true;
				}
				else if ( (sChildName.startsWith("Address 1 Contd: ")) && (sChristeningAddress1Contd != null) && (sChristeningAddress1Contd.length() > 0) ) {
					sChildName = sChildName  + sChristeningAddress1Contd.trim();	
					DisplayChild = true;
				}
				else if ( (sChildName.startsWith("City: ")) && (sChristeningCity != null) && (sChristeningCity.length() > 0) ) {
					sChildName = sChildName  + sChristeningCity.trim();	
					DisplayChild = true;
				}
				else if ( (sChildName.startsWith("State: ")) && (sChristeningState != null) && (sChristeningState.length() > 0) ) {
					sChildName = sChildName  + sChristeningState.trim();	
					DisplayChild = true;
				}
				else if ( (sChildName.startsWith("Post code: ")) && (sChristeningPostCode != null) && (sChristeningPostCode.length() > 0) ) {
					sChildName = sChildName  + sChristeningPostCode.trim();	
					DisplayChild = true;
				}
				else if ( (sChildName.startsWith("Country: ")) && (sChristeningCountry != null) && (sChristeningCountry.length() > 0) ) {
					sChildName = sChildName  + sChristeningCountry.trim();	
					DisplayChild = true;
				}				
				else if ( (sChildName.startsWith("Type: ")) && (sChristeningType != null) && (sChristeningType.length() > 0) ) {
					sChildName = sChildName  + sChristeningType.trim();	
					DisplayChild = true;
				}				
			}

			if (DisplayChild) {
				ch_08_i.setName(sChildName);
				ch_08_i.setTag(null);
				list2.add(ch_08_i);
				DisplayGroup_gru_08 = true;
			}
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
		boolean DisplayGroup_gru_10 = false;
		sSetName = (String) DEATHList.get(0);
		gru_10.setName(sSetName);
		iMax = BURIALList.size();
		i = 1;
		while (i < iMax) {		
			ExpandListChild ch_10_i = new ExpandListChild();	
			sChildName = (String) DEATHList.get(i);

			if ( DisplayMissing ) {				
				DisplayChild = true;
				if (sChildName.startsWith("Date: "))  {
					if      ( (sDeathDate == null) || (sDeathDate.length() <= 0) ) {			
						sChildName = sChildName ;
					}
					else if ( (sDeathDate != null) && (sDeathDate.length() > 0) ) {
						sChildName = sChildName  + sDeathDate.trim();						
					}
				}
				else if (sChildName.startsWith("Place: ")) {
					if      ( (sDeathPlace == null) || (sDeathPlace.length() <= 0) ) {			
						sChildName = sChildName ;
					}
					else if ( (sDeathPlace != null) && (sDeathPlace.length() > 0) ) {
						sChildName = sChildName  + sDeathPlace.trim();						
					}
				}
				else if (sChildName.startsWith("Map: "))  {
					if      ( (sDeathLati == null) || (sDeathLati.length() <= 0) ) {
						sChildName = sChildName.replace("Lat: ", "Lat: "  );						
					}
					else if ( (sDeathLati != null) && (sDeathLati.length() > 0) )  {
						sChildName = sChildName.replace("Lat: ", "Lat: " + sDeathLati.trim());												
					}			
					if      ( (sDeathLong == null) || (sDeathLong.length() <= 0) ) {
						sChildName = sChildName.replace("Long: ", " Long: " );						
					}
					else if ( (sDeathLong != null) && (sDeathLong.length() > 0) )  {
						sChildName = sChildName.replace("Long: ", " Long: " + sDeathLong.trim());						
					}
				}
				else if (sChildName.startsWith("Address: ")) {
					if      ( (sDeathAddress == null) || (sDeathAddress.length() <= 0) ) {			
						sChildName = sChildName ;
					}
					else if ( (sDeathAddress != null) && (sDeathAddress.length() > 0) ) {
						sChildName = sChildName  + sDeathAddress.trim();						
					}
				}
				else if (sChildName.startsWith("Address Contd: ")) {
					if      ( (sDeathAddressContd == null) || (sDeathAddressContd.length() <= 0) ) {			
						sChildName = sChildName ;
					}
					else if ( (sDeathAddressContd != null) && (sDeathAddressContd.length() > 0) ) {
						sChildName = sChildName  + sDeathAddressContd.trim();						
					}
				}
				else if (sChildName.startsWith("Address 1: ")) {
					if      ( (sDeathAddress1 == null) || (sDeathAddress1.length() <= 0) ) {			
						sChildName = sChildName ;
					}
					else if ( (sDeathAddress1 != null) && (sDeathAddress1.length() > 0) ) {
						sChildName = sChildName  + sDeathAddress1.trim();						
					}
				}
				else if (sChildName.startsWith("Address 1 Contd: ")) {
					if      ( (sDeathAddress1Contd == null) || (sDeathAddress1Contd.length() <= 0) ) {			
						sChildName = sChildName ;
					}
					else if ( (sDeathAddress1Contd != null) && (sDeathAddress1Contd.length() > 0) ) {
						sChildName = sChildName  + sDeathAddress1Contd.trim();						
					}
				}
				else if (sChildName.startsWith("City: ")) {
					if      ( (sDeathCity == null) || (sDeathCity.length() <= 0) ) {			
						sChildName = sChildName ;
					}
					else if ( (sDeathCity != null) && (sDeathCity.length() > 0) ) {
						sChildName = sChildName  + sDeathCity.trim();						
					}
				}
				else if (sChildName.startsWith("State: ")) {
					if      ( (sDeathState == null) || (sDeathState.length() <= 0) ) {			
						sChildName = sChildName ;
					}
					else if ( (sDeathState != null) && (sDeathState.length() > 0) ) {
						sChildName = sChildName  + sDeathState.trim();						
					}
				}
				else if (sChildName.startsWith("Post code: ")) {
					if      ( (sDeathPostCode == null) || (sDeathPostCode.length() <= 0) ) {			
						sChildName = sChildName ;
					}
					else if ( (sDeathPostCode != null) && (sDeathPostCode.length() > 0) ) {
						sChildName = sChildName  + sDeathPostCode.trim();						
					}
				}
				else if (sChildName.startsWith("Country: ")) {
					if      ( (sDeathCountry == null) || (sDeathCountry.length() <= 0) ) {			
						sChildName = sChildName ;
					}
					else if ( (sDeathCountry != null) && (sDeathCountry.length() > 0) ) {
						sChildName = sChildName  + sDeathCountry.trim();						
					}
				}				
				else if (sChildName.startsWith("Type: ")) {
					if      ( (sDeathType == null) || (sDeathType.length() <= 0) ) {			
						sChildName = sChildName ;
					}
					else if ( (sDeathType != null) && (sDeathType.length() > 0) ) {
						sChildName = sChildName  + sDeathType.trim();						
					}
				}				
			}
			else {
				DisplayChild = false;
				if ( (sChildName.startsWith("Date: "))  && (sDeathDate != null) && (sDeathDate.length() > 0) ) {
					sChildName = sChildName  + sDeathDate.trim();
					DisplayChild = true;
				}
				else if ( (sChildName.startsWith("Place: ")) && (sDeathPlace != null) && (sDeathPlace.length() > 0) ) {
					sChildName = sChildName  + sDeathPlace.trim();
					DisplayChild = true;
				}
				else if ( (sChildName.startsWith("Map: "))  && (sDeathLati != null) && (sDeathLati.length() > 0) && (sDeathLong != null) && (sDeathLong.length() > 0)    ) {
					sChildName = sChildName.replace("Lat: ", "Lat: " + sDeathLati.trim() + " " );
					sChildName = sChildName.replace("Long: ", "Long: " + sDeathLong.trim());
					DisplayChild = true;
				}
				else if ( (sChildName.startsWith("Address: ")) && (sDeathAddress != null) && (sDeathAddress.length() > 0) ) {
					sChildName = sChildName  + sDeathAddress.trim();	
					DisplayChild = true;
				}
				else if ( (sChildName.startsWith("Address Contd: ")) && (sDeathAddressContd != null) && (sDeathAddressContd.length() > 0) ) {
					sChildName = sChildName  + sDeathAddressContd.trim();	
					DisplayChild = true;
				}
				else if ( (sChildName.startsWith("Address 1: ")) && (sDeathAddress1 != null) && (sDeathAddress1.length() > 0) ) {
					sChildName = sChildName  + sDeathAddress1.trim();	
					DisplayChild = true;
				}
				else if ( (sChildName.startsWith("Address 1 Contd: ")) && (sDeathAddress1Contd != null) && (sDeathAddress1Contd.length() > 0) ) {
					sChildName = sChildName  + sDeathAddress1Contd.trim();	
					DisplayChild = true;
				}
				else if ( (sChildName.startsWith("City: ")) && (sDeathCity != null) && (sDeathCity.length() > 0) ) {
					sChildName = sChildName  + sDeathCity.trim();	
					DisplayChild = true;
				}
				else if ( (sChildName.startsWith("State: ")) && (sDeathState != null) && (sDeathState.length() > 0) ) {
					sChildName = sChildName  + sDeathState.trim();	
					DisplayChild = true;
				}
				else if ( (sChildName.startsWith("Post code: ")) && (sDeathPostCode != null) && (sDeathPostCode.length() > 0) ) {
					sChildName = sChildName  + sDeathPostCode.trim();	
					DisplayChild = true;
				}
				else if ( (sChildName.startsWith("Country: ")) && (sDeathCountry != null) && (sDeathCountry.length() > 0) ) {
					sChildName = sChildName  + sDeathCountry.trim();	
					DisplayChild = true;
				}				
				else if ( (sChildName.startsWith("Type: ")) && (sDeathType != null) && (sDeathType.length() > 0) ) {
					sChildName = sChildName  + sDeathType.trim();	
					DisplayChild = true;
				}				
			}

			if (DisplayChild) {
				ch_10_i.setName(sChildName);
				ch_10_i.setTag(null);
				list2.add(ch_10_i);
				DisplayGroup_gru_10 = true;
			}
			i++;
		}
		gru_10.setItems(list2);

		// Emigration

		List EMMIGRATIONList = new LinkedList();
		EMMIGRATIONList      = new ArrayList();

		EMMIGRATIONList.add("Event - emigration");
		EMMIGRATIONList.addAll(EVENTList);

		list2 = new ArrayList<ExpandListChild>();

		ExpandListGroup gru_12 = new ExpandListGroup();
		boolean DisplayGroup_gru_12 = false;
		sSetName = (String) EMMIGRATIONList.get(0);
		gru_12.setName(sSetName);
		iMax = EMMIGRATIONList.size();
		i = 1;
		while (i < iMax) {		
			ExpandListChild ch_12_i = new ExpandListChild();	
			sChildName = (String) EMMIGRATIONList.get(i);

			if ( DisplayMissing ) {				
				DisplayChild = true;
				if (sChildName.startsWith("Date: "))  {
					if      ( (sEmigrationDate == null) || (sEmigrationDate.length() <= 0) ) {			
						sChildName = sChildName ;
					}
					else if ( (sEmigrationDate != null) && (sEmigrationDate.length() > 0) ) {
						sChildName = sChildName  + sEmigrationDate.trim();						
					}
				}
				else if (sChildName.startsWith("Place: ")) {
					if      ( (sEmigrationPlace == null) || (sEmigrationPlace.length() <= 0) ) {			
						sChildName = sChildName ;
					}
					else if ( (sEmigrationPlace != null) && (sEmigrationPlace.length() > 0) ) {
						sChildName = sChildName  + sEmigrationPlace.trim();						
					}
				}
				else if (sChildName.startsWith("Map: "))  {
					if      ( (sEmigrationLati == null) || (sEmigrationLati.length() <= 0) ) {
						sChildName = sChildName.replace("Lat: ", "Lat: "  );						
					}
					else if ( (sEmigrationLati != null) && (sEmigrationLati.length() > 0) )  {
						sChildName = sChildName.replace("Lat: ", "Lat: " + sEmigrationLati.trim());												
					}			
					if      ( (sEmigrationLong == null) || (sEmigrationLong.length() <= 0) ) {
						sChildName = sChildName.replace("Long: ", " Long: " );						
					}
					else if ( (sEmigrationLong != null) && (sEmigrationLong.length() > 0) )  {
						sChildName = sChildName.replace("Long: ", " Long: " + sEmigrationLong.trim());						
					}
				}
				else if (sChildName.startsWith("Address: ")) {
					if      ( (sEmigrationAddress == null) || (sEmigrationAddress.length() <= 0) ) {			
						sChildName = sChildName ;
					}
					else if ( (sEmigrationAddress != null) && (sEmigrationAddress.length() > 0) ) {
						sChildName = sChildName  + sEmigrationAddress.trim();						
					}
				}
				else if (sChildName.startsWith("Address Contd: ")) {
					if      ( (sEmigrationAddressContd == null) || (sEmigrationAddressContd.length() <= 0) ) {			
						sChildName = sChildName ;
					}
					else if ( (sEmigrationAddressContd != null) && (sEmigrationAddressContd.length() > 0) ) {
						sChildName = sChildName  + sEmigrationAddressContd.trim();						
					}
				}
				else if (sChildName.startsWith("Address 1: ")) {
					if      ( (sEmigrationAddress1 == null) || (sEmigrationAddress1.length() <= 0) ) {			
						sChildName = sChildName ;
					}
					else if ( (sEmigrationAddress1 != null) && (sEmigrationAddress1.length() > 0) ) {
						sChildName = sChildName  + sEmigrationAddress1.trim();						
					}
				}
				else if (sChildName.startsWith("Address 1 Contd: ")) {
					if      ( (sEmigrationAddress1Contd == null) || (sEmigrationAddress1Contd.length() <= 0) ) {			
						sChildName = sChildName ;
					}
					else if ( (sEmigrationAddress1Contd != null) && (sEmigrationAddress1Contd.length() > 0) ) {
						sChildName = sChildName  + sEmigrationAddress1Contd.trim();						
					}
				}
				else if (sChildName.startsWith("City: ")) {
					if      ( (sEmigrationCity == null) || (sEmigrationCity.length() <= 0) ) {			
						sChildName = sChildName ;
					}
					else if ( (sEmigrationCity != null) && (sEmigrationCity.length() > 0) ) {
						sChildName = sChildName  + sEmigrationCity.trim();						
					}
				}
				else if (sChildName.startsWith("State: ")) {
					if      ( (sEmigrationState == null) || (sEmigrationState.length() <= 0) ) {			
						sChildName = sChildName ;
					}
					else if ( (sEmigrationState != null) && (sEmigrationState.length() > 0) ) {
						sChildName = sChildName  + sEmigrationState.trim();						
					}
				}
				else if (sChildName.startsWith("Post code: ")) {
					if      ( (sEmigrationPostCode == null) || (sEmigrationPostCode.length() <= 0) ) {			
						sChildName = sChildName ;
					}
					else if ( (sEmigrationPostCode != null) && (sEmigrationPostCode.length() > 0) ) {
						sChildName = sChildName  + sEmigrationPostCode.trim();						
					}
				}
				else if (sChildName.startsWith("Country: ")) {
					if      ( (sEmigrationCountry == null) || (sEmigrationCountry.length() <= 0) ) {			
						sChildName = sChildName ;
					}
					else if ( (sEmigrationCountry != null) && (sEmigrationCountry.length() > 0) ) {
						sChildName = sChildName  + sEmigrationCountry.trim();						
					}
				}				
				else if (sChildName.startsWith("Type: ")) {
					if      ( (sEmigrationType == null) || (sEmigrationType.length() <= 0) ) {			
						sChildName = sChildName ;
					}
					else if ( (sEmigrationType != null) && (sEmigrationType.length() > 0) ) {
						sChildName = sChildName  + sEmigrationType.trim();						
					}
				}				
			}
			else {
				DisplayChild = false;
				if ( (sChildName.startsWith("Date: "))  && (sEmigrationDate != null) && (sEmigrationDate.length() > 0) ) {
					sChildName = sChildName  + sEmigrationDate.trim();
					DisplayChild = true;
				}
				else if ( (sChildName.startsWith("Place: ")) && (sEmigrationPlace != null) && (sEmigrationPlace.length() > 0) ) {
					sChildName = sChildName  + sEmigrationPlace.trim();
					DisplayChild = true;
				}
				else if ( (sChildName.startsWith("Map: "))  && (sEmigrationLati != null) && (sEmigrationLati.length() > 0) && (sEmigrationLong != null) && (sEmigrationLong.length() > 0)    ) {
					sChildName = sChildName.replace("Lat: ", "Lat: " + sEmigrationLati.trim() + " " );
					sChildName = sChildName.replace("Long: ", "Long: " + sEmigrationLong.trim());
					DisplayChild = true;
				}
				else if ( (sChildName.startsWith("Address: ")) && (sEmigrationAddress != null) && (sEmigrationAddress.length() > 0) ) {
					sChildName = sChildName  + sEmigrationAddress.trim();	
					DisplayChild = true;
				}
				else if ( (sChildName.startsWith("Address Contd: ")) && (sEmigrationAddressContd != null) && (sEmigrationAddressContd.length() > 0) ) {
					sChildName = sChildName  + sEmigrationAddressContd.trim();	
					DisplayChild = true;
				}
				else if ( (sChildName.startsWith("Address 1: ")) && (sEmigrationAddress1 != null) && (sEmigrationAddress1.length() > 0) ) {
					sChildName = sChildName  + sEmigrationAddress1.trim();	
					DisplayChild = true;
				}
				else if ( (sChildName.startsWith("Address 1 Contd: ")) && (sEmigrationAddress1Contd != null) && (sEmigrationAddress1Contd.length() > 0) ) {
					sChildName = sChildName  + sEmigrationAddress1Contd.trim();	
					DisplayChild = true;
				}
				else if ( (sChildName.startsWith("City: ")) && (sEmigrationCity != null) && (sEmigrationCity.length() > 0) ) {
					sChildName = sChildName  + sEmigrationCity.trim();	
					DisplayChild = true;
				}
				else if ( (sChildName.startsWith("State: ")) && (sEmigrationState != null) && (sEmigrationState.length() > 0) ) {
					sChildName = sChildName  + sEmigrationState.trim();	
					DisplayChild = true;
				}
				else if ( (sChildName.startsWith("Post code: ")) && (sEmigrationPostCode != null) && (sEmigrationPostCode.length() > 0) ) {
					sChildName = sChildName  + sEmigrationPostCode.trim();	
					DisplayChild = true;
				}
				else if ( (sChildName.startsWith("Country: ")) && (sEmigrationCountry != null) && (sEmigrationCountry.length() > 0) ) {
					sChildName = sChildName  + sEmigrationCountry.trim();	
					DisplayChild = true;
				}				
				else if ( (sChildName.startsWith("Type: ")) && (sEmigrationType != null) && (sEmigrationType.length() > 0) ) {
					sChildName = sChildName  + sEmigrationType.trim();	
					DisplayChild = true;
				}				
			}

			if (DisplayChild) {
				ch_12_i.setName(sChildName);
				ch_12_i.setTag(null);
				list2.add(ch_12_i);
				DisplayGroup_gru_12 = true;
			}
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
		boolean DisplayGroup_gru_14 = false;
		sSetName = (String) IMMIGRATIONList.get(0);
		gru_14.setName(sSetName);
		iMax = IMMIGRATIONList.size();
		i = 1;
		while (i < iMax) {		
			ExpandListChild ch_14_i = new ExpandListChild();	
			sChildName = (String) IMMIGRATIONList.get(i);

			if ( DisplayMissing ) {				
				DisplayChild = true;
				if (sChildName.startsWith("Date: "))  {
					if      ( (sImmigrationDate == null) || (sImmigrationDate.length() <= 0) ) {			
						sChildName = sChildName ;
					}
					else if ( (sImmigrationDate != null) && (sImmigrationDate.length() > 0) ) {
						sChildName = sChildName  + sImmigrationDate.trim();						
					}
				}
				else if (sChildName.startsWith("Place: ")) {
					if      ( (sImmigrationPlace == null) || (sImmigrationPlace.length() <= 0) ) {			
						sChildName = sChildName ;
					}
					else if ( (sImmigrationPlace != null) && (sImmigrationPlace.length() > 0) ) {
						sChildName = sChildName  + sImmigrationPlace.trim();						
					}
				}
				else if (sChildName.startsWith("Map: "))  {
					if      ( (sImmigrationLati == null) || (sImmigrationLati.length() <= 0) ) {
						sChildName = sChildName.replace("Lat: ", "Lat: "  );						
					}
					else if ( (sImmigrationLati != null) && (sImmigrationLati.length() > 0) )  {
						sChildName = sChildName.replace("Lat: ", "Lat: " + sImmigrationLati.trim());												
					}			
					if      ( (sImmigrationLong == null) || (sImmigrationLong.length() <= 0) ) {
						sChildName = sChildName.replace("Long: ", " Long: " );						
					}
					else if ( (sImmigrationLong != null) && (sImmigrationLong.length() > 0) )  {
						sChildName = sChildName.replace("Long: ", " Long: " + sImmigrationLong.trim());						
					}
				}
				else if (sChildName.startsWith("Address: ")) {
					if      ( (sImmigrationAddress == null) || (sImmigrationAddress.length() <= 0) ) {			
						sChildName = sChildName ;
					}
					else if ( (sImmigrationAddress != null) && (sImmigrationAddress.length() > 0) ) {
						sChildName = sChildName  + sImmigrationAddress.trim();						
					}
				}
				else if (sChildName.startsWith("Address Contd: ")) {
					if      ( (sImmigrationAddressContd == null) || (sImmigrationAddressContd.length() <= 0) ) {			
						sChildName = sChildName ;
					}
					else if ( (sImmigrationAddressContd != null) && (sImmigrationAddressContd.length() > 0) ) {
						sChildName = sChildName  + sImmigrationAddressContd.trim();						
					}
				}
				else if (sChildName.startsWith("Address 1: ")) {
					if      ( (sImmigrationAddress1 == null) || (sImmigrationAddress1.length() <= 0) ) {			
						sChildName = sChildName ;
					}
					else if ( (sImmigrationAddress1 != null) && (sImmigrationAddress1.length() > 0) ) {
						sChildName = sChildName  + sImmigrationAddress1.trim();						
					}
				}
				else if (sChildName.startsWith("Address 1 Contd: ")) {
					if      ( (sImmigrationAddress1Contd == null) || (sImmigrationAddress1Contd.length() <= 0) ) {			
						sChildName = sChildName ;
					}
					else if ( (sImmigrationAddress1Contd != null) && (sImmigrationAddress1Contd.length() > 0) ) {
						sChildName = sChildName  + sImmigrationAddress1Contd.trim();						
					}
				}
				else if (sChildName.startsWith("City: ")) {
					if      ( (sImmigrationCity == null) || (sImmigrationCity.length() <= 0) ) {			
						sChildName = sChildName ;
					}
					else if ( (sImmigrationCity != null) && (sImmigrationCity.length() > 0) ) {
						sChildName = sChildName  + sImmigrationCity.trim();						
					}
				}
				else if (sChildName.startsWith("State: ")) {
					if      ( (sImmigrationState == null) || (sImmigrationState.length() <= 0) ) {			
						sChildName = sChildName ;
					}
					else if ( (sImmigrationState != null) && (sImmigrationState.length() > 0) ) {
						sChildName = sChildName  + sImmigrationState.trim();						
					}
				}
				else if (sChildName.startsWith("Post code: ")) {
					if      ( (sImmigrationPostCode == null) || (sImmigrationPostCode.length() <= 0) ) {			
						sChildName = sChildName ;
					}
					else if ( (sImmigrationPostCode != null) && (sImmigrationPostCode.length() > 0) ) {
						sChildName = sChildName  + sImmigrationPostCode.trim();						
					}
				}
				else if (sChildName.startsWith("Country: ")) {
					if      ( (sImmigrationCountry == null) || (sImmigrationCountry.length() <= 0) ) {			
						sChildName = sChildName ;
					}
					else if ( (sImmigrationCountry != null) && (sImmigrationCountry.length() > 0) ) {
						sChildName = sChildName  + sImmigrationCountry.trim();						
					}
				}				
				else if (sChildName.startsWith("Type: ")) {
					if      ( (sImmigrationType == null) || (sImmigrationType.length() <= 0) ) {			
						sChildName = sChildName ;
					}
					else if ( (sImmigrationType != null) && (sImmigrationType.length() > 0) ) {
						sChildName = sChildName  + sImmigrationType.trim();						
					}
				}				
			}
			else {
				DisplayChild = false;
				if ( (sChildName.startsWith("Date: "))  && (sImmigrationDate != null) && (sImmigrationDate.length() > 0) ) {
					sChildName = sChildName  + sImmigrationDate.trim();
					DisplayChild = true;
				}
				else if ( (sChildName.startsWith("Place: ")) && (sImmigrationPlace != null) && (sImmigrationPlace.length() > 0) ) {
					sChildName = sChildName  + sImmigrationPlace.trim();
					DisplayChild = true;
				}
				else if ( (sChildName.startsWith("Map: "))  && (sImmigrationLati != null) && (sImmigrationLati.length() > 0) && (sImmigrationLong != null) && (sImmigrationLong.length() > 0)    ) {
					sChildName = sChildName.replace("Lat: ", "Lat: " + sImmigrationLati.trim() + " " );
					sChildName = sChildName.replace("Long: ", "Long: " + sImmigrationLong.trim());
					DisplayChild = true;
				}
				else if ( (sChildName.startsWith("Address: ")) && (sImmigrationAddress != null) && (sImmigrationAddress.length() > 0) ) {
					sChildName = sChildName  + sImmigrationAddress.trim();	
					DisplayChild = true;
				}
				else if ( (sChildName.startsWith("Address Contd: ")) && (sImmigrationAddressContd != null) && (sImmigrationAddressContd.length() > 0) ) {
					sChildName = sChildName  + sImmigrationAddressContd.trim();	
					DisplayChild = true;
				}
				else if ( (sChildName.startsWith("Address 1: ")) && (sImmigrationAddress1 != null) && (sImmigrationAddress1.length() > 0) ) {
					sChildName = sChildName  + sImmigrationAddress1.trim();	
					DisplayChild = true;
				}
				else if ( (sChildName.startsWith("Address 1 Contd: ")) && (sImmigrationAddress1Contd != null) && (sImmigrationAddress1Contd.length() > 0) ) {
					sChildName = sChildName  + sImmigrationAddress1Contd.trim();	
					DisplayChild = true;
				}
				else if ( (sChildName.startsWith("City: ")) && (sImmigrationCity != null) && (sImmigrationCity.length() > 0) ) {
					sChildName = sChildName  + sImmigrationCity.trim();	
					DisplayChild = true;
				}
				else if ( (sChildName.startsWith("State: ")) && (sImmigrationState != null) && (sImmigrationState.length() > 0) ) {
					sChildName = sChildName  + sImmigrationState.trim();	
					DisplayChild = true;
				}
				else if ( (sChildName.startsWith("Post code: ")) && (sImmigrationPostCode != null) && (sImmigrationPostCode.length() > 0) ) {
					sChildName = sChildName  + sImmigrationPostCode.trim();	
					DisplayChild = true;
				}
				else if ( (sChildName.startsWith("Country: ")) && (sImmigrationCountry != null) && (sImmigrationCountry.length() > 0) ) {
					sChildName = sChildName  + sImmigrationCountry.trim();	
					DisplayChild = true;
				}				
				else if ( (sChildName.startsWith("Type: ")) && (sImmigrationType != null) && (sImmigrationType.length() > 0) ) {
					sChildName = sChildName  + sImmigrationType.trim();	
					DisplayChild = true;
				}				
			}

			if (DisplayChild) {
				ch_14_i.setName(sChildName);
				ch_14_i.setTag(null);
				list2.add(ch_14_i);
				DisplayGroup_gru_14 = true;
			}
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
		boolean DisplayGroup_gru_16 = false;
		sSetName = (String) OCCUPATIONList.get(0);
		gru_16.setName(sSetName);
		iMax = OCCUPATIONList.size();
		i = 1;
		while (i < iMax) {		
			ExpandListChild ch_16_i = new ExpandListChild();	
			sChildName = (String) OCCUPATIONList.get(i);

			if ( DisplayMissing ) {				
				DisplayChild = true;
				if (sChildName.startsWith("Date: "))  {
					if      ( (sOccupationDate == null) || (sOccupationDate.length() <= 0) ) {			
						sChildName = sChildName ;
					}
					else if ( (sOccupationDate != null) && (sOccupationDate.length() > 0) ) {
						sChildName = sChildName  + sOccupationDate.trim();						
					}
				}
				else if (sChildName.startsWith("Place: ")) {
					if      ( (sOccupationPlace == null) || (sOccupationPlace.length() <= 0) ) {			
						sChildName = sChildName ;
					}
					else if ( (sOccupationPlace != null) && (sOccupationPlace.length() > 0) ) {
						sChildName = sChildName  + sOccupationPlace.trim();						
					}
				}
				else if (sChildName.startsWith("Map: "))  {
					if      ( (sOccupationLati == null) || (sOccupationLati.length() <= 0) ) {
						sChildName = sChildName.replace("Lat: ", "Lat: "  );						
					}
					else if ( (sOccupationLati != null) && (sOccupationLati.length() > 0) )  {
						sChildName = sChildName.replace("Lat: ", "Lat: " + sOccupationLati.trim());												
					}			
					if      ( (sOccupationLong == null) || (sOccupationLong.length() <= 0) ) {
						sChildName = sChildName.replace("Long: ", " Long: " );						
					}
					else if ( (sOccupationLong != null) && (sOccupationLong.length() > 0) )  {
						sChildName = sChildName.replace("Long: ", " Long: " + sOccupationLong.trim());						
					}
				}
				else if (sChildName.startsWith("Address: ")) {
					if      ( (sOccupationAddress == null) || (sOccupationAddress.length() <= 0) ) {			
						sChildName = sChildName ;
					}
					else if ( (sOccupationAddress != null) && (sOccupationAddress.length() > 0) ) {
						sChildName = sChildName  + sOccupationAddress.trim();						
					}
				}
				else if (sChildName.startsWith("Address Contd: ")) {
					if      ( (sOccupationAddressContd == null) || (sOccupationAddressContd.length() <= 0) ) {			
						sChildName = sChildName ;
					}
					else if ( (sOccupationAddressContd != null) && (sOccupationAddressContd.length() > 0) ) {
						sChildName = sChildName  + sOccupationAddressContd.trim();						
					}
				}
				else if (sChildName.startsWith("Address 1: ")) {
					if      ( (sOccupationAddress1 == null) || (sOccupationAddress1.length() <= 0) ) {			
						sChildName = sChildName ;
					}
					else if ( (sOccupationAddress1 != null) && (sOccupationAddress1.length() > 0) ) {
						sChildName = sChildName  + sOccupationAddress1.trim();						
					}
				}
				else if (sChildName.startsWith("Address 1 Contd: ")) {
					if      ( (sOccupationAddress1Contd == null) || (sOccupationAddress1Contd.length() <= 0) ) {			
						sChildName = sChildName ;
					}
					else if ( (sOccupationAddress1Contd != null) && (sOccupationAddress1Contd.length() > 0) ) {
						sChildName = sChildName  + sOccupationAddress1Contd.trim();						
					}
				}
				else if (sChildName.startsWith("City: ")) {
					if      ( (sOccupationCity == null) || (sOccupationCity.length() <= 0) ) {			
						sChildName = sChildName ;
					}
					else if ( (sOccupationCity != null) && (sOccupationCity.length() > 0) ) {
						sChildName = sChildName  + sOccupationCity.trim();						
					}
				}
				else if (sChildName.startsWith("State: ")) {
					if      ( (sOccupationState == null) || (sOccupationState.length() <= 0) ) {			
						sChildName = sChildName ;
					}
					else if ( (sOccupationState != null) && (sOccupationState.length() > 0) ) {
						sChildName = sChildName  + sOccupationState.trim();						
					}
				}
				else if (sChildName.startsWith("Post code: ")) {
					if      ( (sOccupationPostCode == null) || (sOccupationPostCode.length() <= 0) ) {			
						sChildName = sChildName ;
					}
					else if ( (sOccupationPostCode != null) && (sOccupationPostCode.length() > 0) ) {
						sChildName = sChildName  + sOccupationPostCode.trim();						
					}
				}
				else if (sChildName.startsWith("Country: ")) {
					if      ( (sOccupationCountry == null) || (sOccupationCountry.length() <= 0) ) {			
						sChildName = sChildName ;
					}
					else if ( (sOccupationCountry != null) && (sOccupationCountry.length() > 0) ) {
						sChildName = sChildName  + sOccupationCountry.trim();						
					}
				}				
				else if (sChildName.startsWith("Type: ")) {
					if      ( (sOccupationType == null) || (sOccupationType.length() <= 0) ) {			
						sChildName = sChildName ;
					}
					else if ( (sOccupationType != null) && (sOccupationType.length() > 0) ) {
						sChildName = sChildName  + sOccupationType.trim();						
					}
				}				
				else if (sChildName.startsWith("Occupation: ")) {
					if      ( (sOccupation == null) || (sOccupation.length() <= 0) ) {			
						sChildName = sChildName ;
					}
					else if ( (sOccupation != null) && (sOccupation.length() > 0) ) {
						sChildName = sChildName  + sOccupation.trim();						
					}
				}				
			}
			else {
				DisplayChild = false;
				if ( (sChildName.startsWith("Date: "))  && (sOccupationDate != null) && (sOccupationDate.length() > 0) ) {
					sChildName = sChildName  + sOccupationDate.trim();
					DisplayChild = true;
				}
				else if ( (sChildName.startsWith("Place: ")) && (sOccupationPlace != null) && (sOccupationPlace.length() > 0) ) {
					sChildName = sChildName  + sOccupationPlace.trim();
					DisplayChild = true;
				}
				else if ( (sChildName.startsWith("Map: "))  && (sOccupationLati != null) && (sOccupationLati.length() > 0) && (sOccupationLong != null) && (sOccupationLong.length() > 0)    ) {
					sChildName = sChildName.replace("Lat: ", "Lat: " + sOccupationLati.trim() + " " );
					sChildName = sChildName.replace("Long: ", "Long: " + sOccupationLong.trim());
					DisplayChild = true;
				}
				else if ( (sChildName.startsWith("Address: ")) && (sOccupationAddress != null) && (sOccupationAddress.length() > 0) ) {
					sChildName = sChildName  + sOccupationAddress.trim();	
					DisplayChild = true;
				}
				else if ( (sChildName.startsWith("Address Contd: ")) && (sOccupationAddressContd != null) && (sOccupationAddressContd.length() > 0) ) {
					sChildName = sChildName  + sOccupationAddressContd.trim();	
					DisplayChild = true;
				}
				else if ( (sChildName.startsWith("Address 1: ")) && (sOccupationAddress1 != null) && (sOccupationAddress1.length() > 0) ) {
					sChildName = sChildName  + sOccupationAddress1.trim();	
					DisplayChild = true;
				}
				else if ( (sChildName.startsWith("Address 1 Contd: ")) && (sOccupationAddress1Contd != null) && (sOccupationAddress1Contd.length() > 0) ) {
					sChildName = sChildName  + sOccupationAddress1Contd.trim();	
					DisplayChild = true;
				}
				else if ( (sChildName.startsWith("City: ")) && (sOccupationCity != null) && (sOccupationCity.length() > 0) ) {
					sChildName = sChildName  + sOccupationCity.trim();	
					DisplayChild = true;
				}
				else if ( (sChildName.startsWith("State: ")) && (sOccupationState != null) && (sOccupationState.length() > 0) ) {
					sChildName = sChildName  + sOccupationState.trim();	
					DisplayChild = true;
				}
				else if ( (sChildName.startsWith("Post code: ")) && (sOccupationPostCode != null) && (sOccupationPostCode.length() > 0) ) {
					sChildName = sChildName  + sOccupationPostCode.trim();	
					DisplayChild = true;
				}
				else if ( (sChildName.startsWith("Country: ")) && (sOccupationCountry != null) && (sOccupationCountry.length() > 0) ) {
					sChildName = sChildName  + sOccupationCountry.trim();	
					DisplayChild = true;
				}				
				else if ( (sChildName.startsWith("Type: ")) && (sOccupationType != null) && (sOccupationType.length() > 0) ) {
					sChildName = sChildName  + sOccupationType.trim();	
					DisplayChild = true;
				}				
				else if ( (sChildName.startsWith("Occupation: ")) && (sOccupation != null) && (sOccupation.length() > 0) ) {
					sChildName = sChildName  + sOccupation.trim();	
					DisplayChild = true;
				}				
			}

			if (DisplayChild) {
				ch_16_i.setName(sChildName);
				ch_16_i.setTag(null);
				list2.add(ch_16_i);
				DisplayGroup_gru_16 = true;
			}
			i++;
		}
		gru_16.setItems(list2);

		// other ie EVEN

		List OTHERList = new LinkedList();
		OTHERList      = new ArrayList();

		OTHERList.add("Event - other");
		OTHERList.addAll(EVENTList);

		list2 = new ArrayList<ExpandListChild>();

		ExpandListGroup gru_18 = new ExpandListGroup();
		boolean DisplayGroup_gru_18 = false;
		sSetName = (String) OTHERList.get(0);
		gru_18.setName(sSetName);
		iMax = OTHERList.size();
		i = 1;
		while (i < iMax) {		
			ExpandListChild ch_18_i = new ExpandListChild();	
			sChildName = (String) OTHERList.get(i);

			if ( DisplayMissing ) {				
				DisplayChild = true;
				if (sChildName.startsWith("Date: "))  {
					if      ( (sEventDate == null) || (sEventDate.length() <= 0) ) {			
						sChildName = sChildName ;
					}
					else if ( (sEventDate != null) && (sEventDate.length() > 0) ) {
						sChildName = sChildName  + sEventDate.trim();						
					}
				}
				else if (sChildName.startsWith("Place: ")) {
					if      ( (sEventPlace == null) || (sEventPlace.length() <= 0) ) {			
						sChildName = sChildName ;
					}
					else if ( (sEventPlace != null) && (sEventPlace.length() > 0) ) {
						sChildName = sChildName  + sEventPlace.trim();						
					}
				}
				else if (sChildName.startsWith("Map: "))  {
					if      ( (sEventLati == null) || (sEventLati.length() <= 0) ) {
						sChildName = sChildName.replace("Lat: ", "Lat: "  );						
					}
					else if ( (sEventLati != null) && (sEventLati.length() > 0) )  {
						sChildName = sChildName.replace("Lat: ", "Lat: " + sEventLati.trim());												
					}			
					if      ( (sEventLong == null) || (sEventLong.length() <= 0) ) {
						sChildName = sChildName.replace("Long: ", " Long: " );						
					}
					else if ( (sEventLong != null) && (sEventLong.length() > 0) )  {
						sChildName = sChildName.replace("Long: ", " Long: " + sEventLong.trim());						
					}
				}
				else if (sChildName.startsWith("Address: ")) {
					if      ( (sEventAddress == null) || (sEventAddress.length() <= 0) ) {			
						sChildName = sChildName ;
					}
					else if ( (sEventAddress != null) && (sEventAddress.length() > 0) ) {
						sChildName = sChildName  + sEventAddress.trim();						
					}
				}
				else if (sChildName.startsWith("Address Contd: ")) {
					if      ( (sEventAddressContd == null) || (sEventAddressContd.length() <= 0) ) {			
						sChildName = sChildName ;
					}
					else if ( (sEventAddressContd != null) && (sEventAddressContd.length() > 0) ) {
						sChildName = sChildName  + sEventAddressContd.trim();						
					}
				}
				else if (sChildName.startsWith("Address 1: ")) {
					if      ( (sEventAddress1 == null) || (sEventAddress1.length() <= 0) ) {			
						sChildName = sChildName ;
					}
					else if ( (sEventAddress1 != null) && (sEventAddress1.length() > 0) ) {
						sChildName = sChildName  + sEventAddress1.trim();						
					}
				}
				else if (sChildName.startsWith("Address 1 Contd: ")) {
					if      ( (sEventAddress1Contd == null) || (sEventAddress1Contd.length() <= 0) ) {			
						sChildName = sChildName ;
					}
					else if ( (sEventAddress1Contd != null) && (sEventAddress1Contd.length() > 0) ) {
						sChildName = sChildName  + sEventAddress1Contd.trim();						
					}
				}
				else if (sChildName.startsWith("City: ")) {
					if      ( (sEventCity == null) || (sEventCity.length() <= 0) ) {			
						sChildName = sChildName ;
					}
					else if ( (sEventCity != null) && (sEventCity.length() > 0) ) {
						sChildName = sChildName  + sEventCity.trim();						
					}
				}
				else if (sChildName.startsWith("State: ")) {
					if      ( (sEventState == null) || (sEventState.length() <= 0) ) {			
						sChildName = sChildName ;
					}
					else if ( (sEventState != null) && (sEventState.length() > 0) ) {
						sChildName = sChildName  + sEventState.trim();						
					}
				}
				else if (sChildName.startsWith("Post code: ")) {
					if      ( (sEventPostCode == null) || (sEventPostCode.length() <= 0) ) {			
						sChildName = sChildName ;
					}
					else if ( (sEventPostCode != null) && (sEventPostCode.length() > 0) ) {
						sChildName = sChildName  + sEventPostCode.trim();						
					}
				}
				else if (sChildName.startsWith("Country: ")) {
					if      ( (sEventCountry == null) || (sEventCountry.length() <= 0) ) {			
						sChildName = sChildName ;
					}
					else if ( (sEventCountry != null) && (sEventCountry.length() > 0) ) {
						sChildName = sChildName  + sEventCountry.trim();						
					}
				}				
				else if (sChildName.startsWith("Type: ")) {
					if      ( (sEventType == null) || (sEventType.length() <= 0) ) {			
						sChildName = sChildName ;
					}
					else if ( (sEventType != null) && (sEventType.length() > 0) ) {
						sChildName = sChildName  + sEventType.trim();						
					}
				}				
			}
			else {
				DisplayChild = false;
				if ( (sChildName.startsWith("Date: "))  && (sEventDate != null) && (sEventDate.length() > 0) ) {
					sChildName = sChildName  + sEventDate.trim();
					DisplayChild = true;
				}
				else if ( (sChildName.startsWith("Place: ")) && (sEventPlace != null) && (sEventPlace.length() > 0) ) {
					sChildName = sChildName  + sEventPlace.trim();
					DisplayChild = true;
				}
				else if ( (sChildName.startsWith("Map: "))  && (sEventLati != null) && (sEventLati.length() > 0) && (sEventLong != null) && (sEventLong.length() > 0)    ) {
					sChildName = sChildName.replace("Lat: ", "Lat: " + sEventLati.trim() + " " );
					sChildName = sChildName.replace("Long: ", "Long: " + sEventLong.trim());
					DisplayChild = true;
				}
				else if ( (sChildName.startsWith("Address: ")) && (sEventAddress != null) && (sEventAddress.length() > 0) ) {
					sChildName = sChildName  + sEventAddress.trim();	
					DisplayChild = true;
				}
				else if ( (sChildName.startsWith("Address Contd: ")) && (sEventAddressContd != null) && (sEventAddressContd.length() > 0) ) {
					sChildName = sChildName  + sEventAddressContd.trim();	
					DisplayChild = true;
				}
				else if ( (sChildName.startsWith("Address 1: ")) && (sEventAddress1 != null) && (sEventAddress1.length() > 0) ) {
					sChildName = sChildName  + sEventAddress1.trim();	
					DisplayChild = true;
				}
				else if ( (sChildName.startsWith("Address 1 Contd: ")) && (sEventAddress1Contd != null) && (sEventAddress1Contd.length() > 0) ) {
					sChildName = sChildName  + sEventAddress1Contd.trim();	
					DisplayChild = true;
				}
				else if ( (sChildName.startsWith("City: ")) && (sEventCity != null) && (sEventCity.length() > 0) ) {
					sChildName = sChildName  + sEventCity.trim();	
					DisplayChild = true;
				}
				else if ( (sChildName.startsWith("State: ")) && (sEventState != null) && (sEventState.length() > 0) ) {
					sChildName = sChildName  + sEventState.trim();	
					DisplayChild = true;
				}
				else if ( (sChildName.startsWith("Post code: ")) && (sEventPostCode != null) && (sEventPostCode.length() > 0) ) {
					sChildName = sChildName  + sEventPostCode.trim();	
					DisplayChild = true;
				}
				else if ( (sChildName.startsWith("Country: ")) && (sEventCountry != null) && (sEventCountry.length() > 0) ) {
					sChildName = sChildName  + sEventCountry.trim();	
					DisplayChild = true;
				}				
				else if ( (sChildName.startsWith("Type: ")) && (sEventType != null) && (sEventType.length() > 0) ) {
					sChildName = sChildName  + sEventType.trim();	
					DisplayChild = true;
				}				
			}

			if (DisplayChild) {
				ch_18_i.setName(sChildName);
				ch_18_i.setTag(null);
				list2.add(ch_18_i);
				DisplayGroup_gru_18 = true;
			}
			i++;
		}
		gru_18.setItems(list2);

		// residence

		List RESIDENCEList = new LinkedList();
		RESIDENCEList      = new ArrayList();

		RESIDENCEList.add("Event - residence");
		RESIDENCEList.addAll(EVENTList);

		list2 = new ArrayList<ExpandListChild>();

		ExpandListGroup gru_20 = new ExpandListGroup();
		boolean DisplayGroup_gru_20 = false;
		sSetName = (String) RESIDENCEList.get(0);
		gru_20.setName(sSetName);
		iMax = RESIDENCEList.size();
		i = 1;
		while (i < iMax) {		
			ExpandListChild ch_20_i = new ExpandListChild();	
			sChildName = (String) RESIDENCEList.get(i);

			if ( DisplayMissing ) {				
				DisplayChild = true;
				if (sChildName.startsWith("Date: "))  {
					if      ( (sResidenceDate == null) || (sResidenceDate.length() <= 0) ) {			
						sChildName = sChildName ;
					}
					else if ( (sResidenceDate != null) && (sResidenceDate.length() > 0) ) {
						sChildName = sChildName  + sResidenceDate.trim();						
					}
				}
				else if (sChildName.startsWith("Place: ")) {
					if      ( (sResidencePlace == null) || (sResidencePlace.length() <= 0) ) {			
						sChildName = sChildName ;
					}
					else if ( (sResidencePlace != null) && (sResidencePlace.length() > 0) ) {
						sChildName = sChildName  + sResidencePlace.trim();						
					}
				}
				else if (sChildName.startsWith("Map: "))  {
					if      ( (sResidenceLati == null) || (sResidenceLati.length() <= 0) ) {
						sChildName = sChildName.replace("Lat: ", "Lat: "  );						
					}
					else if ( (sResidenceLati != null) && (sResidenceLati.length() > 0) )  {
						sChildName = sChildName.replace("Lat: ", "Lat: " + sResidenceLati.trim());												
					}			
					if      ( (sResidenceLong == null) || (sResidenceLong.length() <= 0) ) {
						sChildName = sChildName.replace("Long: ", " Long: " );						
					}
					else if ( (sResidenceLong != null) && (sResidenceLong.length() > 0) )  {
						sChildName = sChildName.replace("Long: ", " Long: " + sResidenceLong.trim());						
					}
				}
				else if (sChildName.startsWith("Address: ")) {
					if      ( (sResidenceAddress == null) || (sResidenceAddress.length() <= 0) ) {			
						sChildName = sChildName ;
					}
					else if ( (sResidenceAddress != null) && (sResidenceAddress.length() > 0) ) {
						sChildName = sChildName  + sResidenceAddress.trim();						
					}
				}
				else if (sChildName.startsWith("Address Contd: ")) {
					if      ( (sResidenceAddressContd == null) || (sResidenceAddressContd.length() <= 0) ) {			
						sChildName = sChildName ;
					}
					else if ( (sResidenceAddressContd != null) && (sResidenceAddressContd.length() > 0) ) {
						sChildName = sChildName  + sResidenceAddressContd.trim();						
					}
				}
				else if (sChildName.startsWith("Address 1: ")) {
					if      ( (sResidenceAddress1 == null) || (sResidenceAddress1.length() <= 0) ) {			
						sChildName = sChildName ;
					}
					else if ( (sResidenceAddress1 != null) && (sResidenceAddress1.length() > 0) ) {
						sChildName = sChildName  + sResidenceAddress1.trim();						
					}
				}
				else if (sChildName.startsWith("Address 1 Contd: ")) {
					if      ( (sResidenceAddress1Contd == null) || (sResidenceAddress1Contd.length() <= 0) ) {			
						sChildName = sChildName ;
					}
					else if ( (sResidenceAddress1Contd != null) && (sResidenceAddress1Contd.length() > 0) ) {
						sChildName = sChildName  + sResidenceAddress1Contd.trim();						
					}
				}
				else if (sChildName.startsWith("City: ")) {
					if      ( (sResidenceCity == null) || (sResidenceCity.length() <= 0) ) {			
						sChildName = sChildName ;
					}
					else if ( (sResidenceCity != null) && (sResidenceCity.length() > 0) ) {
						sChildName = sChildName  + sResidenceCity.trim();						
					}
				}
				else if (sChildName.startsWith("State: ")) {
					if      ( (sResidenceState == null) || (sResidenceState.length() <= 0) ) {			
						sChildName = sChildName ;
					}
					else if ( (sResidenceState != null) && (sResidenceState.length() > 0) ) {
						sChildName = sChildName  + sResidenceState.trim();						
					}
				}
				else if (sChildName.startsWith("Post code: ")) {
					if      ( (sResidencePostCode == null) || (sResidencePostCode.length() <= 0) ) {			
						sChildName = sChildName ;
					}
					else if ( (sResidencePostCode != null) && (sResidencePostCode.length() > 0) ) {
						sChildName = sChildName  + sResidencePostCode.trim();						
					}
				}
				else if (sChildName.startsWith("Country: ")) {
					if      ( (sResidenceCountry == null) || (sResidenceCountry.length() <= 0) ) {			
						sChildName = sChildName ;
					}
					else if ( (sResidenceCountry != null) && (sResidenceCountry.length() > 0) ) {
						sChildName = sChildName  + sResidenceCountry.trim();						
					}
				}				
				else if (sChildName.startsWith("Type: ")) {
					if      ( (sResidenceType == null) || (sResidenceType.length() <= 0) ) {			
						sChildName = sChildName ;
					}
					else if ( (sResidenceType != null) && (sResidenceType.length() > 0) ) {
						sChildName = sChildName  + sResidenceType.trim();						
					}
				}				
			}
			else {
				DisplayChild = false;
				if ( (sChildName.startsWith("Date: "))  && (sResidenceDate != null) && (sResidenceDate.length() > 0) ) {
					sChildName = sChildName  + sResidenceDate.trim();
					DisplayChild = true;
				}
				else if ( (sChildName.startsWith("Place: ")) && (sResidencePlace != null) && (sResidencePlace.length() > 0) ) {
					sChildName = sChildName  + sResidencePlace.trim();
					DisplayChild = true;
				}
				else if ( (sChildName.startsWith("Map: "))  && (sResidenceLati != null) && (sResidenceLati.length() > 0) && (sResidenceLong != null) && (sResidenceLong.length() > 0)    ) {
					sChildName = sChildName.replace("Lat: ", "Lat: " + sResidenceLati.trim() + " " );
					sChildName = sChildName.replace("Long: ", "Long: " + sResidenceLong.trim());
					DisplayChild = true;
				}
				else if ( (sChildName.startsWith("Address: ")) && (sResidenceAddress != null) && (sResidenceAddress.length() > 0) ) {
					sChildName = sChildName  + sResidenceAddress.trim();	
					DisplayChild = true;
				}
				else if ( (sChildName.startsWith("Address Contd: ")) && (sResidenceAddressContd != null) && (sResidenceAddressContd.length() > 0) ) {
					sChildName = sChildName  + sResidenceAddressContd.trim();	
					DisplayChild = true;
				}
				else if ( (sChildName.startsWith("Address 1: ")) && (sResidenceAddress1 != null) && (sResidenceAddress1.length() > 0) ) {
					sChildName = sChildName  + sResidenceAddress1.trim();	
					DisplayChild = true;
				}
				else if ( (sChildName.startsWith("Address 1 Contd: ")) && (sResidenceAddress1Contd != null) && (sResidenceAddress1Contd.length() > 0) ) {
					sChildName = sChildName  + sResidenceAddress1Contd.trim();	
					DisplayChild = true;
				}
				else if ( (sChildName.startsWith("City: ")) && (sResidenceCity != null) && (sResidenceCity.length() > 0) ) {
					sChildName = sChildName  + sResidenceCity.trim();	
					DisplayChild = true;
				}
				else if ( (sChildName.startsWith("State: ")) && (sResidenceState != null) && (sResidenceState.length() > 0) ) {
					sChildName = sChildName  + sResidenceState.trim();	
					DisplayChild = true;
				}
				else if ( (sChildName.startsWith("Post code: ")) && (sResidencePostCode != null) && (sResidencePostCode.length() > 0) ) {
					sChildName = sChildName  + sResidencePostCode.trim();	
					DisplayChild = true;
				}
				else if ( (sChildName.startsWith("Country: ")) && (sResidenceCountry != null) && (sResidenceCountry.length() > 0) ) {
					sChildName = sChildName  + sResidenceCountry.trim();	
					DisplayChild = true;
				}				
				else if ( (sChildName.startsWith("Type: ")) && (sResidenceType != null) && (sResidenceType.length() > 0) ) {
					sChildName = sChildName  + sResidenceType.trim();	
					DisplayChild = true;
				}				
			}

			if (DisplayChild) {
				ch_20_i.setName(sChildName);
				ch_20_i.setTag(null);
				list2.add(ch_20_i);
				DisplayGroup_gru_20 = true;
			}
			i++;
		}
		gru_20.setItems(list2);

		// note

		List NOTEList = new LinkedList();
		NOTEList      = new ArrayList();

		NOTEList.add("Event - note");
		NOTEList.addAll(EVENTList);

		list2 = new ArrayList<ExpandListChild>();

		ExpandListGroup gru_22 = new ExpandListGroup();
		boolean DisplayGroup_gru_22 = false;
		sSetName = (String) NOTEList.get(0);
		gru_22.setName(sSetName);
		iMax = NOTEList.size();
		i = 1;
		while (i < iMax) {		
			ExpandListChild ch_22_i = new ExpandListChild();	
			sChildName = (String) NOTEList.get(i);

			if ( DisplayMissing ) {				
				DisplayChild = true;
				if (sChildName.startsWith("Date: "))  {
					if      ( (sNoteDate == null) || (sNoteDate.length() <= 0) ) {			
						sChildName = sChildName ;
					}
					else if ( (sNoteDate != null) && (sNoteDate.length() > 0) ) {
						sChildName = sChildName  + sNoteDate.trim();						
					}
				}
				else if (sChildName.startsWith("Place: ")) {
					if      ( (sNotePlace == null) || (sNotePlace.length() <= 0) ) {			
						sChildName = sChildName ;
					}
					else if ( (sNotePlace != null) && (sNotePlace.length() > 0) ) {
						sChildName = sChildName  + sNotePlace.trim();						
					}
				}
				else if (sChildName.startsWith("Map: "))  {
					if      ( (sNoteLati == null) || (sNoteLati.length() <= 0) ) {
						sChildName = sChildName.replace("Lat: ", "Lat: "  );						
					}
					else if ( (sNoteLati != null) && (sNoteLati.length() > 0) )  {
						sChildName = sChildName.replace("Lat: ", "Lat: " + sNoteLati.trim());												
					}			
					if      ( (sNoteLong == null) || (sNoteLong.length() <= 0) ) {
						sChildName = sChildName.replace("Long: ", " Long: " );						
					}
					else if ( (sNoteLong != null) && (sNoteLong.length() > 0) )  {
						sChildName = sChildName.replace("Long: ", " Long: " + sNoteLong.trim());						
					}
				}
				else if (sChildName.startsWith("Address: ")) {
					if      ( (sNoteAddress == null) || (sNoteAddress.length() <= 0) ) {			
						sChildName = sChildName ;
					}
					else if ( (sNoteAddress != null) && (sNoteAddress.length() > 0) ) {
						sChildName = sChildName  + sNoteAddress.trim();						
					}
				}
				else if (sChildName.startsWith("Address Contd: ")) {
					if      ( (sNoteAddressContd == null) || (sNoteAddressContd.length() <= 0) ) {			
						sChildName = sChildName ;
					}
					else if ( (sNoteAddressContd != null) && (sNoteAddressContd.length() > 0) ) {
						sChildName = sChildName  + sNoteAddressContd.trim();						
					}
				}
				else if (sChildName.startsWith("Address 1: ")) {
					if      ( (sNoteAddress1 == null) || (sNoteAddress1.length() <= 0) ) {			
						sChildName = sChildName ;
					}
					else if ( (sNoteAddress1 != null) && (sNoteAddress1.length() > 0) ) {
						sChildName = sChildName  + sNoteAddress1.trim();						
					}
				}
				else if (sChildName.startsWith("Address 1 Contd: ")) {
					if      ( (sNoteAddress1Contd == null) || (sNoteAddress1Contd.length() <= 0) ) {			
						sChildName = sChildName ;
					}
					else if ( (sNoteAddress1Contd != null) && (sNoteAddress1Contd.length() > 0) ) {
						sChildName = sChildName  + sNoteAddress1Contd.trim();						
					}
				}
				else if (sChildName.startsWith("City: ")) {
					if      ( (sNoteCity == null) || (sNoteCity.length() <= 0) ) {			
						sChildName = sChildName ;
					}
					else if ( (sNoteCity != null) && (sNoteCity.length() > 0) ) {
						sChildName = sChildName  + sNoteCity.trim();						
					}
				}
				else if (sChildName.startsWith("State: ")) {
					if      ( (sNoteState == null) || (sNoteState.length() <= 0) ) {			
						sChildName = sChildName ;
					}
					else if ( (sNoteState != null) && (sNoteState.length() > 0) ) {
						sChildName = sChildName  + sNoteState.trim();						
					}
				}
				else if (sChildName.startsWith("Post code: ")) {
					if      ( (sNotePostCode == null) || (sNotePostCode.length() <= 0) ) {			
						sChildName = sChildName ;
					}
					else if ( (sNotePostCode != null) && (sNotePostCode.length() > 0) ) {
						sChildName = sChildName  + sNotePostCode.trim();						
					}
				}
				else if (sChildName.startsWith("Country: ")) {
					if      ( (sNoteCountry == null) || (sNoteCountry.length() <= 0) ) {			
						sChildName = sChildName ;
					}
					else if ( (sNoteCountry != null) && (sNoteCountry.length() > 0) ) {
						sChildName = sChildName  + sNoteCountry.trim();						
					}
				}				
				else if (sChildName.startsWith("Type: ")) {
					if      ( (sNoteType == null) || (sNoteType.length() <= 0) ) {			
						sChildName = sChildName ;
					}
					else if ( (sNoteType != null) && (sNoteType.length() > 0) ) {
						sChildName = sChildName  + sNoteType.trim();						
					}
				}				
			}
			else {
				DisplayChild = false;
				if ( (sChildName.startsWith("Date: "))  && (sNoteDate != null) && (sNoteDate.length() > 0) ) {
					sChildName = sChildName  + sNoteDate.trim();
					DisplayChild = true;
				}
				else if ( (sChildName.startsWith("Place: ")) && (sNotePlace != null) && (sNotePlace.length() > 0) ) {
					sChildName = sChildName  + sNotePlace.trim();
					DisplayChild = true;
				}
				else if ( (sChildName.startsWith("Map: "))  && (sNoteLati != null) && (sNoteLati.length() > 0) && (sNoteLong != null) && (sNoteLong.length() > 0)    ) {
					sChildName = sChildName.replace("Lat: ", "Lat: " + sNoteLati.trim() + " " );
					sChildName = sChildName.replace("Long: ", "Long: " + sNoteLong.trim());
					DisplayChild = true;
				}
				else if ( (sChildName.startsWith("Address: ")) && (sNoteAddress != null) && (sNoteAddress.length() > 0) ) {
					sChildName = sChildName  + sNoteAddress.trim();	
					DisplayChild = true;
				}
				else if ( (sChildName.startsWith("Address Contd: ")) && (sNoteAddressContd != null) && (sNoteAddressContd.length() > 0) ) {
					sChildName = sChildName  + sNoteAddressContd.trim();	
					DisplayChild = true;
				}
				else if ( (sChildName.startsWith("Address 1: ")) && (sNoteAddress1 != null) && (sNoteAddress1.length() > 0) ) {
					sChildName = sChildName  + sNoteAddress1.trim();	
					DisplayChild = true;
				}
				else if ( (sChildName.startsWith("Address 1 Contd: ")) && (sNoteAddress1Contd != null) && (sNoteAddress1Contd.length() > 0) ) {
					sChildName = sChildName  + sNoteAddress1Contd.trim();	
					DisplayChild = true;
				}
				else if ( (sChildName.startsWith("City: ")) && (sNoteCity != null) && (sNoteCity.length() > 0) ) {
					sChildName = sChildName  + sNoteCity.trim();	
					DisplayChild = true;
				}
				else if ( (sChildName.startsWith("State: ")) && (sNoteState != null) && (sNoteState.length() > 0) ) {
					sChildName = sChildName  + sNoteState.trim();	
					DisplayChild = true;
				}
				else if ( (sChildName.startsWith("Post code: ")) && (sNotePostCode != null) && (sNotePostCode.length() > 0) ) {
					sChildName = sChildName  + sNotePostCode.trim();	
					DisplayChild = true;
				}
				else if ( (sChildName.startsWith("Country: ")) && (sNoteCountry != null) && (sNoteCountry.length() > 0) ) {
					sChildName = sChildName  + sNoteCountry.trim();	
					DisplayChild = true;
				}				
				else if ( (sChildName.startsWith("Type: ")) && (sNoteType != null) && (sNoteType.length() > 0) ) {
					sChildName = sChildName  + sNoteType.trim();	
					DisplayChild = true;
				}				
			}

			if (DisplayChild) {
				ch_22_i.setName(sChildName);
				ch_22_i.setTag(null);
				list2.add(ch_22_i);
				DisplayGroup_gru_22 = true;
			}
			i++;
		}
		gru_22.setItems(list2);

		// source

		List SOURCEList = new LinkedList();
		SOURCEList      = new ArrayList();

		SOURCEList.add("Event - source");
		SOURCEList.addAll(EVENTList);

		list2 = new ArrayList<ExpandListChild>();

		ExpandListGroup gru_24 = new ExpandListGroup();
		boolean DisplayGroup_gru_24 = false;
		sSetName = (String) SOURCEList.get(0);
		gru_24.setName(sSetName);
		iMax = SOURCEList.size();
		i = 1;
		while (i < iMax) {		
			ExpandListChild ch_24_i = new ExpandListChild();	
			sChildName = (String) SOURCEList.get(i);

			if ( DisplayMissing ) {				
				DisplayChild = true;
				if (sChildName.startsWith("Date: "))  {
					if      ( (sSourceDate == null) || (sSourceDate.length() <= 0) ) {			
						sChildName = sChildName ;
					}
					else if ( (sSourceDate != null) && (sSourceDate.length() > 0) ) {
						sChildName = sChildName  + sSourceDate.trim();						
					}
				}
				else if (sChildName.startsWith("Place: ")) {
					if      ( (sSourcePlace == null) || (sSourcePlace.length() <= 0) ) {			
						sChildName = sChildName ;
					}
					else if ( (sSourcePlace != null) && (sSourcePlace.length() > 0) ) {
						sChildName = sChildName  + sSourcePlace.trim();						
					}
				}
				else if (sChildName.startsWith("Map: "))  {
					if      ( (sSourceLati == null) || (sSourceLati.length() <= 0) ) {
						sChildName = sChildName.replace("Lat: ", "Lat: "  );						
					}
					else if ( (sSourceLati != null) && (sSourceLati.length() > 0) )  {
						sChildName = sChildName.replace("Lat: ", "Lat: " + sSourceLati.trim());												
					}			
					if      ( (sSourceLong == null) || (sSourceLong.length() <= 0) ) {
						sChildName = sChildName.replace("Long: ", " Long: " );						
					}
					else if ( (sSourceLong != null) && (sSourceLong.length() > 0) )  {
						sChildName = sChildName.replace("Long: ", " Long: " + sSourceLong.trim());						
					}
				}
				else if (sChildName.startsWith("Address: ")) {
					if      ( (sSourceAddress == null) || (sSourceAddress.length() <= 0) ) {			
						sChildName = sChildName ;
					}
					else if ( (sSourceAddress != null) && (sSourceAddress.length() > 0) ) {
						sChildName = sChildName  + sSourceAddress.trim();						
					}
				}
				else if (sChildName.startsWith("Address Contd: ")) {
					if      ( (sSourceAddressContd == null) || (sSourceAddressContd.length() <= 0) ) {			
						sChildName = sChildName ;
					}
					else if ( (sSourceAddressContd != null) && (sSourceAddressContd.length() > 0) ) {
						sChildName = sChildName  + sSourceAddressContd.trim();						
					}
				}
				else if (sChildName.startsWith("Address 1: ")) {
					if      ( (sSourceAddress1 == null) || (sSourceAddress1.length() <= 0) ) {			
						sChildName = sChildName ;
					}
					else if ( (sSourceAddress1 != null) && (sSourceAddress1.length() > 0) ) {
						sChildName = sChildName  + sSourceAddress1.trim();						
					}
				}
				else if (sChildName.startsWith("Address 1 Contd: ")) {
					if      ( (sSourceAddress1Contd == null) || (sSourceAddress1Contd.length() <= 0) ) {			
						sChildName = sChildName ;
					}
					else if ( (sSourceAddress1Contd != null) && (sSourceAddress1Contd.length() > 0) ) {
						sChildName = sChildName  + sSourceAddress1Contd.trim();						
					}
				}
				else if (sChildName.startsWith("City: ")) {
					if      ( (sSourceCity == null) || (sSourceCity.length() <= 0) ) {			
						sChildName = sChildName ;
					}
					else if ( (sSourceCity != null) && (sSourceCity.length() > 0) ) {
						sChildName = sChildName  + sSourceCity.trim();						
					}
				}
				else if (sChildName.startsWith("State: ")) {
					if      ( (sSourceState == null) || (sSourceState.length() <= 0) ) {			
						sChildName = sChildName ;
					}
					else if ( (sSourceState != null) && (sSourceState.length() > 0) ) {
						sChildName = sChildName  + sSourceState.trim();						
					}
				}
				else if (sChildName.startsWith("Post code: ")) {
					if      ( (sSourcePostCode == null) || (sSourcePostCode.length() <= 0) ) {			
						sChildName = sChildName ;
					}
					else if ( (sSourcePostCode != null) && (sSourcePostCode.length() > 0) ) {
						sChildName = sChildName  + sSourcePostCode.trim();						
					}
				}
				else if (sChildName.startsWith("Country: ")) {
					if      ( (sSourceCountry == null) || (sSourceCountry.length() <= 0) ) {			
						sChildName = sChildName ;
					}
					else if ( (sSourceCountry != null) && (sSourceCountry.length() > 0) ) {
						sChildName = sChildName  + sSourceCountry.trim();						
					}
				}				
				else if (sChildName.startsWith("Type: ")) {
					if      ( (sSourceType == null) || (sSourceType.length() <= 0) ) {			
						sChildName = sChildName ;
					}
					else if ( (sSourceType != null) && (sSourceType.length() > 0) ) {
						sChildName = sChildName  + sSourceType.trim();						
					}
				}				
			}
			else {
				DisplayChild = false;
				if ( (sChildName.startsWith("Date: "))  && (sSourceDate != null) && (sSourceDate.length() > 0) ) {
					sChildName = sChildName  + sSourceDate.trim();
					DisplayChild = true;
				}
				else if ( (sChildName.startsWith("Place: ")) && (sSourcePlace != null) && (sSourcePlace.length() > 0) ) {
					sChildName = sChildName  + sSourcePlace.trim();
					DisplayChild = true;
				}
				else if ( (sChildName.startsWith("Map: "))  && (sSourceLati != null) && (sSourceLati.length() > 0) && (sSourceLong != null) && (sSourceLong.length() > 0)    ) {
					sChildName = sChildName.replace("Lat: ", "Lat: " + sSourceLati.trim() + " " );
					sChildName = sChildName.replace("Long: ", "Long: " + sSourceLong.trim());
					DisplayChild = true;
				}
				else if ( (sChildName.startsWith("Address: ")) && (sSourceAddress != null) && (sSourceAddress.length() > 0) ) {
					sChildName = sChildName  + sSourceAddress.trim();	
					DisplayChild = true;
				}
				else if ( (sChildName.startsWith("Address Contd: ")) && (sSourceAddressContd != null) && (sSourceAddressContd.length() > 0) ) {
					sChildName = sChildName  + sSourceAddressContd.trim();	
					DisplayChild = true;
				}
				else if ( (sChildName.startsWith("Address 1: ")) && (sSourceAddress1 != null) && (sSourceAddress1.length() > 0) ) {
					sChildName = sChildName  + sSourceAddress1.trim();	
					DisplayChild = true;
				}
				else if ( (sChildName.startsWith("Address 1 Contd: ")) && (sSourceAddress1Contd != null) && (sSourceAddress1Contd.length() > 0) ) {
					sChildName = sChildName  + sSourceAddress1Contd.trim();	
					DisplayChild = true;
				}
				else if ( (sChildName.startsWith("City: ")) && (sSourceCity != null) && (sSourceCity.length() > 0) ) {
					sChildName = sChildName  + sSourceCity.trim();	
					DisplayChild = true;
				}
				else if ( (sChildName.startsWith("State: ")) && (sSourceState != null) && (sSourceState.length() > 0) ) {
					sChildName = sChildName  + sSourceState.trim();	
					DisplayChild = true;
				}
				else if ( (sChildName.startsWith("Post code: ")) && (sSourcePostCode != null) && (sSourcePostCode.length() > 0) ) {
					sChildName = sChildName  + sSourcePostCode.trim();	
					DisplayChild = true;
				}
				else if ( (sChildName.startsWith("Country: ")) && (sSourceCountry != null) && (sSourceCountry.length() > 0) ) {
					sChildName = sChildName  + sSourceCountry.trim();	
					DisplayChild = true;
				}				
				else if ( (sChildName.startsWith("Type: ")) && (sSourceType != null) && (sSourceType.length() > 0) ) {
					sChildName = sChildName  + sSourceType.trim();	
					DisplayChild = true;
				}				
			}

			if (DisplayChild) {
				ch_24_i.setName(sChildName);
				ch_24_i.setTag(null);
				list2.add(ch_24_i);
				DisplayGroup_gru_24 = true;
			}
			i++;
		}
		gru_24.setItems(list2);

		if (DisplayGroup_gru_01 ) { list.add(gru_01); }
		if (DisplayGroup_gru_02 ) { list.add(gru_02); }
		if (DisplayGroup_gru_04 ) { list.add(gru_04); }
		if (DisplayGroup_gru_06 ) { list.add(gru_06); }
		if (DisplayGroup_gru_08 ) { list.add(gru_08); }
		if (DisplayGroup_gru_10 ) { list.add(gru_10); }
		if (DisplayGroup_gru_12 ) { list.add(gru_12); }
		if (DisplayGroup_gru_14 ) { list.add(gru_14); }
		if (DisplayGroup_gru_16 ) { list.add(gru_16); }
		if (DisplayGroup_gru_18 ) { list.add(gru_18); }
		if (DisplayGroup_gru_20 ) { list.add(gru_20); }
		if (DisplayGroup_gru_22 ) { list.add(gru_22); }
		if (DisplayGroup_gru_24 ) { list.add(gru_24); }

		return list;
	}

	/** Christening details **/

    public void detailsChristening(String st) {

        // Log.i(sFragmentName, "detailsChristening()");

        if (st.startsWith("1 CHR")) {
            sFlag = "chr";
            Log.i(sFragmentName, "detailsChristening() - find somewhere to put text to RHS of 1 CHR");
        }
        else if ((sFlag == "chr") && (st.startsWith("2 TYPE"))) {
            sChristeningType = st.substring(prefix,st.length());
        }
        else if ((sFlag == "chr") && (st.startsWith("2 DATE"))) {
            sChristeningDate = st.substring(prefix,st.length());
        }
        else if ((sFlag == "chr") && (st.startsWith("2 PLAC"))) {
            sChristeningPlace = st.substring(prefix + 1,st.length());
        }
        else if ((sFlag == "chr") && (st.startsWith("3 MAP"))) {
            sChristeningMap = "Map";
        }
        else if ((sFlag == "chr") && (st.startsWith("4 LATI"))) {
            sChristeningLati = st.substring(prefix,st.length());
        }
        else if ((sFlag == "chr") && (st.startsWith("4 LONG"))) {
            sChristeningLong = st.substring(prefix,st.length());
        }
        else if ((sFlag == "chr") && (st.startsWith("2 ADDR"))) {
            sChristeningAddress = st.substring(prefix,st.length());
        }
        else if ((sFlag == "chr") && (st.startsWith("3 CONT"))) {
            sChristeningAddressContd = st.substring(prefix,st.length());
        }
        else if ((sFlag == "chr") && (st.startsWith("3 ADR1"))) {
            sChristeningAddress1 = st.substring(prefix,st.length());
        }
        else if ((sFlag == "chr") && (st.startsWith("4 CONT "))) {
            sChristeningAddress1Contd = st.substring(prefix,st.length());
        }
        else if ((sFlag == "chr") && (st.startsWith("3 CITY"))) {
            sChristeningCity = st.substring(prefix,st.length());
        }
        else if ((sFlag == "chr") && (st.startsWith("3 STAE"))) {
            sChristeningState = st.substring(prefix,st.length());
        }
        else if ((sFlag == "chr") && (st.startsWith("3 POST"))) {
            sChristeningPostCode = st.substring(prefix,st.length());
        }
        else if ((sFlag == "chr") && (st.startsWith("3 CTRY"))) {
            sChristeningCountry = st.substring(prefix,st.length());
        }

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
