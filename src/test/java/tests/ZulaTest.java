package tests;

import org.testng.Assert;
import org.testng.annotations.*;
import pages.*;
import utilities.BaseTest;



public class ZulaTest extends BaseTest {

    public static ZulaMainMenuPage mainMenuPage;
    public static ZulaStorePage storePage;
    public static ZulaAddGoldPage addGoldPage;
    public static ZulaMatchResultPage matchResultPage;



    @BeforeMethod
    public void ZulaTestObject(){
        mainMenuPage = new ZulaMainMenuPage(driver);
        storePage = new ZulaStorePage(driver);
        addGoldPage = new ZulaAddGoldPage(driver);
        matchResultPage = new ZulaMatchResultPage(driver);
        //MainMenuPage.loadScene();
    }




    @Test(priority = 0)
    public void testMainPageLoadedCorrectly() throws InterruptedException {

        mainMenuPage.setCharacterName();
        Thread.sleep(3000);
        mainMenuPage.setInventoryButton();
        mainMenuPage.setMissionsButton();
        mainMenuPage.setRunButton();
        mainMenuPage.setSettingsButton();
        mainMenuPage.setStoreButton();
        mainMenuPage.setGameModeName();
        mainMenuPage.setAddGoldButton();
        Assert.assertTrue(mainMenuPage.isDisplayed());
        Thread.sleep(3000);
        
    }


    @Test(priority = 1)
    public void controlOffers() throws InterruptedException {

        mainMenuPage.setStoreButton();
        mainMenuPage.storeButton.tap();
        Thread.sleep(3000);
        storePage.setBackButton();
        storePage.setOfferTitle();
        storePage.setOfferSubtitle();
        storePage.setRemainingTime();
        storePage.setOfferPrice();
        storePage.setBackButton();
        storePage.backButton.tap();
        Thread.sleep(3000);
    }


    @Test(priority = 2)
    public void controlGoldPrices() throws InterruptedException {

        mainMenuPage.setAddGoldButton();
        mainMenuPage.addGoldButton.tap();
        Thread.sleep(3000);
        addGoldPage.setGold80000();
        addGoldPage.setGold40000();
        addGoldPage.setGold15500();
        addGoldPage.setGold8000();
        addGoldPage.setGold4000();
        addGoldPage.setGold800();
        addGoldPage.setCloseButton();
        addGoldPage.closeButton.tap();
        Thread.sleep(3000);
    }

    @Test(priority = 3)
    public void gamePlayTest() throws InterruptedException {

        mainMenuPage.setCharacterName();
        mainMenuPage.characterName.tap();
        Thread.sleep(3000);
        mainMenuPage.setStatisticsButton();
        mainMenuPage.statisticsButton.tap();
        Thread.sleep(3000);
        mainMenuPage.setMatchCounterText();
        int matchCount = Integer.parseInt(mainMenuPage.matchCounterText.getText());
        mainMenuPage.setStatisticsCloseButton();
        mainMenuPage.statisticsCloseButton.tap();
        Thread.sleep(3000);
        mainMenuPage.setRunButton();
        mainMenuPage.runButton.tap();
        Thread.sleep(720000);

        matchResultPage.setGameModeText();
        matchResultPage.setZulaScore();
        matchResultPage.setGladyoScore();
        matchResultPage.setNextButton();
        matchResultPage.nextButton.tap();
        Thread.sleep(3000);
        matchResultPage.setReturnToLobbyButton();
        matchResultPage.returnToLobbyButton.tap();
        Thread.sleep(3000);
        mainMenuPage.setCharacterName();
        mainMenuPage.characterName.tap();
        Thread.sleep(3000);
        mainMenuPage.setStatisticsButton();
        mainMenuPage.statisticsButton.tap();
        Thread.sleep(3000);
        mainMenuPage.setMatchCounterText();
        int endMatchCount = Integer.parseInt(mainMenuPage.matchCounterText.getText());
        Assert.assertEquals(matchCount + 1, endMatchCount);
        mainMenuPage.setStatisticsCloseButton();
        mainMenuPage.statisticsCloseButton.tap();
        Thread.sleep(3000);
    }

}
