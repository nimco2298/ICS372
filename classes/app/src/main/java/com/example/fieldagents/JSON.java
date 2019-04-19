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


public class JSON  {

private static Reading reading = new Reading("Midwest USA Climate 2017", "902","15566","particulate","1adf4",354.00,"1515354694451");


  //Method will get a parse through JSON file

    public String readJSON(File jsonFile){
       String temp = "";

        String fileInString = ReaderWriter.stringFromStream(jsonFile);

        try{

            JSONObject listRdgs = new JSONObject(fileInString); // create one giant object
            JSONArray siteRdgs = listRdgs.getJSONArray("site_readings");


            for( int i = 0; i <siteRdgs.length(); i++){


                JSONObject reading = siteRdgs.getJSONObject(i); //get each reading in this file

                temp = temp +  "Site ID: "  + reading.getString("site_id") + "\n"
                        +   "Reading Type: " + reading.getString("reading_type") + "\n"
                        +   "Reading ID: " + reading.getString("reading_id") + "\n"
                        +   "Reading Value: " + reading.getDouble("reading_value") + "\n"
                        +  "Reading Date:"  + reading.getInt("reading_date") + "\n";


                //return temp;
            }

        }
        catch(JSONException e){
         e.printStackTrace();
        }
        catch(IndexOutOfBoundsException e){
            e.printStackTrace();
        }
        catch(ClassCastException e){
            e.printStackTrace();
        }
        return temp;
    }

    public static void quietImportFromFile() {
        try {
            java.io.File inputFile = new File("archive.json");

            JSONParser parser = new JSONParser();

            Object obj = parser.parse(new FileReader(inputFile));

            JSONObject jsonObject = (JSONObject) obj;
            JSONArray site_reading = (JSONArray) jsonObject.get("site_readings");

            for (int j = 0; j < (site_reading).length(); j++) {
                JSONObject rec = (JSONObject) site_reading.get(j);
                Site myTest = new Site(rec.get("site_id").toString());
                AllSites.activeSites.add(myTest);
                if (rec.get("study_id") != null && rec.get("study") != null) {
                    String study_id = rec.get("study_id").toString();
                    String study = rec.get("study_id").toString();

                    Reading myReading = new Reading(study_id, study, rec.get("site_id").toString(),
                            rec.get("reading_type").toString(), rec.get("reading_id").toString(),
                            Double.parseDouble(rec.get("reading_value").toString()), rec.get("reading_date").toString());
                    AllSites.activeSites.get(j).readings.add(myReading);
                    System.out.println(AllSites.activeSites.get(j).readings);

                } else {
                    Reading myReading = new Reading(null, null, rec.get("site_id").toString(),
                            rec.get("reading_type").toString(), rec.get("reading_id").toString(),
                            Double.parseDouble(rec.get("reading_value").toString()), rec.get("reading_date").toString());
                    AllSites.activeSites.get(j).readings.add(myReading);

                }
            }
        }
        catch(JSONException j){

        }catch(IOException ie){

        }
        catch(org.json.simple.parser.ParseException p){

        }
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
