package ourClasses;

import java.io.File;
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

		// The name of the file that is produced
		try (FileWriter file = new FileWriter("Site Collection Results.json")) {
			// this needs to be our array list
			file.write("{\"site_readings\":" + AllSites.activeSites.toString() + "}");
			file.flush();
			// Message that appears once the data is saved to directory
			JOptionPane.showMessageDialog(null, "Please check your project directory folder for results", "Json Export",
					JOptionPane.INFORMATION_MESSAGE);

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@SuppressWarnings("unchecked")
	public static void exportFileQuiet() throws IOException {

		// The name of the file that is produced
		try (FileWriter file = new FileWriter("archive.json")) {
			file.write("{\"site_readings\":" + AllSites.activeSites.toString() + "}");

		} catch (IOException e) {
			e.printStackTrace();
		}
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
			// will use this if the file is json
			if (fileType.contains("son")) {
				JSONParser parser = new JSONParser();

				Object obj = parser.parse(new FileReader(inputFile));

				JSONObject jsonObject = (JSONObject) obj;
				JSONArray site_reading = (JSONArray) jsonObject.get("site_readings");

				for (int j = 0; j < (site_reading).size(); j++) {
					JSONObject rec = (JSONObject) site_reading.get(j);
					Sites myTest = new Sites(rec.get("site_id").toString());
					AllSites.activeSites.add(myTest);
					if (rec.get("study_id") != null && rec.get("study") != null) {
						String study_id = rec.get("study_id").toString();
						String study = rec.get("study_id").toString();

						Reading myReading = new Reading(study_id, study, rec.get("site_id").toString(),
								rec.get("reading_type").toString(), rec.get("reading_id").toString(),
								Double.parseDouble(rec.get("reading_value").toString()),
								rec.get("reading_date").toString());
						AllSites.activeSites.get(j).readings.add(myReading);
						System.out.println(AllSites.activeSites.get(j).readings);

					} else {
						Reading myReading = new Reading(null, null, rec.get("site_id").toString(),
								rec.get("reading_type").toString(), rec.get("reading_id").toString(),
								Double.parseDouble(rec.get("reading_value").toString()),
								rec.get("reading_date").toString());
						AllSites.activeSites.get(j).readings.add(myReading);
						System.out.println(AllSites.activeSites.get(j).readings);
					}
				}

			}
			// will use this if the file is xml
			if (fileType.contains("xml")) {

				DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
				DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
				Document doc = dBuilder.parse(inputFile);
				doc.getDocumentElement().normalize();
				NodeList readingSetList = doc.getElementsByTagName("ReadingSet");
				NodeList studyList = doc.getElementsByTagName("Study");
				NodeList readingList = doc.getElementsByTagName("Reading");
				NodeList valueList = doc.getElementsByTagName("Value");
				NodeList siteList = doc.getElementsByTagName("Site");

				for (int i = 0; i < readingSetList.getLength(); i++) {
					Node alphaNode = studyList.item(i);
					Node betaNode = readingList.item(i);
					Node gammaNode = valueList.item(i);
					Node deltaNode = siteList.item(i);

					if (alphaNode.getNodeType() == Node.ELEMENT_NODE) {
						Element alphaElement = (Element) alphaNode;
						Element betaElement = (Element) betaNode;
						Element gammaElement = (Element) gammaNode;
						Element deltaElement = (Element) deltaNode;
						Sites xmlSite = new Sites(deltaElement.getTextContent());
						AllSites.activeSites.add(xmlSite);
						Reading myOtherReading = new Reading(alphaElement.getTextContent(),
								alphaElement.getAttribute("id"), deltaElement.getTextContent(),
								betaElement.getAttribute("type"), betaElement.getAttribute("id"),
								Double.parseDouble(gammaElement.getTextContent()), null);

						System.out.println("Study: " + alphaElement.getTextContent());
						System.out.println("Study ID: " + alphaElement.getAttribute("id"));
						System.out.println("Site ID: " + deltaElement.getTextContent());
						System.out.println("Reading Type: " + betaElement.getAttribute("type"));
						System.out.println("Reading ID: " + betaElement.getAttribute("id"));
						System.out.println("Reading Value: " + gammaElement.getTextContent());

						AllSites.activeSites.get(i).readings.add(myOtherReading);
						System.out.println(AllSites.activeSites.get(i).readings);
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

	public static void quietImportFromFile()
			throws FileNotFoundException, IOException, org.json.simple.parser.ParseException {
		java.io.File inputFile = new File("archive.json");

		JSONParser parser = new JSONParser();

		Object obj = parser.parse(new FileReader(inputFile));

		JSONObject jsonObject = (JSONObject) obj;
		JSONArray site_reading = (JSONArray) jsonObject.get("site_readings");

		for (int j = 0; j < (site_reading).size(); j++) {
			JSONObject rec = (JSONObject) site_reading.get(j);
			Sites myTest = new Sites(rec.get("site_id").toString());
			AllSites.activeSites.add(myTest);
			if (rec.get("study_id") != null && rec.get("study") != null) {
				String study_id = rec.get("study_id").toString();
				String study = rec.get("study_id").toString();

				Reading myReading = new Reading(study_id, study, rec.get("site_id").toString(),
						rec.get("reading_type").toString(), rec.get("reading_id").toString(),
						Double.parseDouble(rec.get("reading_value").toString()), rec.get("reading_date").toString());
				AllSites.activeSites.get(j).readings.add(myReading);
				System.out.println(AllSites.activeSites.get(j).readings);

			} else {
				Reading myReading = new Reading(null, null, rec.get("site_id").toString(),
						rec.get("reading_type").toString(), rec.get("reading_id").toString(),
						Double.parseDouble(rec.get("reading_value").toString()), rec.get("reading_date").toString());
				AllSites.activeSites.get(j).readings.add(myReading);

			}
		}
	}
}
