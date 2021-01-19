package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {

    protected WebDriver driver;

    By addEntryButton = By.xpath("//*[@id=\"module_2\"]/div/ul[1]/li[1]/ul/li[1]/a");
    By changeEntryButton = By.xpath("//*[@id=\"module_2\"]/div/ul[1]/li[1]/ul/li[2]/a");

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public AddEntryPage addEntry() {
        driver.findElement(addEntryButton).click();
        return new AddEntryPage(driver);
    }

    public AllEntriesPage goToChangeEntryPage() {
        driver.findElement(changeEntryButton).click();
        return new AllEntriesPage(driver);
    }
}
