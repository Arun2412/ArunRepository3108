package com.example.demo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class InstanceMetaData {
	//The API that provides the details of instance
	private static String url ="http://169.254.169.254/";
	//The URI for querying the meta-data
	private static String metadata = "latest/meta-data/";
	
	//The method to send request and return String response
	public String getAnyData(String url,String path) throws IOException {
		URL urlForGetRequest = new URL(url+path);
	    String readLine = null;
	    HttpURLConnection conection = (HttpURLConnection) urlForGetRequest.openConnection();
	    conection.setRequestMethod("GET");
	    if (conection.getResponseCode() == HttpURLConnection.HTTP_OK) {
	        BufferedReader in = new BufferedReader(new InputStreamReader(conection.getInputStream()));
	        StringBuffer response = new StringBuffer();
	        while ((readLine = in .readLine()) != null) {
	            response.append(readLine);
	        } in .close();
	        return response.toString();
	    } else {
	        return "Request failed";
	    }
	}
	
	//getting ami-id 
	public String getAmiId() throws IOException {
		return getAnyData(url,metadata+"ami-id");
	}
	//getting instance-id
	public String getInstaceId() throws IOException{
		return getAnyData(url,metadata+"instance-id");
	}

	/*
	 * we can get further more details in the same format as specified above
	 * */
}
