package com.example.testingproject.StepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.AfterAll;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.jupiter.api.Assertions;

public class ColorChangeStepDef extends AbstractStepDef{
    @Given("the user is on Hero Hoodie page")
    public void theUserIsOnHeroHoodiePage() {
        setDriver();
        singleItemPage.openHeroHoodiePage();
        singleItemPage.initElements();
    }

    @When("{string} is selected")
    public void colorIsSelected(String arg0) {
        singleItemPage.selectElementWithLabel(arg0);
    }

    @Then("main image has the link {string}")
    public void mainImageHasTheLinkHref(String arg0) throws InterruptedException {
        Thread.sleep(500);
        Assertions.assertEquals(arg0, singleItemPage.getLinkOfMainImage());
    }

    @After
    public static void af(){
        //driver.close();
        driver.quit();
    }
}
