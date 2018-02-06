package model.pages.implementation.search;

import com.codeborne.selenide.SelenideElement;
import driver.WebDriverHolder;
import html.elements.Header;
import lombok.Getter;
import model.pages.implementation.cart.CartPage;
import model.pages.implementation.product.ProductPage;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;
import net.thucydides.core.pages.WebElementFacade;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

@DefaultUrl("https://ua.iherb.com")
public class SearchResultPage extends PageObject {
    @FindBy(xpath = "//span[@class='orange']")
    private @Getter WebElementFacade nameOfSearchedItem;
    @FindBy(xpath = "//a[@class='applied-filter']")
    private @Getter WebElementFacade appliedFilter;
    @FindBy(xpath = "//label[@class='applied-filter-label']")
    private WebElementFacade appliedFilterLabel;
    @FindBy(xpath = "//a[@class='applied-filter-clear']")
    private WebElementFacade removeFilters;
    @FindBy(xpath = "//p[@class='no-results-found-heading']")
    private @Getter WebElementFacade NoResultsFoundMessage;
    @FindBy(xpath = "//div[@class='MainContent']/p")
    private  @Getter WebElementFacade PageErrorMessage;
    @FindBy(xpath = "//div[contains(@class,'product ga-product')]//button")
    private List<WebElementFacade> addToCartButtons;
    @FindBy(xpath = "//a[@data-ga-event-action='productClick']")
    private List<WebElementFacade> openProductButtons;
    @FindBy(xpath = "//span[@class='product-title']")
    private List<WebElementFacade> productTitles;
    @FindBy(css = "h1.sub-header-title")
    private @Getter WebElementFacade pageTitle;

    private WebDriver driver;
    private @Getter Header header = new Header(driver);

    public SearchResultPage(WebDriver driver) {
        super(driver);
    }

    public SearchResultPage filterSearch(int minPrice, int maxPrice) {
        return header.search(minPrice, maxPrice);
    }

    public SearchResultPage removeFilters() {
        Actions actions = new Actions(WebDriverHolder.getWebDriver());
        actions.moveToElement(removeFilters).click().perform();

        new WebDriverWait(WebDriverHolder.getWebDriver(), 6)
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[@class='applied-filter']")));
        return this;
    }

    public CartPage addToCartProduct(int productNumber) {
        if (productNumber > addToCartButtons.size()) {
            addToCartButtons.get(0).submit();
        }
        addToCartButtons.get(productNumber).submit();

        return new CartPage(WebDriverHolder.getWebDriver());
    }

    public String getProductTitle(int productNumber) {
        return productTitles.get(productNumber).getText();
    }

    public ProductPage openProduct(int productNumber) {
        openProductButtons.get(productNumber * 2).click();
        return new ProductPage(WebDriverHolder.getWebDriver());
    }

    public boolean assertFiltersArePresent() {
        new WebDriverWait(WebDriverHolder.getWebDriver(), 6)
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//label[@class='applied-filter-label']")));
        if (appliedFilterLabel != null) {
            return true;
        }

        return false;
    }
}
