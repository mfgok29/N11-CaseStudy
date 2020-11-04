package com.n11.pages;

import com.n11.utilies.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class SearchPage {
    public SearchPage() {
        PageFactory.initElements(Driver.get(), this);

    }



    @FindBy(css = "span[class='textImg followBtn']")
    public List<WebElement> addToFavoritesBtn;

    @FindBy(css = "h3.productName")
    public List<WebElement> products;

    @FindBy(css = "div.resultText")
    public WebElement resultText;



    public String getResult(){
        return resultText.getText();
    }
}
