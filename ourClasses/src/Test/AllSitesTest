package Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ourClasses.AllSites;
import ourClasses.Sites;

class AllSitesTest {

	private AllSites allSites;
	private Sites sites;
	@BeforeEach
	void init() {
		allSites = new AllSites();
		sites = new Sites("011");
		sites.addAReading("My Test Study", "studyID", "011", "rdgType", "rdgID", 70.0, "12348991");
		AllSites.activeSites.add(sites);
	}
	

	@SuppressWarnings("static-access")
	@Test
	void testFindSiteIfNotFound() {
		
		assertEquals(null, allSites.findSite("0112"));
		
	}
	@SuppressWarnings("static-access")
	@Test
	void testFindSiteIfFound() {
		
		assertEquals(1, allSites.findSite("011").readings.size());
		
	}

}
