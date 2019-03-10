package ourClasses;
import java.text.ParseException;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Reading {

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


		/*Constructing a reading given all the input information */
		public Reading(String aSiteID, String aReadingType, String aReadingId, double aReadingVal, String aReadingDate){
		        siteId = aSiteID;
		        rdgType = aReadingType;
		        rdgId = aReadingId;
		        rdgVal = aReadingVal;
		        rdgDate = aReadingDate;

		    }

		

		/**Getter method for SiteID
		 * @return String the siteID
		 **/
		public String getSiteId() {
			return siteId;
		}

		/*Setter for a new siteID
	    *@param   String a new ID
	    */

		/**Setter method for SiteID
		 * @param String the siteID
		 */

		public void setSiteId(String siteId) {
			this.siteId = siteId;
		}

		

		/*Setter for a new reading type
	    *@param   void  a new type
	    */

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
		public String getReadingId() {
			return rdgId;
		}

		/**Setter method for the readingID
		 * @param String the reading ID to be set
		 **/
		public void setReadingId(String rdgId) {
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
			unixToDate(rdgDate);
			return rdgDate;
		}


		//Updates Unix time to a readable format
		public void unixToDate(String readableDate) throws ParseException {    
		    long timestamp = Long.parseLong(readableDate); 
		}

		

		/**Setter method for the reading date
		 * @param String the reading date to be set
		 */
		public void setReadingDate(String rdgDate) {
			this.rdgDate = rdgDate;
		}
		
		/* Prints all the information for a reading */
		@Override
		public String toString(){
			String output = "";
			
			try {
				output = " SiteID: \t " + this.getSiteId() +
				"\t"+ "Reading type: \t " + getReadingType() +
				"\t" + "Reading ID: \t " + getReadingId() +
				"\t" + " Reading Value: \t " + getReadingValue() +
				"\t" + " Reading Date: \t " + getReadingDate() 
				+ "\n";
			} catch (ParseException e) {
			
				e.printStackTrace();
			} 
		
			return output;
		} 

}


