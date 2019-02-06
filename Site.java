
public class Site {

    //Describe a Site 

    //A site has String
    private String siteID; 
    //A site has reading type
    private String rdgType;
    //A site has readig value
    private int rdgVal; 
    //A site has a reading date 
    private String rdgDate;


    //Contructor w/ param 
    public Site (String aSiteID, String aReadingType, int aReadingVal, String aReadingDate){
        siteID = aSiteID;
        rdgType = aReadingType;
        rdgVal = aReadingVal;
        rdgDate = aReadingDate;

    }

    public String getSiteId() {
        return siteID;
    }

    public String getRdgType() {
        return rdgType;
    }

    public String getRdgDate() {
        return rdgDate;
    }

    public int getRdgVal() {
        return rdgVal;
    }
   public void setSiteID(String aNewID) {
       siteID = aNewID;
   }

   public void setRdgType(String aNewType) {
    rdgType = aNewType;
   }

   public void setRdgVal(int aNewVal) {
    rdgVal = aNewVal;
   }

   public void setRdgDate(String aNewDate) {
    rdgDate = aNewDate;
   }

}