package com.example.fieldagents;

import android.content.res.AssetManager;
import android.content.*;
import android.util.Log;

import org.json.simple.JSONObject;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import static android.os.Environment.getExternalStorageDirectory;

/**ReaderWriter is responsible for FILE I/O for our Android project
 * 
 */
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

    /**Method will write a JSON Object to a File
     *
     * @param content The JSON Object that will be serialized
     */
    public static void fileWriter(JSONObject content){
        File fileDir5 = getExternalStorageDirectory();
        File file5 = new File(fileDir5 + "/Download/json/example.json");
        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file5));
            bufferedWriter.write(content.toString());
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
