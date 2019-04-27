/**
 *
 */
package ourClasses;


import java.util.ArrayList;
import java.util.LinkedList;




/**AllSites is a class that stores active and nonactive sites, and can manipulate these lists
 *activeSites is a list of all Sites that have data collection status of true
 *
 */
public class AllSites{

    //needs to be static, since We just need one collection of activesites and nonactive sites
    public static LinkedList<Site> activeSites = new LinkedList<Site>();
    public static LinkedList<Site> nonActiveSites = new LinkedList<Site>();


    /**Method will take a Site and add it from nonactive to active
     *
     * @param site the site to be added to the activeSites list
     **/
    public static void addToActive(Site site) {

        for(int i =0; i <nonActiveSites.size(); i ++) {
            //if site we are on is in the list, is equal to the site
            if (nonActiveSites.get(i).equals(site) & site.checkCollStatus() == false) {
                nonActiveSites.remove(site);
                activeSites.add(site);

            } else {
                System.out.println("Sorry! The site collection status of this site is false, and cannot be added to the active list.");
            }

        }

    }

    /**Method will take a Site and remove it from nonactive and add it to active
     *
     * @param site The site to be removed from activeSites list.
     **/
    public static void removeFromActive(Site site) {

        for(int i =0; i <activeSites.size(); i ++) {
            //if site we are on is in the list, is equal to the site we passed in
            if (activeSites.get(i).equals(site) & site.checkCollStatus() == true) {
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
     * @param  String siteId
     * @return Sites  the given Site for that siteID
     **/

    public Site findSite(String siteId) {
        for(Site site: activeSites) {
            if(siteId.equals(site.readings.element().getSiteID())) {
                System.out.println("The site is found");
                return site;
            }
        }
        return null;
    }




    public static void main(String[] args) {

        AllSites a = new AllSites();
        //Add a new site to the list
        AllSites.activeSites.add(new Site("12345"));
        AllSites.activeSites.add(new Site("12555"));
        AllSites.activeSites.add(new Site("12549"));

        //Add readings to sites
        AllSites.activeSites.get(0).addAReading("Midwest USA Study", "465","12345","humidity","900",78.00,"1515354694451");
        AllSites.activeSites.get(1).addAReading("Eastern USA Study", "400","12555","temperature","910",122.00,"1515354694451");
        AllSites.activeSites.get(2).addAReading("Midwest USA Study", "465","12549","temperature","930",122.00,"1515354694451");

        //Test to find the site
        Site s4 = a.findSite("12555");
        System.out.println("Site is added properly. Site status:" + s4.checkCollStatus() + s4.toString() + "\n");


    }

}
