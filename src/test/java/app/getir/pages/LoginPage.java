package app.getir.pages;

import io.appium.java_client.MobileElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends  BasePage{

    @FindBy(id = "com.getir.casestudy.dev:id/usernameEditText")
    public MobileElement usernameInput;

    @FindBy(id = "com.getir.casestudy.dev:id/passwordEditText")
    public MobileElement passwordInput;

    @FindBy(id = "com.getir.casestudy.dev:id/loginButton")
    public MobileElement loginButton;

    public void login(String username, String password) {
        usernameInput.sendKeys(username);
        passwordInput.sendKeys(password);
        loginButton.click();
    }


}
