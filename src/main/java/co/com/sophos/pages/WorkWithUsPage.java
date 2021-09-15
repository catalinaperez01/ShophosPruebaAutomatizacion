package co.com.sophos.pages;

import io.qameta.allure.Step;
import java.util.HashMap;
import java.util.LinkedHashMap;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

/**
 *
 * @author catalina
 */
public class WorkWithUsPage extends BasePage {

    By inputTextBuscar = By.id("s");
    By principalCard = By.className("elementor-post");
    By offerTitle = By.className("elementor-post__title");
    By dateOffer = By.className("elementor-post-date");
    By descriptionOffer = By.className("elementor-post__excerpt");
    By paginator = By.className("page-numbers");
    Keys enterKey = Keys.ENTER;
    HashMap<String, By> toPrint;

    public WorkWithUsPage(WebDriver driver) {
        super(driver);
        this.toPrint = new LinkedHashMap<>();
    }

    /**
     *
     * @param word Palabra a buscar
     * @return
     */
    @Step("Open Browser and go to Sophos Solution Step...")
    public WorkWithUsPage searchWord(String word) {

        waitVisibility(inputTextBuscar);
        writeText(inputTextBuscar, word);
        sendKey(enterKey, inputTextBuscar);
        return this;
    }

    /**
     *
     * @return WorkWithUsPage
     */
    @Step("Open Browser and go to Sophos Solution Step...")
    public WorkWithUsPage getOffers() {

        toPrint.put("Nombre de la Oferta:", offerTitle);
        toPrint.put("Fecha:", dateOffer);
        toPrint.put("Descripcion:", descriptionOffer);
        printOffers(principalCard, toPrint, paginator);

        return this;
    }

}
