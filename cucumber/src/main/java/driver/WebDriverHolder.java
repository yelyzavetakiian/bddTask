package driver;

import org.openqa.selenium.WebDriver;

public class WebDriverHolder {

    private static final ThreadLocal<WebDriver> DRIVER_HOLDER = new ThreadLocal<>();

    public static void setWebDriver(WebDriver webDriver) {
        DRIVER_HOLDER.set(webDriver);
    }

    public static WebDriver getWebDriver() {
        return DRIVER_HOLDER.get();
    }

    public static void closeDriver() {
        DRIVER_HOLDER.get().quit();
        DRIVER_HOLDER.remove();
    }
}
