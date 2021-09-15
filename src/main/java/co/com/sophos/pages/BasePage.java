package co.com.sophos.pages;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 *
 * @author catalina perez
 */
public class BasePage {

    int count = 0;
    public WebDriver driver;
    public WebDriverWait wait;


    public BasePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 20);
    }


    public void click(By elementLocation) {
        driver.findElement(elementLocation).click();
    }


    public void writeText(By elementLocation, String text) {
        driver.findElement(elementLocation).sendKeys(text);
    }

    public String readText(By elementLocation) {
        return driver.findElement(elementLocation).getText();
    }


    public void waitVisibility(By by) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }


    public void waitWhenVisibilityFrame(By by) {
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(by));
    }

    public void changetoIframe(String idIframe) {
        this.driver.switchTo().frame(idIframe);
    }

    public void sendKey(Keys key, By by) {
        driver.findElement(by).sendKeys(key);
    }

    public void printElements(By completeOffer, HashMap<String, By> elementsToPrint) {
        for (WebElement card : driver.findElements(completeOffer)) {
            count++;
            System.out.println("Oferta " + count);
            System.out.println("");
            for (Map.Entry<String, By> entry : elementsToPrint.entrySet()) {
                System.out.println(entry.getKey() + " " + card.findElement(entry.getValue()).getText());

            }
        }
    }

    public void printOffers(By principalCards, HashMap<String, By> elementsToPrint, By paginatorElement) {

        List<WebElement> pages = driver.findElements(paginatorElement);
        waitVisibility(principalCards);
        printElements(principalCards, elementsToPrint);
        for (int i = 1; i < pages.size(); i++) {
            WebElement page = pages.get(i);
            page.click();
            waitVisibility(principalCards);
            printElements(principalCards, elementsToPrint);
        }
        count = 1;
    }

}
