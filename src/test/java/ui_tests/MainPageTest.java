package ui_tests;

import io.qameta.allure.junit4.DisplayName;
import org.hamcrest.MatcherAssert;
import org.junit.Test;
import settings.BaseUISettings;

import static org.hamcrest.CoreMatchers.containsString;

public class MainPageTest extends BaseUISettings {

    private final String indicatorClass = "tab_tab_type_current__2BEPc";

    @Test
    @DisplayName("Check switching from Buns section to Sauces section")
    public void clickSauceSectionExpectedSwitchedToSauceSectionTest() {
        mainPage.waitUnitPageLoaded(8);
        mainPage.clickSauceSectionButton();
        MatcherAssert.assertThat(mainPage.getSauceSectionClass(), containsString(indicatorClass));
    }

    @Test
    @DisplayName("Check switching from Buns section to Filling section")
    public void clickFillingSectionExpectedSwitchedToFillingSectionTest() {
        mainPage.waitUnitPageLoaded(8);
        mainPage.clickFillingSectionButton();
        MatcherAssert.assertThat(mainPage.getFillingSectionClass(), containsString(indicatorClass));
    }

    @Test
    @DisplayName("Check switching from Filling section to Buns section")
    public void clickBunSectionExpectedSwitchedToBunSectionTest() {
        mainPage.waitUnitPageLoaded(8);
        mainPage.clickFillingSectionButton();
        mainPage.clickBunSectionButton();
        MatcherAssert.assertThat(mainPage.getBunSectionClass(), containsString(indicatorClass));
    }


}
