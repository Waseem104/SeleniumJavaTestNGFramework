package com.Utils;

import java.io.File;
import java.util.concurrent.ThreadLocalRandom;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.Base.Base;

public class Utils extends Base{
	public String captureScreenShot(String testCaseName, WebDriver driver) throws Exception {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		String destination = System.getProperty("user.dir") + "//Reports" + testCaseName + "_"
				+ ThreadLocalRandom.current().nextInt() + ".png";
		FileUtils.copyFile(source, new File(destination));
		return destination;
	}
}
