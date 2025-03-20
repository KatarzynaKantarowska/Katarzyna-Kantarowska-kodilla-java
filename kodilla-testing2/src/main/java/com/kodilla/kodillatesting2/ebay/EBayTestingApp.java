package com.kodilla.kodillatesting2.ebay;

import com.kodilla.kodillatesting2.config.WebDriverConfig;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class EBayTestingApp extends WebDriverConfig {
    public static void main(final String[] args) {
        WebDriver driver = WebDriverConfig.getDriver(WebDriverConfig.CHROME);
        driver.get("https://www.ebay.com");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement cookieButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("gdpr-banner-decline")));
        js.executeScript("arguments[0].click();", cookieButton);

        WebElement searchField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("gh-ac")));
        searchField.sendKeys("Laptop");
        searchField.submit();
    }
}
