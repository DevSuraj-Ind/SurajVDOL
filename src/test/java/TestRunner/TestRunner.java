package TestRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features="src/test/resources",
                 glue = {"stepDefinitions"},
                 plugin= {"pretty","html:Reports/cucumber-Report.html","json:Reports/cucumber-Report.json","com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},
                 tags= "@E2E",
                 monochrome=true    
)
public class TestRunner extends AbstractTestNGCucumberTests {

}







