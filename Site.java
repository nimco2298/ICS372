

 public class Site {

	// A boolean to check if readings can be collected for a given site 
	private boolean canCollect = false;
	
	SiteLinkedBag activeSites = new SiteLinkedBag();
	SiteReading newSite;
	
	public Boolean canCollectSite(String siteId) {
		
	  newSite = new SiteReading(siteId);
	  activeSites.add(newSite);
	  
	  canCollect = true;
		
	  return canCollect;
	}

	/** 
	 * 
	 * Problem in the following method
	 * 
	 * This is causing null pointer exception errors.
	 * */
	 /*
	public Boolean statusCheck(String siteId) {
		
		int result = activeSites.checkSite(newSite.getSiteId());
		
		if(result > 0) {
			canCollect = true;
		}
		
		return canCollect;
	} */  
	
	
 
} 
