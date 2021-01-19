package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BlogPage {
    protected WebDriver driver;

    //*[@id="entries"]/h2[1]/a
    By lastAddedEntryTittle = By.xpath("/html/body/div[2]/div[1]/p");

    //*[@id="entries"]/div[1]/p
    By lastAddedEntrySlug = By.xpath("/html/body/div[2]/h2[1]/a");

    public BlogPage(WebDriver driver) {
        this.driver = driver;
    }
}
