//package siteCollection;


public class SiteNode {
	
	/* value stored in node  */
	private Site data;
	/* Link to next node */
	private SiteNode link;

	/* Constructor for a node */
	public SiteNode(Site aSite, SiteNode nextNode){
		this.data = aSite;
		this.link = nextNode;
	}

	/*Add a reading as a node 
	*@param  SiteReading  a new reading 
	*@return void 
	*/
	public addSiteNode(Site newSite){
		link = new SiteNode(aReading, this.link);
	}

	/**Gets the data in the current node
	 * @return SiteReading returns the value of the node
	 */
	public Site getData() {
		return this.data;
	}

	/**Sets the data in the current node
	 * @param Site a reading 
	 */
	public void setData(Site newData) {
		this.data = newData;
	}
}


