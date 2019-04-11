package com.example.fieldagents;

import android.content.res.AssetManager;
import android.content.*;

import java.io.InputStream;

//class that acts like SiteReader for Android Studio
public class ReaderWriter {


    //Will look through all Android  assets to find the selected file(.json, xml etc)
    public static String obtainFile(Context c, String assetName) {
        AssetManager a = c.getAssets();

        try {
            InputStream i = a.open(assetName);

            //ERROR HERE! CANNOT FIND SYMBOL METHOD STRINGFROMSTREAM(InputStream), is i an INPUTSTREAM object?
            String chosenFile = ReaderWriter.stringFromStream(i);
            i.close();
            return chosenFile;  //obtain the file

        } catch (Exception e) {
            e.printStackTrace();

        }
        return null;  //return null if file cannot be found
    }
}
