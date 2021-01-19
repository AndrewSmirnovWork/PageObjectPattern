package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AllEntriesPage {
    WebDriver driver;

    //"//*[@id=\"result_list\"]/tbody/tr[1]/th/a"
    By lastEntry = By.xpath("/html/body/div/div[3]/div/div/form/div[4]/table/tbody/tr[1]/th/a");

    public AllEntriesPage(WebDriver driver) {
        this.driver = driver;
        if (!driver.getTitle().equals("Выберите entry для изменения | Панель управления")) {
            throw new IllegalStateException("This is not All entries page of logged in user," +
                    " current page is: " + driver.getCurrentUrl());
        }
    }

    public ChangeEntryPage changeEntry() {
        driver.findElement(lastEntry).click();
        return new ChangeEntryPage(driver);
    }

}
