package com.gmail.test.SelenideGmail;

import org.testng.annotations.Test;

import junit.framework.Assert;

import static com.codeborne.selenide.CollectionCondition.*;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;

public class GMailAuthorizationTest {

	@Test
	public void search(){
	//	open("https://www.google.com.ua/");
		//ScreenShooter.captureSuccessfulTests = true;
		  GoogleSearchPage searchPage = open("https://www.google.com.ua/", GoogleSearchPage.class);
		  GoogleResultsPage resultsPage = searchPage.search("selenide");
		  resultsPage.results().shouldHave(size(10));
		  resultsPage.results().get(0).shouldHave(text("Selenide: лаконичные и стабильные UI тесты на Java"));
	}
	
	@Test
	public void login(){
		GoogleSearchPage searchPage = open("https://www.google.com.ua/", GoogleSearchPage.class);
		GoogleLoginPage loginPage = searchPage.goToLoginPage();
		GoogleBasePage basePage = loginPage.login("anry.chushkin@gmail.com", "128333333");
		Assert.assertEquals("Андрей", basePage.getLoginName());
	}
}
