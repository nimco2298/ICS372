import java.util.Iterator;

public class SiteLinkedBag {
	/* Current Head */
	private SiteNode head;
	/* number of siteNodes */
	private int manyNodes;
	
	public SiteLinkedBag(){
		this.head = null;
		this.manyNodes = 0;
	}
	
	
	public void addToCollection(SiteReading element) {
		
		if(checkStatus(element.getSiteId())) {
		this.head = new SiteNode(element, head);
		manyNodes++; 
		}
		
	}
	
public void add(SiteReading element) {
		
		
		this.head = new SiteNode(element, head);
		manyNodes++; 
		
		
	}
	
	public Boolean checkStatus(String id) {
		
		Site status = new Site();
		
		if(status.canCollectSite(id)) {
			return true;
		}
		
		return false;
	}
	
	public void add(int index, SiteReading element) {
		
		
		SiteNode n = SiteNode.listPosition(head, index);
		
		if(n!= null) {
			n.addNodeAfter(element);
		}
	}
	// Need to be modified
	public int countOccurances(String target){
		int counter = 0;
		SiteNode cursor = head;
		while (cursor != null){
			
			if(cursor.getData().getSiteId().equals(target))
			
				System.out.println(cursor.getData());
				counter++;
				cursor = cursor.getLink();
		
		}
		
		return counter;
		
	}
	
	/** 
	 * 
	 * Problem in the following method
	 * 
	 * 
	 * */
	public int checkSite(String target){
		int counter = 0;
		SiteNode cursor = head;
		while (cursor != null){
			
			if(cursor.getData().getSiteId().equals(target))
			System.out.println("Your site id: " + cursor.getData().getSiteId());
				counter++;
				cursor = cursor.getLink();
		
		}
		
		return counter;
		
	}
	
	public SiteReading get(int index) {
		
		SiteNode cursor;
		
		if(manyNodes == 0) {
			throw new IllegalStateException("The data size is zero.");
		}
		cursor = SiteNode.listPosition(head, index);
		
		return cursor.getData();  
	}
	

	
	public void display() {
		
		SiteNode.display(head);
		
	}
	
	@Override
	public String toString(){
		
		String output = "[ ";
		
		SiteNode cursor = head;
		
		while (cursor != null){
			output += cursor.getData()+" ,";
			cursor = cursor.getLink();
		}
		
		output +=" ]";
				
		return output;
	}
	
	public Iterator<SiteReading> iterator() {
		
		return new SiteLinkedBagIterator(this.head);
		//return new InnerLinkedIterator();
	}
}
