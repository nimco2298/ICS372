package Test;

import static org.junit.Assert.*;

import org.junit.Before;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.Test;
import ourClasses.Sites;

public class SitesTest {
	
	
   // Create private Site object to refernce through each of the tests
	private Sites site;
	
	
	//what ever you put in this Before section will run before every test. I am making a new object for each test
	@Before
	public void beginObject() {
		site = new Sites("12335");
	    //site.addAReading("Midwest USA Study", "450","12335","temprature","974",102.00,"1515354694451");
        //site.addAReading("Eastern USA Study", "400","12335","temprature","984",99.00,"1515354694489");
	}
	
	
	@Test
	 public void testAddAReading() {
		site.addAReading("My Test Study", "studyID", "siteID", "rdgType", "rdgID", 70.0, "12348991");
		assertEquals(1, Sites.readings.size());
	
	}
	@Test
	 public void testDisplayRdgs() {
		assertEquals(
				"StudyName:  My Test Study	 StudyID: studyID	 SiteID: siteID	Reading type: rdgType	Reading ID:  rdgID	 Reading Value: 70.0	 Reading Date: 12348991",
				site.displayRdgs().trim());
	}
	
	@Test
	 public void testDisplayStdyRdgs() {
		
		/// assert to test if you can display reading given a study ID 
	}
	
	
	
	@Test
	 public void testTurnOnStatus() {
		
	
	}
	
	@Test
	 public void testTurnOffStatus() {
		
	
	}
	
	
	
}
