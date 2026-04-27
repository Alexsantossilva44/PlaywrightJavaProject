package com.raghavpal.PlaywrightJavaProject.tests;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import com.raghavpal.PlaywrightJavaProject.base.BaseTest;
import org.testng.annotations.Test;


/**
 * Autor: Alex Silva
 * Data: 27/04/2026
 */

public class LoginTest extends BaseTest {

    @Test
    public void test() {
        page.navigate("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Username")).click();
        page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Username")).fill("Admin");
        page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Username")).press("Tab");
        page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Password")).fill("admin123");
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Login")).click();
        page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Time")).click();
    }
}

