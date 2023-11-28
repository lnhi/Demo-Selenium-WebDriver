import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class Upload {
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
        chromeDriver.get("https://soundcloud.com/discover");
        sleep(30000);
        WebElement cookie = chromeDriver.findElement(By.id("onetrust-accept-btn-handler"));
        cookie.click();
        sleep(30000);

        //sign in
        chromeDriver.findElement(By.xpath("//button[normalize-space()='Sign in']")).click();
        sleep(30000);

        //mo frame dang nhap
        WebElement sign_in = chromeDriver.findElement(By.xpath("(//iframe[@scrolling='no'])[1]"));
        System.out.println("iframe total: " + chromeDriver.findElements(By.tagName("iframe")).size());
        chromeDriver.switchTo().frame(sign_in);

        //nhap email
        sleep(30000);
        WebElement username = chromeDriver.findElement(By.id("sign_in_up_email"));
        username.sendKeys("nhiinguyen2406@gmail.com");

        //submit
        sleep(30000);
        chromeDriver.findElement(By.id("sign_in_up_submit")).click();
        sleep(30000);

        chromeDriver.switchTo().defaultContent();
        sleep(20000);

        //mo frame nhap password
        WebElement password = chromeDriver.findElement(By.xpath("(//iframe[@scrolling='no'])[1]"));
        chromeDriver.switchTo().frame(password);
        WebElement pass = chromeDriver.findElement(By.id("enter_password_field"));
        pass.sendKeys("nhi0931661670");
        sleep(30000);

        chromeDriver.findElement(By.id("enter_password_submit")).click();
        sleep(30000);

        chromeDriver.switchTo().defaultContent();
        sleep(20000);

        //upload
        WebElement upload_btn = chromeDriver.findElement(By.xpath("(//div[@class='header__soundInput left'])[1]"));
        upload_btn.sendKeys("\"D:\\Untitled.txt\"");
        sleep(30000);

        chromeDriver.switchTo().alert();
        WebElement message = chromeDriver.findElement(By.xpath("//a[normalize-space()='Read about our supported file types.']"));
        Assert.assertEquals(message.isDisplayed(), true);
    }

    public void TC_02() {

        //open SoundCloud
        chromeDriver.get("https://soundcloud.com/discover");
        sleep(3000);
        WebElement cookie = chromeDriver.findElement(By.id("onetrust-accept-btn-handler"));
        cookie.click();
        sleep(3000);

        //sign in
        chromeDriver.findElement(By.xpath("//button[normalize-space()='Sign in']")).click();
        sleep(3000);

        //mo frame dang nhap
        WebElement sign_in = chromeDriver.findElement(By.xpath("(//iframe[@scrolling='no'])[1]"));
        System.out.println("iframe total: " + chromeDriver.findElements(By.tagName("iframe")).size());
        chromeDriver.switchTo().frame(sign_in);

        //nhap email
        sleep(3000);
        WebElement username = chromeDriver.findElement(By.id("sign_in_up_email"));
        username.sendKeys("nhiinguyen2406@gmail.com");

        //submit
        sleep(3000);
        chromeDriver.findElement(By.id("sign_in_up_submit")).click();
        sleep(3000);

        chromeDriver.switchTo().defaultContent();
        sleep(2000);

        //mo frame nhap password
        chromeDriver.switchTo().frame(0);
        WebElement pass = chromeDriver.findElement(By.id("enter_password_field"));
        pass.sendKeys("nhi0931661670");
        sleep(3000);

        chromeDriver.switchTo().defaultContent();
        sleep(2000);

        //upload
        WebElement upload_btn = chromeDriver.findElement(By.xpath("(//div[@class='header__soundInput left'])[1]"));
        upload_btn.sendKeys("\"D:\\sample-3s.mp3\"");
        sleep(3000);
        WebElement message = chromeDriver.findElement(By.xpath("(//div[@class='activeUpload__form sc-media sc-border-light g-shadow-light sc-p-2x sc-mb-3x'])[1]"));
        Assert.assertEquals(message.isDisplayed(), true);
    }

    public void TC_03() {

        //open SoundCloud
        chromeDriver.get("https://soundcloud.com/discover");
        sleep(3000);
        WebElement cookie = chromeDriver.findElement(By.id("onetrust-accept-btn-handler"));
        cookie.click();
        sleep(3000);

        //sign in
        chromeDriver.findElement(By.xpath("//button[normalize-space()='Sign in']")).click();
        sleep(3000);

        //mo frame dang nhap
        WebElement sign_in = chromeDriver.findElement(By.xpath("(//iframe[@scrolling='no'])[1]"));
        System.out.println("iframe total: " + chromeDriver.findElements(By.tagName("iframe")).size());
        chromeDriver.switchTo().frame(sign_in);

        //nhap email
        sleep(3000);
        WebElement username = chromeDriver.findElement(By.id("sign_in_up_email"));
        username.sendKeys("nhiinguyen2406@gmail.com");

        //submit
        sleep(3000);
        chromeDriver.findElement(By.id("sign_in_up_submit")).click();
        sleep(3000);

        chromeDriver.switchTo().defaultContent();
        sleep(2000);

        //mo frame nhap password
        chromeDriver.switchTo().frame(0);
        WebElement pass = chromeDriver.findElement(By.id("enter_password_field"));
        pass.sendKeys("nhi0931661670");
        sleep(3000);

        chromeDriver.switchTo().defaultContent();
        sleep(2000);

        //upload
        WebElement upload_btn = chromeDriver.findElement(By.xpath("(//div[@class='header__soundInput left'])[1]"));
        upload_btn.sendKeys("\"D:\\sample-3s.mp3\"");
        sleep(5000);

        chromeDriver.findElement(By.xpath("(//button[normalize-space()='Save'])[1]")).click();
        sleep(5000);

        WebElement upload_cpl = chromeDriver.findElement(By.xpath("(//div[@class='sc-text-body sc-mr-0.5x'])[1]"));
        Assert.assertEquals(upload_cpl.isDisplayed(), true);
    }

    @AfterMethod
    public void Cleanup() {
        System.out.println("After method");
        //chromeDriver.quit();
    }

    private void sleep(int time) {
        try {
            Thread.sleep(time);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
}