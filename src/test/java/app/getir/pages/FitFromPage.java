package app.getir.pages;

import app.getir.utilities.MobileUtils;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;

public class FitFromPage extends BasePage{

    public MobileElement item(String itemName) {
        return driver.findElement(By.xpath("//*[@text='" + itemName + "']"));
    }

    public MobileElement addButton(String itemName) {
        return driver.findElement(By.xpath("//*[@text='" + itemName + "']/following-sibling::android.widget.LinearLayout/*[@resource-id='com.getir.casestudy.dev:id/btnAdd']"));
    }

    public void addItem(String itemName) {

        int attempts = 0;
        while (attempts < 5) {
            try {
                if (item(itemName).isDisplayed()) {
                    addButton(itemName).click();
                    break;
                }
            }catch (Exception e) {
                e.printStackTrace();
            }
            MobileUtils.scrollDown(driver);
            attempts++;
        }

    }
}
