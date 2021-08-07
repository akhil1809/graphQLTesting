package com.test.graphql.Tests;

import org.apache.http.HttpStatus;
import static org.hamcrest.Matchers.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


import org.testng.Assert;


import com.google.gson.Gson;
import com.test.graphql.APIFunction.UserEndPoint;

import com.test.graphql.POJO.Address;
import com.test.graphql.POJO.Users;
import com.test.graphql.Utils.CommonFunction;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import io.restassured.response.Response;
import org.testng.annotations.*;

public class UserTests {

    Users user;
    UserEndPoint userEndPoint;
    String baseURL;
    Gson gson;
    List<Address> addr;

    @Parameters("baseURI")
    @BeforeClass(groups = {"graphql"})
    public void init(@Optional("null")String baseURI)
    {
      user =new Users();
      userEndPoint=new UserEndPoint();
      baseURL=baseURI;
      gson= new Gson();
      addr=new ArrayList<Address>();
      addr.add(new Address("A-1 Indira Colony mala Road, Kota - Rajasthan -324002"));
            
      
      user.setName("Akhilesh");
      user.setAge(34);
      //user.setGender(Gender.MALE);
      user.setAddresses(addr);
      
    }

    @Test(groups = {"graphql"})
    @Severity(SeverityLevel.CRITICAL)
    @Description ("Get The user By Limit")
    @Story("Validate user by limit option")
    public void getUserByLimit()
    {  	
    	user.setLimit(5);
    	int getLimit=user.getLimit();
    	Object payloadCheck= userEndPoint.getQueryByLimit(user);
    	String payload= gson.toJson(payloadCheck);
        Response response= UserEndPoint.getUsersByCounts(payload,getLimit,baseURL,"/user");
        response.then().log().all().assertThat().statusCode(HttpStatus.SC_OK);
        Assert.assertEquals(5,CommonFunction.getResponseOject(response).getJSONObject("data").getJSONArray("userMany").length());
    }

    @Test(groups = {"graphql"},priority = 1)
    @Severity(SeverityLevel.CRITICAL)
    @Description ("Create user with name By")
    @Story("Create user with name")
    public void createUser()
    {  
    	Map<String,Object> hm= new HashMap<String, Object>();
    	
    	hm.put("name", user.getName());
    	hm.put("age", user.getAge());
    	//hm.put("gender", user.getGender());
    	hm.put("address", user.getAddresses());
    	//user.setRecord(hm);
    	
    	//int getLimit=user.getLimit();
    	 Object payloadCheck= userEndPoint.createUser(hm);
    	 String payload= gson.toJson(payloadCheck);
    	 System.out.println(payload);
			
		 Response response=UserEndPoint.getUsers(payload,baseURL,"/user");
		 response.then().log().all().assertThat().statusCode(HttpStatus.SC_OK);
		 
		 String user_id= response.path("data.userCreate.record.name");
		 Assert.assertEquals(user_id, user.getName());
    }
	

}


