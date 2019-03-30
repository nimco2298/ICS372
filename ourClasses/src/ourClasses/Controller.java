/**
 * 
 */
package ourClasses;

public class Controller {

	AllSites sites = new AllSites();
	Sites s1;

	/**
	 * Method will start the site collection status for a Site Once the site status
	 * is on, the site will be added from nonactive to active
	 * 
	 * precondition: the site must have site collection status of FALSE
	 * precondition: the site must be currently in the nonActiveSite list
	 * 
	 * @param siteID
	 */
	void startCollection(Sites aSite) {

		if (aSite.checkCollStatus() == true) {
			System.out.println("Sorry, Site:" + aSite.readings.element().getSiteId()
					+ " is already available for data collection.");
		} else {
			aSite.turnOnStatus();
			AllSites.addToActive(aSite); // add the site to the active list
			System.out.println("Success! Site:" + aSite.readings.element().getSiteId() + " can start collecting data.");
		}

	}

	/**
	 * Method will end the collection status for a Site Once the site status is off,
	 * the site will be added from active to nonActive list
	 * 
	 * precondition: the site must have site collection status of TRUE precondition:
	 * the site must be currently in the active list
	 * 
	 * @param siteID
	 */
	void endCollection(Sites aSite) {
		if (aSite.checkCollStatus() == false) {
			if (aSite.checkCollStatus() == false) {
				System.out.println("Sorry, Site:" + aSite.readings.element().getSiteId()
						+ " is not available for data collection.");
			} else {
				aSite.turnOffStatus();
				AllSites.removeFromActive(aSite); // add the site to the active list
				System.out.println("Success! Site:" + aSite.readings.element().getSiteId()
						+ " is not available anymore for data collection");
			}
		}
	}

	public void addReading(String studyName, String studyId, String siteID, String readingType, String readingId,
			double readingVal, String readingDate) {
		s1 = sites.findSite(siteID);
		s1.addAReading(studyName, studyId, siteID, readingType, readingId, readingVal, readingDate);
	}

	public String displayReading(Sites s) {

		String list = s.displayRdgs();

		return list;

	}

	public void displayStudy(String studyID) {
		// s1.displayRdgs(siteID);
		s1 = sites.findSite(studyID); // find Site object for that reading
		System.out.println(s1.displayStdyRdgs(studyID));
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		AllSites a = new AllSites();
		Controller c = new Controller();

//	    //add new sites to the list 
//        AllSites.activeSites.add(new Sites("12345"));
//        AllSites.activeSites.add(new Sites("12555"));
//        
//      
//        //populate readings for these sites using ARRAYLIST
//        AllSites.activeSites.get(0).addAReading("Midwest USA Study", "465","12345","humidity","900",78.00,"1515354694451");
//        AllSites.activeSites.get(1).addAReading("Western USA Study", "490","12555","temperature","954",100.00,"1515354694451");
//        
//        //test start collection
//         Sites a1 = a.findSite("12345");
//         a1.turnOffStatus();
//         c.startCollection(a1); //NULL
//         
//         //testing display study reading process
//         AllSites.activeSites.add(new Sites("12468"));
//         AllSites.activeSites.get(0).addAReading("Midwest USA Study", "400","12468","humidity","910",30.00,"1515354694451");
//         AllSites.activeSites.get(1).addAReading("Western USA Study", "490","12468","temperature","954",130.00,"1515354694451");
//         AllSites.activeSites.get(1).addAReading("Midwest USA Study", "400","12468","humidity","940",50.00,"1515354394451");
//         AllSites.activeSites.get(1).addAReading("Midwest USA Study", "400","12468","humidity","999",20.00,"1515354694451");
//        
//         Sites s2 = new Sites("12444");
//         AllSites.activeSites.add(s2);
//         AllSites.activeSites.get(0).addAReading("Midwest USA Study", "400","12444","temperture","998",80.00,"1515354694451");
//         System.out.println(AllSites.activeSites.get(0).displayStdyRdgs("098"));

	}

}
