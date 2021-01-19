package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ChangeEntryPage {
    WebDriver driver;

    By deleteButton = By.xpath("/html/body/div[1]/div[3]/div/form/div/div/p/a");
    By confirmButton = By.xpath("//*[@id=\"content\"]/form/div/input[2]");

    public ChangeEntryPage(WebDriver driver) {
        this.driver = driver;
        if (!driver.getTitle().equals("Изменить entry | Панель управления")) {
            throw new IllegalStateException("This is not Change entry page of logged in user," +
                    " current page is: " + driver.getCurrentUrl());
        }
    }
    public void deleteEntry() {
        driver.findElement(deleteButton).click();
        driver.findElement(confirmButton).click();
    }
}
