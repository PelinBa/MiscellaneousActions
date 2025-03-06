package pb;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import org.openqa.selenium.DeviceRotation;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URISyntaxException;

public class MiscellaneousAppiumActions extends BaseTest {

    @Test
    public void Miscellaneous() throws MalformedURLException, URISyntaxException {

        //Go to wifi
        driver.findElement(AppiumBy.accessibilityId("Preference")).click();
        driver.findElement(AppiumBy.xpath("//android.widget.TextView[@content-desc='3. Preference dependencies']")).click();
        driver.findElement(AppiumBy.id("android:id/checkbox")).click();

        //Rotate the device
        DeviceRotation landScape = new DeviceRotation(0, 0, 90);
        driver.rotate(landScape);

        //Go to wifi settings and verify the alert
        driver.findElement(AppiumBy.xpath("(//android.widget.RelativeLayout)[2]")).click();
        String alertTitle= driver.findElement(AppiumBy.id("android:id/alertTitle")).getText();
        Assert.assertEquals(alertTitle, "WiFi settings");

        //Copy and Paste to clipboard
        driver.setClipboardText("Pelin Wifi");
        driver.findElement(AppiumBy.id("android:id/edit")).sendKeys(driver.getClipboardText());

        //Click ok button
        driver.findElements(AppiumBy.className("android.widget.Button")).get(1).click();

        //Press the back and home button
        driver.pressKey(new KeyEvent(AndroidKey.BACK));
        driver.pressKey(new KeyEvent(AndroidKey.HOME));
    }
}
