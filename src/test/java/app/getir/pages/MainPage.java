package app.getir.pages;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class MainPage extends BasePage{

    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"Yiyecek\")") // appiumdan gelen locatorlarda bu sekilde kullanilabilir
    public MobileElement foods;

    @FindBy(id = "com.getir.casestudy.dev:id/ga_toolbar_getir10GABasketButton")
    public MobileElement basketBtn;

    @FindBy(xpath = "//*[@resource-id='com.getir.casestudy.dev:id/tvTitle']")
    public List<MobileElement> menuList;

    public MobileElement menu(String menuName) {
        String xpath = "//*[@text='" + menuName + "']";
        return driver.findElementByXPath(xpath);
    }


}
