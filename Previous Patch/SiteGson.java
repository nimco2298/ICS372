//package siteCollection;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException; 
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
// This is the main class that will read in JSON formatted objects and convert them to java objects.
public class SiteGson {
	
	public static void writeFile() throws IOException {
	File projectDirectory = new File(new java.io.File("").getAbsolutePath());
	projectDirectory.mkdirs();
	File outputFile = new File(projectDirectory, "Results.json");
	outputFile.createNewFile();
	JOptionPane.showMessageDialog(null, "Please check your project directory folder for results", "Json Export",
				JOptionPane.INFORMATION_MESSAGE);
	try (PrintWriter pw = new PrintWriter(outputFile)) {
		//this will determine what is printed to the file
		pw.println(Site.activeSites);
		}
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
	
		Gson gson = new Gson();
		BufferedReader br = null;
		SiteLinkedBag a = new SiteLinkedBag();
		
		try {
		 br = new BufferedReader(new FileReader("example.json"));
		 Result result = gson.fromJson(br, Result.class);
		 
		 	if(result != null) {
		 		for(SiteReading t: result.getSiteReadings()) {
		 			a.add(t);
		 		}
		 	}
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		} finally {
			if (br != null) {
				br.close();
			}
		}
			a.display();
	}

}
