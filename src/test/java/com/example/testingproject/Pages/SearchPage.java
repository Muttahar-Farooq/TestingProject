package com.example.testingproject.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;

public class SearchPage {

    List<WebElement> allSearchedItems;
    By bySearchedItemsCss = new By.ByCssSelector(".item.product.product-item");
    By byItemTitleCss = new By.ByCssSelector(".product.name.product-item-name");

    @FindBy(xpath = "/html/body/div[2]/main/div[3]/div[1]/div[2]/div[2]/ol/li[1]/div/div/strong/a")
    public WebElement firstProductItemLink;

    WebDriver driver;

    @FindBy(css = "[data-role = 'sorter']")
    public WebElement sortByDropDown;

    @FindBy(xpath = "/html/body/div[2]/main/div[3]/div[1]/div[2]/div[1]/div[4]/select/option[1]")
    public WebElement sortByProductName;
    
    public  SearchPage(WebDriver driver){
        this.driver = driver;
    }

    public void initElement(){
        PageFactory.initElements(driver, this);
    }

    public WebElement getFirstProductItemLink() {
        return firstProductItemLink;
    }

    public ArrayList<String> allSearchedItemsNames(){
        allSearchedItems = driver.findElements(bySearchedItemsCss);
        ArrayList<String> titles = new ArrayList<>();
        allSearchedItems.forEach(webElement -> {
            titles.add(webElement.findElement(byItemTitleCss).getText());
        });
        return titles;
    }

    public void clickOnSortBy(){
        sortByDropDown.click();
    }

    public void selectSortByProductName(){
        Select sortBySelect = new Select(sortByDropDown);
        sortBySelect.selectByIndex(0);
        //sortByProductName.click();
    }

}
