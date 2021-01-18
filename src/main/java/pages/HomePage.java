package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {

    WebDriver driver;
    By homePageName = By.xpath("/html/head/title/");

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }
    public String getHomePageDashboardName(){
        return driver.findElement(homePageName).getText();
    }
}
