package com.Actions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class CustomActions {
	protected WebDriver driver;

	public CustomActions(WebDriver driver) {
		this.driver = driver;
	}

	public void navigate(String url) {
		driver.get(url);
	}

	public void click(By locator) {
		driver.findElement(locator).click();
	}

	public void type(By locator, String text) {
		WebElement element = driver.findElement(locator);
		element.sendKeys(text);
	}

	public void clearAndType(By locator, String text) {
		WebElement element = driver.findElement(locator);
		element.clear();
		element.sendKeys(text);
	}

	public void selectDropdownByVisibleText(By locator, String text) {
		WebElement dropdown = driver.findElement(locator);
		Select select = new Select(dropdown);
		select.selectByVisibleText(text);
	}

	public String getUrl() {
		return driver.getCurrentUrl();
	}

	public String getTitle() {
		return driver.getTitle();
	}
}
