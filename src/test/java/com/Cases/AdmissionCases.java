package com.Cases;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.Base.Base;
import com.pageObject.Admission;

public class AdmissionCases extends Base {
	public Actions actions;

	@Test(dataProvider = "Admission_data")
	public void studentAdmission(String Name, String Course_option, String Phone_number, String Parent_number,
			String Reference, String Address) throws Exception {
		Admission admission = new Admission(driver);
		admission.navigateTo("https://www.ksgcollege.com");
		admission.clickAdmissionLink();

		// fill in the admission form
		admission.enterEmail(Name);
		admission.selectGender();
		admission.selectCourse(Course_option);
		admission.enterPhoneNumber(Phone_number);
		admission.enterParentNumber(Parent_number);
		admission.enterReference(Reference);
		admission.enterAddress(Address);

		// submit the form
		admission.clickRegisterButton();

		String expectedUrl = "https://ksgcollege.com/homeadmin/add4.php";
		Assert.assertEquals(admission.getUrl(), expectedUrl);
	}

//reading data from excel sheet
	@DataProvider(name = "Admission_data")
	public String[][] getData() throws Exception {
		File excelFile = new File("C:\\Users\\wasee\\eclipse-workspace\\git\\resources\\Admission_data.xlsx");
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
