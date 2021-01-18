import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;

import java.util.concurrent.TimeUnit;

public class TestLoginPage {
    WebDriver driver;
    LoginPage loginPage;
    HomePage homePage;

    @BeforeTest
    public void setup(){
        //String browser = java.lang.System.getProperties().getProperty("webbrowser");
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Luck\\Desktop\\chromedriver.exe");
        driver = new ChromeDriver();
        //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://igorakintev.ru/");
    }

    @Test
    public void test_Home_Page_Appear_Correct(){
        //Create Login Page object
        loginPage = new LoginPage(driver);
        //login to application
        loginPage.loginAs("selenium", "super_password");
        // go the next page

        //Verify home page
        System.out.println(homePage.getHomePageDashboardName());
        //Assert.assertTrue(homePage.getHomePageDashboardName().toLowerCase().contains("admin"));
    }
}