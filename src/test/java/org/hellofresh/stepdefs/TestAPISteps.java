package org.hellofresh.stepdefs;

import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONObject;
import junit.framework.Assert;

import com.jayway.restassured.response.Response;
import org.hellofresh.resources.RestApiMethods;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class TestAPISteps 
{
	String baseUrl="http://services.groupkt.com";
	String resUrl;
	Response actResponse;
	RestApiMethods api;
	
	public TestAPISteps (RestApiMethods api)
	{
		//this.actResponse;		
	}	
	
	@Given("^with resource url as \"([^\"]*)\" ,get request details$")
	public void get_request_all_countries(String resoureUrl) 
	{
		System.out.println("Get url : "+baseUrl+resoureUrl);
		api=new RestApiMethods();
		actResponse=null;
		
		actResponse=api.getRequest(baseUrl,resoureUrl);
		System.out.println("Actual Status Response Code : "+actResponse.getStatusCode());
		System.out.println("Actual Response : "+actResponse.asString());

	}

	
	@Given("^with resource url as \"([^\"]*)\" ,post request to add country with json as:$")
	public void post_request_to_add_country(String resoureUrl,String json) 
	{
		System.out.println("post url : "+baseUrl+resoureUrl);
		api=new RestApiMethods();
		actResponse=null;
		
		actResponse=api.postRequest(baseUrl,resoureUrl,json);
		System.out.println("Actual Status Response Code : "+actResponse.getStatusCode());
		System.out.println("Actual Response : "+actResponse.asString());

	}
	
	@Then("^verify respone with status code as \"([^\"]*)\"$")
	public void verify_respone_status_code_as(String exptStatusCode)
	{
		Assert.assertTrue("Actual Response : "+actResponse.asString()+"\n"+
				"Expected status : "+exptStatusCode+" , Actual status : "+Integer.toString(actResponse.getStatusCode()),exptStatusCode.trim().equalsIgnoreCase(Integer.toString(actResponse.getStatusCode())));
	}

	@And("^validate that \"([^\"]*)\" were returned in the response$")	
	public void verifyJsonResponse(String dataToVerify)
	{
		Assert.assertTrue("Verification failed for codes : "+dataToVerify,verifyCountryCodes(actResponse.asString(), dataToVerify));
	}

	@And("^validate that country name \"([^\"]*)\" were returned in the response$")	
	public void verifyJsonResponse1(String dataToVerify)
	{
		Assert.assertTrue("Verification failed for country name : "+dataToVerify,verifyCountryName(actResponse.asString(), dataToVerify));
	}

	public boolean verifyCountryCodes(String resonse,String countryCodes)
	{
		boolean bFlag=false;
		String[] arrCountryCOdes=countryCodes.split(",");
		ArrayList<String> arrCountryCodes = new ArrayList<String>();
		
		try
		{
		    JSONObject outerObject = new JSONObject(resonse);		    
		    JSONArray jsonArray = outerObject.getJSONObject("RestResponse").getJSONArray("result");
		    
		    for (int i = 0; i < jsonArray.length(); i++)
		    {
			    arrCountryCodes.add(jsonArray.getJSONObject(i).getString("alpha2_code"));
		    }

		    int nCount=0;
		    for(int i=0;i<arrCountryCOdes.length;i++)
		    {
		    	if(arrCountryCodes.contains(arrCountryCOdes[i].trim()))
    			{
		    		nCount++;
    			}
		    }
		    
		    
		    if(nCount==arrCountryCOdes.length)
		    {
		    	bFlag=true;
		    }
		    
		}
		catch(Exception err)
		{
			err.printStackTrace();
		}
		
		return bFlag;
	}
	
	public boolean verifyCountryName(String resonse,String expCountryName)
	{
		boolean bFlag=false;
		
		try
		{
		    JSONObject outerObject = new JSONObject(resonse);		    
		    String actCountryName = outerObject.getJSONObject("RestResponse").getJSONObject("result").getString("name");
		    if(actCountryName.equalsIgnoreCase(expCountryName))
		    {
		    	bFlag=true;
		    }
		}
		catch(Exception err)
		{
			err.printStackTrace();
		}

		return bFlag;
	}
}
