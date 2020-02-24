package com.actitime.test;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.actitime.generics.BaseClass;
import com.atitime.pom.EnterTimeTrackPage;
import com.atitime.pom.TaskListPage;
@Listeners(com.actitime.generics.ListenersImplementation.class)
public class CustomerModule extends BaseClass{
@Test
public void testCreateCustomer() throws EncryptedDocumentException, InvalidFormatException, IOException, InterruptedException {
	String ExpectedText = f.getExcelData("CreateCustomer", 1, 3);
	EnterTimeTrackPage e=new EnterTimeTrackPage(driver);
//
	e.clickTasks();
	TaskListPage t=new TaskListPage(driver);
	t.getAddNewBtn().click();
	t.getNewCustomerOption().click();
	t.getCustomerNameTBX().sendKeys(ExpectedText);
    t.getDescriptionTBX().sendKeys(f.getExcelData("CreateCustomer", 1, 4));
	t.getCopyProjectDropDown().click();
	t.getOurCompanyMenuOption().click();
	t.getCreateCustomerBtn().click();
	WebDriverWait wait=new WebDriverWait(driver,10);
wait.until(ExpectedConditions.textToBePresentInElement(t.getCustomerCreatedTitle(), ExpectedText));
String ActualText = t.getCustomerCreatedTitle().getText();
Assert.assertEquals(ActualText, ExpectedText);
Reporter.log("Customer successfully created",true);

}
}
