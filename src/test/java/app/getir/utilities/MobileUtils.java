package app.getir.utilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;

import java.time.Duration;

public class MobileUtils {
    public static void scrollDown(AppiumDriver<MobileElement> driver) {
        int height = driver.manage().window().getSize().getHeight();
        int width = driver.manage().window().getSize().getWidth();

        int startPoint = (int) (height * 0.8);
        int endPoint = (int) (height * 0.2);
        int anchor = (int) (width * 0.5);

        new TouchAction<>(driver)
                .press(PointOption.point(anchor, startPoint))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(800)))
                .moveTo(PointOption.point(anchor, endPoint))
                .release()
                .perform();
    }

    public static void scrollUp(AppiumDriver<MobileElement> driver) {
        int height = driver.manage().window().getSize().getHeight();
        int width = driver.manage().window().getSize().getWidth();

        int startPoint = (int) (height * 0.2);
        int endPoint = (int) (height * 0.8);
        int anchor = (int) (width * 0.5);

        new TouchAction<>(driver)
                .press(PointOption.point(anchor, startPoint))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(800)))
                .moveTo(PointOption.point(anchor, endPoint))
                .release()
                .perform();
    }

}
