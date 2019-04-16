package com.example.fieldagents;

import android.content.res.AssetManager;
import android.content.*;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

//class that acts like SiteReader for Android Studio
public class ReaderWriter {


    //Will look through all Android  assets to find the selected file(.json, xml etc)
    public static String obtainFile(Context c, String assetName) {
        AssetManager a = c.getAssets();

        try {
            InputStream i = a.open(assetName);

            String chosenFile = ReaderWriter.stringFromStream(i);
            i.close();
            return chosenFile;  //obtain the file

        } catch (Exception e) {
            e.printStackTrace();

        }
        return null;  //return null if file cannot be found
    }


    /**Method will take a file, and create a new strign that has the contents of the file
     *
     * @param  i InputStream
     * @return a String representation of a file
     */
    public static String stringFromStream(InputStream i){

        try{
            BufferedReader reader = new BufferedReader(new InputStreamReader(i));
            StringBuilder s = new StringBuilder();
            String currLine = null;

            while((currLine = reader.readLine()) != null) {
                s.append(currLine).append("\n");
            }
            reader.close();
        }
        catch(Exception e){

        }

        return null;
    }
}
