package com.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.Actions.CustomActions;

public class Admission extends CustomActions {

//WebElements Locators
	private By admissionLink = By.xpath("//*[@id=\"category-part\"]/div/div/div/div[1]/div[2]/center/a");
	private By name = By.name("email");
	private By gender = By.xpath("/html/body/div[1]/div/div[2]/div/form/div[2]/label[1]");
	private By course = By.name("co");
	private By phoneNumber = By.name("pn");
	private By parentNumber = By.name("fn");
	private By reference = By.name("Pleasem");
	private By address = By.name("story");
	private By registerButton = By.name("submit");

	// constructor
	public Admission(WebDriver driver) {
		super(driver);
	}

	// Methods to interact with the elements
	public void navigateTo(String url) {
		driver.get(url);
	}

	public void clickAdmissionLink() {
		click(admissionLink);
	}

	public void enterEmail(String Name) {
		type(name, Name);
	}

	public void selectGender() {
		click(gender);
	}

	public void selectCourse(String Course_option) {
		selectDropdownByVisibleText(course, Course_option);
	}

	public void enterPhoneNumber(String Phone_number) {
		type(phoneNumber, Phone_number);
	}

	public void enterParentNumber(String Parent_number) {
		type(parentNumber, Parent_number);
	}

	public void enterReference(String Reference) {
		type(reference, Reference);
	}

	public void enterAddress(String Address) {
		clearAndType(address, Address);
	}

	public void clickRegisterButton() {
		click(registerButton);
	}

}
