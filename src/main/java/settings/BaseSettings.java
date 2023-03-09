package settings;

import org.openqa.selenium.WebDriver;

public abstract class BaseSettings {

    protected final WebDriver driver;


    public BaseSettings(WebDriver driver) {
        this.driver = driver;
    }

}