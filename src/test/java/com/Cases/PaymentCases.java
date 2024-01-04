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
import com.pageObject.Payment;

import junit.framework.Assert;

public class PaymentCases extends Base {
	public Actions actions;

	@Test(dataProvider = "Payment_data")
	public void OnlinePayment(String Transaction_ID, String Amount, String Product_info, String Firstname,
			String Lastname, String Zipcode, String Email, String Phone, String Address1, String Address2, String City,
			String State, String Country, String Pg) {
		Payment payment = new Payment(driver);
		payment.navigateTo("https://www.ksgcollege.com");
		payment.clickPaymentLink();

		// fill in the payment form
		payment.enterTransactionId(Transaction_ID);
		payment.enterAmount(Amount);
		payment.enterProductInfo(Product_info);
		payment.enterFirstname(Firstname);
		payment.enterLastname(Lastname);
		payment.enterZipcode(Zipcode);
		payment.enterEmail(Email);
		payment.enterPhone(Phone);
		payment.enterAddress1(Address1);
		payment.enterAddress2(Address2);
		payment.enterCity(City);
		payment.enterState(State);
		payment.enterCountry(Country);
		payment.enterPg(Pg);

		// click pay button
		payment.clickPayButton();

		String expectedTitle = "Payment Page";
		Assert.assertEquals(payment.getTitle(), expectedTitle);
	}
	// providing data from excel sheet

	@DataProvider(name = "Payment_data")
	public String[][] getData() throws Exception {
		File excelFile = new File("C:\\Users\\wasee\\eclipse-workspace\\git\\resources\\payment_data.xlsx");
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
