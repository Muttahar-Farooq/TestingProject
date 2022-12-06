package com.example.testingproject.StepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.AfterAll;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.jupiter.api.Assertions;


public class CartStepDef extends AbstractStepDef{


    @Given("item Radiant Tee is selected")
    public void itemRadiantTeeIsSelected() {

    }

    @And("size XS is selected")
    public void sizeXSIsSelected() {
        homePage.selectSizeRadiantTeeXS();
    }

    @And("color Orange is selected")
    public void colorOrangeIsSelected() {
        homePage.selectRadiantTeeOrange();
    }

    @When("add to cart of selected item is clicked")
    public void addToCartOfSelectedItemIsClicked() {
        homePage.clickRadiantTeeAddToCart();
        homePage.waitTillItemAddedToCart();
    }

    @Then("added to cart message is displayed")
    public void addedToCartMessageIsDisplayed() {
        Assertions.assertTrue(homePage.checkIsItemAddedToCart().contains("You added Radiant Tee to your"));
    }

    @When("cart icon is clicked")
    public void cartIconIsClicked() throws InterruptedException {
        Thread.sleep(1000);
        homePage.clickCartIcon();
    }

    @Then("empty cart message is displayed")
    public void emptyCartMessageIsDisplayed() {
        Assert.assertEquals("You have no items in your shopping cart.", homePage.getEmptyCartItemText());
    }

    @Then("Radian Tee item is shown in cart")
    public void radianTeeItemIsShownInCart() {
        Assert.assertEquals("Radiant Tee", homePage.getItemTitleInCart());
    }

    @And("the item can be checked out")
    public void theItemCanBeCheckedOut() {
        Assert.assertTrue(homePage.checkIsCartProceedButton());
    }

    @Given("item Radiant Tee is added to cart")
    public void itemRadiantTeeIsAddedToCart() throws InterruptedException {
        sizeXSIsSelected();
        colorOrangeIsSelected();
        addToCartOfSelectedItemIsClicked();
        cartIconIsClicked();
        radianTeeItemIsShownInCart();
    }

    @When("remove item button is clicked")
    public void removeItemButtonIsClicked() {
        homePage.removeCartItems();
    }

    @And("OK option is selected in confirmation prompt")
    public void okOptionIsSelectedInConfirmationPrompt() throws InterruptedException {
        Thread.sleep(1000);
        homePage.clickRemoveItemsConfirmationButton();
    }

    @After
    public static void af(){
        //driver.close();
        driver.quit();
    }

}
