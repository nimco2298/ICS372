package Test;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;

import org.junit.Test;

import ourClasses.AllSites;
import ourClasses.Sites;

public class AllSitesTest {
	
	@Test
	public void testActiveSites() {
		
		 Sites myTest = new Sites("1234");
		 AllSites a = new AllSites();
		 AllSites.activeSites.add(myTest);   // must add a site to active list(default list)
	  
	     myTest.turnOffStatus();
		 a.addToActive(myTest);
		assertEquals(1, AllSites.activeSites.size());
	}

}
