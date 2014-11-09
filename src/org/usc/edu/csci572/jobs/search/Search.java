package org.usc.edu.csci572.jobs.search;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashSet;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class Search {

	HashSet<String> regionMap = null;
	/**
	 * @param args
	 */
	public static void main(String[] args) {		
		Search app = new Search();
		app.init();
		try {
			app.mapLocations();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void init() {
		regionMap = new HashSet<String>();
	}
	
	public void performQueries() {
		
	}
	
	public void mapLocations() throws Exception{
		URL u = new URL("http://localhost:8983/solr/collection1/select?q=location2%3A*&rows=100&fl=location2&wt=json&indent=true");
        HttpURLConnection c = (HttpURLConnection) u.openConnection();
        c.setRequestMethod("GET"); 
        c.connect();
        int status = c.getResponseCode();
        System.out.println(status);
        if(status == 200 || status == 201) {
        	InputStream is = c.getInputStream();
        	JSONParser jsonParser = new JSONParser();
        	InputStreamReader isr = new InputStreamReader(is);
        	JSONObject resJson = (JSONObject) jsonParser.parse(isr);
        	System.out.println(resJson);
        }
	}
	
	public void query1() {
		
	}
	
	public void query2() {
		
	}
	
	public void query3() {
		
	}
	
	public void query4() {
		
	}

}
