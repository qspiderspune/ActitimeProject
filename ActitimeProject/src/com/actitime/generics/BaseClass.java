package com.actitime.generics;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;

import com.atitime.pom.EnterTimeTrackPage;
import com.atitime.pom.LoginPage;
@Listeners(com.actitime.generics.ListenersImplementation.class)
public class BaseClass {
	public static WebDriver driver;
	public FileLib f=new FileLib();
	static 
	{
System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
System.setProperty("webdriver.gecko.driver", "./driver/geckodriver.exe");
	}
	@BeforeTest
	public void openBrowser() {	
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	@AfterTest
	public void closeBrowser() {
	driver.close();
	}
	@BeforeMethod
	public void login() throws IOException {
	String URL = f.getPropertyData("url");
	String un=f.getPropertyData("username");
	String pw=f.getPropertyData("password");
	driver.get(URL);	
LoginPage l=new LoginPage(driver);
	l.setUser(un, pw);
	}
	@AfterMethod
	public void logout() throws InterruptedException {
	Thread.sleep(7000);
	EnterTimeTrackPage e=new EnterTimeTrackPage(driver);
	e.clickLogout();
	}
}
