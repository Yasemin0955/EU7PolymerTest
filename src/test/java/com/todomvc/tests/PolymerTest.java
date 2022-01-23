package com.todomvc.tests;

import com.todomvc.pages.PolymerPage;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PolymerTest extends TestBase{
    PolymerPage polymerPage=new PolymerPage();
    @Test
    public void test1(){
        polymerPage.getTab("JavaScript").click();
        polymerPage.getLink("Polymer").click();
        String toDoItemOne = "My first to do item";
        String toDoItemTwo = "My second to do item";
        polymerPage.inputBox.sendKeys(toDoItemOne+ Keys.ENTER);
        polymerPage.inputBox.sendKeys(toDoItemTwo+Keys.ENTER);
        Assert.assertTrue(polymerPage.createdItemElement(toDoItemOne).isDisplayed(),"itemone is not created");
        Assert.assertTrue(polymerPage.createdItemElement(toDoItemTwo).isDisplayed(),"itemtwo is not created");

     WebElement btnForChanging =polymerPage.createdItemElement(toDoItemOne);
     actions.doubleClick(btnForChanging).perform();


        for (int i = 0; i < toDoItemTwo.length() ; i++) {
            polymerPage.editBox.sendKeys(Keys.BACK_SPACE);
        }
        String changedItem = "I have changed second item";
        polymerPage.editBox.sendKeys(changedItem);

        Assert.assertTrue(polymerPage.createdItemElement(changedItem).isDisplayed(),"My second item NOT changed");




    }
}
