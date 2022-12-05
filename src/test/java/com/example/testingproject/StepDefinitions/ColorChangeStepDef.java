package com.example.testingproject.StepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;

public class ColorChangeStepDef extends AbstractStepDef{
    @Given("the user is on Hero Hoodie page")
    public void theUserIsOnHeroHoodiePage() {
        singleItemPage.openHeroHoodiePage();
        singleItemPage.initElements();
    }

    @When("{string} is selected")
    public void colorIsSelected(String arg0) {
        singleItemPage.selectColor(arg0);
    }

    @Then("main image has the link {string}")
    public void mainImageHasTheLinkHref(String arg0) throws InterruptedException {
        Thread.sleep(500);
        Assertions.assertEquals(arg0, singleItemPage.getLinkOfMainImage());
    }
}
