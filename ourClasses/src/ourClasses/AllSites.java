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
		public static LinkedList<Site> activeSites = new LinkedList<Site>();
		public static LinkedList<Site> nonActiveSites = new LinkedList<Site>();
		
		/**Method will take a Site and add it from nonactive to active
		 * 
		 * @param aSite
		 **/
		public static void addToActive(Site site) {
			
			for(Site s : nonActiveSites) {
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
		public static void removeFromActive(Site site) {
			
			for(Site s : activeSites) {
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
		
		
		public Site findSite(String siteId) {
			for(Site site: activeSites) {
				if(siteId.equals(site.readings.element().getSiteId())) {
					System.out.println("The site is found");
					return site;
				}
			}
			return null;
	}

	
	
	
//	public static void main(String[] args) {
//		
//		AllSites a = new AllSites();
//		 //Add a new site to the list 
//        AllSites.activeSites.add(new Sites("12345"));
//        AllSites.activeSites.add(new Sites("12555"));
//        AllSites.activeSites.add(new Sites("12549"));
//        
//        //Add readings to sites
//        AllSites.activeSites.get(0).addAReading("Midwest USA Study", "465","12345","humidity","900",78.00,"1515354694451");
//        AllSites.activeSites.get(1).addAReading("Eastern USA Study", "400","12555","temperature","910",122.00,"1515354694451");
//        AllSites.activeSites.get(2).addAReading("Midwest USA Study", "465","12549","temperature","930",122.00,"1515354694451");
//        
//        
//        /* FINDSITE ONLY WORKS IN CONTROLLER, Where a reading can be added */
//         Sites s4 = a.findSite("12555");
//        //s4.addAReading("Midwest USA Study", "465","12345","temperature","930",122.00,"1515354694451");
//        System.out.println("Site is added properly. Site status:" + s4.checkCollStatus() + "\n");
//        // System.out.println("Site readings :" + s4.displayRdgs() + "\n");
//     	        
//        //For every site in activeSites, display its readings
//        //for(Sites b : AllSites.activeSites)
//        //{
//           // System.out.println("List of readings for an active site : " + b.readings.toString());
//       // }
//
//	}

}
