package com.abc.magentoTest;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Magento 
{
	public static void main(String[] args) throws IOException, InterruptedException
	{
		FileInputStream fis=new FileInputStream("C:\\Users\\HP\\eclipse-workspace\\java pgms\\selenium\\DataDrivenFramework\\src\\com\\abc\\utilities\\data.properties");
		Properties p=new Properties();
		p.load(fis);
		String urldata=p.getProperty("url");
	    String emaildata=p.getProperty("email");
	    String passdata=p.getProperty("password");
	    WebDriver driver=new ChromeDriver();
	    driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get(urldata);
		driver.findElement(By.id("email")).sendKeys(emaildata);;
		driver.findElement(By.id("pass")).sendKeys(passdata);;
		driver.findElement(By.id("send2")).click();
		driver.findElement(By.linkText("My Account")).click();
		
		driver.findElement(By.linkText("Logout")).click();
		Thread.sleep(3000);
		driver.quit();
		
	}
}
