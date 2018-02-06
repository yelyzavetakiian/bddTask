package model.pages.implementation.user.profile;

import driver.WebDriverHolder;
import html.elements.Header;
import lombok.Getter;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;
import net.thucydides.core.pages.WebElementFacade;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DefaultUrl("https://ua.iherb.com")
public class UserProfilePage extends PageObject {
    @FindBy(xpath = "//a[contains(text(),'MY ACCOUNT')]")
    private @Getter WebElementFacade myAccountTitle;

    private WebDriver driver;
    private @Getter Header header = new Header(driver);

    public UserProfilePage(WebDriver driver) {
        super(driver);
    }
}
