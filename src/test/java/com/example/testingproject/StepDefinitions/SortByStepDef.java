package com.example.testingproject.StepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class SortByStepDef extends AbstractStepDef {

    List<String> sortedPositionOfTitles;

    @Given("Sort By dropdown menu is clicked")
    public void sortByDropdownMenuIsClicked() {
        searchPage.initElement();
        sortedPositionOfTitles = searchPage.allSearchedItemsNames().stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
        searchPage.clickOnSortBy();
    }

    @When("Product Name option is selected")
    public void productNameOptionIsSelected() {
        searchPage.selectSortByProductName();
    }

    @Then("sorting of searched results should be according to Product Name")
    public void sortingOfSearchedResultsShouldBeAccordingToProductName() {
        Assertions.assertEquals(sortedPositionOfTitles,searchPage.allSearchedItemsNames());
    }
}
