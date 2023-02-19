package page_object;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import settings.BaseSettings;

public class ForgotPasswordPage extends BaseSettings {


    private final By loginLink = By.xpath("//*[@id=\"root\"]/div/main/div/div/p/a");

    public ForgotPasswordPage(WebDriver driver) {
        super(driver);
    }

    public void clickLoginLink() {
        driver.findElement(loginLink).click();
    }

}
