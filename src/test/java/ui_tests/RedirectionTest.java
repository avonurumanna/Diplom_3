package ui_tests;

import io.qameta.allure.junit4.DisplayName;
import org.hamcrest.MatcherAssert;
import org.junit.Test;
import page_object.AccountProfilePage;
import page_object.LoginPage;
import settings.BaseUISettings;

import static org.hamcrest.CoreMatchers.containsString;

public class RedirectionTest extends BaseUISettings {

    public final String createOrderButtonText = "Оформить заказ";
    public final String profileLinkText = "Профиль";
    public final String userTestLogin = "testemail456@gmail.com";
    public final String userTestPassword = "1234567";

    @Test
    @DisplayName("Check redirection from account profile page to main page using click on logo")
    public void clickLogoExpectedRedirectToMainPageTest() {
        mainPage.clickAccountButton();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.fillEmail(userTestLogin);
        loginPage.fillPassword(userTestPassword);
        loginPage.clickLoginButton();
        mainPage.waitUnitPageLoaded(8);
        mainPage.clickAccountButton();
        AccountProfilePage accountProfilePage = new AccountProfilePage(driver);
        accountProfilePage.waitUnitPageLoaded(8);
        accountProfilePage.clickLogoLink();
        mainPage.waitUnitPageLoaded(8);
        MatcherAssert.assertThat(mainPage.getTextCreateOrderButton(), containsString(createOrderButtonText));
    }

    @Test
    @DisplayName("Check redirection from account profile page to main page using constructor link")
    public void clickConstructorExpectedRedirectToMainPageTest() {
        mainPage.clickAccountButton();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.fillEmail(userTestLogin);
        loginPage.fillPassword(userTestPassword);
        loginPage.clickLoginButton();
        mainPage.waitUnitPageLoaded(8);
        mainPage.clickAccountButton();
        AccountProfilePage accountProfilePage = new AccountProfilePage(driver);
        accountProfilePage.waitUnitPageLoaded(10);
        accountProfilePage.clickConstructorLink();
        mainPage.waitUnitPageLoaded(20);
        MatcherAssert.assertThat(mainPage.getTextCreateOrderButton(), containsString(createOrderButtonText));
    }

    @Test
    @DisplayName("Check redirection from main page page to account profile using Account profile button")
    public void redirectToAccountProfileExpectedAccountProfileOpenedTest() {
        mainPage.clickAccountButton();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.fillEmail(userTestLogin);
        loginPage.fillPassword(userTestPassword);
        loginPage.clickLoginButton();
        mainPage.waitUnitPageLoaded(8);
        mainPage.clickAccountButton();
        AccountProfilePage accountProfilePage = new AccountProfilePage(driver);
        accountProfilePage.waitUnitPageLoaded(100);
        MatcherAssert.assertThat(accountProfilePage.getProfileText(), containsString(profileLinkText));
    }
}
