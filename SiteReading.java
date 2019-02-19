import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SiteReading {

	@SerializedName("site_id")
	@Expose
	private String siteId;
	@SerializedName("reading_type")
	@Expose
	private String rdgType;
	@SerializedName("reading_id")
	@Expose
	private String rdgId;
	@SerializedName("reading_value")
	@Expose
	private Double rdgVal;
	@SerializedName("reading_date")
	@Expose
	private String rdgDate;
	
	
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
	public String getSiteId() {
		return siteId;
	}

	/**Setter method for SiteID
	 * @param String the siteID
	 */
	public void setSiteId(String siteId) {
		this.siteId = siteId;
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
	public String getReadingId() {
		return rdgId;
	}

	/**Setter method for the readingID
	 * @param String the reading ID to be set
	 **/
	public void setReadingId(String rdgId) {
		this.rdgId = rdgId;
	}

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


 
}
