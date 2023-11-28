import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Search {
    ChromeDriver chromeDriver;

    @BeforeMethod
    public void Setup() {
        System.out.println("Before method");
        WebDriverManager.chromedriver().setup();
        chromeDriver = new ChromeDriver();
    }
    @Test
    public void TC_01() {

        //open SoundCloud
        chromeDriver.get("https://soundcloud.com");
        sleep(3000);
        WebElement cookie = chromeDriver.findElement(By.id("onetrust-accept-btn-handler"));
        cookie.click();
        sleep(5000);

        WebElement search = chromeDriver.findElement(By.xpath("(//input[@placeholder='Search for artists, bands, tracks, podcasts'])[2]"));
        sleep(3000);
        search.click();
        sleep(3000);
        String key = "rvhuwjdiw";
        search.sendKeys(key);
        sleep(3000);
        WebElement res = chromeDriver.findElement(By.linkText("No result for " + key));
        Assert.assertEquals(res.isDisplayed(), true);
        sleep(10000);
    }
    @Test
    public void TC_02() {
        //open SoundCloud
        chromeDriver.get("https://soundcloud.com");
        sleep(3000);
        WebElement cookie = chromeDriver.findElement(By.id("onetrust-accept-btn-handler"));
        cookie.click();
        sleep(3000);

        //search
        WebElement search = chromeDriver.findElement(By.xpath("(//input[@placeholder='Search for artists, bands, tracks, podcasts'])[2]"));
        sleep(3000);
        search.click();
        sleep(3000);
        String key = "see you again";
        search.sendKeys(key);
        sleep(3000);

        new Actions(chromeDriver).keyDown(Keys.ENTER).perform();
        sleep(5000);
        WebElement res = chromeDriver.findElement(By.xpath(" (//span[contains(text(),'Wiz Khalifa - See You Again ft. Charlie Puth Furio')])[1]"));
        Assert.assertEquals(res.isDisplayed(), true);
        sleep(10000);
    }
    @AfterMethod
    public void Cleanup(){
        System.out.println("After method");
        chromeDriver.quit();
    }

    private void sleep(int time) {
        try {
            Thread.sleep(time);
        }
        catch(Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
}