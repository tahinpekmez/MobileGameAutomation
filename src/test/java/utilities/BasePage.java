package utilities;

import org.testng.Assert;
import ro.altom.altunitytester.AltUnityDriver;
import ro.altom.altunitytester.AltUnityObject;

public class BasePage {

    public AltUnityDriver driver;

    public BasePage(AltUnityDriver driver) {
        this.driver = driver;
    }

    public AltUnityDriver getDriver() {
        return driver;
    }

    public void setDriver(AltUnityDriver driver) {
        this.driver = driver;
    }

    public void isTextCorrect(AltUnityObject object, String text){
        Assert.assertEquals(object.getText(),text);
    }
}
