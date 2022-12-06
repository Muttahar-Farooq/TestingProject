package com.example.testingproject.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CheckoutPage {
    WebDriver driver;

    @FindBy(id = "customer-email")
    private WebElement emailText;

    @FindBy(name = "firstname")
    private WebElement firstnameText;

    @FindBy(name = "lastname")
    private WebElement lastnameText;

    @FindBy(name = "street[0]")
    private WebElement address;

    @FindBy(name = "city")
    private WebElement cityText;

    @FindBy(name = "region_id")
    private WebElement region;

    @FindBy(name = "postcode")
    private WebElement postcodeText;

    @FindBy(xpath = "/html/body/div[2]/main/div[2]/div/div[2]/div[4]/ol/li[1]/div[2]/form[2]/div/div[8]/div/select")
    private WebElement country;

    @FindBy(css = "[data-role = 'opc-continue']")
    private WebElement continueButton;

    @FindBy(name = "telephone")
    public WebElement telephoneText;

    @FindBy(css = "button[class$=\"checkout\"]")
    public WebElement placeOrderButton;

    @FindBy(css = "[data-ui-id = 'page-title-wrapper']")
    public WebElement pageTitleWrapper;

    @FindBy(css = "[data-role = 'title']")
    public WebElement title;

    WebDriverWait wait;

    public CheckoutPage(WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    }
    public void initElements(){
        PageFactory.initElements(driver,this);
    }


    public void setEmailText(String s){
        wait.until(ExpectedConditions.invisibilityOf(driver.findElement(new By.ByCssSelector("[alt=\"Loading...\"]"))));
        emailText.sendKeys(s);
    }

    public void setFirstnameText(String s){
        firstnameText.sendKeys(s);
    }

    public void setLastnameText(String s){
        lastnameText.sendKeys(s);
    }

    public void setCityText(String s){
        cityText.sendKeys(s);
    }

    public void setPostcodeText(String s){
        postcodeText.sendKeys(s);
    }

    public void setCountry(String s){
        Select select = new Select(country);
        select.selectByIndex(1);
    }

    public void setAddress(String s){
        address.sendKeys(s);
    }

    public void setTelephoneText(String s){
        telephoneText.sendKeys(s);
    }
    
    public void clickNextButton(){
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(new By.ByCssSelector("[alt=\"Loading...\"]"))));
        wait.until(ExpectedConditions.invisibilityOf(driver.findElement(new By.ByCssSelector("[alt=\"Loading...\"]"))));
        continueButton.click();
    }

    public void clickPlaceOrderButton(){
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(new By.ByCssSelector("[alt=\"Loading...\"]"))));
        wait.until(ExpectedConditions.invisibilityOf(driver.findElement(new By.ByCssSelector("[alt=\"Loading...\"]"))));
        placeOrderButton.click();
    }

    public String getMainText(){
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(new By.ByCssSelector("[alt=\"Loading...\"]"))));
        wait.until(ExpectedConditions.invisibilityOf(driver.findElement(new By.ByCssSelector("[alt=\"Loading...\"]"))));
        return pageTitleWrapper.getText();
    }
    

}
