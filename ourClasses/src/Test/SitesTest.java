package Test;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.Test;
import ourClasses.Sites;

public class SitesTest {

	// Test that addAReading works
	@Test
	public void testAddReading() {
		Sites.addAReading("My Test Study", "studyID", "siteID", "rdgType", "rdgID", 70.0, "12348991");
		assertEquals(1, Sites.readings.size());
	}
	//Test that displayRdgs works
	@Test
	public void testDisplayReading() {
		assertEquals(
				"StudyName:  My Test Study	 StudyID: studyID	 SiteID: siteID	Reading type: rdgType	Reading ID:  rdgID	 Reading Value: 70.0	 Reading Date: 12348991",
				Sites.displayRdgs().trim());
	}

}
