package pages;

import ro.altom.altunitytester.AltUnityDriver;
import ro.altom.altunitytester.AltUnityObject;
import ro.altom.altunitytester.Commands.FindObject.AltFindObjectsParameters;
import ro.altom.altunitytester.Commands.FindObject.AltWaitForObjectsParameters;
import utilities.BasePage;

public class ZulaAddGoldPage extends BasePage {
    
    public AltUnityObject gold80000;
    public AltUnityObject gold40000;
    public AltUnityObject gold15500;
    public AltUnityObject gold8000;
    public AltUnityObject gold4000;
    public AltUnityObject gold800;
    public AltUnityObject closeButton;

    public ZulaAddGoldPage(AltUnityDriver driver) {
        super(driver);
    }

    public void setGold80000() {
        AltFindObjectsParameters par=new AltFindObjectsParameters.Builder(AltUnityDriver.By.PATH, "//LobbyStateUIView(Clone)/PurchaseCurrencyPopupUIView/Canvas/SafeArea/GoldPurchaseBigUIView/Image_BackgroundPrice/Text_Price").build();
        AltWaitForObjectsParameters params = new AltWaitForObjectsParameters.Builder(par).withTimeout(10).build();
        this.gold80000 = getDriver().waitForObject(params);
        isTextCorrect(gold80000, "₺699,99");
    }

    public void setGold40000() {
        AltFindObjectsParameters par=new AltFindObjectsParameters.Builder(AltUnityDriver.By.PATH, "//LobbyStateUIView(Clone)/PurchaseCurrencyPopupUIView/Canvas/SafeArea/GoldPurchaseMediumUIView/Image_BackgroundPrice/Text_Price").build();
        AltWaitForObjectsParameters params = new AltWaitForObjectsParameters.Builder(par).withTimeout(10).build();
        this.gold40000 = getDriver().waitForObject(params);
        isTextCorrect(gold40000, "₺349,99");
    }

    public void setGold15500() {
        AltFindObjectsParameters par=new AltFindObjectsParameters.Builder(AltUnityDriver.By.PATH, "//LobbyStateUIView(Clone)/PurchaseCurrencyPopupUIView/Canvas/SafeArea/GoldPurchaseMediumUIView (2)/Image_BackgroundPrice/Text_Price").build();
        AltWaitForObjectsParameters params = new AltWaitForObjectsParameters.Builder(par).withTimeout(10).build();
        this.gold15500 = getDriver().waitForObject(params);
        isTextCorrect(gold15500, "₺134,99");
    }

    public void setGold8000() {
        AltFindObjectsParameters par=new AltFindObjectsParameters.Builder(AltUnityDriver.By.PATH, "//LobbyStateUIView(Clone)/PurchaseCurrencyPopupUIView/Canvas/SafeArea/GoldPurchaseSmallUIView/Image_BackgroundPrice/Text_Price").build();
        AltWaitForObjectsParameters params = new AltWaitForObjectsParameters.Builder(par).withTimeout(10).build();
        this.gold8000 = getDriver().waitForObject(params);
        isTextCorrect(gold8000, "₺69,99");
    }

    public void setGold4000() {
        AltFindObjectsParameters par=new AltFindObjectsParameters.Builder(AltUnityDriver.By.PATH, "//LobbyStateUIView(Clone)/PurchaseCurrencyPopupUIView/Canvas/SafeArea/GoldPurchaseSmallUIView (2)/Image_BackgroundPrice/Text_Price").build();
        AltWaitForObjectsParameters params = new AltWaitForObjectsParameters.Builder(par).withTimeout(10).build();
        this.gold4000 = getDriver().waitForObject(params);
        isTextCorrect(gold4000, "₺34,99");
    }

    public void setGold800() {
        AltFindObjectsParameters par=new AltFindObjectsParameters.Builder(AltUnityDriver.By.PATH, "//LobbyStateUIView(Clone)/PurchaseCurrencyPopupUIView/Canvas/SafeArea/GoldPurchaseSmallUIView (3)/Image_BackgroundPrice/Text_Price").build();
        AltWaitForObjectsParameters params = new AltWaitForObjectsParameters.Builder(par).withTimeout(10).build();
        this.gold800 = getDriver().waitForObject(params);
        isTextCorrect(gold800, "₺6,99");
    }

    public void setCloseButton() {
        AltFindObjectsParameters par=new AltFindObjectsParameters.Builder(AltUnityDriver.By.NAME, "Button_Close").build();
        AltWaitForObjectsParameters params = new AltWaitForObjectsParameters.Builder(par).withTimeout(10).build();
        this.closeButton = getDriver().waitForObject(params);
    }

}
