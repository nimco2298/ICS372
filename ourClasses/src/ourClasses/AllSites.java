/**
 * 
 */
package ourClasses;


import java.util.LinkedList;



/**AllSites is a class that stores active and nonactive sites, and can manipulate these lists
 * 
 *
 */
public class AllSites{

	//needs to be static, since We just need one collection of activesites and nonactive sites
	public static LinkedList<Sites> activeSites = new LinkedList<Sites>();
	public static LinkedList<Sites> nonActiveSites = new LinkedList<Sites>();
	
	/**Method will take a Site and add it from nonactive to active
	 * 
	 * @param aSite
	 **/
	public static void addToActive(Sites site) {
		
		for(Sites s : nonActiveSites) {
			if(nonActiveSites.element().equals(s) &  s.checkCollStatus() == false) {
				nonActiveSites.remove(site);
				activeSites.add(site);
			
			}
			else {
				System.out.println("Sorry! The site collection status of this site is false, and cannot be added to the active list.");
			}
		}
			
	}
	
	/**Method will take a Site and remove it from nonactive and add it to active
	 * 
	 * @param aSite
	 **/
	public static void removeFromActive(Sites site) {
		
		for(Sites s : activeSites) {
			if(activeSites.element().equals(s) &  s.checkCollStatus() == true ) {
				activeSites.remove(site);
				nonActiveSites.add(site);
			
			}
			else {
				System.out.println("Sorry! The site collection status of this site is false, and cannot be added to the active list.");
			}
		}
	}
	
	
	
	/**Method will take a SiteID and traverse the active list to find it.
	 * 
	 * @param  String aSite
	 * @return Sites  the given Site for that siteID
	 **/
	//@SuppressWarnings("static-access")
	public static Sites findSite(String siteID) {
	
		Sites site = null;	
		for(Sites s : activeSites) {
			if(siteID.equals(s.readings.element().getSiteId())) {
				//site = s;
				System.out.println("Congrats!" + siteID + " was found");
				return s;
				//break;
			
			}
			else {
				System.out.println("Sorry! The Site you are looking for doesnt have any readings and is non active");
				
				
			}
		}
		  return site;
	}

	
	/**
	 * Method will loop through and display readings given a study ID and validate
	 * the study ID
	 * 
	 * @param studyID the given study ID
	 * @return list list of all readings with that study ID
	 */
	public String displayStdyRdgs(String studyID) {
		// Loop through all the sites and get studyID
		// compare studyID with the parameter so they can match
		// then call toString for that reading
/*		String list = "";
		
		//loop through each site in active list
		for (Sites s : activeSites) {
			
			if (s.readings.element().getStudyId() == "") {
				System.out.println("Sorry! Please enter a valid studyID");
				
			} else if (s.readings.element().getStudyId().equals(studyID)) {
				list = list + s.readings.element().toString();
				
			} else if (!s.readings.element().getStudyId().equals(studyID)) {
				list = "";
				System.out.println(
						"Sorry! Study ID: " + s.readings.element().getStudyId() + " does not match the study ID you have entered");
			}

		}

		System.out.println(list);
		return list;*/
		
		
		String list = "";
		for (Reading rdgs : activeSites.element().readings) {
			if (studyID == "") {
				System.out.println("Sorry! Please enter a valid studyID");
			} else if (rdgs.getStudyId() == studyID) {
				list = list + rdgs.toString();
			} else if (rdgs.getStudyId() != studyID) {
				list = "";
				System.out.println(
						"Sorry! Study ID: " + rdgs.getStudyId() + " does not match the study ID you have entered");
			}

		}

		return list;
	}
	
	
	public static void main(String[] args) {
		
		AllSites a = new AllSites();
		 //Add a new site to the list 
        AllSites.activeSites.add(new Sites("12345"));
        AllSites.activeSites.add(new Sites("12555"));
        AllSites.activeSites.add(new Sites("12549"));
        
        //Add readings to sites
        AllSites.activeSites.get(0).addAReading("Midwest USA Study", "465","12345","humidity","900",78.00,"1515354694451");
        AllSites.activeSites.get(0).addAReading("Midwest USA Study", "400","12345","humidity","980",7.00,"1515354694451");
        AllSites.activeSites.get(1).addAReading("Eastern USA Study", "400","12555","temperature","910",122.00,"1515354694451");
        AllSites.activeSites.get(2).addAReading("Midwest USA Study", "465","12549","temperature","930",122.00,"1515354694451");
        
        
        //test findSite method for working
         Sites s4 = AllSites.findSite("12555");
         System.out.println("Site status is: " + s4.checkCollStatus());
         
         
         
         //Test that study display reading works
         System.out.println(a.displayStdyRdgs("400"));


	}

}