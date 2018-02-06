package model.pages.implementation.product;

import driver.WebDriverHolder;
import html.elements.Header;
import lombok.Getter;
import model.pages.implementation.cart.CartPage;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;
import net.thucydides.core.pages.WebElementFacade;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DefaultUrl("https://ua.iherb.com")
public class ProductPage extends PageObject {
    @FindBy(xpath = "//a[@class='last']")
    private @Getter WebElementFacade productCategoryName;
    @FindBy(name = "AddToCart")
    private WebElementFacade addToCartButton;

    private WebDriver driver;
    private @Getter Header header = new Header(driver);

    public ProductPage(WebDriver driver) {
        super(driver);
    }

    public CartPage addToCart() {
        addToCartButton.submit();
        return new CartPage(WebDriverHolder.getWebDriver());
    }
}
