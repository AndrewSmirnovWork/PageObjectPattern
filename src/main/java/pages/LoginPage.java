package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.concurrent.TimeUnit;

public class LoginPage {
/*    @FindBy(xpath = "//*[contains(@id, 'id_username')]")
    private WebElement loginField;

    @FindBy(xpath = "//*[contains(@id, 'id_password')]")
    private WebElement passwordField;

    @FindBy(xpath = "//*[contains(text(), 'Войти')]")
    private WebElement loginButton;*/

    By usernameLocator = By.id("id_username");
    By passwordLocator = By.id("id_password");
    By loginButtonLocator = By.xpath("/html/body/div/div[2]/div/form/div[3]/input");

    protected WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        if (!driver.getTitle().equals("Войти | Панель управления")) {
            throw new IllegalStateException("This is not Home Page of logged in user," +
                    " current page is: " + driver.getCurrentUrl());
        }
    }

    public LoginPage typeUsername(String username) {
        driver.findElement(usernameLocator).sendKeys(username);
        return this;
    }

    public LoginPage typePassword(String password) {
        driver.findElement(passwordLocator).sendKeys(password);
        return this;
    }

    public HomePage submitLogin() {
        driver.findElement(loginButtonLocator).submit();
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


