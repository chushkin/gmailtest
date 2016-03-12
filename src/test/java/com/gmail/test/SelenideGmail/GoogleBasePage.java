package com.gmail.test.SelenideGmail;

import static com.codeborne.selenide.Selenide.page;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.codeborne.selenide.SelenideElement;

public class GoogleBasePage {
	@FindBy(how = How.CSS, using =".gb_P.gb_R")
	private SelenideElement loginName;
	
	 @FindBy(how = How.CSS, using = "div.gb_mc>a[href*='ServiceLogin']")
	 private SelenideElement loginButton;
	
	public String getLoginName(){
		return loginName.getText();
	}
	
	public GoogleLoginPage goToLoginPage(){
		loginButton.click();
		return page(GoogleLoginPage.class);
	}
}
