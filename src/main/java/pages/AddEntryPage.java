package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AddEntryPage {

    protected WebDriver driver;

    By tittleLocator = By.id("id_title");
    By slugLocator = By.id("id_slug");
    By textMarkdownLocator = By.id("id_text_markdown");
    By textLocator = By.xpath("/html/body/div[1]/div[3]/div/form/div/fieldset/div[6]/div/textarea");
    By saveButtonLocator = By.name("_save");
    private String tittle;
    private String slug;

    public AddEntryPage(WebDriver driver) {
        this.driver = driver;
        if (!driver.getTitle().equals("Добавить entry | Панель управления")) {
            throw new IllegalStateException("This is not Add entry page of logged in user," +
                    " current page is: " + driver.getCurrentUrl());
        }
    }

    public String getTittle() {
        return tittle;
    }

    public String getSlug() {
        return slug;
    }

    public AddEntryPage typeTittle(String tittle) {
        driver.findElement(tittleLocator).sendKeys(tittle);
        this.tittle = tittle;
        return this;
    }

    public AddEntryPage typeSlug(String slug) {
        driver.findElement(slugLocator).sendKeys(slug);
        this.slug = slug;
        return this;
    }

    public AddEntryPage typeTextMarkdown(String textMarkdown) {
        driver.findElement(textMarkdownLocator).sendKeys(textMarkdown);
        return this;
    }

    public AddEntryPage typeText(String text) {
        driver.findElement(textLocator).sendKeys(text);
        return this;
    }

    public HomePage submitSave() {
        driver.findElement(saveButtonLocator).submit();
        return new HomePage(driver);
    }


    public HomePage saveEntry(String tittle, String slug, String textMarkdown, String text) {
        typeTittle(tittle);
        typeSlug(slug);
        typeTextMarkdown(textMarkdown);
        typeText(text);
        return submitSave();
    }


}