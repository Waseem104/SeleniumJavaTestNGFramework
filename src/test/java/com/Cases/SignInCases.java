package com.Cases;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.Base.Base;
import com.pageObject.SignIn;

public class SignInCases extends Base {
	public Actions actions;

	@Test(dataProvider="signin_data")
	public void staffSignin(String Username, String Password) throws Exception {
		SignIn signIn = new SignIn(driver);
		signIn.navigateTo("https://www.ksgcollege.com");
		signIn.clickSignInLink();

		signIn.enterUsername(Username);
		signIn.enterPassword(Password);

		signIn.clickSignInButton();
	}

	// reading data from excel
	@DataProvider(name = "signin_data")
	public String[][] getData() throws Exception {
		File excelFile = new File("C:\\Users\\wasee\\eclipse-workspace\\git\\resources\\signin.xlsx");
		FileInputStream fis = new FileInputStream(excelFile);
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet sheet = workbook.getSheet("sheet1");
		int noOfRows = sheet.getPhysicalNumberOfRows();
		int noOfColumns = sheet.getRow(0).getLastCellNum();

		String[][] data = new String[noOfRows - 1][noOfColumns];
		for (int i = 0; i < noOfRows - 1; i++) {
			for (int j = 0; j < noOfColumns; j++) {
				DataFormatter df = new DataFormatter();
				data[i][j] = df.formatCellValue(sheet.getRow(i + 1).getCell(j));
			}
			System.out.println();
		}
		workbook.close();
		fis.close();

		return data;
	}
}
