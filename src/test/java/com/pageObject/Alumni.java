package com.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.Actions.CustomActions;

public class Alumni extends CustomActions {
	private By alumniLink = By.xpath("//a[text()='Alumni']");
	private By alumniRegistration = By.linkText("ALUMNI REGISTRATION");

	public Alumni(WebDriver driver) {
		super(driver);
	}

	public void navigateTo(String Url) {
		navigate(Url);
	}

	public void clickAlumniLink() {
		click(alumniLink);
	}

	public void clickAlumniRegistrationLink() {
		click(alumniRegistration);
	}
}
