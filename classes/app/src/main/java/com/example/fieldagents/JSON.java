package com.example.fieldagents;
import ourClasses.*;

import android.app.Activity;
import android.content.Context;
import android.content.res.AssetManager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.*;
import android.content.Context;
import android.app.Activity;
//import android.app.Bundle;


import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.json.JSONArray;
import org.json.JSONObject;


import java.io.FileInputStream;
import java.io.IOException;
import java.io.*;
import java.util.*; //length()

import android.os.Bundle;

import java.io.FileNotFoundException;
import java.io.FileReader.*;


public class JSON  extends  Activity{

private static TextView txtJson;
private static Reading reading = new Reading("Midwest USA Climate 2017", "902","15566","particulate","1adf4",354.00,"1515354694451");

/*
@Override
protected void onCreate(Bundle savedInstanceState){

    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    txtJson = (TextView) findViewById(R.id.txtJson);
 }

*/


  //Method will get a parse through JSON file
    public String readJSON(){
       String temp = "";
         /**
        this is a Context in order to use the obtainFile method
          This
          */

        String jsonFile = ReaderWriter.obtainFile(this, "example.json"); //get the JSON file

        try{
            JSONArray siteRdgs = new JSONArray(jsonFile); //get the entire list of site readings

            //String temp  = "";
            for( int i = 0; i <siteRdgs.length(); i++){

                JSONObject reading = siteRdgs.getJSONObject(i); //get each reading in this file

                temp = temp +  "Site ID: "  + reading.getString("site_id") + "\n"
                        +   "Reading Type: " + reading.getString("reading_type") + "\n"
                        +   "Reading ID: " + reading.getString("reading_ID") + "\n"
                        +   "Reading Value: " + reading.getDouble("reading_value") + "\n"
                        +  "Reading Date:"  + reading.getString("reading_date") + "\n";

                    //txtJson.setText(temp); // display text to the phone screen!
                //return temp;
            }
        }
        catch(Exception e){

        }
        return temp;
    }



    /*Method will open file a file from our assets folder, read through the entire JSON Array
     *
     * @param view
     /
    public static void readJSON(View view) {

        //CONTEXT IS ABSTRACT
        //moved obtainFile method here!
        AssetManager a = c.getAssets();

        try {
            InputStream i = a.open("example.json");

            String chosenFile = ReaderWriter.stringFromStream(i);
            i.close();


            JSONParser jsonParser = new JSONParser();
            //try (FileReader reader = new FileReader("example.json")){
            try {
                //Read JSON file
                Object obj = jsonParser.parse(chosenFile);

                JSONArray readingList = (JSONArray) obj;

                //Iterate over employee array

                for (int i = 0; i < readingList.length(); i++) {
                    JSONObject rdg = readingList.getJSONObject(i);
                    parseReadingObject(rdg);
                }


            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (ParseException e) {
                e.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            }


        }

        catch (IOException e) {
            e.printStackTrace();
        }
    }






    //go through each reading object in reading list and print it
    private static void parseReadingObject(JSONObject rdg)
    {
        String temp = "";

        try {
            //Get rdg object( a field) within a single reading
            JSONObject readingObject = (JSONObject) rdg.get("site_readings");
            temp = temp +  "Site ID: " + readingObject.getString("site_id") + "\n";


           // String rdgType= (String) readingObject.get("reading_type");
            temp = temp +  "Reading Type: " + readingObject.getString("reading_type") + "\n";

            //Get employee last name
            //Double rdgID = (Double) readingObject.get("reading_ID");
            temp = temp +   "Reading ID: " + readingObject.getString("reading_ID") + "\n";

            temp = temp  +   "Reading Value: " + readingObject.getDouble("reading_value") + "\n";

            //Get employee website name

            temp = temp  +   "Reading Date: " + readingObject.getString("reading_date") + "\n";

            txtJson.setText(temp); // display text to the phone screen!
        }
        catch(Exception e){

        }


    }

*/


}
