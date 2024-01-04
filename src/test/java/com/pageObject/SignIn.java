package com.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.Actions.CustomActions;

public class SignIn extends CustomActions {
	private By signInLink = By.linkText("Staff Login");
	private By usernameField = By.id("exampleInputUsername");
	private By passwordField = By.id("exampleInputPassword");
	private By signInButton = By.xpath("//button[text()='Sign In']");

	// constructor
	public SignIn(WebDriver driver) {
		super(driver);
	}

	public void navigateTo(String url) {
		navigate(url);
	}

	public void clickSignInLink() {
		click(signInLink);
	}

	public void enterUsername(String Username) {
		type(usernameField, Username);
	}

	public void enterPassword(String Password) {
		type(passwordField, Password);
	}

	public void clickSignInButton() {
		click(signInButton);
	}

}
