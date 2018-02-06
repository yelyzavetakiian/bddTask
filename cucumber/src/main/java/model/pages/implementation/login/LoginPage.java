package model.pages.implementation.login;

import driver.WebDriverHolder;
import lombok.Getter;
import model.pages.BasePage;
import model.pages.implementation.user.profile.UserProfilePage;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;
import net.thucydides.core.pages.WebElementFacade;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DefaultUrl("https://ua.iherb.com")
public class LoginPage extends PageObject {
    @FindBy(xpath = "//div[contains(@class,'form-group text-left sign-in-password-options')]/input[@class='form-control']")
    private WebElementFacade emailInput;
    @FindBy(xpath = "//input[@id='Password']")
    private WebElementFacade passwordInput;
    @FindBy(xpath = "//input[@value='Sign In with Password']")
    private WebElementFacade signInButton;
    @FindBy(xpath = "//input[@value='Sign In with Password']")
    private @Getter WebElementFacade EmailAddressIsRequiredMessage;
    @FindBy(xpath = "//input[@value='Sign In with Password']")
    private @Getter WebElementFacade PasswordIsRequiredMessage;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public LoginPage inputEmail(String email) {
        emailInput.sendKeys(email);
        return this;
    }

    public LoginPage inputPassword(String password) {
        passwordInput.sendKeys(password);
        return this;
    }

    public UserProfilePage clickLogin() {
        signInButton.click();
        return new UserProfilePage(WebDriverHolder.getWebDriver());
    }

    public UserProfilePage signIn(String email, String password) {
        emailInput.click();
        inputEmail(email);
        inputPassword(password);
        return clickLogin();
    }
}
