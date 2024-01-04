package com.Base;

import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

public class Base {
	public WebDriver driver;
	public Logger log = LogManager.getLogger(Base.class.getName());

	@Parameters("browser")
	@BeforeClass
	public void setUp(@Optional("chrome") String browser) {
		driver = selectBrowser(browser);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		log.info("driver is initialized");
	}

	public WebDriver selectBrowser(String browser) {
		switch (browser.toLowerCase()) {
		case "chrome":
			System.setProperty("webdriver.chrome.driver",
					"C:\\Users\\wasee\\eclipse-workspace\\git\\drivers\\chromedriver.exe");
			return new ChromeDriver();
		case "firefox":
			System.setProperty("webdriver.gecko.driver",
					"C:\\Users\\wasee\\eclipse-workspace\\git\\drivers\\geckodriver.exe");
			return new FirefoxDriver();
		case "edge":
			System.setProperty("webdriver.edge.driver",
					"C:\\Users\\wasee\\eclipse-workspace\\git\\drivers\\msedgedriver.exe");
			return new EdgeDriver();
		default:
			throw new IllegalArgumentException("Invalid browser specified: " + browser);
		}
	}

	@AfterClass
	public void TearDown() {
		if (driver != null) {
			driver.quit();
			log.info("driver is closed");
		}
	}
}
