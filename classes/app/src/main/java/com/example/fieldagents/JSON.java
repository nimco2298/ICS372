package com.example.fieldagents;
import ourClasses.*;


import org.json.JSONException;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.json.JSONArray;
import org.json.JSONObject;


import java.io.FileInputStream;
import java.io.IOException;
import java.io.*;
import java.util.*; //length()
import java.io.FileNotFoundException;
import java.io.FileReader.*;


public class JSON {


    ArrayList<Reading> sitesArray = new ArrayList<Reading>();


    /**Method imports JSON file into a Reading Object
     *
     * @param jsonFile
     * @return String of the object's data
     */
    public String importFromFile(File jsonFile) {

        try {

            String fileInString = ReaderWriter.stringFromStream(jsonFile);
            JSONObject listRdgs = new JSONObject(fileInString); // create one giant object
            JSONArray site_reading = listRdgs.getJSONArray("site_readings");


            for (int j = 0; j < site_reading.length(); j++) {


                JSONObject rec = site_reading.getJSONObject(j);
                Site mySite = new Site(rec.getString("site_id"));
                AllSites.activeSites.add(mySite);


                AllSites.activeSites.get(j).addAReading("", "", rec.getString("site_id"),
                        rec.getString("reading_type"), rec.getString("reading_id"),
                        rec.getDouble("reading_value"), rec.getString("reading_date"));

                //Add the reading to this temp array
                sitesArray.add(new Reading("", "", rec.getString("site_id"),
                        rec.getString("reading_type"), rec.getString("reading_id"),
                        rec.getDouble("reading_value"), rec.getString("reading_date")));

            }
            return sitesArray.toString();

        }

        catch (JSONException e) {
            e.printStackTrace();
        }
        catch(IndexOutOfBoundsException e){
            e.printStackTrace();
        } catch(ClassCastException e){
            e.printStackTrace();
        }
        catch(NullPointerException e){
            e.printStackTrace();
        }

        return sitesArray.toString();

    }
}



