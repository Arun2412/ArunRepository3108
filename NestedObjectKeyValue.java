package com.example.demo;

import org.json.JSONException;
import org.json.JSONObject;

public class NestedObjectKeyValue {
	
	public String nestedKeyValue(String input, String key) {
		try {
		     JSONObject jsonObject = new JSONObject(input);
		     String output = null;
			 String[] keysArray = key.split("/");
			 for(int i=0; i<keysArray.length; i++) { 
				if(jsonObject.has(keysArray[i])) {
					if(i!=keysArray.length-1) {
						if(jsonObject.getJSONObject(keysArray[i]) instanceof JSONObject) {
							jsonObject = (JSONObject) jsonObject.getJSONObject(keysArray[i]);
						}
					}else {
						if(jsonObject.get(keysArray[i]) instanceof String) {
							output = jsonObject.get(keysArray[i]).toString();
						}
					}
				}else {
					return "input key is not valid";
				}
			 }
			 return output;
		}catch (JSONException err){
		     return err.getMessage();
		}
	}

}
