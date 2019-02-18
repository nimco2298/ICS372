package siteCollection;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Locale;

/* Class that describes the behavior of a Site
*/ 
public class Site {

     
    /* A site has String  */
    private String siteID; 
    /* A site has reading type  */
    private String rdgType;
    /* A site has reading value */
    private int rdgVal; 
    /* A site has a reading date */
    private String rdgDate;
    
    private boolean canCollect = true;


    /*Constructor that creates a new Site object with parameters
    *
    *@param   String  a site ID
    *@param   String  a reading type
    *@param   int     a reading value
    *@param   String  a reading date
    *
    *@return   Site   a Site object
    */
    public Site (String aSiteID, String aReadingType, int aReadingVal, String aReadingDate){
        siteID = aSiteID;
        rdgType = aReadingType;
        rdgVal = aReadingVal;
        rdgDate = aReadingDate;

    }
    
    /*Getter for siteID 
    *@return String the siteID
    */
    public String getSiteId() {
        return siteID;
    }

    /*Getter for reading type
    *@return String the rdgType
    */
    public String getRdgType() {
        return rdgType;
    }

    /*Getter for reading date
    *@return String the rdgDate
    */
    public String getRdgDate() throws ParseException {
        return rdgDate;
    }

    /*Getter for reading value
    *@return  int   the rdgVal
    */
    public int getRdgVal() {
        return rdgVal;
    }

    /*Setter for a new siteID
    *@param   String a new ID
    */
   public void setSiteID(String aNewID) {
       siteID = aNewID;
   }

   /*Setter for a new reading type
    *@param   String  a new type
    */
   public void setRdgType(String aNewType) {
    rdgType = aNewType;
   }

   /*Setter for a new value
    *@param   int  a new value
    */
   public void setRdgVal(int aNewVal) {
    rdgVal = aNewVal;
   }

   /*Setter for a new reading date
    *@param   String  a new date
    */
   public void setRdgDate(String aNewDate) {
    rdgDate = aNewDate;
   }
 
//need LinkedList for current and archive readings

//   public void printAllReadings() {
//	   System.out.println(*LinkedList for current and archive readings*.toString());
//		}
//   
//   	public void canCollect(String siteId) {
//   		for (String s:*LinkedList*) {
//   			if(s.contains(siteID)) {
//   				canCollect = false;
//   			}
//   		}
//   	}
   }


