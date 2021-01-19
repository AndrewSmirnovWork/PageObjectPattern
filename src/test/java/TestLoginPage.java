import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.AddEntryPage;
import pages.BlogPage;
import pages.HomePage;
import pages.LoginPage;

import java.util.concurrent.TimeUnit;

public class TestLoginPage {
    WebDriver driver;
    LoginPage loginPage;
    HomePage homePage;
    AddEntryPage addEntryPage;
    BlogPage blogPage;


    @BeforeTest
    public void setup() {
        //String browser = java.lang.System.getProperties().getProperty("webbrowser");
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Luck\\IdeaProjects\\Projects\\PageObjectPattern\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
    }

    @AfterTest
    public void quit() {
        driver.manage().deleteAllCookies();
        driver.quit();
    }

    @Test
    public void testLogin() {
        //Get site and do Login
        driver.get("https://igorakintev.ru/admin/");
        loginPage = new LoginPage(driver);
        loginPage.loginAs("selenium", "super_password");
        //Verify page title
        Assert.assertEquals(driver.getTitle(), "Администрирование сайта | Панель управления");
        homePage = new HomePage(driver);
        //go to add entry page
        homePage.addEntry();
        //Verify page title
        Assert.assertEquals(driver.getTitle(), "Добавить entry | Панель управления");
        addEntryPage = new AddEntryPage(driver);
        // Save new Entry
        addEntryPage.saveEntry("Title" + (int) (Math.random() * 10000),
                "slug" + (int) (Math.random() * 10000),
                "textmarkdown" + (int) (Math.random() * 10000),
                "text" + (int) (Math.random() * 10000));

        //go to site and check entry
        driver.get("http://igorakintev.ru/blog/");
        blogPage = new BlogPage(driver);

        Assert.assertEquals(addEntryPage.getTittle(), driver.findElement(By.xpath("/html/body/div[2]/h2[1]/a")).getText());
        Assert.assertEquals(addEntryPage.getSlug(), driver.findElement(By.xpath("/html/body/div[2]/div[1]/p")).getText());
        //deleting entry
        driver.get("https://igorakintev.ru/admin/");
        homePage.changeEntry();
    }


}
