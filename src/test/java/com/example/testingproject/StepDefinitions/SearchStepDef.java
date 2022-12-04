package com.example.testingproject.StepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;

public class SearchStepDef extends AbstractStepDef{
    @Given("search bar is clicked")
    public void searchBarIsClicked() {
    }

    @And("item name {string} is typed")
    public void itemNameIsTyped(String arg0) {
        homePage.addTextSearchBar(arg0);
    }

    @When("enter button is pressed")
    public void enterButtonIsPressed() {
        homePage.enterSearchBar();
    }

    @Then("search page is opened")
    public void searchPageIsOpened() {
        Assertions.assertTrue(driver.getCurrentUrl().contains("https://magento.softwaretestingboard.com/catalogsearch/result"));
    }

    @And("item {string} should be present in search result")
    public void itemShouldBePresentInSearchResult(String arg0) {
        searchPage.initElement();
        Assertions.assertEquals(searchPage.getFirstProductItemLink().getText(),arg0);
    }

    @And("item {string} should be NOT be present in ANY search result")
    public void itemShouldBeNOTBePresentInANYSearchResult(String arg0) {
        Assertions.assertFalse(searchPage.allSearchedItemsNames().contains(arg0));
    }
}
