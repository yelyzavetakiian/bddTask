package html.elements;

import driver.WebDriverHolder;
import lombok.Getter;
import model.pages.implementation.cart.CartPage;
import model.pages.implementation.login.LoginPage;
import model.pages.implementation.main.IherbMainPage;
import model.pages.implementation.search.SearchResultPage;
import net.thucydides.core.pages.PageObject;
import net.thucydides.core.pages.WebElementFacade;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Header extends PageObject{
    @FindBy(xpath = "//div[@class='iherb-header-cart float-right']")
    private @Getter WebElementFacade cartIcon;
    @FindBy(xpath = "//div[contains(@class,'iherb-header-logo')]/a")
    private @Getter WebElementFacade iherbIcon;
    @FindBy(xpath = ".//input[@class='range-min']")
    private @Getter WebElementFacade minPriceInput;
    @FindBy(xpath = ".//input[@class='range-max']")
    private @Getter WebElementFacade maxPriceInput;
    @FindBy(xpath = "//button[contains(@class,'range-filter')]")
    private @Getter WebElementFacade searchByPriceButton;
    @FindBy(xpath = ".//input[@id='txtSearch']")
    private @Getter WebElementFacade requestInput;
    @FindBy(xpath = ".//button[@id='searchBtn']")
    private @Getter WebElementFacade searchButton;
    @FindBy(xpath = "//a[@class='iherb-header-signed-out btn btn-primary btn-block sign-in']")
    private @Getter WebElementFacade signInButton;
    @FindBy(css = ".iherb-header-account-my-account")
    private @Getter WebElementFacade myAccountButton;
    @FindBy(xpath = "//label[contains(@class,'iherb-header-account-name')]")
    private @Getter WebElementFacade userEmail;

    public Header(WebDriver driver) {
        super(driver);
    }

    public LoginPage openLoginPage() {
        Actions action = new Actions(WebDriverHolder.getWebDriver());
        action.moveToElement(myAccountButton).moveToElement(signInButton).click().build().perform();

        return new LoginPage(WebDriverHolder.getWebDriver());
    }

    public void inputRequest(String request) {
        requestInput.sendKeys(request);
    }

    public void clickSearchButton() {
        searchButton.click();
    }

    public SearchResultPage search(String request) {
        inputRequest(request);
        clickSearchButton();

        return new SearchResultPage(WebDriverHolder.getWebDriver());
    }

    public void inputMinPrice(int minPrice) {
        minPriceInput.sendKeys(String.valueOf(minPrice));
    }

    public void inputMaxPrice(int maxPrice) {
        maxPriceInput.sendKeys(String.valueOf(maxPrice));
    }

    public void clickSearchByPriceButton() {
        searchByPriceButton.click();
    }

    public SearchResultPage search(int minPrice, int maxPrice) {
        inputMinPrice(minPrice);
        inputMaxPrice(maxPrice);
        clickSearchByPriceButton();

        return new SearchResultPage(WebDriverHolder.getWebDriver());
    }

    public IherbMainPage goToMainPage() {
        iherbIcon.click();

        return new IherbMainPage(WebDriverHolder.getWebDriver());
    }

    public CartPage goToCartPage() {
        Actions actions = new Actions(WebDriverHolder.getWebDriver());
        actions.moveToElement(cartIcon).click().build().perform();

        return new CartPage(WebDriverHolder.getWebDriver());
    }
}
