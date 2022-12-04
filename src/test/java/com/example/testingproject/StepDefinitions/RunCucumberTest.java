package com.example.testingproject.StepDefinitions;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features={"src/test/resources/com.example.testingproject"},plugin = {"pretty"})
public class RunCucumberTest {

}
