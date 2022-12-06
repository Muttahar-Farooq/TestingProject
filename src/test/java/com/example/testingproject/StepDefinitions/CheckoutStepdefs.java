package com.example.testingproject.StepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.AfterAll;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.jupiter.api.Assertions;

public class CheckoutStepdefs extends AbstractStepDef{
    @And("cart icon is clicked on Hero Hoodie page")
    public void cartIconIsClickedOnHeroHoodiePage() {
        singleItemPage.clickCartButton();
    }

    @And("proceed to cart is clicked")
    public void proceedToCartIsClicked() throws InterruptedException {
        Thread.sleep(1000);
        singleItemPage.clickProceedToCheckout();
    }

    @Given("first name is filled with {string}")
    public void firstNameIsFilledWithSoftware(String fname) {

        checkoutPage.setFirstnameText(fname);
    }

    @And("last name is filled with {string}")
    public void lastNameIsFilledWithTesting(String lname) {
        checkoutPage.setLastnameText(lname);
    }

    @And("address is filled with {string}")
    public void addressIsFilledWithTestAddress(String address) {
        checkoutPage.setAddress(address);
    }

    @And("city is filled with {string}")
    public void cityIsFilledWithTestCity(String city) {
        checkoutPage.setCityText(city);
    }

    @And("zip code is filled with {string}")
    public void zipCodeIsFilledWith(String zipCode) {
        checkoutPage.setPostcodeText(zipCode);
    }

    @And("country is selected as {string}")
    public void countryIsSelectedAsAfghanistan(String country) {
        checkoutPage.setCountry(country);
    }

    @And("phone number is filled with {string}")
    public void phoneNumberIsFilledWith(String num) throws InterruptedException {
        checkoutPage.setTelephoneText(num);
        Thread.sleep(2000);
    }

    @When("next button is clicked")
    public void nextButtonIsClicked() throws InterruptedException {
        checkoutPage.clickNextButton();
        //Thread.sleep(2000);
    }

    @And("place order button is clicked")
    public void placeOrderButtonIsClicked() throws InterruptedException {
        checkoutPage.clickPlaceOrderButton();
        //Thread.sleep(2000);
    }

    @Then("Thank message is shown")
    public void thankMessageIsShown() {
        Assertions.assertEquals("Thank you for your purchase!",checkoutPage.getMainText());
    }

    @Given("email is filled with {string}")
    public void emailIsFilledWithTestingExampleCom(String email) {
        checkoutPage.initElements();
        checkoutPage.setEmailText(email);
    }

    @After
    public static void af(){
        //driver.close();
        driver.quit();
    }

}
