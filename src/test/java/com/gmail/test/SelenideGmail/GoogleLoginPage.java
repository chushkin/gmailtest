package com.gmail.test.SelenideGmail;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.*;

public class GoogleLoginPage {
	@FindBy(how = How.ID, using = "Email")
	private SelenideElement emailInput;
	
	@FindBy(how = How.ID, using = "next")
	private SelenideElement nextButton;
	
	@FindBy(how = How.ID, using = "Passwd")
	private SelenideElement passwordInput;
	
	@FindBy(how = How.ID, using = "signIn")
	private SelenideElement signInButton;
	
	public void enterEmail(String email){
		emailInput.setValue(email);
	}
	
	public void clickNext(){
		nextButton.click();
	}
	
	public void enterPassword(String password){
		passwordInput.setValue(password);
	}
	
	public void clickSignIn(){
		signInButton.click();
	}
	
	public GoogleBasePage login(String email, String password){
		enterEmail(email);
		clickNext();
		enterPassword(password);
		clickSignIn();
		return page(GoogleBasePage.class);
	}
}
