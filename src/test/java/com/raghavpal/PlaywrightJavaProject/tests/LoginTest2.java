package com.raghavpal.PlaywrightJavaProject.tests;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import com.raghavpal.PlaywrightJavaProject.base.BaseTest;
import com.raghavpal.PlaywrightJavaProject.pages.HomePage;
import com.raghavpal.PlaywrightJavaProject.pages.LoginPage;
import org.testng.annotations.Test;
import java.util.regex.Pattern;
import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;


/**
 * Autor: Alex Silva
 * Data: 27/04/2026
 */

public class LoginTest2 extends BaseTest {

    @Test
    public void test() {

        LoginPage loginPage = new LoginPage(page);
        HomePage homePage = new HomePage(page);

        loginPage.navigate();
        loginPage.login("Admin", "admin123");

        // VALIDAR: Se o link "Time" está visível na HomePage após o login
        // Isso garante que o login funcionou
        assertThat(page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Time"))).isVisible();

        homePage.clickTimeLink();

        // VALIDAR: Se a URL mudou para a página de Time
        assertThat(page).hasURL(Pattern.compile(".*time/viewEmployeeTimesheet"));
    }
}

