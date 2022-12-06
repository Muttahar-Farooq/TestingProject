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

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class SortByStepDef extends AbstractStepDef {

    List<String> sortedPositionOfTitles;
    List<String> sortedPositionOfPrices;

    @Given("Sort By dropdown menu is clicked")
    public void sortByDropdownMenuIsClicked() {
        searchPage.initElement();
        sortedPositionOfTitles = searchPage.allSearchedItemsNames().stream()
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());
        sortedPositionOfPrices = searchPage.allSearchedItemsPrices().stream()
                .mapToLong( string -> Long.parseLong(string.replace("$","").replace(".",""))*-1)
                .sorted()
                .mapToObj(Long::toString)
                .collect(Collectors.toList());
        searchPage.clickOnSortBy();
    }

    @When("Product Name option is selected")
    public void productNameOptionIsSelected() {
        searchPage.selectSortByIndex(0);
    }

    @Then("sorting of searched results should be according to Product Name")
    public void sortingOfSearchedResultsShouldBeAccordingToProductName() {
        Assertions.assertEquals(sortedPositionOfTitles,searchPage.allSearchedItemsNames());
    }

    @When("Price option is selected")
    public void priceOptionIsSelected() {
        searchPage.selectSortByIndex(1);
    }

    @Then("sorting of searched results should be according to Price")
    public void sortingOfSearchedResultsShouldBeAccordingToPrice() {
        Assertions.assertEquals(sortedPositionOfPrices,searchPage.allSearchedItemsPrices().stream().mapToLong(string -> Long.parseLong(string.replace("$","").replace(".",""))*-1).mapToObj(Long::toString)
                .collect(Collectors.toList()));
    }

    @When("Order modifier button is pressed")
    public void orderModifierButtonIsPressed() {
        sortedPositionOfTitles = searchPage.allSearchedItemsNames();
        Collections.reverse(sortedPositionOfTitles);
        searchPage.initElement();
        searchPage.clickOrderModifierToggle();
    }

    @Then("the order of items displayed is reversed")
    public void theOrderOfItemsDisplayedIsReversed() {
        Assertions.assertEquals(sortedPositionOfTitles,searchPage.allSearchedItemsNames());
    }

    @After
    public static void af(){
        //driver.close();
        driver.quit();
    }

}
