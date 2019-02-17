package siteCollection;

public class SiteNode {
	
	private SiteReading data;
	private SiteNode link;
	
	public SiteNode(SiteReading data, SiteNode link) {
		this.data = data;
		this.link = link;
	}
	
	/**
	 * 
	 * @return Grabs the node from the list and returns the data values
	 */
	public SiteReading getData() {
		return this.data;
	}

	public void setData(SiteReading data) {
		this.data = data;
	}

	public SiteNode getLink() {
		return this.link;
	}

	public void setLink(SiteNode link) {
		this.link = link;
	}
	
	public void addNodeAfter(SiteReading element) {

		link = new SiteNode(element, this.link);
	}

	public void removeNodeAfter() {
		this.link = this.link.link;
	}
	
	/**
	 * 
	 * @param given list, the method will display the entire linked list
	 */
	public static void display(SiteNode list){
		
		SiteNode cursor = list;
		
		while (cursor != null){
			System.out.print(cursor.data+",");
			cursor = cursor.link;
		}
		System.out.println("\n");
	}
	
	/**	
	 * 
	 * This method has not been tested yet. 
	 */
	public static SiteNode listSearch(SiteNode head, SiteReading target){
		
		SiteNode cursor = head;
	
		while (cursor != null){
			if (cursor.getData() == target)
				return cursor;
			cursor = cursor.getLink();
		}
		
		return null;
	}
	
	/**
	 * 
	 * @param head is the starting node of the list
	 * @param position is the index position we are looking for
	 * @return the appropriate node
	 */
	public static SiteNode listPosition(SiteNode head, int position){
		
		SiteNode cursor = head;
		int index = 1;
		
		while (cursor != null && index < position){
			index++;
			cursor = cursor.getLink();
		}
		
		return cursor;
		
	}
	

}
