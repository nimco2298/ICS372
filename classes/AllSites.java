package siteCollection;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Locale;

import java.util.*; //Collections
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
// import org.apache.commons.lang.builder.ToStringBuilder;

public class AllSites{
   

    /**List of All active Sites*/
   LinkedList<Site> activeSites = new LinkedList<Site>(); 

    /**List of All ARCHIVED Sites*/
	LinkedList<Site> archivedSites = new LinkedList<Site>(); 


    // traverse list of Allsites and find the site by printing its content 
	/*Getter for siteID 
    *@return String information about that 
    */
	public Site findSite(String aPossibleSite) {
	//traverse activeSites and find Site
	 for (Site s : activeSites){
	  if(s.printReadings(aPossibleSite)) {
	   return s;
	    }
	  }
	}


/* Check if a site can collect
*@return String  message indicating the status
*/
public String checkCollectStatus(){
 if(canCollect == true){
	System.out.println("This site can collect readings");
 }
 else{
	System.out.println("This site cannot collect readings ");
 }
}
}

