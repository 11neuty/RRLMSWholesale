package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;
import java.util.concurrent.Callable;
import java.util.logging.Logger;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.ElementClickInterceptedException;

public class LMSPage {
    private WebDriver webDriver;
    private static final Logger logger = Logger.getLogger(LMSPage.class.getName());

    public LMSPage(WebDriver driver) {
        this.webDriver = driver;
        PageFactory.initElements(driver, this);
    }

    public WebElement waitForElement(By locator) {
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(10));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    private <T> T executeWithHandling(Callable<T> callable) {
        try {
            return callable.call();
        } catch (NoSuchElementException e) {
            logger.warning("Element not found: " + e.getMessage());
            return null;
        } catch (StaleElementReferenceException e) {
            logger.warning("Stale element reference: " + e.getMessage());
            return null;
        } catch (ElementClickInterceptedException e) {
            logger.warning("Element click intercepted: " + e.getMessage());
            return null;
        } catch (Exception e) {
            logger.severe("An unexpected error occurred: " + e.getMessage());
            return null;
        }
    }

    public boolean verifyLoginPage() {
        return executeWithHandling(() -> {
            WebElement loginLms = waitForElement(By.xpath("//div/input[@id='txtUsername']")); // ganti locator
            return loginLms.isDisplayed();
        }) != null;
    }

    public void enterUsername(String username) {
        executeWithHandling(() -> {
            WebElement userField = waitForElement(By.xpath("//div/input[@id='txtUsername']")); // ganti locator sesuai elemen
            userField.clear();
            userField.sendKeys(username);
            return null;
        });
    }


    public void enterPassword(String password) {
        executeWithHandling(() -> {
            WebElement passField = waitForElement(By.xpath("//div/input[@id='txtPassword']"));
            passField.clear();
            passField.sendKeys(password);
            return null;
        });
    }

    public void clickLoginButton() {
        executeWithHandling(() -> {
            WebElement btn = waitForElement(By.xpath("//div/button[@id='btnLogin']"));
            btn.click();
            return null;
        });
    }
    //open customer group
    //search nomor app
    //click open deal team setup

    public void clickOpenDealTeamSetup(){
        executeWithHandling(() -> {
            WebElement openButton = waitForElement(By.xpath("//div/div/a[@title='Open']"));
            openButton.click();
            return null;
        });
    }
}
