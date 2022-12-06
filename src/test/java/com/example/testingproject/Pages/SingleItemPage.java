package com.example.testingproject.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.xml.xpath.XPath;
import java.time.Duration;

import static com.example.testingproject.Pages.HomePage.EXPLICIT_WAIT;

public class SingleItemPage {

    public static String HEERO_HOODIE_URL = "https://magento.softwaretestingboard.com/hero-hoodie.html";

    @FindBy(id = "qty")
    private WebElement quantityInput;

    @FindBy(id = "product-addtocart-button")
    private WebElement addToCartButton;

    @FindBy(xpath = "/html/body/div[2]/header/div[2]/div[1]/a/span[2]")
    private WebElement numIconWrapperSpan;

    @FindBy(css = "a.action.showcart")
    private WebElement cartButton;

    WebDriver driver;
    public SingleItemPage(WebDriver driver){
        this.driver = driver;
    }

    public void openHeroHoodiePage(){
        driver.get(HEERO_HOODIE_URL);
    }

    public void initElements(){
        PageFactory.initElements(driver,this);
    }

    public void selectElementWithLabel(String givenString){
        driver.findElement(new By.ByCssSelector("div[option-label="+givenString+"]")).click();
    }

    public String getLinkOfMainImage(){
        return driver.findElement(new By.ByCssSelector("div.fotorama__stage__frame")).getAttribute("href");
    }

    public void enterQuantity(String quantity) throws InterruptedException {
        quantityInput.sendKeys(Keys.DELETE);
        Thread.sleep(500);
        quantityInput.sendKeys(quantity);
    }

    public void clickAddToCartButton(){
        addToCartButton.click();
    }

    public String getNumberOfItemsInCart() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(EXPLICIT_WAIT));
        wait.until(ExpectedConditions.attributeToBe(numIconWrapperSpan,"class","counter qty"));
        return driver.findElement(By.className("counter-number")).getText();
    }

    public String quantityErrorMessage(){
        return driver.findElement(By.id("qty-error")).getText();
    }

    public void clickCartButton(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(EXPLICIT_WAIT));
        wait.until(ExpectedConditions.attributeToBe(numIconWrapperSpan,"class","counter qty"));
        cartButton.click();
    }

    public void clickProceedToCheckout(){
        driver.findElement(By.id("top-cart-btn-checkout")).click();
    }
}
