package com.gmail.test.SelenideGmail;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import junit.framework.Assert;

import static com.codeborne.selenide.CollectionCondition.*;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;

public class GMailAuthorizationTest {

	@Test
	@Parameters({"url"})
	public void search(String url){
	//	open("https://www.google.com.ua/");
		//ScreenShooter.captureSuccessfulTests = true;
		  GoogleSearchPage searchPage = open(url, GoogleSearchPage.class);
		  GoogleResultsPage resultsPage = searchPage.search("java");
		  resultsPage.results().shouldHave(size(10));
		  resultsPage.results().get(0).shouldHave(text("Javax"));
	}
	
	@Test
	public void loginOld(){
		GoogleSearchPage searchPage = open("https://www.google.com.ua/", GoogleSearchPage.class);
		GoogleLoginPage loginPage = searchPage.goToLoginPage();
		GoogleBasePage basePage = loginPage.login("anry.chushkin@gmail.com", "128333333");
		Assert.assertEquals("Андрей", basePage.getLoginName());
	}
	

	@Test
	@Parameters({"url","login", "password", "nickname"})
	public void login(String url,String login, String password, String nickname){
		GoogleSearchPage searchPage = open(url, GoogleSearchPage.class);
		GoogleLoginPage loginPage = searchPage.goToLoginPage();
		GoogleBasePage basePage = loginPage.login(login, password);
		Assert.assertEquals(nickname, basePage.getLoginName());
	}
}
