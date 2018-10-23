import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;

public class BaseTest {

    protected static AndroidDriver driver;


    @Before
    public void setUp() throws MalformedURLException, InstantiationException {
        Properties properties = getProperties();

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("deviceName", properties.getProperty("deviceName"));
        capabilities.setCapability("platformName", properties.getProperty("deviceName"));
        capabilities.setCapability("appPackage", properties.getProperty("appPackage"));
        capabilities.setCapability("appActivity", properties.getProperty("appActivity"));

        capabilities.setCapability(MobileCapabilityType.APP, "C:\\adb\\Test_app.apk");

        URL appiumURL = new URL("http://127.0.0.1:4723/wd/hub");

        driver = new AndroidDriver(appiumURL, capabilities);
    }

    private Properties getProperties() throws InstantiationException {
        Properties properties = new Properties();
        InputStream inputStream = null;
        try {

            inputStream = BaseTest.class
                    .getResourceAsStream("/config.properties");
            if (inputStream == null) {
                throw new RuntimeException("properties is null");
            }
            properties.load(inputStream);

            if (properties == null) {
                throw new InstantiationException("properties are missing");
            }

        } catch (IOException e) {

        } finally {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {

                }

            }
        }
        return properties;
    }

    @After
    public void closeBrowser() {
        if (driver != null) {
            driver.quit();
        }
    }
}
