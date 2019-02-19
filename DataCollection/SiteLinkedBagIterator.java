

import java.util.Iterator;

public class SiteLinkedBagIterator implements Iterator<SiteReading> {
	
	private SiteNode current;
	public SiteLinkedBagIterator(SiteNode head){
		this.current = head;
	}

	@Override
	public boolean hasNext() {
		if (this.current == null)
			return false;
		
		return true;
	}

	@Override
	public SiteReading next() {
		
		SiteReading data = this.current.getData();
		
		this.current = this.current.getLink();
		
		return data;
	}

}
