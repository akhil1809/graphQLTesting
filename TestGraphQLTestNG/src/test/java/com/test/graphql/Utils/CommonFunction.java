package com.test.graphql.Utils;

import org.json.JSONArray;
import org.json.JSONObject;

import com.google.gson.JsonParser;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class CommonFunction {

   public String generateRandomString(int n)
   {
      String alphaNuemeric = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
              + "0123456789"
              + "abcdefghijklmnopqrstuvxyz";

      StringBuilder stringBuilder= new StringBuilder(n);
      for(int i=0;i <n;i++)
      {
          int index= (int)(alphaNuemeric.length() * Math.random());
          stringBuilder.append(alphaNuemeric.charAt(index));
      }
      return  stringBuilder.toString();
   }


public static JSONArray  getResponseArray(Response response)
{
	try
	{
		JSONArray jsonArr= new JSONArray(response.getBody().asString());
		return jsonArr;
	}
	catch (Exception e) {
		
		
		e.printStackTrace();
		return null;
	
	}
}

public static JSONObject getResponseOject(Response response)
{
	
	try
	{
		JSONObject jsonObj= new JSONObject(response.getBody().asString());
		return jsonObj;
	}
	catch (Exception e) {
		
		e.printStackTrace();
		return null;
		// TODO: handle exception
	}
}

public static JSONArray getArrayInList(Response response,String list)
{
	
	try
	{
		JSONObject jsonObj= new JSONObject(response.getBody().asString());
		
	  	JSONArray arr= jsonObj.getJSONArray(list);
	  	 return arr;
		
	}
	catch (Exception e) {
		
		e.printStackTrace();
		return null;
		// TODO: handle exception
	}
}

}
