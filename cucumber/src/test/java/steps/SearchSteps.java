package steps;

import com.codeborne.selenide.Condition;
import driver.WebDriverHolder;
import model.pages.implementation.main.IherbMainPage;
import model.pages.implementation.search.SearchResultPage;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.pages.Pages;
import net.thucydides.core.steps.ScenarioSteps;
import org.openqa.selenium.WebDriver;

public class SearchSteps extends ScenarioSteps {
    /*private IherbMainPage mainPage = new IherbMainPage(WebDriverHolder.getWebDriver());
    private SearchResultPage searchResultPage = new SearchResultPage(WebDriverHolder.getWebDriver());*/

    WebDriver driver;
    private IherbMainPage mainPage = new IherbMainPage(driver);
    private SearchResultPage searchResultPage = new SearchResultPage(driver);

    @Step
    public void openMainPage() {
        mainPage.open();
    }

    @Step
    public void inputRequest(String request) {
        mainPage.getHeader().inputRequest(request);
    }

    @Step
    public void clickSearchButton() {
        mainPage.getHeader().clickSearchButton();
    }

    @Step
    public void assertThatUserOnSearchPage() {
        searchResultPage.getPageTitle().waitUntilVisible().containsText("Search Results for");
        //searchResultPage.getPageTitle().shouldBe(Condition.visible).shouldHave(Condition.text("Search Results for"));
    }

    @Step
    public void assertThatPageTitleEqualsToRequest(String request) {
        searchResultPage.getNameOfSearchedItem().waitUntilVisible().containsOnlyText(request);
    }
}
