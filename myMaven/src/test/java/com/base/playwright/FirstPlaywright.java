package com.base.playwright;

import org.testng.annotations.Test;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class FirstPlaywright {
	@Test
	public void firstPlaywrightProgram() {
		try (Playwright playwright = Playwright.create()) {
			Browser driver = playwright.chromium().launch();
			Page page = driver.newPage();
			page.navigate("https://amazon.in");
			System.out.println(page.title());
		}
	}

}
