package com.restfulBookerPlatform.tests.step_defs;

import com.restfulBookerPlatform.tests.pages.BasePage;
import com.restfulBookerPlatform.tests.utilities.*;
import io.cucumber.java.en.*;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

import static com.restfulBookerPlatform.tests.utilities.BrowserUtils.*;
import static com.restfulBookerPlatform.tests.utilities.Driver.*;

public class BookRoomStepDefs {

    BasePage basePage = new BasePage();

    WebDriver driver;

    @When("user is on main page")
    public void userIsOnMainPage() {

        assert get().getCurrentUrl().equals("https://automationintesting.online/");
    }

    @And("user scrolls to book this room button")
    public void userScrollsToBookThisRoomButton() {

        BrowserUtils.scrollToElement(basePage.bookRoomBtn);
    }

    @Then("user should able to see {string} button")
    public void userShouldAbleToSeeButton(String button) {

        BrowserUtils.waitForClickablility(basePage.bookRoomBtn, 5);

        if (button.equals("book this room")) {

            BrowserUtils.waitForClickablility(basePage.bookRoomBtn, 5);

        }else {

            BrowserUtils.waitForClickablility(basePage.bookBtn, 5);
        }
    }

    @Then("user can click {string} button")
    public void userCanClickBookThisRoomButton(String button) {

        switch (button) {
            case "book this room":

                basePage.bookRoomBtn.click();
                break;
            case "book":

                basePage.bookBtn.click();
                break;
            case "cancel":

                basePage.cancelBtn.click();
                break;

            case "next":

                get()
                .findElement(By.xpath("//*[@class='rbc-btn-group']/button[text()='Next']"))
                .click();
                break;
            default:

                get()
                .findElement(By.xpath("//*[@class='rbc-btn-group']/button[text()='Back']"))
                .click();
                break;
        }
    }

    @Then("user can see {string} button")
    public void userCanSeeBookThisRoomButton(String button) {

        if (button.equals("book this room")) {

            basePage.bookRoomBtn.isEnabled();
        }else if(button.equals("book")){

            basePage.bookBtn.isEnabled();
        }else if(button.equals("cancel")){

            basePage.cancelBtn.isEnabled();
        }else {

            BrowserUtils
            .waitForVisibility(By.xpath("//button[@class='btn btn-outline-primary']"),5);
        }
    }

    @And("user can see calendar")
    public void userCanSeeCalendar() {

        BrowserUtils.waitForVisibility(basePage.calendar,5);
    }

    @Then("user fills for {string}")
    public void userFillsFor(String inbox) {

        switch (inbox) {

            case "firstname":
                basePage.firstnameBox.sendKeys(ConfigurationReader.get("userName"));
                break;

            case "lastname":
                basePage.lastnameBox.sendKeys(ConfigurationReader.get("userLastName"));
                break;

            case "email":
                basePage.emailBox.sendKeys(ConfigurationReader.get("userEmail"));
                break;

            case "phone":
                basePage.phoneBox.sendKeys(ConfigurationReader.get("userPhone"));
                break;
        }
    }

    @And("user gets {string} message")
    public void userGetsRedErrorMessage(String message) {

        waitFor(2);

        if(message.equals("red error")){

            basePage.alert.isEnabled();

        }else{

            get().findElement(By.xpath("//h3[contains(text(),'Successful')]")).isEnabled();
        }

    }

    @And("user can select {string} date")
    public void userCanSelectOneDate(String date) {

        if (date.equals("one")) {
            get()
                    .findElement(By.xpath("//*[@class='rbc-date-cell']/button[text()='12']"))
                    .click();

        }else{

            Actions actions = new Actions(get());

//      Even if source point 16 is received,the reservation starts from the next 2nd day.like 18-19
            WebElement source =get()
                    .findElement(By.xpath("//*[@class='rbc-date-cell']/button[text()='16']"));

            WebElement target = get()
                    .findElement(By.xpath("//*[@class='rbc-date-cell']/button[text()='19']"));

            System.out.println("target.getLocation() = " + target.getLocation());

            System.out.println("source.getLocation() = " + source.getLocation());

            actions.clickAndHold(source).pause(2000).moveByOffset(180,0).release(target).build().perform();
        }

        waitFor(5);
    }
}
