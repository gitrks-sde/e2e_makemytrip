package testrunners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "features",
glue = "stepdefinitions",
tags = "@sunday",
plugin= {"pretty","html:target/cucumber_reports.html"})
public class TestRunner extends AbstractTestNGCucumberTests {

}
