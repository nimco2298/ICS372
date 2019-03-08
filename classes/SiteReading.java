<<<<<<< HEAD:classes/SiteReading.java
//package siteCollection;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Locale;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
//import org.apache.commons.lang.builder.ToStringBuilder;
=======
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
>>>>>>> 1353bbe844edb5b0ceb0a0b19088de51d8468507:SiteReading.java

public class SiteReading {
    /* A site has String  */
	@SerializedName("site_id")
	@Expose
	private String siteId;

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
<<<<<<< HEAD:classes/SiteReading.java

    /* variable to format the date*/
	private String readableDate;

	
	/*Getter for siteID 
    *@return String the siteID
    */
=======
	
	
	public SiteReading(String aSiteId) {
		siteId = aSiteId;
	}
	
	/*Constructing a reading given all the input information */
	public SiteReading (String aSiteID, String aReadingType, String aReadingId, double aReadingVal, String aReadingDate){
	        siteId = aSiteID;
	        rdgType = aReadingType;
	        rdgId = aReadingId;
	        rdgVal = aReadingVal;
	        rdgDate = aReadingDate;

	    }

	/**Getter method for SiteID
	 * @return String the siteID
	 **/
>>>>>>> 1353bbe844edb5b0ceb0a0b19088de51d8468507:SiteReading.java
	public String getSiteId() {
		return siteId;
	}

<<<<<<< HEAD:classes/SiteReading.java
	/*Setter for a new siteID
    *@param   String a new ID
    */
=======
	/**Setter method for SiteID
	 * @param String the siteID
	 */
>>>>>>> 1353bbe844edb5b0ceb0a0b19088de51d8468507:SiteReading.java
	public void setSiteId(String siteId) {
		this.siteId = siteId;
	}

<<<<<<< HEAD:classes/SiteReading.java
	/*Getter for reading type
    *@return String the rdgType
    */
	public String getReadingType()  {
	    return rdgType;
	}

	/*Setter for a new reading type
    *@param   void  a new type
    */
=======
	/**Getter method for the reading type
	 * @return String the reading type
	 **/
	public String getReadingType() {
		return rdgType;
	}

	/**Setter method for the reading type
	 * @param String the reading type to be set
	 **/
>>>>>>> 1353bbe844edb5b0ceb0a0b19088de51d8468507:SiteReading.java
	public void setReadingType(String rdgType) {
		this.rdgType = rdgType;
	}

	/**Getter method for the readingID
	 * @return String the reading ID
	 **/
	public String getReadingId() {
		return rdgId;
	}

	/**Setter method for the readingID
	 * @param String the reading ID to be set
	 **/
	public void setReadingId(String rdgId) {
		this.rdgId = rdgId;
	}

<<<<<<< HEAD:classes/SiteReading.java
	/*Getter for reading value
    *@return  double   the rdgVal
    */
	public Double getReadingValue() {
		return rdgVal;
	}

	 /*Setter for a new value
    *@param   int  a new value
    */
=======
	/**Getter method for the reading value 
	 * @return Double the reading value
	 **/
	public Double getReadingValue() {
		return rdgVal;
	}
	/**Setter method for the reading value
	 * @param Double the reading val to be set
	 */
>>>>>>> 1353bbe844edb5b0ceb0a0b19088de51d8468507:SiteReading.java
	public void setReadingValue(Double rdgVal) {
		this.rdgVal = rdgVal;
	}

<<<<<<< HEAD:classes/SiteReading.java
	/*Getter for reading date
    *@return String the rdgDate
    */
	public String getReadingDate() throws ParseException {
		unixToDate(rdgDate);
		return rdgDate;
	}

	 /*Setter for a new reading date
    *@param   String  a new date
    */
	public void setReadingDate(String rdgDate) {
		this.rdgDate = rdgDate;
	}

	//Updates Unix time to a readable format
	public void unixToDate(String readableDate) throws ParseException {    
	    long timestamp = Long.parseLong(readableDate);
=======
	/**Getter method for the reading date
	 * @return String the reading date
	 */
	public String getReadingDate() {
		return rdgDate;
	}

	/**Setter method for the reading date
	 * @param String the reading date to be set
	 */
	public void setReadingDate(String rdgDate) {
		this.rdgDate = rdgDate;
	}
	
	@Override
	public String toString(){
		
		
		String output = "";
		
		output +=this.siteId+"\t";
		output += this.rdgType + "\t";
		output += this.rdgId + "\t";
		output += this.rdgVal + "\t";
		output += this.rdgDate;
		
		
		return output;
	}
	
	/**Compare an object to Site Reading object for equality
	 * @return boolean  true/false
	 */
	public boolean equals(Object obj) {
		
		if(obj instanceof SiteReading) {
			SiteReading candidate = (SiteReading) obj;
			return (candidate.rdgId == rdgId);
		} else
			return false;
	}
>>>>>>> 1353bbe844edb5b0ceb0a0b19088de51d8468507:SiteReading.java


<<<<<<< HEAD:classes/SiteReading.java
	}
 
	/* Prints all the information for a reading */
	public String toString(){
		return (" SiteID: \t " + this.getSiteId() +
		" Reading type: \t " + getReadingType() +
		" Reading ID: \t " + getReadingId() +
		" Reading value: \t " + getReadingValue() +
		" Reading date: \t " + getReadingDate()); 
		
	} 
=======
 
>>>>>>> 1353bbe844edb5b0ceb0a0b19088de51d8468507:SiteReading.java
}
