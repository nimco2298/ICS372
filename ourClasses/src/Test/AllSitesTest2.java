package Test;

import static org.junit.Assert.*;

import org.junit.Test;

import ourClasses.AllSites;
import ourClasses.Sites;

public class AllSitesTest2 {
	
	Sites myTest = new Sites("12340");
	AllSites a = new AllSites();

	@SuppressWarnings("static-access")
	@Test
	public void testaddToActive() {

		myTest.canCollect = false;
		AllSites.nonActiveSites.add(myTest);
		a.addToActive(myTest);
		assertEquals(1, AllSites.activeSites.size());
	}

	@SuppressWarnings("static-access")
	@Test
	public void testremoveFromActive() {
		myTest.canCollect = true;
		AllSites.nonActiveSites.add(myTest);
		a.addToActive(myTest);
		a.removeFromActive(myTest);
		assertEquals(1, AllSites.nonActiveSites.size());
	}

}
