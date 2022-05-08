package pages;

import ro.altom.altunitytester.AltUnityDriver;
import ro.altom.altunitytester.AltUnityObject;
import ro.altom.altunitytester.Commands.FindObject.AltFindObjectsParameters;
import ro.altom.altunitytester.Commands.FindObject.AltWaitForObjectsParameters;
import utilities.BasePage;

public class ZulaStorePage extends BasePage {
    
    public AltUnityObject offerTitle;
    public AltUnityObject offerSubtitle;
    public AltUnityObject offerPrice;
    public AltUnityObject backButton;
    public AltUnityObject remainingTime;

    public ZulaStorePage(AltUnityDriver driver) {
        super(driver);
    }

    public void setOfferTitle() {
        AltFindObjectsParameters par=new AltFindObjectsParameters.Builder(AltUnityDriver.By.NAME, "OfferTitleText").build();
        AltWaitForObjectsParameters params = new AltWaitForObjectsParameters.Builder(par).withTimeout(10).build();
        this.offerTitle = getDriver().waitForObject(params);
        isTextCorrect(offerTitle, "OPTİMUM SİLAH PAKETİ");
    }

    public void setOfferSubtitle() {
        AltFindObjectsParameters par=new AltFindObjectsParameters.Builder(AltUnityDriver.By.NAME, "OfferSubtitleText").build();
        AltWaitForObjectsParameters params = new AltWaitForObjectsParameters.Builder(par).withTimeout(10).build();
        this.offerSubtitle = getDriver().waitForObject(params);
        isTextCorrect(offerSubtitle, "250 ADET NADİR, EFSANEVİ VEYA DESTANSI KART KAZANDIRAN KASA");
    }

    public void setOfferPrice() {
        AltFindObjectsParameters par=new AltFindObjectsParameters.Builder(AltUnityDriver.By.NAME, "TextCurrency").build();
        AltWaitForObjectsParameters params = new AltWaitForObjectsParameters.Builder(par).withTimeout(10).build();
        this.offerPrice = getDriver().waitForObject(params);
        isTextCorrect(offerPrice, "₺36,99");
    }

    public void setRemainingTime() {
        AltFindObjectsParameters par=new AltFindObjectsParameters.Builder(AltUnityDriver.By.NAME, "RemainingTime").build();
        AltWaitForObjectsParameters params = new AltWaitForObjectsParameters.Builder(par).withTimeout(10).build();
        this.remainingTime = getDriver().waitForObject(params);
        isTextCorrect(remainingTime, "Bitiş: 19g");
    }

    public void setBackButton() {
        AltFindObjectsParameters par=new AltFindObjectsParameters.Builder(AltUnityDriver.By.NAME, "Button_Back").build();
        AltWaitForObjectsParameters params = new AltWaitForObjectsParameters.Builder(par).withTimeout(10).build();
        this.backButton = getDriver().waitForObject(params);
    }

}
