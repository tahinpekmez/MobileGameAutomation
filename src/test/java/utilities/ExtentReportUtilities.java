package utilities;

import org.apache.commons.codec.binary.Base64;
import org.testng.Assert;
import ro.altom.altunitytester.AltUnityDriver;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class ExtentReportUtilities {


    public static File testScreenshot(AltUnityDriver driver)  {
        String path=System.getProperty("user.dir")+"/Reports/"+System.currentTimeMillis()+".png";
        driver.getPNGScreeshot(path);
        Assert.assertTrue(new File(path).isFile());
        File outputFile = new File(path);
        return outputFile;
    }


    public static String encodeFileToBase64Binary(File file){
        String encodedFile = null;
        try {
            FileInputStream fileInputStreamReader = new FileInputStream(file);
            byte[] bytes = new byte[(int)file.length()];
            fileInputStreamReader.read(bytes);
            encodedFile = new String(Base64.encodeBase64(bytes), "UTF-8");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return encodedFile;
    }

    public static void deleteScreenshotFiles() {
        File folder = new File("./Reports");
        for (File file : folder.listFiles()) {
            if (file.getName().endsWith(".png")) {
                file.delete();
            }
        }
    }

}
