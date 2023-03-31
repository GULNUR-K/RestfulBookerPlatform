package com.restfulBookerPlatform.tests.pages;

import com.restfulBookerPlatform.tests.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BasePage {

    public BasePage() {
    PageFactory.initElements(Driver.get(), this);
}

    @FindBy(xpath = "//button[text()='Book this room']")
    public WebElement bookRoomBtn;

    @FindBy(className = "rbc-calendar")
    public WebElement calendar;

    @FindBy(xpath = "//button[text()='Book']")
    public WebElement bookBtn;

    @FindBy(xpath = "//*[@class='alert alert-danger']")
    public WebElement alert;

    @FindBy(xpath = "//button[text()='Cancel']")
    public WebElement cancelBtn;

    @FindBy(name = "firstname")
    public WebElement firstnameBox;

    @FindBy(name = "lastname")
    public WebElement lastnameBox;

    @FindBy(name = "email")
    public WebElement emailBox;

    @FindBy(name = "phone")
    public WebElement phoneBox;
}
