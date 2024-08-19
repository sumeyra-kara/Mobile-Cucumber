package app.getir.pages;

import app.getir.step_definitions.Initialize;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;


public class BasePage {

    AppiumDriver<MobileElement> driver;

    public BasePage() {
        this.driver= Initialize.driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver),this);
    }
}
