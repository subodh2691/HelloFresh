package org.hellofresh.resources;


import org.hellofresh.resources.Reporter;
import org.junit.runner.RunWith;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import cucumber.api.junit.Cucumber;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import cucumber.api.CucumberOptions;
import java.io.File;
import java.io.IOException;

@RunWith(Cucumber.class)
@CucumberOptions(strict = true,
        features = {"src/test/resources/org/hellofresh/features/"},
        glue = {"org.hellofresh.stepdefs"},
        plugin = {"org.hellofresh.resources.ExtentCucumberFormatter:test-output/HellofreshAutomation.html"}
)
public class HelloFreshAutomationRunner extends AbstractTestNGCucumberTests{
	
	@BeforeSuite
	public static void start(){
		System.out.println("Starting");
	}
	
	@BeforeMethod
	public static void beforeMethod(){
		System.out.println("Before Method");
		Reporter.setupEnv("Chrome");
	}
	
	@AfterMethod
	public static void afterMethod() throws IOException{
		Reporter.tearDownEnv();
	}
	
    @AfterSuite
    public static void setup() throws IOException {
    	System.out.println("In After Suite");
        Reporter.loadXMLConfig(new File("src/test/java/org/hellofresh/resources/extent-config.xml"));
        Reporter.setSystemInfo("user", System.getProperty("user.name"));
        Reporter.setSystemInfo("os", "Windows 10");
        Reporter.setTestRunnerOutput("Sample test runner output message");
    }
}
