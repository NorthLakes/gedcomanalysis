package com.example.cliffhorwood.gedcomanalysis.Classes;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

import android.os.Environment;
import android.util.Log;

public class MyMethods {

	/**
	public boolean storeKeys(String sKey, String sSecret) {

		final String PREFS_NAME = "MyPrefsFile";
		final int MODE_PRIVATE;
		 
		// We need an Editor object to make preference changes.
		// All objects are from android.context.Context
		SharedPreferences settings = getPreferences(int 0);
		SharedPreferences.Editor editor = settings.edit();
		editor.putString("sKey", sKey);
		editor.putString("sSecret", sSecret);

		// Commit the edits!
		editor.commit();

        // Restore preferences
        SharedPreferences settings = getSharedPreferences(PREFS_NAME, 0);
        boolean silent = settings.getBoolean("silentMode", false);
        setSilent(silent);

		return true;
	}
		**/
	
	/**
	 * Returns a TRUE if the name is already in the list
	 * @param	IndvList	= array of Strings
	 * 			sName		= name to search the array for
	 * @return	namefound	
	 */
	public boolean NameExistsInArray(ArrayList<String> IndvList, String sName) {
		int z = 0;
		boolean namefound = false;

		// if (!sName.equals(" ")) {			// ignore empty names
			while (z < IndvList.size()) {
				String scratch2 = (String) IndvList.get(z);        				
				if (scratch2.equals(sName)) {            					
					namefound = true;        					        					
					z = IndvList.size();    // end the loop         					
				}
				z++;
			}
		//}
		
		return namefound;
	}

	/**
	 * Returns a string value which is the fully qualified external storage directory
	 * @return	sExtStorageDirectory	
	 */
	public String extStorageDir() {
		String sExtStorageDirectory = "/" + Environment.getExternalStorageDirectory().toString() + "/";
		return sExtStorageDirectory;
	}

	/* Checks if external storage is available for read and write */
	public boolean isExternalStorageWritable() {
		String state = Environment.getExternalStorageState();
		if (Environment.MEDIA_MOUNTED.equals(state)) {
			return true;
		}
		return false;
	}

	/* Checks if external storage is available to at least read */
	public boolean isExternalStorageReadable() {
		String state = Environment.getExternalStorageState();
		if (Environment.MEDIA_MOUNTED.equals(state) ||
				Environment.MEDIA_MOUNTED_READ_ONLY.equals(state)) {
			return true;
		}
		return false;
	}

	/**
	 * Returns an arraylist which contains each row from the nominated text file
	 * @param	newList				= array of Strings
	 * 			sFullyQualFileName	= nominated text file - fully qualified file name
	 * @return	newList				= the arraylist
	 */
	public ArrayList<String> LoadTextFileToArray(ArrayList<String> newList, String sFullyQualFileName) {	    	
		String str;
		String s;
		try {        	
			BufferedReader in = new BufferedReader(new FileReader(sFullyQualFileName));
			while ((str = in.readLine()) != null) {
				if (str.length() > 0) {
					s = trimEnd( str );					// remove trailing spaces - should be the only one required at the file level
					newList.add(s);
				}	
			}						
			in.close();

			int i = newList.size();

            String str1 = (String) newList.get(0);
            String str2 = (String) newList.get(i - 1);
            Log.i( "MyMethods", "LoadTextFileToArray - Size: " + i);
            Log.i( "MyMethods", "LoadTextFileToArray - First row: " + str1);
            Log.i( "MyMethods", "LoadTextFileToArray - Last row: " + str2);

        }
		catch( Exception error ) {
			Log.e( "MyMethods", "LoadTextFileToArray: " + error.toString() );
		}
		return (ArrayList<String>) newList;
	}

	/**
	 * Returns an arraylist which contains each row from the nominated arraylist for individuals
	 * @param	newList				= array of Strings
	 * 			IndividualList		= array of Strings
	 * @return	IndividualList		= the arraylist
	 */
	public ArrayList<String> LoadIndividualsToArray(ArrayList<String> IndividualList, ArrayList<String> newList) {	    	
		String str;
		String s;

		// process the array

		// Log.i( "MyMethods", "LoadIndividualsToArray - newList: " + newList.size() );

		int iz = 0;
		if ( newList.size() > iz ) {

			s = (String) newList.get(iz);				// get the first row
			str = trimEnd( s );							// remove trailing spaces
			
			// bypass everything until the first individual
			while ( (iz < newList.size()) && !(str.endsWith("@ INDI")) ) {
				// Log.e( "MyMethods", "LoadIndividualsToArray: " + iz + " " + str + "##");
				
				// get the next line if it exists
				iz++;
				if (iz < newList.size()) {
					s = (String) newList.get(iz);
					str = trimEnd( s );					// remove trailing spaces
				}
			}	

			IndividualList.add(str);
			// Log.e( "MyMethods", "LoadIndividualsToArray - IndividualList: " + IndividualList.size() );

			// get the next line if it exists
			iz++;
			if (iz < newList.size()) {
				s = (String) newList.get(iz);
				str = trimEnd( s );					// remove trailing spaces
			}

			while ( (iz < newList.size()) && !(str.startsWith("0 TRLR")) && !(str.endsWith("@ SOUR")) && !(str.endsWith("@ FAM")) && !(str.indexOf("@ NOTE") > 0) ) {
				IndividualList.add(str);

				// get the next line if it exists
				iz++;
				if (iz < newList.size()) {
					s = (String) newList.get(iz);
					str = trimEnd( s );					// remove trailing spaces
				}

			}				// while ( (i < newList.size()) &&

		}					// if ( newList.size() > i )

        int i = IndividualList.size();

        String str3 = (String) IndividualList.get(0);
        String str4 = (String) IndividualList.get(i - 1);
        Log.i( "MyMethods", "LoadIndividualsToArray - Size: " + i);
        Log.i( "MyMethods", "LoadIndividualsToArray - First row: " + str3);
        Log.i( "MyMethods", "LoadIndividualsToArray - Last row: " + str4);

        return (ArrayList<String>) IndividualList;
	}

	/**
	 * Returns an arraylist which contains each row from the nominated arraylist for families
	 * @param	newList			= array of Strings
	 * 			FamilyList		= array of Strings
	 * @return	FamilyList		= the arraylist
	 */
	public ArrayList<String> LoadFamilyToArray(ArrayList<String> FamilyList, ArrayList<String> newList) {	    	
		String str;

		// process the array

		Log.i( "MyMethods", "LoadFamilyToArray - newList: " + newList.size() );

		int iz2 = 0;
		if ( newList.size() > iz2 ) {

			str = (String) newList.get(iz2);				// get the first row

			// bypass everything until the first Family
			while ( (iz2 < newList.size()) && !(str.endsWith("@ FAM")) ) {
				iz2++;
				str = (String) newList.get(iz2);
			}	

			FamilyList.add(str);

			// get the next line if it exists
			iz2++;
			if (iz2 < newList.size()) {
				str = (String) newList.get(iz2);
			}

			while ( (iz2 < newList.size()) && !(str.startsWith("0 TRLR")) && !(str.endsWith("@ SOUR")) && !(str.indexOf("@ NOTE") > 0) ) {
				FamilyList.add(str);

				// get the next line if it exists
				iz2++;
				if (iz2 < newList.size()) {
					str = (String) newList.get(iz2);
				}

			}				// while ( (i < newList.size()) &&

		}					// if ( newList.size() > i )

		Log.i( "MyMethods", "LoadFamilyToArray - FamilyList:  " + FamilyList.size() );
		String str1 = (String) FamilyList.get(0);
		Log.i( "MyMethods", "LoadFamilyToArray - FamilyList:  " + str1 );
		int  st = FamilyList.size() - 1;
		String str2 = (String) FamilyList.get(st);
		Log.i( "MyMethods", "LoadFamilyToArray - FamilyList:  " + str2 );

		return (ArrayList<String>) FamilyList;
	}

	/**
	 * Returns an arraylist which contains each row from the nominated arraylist for sources
	 * @param	newList			= array of Strings
	 * 			SourceList		= array of Strings
	 * @return	SourceList		= the arraylist
	 */
	public ArrayList<String> LoadSourceToArray(ArrayList<String> SourceList, ArrayList<String> newList) {	    	
		String str;

		// process the array

		Log.i( "MyMethods", "LoadSourceToArray - newList: " + newList.size() );

		int iz2 = 0;
		if ( newList.size() > iz2 ) {

			str = (String) newList.get(iz2);				// get the first row

			// bypass everything until the first Source
			while ( (iz2 < newList.size()) && !(str.endsWith("@ SOUR")) ) {
				iz2++;
				str = (String) newList.get(iz2);
			}	

			SourceList.add(str);

			// get the next line if it exists
			iz2++;
			if (iz2 < newList.size()) {
				str = (String) newList.get(iz2);
			}

			while ( (iz2 < newList.size()) && !(str.startsWith("0 TRLR")) && !(str.indexOf("@ NOTE") > 0) ) {
				SourceList.add(str);

				// get the next line if it exists
				iz2++;
				if (iz2 < newList.size()) {
					str = (String) newList.get(iz2);
				}

			}				// while ( (i < newList.size()) &&

		}					// if ( newList.size() > i )

		Log.i( "MyMethods", "LoadSourceToArray - SourceList:  " + SourceList.size() );
		String str1 = (String) SourceList.get(0);
		Log.i( "MyMethods", "LoadSourceToArray - SourceList:  " + str1 );
		int  st = SourceList.size() - 1;
		String str2 = (String) SourceList.get(st);
		Log.i( "MyMethods", "LoadSourceToArray - SourceList:  " + str2 );

		return (ArrayList<String>) SourceList;
	}

	/**
	 * Returns an arraylist which contains each row from the nominated arraylist for notes
	 * @param	newList			= array of Strings
	 * 			NoteList		= array of Strings
	 * @return	NoteList		= the arraylist
	 */
	public ArrayList<String> LoadNoteToArray(ArrayList<String> NoteList, ArrayList<String> newList) {	    	
		String str;

		// process the array

		Log.i( "MyMethods", "LoadNoteToArray - newList: " + newList.size() );

		int iz2 = 0;
		if ( newList.size() > iz2 ) {

			str = (String) newList.get(iz2);				// get the first row

			// bypass everything until the first Note
			while ( (iz2 < newList.size()) && !(str.contains("@ NOTE")) ) {
				iz2++;
				str = (String) newList.get(iz2);
			}	

			NoteList.add(str);

			// get the next line if it exists
			iz2++;
			if (iz2 < newList.size()) {
				str = (String) newList.get(iz2);
			}

			while ( (iz2 < newList.size()) && !(str.startsWith("0 TRLR")) ) {
				NoteList.add(str);

				// get the next line if it exists
				iz2++;
				if (iz2 < newList.size()) {
					str = (String) newList.get(iz2);
				}

			}				// while ( (i < newList.size()) &&

		}					// if ( newList.size() > i )

		Log.i( "MyMethods", "LoadNoteToArray - NoteList:  " + NoteList.size() );
		String str1 = (String) NoteList.get(0);
		Log.i( "MyMethods", "LoadNoteToArray - NoteList:  " + str1 );
		int  st = NoteList.size() - 1;
		String str2 = (String) NoteList.get(st);
		Log.i( "MyMethods", "LoadNoteToArray - NoteList:  " + str2 );

		return (ArrayList<String>) NoteList;
	}

	/**
	 * Returns string with trailing spaces removed
	 */
	
	 public String trimEnd( String myString ) {

	    for ( int i = myString.length() - 1; i >= 0; --i ) {
	        if ( myString.charAt(i) == ' ' ) {
	            continue;
	        } else {
	            myString = myString.substring( 0, ( i + 1 ) );
	            break;
	        }
	    }
	    return myString;
	}
}
