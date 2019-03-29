package ourClasses;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/*
 * SiteReader handles importing and exporting of data to file.
 */
public class SiteReader {

	static ArrayList<Object> site_IDs = new ArrayList<>();
	
	@SuppressWarnings("unchecked")
	public static void exportFile() throws IOException {

		JSONObject writeObj = new JSONObject();
		JSONArray jList = new JSONArray();

		for (int j = 0; j < (AllSites.activeSites.get(j).readings).size(); j++) {
			jList.add(AllSites.activeSites.get(j).readings);
		}
		writeObj.put("site_readings", jList);
		// The name of the file that is produced
		try (FileWriter file = new FileWriter("Site Collection Results.json")) {
			file.write(writeObj.toJSONString());
			file.flush();
			// Message that appears once the data is saved to directory
			JOptionPane.showMessageDialog(null, "Please check your project directory folder for results", "Json Export",
					JOptionPane.INFORMATION_MESSAGE);

//		} catch (IOException e) {
//			e.printStackTrace();
//		}
	}

	public static void importFile() throws FileNotFoundException, IOException, ParseException,
			ParserConfigurationException, SAXException, org.json.simple.parser.ParseException {

		JFileChooser jfc = new JFileChooser();
		// filter to only select .xml or .json files
		FileNameExtensionFilter filter = new FileNameExtensionFilter(".json and .xml", "xml", "json");
		jfc.setFileFilter(filter);

		int returnValue = jfc.showOpenDialog(null);

		if (returnValue == JFileChooser.APPROVE_OPTION) {
			java.io.File inputFile = jfc.getSelectedFile();
			String fileType = inputFile.getName();
			fileType = fileType.substring(fileType.length() - 3);
			if (fileType.contains("son")) {
				JSONParser parser = new JSONParser();

				Object obj = parser.parse(new FileReader(inputFile));

				JSONObject jsonObject = (JSONObject) obj;
				JSONArray site_reading = (JSONArray) jsonObject.get("site_readings");

				for (int j = 0; j < (site_reading).size(); j++) {
					JSONObject rec = (JSONObject) site_reading.get(j);
					if (rec.get("site_id") == null || rec.get("reading_type") == null || rec.get("reading_id") == null
							|| rec.get("reading_value") == null || rec.get("reading_date") == null) {
//						JOptionPane.showMessageDialog(null, "JSON File has invalid entry upon: " + j, "ERROR",
//								JOptionPane.INFORMATION_MESSAGE);
					} else {
						Sites myTest = new Sites(rec.get("site_id").toString());
						AllSites.activeSites.add(myTest);
						Reading myReading = new Reading(null, null, rec.get("site_id").toString(),
								rec.get("reading_type").toString(), rec.get("reading_id").toString(),
								Double.parseDouble(rec.get("reading_value").toString()),
								rec.get("reading_date").toString());
						AllSites.activeSites.get(j).readings.add(myReading);

					}
				}

			}
			if (fileType.contains("xml")) {

				DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
				DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
				Document doc = dBuilder.parse(inputFile);
				doc.getDocumentElement().normalize();
				NodeList kList = doc.getElementsByTagName("ReadingSet");
				NodeList nList = doc.getElementsByTagName("Study");
				NodeList mList = doc.getElementsByTagName("Reading");
				NodeList oList = doc.getElementsByTagName("Value");
				NodeList pList = doc.getElementsByTagName("Site");
				System.out.println(mList.getLength());
				for (int temp = 0; temp < nList.getLength(); temp++) {
					Node nNode = nList.item(temp);
					Node mNode = mList.item(temp);
					Node oNode = oList.item(temp);
					Node pNode = pList.item(temp);

					if (nNode.getNodeType() == Node.ELEMENT_NODE) {
						Element eElement = (Element) nNode;
						Element mElement = (Element) mNode;
						Element oElement = (Element) oNode;
						Element pElement = (Element) pNode;
						Sites myOtherTest = new Sites(pElement.getTextContent());
						AllSites.activeSites.add(myOtherTest);
						System.out.println("Study id : " + eElement.getAttribute("id"));
						System.out.println("Study Name: " + eElement.getTextContent());
						System.out.println("Reading id: " + mElement.getAttribute("id"));
						System.out.println("Type: " + mElement.getAttribute("type"));
						System.out.println("Value Unit: " + oElement.getAttribute("unit"));
						System.out.println("Value: " + oElement.getTextContent());
						System.out.println("Site ID: " + pElement.getTextContent());
					}
					if (mNode.getNodeType() == Node.ELEMENT_NODE) {
						Element eElement = (Element) nNode;
						Element mElement = (Element) mNode;
						Element oElement = (Element) oNode;
						Element pElement = (Element) pNode;
						Sites myOtherTest = new Sites(pElement.getTextContent());
						AllSites.activeSites.add(myOtherTest);
						System.out.println("Study id : " + eElement.getAttribute("id"));
						System.out.println("Study Name: " + eElement.getTextContent());
						System.out.println("Reading id: " + mElement.getAttribute("id"));
						System.out.println("Type: " + mElement.getAttribute("type"));
						System.out.println("Value Unit: " + oElement.getAttribute("unit"));
						System.out.println("Value: " + oElement.getTextContent());
						System.out.println("Site ID: " + pElement.getTextContent());
					}
					
					if (oNode.getNodeType() == Node.ELEMENT_NODE) {
						Element eElement = (Element) nNode;
						Element mElement = (Element) mNode;
						Element oElement = (Element) oNode;
						Element pElement = (Element) pNode;
						Sites myOtherTest = new Sites(pElement.getTextContent());
						AllSites.activeSites.add(myOtherTest);
						System.out.println("Study id : " + eElement.getAttribute("id"));
						System.out.println("Study Name: " + eElement.getTextContent());
						System.out.println("Reading id: " + mElement.getAttribute("id"));
						System.out.println("Type: " + mElement.getAttribute("type"));
						System.out.println("Value Unit: " + oElement.getAttribute("unit"));
						System.out.println("Value: " + oElement.getTextContent());
						System.out.println("Site ID: " + pElement.getTextContent());
					}
					
					if (pNode.getNodeType() == Node.ELEMENT_NODE) {
						Element eElement = (Element) nNode;
						Element mElement = (Element) mNode;
						Element oElement = (Element) oNode;
						Element pElement = (Element) pNode;
						Sites myOtherTest = new Sites(pElement.getTextContent());
						AllSites.activeSites.add(myOtherTest);
						System.out.println("Study id : " + eElement.getAttribute("id"));
						System.out.println("Study Name: " + eElement.getTextContent());
						System.out.println("Reading id: " + mElement.getAttribute("id"));
						System.out.println("Type: " + mElement.getAttribute("type"));
						System.out.println("Value Unit: " + oElement.getAttribute("unit"));
						System.out.println("Value: " + oElement.getTextContent());
						System.out.println("Site ID: " + pElement.getTextContent());
					}
				}

			}

		} else {
			// Error message if the user closes JFileChooser without selecting anything
			JOptionPane.showMessageDialog(null, "No File Selected", "ERROR", JOptionPane.INFORMATION_MESSAGE);
		}
	}

	public static void main(String[] args) throws FileNotFoundException, IOException, ParseException,
			ParserConfigurationException, SAXException, org.json.simple.parser.ParseException {

		importFile();
	}

}
