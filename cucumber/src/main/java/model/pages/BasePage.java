package model.pages;

import driver.WebDriverHolder;
import lombok.SneakyThrows;
import model.data.properties.Environments;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.support.PageFactory;

import java.util.Properties;

public abstract class BasePage<P> {
    private String path;

    public BasePage(String path) {
        this.path = path;
        PageFactory.initElements(WebDriverHolder.getWebDriver(), this);
    }

    @SneakyThrows
    public P openPage() {
        new Properties() {{
            load(getClass().getClassLoader().getResourceAsStream("environments.properties"));
            WebDriverHolder.getWebDriver().get(getProperty(ConfigFactory.create(Environments.class).getEnvironment()) + path);
        }};

        return (P) this;
    }
}
