package com.learning.helper;

import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public abstract class WebStorageActionsHelper {

	private String storageType;
	private JavascriptExecutor js;
	
	public WebStorageActionsHelper(String storageType, WebDriver driver) {
		this.storageType = storageType;
		js = (JavascriptExecutor) driver;
	}
	
	public long getStorageLength() {
		String script = String.format("return window.%s.length;", storageType) ;
		return ((Number) js.executeScript(script)).longValue();
	}
	
	@SuppressWarnings("unchecked")
	public List<String> getStorageKeys() {
		String script = String.format("return Object.keys(window.%s);", storageType);
		return (List<String>) js.executeScript(script);
	}
	
	public void clearStorge() {
		String script = String.format("window.%s.clear()", storageType);
		js.executeScript(script);
	}
	
	public String getValueByKey(String key) {
		String script = String.format("return window.%s.getItem('%s');", storageType, key);
		return (String) js.executeScript(script);
	}
	
	public String getKeyByIndex(int keyIndex) {
		String script = String.format("return window.%s.key(%d);", storageType, keyIndex);
		return (String) js.executeScript(script);
	}
	
	public void removeItemByKey(String key) {
		String script = String.format("window.%s.removeItem('%s');", storageType, key);
		js.executeScript(script);
	}

	public void setItem(String key, String value) {
		String script = String.format("window.%s.setItem('%s', '%s');", storageType, key, value);
		js.executeScript(script);
	}
	
}
