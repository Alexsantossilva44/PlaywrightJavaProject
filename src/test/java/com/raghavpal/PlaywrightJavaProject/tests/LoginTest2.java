package com.raghavpal.PlaywrightJavaProject.tests;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import com.raghavpal.PlaywrightJavaProject.base.BaseTest;
import com.raghavpal.PlaywrightJavaProject.pages.HomePage;
import com.raghavpal.PlaywrightJavaProject.pages.LoginPage;
import org.testng.SkipException;
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

        test.info("Navigating to the login page and logging in with valid credentials");
        loginPage.navigate();

        test.info("Realizando o login com username: 'Admin' e password: 'admin123'");
        loginPage.login("Admin", "admin123");

        // VALIDAR: Se o link "Time" está visível na HomePage após o login
        // Isso garante que o login funcionou
        assertThat(page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Time"))).isVisible();

        test.info("Realizando o login com username: 'admin123'");
        homePage.clickTimeLink();

        // VALIDAR: Se a URL mudou para a página de Time
        assertThat(page).hasURL(Pattern.compile(".*time/viewEmployeeTimesheet"));

        test.info("All steps executed successfully.");
    }

    @Test
    public void loginTest1() {

        LoginPage loginPage = new LoginPage(page);
        HomePage homePage = new HomePage(page);

        test.info("Navigating to the login page and logging in with valid credentials");
        loginPage.navigate();

        test.info("Realizando o login com username: 'Admin' e password: 'admin123'");
        loginPage.login("Admin", "admin123");

        // VALIDAR: Se o link "Time" está visível na HomePage após o login
        // Isso garante que o login funcionou
        assertThat(page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Time"))).isVisible();

        test.info("Realizando o login com username: 'admin123'");
        homePage.clickTimeLink();

        // VALIDAR: Se a URL mudou para a página de Time
        assertThat(page).hasURL(Pattern.compile(".*time/viewEmployeeTimesheet"));

        test.info("All steps executed successfully.");
    }

    @Test
    public void loginTest2() {

        test.info("Skipping this test for demonstration purposes");
        throw new SkipException("Skipping this test for demonstration purposes");
    }

    @Test
    public void loginTest3() {
        LoginPage loginPage = new LoginPage(page);
        HomePage homePage = new HomePage(page); // Descomentei o HomePage

        test.info("Navigating to the login page and logging in with valid credentials");
        loginPage.navigate();

        test.info("Realizando o login com username: 'Admin' e password: 'admin123'");
        loginPage.login("Admin", "admin123");

        // Valida se o login deu certo vendo o menu
        assertThat(page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Time"))).isVisible();

        test.info("Clicando no link Time para navegar");
        homePage.clickTimeLink(); // AGORA ELE CLICA!

        // Aguarda a URL mudar antes de fazer a asserção (isso evita flutuações de rede)
        page.waitForURL(Pattern.compile(".*time/viewEmployeeTimesheet"));

        // Validação final
        assertThat(page).hasURL(Pattern.compile(".*time/viewEmployeeTimesheet"));

        test.info("All steps executed successfully.");
    }
}

