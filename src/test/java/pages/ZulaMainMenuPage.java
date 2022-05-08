package pages;

import ro.altom.altunitytester.AltUnityDriver;
import ro.altom.altunitytester.AltUnityObject;
import ro.altom.altunitytester.Commands.FindObject.AltFindObjectsParameters;
import ro.altom.altunitytester.Commands.FindObject.AltWaitForObjectsParameters;
import utilities.BasePage;


public class ZulaMainMenuPage extends BasePage {
    
    public AltUnityObject storeButton;
    public AltUnityObject inventoryButton;
    public AltUnityObject settingsButton;
    public AltUnityObject missionsButton;
    public AltUnityObject runButton;
    public AltUnityObject characterName;
    public AltUnityObject gameModeName;
    public AltUnityObject addGoldButton;
    public AltUnityObject statisticsButton;
    public AltUnityObject matchCounterText;
    public AltUnityObject statisticsCloseButton;


    public ZulaMainMenuPage(AltUnityDriver driver) {
        super(driver);
    }

    public void setStoreButton() {
        AltFindObjectsParameters par=new AltFindObjectsParameters.Builder(AltUnityDriver.By.PATH, "//LobbyStateUIView(Clone)/PlayMenuStateUIView(Clone)/SafeArea/Button_BlackMarket/Text").build();
        AltWaitForObjectsParameters params = new AltWaitForObjectsParameters.Builder(par).withTimeout(10).build();
        this.storeButton = getDriver().waitForObject(params);
        isTextCorrect(storeButton, "MARKET");
    }

    public void setCharacterName() {
        AltFindObjectsParameters par=new AltFindObjectsParameters.Builder(AltUnityDriver.By.PATH, "//LobbyStateUIView(Clone)/TopBarUIView(Clone)/Canvas_TopBar/SafeArea/Panel_TopBar/Button_Profile/Content/Text_PlayerName").build();
        AltWaitForObjectsParameters params = new AltWaitForObjectsParameters.Builder(par).withTimeout(10).build();
        this.characterName = driver.waitForObject(params);
        isTextCorrect(characterName, "Guest-0962");
        //isTextCorrect(characterName, "Guest-7475");
    }

    public void setSettingsButton() {
        AltFindObjectsParameters par= new AltFindObjectsParameters.Builder(AltUnityDriver.By.PATH, "//LobbyStateUIView(Clone)/TopBarUIView(Clone)/Canvas_TopBar/SafeArea/Panel_TopBar/Button_Settings/Image").build();
        AltWaitForObjectsParameters params = new AltWaitForObjectsParameters.Builder(par).withTimeout(10).build();
        this.settingsButton = getDriver().waitForObject(params);
    }

    public void setInventoryButton() {
        AltFindObjectsParameters par=new AltFindObjectsParameters.Builder(AltUnityDriver.By.PATH, "//LobbyStateUIView(Clone)/PlayMenuStateUIView(Clone)/SafeArea/Button_Weapons/Text").build();
        AltWaitForObjectsParameters params = new AltWaitForObjectsParameters.Builder(par).withTimeout(10).build();
        this.inventoryButton = getDriver().waitForObject(params);
        isTextCorrect(inventoryButton, "EKİPMAN");
    }

    public void setMissionsButton() {
        AltFindObjectsParameters par=new AltFindObjectsParameters.Builder(AltUnityDriver.By.PATH, "//LobbyStateUIView(Clone)/PlayMenuStateUIView(Clone)/SafeArea/Container_Misions/DailyHeader/ButtonMissions/Text").build();
        AltWaitForObjectsParameters params = new AltWaitForObjectsParameters.Builder(par).withTimeout(10).build();
        this.missionsButton = getDriver().waitForObject(params);
        isTextCorrect(missionsButton, "GÖREVLER");
    }

    public void setRunButton() {
        AltFindObjectsParameters par=new AltFindObjectsParameters.Builder(AltUnityDriver.By.PATH, "//LobbyStateUIView(Clone)/PlayMenuStateUIView(Clone)/SafeArea/Right Parent/Ready Button/Text").build();
        AltWaitForObjectsParameters params = new AltWaitForObjectsParameters.Builder(par).withTimeout(10).build();
        this.runButton = getDriver().waitForObject(params);
        isTextCorrect(runButton, "BAŞLA");
    }

    public void setGameModeName() {
        AltFindObjectsParameters par=new AltFindObjectsParameters.Builder(AltUnityDriver.By.PATH, "//LobbyStateUIView(Clone)/PlayMenuStateUIView(Clone)/SafeArea/Right Parent/Map Parent/Map Image Mask/Image").build();
        AltWaitForObjectsParameters params = new AltWaitForObjectsParameters.Builder(par).withTimeout(10).build();
        this.gameModeName = getDriver().waitForObject(params);
    }

    public void setAddGoldButton() {
        AltFindObjectsParameters par=new AltFindObjectsParameters.Builder(AltUnityDriver.By.PATH, "//LobbyStateUIView(Clone)/TopBarUIView(Clone)/Canvas_TopBar/SafeArea/Panel_TopBar/Container_Currency/Button_HardCurrency/Image").build();
        AltWaitForObjectsParameters params = new AltWaitForObjectsParameters.Builder(par).withTimeout(10).build();
        this.addGoldButton = getDriver().waitForObject(params);
    }

    public boolean isDisplayed( ){
        if(storeButton != null && inventoryButton != null && settingsButton != null && missionsButton != null && runButton != null && characterName != null && gameModeName != null && addGoldButton != null){
            return true;
        }
        return false;
    }

    public void setStatisticsButton() {
        AltFindObjectsParameters par=new AltFindObjectsParameters.Builder(AltUnityDriver.By.PATH, "//PlayerProfileUIView_Low(Clone)/PlayerProfile/Popup Canvas/Top Canvas/SafeArea/Settings Panel Buttons/Viewport/Content/Graphic Panel Button/Text").build();
        AltWaitForObjectsParameters params = new AltWaitForObjectsParameters.Builder(par).withTimeout(10).build();
        this.statisticsButton = getDriver().waitForObject(params);
        isTextCorrect(statisticsButton, "İSTATİSTİKLER");

    }

    public void setMatchCounterText() {
        AltFindObjectsParameters par=new AltFindObjectsParameters.Builder(AltUnityDriver.By.PATH, "//PlayerProfileUIView_Low(Clone)/PlayerProfile/Popup Canvas/Content Canvas/ScrollView_LeftRight/Viewport/Content/StatisticsUIView(Clone)/Panel 1/Matches/Matches/Count").build();
        AltWaitForObjectsParameters params = new AltWaitForObjectsParameters.Builder(par).withTimeout(10).build();
        this.matchCounterText = getDriver().waitForObject(params);
    }

    public void setStatisticsCloseButton() {
        AltFindObjectsParameters par=new AltFindObjectsParameters.Builder(AltUnityDriver.By.NAME, "Close Button").build();
        AltWaitForObjectsParameters params = new AltWaitForObjectsParameters.Builder(par).withTimeout(10).build();
        this.statisticsCloseButton = getDriver().waitForObject(params);
    }
    
/*
    public void loadScene(){
        getDriver().loadScene(new AltLoadSceneParameters.Builder("Main").loadMode(false).build());
        System.out.println(getDriver().getCurrentScene());
        getDriver().loadScene(new AltLoadSceneParameters.Builder("PlayMenu_Low").loadMode(false).build());
        System.out.println(getDriver().getCurrentScene());
    }
*/


}
