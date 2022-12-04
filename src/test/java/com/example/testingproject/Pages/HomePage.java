package com.example.testingproject.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage {

    public static final String PAGE_URL = "https://magento.softwaretestingboard.com/";

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

    private WebDriver driver;


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

    public String getNoItemCartMessage(){
        return driver.findElement(new By.ByXPath("//*[@id=\"maincontent\"]/div[3]/div/div[2]/p[1]")).getText();
    }

    public void clickCartIcon(){
        cartIcon.click();
    }

    public String checkIsItemAddedToCart(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.textToBePresentInElement(itemAddedToCartText,"You added"));
        return itemAddedToCartText.getAttribute("innerText");
    }

}
