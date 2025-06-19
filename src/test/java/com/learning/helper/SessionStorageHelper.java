package com.learning.helper;

import org.openqa.selenium.WebDriver;

public class SessionStorageHelper extends WebStorageActionsHelper {

	public SessionStorageHelper(WebDriver driver) {
		super(STRINGS.SESSION_STORAGE, driver);
	}
	
}
