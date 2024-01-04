package com.Cases;

import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import com.Base.Base;
import com.pageObject.Alumni;

import junit.framework.Assert;

public class AlumniCases extends Base {
	public Actions actions;

	@Test
	public void AlumniPageConfirmation() throws Exception {
		Alumni alumni = new Alumni(driver);
		alumni.navigateTo("https://www.ksgcollege.com");

		alumni.clickAlumniLink();
		alumni.clickAlumniRegistrationLink();

		String expectedTitle = "KSG COLLEGE OF ARTS AND SCIENCE";
		Assert.assertEquals(alumni.getTitle(), expectedTitle);
	}
}
