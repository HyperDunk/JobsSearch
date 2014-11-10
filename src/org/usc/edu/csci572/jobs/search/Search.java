package org.usc.edu.csci572.jobs.search;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashSet;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class Search {

	HashSet<String> regionMap = null;
	HashSet<String> citiesMap = null;
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
		citiesMap = new HashSet<String>();
	}
	
	public void performQueries() {
		
	}
	
	public void mapLocations() throws Exception{
		URL u = new URL("http://localhost:8983/solr/collection1/select?q=*.*&rows=264486&fl=location2&wt=json&indent=true");
        HttpURLConnection c = (HttpURLConnection) u.openConnection();
        c.setRequestMethod("GET"); 
        c.connect();
        int status = c.getResponseCode();
       // System.out.println(status);
        if(status == 200 || status == 201) {
        	InputStream is = c.getInputStream();
        	JSONParser jsonParser = new JSONParser();
        	InputStreamReader isr = new InputStreamReader(is);
        	JSONObject resJson = (JSONObject) jsonParser.parse(isr);
        	//System.out.println("\n"+resJson);
        	
        	JSONObject resValueJSON = (JSONObject) resJson.get("response");
        	JSONArray docsJSON = (JSONArray) resValueJSON.get("docs");
        	//System.out.println(docsJSON);
        	for(int i=0; i<docsJSON.size(); i++) {
        		JSONObject locJSON = (JSONObject) docsJSON.get(i);
        		String ch[] = locJSON.get("location2").toString().split(",");
        		//System.out.println("tokens:"+ch[ch.length-1]);
        		//System.out.println("tokens:"+ch[0]);

        		regionMap.add(ch[ch.length-1].toLowerCase());
        		if(ch.length > 1) {
        			citiesMap.add(ch[ch.length-2]);
        		}
        		
        	}
        	System.out.println(regionMap);
        	System.out.println(citiesMap);
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
