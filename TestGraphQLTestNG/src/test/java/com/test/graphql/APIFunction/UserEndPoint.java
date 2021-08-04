package com.test.graphql.APIFunction;

import java.util.ArrayList;
import java.util.List;

import com.test.graphql.POJO.Address;
import com.test.graphql.POJO.Query;
import com.test.graphql.POJO.Users;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class UserEndPoint {

   // private static RequestSpecification requestSpecification;
   public Query query;
   public Users users;

    public UserEndPoint()
    {
        query=new Query();
        users=new Users();
    }


    public static RequestSpecification setUserHeader(String baseURI)
    {
        RequestSpecification requestSpecification = RestAssured.given().baseUri(baseURI).contentType(ContentType.JSON);
        return requestSpecification;
    }

    public static Response getUsersByCounts(String payload,int limit,String baseURI,String path)
    {
        Response  response=RestAssured.given().log().all().spec(setUserHeader(baseURI)).body(payload).when().log().all().post(path);
        return response;
    }

    public static Response getUsers(String payload,String baseURI,String path)
    {
        Response  response=RestAssured.given().log().all().spec(setUserHeader(baseURI)).body(payload).when().log().all().post(path);
        return response;
    }

    
    public Query getQueryByLimit(Object object)
    {
        query.setQuery("query getmanyUser($limit: Int) {\n" +
                "  userMany(limit: $limit)\n" +
                "  {\n" +
                "    name\n" +
                "    age\n" +
                "    gender\n" +
                "    languages\n" +
                "    {\n" +
                "     language\n" +
                "    }\n" +
                "    }\n" +
                "  }");
        query.setVariableVal(object);
        return query;

    }

   public enum Gender {
    	MALE,FEMALE
    }
   
   public Query createUser(Object object)
   {
	   query.setQuery("mutation ($name :String,$age :Float, $street : String)\n"
	   		+ "{\n"
	   		+ "  userCreate(record:{name :$name,age:$age, address :{street: $street}})\n"
	   		+ "  {\n"
	   		+ "    record\n"
	   		+ "    {\n"
	   		+ "      name\n"
	   		+ "      age\n"
	   		+ "      _id\n"
	   		+ "    }\n"
	   		+ "    \n"
	   		+ "  }\n"
	   		+ "}");
	   
	   query.setVariableVal(object);
       return query;
   }
   
	   
   

}
