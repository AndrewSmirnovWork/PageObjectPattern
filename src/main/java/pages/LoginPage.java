package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.concurrent.TimeUnit;

public class LoginPage {
    @FindBy(xpath = "//*[contains(@id, 'id_username')]")
    private WebElement loginField;

    @FindBy(xpath = "//*[contains(@id, 'id_password')]")
    private WebElement passwordField;

    @FindBy(xpath = "//*[contains(text(), 'Войти')]")
    private WebElement loginButton;

 /*   By usernameLocator = By.id("id_username");
    By passwordLocator = By.id("id_password");
    By loginButtonLocator = By.id("submit"); */

    private final WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        /*if (!"Войти | Панель управления".equals(driver.getTitle())) {
            throw new IllegalStateException("This is not the login page");
        }*/
    }

    public LoginPage typeUsername(String username) {
        //driver.findElement(usernameLocator).sendKeys(username);
        loginField.sendKeys(username);
        return this;
    }

    public LoginPage typePassword(String password) {
        //driver.findElement(passwordLocator).sendKeys(password);
        passwordField.sendKeys(password);
        return this;
    }

    public HomePage submitLogin() {
        //driver.findElement(loginButtonLocator).submit();
        loginButton.click();
        return new HomePage(driver);
    }

    /*public LoginPage submitLoginExpectingFailure() {
        driver.findElement(loginButtonLocator).submit();
        return new LoginPage(driver);
    }*/

    public HomePage loginAs(String username, String password) {
        typeUsername(username);
        typePassword(password);
        return submitLogin();
    }
}


