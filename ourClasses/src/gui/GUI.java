package gui;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.ParseException;

import javax.swing.JOptionPane;
import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Path;
import javafx.stage.Stage;
import ourClasses.AllSites;
import ourClasses.Controller;
import ourClasses.SiteReader;
import ourClasses.Site;

public class GUI extends Application {

	Stage window;

	// Scenes

	Controller d1 = new Controller();
	AllSites sites = new AllSites();
	Site s1;

	Scene homeScene;
	Scene readingScene;
	Scene addCollectionScene;
	Scene endCollectionScene;
	Scene dataLogScene;

	// Panes, each scene needs a pane

	HBox homePane;
	VBox readingPane;
	VBox addCollectionPane;
	VBox endCollectionPane;
	VBox dataLogPane;

	// Buttons in the home scene

	Button addCollection = new Button("Start Data Collection");
	Button addReadingData = new Button("Add Reading");
	Button endCollection = new Button("End Data Collection");
	Button dataLog = new Button("View Data Log");
	Button importFile = new Button("Import File");
	Button exportFile = new Button("Export to File"); // 1

	// Buttons to return to Home menu
	Button homeBtnAddCollection;
	Button homeBtnEndCollection;
	Button homeBtnReading;
	Button homeBtnLog;

	// Add Reading Scene items
	TextField insert_studyName_TF;
	TextField insert_studyID_TF;
	TextField insert_siteId_TF;
	TextField insert_readingType_TF;
	TextField insert_readingId_TF;
	TextField insert_readingValue_TF;
	TextField insert_readingDate_TF;
	TextArea reading_result;

	// Add Collection Scene items
	TextField start_siteId_TF;
	TextArea start_result;

	// End Collection Scene items
	TextField end_siteId_TF;
	TextArea end_result;

	// Data log for a site
	TextField log_siteId_TF;
	TextArea data_result;

	@Override
	public void init() throws Exception {
		File tmpDir = new File("archive.json");
		boolean exists = tmpDir.exists();
		if (tmpDir.exists()) {
			SiteReader.quietImportFromFile();
		}
		
	}

	public static void main(String[] args) {
		
		Application.launch(args);
	}

	// A method to switch to the appropriate scene when a button is clicked
	class ButtonListenerClass implements EventHandler<ActionEvent> {
		public void handle(ActionEvent e) {

			if (e.getSource() == addCollection) {
				window.setScene(addCollectionScene);

			} else if (e.getSource() == homeBtnAddCollection) {
				window.setScene(homeScene);
			} else if (e.getSource() == addReadingData) {
				window.setScene(readingScene);
			} else if (e.getSource() == homeBtnReading) {
				window.setScene(homeScene);
			} else if (e.getSource() == endCollection) {
				window.setScene(endCollectionScene);

			} else if (e.getSource() == homeBtnEndCollection) {
				window.setScene(homeScene);
			} else if (e.getSource() == dataLog) {
				window.setScene(dataLogScene);
			} else if (e.getSource() == homeBtnLog) {
				window.setScene(homeScene);
			}

		}

	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		window = primaryStage;

		// Buttons to open the various scenes
		addCollection = new Button("Start Data Collection");
		addReadingData = new Button("Add Reading");
		endCollection = new Button("End Data Collection");
		dataLog = new Button("View Data Log");
		importFile = new Button("Import File");
		exportFile = new Button("Export to File"); // 1

		homeBtnAddCollection = new Button("Home");
		homeBtnEndCollection = new Button("Home");
		homeBtnReading = new Button("Home");
		homeBtnLog = new Button("Home");

		ButtonListenerClass btnListener = new ButtonListenerClass();

		addCollection.setOnAction(btnListener);
		endCollection.setOnAction(btnListener);
		addReadingData.setOnAction(btnListener);
		dataLog.setOnAction(btnListener);
		importFile.setOnAction(btnListener);
		exportFile.setOnAction(btnListener); // 1

		homeBtnAddCollection.setOnAction(btnListener);
		homeBtnEndCollection.setOnAction(btnListener);
		homeBtnReading.setOnAction(btnListener);
		homeBtnLog.setOnAction(btnListener);

		// Home scene Design

		// The home scene contains the main interface buttons

		homePane = new HBox(6);
		homePane.getChildren().add(addCollection);
		homePane.getChildren().add(addReadingData);
		homePane.getChildren().add(endCollection);
		homePane.getChildren().add(dataLog);
		homePane.getChildren().add(importFile);
		homePane.getChildren().add(exportFile); // 1
		homeScene = new Scene(homePane, 620, 30);

		primaryStage.setTitle("Data Collection Interface");
		primaryStage.setScene(homeScene);
		primaryStage.show();

		//////////////////////////////////////////////
		// Adding Reading Scene Design

		// creating visual items

		Label studyName_Label = new Label("Study Name:");
		Label studyId_Label = new Label("Study ID:");
		Label siteId_Label = new Label("Site Id:");
		Label readingType_Label = new Label("Reading Type:");
		Label readingId_Label = new Label("Reading Id:");
		Label readingValue_Label = new Label("Reading Value:");
		Label readingDate_Label = new Label("Reading Date:");
		Button addReading = new Button("Add Reading");

		// Insert Text field
		// Text fields are declared as instance variables not local variables
		// because the listeners need to read from and write to text fields

		insert_studyName_TF = new TextField("Enter Study Name");
		insert_studyID_TF = new TextField("Enter Study ID");
		insert_siteId_TF = new TextField("Enter Site ID");
		insert_readingType_TF = new TextField("Enter Reading Type (Only: humidity/particulate/temp/bar_press");
		insert_readingId_TF = new TextField("Enter Reading ID");
		insert_readingValue_TF = new TextField("Enter Reading Value");
		insert_readingDate_TF = new TextField("Enter Reading Date");
		reading_result = new TextArea();
		reading_result.setEditable(false);

		// Creating insert pane and adding items to it

		readingPane = new VBox();
		readingPane.getChildren().add(homeBtnReading);
		readingPane.getChildren().add(studyName_Label);
		readingPane.getChildren().add(insert_studyName_TF);
		readingPane.getChildren().add(studyId_Label);
		readingPane.getChildren().add(insert_studyID_TF);
		readingPane.getChildren().add(siteId_Label);
		readingPane.getChildren().add(insert_siteId_TF);
		readingPane.getChildren().add(readingType_Label);
		readingPane.getChildren().add(insert_readingType_TF);
		readingPane.getChildren().add(readingId_Label);
		readingPane.getChildren().add(insert_readingId_TF);
		readingPane.getChildren().add(readingValue_Label);
		readingPane.getChildren().add(insert_readingValue_TF);
		readingPane.getChildren().add(readingDate_Label);
		readingPane.getChildren().add(insert_readingDate_TF);
		readingPane.getChildren().add(addReading);
		readingPane.getChildren().add(reading_result);

		InsertListenerClass readingInsertListener = new InsertListenerClass();
		addReading.setOnAction(readingInsertListener);
		// adding insert pane to insert scene
		readingScene = new Scene(readingPane, 400, 400);

		//////////////////////////////////////////////
		// Add Data Collection Scene Design

		Label siteLabel = new Label("Site ID:");
		Button start_SiteIdSubmit = new Button("Start Data Collection");
		start_siteId_TF = new TextField("Enter Site ID");
		start_result = new TextArea();
		start_result.setEditable(false);

		// Creating data collection pane and adding site id's to it
		addCollectionPane = new VBox();
		addCollectionPane.getChildren().add(homeBtnAddCollection);
		addCollectionPane.getChildren().add(siteLabel);
		addCollectionPane.getChildren().add(start_siteId_TF);
		addCollectionPane.getChildren().add(start_SiteIdSubmit);
		addCollectionPane.getChildren().add(start_result);

		AddCollectionListenerClass addCollectionListenerClass = new AddCollectionListenerClass();
		start_SiteIdSubmit.setOnAction(addCollectionListenerClass);
		// adding insert pane to insert scene
		addCollectionScene = new Scene(addCollectionPane, 300, 300);

		//////////////////////////////////////////////
		// Add End Data Collection Scene Design

		Button end_SiteIdSubmit = new Button("End Data Collection");
		end_siteId_TF = new TextField("Enter Site ID");
		end_result = new TextArea();
		end_result.setEditable(false);

		// Creating an ending data collection pane and adding site id's to it
		endCollectionPane = new VBox();
		endCollectionPane.getChildren().add(homeBtnEndCollection);
		endCollectionPane.getChildren().add(siteLabel);
		endCollectionPane.getChildren().add(end_siteId_TF);
		endCollectionPane.getChildren().add(end_SiteIdSubmit);
		endCollectionPane.getChildren().add(end_result);

		EndCollectionListenerClass endCollectionListenerClass = new EndCollectionListenerClass();
		end_SiteIdSubmit.setOnAction(endCollectionListenerClass);
		// adding insert pane to insert scene
		endCollectionScene = new Scene(endCollectionPane, 300, 300);

		//////////////////////////////////////////////
		// Add Data Log Scene Design

		Button log_SiteIdSubmit = new Button("View Data Log");
		log_siteId_TF = new TextField("Enter Site ID");
		data_result = new TextArea();
		data_result.setEditable(false);

		// Creating a view data collection pane
		dataLogPane = new VBox();
		dataLogPane.getChildren().add(homeBtnLog);
		dataLogPane.getChildren().add(siteLabel);
		dataLogPane.getChildren().add(log_siteId_TF);
		dataLogPane.getChildren().add(log_SiteIdSubmit);
		dataLogPane.getChildren().add(data_result);

		DataLogListenerClass dataListenerClass = new DataLogListenerClass();
		log_SiteIdSubmit.setOnAction(dataListenerClass);
		// adding insert pane to insert scene
		dataLogScene = new Scene(dataLogPane, 300, 300);

		// Importing file section
		DataImportListenerClass dataImportListenerClass = new DataImportListenerClass();
		importFile.setOnAction(dataImportListenerClass);

		// Exporting file section
		DataExportListenerClass dataExportListenerClass = new DataExportListenerClass();
		exportFile.setOnAction(dataExportListenerClass);

	}

	/**
	 * 
	 * Problem in the following method
	 * 
	 * 
	 */

	// A listener to be called to insert a reading in the collection
	class InsertListenerClass implements EventHandler<ActionEvent> {
		@Override
		public void handle(ActionEvent ae) {

			String studyName = insert_studyName_TF.getText();
			String studyID = insert_studyID_TF.getText();
			String siteId = insert_siteId_TF.getText();
			String readingType = insert_readingType_TF.getText();
			String readingId = insert_readingId_TF.getText();
			String readingValue = insert_readingValue_TF.getText();
			String readingDate = insert_readingDate_TF.getText();
			int num = 0;
			System.out.println(studyName + " " + studyID + " " + siteId + " " + readingType + " " + readingId + " "
					+ readingValue + " " + readingDate);

			double readingVal = Double.parseDouble(readingValue);

			AllSites.activeSites.get(num).addAReading(studyName, studyID, siteId, readingType, readingId, readingVal,
					readingDate);
			num++;

			reading_result.setText("The reading has been added to the collection");
			try {
				SiteReader.exportFileQuiet();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	// A listener to be called to begin site data collection
	class AddCollectionListenerClass implements EventHandler<ActionEvent> {
		@Override
		public void handle(ActionEvent ae) {
			String siteId = start_siteId_TF.getText();

			AllSites.activeSites.add(new Site(siteId));
			System.out.println(siteId);
			start_result.setText("The Site can now collect readings");

		}
	}

	// A listener to be called to end site data collection
	class EndCollectionListenerClass implements EventHandler<ActionEvent> {
		@Override
		public void handle(ActionEvent ae) {
			String siteId = end_siteId_TF.getText();
			s1 = sites.findSite(siteId);
			AllSites.removeFromActive(s1);
			end_result.setText("The Site has ended its collection and can no longer accept readings");
		}
	}

	// A listener to be called to view a site data collection
	class DataLogListenerClass implements EventHandler<ActionEvent> {
		@Override
		public void handle(ActionEvent ae) {

			String siteId = insert_siteId_TF.getText();
			String value;
			s1 = sites.findSite(siteId);
			value = d1.displayReading(s1);

			data_result.setText(value);

		}
	}

	// A listener to be called to export data
	class DataExportListenerClass implements EventHandler<ActionEvent> {
		@Override
		public void handle(ActionEvent ae) {
			try {
				SiteReader.exportFile();
			} catch (IOException e) {
				e.printStackTrace();
			}

		}
	}

	class DataImportListenerClass implements EventHandler<ActionEvent> {
		@Override
		public void handle(ActionEvent ae) {
			try {
				try {
					SiteReader.importFile();
				} catch (ParseException | ParserConfigurationException | SAXException
						| org.json.simple.parser.ParseException e) {
					e.printStackTrace();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
			try {
				SiteReader.exportFileQuiet();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
