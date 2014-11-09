package org.usc.edu.csci572.jobs.search;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashSet;

public class Search {

	HashSet<String> regionMap = null;
	/**
	 * @param args
	 */
	public static void main(String[] args) {		
		Search app = new Search();
		app.init();
	}
	
	public void init() {
		regionMap = new HashSet<String>();
	}
	
	public void performQueries() throws Exception {
		URL u = new URL("");
        HttpURLConnection c = (HttpURLConnection) u.openConnection();
        c.setRequestMethod("GET"); 
        c.connect();
        int status = c.getResponseCode();
        
	}
	
	public void mapLocations() {
		
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
