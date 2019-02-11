
package siteCollection;

import java.util.List; 
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
// import org.apache.commons.lang.builder.ToStringBuilder;

public class Result {

	@SerializedName("site_readings")
	@Expose
	private List<SiteReading> siteReadings = null;

	public List<SiteReading> getSiteReadings() {
		return siteReadings;
	}

	public void setSiteReadings(List<SiteReading> siteReadings) {
		this.siteReadings = siteReadings;
	}

}