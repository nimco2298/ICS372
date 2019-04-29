package ourClasses;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;

import org.json.simple.JSONObject;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


/**
 * Reading is the class that is comprised of various measurements.
 *
 *
 */

public class Reading {

    /* A site has String  */
    @SerializedName("site_id")
    @Expose
    private String siteID;

    /* A reading has reading type  */
    @SerializedName("reading_type")
    @Expose
    private String rdgType;

    /* A unique ID for each reading */
    @SerializedName("reading_id")
    @Expose
    private String rdgId;

    /* A reading has reading value */
    @SerializedName("reading_value")
    @Expose
    private Double rdgVal;

    /* A reading has a reading date */
    @SerializedName("reading_date")
    @Expose
    private String rdgDate;

    /* variable to format the date*/
    private String readableDate;

    /* A reading belongs to one study id    */
    @SerializedName("study_id")
    @Expose
    private String studyID;

    /* A reading belongs to a study that has a name   */
    @SerializedName("study_name")
    @Expose
    private String studyName;

    /*Constructing a reading given all the input information */
    public Reading(String AStudyName, String AStudyID, String asiteID, String aReadingType, String aReadingId, double aReadingVal, String aReadingDate){
        studyName = AStudyName;
        studyID= AStudyID;
        siteID = asiteID;
        rdgType = aReadingType;
        rdgId = aReadingId;
        rdgVal = aReadingVal;
        rdgDate = aReadingDate;

    }


    /**Getter method for studyID
     * @return String the studyID
     **/
    public String getStudyID() {
        return studyID;
    }

    /**Setter method for study ID
     * @param String the studyID
     */

    public void setStudyID(String aStudyID) {
        this.studyID = aStudyID;
    }

    /**Getter method for study name
     * @return String the studyName
     **/
    public String getStudyName() {
        return studyName;
    }


    /**Setter method for study name
     * @param String the new studyName
     **/
    public void setStudyName(String newName) {
        this.studyName = newName;
    }

    /**Getter method for siteID
     * @return String the siteID
     **/
    public String getSiteID() {
        return siteID;
    }



    /**Setter method for siteID
     * @param String the siteID
     */

    public void setSiteID(String siteID) {
        this.siteID = siteID;
    }



    /**Getter method for the reading type
     * @return String the reading type
     **/
    public String getReadingType() {
        return rdgType;
    }

    /**Setter method for the reading type
     * @param String the reading type to be set
     **/
    public void setReadingType(String rdgType) {
        this.rdgType = rdgType;
    }

    /**Getter method for the readingID
     * @return String the reading ID
     **/
    public String getReadingID() {
        return rdgId;
    }

    /**Setter method for the readingID
     * @param String the reading ID to be set
     **/
    public void setReadingID(String rdgId) {
        this.rdgId = rdgId;
    }

    /*Setter for a new value
     *@param   int  a new value
     */

    /**Getter method for the reading value
     * @return Double the reading value
     **/
    public Double getReadingValue() {
        return rdgVal;
    }
    /**Setter method for the reading value
     * @param Double the reading val to be set
     */

    public void setReadingValue(Double rdgVal) {
        this.rdgVal = rdgVal;
    }

    /**Getter for reading date
     *@return String the rdgDate
     **/
    public String getReadingDate() throws ParseException {
        return rdgDate;
    }




    /**Setter method for the reading date
     * @param String the reading date to be set
     */
    public void setReadingDate(String rdgDate) {
        this.rdgDate = rdgDate;
    }


    /**Overridden toString implementatio
     *
     * @return String a string containing all the Reading information
     */
    @Override
    public String toString(){
        /*
        JSONObject obj = new JSONObject();
        try {
            obj.put("study", this.getStudyName());
            obj.put("study_id", this.getStudyID());
            obj.put("site_id", this.getSiteID());
            obj.put("reading_type", getReadingType());
            obj.put("reading_id", getReadingID());
            obj.put("reading_value", getReadingValue());
            obj.put("reading_date", getReadingDate());
        } catch (ParseException e) {
            e.printStackTrace();
        }

          */

        String temp = "";
        try{


            temp = temp  + "\n" + "Study Name: " + this.getStudyName() + "\n"
                    + "Study ID" + this.getStudyID() + "\n"
                    + "Site ID: " + this.getSiteID() + "\n"
                    + "Reading Type: " + getReadingType()+ "\n"
                    + "Reading ID: " + getReadingID() + "\n"
                    + "Reading Value: " + getReadingValue() + "\n"
                    + "Reading Date:" + getReadingDate() + "\n";
        }
        catch(ParseException e){
            e.printStackTrace();
        }

        return temp;

    }

    /**Method will reformat a reading so that it can be exported
     *
     * @return JSONObject The reading itself
     */
    public JSONObject formatReadingForExport(){
        JSONObject obj = new JSONObject();
        try {
            obj.put("study", this.getStudyName());
            obj.put("study_id", this.getStudyID());
            obj.put("site_id", this.getSiteID());
            obj.put("reading_type", getReadingType());
            obj.put("reading_id", getReadingID());
            obj.put("reading_value", getReadingValue());
            obj.put("reading_date", getReadingDate());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return obj;
    }

}
