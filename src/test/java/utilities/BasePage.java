package utilities;

import org.testng.Assert;
import ro.altom.altunitytester.AltUnityDriver;
import ro.altom.altunitytester.AltUnityObject;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class BasePage {

    PropFileReader propReader = new PropFileReader();
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

    public String getDate(){
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        Date now = new Date();
        return dateFormat.format(now);
    }

    public String substractDate( ) throws ParseException {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd");

            Date start = simpleDateFormat.parse(getDate());
            Date finish = simpleDateFormat.parse(propReader.getProperty("timeRemaining"));

            long diffInMillis = Math.abs(finish.getTime() - start.getTime());
            long diffDays = TimeUnit.DAYS.convert(diffInMillis, TimeUnit.MILLISECONDS);
            return "Bitiş: " + diffDays + "g";
    }

}
