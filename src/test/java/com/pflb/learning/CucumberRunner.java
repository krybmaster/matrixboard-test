package com.pflb.learning;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(
        strict = true,
        features = {"src/test/resources/features"},
        glue = "com.pflb.learning.stepdefinition"
)
public class CucumberRunner extends AbstractTestNGCucumberTests {
}
