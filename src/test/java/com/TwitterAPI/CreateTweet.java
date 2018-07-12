package com.TwitterAPI;

import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

public class CreateTweet {

	String ConsumerKey = "evaGJTn3Jr0BhoYDUq3Jke5xL";
	String ConsumerSecret = "Nmt0v7xCWAITZRzFKlgzY2pLzLfyM9Bq5rWqfSFHbkKsbhEFHL";
	String Token = "1017012161976119297-UUtSiRoo0UdClMERP4dqJ0mGQ8B85N";
	String TokenSecret = "xHAmm5kgmKRosTc3kcBr96IyxpwTOZKq4nMEEsTSBDWXW";

	@Test
	public void createTweet() {

		RestAssured.baseURI = "https://api.twitter.com/1.1/statuses";
		Response res = given().auth().oauth(ConsumerKey, ConsumerSecret, Token, TokenSecret)
				.queryParam("status", "Hello Twitter, i am creating this tweet with automation 2").when()
				.post("/update.json").then().extract().response();

		String response = res.asString();
		System.out.println(response);
		JsonPath js = new JsonPath(response);
		System.out.println(js.get("text"));
		System.out.println(js.get("id"));

	}
}
