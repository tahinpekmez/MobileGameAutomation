package pages;


import ro.altom.altunitytester.AltUnityDriver;
import ro.altom.altunitytester.AltUnityObject;
import ro.altom.altunitytester.Commands.FindObject.AltFindObjectsParameters;
import ro.altom.altunitytester.Commands.FindObject.AltWaitForObjectsParameters;
import utilities.BasePage;

public class ZulaMatchResultPage extends BasePage {
    
    public AltUnityObject resultText;
    public AltUnityObject gameModeText;
    public AltUnityObject gladyoScore;
    public AltUnityObject zulaScore;
    public AltUnityObject nextButton;
    public AltUnityObject returnToLobbyButton;

    public ZulaMatchResultPage(AltUnityDriver driver) {
        super(driver);
    }

    public void setResultText() {
        AltFindObjectsParameters par=new AltFindObjectsParameters.Builder(AltUnityDriver.By.NAME, "VictoryDefeatText").build();
        AltWaitForObjectsParameters params = new AltWaitForObjectsParameters.Builder(par).withTimeout(10).build();
        this.resultText = getDriver().waitForObject(params);
        isTextCorrect(resultText, "BERABERE");
    }

    public void setGameModeText() {
        AltFindObjectsParameters par=new AltFindObjectsParameters.Builder(AltUnityDriver.By.PATH, "//EventCanvas(Clone)/ScoreBoardHUDTeamView(Clone)/SafeArea/GameMode/Mode").build();
        AltWaitForObjectsParameters params = new AltWaitForObjectsParameters.Builder(par).withTimeout(10).build();
        this.gameModeText = getDriver().waitForObject(params);
        isTextCorrect(gameModeText, "TAKIM ÖLÜM MAÇI");
    }

    public void setZulaScore() {
        AltFindObjectsParameters par=new AltFindObjectsParameters.Builder(AltUnityDriver.By.PATH, "//EventCanvas(Clone)/ScoreBoardHUDTeamView(Clone)/SafeArea/Top/ZulaTeam/Score").build();
        AltWaitForObjectsParameters params = new AltWaitForObjectsParameters.Builder(par).withTimeout(10).build();
        this.zulaScore = getDriver().waitForObject(params);
        isTextCorrect(zulaScore, "0");
    }

    public void setGladyoScore() {
        AltFindObjectsParameters par=new AltFindObjectsParameters.Builder(AltUnityDriver.By.PATH, "//EventCanvas(Clone)/ScoreBoardHUDTeamView(Clone)/SafeArea/Top/GladyoTeam/Score").build();
        AltWaitForObjectsParameters params = new AltWaitForObjectsParameters.Builder(par).withTimeout(10).build();
        this.gladyoScore = getDriver().waitForObject(params);
        isTextCorrect(gladyoScore, "0");
    }

    public void setNextButton() {
        AltFindObjectsParameters par=new AltFindObjectsParameters.Builder(AltUnityDriver.By.PATH, "//EventCanvas(Clone)/ScoreBoardHUDTeamView(Clone)/SafeArea/EndGameHolder/BottomEndGame/MatchResult/Text").build();
        AltWaitForObjectsParameters params = new AltWaitForObjectsParameters.Builder(par).withTimeout(10).build();
        this.nextButton = getDriver().waitForObject(params);
        isTextCorrect(nextButton, "SONRAKİ");
    }
    
    public void setReturnToLobbyButton() {
        AltFindObjectsParameters par=new AltFindObjectsParameters.Builder(AltUnityDriver.By.PATH, "//StaticCanvas(Clone)/RewardsPopUpMatchResult(Clone)/Content/ToLobby/Text").build();
        AltWaitForObjectsParameters params = new AltWaitForObjectsParameters.Builder(par).withTimeout(10).build();
        this.returnToLobbyButton = getDriver().waitForObject(params);
        isTextCorrect(returnToLobbyButton, "LOBİYE DÖN");
    }
    
    

}
