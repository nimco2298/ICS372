package ourClasses;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.util.LinkedList;

/**
 * Site is a class that holds a list of readings, and has an associated Study
 *
 *
 */
public class Site {

    /** Collection Status  of a Site*/
    public static boolean canCollect = true;

    /** List of readings for a Site */
    public static LinkedList<Reading> readings = new LinkedList<Reading>();

    /** List of SiteIDs  that can be cross referneced with the list of readings   */
    public LinkedList<String> ids = new LinkedList<String>();

    /**      */
    public static boolean canAdd = true;

    /**  */
    private String siteID;
    /**  */
    private String siteName;
    /**  */
    private String state;
    /**  */
    private Study associatedStudy;


    //a Site should have a siteID and its list of readings
    //Constructor
    public Site(String siteID) {
        // readings = new LinkedList<Reading>(); //initalize empty Linkedlist of Reading objects
        ids.add(siteID);
    }


    /**Getter for the Site's ID
     *
     * @return the Site ID
     */
    public String getSiteID(){
        return siteID;
    }

    /**Setter for the Site's ID
     *
     * @param theSiteID
     */
    public void setSiteID( String theSiteID ){
        theSiteID = siteID;
    }

    /**Getter for the Site's name
     *
     * @return Site name
     */
    public String getSiteName(){
        return siteName;
    }

    /**Setter for the Site's name
     *
     * @param theSiteName
     */
    public void setSiteName( String theSiteName ){
        theSiteName = siteName;
    }

    /**Getter for the state of a Site
     *
     * @return the state the Site is in
     */
    public String getState(){
        return state;
    }

    /**Setter for the state of a Site
     *
     * @param theState the new state
     */
    public void setState( String theState ){
        theState = state;
    }

    /**Getter of the new associated Study
     *
     * @return the Study this Site belongs to
     */
    public Study getAssociatedStudy(){
        return associatedStudy;
    }

    /**Setter of the new associated Study
     *
     * @param theAssociatedStudy the new Study a Site will belong to
     */
    public void setAssociatedStudy( Study theAssociatedStudy ){
        theAssociatedStudy = associatedStudy;
    }


    /**Method is will switch the status of a Site
     *
     * @param s1
     */
    public void makeState (Site s1){
        // Invalid = 1 : Site cannot add readings, and all information about the site is deleted
        // Complete = 2 : Site cannot add readings temporarily, but information remains
        // Active = 3 : Site can add readings and display information
        // Disabled = 4 : Site cannot add readings

        int s1Num = 0;

        if(s1.getState() == "Invalid"){
            s1Num = 1;
        }
        if(s1.getState() == "Complete"){
            s1Num = 2;
        }
        if(s1.getState() == "Active"){
            s1Num = 3;
        }
        if(s1.getState() == "Disabled"){
            s1Num = 4;
        }

        if(s1Num == 1){
            s1.turnOffStatus();
            s1.setSiteName(null);
            s1.setSiteID(null);
            s1.addImpossible();
        }else if(s1Num == 2){
            s1.turnOffStatus();
        }else if(s1Num == 3){
            s1.turnOnStatus();
        }else if(s1Num == 4){
            s1.turnOffStatus();
            s1.addImpossible();
        }

    }

    /**Method will check if a siteID is found within the list of SiteIDs
     *
     * @param siteId
     * @return the T or F value
     */
    public Boolean findSiteID(String siteId) {
        for(String site: ids) {
            if(site == siteId) {
                System.out.println("The site is found");
                return true;
            }
        }
        return false;
    }

    /**Method will check a Sites ability to
     *
     * @return the T or F value
     */
    public boolean checkAddStatus(){
        return canAdd;
    }

    /**Method will check a Sites ability to be added to another Study aka state
     *
     */
    public void addPossible(){
        if (canAdd == false) {
            canAdd = true;
        }
    }

    /**Method will change the status of a Site so it cant be added to a Study aka state
     *
     */
    public void addImpossible(){
        if (canAdd == true) {
            canAdd = false;
        }
    }



    /**Method return the status of a Site for collection
     *
     * @return Boolean status of collection for a Site
     */
    public boolean checkCollStatus() {
        return canCollect;
    }

    /** Method that turns on site collection for a Site
     **/

    public void turnOnStatus() {
        if (canCollect == false) {
            canCollect = true;
        }
    }

    /** Method that turns off site collection for a Site
     **/
    public void turnOffStatus() {
        if (canCollect == true) {
            canCollect = false;
        }
    }

    /** Method that takes in parameters and adds it to its LinkedList of readings
     *
     * precondition: collection status of Site must be true
     **/
    public void addAReading(String studyName, String studyId, String id, String rdgType, String rdgID, double rdgValue, String rdgDate){
        if(checkCollStatus() == true) {
            readings.add(new Reading(studyName,studyId,id,rdgType,rdgID,rdgValue,rdgDate));
        }
        else {
            System.out.println("Sorry, this site is not accepting data for collection");
        }
    }



    /**
     * Method that displays all the readings for a given site
     * @return String containing JSon of the list of readings
     **/
    public String displayReadings() {
        String list = "";
        for(Reading rdgs : readings)
        {
            list = list + rdgs.toString();
        }
        if (list.length()>0) {
            return list;
        }else {
            return "{Site with no readings}";
        }
    }

    /**Method formats a Site and its readings for export
     *
     * @return JSONObject returns a Site objects and its readings for export
     */
    public static JSONObject formatSiteForExport(){
        JSONObject obj = new JSONObject();
        JSONArray obj2 = new JSONArray();
        for(Reading rdgs : readings)
        {
            obj2.add(rdgs.formatReadingForExport());
        }
        obj.put("site_readings",obj2);
        return obj;
    }
 }
