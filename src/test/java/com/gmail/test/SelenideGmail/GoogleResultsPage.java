package com.gmail.test.SelenideGmail;

import com.codeborne.selenide.ElementsCollection;
import static com.codeborne.selenide.Selenide.*;

public class GoogleResultsPage {
	public ElementsCollection results() {
	    return $$(".r>a");
	  }
}
