package com.example.fieldagents;
import ourClasses.*;

import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.*;


import org.json.simple.*;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.*;
import java.util.*; //length()

import android.os.Bundle;

import org.json.simple.*; //JSONObject, JSONArray


public class JSON  extends AppCompatActivity {

private static TextView txtJson;
private static Reading reading = new Reading("Midwest USA Climate 2017", "902","15566","particulate","1adf4",354.00,"1515354694451");

@Override
protected void onCreate(Bundle savedInstanceState){

    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    txtJson = (TextView) findViewById(R.id.txtJson);
 }




    public static  void readJSON(View view){

         /**ERROR HERE!!!!
        this is a Reading, but it needs to be a Context in order to use the obtainFile method
          */
        String jsonFile = ReaderWriter.obtainFile(this, "example.json"); //get the JSON file

        try{
            JSONArray siteRdgs = new JSONArray(jsonFile); //get the entire list of site readings

            String temp  = "";
            for( int i = 0; i <siteRdgs.length(); i++){

                JSONObject reading = siteRdgs.getJSONObject(i); //get each reading in this file

                temp = temp +  "Site ID: " + reading.getString("site_id") + "\n"
                        +   "Reading Type: " + reading.getString("reading_type") + "\n"
                        +   "Reading ID: " + reading.getString("reading_ID") + "\n"
                        +   "Reading Value: " + reading.getDouble("reading_value") + "\n"
                        +  "Reading Date:"  + reading.getString("reading_date") + "\n";

                    txtJson.setText(temp); // display text to the phone screen!
            }
        }
        catch(Exception e){

        }
    }


}
