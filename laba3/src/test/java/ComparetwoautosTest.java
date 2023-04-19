// Generated by Selenium IDE
import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.core.IsNot.not;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Alert;
import org.openqa.selenium.Keys;
import java.util.*;
import java.net.MalformedURLException;
import java.net.URL;
public class ComparetwoautosTest {
  private WebDriver driver;
  private Map<String, Object> vars;
  JavascriptExecutor js;
  @Before
  public void setUp() {
    driver = new ChromeDriver();
    js = (JavascriptExecutor) driver;
    vars = new HashMap<String, Object>();
  }
  @After
  public void tearDown() {
    driver.quit();
  }
  public String waitForWindow(int timeout) {
    try {
      Thread.sleep(timeout);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    Set<String> whNow = driver.getWindowHandles();
    Set<String> whThen = (Set<String>) vars.get("window_handles");
    if (whNow.size() > whThen.size()) {
      whNow.removeAll(whThen);
    }
    return whNow.iterator().next();
  }
  @Test
  public void comparetwoautos() {
    driver.get("https://auto.ru/");
    driver.manage().window().setSize(new Dimension(1256, 791));
    js.executeScript("window.scrollTo(0,1127)");
    vars.put("window_handles", driver.getWindowHandles());
    driver.findElement(By.xpath("//div[@id=\'LayoutIndex\']/div/div/div[4]/div/section/div/div/a/div/div/span/div/div/div[3]")).click();
    vars.put("win2335", waitForWindow(2000));
    vars.put("root", driver.getWindowHandle());
    driver.switchTo().window(vars.get("win2335").toString());
    driver.findElement(By.cssSelector(".IconSvg_more > use")).click();
    driver.findElement(By.cssSelector("div:nth-child(1) > .CardActions__action-MUIOE:nth-child(1)")).click();
    driver.switchTo().window(vars.get("root").toString());
    vars.put("window_handles", driver.getWindowHandles());
    driver.findElement(By.xpath("//div[@id=\'LayoutIndex\']/div/div/div[4]/div/section/div/div[2]/a/div/div/span/div/div/div[3]")).click();
    vars.put("win5444", waitForWindow(2000));
    driver.switchTo().window(vars.get("win5444").toString());
    driver.findElement(By.cssSelector(".IconSvg_more > use")).click();
    driver.findElement(By.cssSelector("div:nth-child(1) > .CardActions__action-MUIOE:nth-child(1)")).click();
    driver.findElement(By.xpath("//div[@id=\'app\']/div/div[2]/header/div/div/div[4]/a/div")).click();
    driver.findElement(By.xpath("//div[@id=\'LayoutIndex\']/div/div/label/span/span")).click();
    {
      WebElement element = driver.findElement(By.xpath("//div[@id=\'LayoutIndex\']/div/div[2]/table/thead/tr/div/th[2]/div/a/img"));
      Actions builder = new Actions(driver);
      builder.moveToElement(element).perform();
    }
    driver.findElement(By.xpath("//div[@id=\'LayoutIndex\']/div/div[2]/table/thead/tr/div/th/div/div")).click();
    driver.findElement(By.cssSelector(".ComparisonHeader__item:nth-child(1) .CloseButton_color_black")).click();
  }
}
