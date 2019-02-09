package siteCollection;

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

public class SiteGson {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
	
		Gson gson = new Gson();
		BufferedReader br = null;
		
		try {
		 br = new BufferedReader(new FileReader("example.json"));
		 Result result = gson.fromJson(br, Result.class);
		 
		 	if(result != null) {
		 		for(SiteReading t: result.getSiteReadings()) {
		 			System.out.println(t.getSiteId() + " - " +t.getReadingType() + " - " + t.getReadingId() + " - "
		 					+ t.getReadingValue() + " - " +t.getReadingDate());
		 		}
		 	}
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		} finally {
			if (br != null) {
				br.close();
			}
		}
	}

}
