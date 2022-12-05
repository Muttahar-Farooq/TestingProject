package com.example.testingproject.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SingleItemPage {

    public static String HEERO_HOODIE_URL = "https://magento.softwaretestingboard.com/hero-hoodie.html";

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

    public void selectColor(String color){
        driver.findElement(new By.ByCssSelector("div[option-label="+color+"]")).click();
    }

    public String getLinkOfMainImage(){
        return driver.findElement(new By.ByCssSelector("div.fotorama__stage__frame")).getAttribute("href");
    }
}
