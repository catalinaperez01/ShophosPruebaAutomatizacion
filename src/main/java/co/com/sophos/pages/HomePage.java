package co.com.sophos.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
/**
 *
 * @author catalina perez
 */
public class HomePage extends BasePage {

    public HomePage(WebDriver driver) {
        super(driver);
    }

    String baseURL = "https://www.sophossolutions.com/";
    By popup = By.id("sg-popup-content-wrapper-5998");
    By body = By.xpath("//body");
    By optionMenuWorkWithUs = By.linkText("Trabaja Con Nosotros");
    Keys keyEscape = Keys.ESCAPE;
  
    @Step("Open Browser and go to Sophos Solution Step...")
    public HomePage goToSophos() {
        driver.get(baseURL);
        return this;
    }

    @Step("Go to option 'Trabaje con nosotros' Step...")
    public HomePage goToOptionWorkWithUs() {
        waitVisibility(popup);
        sendKey(keyEscape,body);
        waitVisibility(optionMenuWorkWithUs);
        click(optionMenuWorkWithUs);
        return this;
    }
}