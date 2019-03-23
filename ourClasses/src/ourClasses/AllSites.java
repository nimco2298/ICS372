/**
 * 
 */
package ourClasses;

import java.util.ArrayList;

/**AllSites is a class that stores active and nonactive sites, and can manipulate these lists
 * 
 *
 */
public class AllSites{

	//needs to be static, since We just need one collection of activesites and nonactive sites
	public static ArrayList<Sites> activeSites = new ArrayList<Sites>();
	public static ArrayList<Sites> nonActiveSites = new ArrayList<Sites>();
	
	/**Method will take a Site and add it from nonactive to active
	 * 
	 * @param aSite
	 **/
	public  void addToActive(Sites site) {
		
		int i;
		for(i = 0; i < nonActiveSites.size(); i++) {
			
			if(nonActiveSites.get(i).equals(site) & site.checkCollStatus() == false) {

				System.out.println("Yay we found the site to be added to active again");
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
	public void removeFromActive(Sites site) {
		
		int i;
		for(i = 0; i < activeSites.size(); i++) {
			
			if(activeSites.get(i).equals(site) & site.checkCollStatus() == true) {

				System.out.println("Yay we found the site to be removed from active");
				activeSites.remove(site);
				nonActiveSites.add(site);
			
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
	int i;
	for(i = 0; i < activeSites.size(); i++) {
		
		if(siteID.equals(activeSites.get(i).readings.element().getSiteId()) ) {
			site = activeSites.get(i);
		
		}
	}
	   return site;
   }

	
	
	
	public static void main(String[] args) {
		
		    //AllSites a = new AllSites();
		    //add a new site to the list 
		    
	        AllSites.activeSites.add(new Sites("12345"));
	        //using our method 
	        AllSites.activeSites.get(0).addAReading("Midwest USA Study", "465","12345","humidity","900",78.00,"1515354694451");
	        
	        //using the long way 
	        AllSites.activeSites.get(0).addAReading("Midwest USA Study", "465","12345","temperature","930",122.00,"1515354694451");
	        
	        
	        //PROPER WAY OF ADDING SITE to active list
	        Sites s3 = new Sites("12009");
	        AllSites.activeSites.add(s3);
	        
	        /* FINDSITE NOT WORKING */
            //s3 = AllSites.findSite("12009");
            System.out.println("Site is added properly. Site status:" + s3.checkCollStatus() + "\n");
	     	        
	        //For every site in activeSites, display its readings
	        for(Sites b : AllSites.activeSites)
	        {
	            System.out.println("List of readings for an active site : " + b.readings.toString());
	        }
		

	}

}