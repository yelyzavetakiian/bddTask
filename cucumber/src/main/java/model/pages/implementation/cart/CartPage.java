package model.pages.implementation.cart;

import driver.WebDriverHolder;
import html.elements.Header;
import lombok.Getter;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;
import net.thucydides.core.pages.WebElementFacade;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.text.DecimalFormat;
import java.util.List;

@DefaultUrl("https://ua.iherb.com")
public class CartPage extends PageObject {
    @FindBy(xpath = "//div[contains(@class,'prod-desc')]/a[@class='prod-title']/bdi")
    private @Getter List<WebElementFacade> productTitles;
    @FindBy(xpath = "//div[@class='col-xs-3 col-md-3 text-center']/p")
    private @Getter List<WebElementFacade> productPrices;
    @FindBy(xpath = "//span[@id='sub-total']")
    private @Getter WebElementFacade orderTotalPrice;

    private WebDriver driver;
    private @Getter Header header = new Header(driver);

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public double countOrderTotalPrice() {
        Double sum = productPrices.stream()
                .map(item -> item.getText().substring(1,item.getText().length()))
                .mapToDouble(item -> Double.parseDouble(item))
                .sum();
        DecimalFormat decimalFormat = new DecimalFormat("#.##");

        return Double.parseDouble(decimalFormat.format(sum));
    }
}
