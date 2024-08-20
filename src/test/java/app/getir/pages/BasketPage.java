package app.getir.pages;

import io.appium.java_client.MobileElement;
import org.openqa.selenium.support.FindBy;

public class BasketPage extends BasePage{

    @FindBy(xpath = "//*[@text='There is no result']")
    public MobileElement noResult;

    @FindBy(id = "com.getir.casestudy.dev:id/ga_toolbar_leftIconImageView")
    public MobileElement backBtn;

    @FindBy(id = "com.getir.casestudy.dev:id/tvTotalTitle")
    public MobileElement totalPrice;
}
