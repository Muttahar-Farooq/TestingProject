package com.example.testingproject.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage {

    public static final String PAGE_URL = "https://magento.softwaretestingboard.com/";
    public static final Integer EXPLICIT_WAIT = 10;

    @FindBy(xpath = "//header/div[1]/div[1]/ul[1]/li[2]/a[1]")
    WebElement loginButton;

    @FindBy(xpath = "//*[@id=\"maincontent\"]/div[3]/div/div[2]/div[3]/div/div/ol/li[3]")
    WebElement radiantTeeShirt;

    @FindBy(id = "option-label-size-143-item-166")
    WebElement radiantTeeXsSize;

    @FindBy(id = "option-label-color-93-item-56")
    WebElement radiantTeeOrange;

    @FindBy(xpath = "//*[@id=\"maincontent\"]/div[3]/div/div[2]/div[3]/div/div/ol/li[1]/div/div/div[4]/div/div[1]/form/button")
    WebElement radiantTeeAddToCart;

    @FindBy(xpath = "//*[@id=\"maincontent\"]/div[2]/div[2]/div/div/div")
    WebElement itemAddedToCartText;

    @FindBy(xpath = "/html/body/div[2]/header/div[2]/div[1]/a")
    WebElement cartIcon;

    @FindBy(xpath = "//*[@id=\"top-cart-btn-checkout\"]")
    WebElement cartProceedButton;

    @FindBy(xpath = "//*[@id=\"mini-cart\"]/li/div/div/strong/a")
    WebElement cartItemTitle;
    private WebDriver driver;

    @FindBy(xpath = "/html/body/div[2]/header/div[2]/div[1]/div/div/div/div[2]/strong")
    WebElement emptyCartItemText;

    @FindBy(xpath = "//*[@id=\"mini-cart\"]/li/div/div/div[3]/div[2]/a")
    WebElement cartRemoveButton;

    @FindBy(xpath = "/html/body/div[4]/aside[2]/div[2]/footer/button[2]/span")
    WebElement removeItemsConfirmationButton;


    By numberItemsInCartIcon = new By.ByXPath("/html/body/div[2]/header/div[2]/div[1]/a/span[2]/span[1]");

    @FindBy(id = "search")
    public WebElement searchBar;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public void openPage() {
        driver.get(PAGE_URL);
        PageFactory.initElements(driver, this);
    }

    public void clickLoginButton() {
        loginButton.click();
    }

    public void selectSizeRadiantTeeXS(){ radiantTeeXsSize.click(); }

    public void selectRadiantTeeOrange(){ radiantTeeOrange.click();}

    public void clickRadiantTeeAddToCart(){ radiantTeeAddToCart.click();}

    public void clickCartIcon(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(EXPLICIT_WAIT));
        cartIcon.click();
    }

    public String checkIsItemAddedToCart(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(EXPLICIT_WAIT));
        wait.until(ExpectedConditions.textToBePresentInElement(itemAddedToCartText,"You added"));
        return itemAddedToCartText.getAttribute("innerText");
    }

    public String getItemTitleInCart(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(EXPLICIT_WAIT));
        wait.until(ExpectedConditions.textToBePresentInElement(cartItemTitle,"Radiant"));
        return cartItemTitle.getText();
    }

    public String getEmptyCartItemText(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(EXPLICIT_WAIT));
        wait.until(ExpectedConditions.textToBePresentInElement(emptyCartItemText,"You have"));
        return emptyCartItemText.getText();
    }

    public void waitTillItemAddedToCart(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(EXPLICIT_WAIT));
        wait.until(ExpectedConditions.elementToBeClickable(numberItemsInCartIcon));
    }

    public boolean checkIsCartProceedButton(){
        return cartProceedButton.isDisplayed();
    }

    public void removeCartItems(){
        cartRemoveButton.click();
    }

    public void clickRemoveItemsConfirmationButton(){
        removeItemsConfirmationButton.click();
    }

    public void addTextSearchBar(String text){
        searchBar.sendKeys(text);
    }

    public void enterSearchBar(){
        searchBar.sendKeys(Keys.ENTER);
    }


}
