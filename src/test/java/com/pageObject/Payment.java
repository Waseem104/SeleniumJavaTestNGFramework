package com.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.Actions.CustomActions;

public class Payment extends CustomActions {
	private By paymentLink = By.xpath("//a[contains(text(),'Online Payment')]");
	private By transaction = By.id("txnid");
	private By amount = By.id("amount");
	private By productInfo = By.id("productinfo");
	private By firstname = By.id("firstname");
	private By lastname = By.id("Lastname");
	private By zipcode = By.id("Zipcode");
	private By email = By.id("email");
	private By phone = By.id("phone");
	private By address1 = By.id("address1");
	private By address2 = By.id("address2");
	private By city = By.id("city");
	private By state = By.id("state");
	private By country = By.id("country");
	private By pg = By.id("Pg");
	private By payButton = By.xpath("//input[@id='btnsubmit']");

	public Payment(WebDriver driver) {
		super(driver);
	}

	public void navigateTo(String Url) {
		navigate(Url);
	}

	public void clickPaymentLink() {
		click(paymentLink);
	}

	public void enterTransactionId(String Transaction_ID) {
		clearAndType(transaction, Transaction_ID);
	}

	public void enterAmount(String Amount) {
		clearAndType(amount, Amount);
	}

	public void enterProductInfo(String Product_info) {
		clearAndType(productInfo, Product_info);
	}

	public void enterFirstname(String Firstname) {
		clearAndType(firstname, Firstname);
	}

	public void enterLastname(String Lastname) {
		clearAndType(lastname, Lastname);
	}

	public void enterZipcode(String Zipcode) {
		clearAndType(zipcode, Zipcode);
	}

	public void enterEmail(String Email) {
		clearAndType(email, Email);
	}

	public void enterPhone(String Phone) {
		clearAndType(phone, Phone);
	}

	public void enterAddress1(String Address1) {
		clearAndType(address1, Address1);
	}

	public void enterAddress2(String Address2) {
		clearAndType(address2, Address2);
	}

	public void enterCity(String City) {
		clearAndType(city, City);
	}

	public void enterState(String State) {
		clearAndType(state, State);
	}

	public void enterCountry(String Country) {
		clearAndType(country, Country);
	}

	public void enterPg(String Pg) {
		clearAndType(pg, Pg);
	}

	public void clickPayButton() {
		click(payButton);
	}

}
