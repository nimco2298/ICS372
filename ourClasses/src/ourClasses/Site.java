package ourClasses;

import java.util.LinkedList;

/**
 * Site is a class that holds a list of readings for a given site
 * 
 *
 */
public class Site {
public static boolean canCollect = true; 
	public LinkedList<Reading> readings = new LinkedList<Reading>();
	public LinkedList<String> ids = new LinkedList<String>();
	
	
	
	//a Site should have a siteID and its list of readings 
	//Constructor
	 public Site(String siteID) {
	 // readings = new LinkedList<Reading>(); //initalize empty Linkedlist of Reading objects
	  ids.add(siteID);
	}

	public Boolean findSiteID(String siteId) {
			for(String site: ids) {
				if(site == siteId) {
					System.out.println("The site is found");
					return true;
				}
			}
			return false;
		}
	
     /**Method return the status of a Site for collection
      * 
      * @return Boolean status of collection for a Site
      */
	 public boolean checkCollStatus() {
		 return canCollect;	 
	 }
	 
	/** Method that turns on site collection for a Site 
	 **/
	 
	public void turnOnStatus() {
	if (canCollect == false) {
	canCollect = true;
	}
	}
	
	/** Method that turns off site collection for a Site 
	 **/
	public void turnOffStatus() {
		if (canCollect == true) {
			canCollect = false;
		}
	}
	
	/** Method that takes in parameters and adds it to its LinkedList of readings 
	 * 
	 * precondition: collection status of Site must be true
	 **/
	public void addAReading(String studyName, String studyId, String id, String rdgType, String rdgID, double rdgValue, String rdgDate){
	 if(checkCollStatus() == true) {
		 readings.add(new Reading(studyName,studyId,id,rdgType,rdgID,rdgValue,rdgDate));
	 }
	 else {
		 System.out.println("Sorry, this site is not accepting data for collection");
	 }
	}
	
	/**
	 * Method that displays all the readings for a given site
	 * @return String the list of readings
	 **/
	public String displayRdgs() {
		String list = "";
		for(Reading rdgs : readings)
	        {	            	
	            	list = list + rdgs.toString();
	  
	        }
		
		return list;
	}
	
	/**
	 * Method that displays all the readings for a given site
	 * @return String containing JSon of the list of readings
	 **/
	public String toString() {
		String list = "";
		for(Reading rdgs : readings)
	        {	            	
	            	list = list + rdgs.toString();
	        }
		if (list.length()>0) {
			return list;
		}else {
			return "{Site with no readings}";
		}
	}
		
	
	/**Method will loop through and display readings given a study ID and validate the study ID
	 * 
	 * @param studyID   the given study ID
	 * @return list    list of all readings with that study ID
	 */
	public String displayStdyRdgs(String studyID){
		//Loop through all readings and get studyID
		//compare studyID with the parameter so they can match
		//then call toString for that reading
		String list = "";
		for(Reading rdgs : readings)
        {	  
			if(studyID == null || studyID == "") {
			 System.out.println("Sorry! Please enter a valid studyID");	
			}
			else if(studyID.equals(rdgs.getStudyId()) ) {
				list = list + rdgs.toString();
			}
			else if(rdgs.getStudyId() != studyID){
			 list = "";
			 System.out.println("Sorry! Study ID: " + rdgs.getStudyId() + " does not match the study ID you have entered");
			}
			
        }
		
		return list;
	}

	public static void main(String[] args) {

		Site s = new Site("12345");
		Site s2 = new Site("12555");

		s.addAReading("Midwest USA Study", "450", "12345", "temprature", "974", 102.00, "1515354694451");
		s2.addAReading("Eastern USA Study", "400", "12555", "temprature", "984", 99.00, "1515354694489");
		s2.addAReading("Midwest USA Study", "450", "12555", "temprature", "984", 99.00, "1515354694489");
		s.addAReading("Eastern USA Study", "400", "12345", "humidity", "100", 30.00, "1515784694489");

		System.out.println(s2.displayStdyRdgs("450"));

	}

}
