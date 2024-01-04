package com.Reports;

import java.net.InetAddress;
import java.net.UnknownHostException;

import com.Base.Base;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class Extent extends Base{
    private ExtentReports extentReports;

    public ExtentReports getExtentReports() {
        if (extentReports == null) {
            extentReports = new ExtentReports();
            ExtentSparkReporter reporter = new ExtentSparkReporter(
                    "C:\\Users\\wasee\\eclipse-workspace\\git\\Reports\\Spark.html");
            reporter.config().setReportName("Test Report");
            reporter.config().setDocumentTitle("Tests Results");
            extentReports.attachReporter(reporter);

            extentReports.setSystemInfo("Tester", System.getProperty("user.name"));
            try {
                extentReports.setSystemInfo("Machine", InetAddress.getLocalHost().getHostName());
            } catch (UnknownHostException e) {
                System.out.println("Unable to capture hostname.");
            }
        }
        return extentReports;
    }
}
