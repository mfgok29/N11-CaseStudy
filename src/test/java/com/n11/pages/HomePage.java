package com.n11.pages;

import com.n11.utilies.BrowserUtils;
import com.n11.utilies.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
    public HomePage() {

        PageFactory.initElements(Driver.get(), this);
    }

    @FindBy(className = "btnSignIn")
    public WebElement SignInBtn;

    @FindBy(xpath = "//span[text()='Tamam']")
    public WebElement privPoliciyBtn;

    @FindBy(css = "input#searchData")
    public WebElement searchInput;

    @FindBy(css = "a.searchBtn")
    public WebElement searchBtn;

    @FindBy(css = "a[class*='home']")
    public WebElement pageSubTitle;

    public void searchProduct(String product) {
        BrowserUtils.waitFor(2);
        searchInput.sendKeys(product);
        searchBtn.click();
    }
    public String getPageSubTitle() {

        return pageSubTitle.getAttribute("title");
    }
}
