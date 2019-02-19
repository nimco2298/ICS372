
import java.util.*; //Collections

public class Site{
   

	/* A boolean to check if readings can be collected for a given site */
	private boolean canCollect = true;

    /**List of All active readings */
    private LinkedList<ReadingNode> readings = new LinkedList<ReadingNode>(); 


	/*Print all readings for an active site
	*@param String the siteID of a site 
	*@returns String  A list of all readings
    */
	public String printReadings(String siteID){
	 //print all info 
	for(ReadingNode r : readings){
      if(r.getData().getSiteId() == siteID){
         r.toString();
	}
	else{
		System.out.println("Sorry, the siteID you entered doesnt have any readings");
	    }
	  }
	}


/* Check if a site can collect
*@return boolean the status of the variable(T/F)
*/
public boolean checkCollectStatus(){
 return canCollect;
}

/*Turn off Site Collection
*/
public void endCollect(){
	canCollect = false;
}
}
