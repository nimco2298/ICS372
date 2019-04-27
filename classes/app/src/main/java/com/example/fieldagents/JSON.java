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
    //Method will get a parse through JSON file

    public String readJSON(File jsonFile) {
        String temp = "";

        String fileInString = ReaderWriter.stringFromStream(jsonFile);

        try {

            JSONObject listRdgs = new JSONObject(fileInString); // create one giant object
            JSONArray siteRdgs = listRdgs.getJSONArray("site_readings");


            for (int i = 0; i < siteRdgs.length(); i++) {


                JSONObject reading = siteRdgs.getJSONObject(i); //get each reading in this file

                temp = temp + "Site ID: " + reading.getString("site_id") + "\n"
                        + "Reading Type: " + reading.getString("reading_type") + "\n"
                        + "Reading ID: " + reading.getString("reading_id") + "\n"
                        + "Reading Value: " + reading.getDouble("reading_value") + "\n"
                        + "Reading Date:" + reading.getInt("reading_date") + "\n";


                //return temp;
            }

        } catch (JSONException e) {
            e.printStackTrace();
        } catch (IndexOutOfBoundsException e) {
            e.printStackTrace();
        } catch (ClassCastException e) {
            e.printStackTrace();
        }
        return temp;
    }

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
                //Site myTest = new Site(rec.getString("site_id"));
                //AllSites.activeSites.add(myTest);

                /*
                if (rec.getString("study_id") != null && rec.getString("study") != null) {
                    String study_id = rec.getString("study_id");
                    String study_name = rec.getString("study_name");



                    reading = new Reading(study_name,study_id, rec.getString("site_id"),
                            rec.getString("reading_type"), rec.getString("reading_id"),
                            rec.getDouble("reading_value"), rec.getString("reading_date"));

                    if(reading == null){
                        System.out.println("READING IS NULLLLLLLL");
                    }

                    AllSites.activeSites.get(j).readings.add(reading);
                    //temp2 = temp2 + myReading.toString();
                    //System.out.println(temp2);

                } else {

                */
                System.out.println(" THIS IS J: " + j);



                sitesArray.add(new Reading("", "", rec.getString("site_id"),
                        rec.getString("reading_type"), rec.getString("reading_id"),
                        rec.getDouble("reading_value"), rec.getString("reading_date")));

                //Add readings to an ArrayList
                //sites.add(reading);
                //AllSites.activeSites.get(j).readings.add(myReading);


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



