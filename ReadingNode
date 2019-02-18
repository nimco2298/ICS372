//package siteCollection;

public class ReadingNode {
	
	/* value stored in node  */
	private SiteReading data;
	/* Link to next node */
	private ReadingNode link;

	/* Constructor for a node */
	public ReadingNode(SiteReading info, ReadingNode nextNode){
		this.data = info;
		this.link = nextNode;
	}

	/*Add a reading as a node 
	*@param  SiteReading  a new reading 
	*@return void 
	*/
	public void addReadingNode(SiteReading aReading){
		link = new ReadingNode(aReading, this.link);
	}

	/**Gets the data in the current node
	 * @return SiteReading returns the value of the node
	 */
	public SiteReading getData() {
		return this.data;
	}

	/**Sets the data in the current node
	 * @param SiteReading a reading 
	 */
	public void setData(SiteReading data) {
		this.data = data;
	}

}
