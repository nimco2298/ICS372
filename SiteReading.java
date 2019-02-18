

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Locale;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
// import org.apache.commons.lang.builder.ToStringBuilder;

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
	private String readableDate;

	public String getSiteId() {
		return siteId;
	}

	public void setSiteId(String siteId) {
		this.siteId = siteId;
	}

	   public String getReadingType()  {
	        return rdgType;
	    }

	public void setReadingType(String rdgType) {
		this.rdgType = rdgType;
	}

	public String getReadingId() {
		return rdgId;
	}

	public void setReadingId(String rdgId) {
		this.rdgId = rdgId;
	}

	public Double getReadingValue() {
		return rdgVal;
	}

	public void setReadingValue(Double rdgVal) {
		this.rdgVal = rdgVal;
	}

	public String getReadingDate() throws ParseException {
		unixToDate(rdgDate);
		return rdgDate;
	}

	public void setReadingDate(String rdgDate) {
		this.rdgDate = rdgDate;
	}
	//Updates Unix time to a readable format
	public void unixToDate(String readableDate) throws ParseException {    
	    long timestamp = Long.parseLong(readableDate);

	    SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/YYYY", Locale.US);
	    rdgDate = sdf.format(timestamp);

	}
}
