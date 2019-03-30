package Test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import ourClasses.Sites;

public class SitesTest {

	// Create private Site object to reference through each of the tests
	private Sites site;

	@Before
	public void beginObject() {
		site = new Sites("12335");
		site.addAReading("Midwest USA Study", "450", "12335", "temperature", "974", 102.00, "1515354694451");
	}

	@Test
	public void testAddAReading() {
		site.addAReading("My Test Study", "studyID", "siteID", "rdgType", "rdgID", 70.0, "12348991");
		assertEquals(2, site.readings.size());

	}

	@Test
	public void testDisplayRdgs() {
		assertEquals(
				"StudyName:  Midwest USA Study	 StudyID: 450	 SiteID: 12335	Reading type: temperature	Reading ID:  974	 Reading Value: 102.0	 Reading Date: 1515354694451",
				site.displayRdgs().trim());
	}

	@Test
	public void testdisplayStdyRdgs() {
		assertEquals(
				"StudyName:  Midwest USA Study	 StudyID: 450	 SiteID: 12335	Reading type: temperature	Reading ID:  974	 Reading Value: 102.0	 Reading Date: 1515354694451",
				site.displayStdyRdgs("450").trim());
	}

}
