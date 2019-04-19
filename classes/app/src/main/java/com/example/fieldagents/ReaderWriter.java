package com.example.fieldagents;

import android.content.res.AssetManager;
import android.content.*;
import android.util.Log;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.File;
import java.io.InputStream;
import java.io.InputStreamReader;

//class that acts like SiteReader for Android Studio
public class ReaderWriter {


    /**Method will take a file, and create a new strign that has the contents of the file
     *
     * @param  f the file to be read
     * @return a String representation of a file
     */
    public static String stringFromStream(File f){


        try{
            BufferedReader reader = new BufferedReader(new FileReader(f));
            StringBuilder s = new StringBuilder();
            String currLine = null;

            while((currLine = reader.readLine()) != null) {
            //while(reader.readLine() != null){
                s.append(currLine);
                s.append("\n");
            }
            reader.close();

            System.out.println(s.toString());
            return s.toString();
        }
        catch(Exception e){
         e.printStackTrace();
        }

        return null;
    }
}
