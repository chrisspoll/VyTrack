package com.cybertek.tests.HomeWorks.VyTrackAutomatedTestCase;

import com.cybertek.tests.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CreatingVehicleCosts extends TestBase {


    @Test
    public void test() throws InterruptedException {

        //Input username
        WebElement usernameInput = driver.findElement(By.id("prependedInput"));
        usernameInput.sendKeys("storemanager63");

        //Input password
        WebElement passwordInput = driver.findElement(By.id("prependedInput2"));
        passwordInput.sendKeys("UserUser123");

        //click Login
        driver.findElement(By.cssSelector(".btn")).click();

        //Hover over Fleet Module
        WebElement FleetModule = driver.findElement(By.xpath("//*[@id='main-menu']/ul/li[2]/a/span"));
        WebElement SentElement = driver.findElement(By.xpath("//a[@data-name='sent']"));
        wait.until(ExpectedConditions.visibilityOf(SentElement));
        actions.moveToElement(FleetModule).perform();
        
        //Click Vehicle Costs
        WebElement VehicleCosts = driver.findElement(By.xpath("//span[text()='Vehicle Costs']"));
        wait.until(ExpectedConditions.visibilityOf(VehicleCosts));
        VehicleCosts.click();


        //click Create Vehicle Costs
        WebElement CreateVehicleButton = driver.findElement(By.xpath("//a[@title='Create Vehicle Costs']"));
        wait.until(ExpectedConditions.titleIs("All - Vehicle Costs - Entities - System - Car - Entities - System"));
        CreateVehicleButton.click();

        //click Choose a value...
        driver.findElement(By.xpath("//span[text()='Choose a value...']")).click();

        //click Tax Roll
        driver.findElement(By.xpath("//option[text()='Tax Roll']")).click();

        //input for Total Price
        driver.findElement(By.xpath("//input[starts-with(@id,'custom_entity_type_TotalPrice')]")).sendKeys("999");

        //click date
        driver.findElement(By.xpath("//input[starts-with(@id,'date_selector_custom_entity_type_Date')]")).click();

        //Select June
        WebElement monthDropDown = driver.findElement(By.cssSelector(".ui-datepicker-month"));
        Select month = new Select(monthDropDown);
        month.selectByValue("5");

        //Select day 5
        driver.findElement(By.xpath("//table/tbody/tr[1]/td[6]/a")).click();

        //input Cost Description
        driver.findElement(By.tagName("textarea")).sendKeys("Tax");

        //click add button for Chassis Number
        driver.findElement(By.xpath("(//i[@class='fa-plus'])[1]")).click();

        //click second row Chassis Number check button
        driver.findElement(By.xpath("//tbody/tr[2]/td[1]/input")).click();

        //click Select
        driver.findElement(By.xpath("//button[text()='Select']")).click();

        //click add button for License Plate
        driver.findElement(By.xpath("(//i[@class='fa-plus'])[2]")).click();

        //click second row License Plate check box
        driver.findElement(By.xpath("//tbody/tr[2]/td[1]/input")).click();

        //click Select
        driver.findElement(By.xpath("//button[text()='Select']")).click();

        //Click Save And Close
        driver.findElement(By.xpath("(//button[@type='submit'])[1]")).click();

        //Verify "Entity saved" message is displayed
        WebElement EntitySavedMessage = driver.findElement(By.xpath("//div[text()='Entity saved']"));
        Assert.assertTrue(EntitySavedMessage.isDisplayed(),"Verify 'Entity saved' message is displayed");


    }


}
