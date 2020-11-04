package com.n11.step_definitions;

import com.n11.pages.HomePage;
import com.n11.pages.LoginPage;
import com.n11.pages.SearchPage;
import com.n11.utilies.ConfigurationReader;
import com.n11.utilies.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class n11StepDef {
    HomePage homePage = new HomePage();
    LoginPage loginPage = new LoginPage();
    SearchPage searchPage = new SearchPage();

    @Given("go to the n11 homepage")
    public void go_to_the_n11_homepage() {
        String url = ConfigurationReader.get("url");
        Driver.get().get(url);
        homePage.privPoliciyBtn.click();
        System.out.println("I opened the n11.com.tr");
        String actualUrl = Driver.get().getCurrentUrl();
        Assert.assertEquals("Verify this website", url, actualUrl);

    }
    @Given("the user opened the login page")
    public void the_user_opened_the_login_page() {
        homePage.SignInBtn.click();
    }


    @When("login with valid credentials")
    public void login_with_valid_credentials() {
        String username = ConfigurationReader.get("username");
        String password = ConfigurationReader.get("password");
        loginPage.fbLogin(username, password);

        String expectedTitle = "hayat sana gelir";
        Assert.assertEquals("Verify pageSubTitle", expectedTitle, homePage.getPageSubTitle());
        System.out.println("PageSubTitle = " + homePage.getPageSubTitle());




    }
    @Then("in the search area write {} and click search button")
    public void in_the_search_area_write_and_click_search_button(String product) {
        homePage.searchProduct(product);
        searchPage.getResult();
        System.out.println("the result of the product = " + searchPage.getResult());

    }
}
