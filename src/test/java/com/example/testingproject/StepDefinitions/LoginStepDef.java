package com.example.testingproject.StepDefinitions;

import com.example.testingproject.Pages.HomePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class LoginStepDef extends AbstractStepDef {
    @Given("the home page is opened")
    public void theHomePageIsOpened() {
        homePage.openPage();
    }

    @And("Login Button is clicked")
    public void loginButtonIsClicked() {
        homePage.clickLoginButton();
        loginPage.initElements();
    }

    @Given("the Username is filled with {string}")
    public void theUsernameIsFilledWithSoftwaretestingUnidebHu(String arg0) {
        loginPage.fillEmail(arg0);
    }

    @And("the Password is filled with {string}")
    public void thePasswordIsFilledWithSoftwaretesting(String arg0) {
        loginPage.fillPassword(arg0);
    }

    @When("the Sign In button is clicked")
    public void theSignInButtonIsClicked() {
        loginPage.clickLogin();
    }

    @Then("My Account page is opened")
    public void myAccountPageIsOpened() {
        Assert.assertEquals(HomePage.PAGE_URL, driver.getCurrentUrl());
    }

    @Then("error message is shown")
    public void errorMessageIsShown() {
        Assert.assertTrue(loginPage.checkLoginFailedText());
    }
}
