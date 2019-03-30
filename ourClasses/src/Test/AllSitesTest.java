package Test;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import ourClasses.AllSites;
import ourClasses.Sites;

public class AllSitesTest {

	private AllSites allSites;
	private Sites sites;
	@Before
	public void init() {
		allSites = new AllSites();
		sites = new Sites("011");
		sites.addAReading("My Test Study", "studyID", "011", "rdgType", "rdgID", 70.0, "12348991");
		AllSites.activeSites.add(sites);
	}
	

	@SuppressWarnings("static-access")
	@Test
	public void testFindSiteIfNotFound() {
		
		assertEquals(null, allSites.findSite("0112"));
		
	}
	@SuppressWarnings("static-access")
	@Test
	public void testFindSiteIfFound() {
		
		assertEquals(1, allSites.findSite("011").readings.size());
		
	}

}
