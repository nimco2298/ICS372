package siteCollection;

import java.util.Iterator;

public class SiteLinkedBag {
	
	private SiteNode head;
	private int manyNodes;
	
	public SiteLinkedBag(){
		this.head = null;
		this.manyNodes = 0;
	}
	// Add a node onto the list
	public void add(SiteReading element) {
		this.head = new SiteNode(element, head);
		manyNodes++;
	}

	public void add(int index, SiteReading element) {
		
		
		SiteNode n = SiteNode.listPosition(head, index);
		
		if(n!= null) {
			n.addNodeAfter(element);
		}
	}
	// This method will take in an instance object of SiteReading and count how many times it occurs in the code.
	// This will be useful to determine how many reading inputs have been registered under one site.
	public int countOccurances(SiteReading target){
		int count = 0;
		SiteNode cursor = head;
		while (cursor != null){
			if (cursor.getData() == target)
				count++;
			cursor = cursor.getLink();
		}
		return count;
	}
	
	public SiteReading get(int index) {
		
		SiteNode cursor;
		
		if(manyNodes == 0) {
			throw new IllegalStateException("The data size is zero.");
		}
		cursor = SiteNode.listPosition(head, index);
		
		return cursor.getData();  
	}
	

	/**
	 * 
	 * @param Given target, the method will remove it out of the list
	 * @return either true or false
	 */
	
	public boolean remove(SiteReading target){
		
		SiteNode targetNode;
		
		targetNode = SiteNode.listSearch(this.head, target);
		
		if (targetNode == null)
			return false;
		else{
			SiteReading headData = this.head.getData();
			targetNode.setData(headData);
			manyNodes--;
			this.head = this.head.getLink();
			return true;
		}
			
	}
	
	public int size() {
		 
		return manyNodes;
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
