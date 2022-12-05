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

    private List<WebElement> allSearchedItems;
    private By bySearchedItemsCss = new By.ByCssSelector(".item.product.product-item");
    private By byItemTitleCss = new By.ByCssSelector(".product.name.product-item-name");
    private By byItemPriceCss = new By.ByCssSelector(".price");

    @FindBy(xpath = "/html/body/div[2]/main/div[3]/div[1]/div[2]/div[2]/ol/li[1]/div/div/strong/a")
    private WebElement firstProductItemLink;

    @FindBy(css = "[data-role = 'sorter']")
    private WebElement sortByDropDown;

    @FindBy(css = ".action.sorter-action")
    private WebElement orderModifierToggle;

    WebDriver driver;
    
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

    public ArrayList<String> allSearchedItemsPrices(){
        allSearchedItems = driver.findElements(bySearchedItemsCss);
        ArrayList<String> prices = new ArrayList<>();
        allSearchedItems.forEach(webElement -> {
            prices.add(webElement.findElement(byItemPriceCss).getText());
        });
        return prices;
    }

    public void clickOnSortBy(){
        sortByDropDown.click();
    }

    public void selectSortByIndex(Integer index){
        Select sortBySelect = new Select(sortByDropDown);
        sortBySelect.selectByIndex(index);
    }

    public void clickOrderModifierToggle(){ orderModifierToggle.click();}

}
