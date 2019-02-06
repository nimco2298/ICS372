
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
    public Site (aSiteID, aReadingType, aReadingVal, aReadingDate){
        siteID = aSiteID;
        rdgType = aReadingType;
        rdgVal = aReadingVal;
        rdgDate = aReadingDate;

    }

    public getSiteId() {
        return siteID;
    }

    public getRdgType() {
        return rdgType;
    }

    public getRdgDate() {
        return rdgDate;
    }

    public getRdgVal() {
        return rdgVal;
    }

}