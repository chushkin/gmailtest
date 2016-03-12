package com.gmail.test.SelenideGmail;


import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.*;

public class GoogleSearchPage {
	  @FindBy(how = How.NAME, using = "q")
	  private SelenideElement searchBox;
	  
	  @FindBy(how = How.CSS, using = "div.gb_mc>a[href*='ServiceLogin']")
	  private SelenideElement loginButton;
	  
	  public GoogleResultsPage search(String query) {
	    searchBox.setValue(query).pressEnter();
	    return page(GoogleResultsPage.class);
	  }
	  
	  public GoogleLoginPage goToLoginPage(){
		  loginButton.click();
		  return page(GoogleLoginPage.class);
	  }
}
