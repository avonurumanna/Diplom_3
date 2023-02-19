package ui_tests;

import io.qameta.allure.junit4.DisplayName;
import org.hamcrest.MatcherAssert;
import org.junit.Test;
import page_object.ForgotPasswordPage;
import page_object.LoginPage;
import page_object.RegistrationPage;
import settings.BaseUISettings;

import static org.hamcrest.CoreMatchers.containsString;

public class LoginTest extends BaseUISettings {

    public final String createOrderButtonText = "Оформить заказ";

    @Test
    @DisplayName("Check login using Account Profile button")
    public void checkLoginUsingAccountProfileButtonExpectedUserLogged() {
        mainPage.clickAccountButton();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.fillEmail("testemail456@gmail.com");
        loginPage.fillPassword("1234567");
        loginPage.clickLoginButton();
        mainPage.waitUnitPageLoaded(8);
        MatcherAssert.assertThat(mainPage.getTextLoginButton(), containsString(createOrderButtonText));
    }

    @Test
    @DisplayName("Check login using button on registration page")
    public void checkLoginUsingButtonOnRegistrationPageExpectedUserLogged() {
        mainPage.clickAccountButton();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.clickRegistrationLink();
        RegistrationPage registrationPage = new RegistrationPage(driver);
        registrationPage.clickLoginButton();
        loginPage.fillEmail("testemail456@gmail.com");
        loginPage.fillPassword("1234567");
        loginPage.clickLoginButton();
        mainPage.waitUnitPageLoaded(8);
        MatcherAssert.assertThat(mainPage.getTextLoginButton(), containsString(createOrderButtonText));
    }

    @Test
    @DisplayName("Check login using button on forgot password page")
    public void checkLoginUsingButtonOnForgotPasswordPageExpectedUserLogged() {
        mainPage.clickAccountButton();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.clickForgotPasswordLink();
        ForgotPasswordPage forgotPasswordPage = new ForgotPasswordPage(driver);
        forgotPasswordPage.clickLoginLink();
        loginPage.fillEmail("testemail456@gmail.com");
        loginPage.fillPassword("1234567");
        loginPage.clickLoginButton();
        mainPage.waitUnitPageLoaded(8);
        MatcherAssert.assertThat(mainPage.getTextLoginButton(), containsString(createOrderButtonText));
    }


}
