package com.raghavpal.PlaywrightJavaProject.tests;

import com.raghavpal.PlaywrightJavaProject.base.BaseTest;
import com.raghavpal.PlaywrightJavaProject.pages.HomePage;
import com.raghavpal.PlaywrightJavaProject.pages.LoginPage;
import org.testng.annotations.Test;


/**
 * Autor: Alex Silva
 * Data: 27/04/2026
 */

public class LoginTest2 extends BaseTest {

    @Test
    public void test() {
        LoginPage loginPage = new LoginPage(page);
        HomePage homePage = new HomePage(page);

        page.navigate("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        loginPage.addUsername("Admin");
        loginPage.addPassword("admin123");
        loginPage.clickLoginButton();
        homePage.clickTimeLink();

    }
}

