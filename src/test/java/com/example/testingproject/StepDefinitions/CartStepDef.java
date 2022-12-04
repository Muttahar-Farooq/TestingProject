package com.example.testingproject.StepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class CartStepDef extends AbstractStepDef{
    @Given("item Radiant Tee is selected")
    public void itemRadiantTeeIsSelected() {

    }

    @And("size XS is selected")
    public void sizeXSIsSelected() {
        homePage.selectSizeRadiantTeeXS();
    }

    @And("color Orange is selected")
    public void colorOrangeIsSelected() throws InterruptedException {
        homePage.selectRadiantTeeOrange();
    }

    @When("add to cart of selected item is clicked")
    public void addToCartOfSelectedItemIsClicked() throws InterruptedException {
        homePage.clickRadiantTeeAddToCart();
    }

    @Then("added to cart message is displayed")
    public void addedToCartMessageIsDisplayed() throws InterruptedException {
        Assert.assertTrue(homePage.checkIsItemAddedToCart().contains("You added Radiant Tee to your"));
    }

    @When("cart icon is clicked")
    public void cartIconIsClicked() {
        homePage.clickCartIcon();
    }

    @Then("empty cart message is displayed")
    public void emptyCartMessageIsDisplayed() {
        Assert.assertEquals("You have no items in your shopping cart.", homePage.getNoItemCartMessage());
    }
}
