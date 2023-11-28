import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Set;


public class Sign_In {
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
        sleep(2000);

        //accept cookie
        WebElement cookie = chromeDriver.findElement(By.id("onetrust-accept-btn-handler"));
        cookie.click();
        sleep(2000);

        //sign in
        chromeDriver.findElement(By.xpath("//button[normalize-space()='Sign in']")).click();
        sleep(5000);

        //mo frame dang nhap
        WebElement sign_in = chromeDriver.findElement(By.xpath("(//iframe[@scrolling='no'])[1]"));
        System.out.println("iframe total: " + chromeDriver.findElements(By.tagName("iframe")).size());
        chromeDriver.switchTo().frame(sign_in);

        //submit
        chromeDriver.findElement(By.id("sign_in_up_submit")).click();
        sleep(3000);
        WebElement alert = chromeDriver.findElement(By.xpath("//p[@role='alert']"));
        Assert.assertEquals(alert.getText(), "Enter a valid email address or profile url.");
        sleep(10000);
    }
    @Test
    public void TC_02() {
        //open SoundCloud
        chromeDriver.get("https://soundcloud.com/discover");
        sleep(2000);

        //accept cookie
        WebElement cookie = chromeDriver.findElement(By.id("onetrust-accept-btn-handler"));
        cookie.click();
        sleep(2000);

        //sign in
        chromeDriver.findElement(By.xpath("//button[normalize-space()='Sign in']")).click();
        sleep(5000);

        //mo frame dang nhap
        WebElement sign_in = chromeDriver.findElement(By.xpath("(//iframe[@scrolling='no'])[1]"));
        System.out.println("iframe total: " + chromeDriver.findElements(By.tagName("iframe")).size());
        chromeDriver.switchTo().frame(sign_in);

        //nhap email
        sleep(2000);
        WebElement input = chromeDriver.findElement(By.id("sign_in_up_email"));
        input.sendKeys("!$#62@gmail.com");

        //submit
        sleep(2000);
        chromeDriver.findElement(By.id("sign_in_up_submit")).click();
        sleep(2000);
        WebElement alert = chromeDriver.findElement(By.xpath("//p[@role='alert']"));
        Assert.assertEquals(alert.getText(), "Enter a valid email address or profile url.");
        sleep(10000);
    }
    @Test
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

        WebElement sign_in = chromeDriver.findElement(By.xpath("(//iframe[@scrolling='no'])[1]"));
        System.out.println("iframe total: " + chromeDriver.findElements(By.tagName("iframe")).size());
        chromeDriver.switchTo().frame(sign_in);

        //nhap email
        sleep(3000);
        WebElement input = chromeDriver.findElement(By.id("sign_in_up_email"));
        input.sendKeys("nhiinguyen2406@gmail.com");

        //submit
        sleep(3000);
        chromeDriver.findElement(By.id("sign_in_up_submit")).click();
        sleep(3000);

        chromeDriver.switchTo().defaultContent();
        sleep(2000);

        //mo frame dang nhap
        WebElement sign_in_fr = chromeDriver.findElement(By.xpath("(//iframe[@scrolling='no'])[1]"));
        chromeDriver.switchTo().frame(sign_in_fr);

        WebElement pass = chromeDriver.findElement(By.id("enter_password_field"));
        pass.sendKeys("nhi0931661670");
        sleep(2000);

        chromeDriver.findElement(By.id("enter_password_submit")).click();
        sleep(10000);

    }
    @Test
    public void TC_04() {
        //open SoundCloud
        chromeDriver.get("https://soundcloud.com/discover");
        sleep(3000);
        WebElement cookie = chromeDriver.findElement(By.id("onetrust-accept-btn-handler"));
        cookie.click();
        sleep(3000);

        //sign in
        chromeDriver.findElement(By.xpath("//button[normalize-space()='Sign in']")).click();
        sleep(3000);

        WebElement sign_in = chromeDriver.findElement(By.xpath("(//iframe[@scrolling='no'])[1]"));
        System.out.println("iframe total: " + chromeDriver.findElements(By.tagName("iframe")).size());
        chromeDriver.switchTo().frame(sign_in);

        sleep(3000);
        WebElement input = chromeDriver.findElement(By.id("sign_in_up_email"));
        input.sendKeys("lannhi@gmail.com");

        sleep(3000);
        chromeDriver.findElement(By.id("sign_in_up_submit")).click();
        sleep(3000);

        chromeDriver.switchTo().defaultContent();
        sleep(2000);

        //mo frame dang ky
        WebElement dang_ky = chromeDriver.findElement(By.xpath("(//iframe[@scrolling='no'])[1]"));
        chromeDriver.switchTo().frame(dang_ky);
        WebElement wl = chromeDriver.findElement(By.xpath("//h2[normalize-space()='Create your SoundCloud account']"));
        Assert.assertEquals(wl.getText(), "Create your SoundCloud account");
        sleep(10000);
    }
    @Test
    public void TC_05() {
        //open SoundCloud
        chromeDriver.get("https://soundcloud.com/discover");
        sleep(3000);

        //accept cookie
        WebElement cookie = chromeDriver.findElement(By.id("onetrust-accept-btn-handler"));
        cookie.click();
        sleep(3000);

        //sign in
        chromeDriver.findElement(By.xpath("//button[normalize-space()='Sign in']")).click();
        sleep(3000);

        WebElement sign_in = chromeDriver.findElement(By.xpath("(//iframe[@scrolling='no'])[1]"));
        System.out.println("iframe total: " + chromeDriver.findElements(By.tagName("iframe")).size());
        chromeDriver.switchTo().frame(sign_in);

        //click dang ky voi Google
        sleep(3000);
        chromeDriver.findElement(By.xpath("//button[normalize-space()='Continue with Google']")).click();
        sleep(3000);

        chromeDriver.switchTo().defaultContent();
        sleep(2000);

        //chuyen toi cua so moi
        Set <String> wins = chromeDriver.getWindowHandles();
        String firstWindow = (String)wins.toArray()[0];
        String newwindow = (String)wins.toArray()[1];
        chromeDriver.switchTo().window(newwindow);

        //kiem tra cua so moi
        WebElement email = chromeDriver.findElement(By.id("identifierId"));
        email.sendKeys("nhiinguyen2406@gmail.com");
        sleep(2000);

        chromeDriver.findElement(By.xpath("(//button[@class='VfPpkd-LgbsSe VfPpkd-LgbsSe-OWXEXe-k8QpJ VfPpkd-LgbsSe-OWXEXe-dgl2Hf nCP5yc AjY5Oe DuMIQc LQeN7 qIypjc TrZEUc lw1w4b'])[1]")).click();
        sleep(5000);

        //WebElement pass = chromeDriver.findElement(By.id("password"));
        //email.sendKeys("nhi0931661670");
        //sleep(3000);

        //chromeDriver.findElement(By.xpath("(//button[@class='VfPpkd-LgbsSe VfPpkd-LgbsSe-OWXEXe-k8QpJ VfPpkd-LgbsSe-OWXEXe-dgl2Hf nCP5yc AjY5Oe DuMIQc LQeN7 qIypjc TrZEUc lw1w4b'])[1]")).click();
        //sleep(5000);

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