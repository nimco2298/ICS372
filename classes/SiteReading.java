//package siteCollection;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Locale;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
// import org.apache.commons.lang.builder.ToStringBuilder;

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

    /* variable to format the date*/
	private String readableDate;

	
	/*Getter for siteID 
    *@return String the siteID
    */
	public String getSiteId() {
		return siteId;
	}

	/*Setter for a new siteID
    *@param   String a new ID
    */
	public void setSiteId(String siteId) {
		this.siteId = siteId;
	}

	/*Getter for reading type
    *@return String the rdgType
    */
	public String getReadingType()  {
	    return rdgType;
	}

	/*Setter for a new reading type
    *@param   void  a new type
    */
	public void setReadingType(String rdgType) {
		this.rdgType = rdgType;
	}

	public String getReadingId() {
		return rdgId;
	}

	public void setReadingId(String rdgId) {
		this.rdgId = rdgId;
	}

	/*Getter for reading value
    *@return  double   the rdgVal
    */
	public Double getReadingValue() {
		return rdgVal;
	}

	 /*Setter for a new value
    *@param   int  a new value
    */
	public void setReadingValue(Double rdgVal) {
		this.rdgVal = rdgVal;
	}

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

	    SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/YYYY", Locale.US);
	    rdgDate = sdf.format(timestamp);

	}
 
	/* Prints all the information for a reading */
	public String toString(){
		System.out.println(" SiteID: \t " + getSiteID() +
		" Reading type: \t " + getReadingType() +
		" Reading ID: \t " + getReadingId() +
		" Reading value: \t " + getReadingValue() +
		" Reading date: \t " + getReadingDate()); 
		
	} 
}
