package com.example.testingproject.StepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.AfterAll;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.jupiter.api.Assertions;

public class QuantityMyStepdefs extends AbstractStepDef{
    @And("size {string} is selected")
    public void sizeSIsSelected(String size) {
        singleItemPage.selectElementWithLabel(size);
    }

    @And("quantity is set to {string}")
    public void quantityIsSetTo(String quantity) throws InterruptedException {
        singleItemPage.enterQuantity(quantity);
    }

    @When("add to cart is selected")
    public void addToCartIsSelected() throws InterruptedException {
        Thread.sleep(500);
         singleItemPage.clickAddToCartButton();
    }

    @Then("Cart should have {string} items")
    public void cartShouldHaveItems(String quantity) {
        Assertions.assertEquals(quantity, singleItemPage.getNumberOfItemsInCart());
    }

    @Then("Purchase limit error must be shown")
    public void purchaseLimitErrorMustBeShown() {
        Assertions.assertEquals("The maximum you may purchase is 10000.",singleItemPage.quantityErrorMessage());
    }

    @After
    public static void af(){
        //driver.close();
        driver.quit();
    }
}
