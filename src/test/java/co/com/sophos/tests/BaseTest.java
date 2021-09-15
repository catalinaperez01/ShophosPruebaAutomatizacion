package co.com.sophos.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import co.com.sophos.pages.HomePage;
import co.com.sophos.pages.WorkWithUsPage;

/**
 *
 * @author catalina perez
 */
public class BaseTest {

    public WebDriver driver;
    public HomePage homePage;
    public WorkWithUsPage workWithUsPage;


    public WebDriver getDriver() {
        return driver;
    }

    @BeforeClass
    public void classLevelSetup() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("lang=en-US");
        driver = new ChromeDriver(options);
        this.driver.manage().window().maximize();
    }

    @BeforeMethod
    public void methodLevelSetup() {
        homePage = new HomePage(driver);   
        workWithUsPage = new WorkWithUsPage(driver);
 
    }

    @AfterClass
    public void teardown() {
        driver.quit();
    }
}
