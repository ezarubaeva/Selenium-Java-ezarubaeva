package ru.st.selenium;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.testng.annotations.Test;

import ru.st.selenium.pages.TestBase;

public class GoogleTest extends TestBase {
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @Test
  public void testUntitled() throws Exception {
    driver.get("http://www.google.com");
    driver.findElement(By.id("gb_70")).click();
    driver.findElement(By.id("Email")).clear();
    driver.findElement(By.id("Email")).sendKeys("address");
    driver.findElement(By.id("next")).click();
    driver.findElement(By.id("Passwd")).clear();
    driver.findElement(By.id("Passwd")).sendKeys("address");
    driver.findElement(By.id("signIn")).click();
}

  private boolean isElementPresent(By by) {
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