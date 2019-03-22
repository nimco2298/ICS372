/**
 * 
 */
package ourClasses;

import java.util.ArrayList;

/**
 * @author nimco
 *
 */
public class AllSites{

	public static ArrayList<Sites> activeSites = new ArrayList<Sites>();
	public static ArrayList<Sites> nonActiveSites = new ArrayList<Sites>();
	
	/**Method will take a SiteID and add it from nonactive to active
	 * 
	 * @param aSite
	 **/
	public static void addToActive(Sites site) {
		
		int i;
		for(i = 0; i < activeSites.size(); i++) {
			
			if(activeSites.get(i).equals(site)) {

				System.out.println("Yay we found the site to be added to active again");
				activeSites.remove(site);
				nonActiveSites.add(site);
			
			}
		}
			
	}
	
	/**Method will take a SiteID and remove it from nonactive and add it to active
	 * 
	 * @param aSite
	 **/
	public void removeFromActive(Sites site) {
		
		int i;
		for(i = 0; i < activeSites.size(); i++) {
			
			if(activeSites.get(i).equals(site)) {

				System.out.println("Yay we found the site to be removed from active");
				nonActiveSites.remove(site);
				activeSites.add(site);
			
			}
		}
	}
	
	
	
	/**Method will take a SiteID and traverse the active list to find it.
	 * 
	 * @param  String aSite
	 * @return Sites  the given Site for that siteID
	 **/
	public Sites findSite(String siteID) {
		Sites site = null;
		int i;
		for(i = 0; i < activeSites.size(); i++) {
			
			if(activeSites.get(i).readings.element().getSiteId() == siteID ) {
				site = activeSites.get(i);
			
			}
		}
		return site;
	}
	

	
	
	
	
	public static void main(String[] args) {
		
		    AllSites a = new AllSites();
		    //add a new site to the list 
		    
	        a.activeSites.add(new Sites("12345"));
	        //using our method 
	        a.activeSites.get(0).addAReading("Midwest USA Study", "465","12345","humidity","900",78.00,"1515354694451");
	        
	        //using the long way 
	        a.activeSites.get(0).readings.add(new Reading("Midwest USA Study", "465","12345","temperature","930",122.00,"1515354694451"));
	        

	     	        
	        //For every site in activeSites, display its readings
	        for(Sites b : a.activeSites)
	        {
	            System.out.println(b.readings.toString());
	        }
		

	}

}