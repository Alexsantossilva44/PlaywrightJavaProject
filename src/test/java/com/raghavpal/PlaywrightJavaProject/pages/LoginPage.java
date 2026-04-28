package com.raghavpal.PlaywrightJavaProject.pages;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;

/**
 * Autor: Alex Silva
 * Data: 27/04/2026
 */

public class LoginPage {

    private Page page;

    // Constructor
    public LoginPage(Page page) {
        this.page = page;
    }

    // Métodos de Ação
    public void addUsername(String username) {
        // Chamada direta do método do Playwright
        page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Username"))
                .fill(username);
    }

    public void addPassword(String password) {
        page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Password"))
                .fill(password);
    }

    public void clickLoginButton() {
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Login"))
                .click();
    }

    public void navigate() {
        page.navigate("https://opensource-demo.orangehrmlive.com/");
    }

    // Método que agrupa as ações de login
    public void login(String username, String password) {
        this.addUsername(username);
        this.addPassword(password);
        this.clickLoginButton();
    }
}