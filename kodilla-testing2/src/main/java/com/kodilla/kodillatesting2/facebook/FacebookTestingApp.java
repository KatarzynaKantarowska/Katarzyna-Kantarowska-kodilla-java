package com.kodilla.kodillatesting2.facebook;

import com.kodilla.kodillatesting2.config.WebDriverConfig;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class FacebookTestingApp  {
    public static final String XPATH_COOKIE = "//*[@id=\"facebook\"]/body/div[3]/div[2]/div/div/div/div/div[3]/div[2]/div/div[2]/div[1]";
    private static final String XPATH_SELECT_DAY = "/html/body/div[1]/div[1]/div[1]/div[2]/div/div[2]/div/div/div[1]/form/div[1]/div[2]/div[2]/span/span/select[1]";
    private static final String XPATH_SELECT_MONTH = "/html/body/div[1]/div[1]/div[1]/div[2]/div/div[2]/div/div/div[1]/form/div[1]/div[2]/div[2]/span/span/select[2]";
    private static final String XPATH_SELECT_YEAR = "/html/body/div[1]/div[1]/div[1]/div[2]/div/div[2]/div/div/div[1]/form/div[1]/div[2]/div[2]/span/span/select[3]";
    private static final String LINK_TEXT_REGISTER = "Utwórz nowe konto";

    public static void main(String[] args) {
        WebDriver driver = WebDriverConfig.getDriver(WebDriverConfig.CHROME);
        driver.get("https://www.facebook.com");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        while (!driver.findElement(By.xpath(XPATH_COOKIE)).isDisplayed());
        driver.findElement(By.xpath(XPATH_COOKIE)).click();

        wait.until(ExpectedConditions.elementToBeClickable(By.linkText(LINK_TEXT_REGISTER)));
        driver.findElement(By.linkText(LINK_TEXT_REGISTER)).click();

        while (!driver.findElement(By.xpath(XPATH_COOKIE)).isDisplayed());
        driver.findElement(By.xpath(XPATH_COOKIE)).click();

        WebElement selectDay = driver.findElement(By.xpath(XPATH_SELECT_DAY));
        Select select1 = new Select(selectDay);
        select1.selectByIndex(5);

        WebElement selectMonth = driver.findElement(By.xpath(XPATH_SELECT_MONTH));
        Select select2 = new Select(selectMonth);
        select2.selectByIndex(3);

        WebElement selectYear = driver.findElement(By.xpath(XPATH_SELECT_YEAR));
        Select select3 = new Select(selectYear);
        select3.selectByIndex(31);

    }
}
