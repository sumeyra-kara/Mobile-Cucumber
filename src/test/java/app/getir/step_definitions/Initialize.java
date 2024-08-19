package app.getir.step_definitions;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class Initialize {

    public static AppiumDriver<MobileElement> driver;
    public  static AppiumDriverLocalService service;

    @Before
    public void setUp()  {
        initializeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }

    @After
    public void tearDown(Scenario scenario) throws InterruptedException {
        if(scenario.isFailed()){
            final byte[] screenshot= ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot,"image/png",scenario.getName());
        }
       // Thread.sleep(3000);
        driver.closeApp();
        service.stop();
    }


    public void initializeDriver(){
        DesiredCapabilities capabilities = new DesiredCapabilities();

        service = new AppiumServiceBuilder()
                .withIPAddress("127.0.0.1")
                .usingAnyFreePort()
                .build();
        service.start();
        // capabilities for Device

        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME,"Android");
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME,"Pixel_2");
        capabilities.setCapability(MobileCapabilityType.VERSION,"11.0");

        // Capabilities for App
        //caps for App
        capabilities.setCapability("appPackage", "com.getir.casestudy.dev");
        capabilities.setCapability("appActivity", "com.getir.casestudy.modules.splash.ui.SplashActivity");

        try {
            driver = new AppiumDriver<>(service.getUrl(), capabilities);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
