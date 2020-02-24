package com.atitime.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TaskListPage {
@FindBy(xpath="//div[.='Add New']")
private WebElement AddNewBtn;
@FindBy(xpath="//div[.='+ New Customer']")
private WebElement NewCustomerOption;
@FindBy(xpath="//input[contains(@class,'inputNameField')]")
private WebElement CustomerNameTBX;
@FindBy(xpath="//textarea[@placeholder='Enter Customer Description']")
private WebElement DescriptionTBX;
@FindBy(xpath="(//div[@class='dropdownButton'])[15]")
private WebElement CopyProjectDropDown;
@FindBy(xpath="//div[@class='searchItemList']/div[.='Our company']")
private WebElement OurCompanyMenuOption;
@FindBy(xpath="(//div[.='  Create Customer'])[2]")
private WebElement CreateCustomerBtn;
@FindBy(xpath="(//div[@class='title' and @title])[1]")
private WebElement CustomerCreatedTitle;
public WebElement getCustomerCreatedTitle() {
	return CustomerCreatedTitle;
}
public TaskListPage(WebDriver driver) {
PageFactory.initElements(driver, this);
}

public WebElement getAddNewBtn() {
	return AddNewBtn;
}
public WebElement getNewCustomerOption() {
	return NewCustomerOption;
}
public WebElement getCustomerNameTBX() {
	return CustomerNameTBX;
}
public WebElement getDescriptionTBX() {
	return DescriptionTBX;
}
public WebElement getCopyProjectDropDown() {
	return CopyProjectDropDown;
}
public WebElement getOurCompanyMenuOption() {
	return OurCompanyMenuOption;
}
public WebElement getCreateCustomerBtn() {
	return CreateCustomerBtn;
}

}
