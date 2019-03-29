/**
 * 
 */
package Test;

import java.text.ParseException;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ourClasses.Reading;

/**
 * @author nimco
 *
 */
class ReadingTest {

	Reading r;
	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void init() throws Exception {
		
		r = new Reading("Midwest USA Study", "465","12345","humidity","900",78.00,"1515354694451");
	}


	
	@Test
	public void testGetStudyID() {
		assertTrue(r.getStudyId().equals("465"));
	}
	
	@Test
	public void testSetStudyID() {
		String expected = "400";
		r.setStudyID(expected);
		String result = r.getStudyId();
		assertEquals( expected,result);
	}
	
	
	@Test
	public void testGetStudyName() {
		assertTrue(r.getStudyName().equals("Midwest USA Study"));
	}
	
	@Test
	public void testSetStudyName() {
		String expected = "Eastern USA Study";
		r.setStudyName(expected);
		String result = r.getStudyName();
		assertEquals( expected,result);
	}
	

	@Test
	public void testGetSiteID() {
		assertTrue(r.getSiteId().equals("12345"));
	}
	
	@Test
	public void testSetSiteID() {
		String expected = "10002";
		r.setSiteId(expected);
		String result = r.getSiteId();
		assertEquals( expected,result);
	}
	
	
	
	@Test
	public void testGetRdgId() {
		assertTrue(r.getReadingId().equals("900"));
	}
	
	@Test
	public void testSetRdgId() {
		String expected = "493";
		r.setReadingId(expected);
		String result = r.getReadingId();
		assertEquals( expected,result);
	}
	
	
	@Test
	public void testGetRdgType() {
		assertTrue(r.getReadingType().equals("humidity"));
	}
	
	@Test
	public void testSetRdgType() {
		String expected = "temperature";
		r.setReadingType(expected);
		String result = r.getReadingType();
		assertEquals( expected,result);
	}
	
	
	@Test
	public void testGetRdgVal() {
		assertTrue(r.getReadingValue().equals(78.00));
	}
	
	@Test
	public void testSetRdgVal() {
		Double expected = 122.00;
		r.setReadingValue(expected);
		Double result = r.getReadingValue();
		assertEquals( expected,result);
	}
	
	@SuppressWarnings("unlikely-arg-type")
	@Test
	public void testGetRdgDate() throws ParseException{
		assertTrue(r.getReadingDate().equals("1515354694451"));
	}
	
	@Test
	public void testSetRdgDate() throws ParseException{
		String expected = "11515354694247";
		r.setReadingDate(expected);
		String result = r.getReadingDate();
		assertEquals( expected,result);
	}
	
}
