package model.pages.implementation.main;

import driver.WebDriverHolder;
import html.elements.Header;
import lombok.Getter;
import model.pages.implementation.login.LoginPage;
import model.pages.implementation.search.SearchResultPage;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.WebDriver;

@DefaultUrl("https://ua.iherb.com")
public class IherbMainPage extends PageObject {
    private WebDriver driver;
    private @Getter Header header = new Header(driver);

    public IherbMainPage(WebDriver driver) {
        super(driver);
    }

    public LoginPage openLoginPage() {
        return header.openLoginPage();
    }

    public SearchResultPage search(String request) {
        return header.search(request);
    }
}
