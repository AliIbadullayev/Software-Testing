import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class DriverSelector {


    public static List<WebDriver> getDrivers() throws IOException {
        List<WebDriver> drivers = new ArrayList<>();
        List<String> properties = Files.readAllLines(Paths.get("autoru.conf"));
        for (String property : properties) {
            if (property.startsWith("WEB_DRIVER")) {
                switch (property.toLowerCase().split("=")[1]) {
                    case "chrome" -> {
                        drivers.add(getChromeDriver());
                        return drivers;
                    }
                    case "firefox" -> {
                        drivers.add(getFirefoxDriver());
                        return drivers;
                    }
                    case "firechrome" -> {
                        drivers.add(getChromeDriver());
                        drivers.add(getFirefoxDriver());
                        return drivers;
                    }
                    default -> throw new RuntimeException("Web driver is not specified");
                }
            }
        }
        return null;
    }

    private static ChromeDriver getChromeDriver() {
        if (!System.getProperties().containsKey("webdriver.chrome.driver")) {
            throw new RuntimeException("Chrome driver not set properly");
        }
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        return new ChromeDriver(options);
    }

    private static FirefoxDriver getFirefoxDriver() {
        if (!System.getProperties().containsKey("webdriver.gecko.driver")) {
            throw new RuntimeException("Firefox driver not set properly");
        }
        FirefoxOptions firefoxOptions = new FirefoxOptions().setBinary("C:\\Program Files\\Mozilla Firefox\\firefox.exe");
        return new FirefoxDriver(firefoxOptions);
    }

    public static void prepareDrivers() {
        System.setProperty("webdriver.chrome.driver", "src/drivers/chromedriver.exe");
        System.setProperty("webdriver.gecko.driver", "src/drivers/geckodriver.exe");
    }

    public static void waitTime(long timeout) throws InterruptedException {
        Thread.sleep(timeout * 1000);
    }
}
