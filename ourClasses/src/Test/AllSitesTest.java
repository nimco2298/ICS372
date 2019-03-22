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
		 AllSites.addToActive(myTest);
		assertEquals(1, AllSites.activeSites.size());
	}

}
