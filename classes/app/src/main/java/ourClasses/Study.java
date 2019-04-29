/**
 *
 */
package ourClasses;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.text.ParseException;
import java.util.ArrayList;

/**
 * Site is a class that holds a list of readings for a given site
 *
 *
 */
public class Study {

    // Each study has three components to it, listed below
    ArrayList<Site> siteList;
    ArrayList<Reading> readingList;
    String studyName;
    String studyID;

    /**
     * Study() is a constructor that initializes the study object
     */
    public Study() {
        siteList = new ArrayList<Site>();
        readingList = new ArrayList<Reading>();
        studyName = null;
        studyID = null;
    }

    /** Getter for the Sitelist object that occurs in Study()
     *
     * @return ArrayList<Site>
     */
    public ArrayList<Site> getSiteList() {
        return siteList;
    }

    /**Setter for the Sitelist object that occurs in Study()
     *
     * @param theSiteList
     */
    public void setSiteList(ArrayList<Site> theSiteList) {
        theSiteList = siteList;
    }


    /** Getter for the list of readings associated with a study
     *
     * @return ArrayList<Reading>
     */
    public ArrayList<Reading> getReadingList() {
        return readingList;
    }

    /** Setter for the list of readings associated with a study
     *
     * @return ArrayList<Reading>
     */
    public void setReadingList(ArrayList<Reading> theReadingList) {
        theReadingList = readingList;
    }

    // Getter and setter for the Study's name


    /** Getter for the study name
     *
     * @return String
     */
    public String getStudyName() {
        return studyName;
    }


    /** Setter for the study name
     *
     * @param theStudyName
     */
    public void setStudyName(String theStudyName) {
        theStudyName = studyName;
    }

    /** Getter for the study ID
     *
     * @return String
     */
    public String getStudyID() {
        return studyID;
    }


    /** Setter for the study ID
     *
     * @param theStudyID
     */
    public void setStudyID(String theStudyID) {
        theStudyID = studyID;
    }

    /**Method allows us to add a particular site to a study, should we need to
     * @param s  It accepts a site and returns void
     */
    public void addSite(Site s) {
        siteList.add(s);
    }

    /**Method allows us to add a particular reading to a study, should we need to
     * @param r It accepts a reading and returns void
     */
    public void addReading(Reading r) {
        readingList.add(r);
    }

    /*
     * Overwrite of the toString method that reports the contents of a study
     * (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    public String toString() {
        String s = "Study with its sites.\n";
        if (siteList.size() > 0) {
            for (Site n : siteList) {
                // Print node info
                String t = "\nSite " + n.getSiteName() + ", ID " + n.getSiteID() + "\n";
                s = s.concat(t);
            }
            s = s.concat("\n");
        }

        return s;
    }

}
