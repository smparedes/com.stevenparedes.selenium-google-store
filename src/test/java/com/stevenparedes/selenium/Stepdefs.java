package com.stevenparedes.selenium;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class Stepdefs {
	private WebDriver driver;
	@Before
	public void before() throws Exception {

	System.setProperty("webdriver.chrome.driver", "./src/test/resources/webdrivers/chromedriver.exe");
	ChromeOptions options = new ChromeOptions();
	options.addArguments("--start-maximized");
	this.driver = new ChromeDriver(options); //local
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}

	@After
	public void after() {
		this.driver.quit();
	}

	@Given("^I navigate to the Google store$")
	public void i_navigate_to_the_Google_Store() throws Throwable {
		driver.get("https://store.google.com/product/stadia");
	}

	@When("^I see Stadia Premiere Edition as the page Title$")
	public void i_should_see_stadia_premiere_edition_as_the_page_title() throws Throwable {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		String actualTitle = driver.findElement(By.tagName("h1")).getText();
		System.out.print(actualTitle);
		Assert.assertTrue("Stadia Premiere Edition".contains(actualTitle));
	}

	@When("^I select the Buy option$")
	public void i_select_the_buy_option() throws Throwable {
		WebDriverWait wait = new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("bigger-btn")));
		driver.findElement(By.className("bigger-btn")).click();
	}

	@When("^I click the Buy button$")
	public void i_click_the_buy_button() throws Throwable {
		WebDriverWait wait = new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("mqn-quantity-selector__card__button")));
		driver.findElement(By.className("mqn-quantity-selector__card__button")).click();
	}

	@When("^I click the Go to cart button$")
	public void i_click_go_to_cart() throws Throwable {
		WebDriverWait wait = new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("mdc-button__touch")));
		driver.findElement(By.className("mdc-button__touch")).click();
	}

	@Then("^I see the cart subtotal$")
	public void i_see_the_cart_subtotal() throws Throwable {
		String price = driver.findElement(By.cssSelector("span[jsname='hMdCqe']")).getText();
		System.out.print(price);
		Assert.assertTrue("$129.00".contains(price));
	}
}
