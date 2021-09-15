package co.com.sophos.tests;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import co.com.sophos.pages.utils.Listeners.TestListener;
/**
 * 
 * @author catalina perez
 */
@Listeners({TestListener.class})
@Epic("Regression Tests")
@Feature("Sophos Search work")
public class SophosSearchTest extends BaseTest {
    
    String wordToSearch="Java";

    @Test(priority = 0, description = "Test Description: go to the page work with us and fine de offers.")
    @Severity(SeverityLevel.BLOCKER)
    @Description("Test Description: go to the page work with us and fine de offers.")
    @Story("go to the page work with us and fine de offers.")
    public void searchOfferTest() {
        homePage.goToSophos().goToOptionWorkWithUs();
        workWithUsPage.searchWord(wordToSearch).getOffers();
    }
}
