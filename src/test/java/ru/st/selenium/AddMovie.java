package ru.st.selenium;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.testng.*;
import org.testng.annotations.*;

import ru.st.selenium.pages.TestBase;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class AddMovie extends TestBase {
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @Test
public void testAddMovie() throws Exception {
    driver.get(baseUrl + "/php4dvd/");
    driver.findElement(By.id("username")).clear();
    driver.findElement(By.id("username")).sendKeys("admin");
    driver.findElement(By.name("password")).clear();
    driver.findElement(By.name("password")).sendKeys("admin");
    driver.findElement(By.name("submit")).click();
    driver.findElement(By.cssSelector("img[alt=\"Add movie\"]")).click();
    driver.findElement(By.name("name")).clear();
    driver.findElement(By.name("name")).sendKeys("Le jouet");
    driver.findElement(By.name("year")).clear();
    driver.findElement(By.name("year")).sendKeys("1976");
    driver.findElement(By.name("duration")).clear();
    driver.findElement(By.name("duration")).sendKeys("120");
    driver.findElement(By.name("rating")).clear();
    driver.findElement(By.name("rating")).sendKeys("5");
    driver.findElement(By.name("trailer")).clear();
    driver.findElement(By.name("trailer")).sendKeys("http://www.kinopoisk.ru/film/57004/video/124770/");
    driver.findElement(By.name("notes")).clear();
    driver.findElement(By.name("notes")).sendKeys("Pierre Richar");
    driver.findElement(By.name("plotoutline")).clear();
    driver.findElement(By.name("plotoutline")).sendKeys("Comedy");
    driver.findElement(By.id("text_languages_0")).clear();
    driver.findElement(By.id("text_languages_0")).sendKeys("French");
    driver.findElement(By.name("subtitles")).clear();
    driver.findElement(By.name("subtitles")).sendKeys("NO");
    driver.findElement(By.name("country")).clear();
    driver.findElement(By.name("country")).sendKeys("France");
    driver.findElement(By.id("submit")).click();
    driver.findElement(By.linkText("Home")).click();
    driver.get(baseUrl + "/php4dvd/#!/sort/name%20asc/");
    driver.findElement(By.cssSelector("div.title")).click();
    driver.findElement(By.cssSelector("img[alt=\"Remove\"]")).click();
    assertTrue(closeAlertAndGetItsText().matches("^Are you sure you want to remove this[\\s\\S]$"));
    driver.quit();
}

  private boolean isElementPresent1(By by) {
    try {
      driver.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }
  private String closeAlertAndGetItsText() {
	    try {
	      Alert alert = driver.switchTo().alert();
	      String alertText = alert.getText();
	      if (acceptNextAlert) {
	        alert.accept();
	      } else {
	        alert.dismiss();
	      }
	      return alertText;
	    } finally {
	      acceptNextAlert = true;
	    }
	  }
}
