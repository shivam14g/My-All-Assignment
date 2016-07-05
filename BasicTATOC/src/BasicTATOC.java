import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

class BasicTATOC
{
	static String myname = "Shivam";
    public static void main(String... s) throws InterruptedException 
    {
        WebDriver driver = new FirefoxDriver();
        driver.get("http://10.0.1.86/tatoc/basic/grid/gate");
        
        //Part 1
        driver.findElement(By.className("greenbox")).click();
        
        //Part 2
        while(true)
        {
            driver.switchTo().defaultContent();
            driver.switchTo().frame(driver.findElement(By.id("main")));
            String s1 = driver.findElement(By.id("answer")).getAttribute("class");
            driver.switchTo().frame(driver.findElement(By.id("child")));
            String s2 = driver.findElement(By.id("answer")).getAttribute("class");
            driver.switchTo().defaultContent();
            driver.switchTo().frame(driver.findElement(By.id("main")));
            if(s1.equals(s2))
            {
                driver.findElement(By.linkText("Proceed")).click();
                break;
            }
            else
            {
                driver.findElement(By.linkText("Repaint Box 2")).click();
            }
            
        }
        
        //Part 3
        WebElement element = driver.findElement(By.id("dragbox"));
        WebElement target = driver.findElement(By.id("dropbox"));
        new Actions(driver).dragAndDrop(element, target).perform();
        Thread.sleep(1000);
        driver.findElement(By.linkText("Proceed")).click();
        
        //Part 4
        String mainwindow=driver.getWindowHandle();
        driver.findElement(By.linkText("Launch Popup Window")).click();
        for(String winHandle :driver.getWindowHandles())
        {
            driver.switchTo().window(winHandle);
            if(driver.getTitle().equals("Popup - Basic Course - T.A.T.O.C"))
            {
                break;
            }
        }
        driver.findElement(By.id("name")).sendKeys(myname);
        driver.findElement(By.id("submit")).click();
        driver.switchTo().window(mainwindow);
        driver.findElement(By.linkText("Proceed")).click();
        
        //Part 5
        driver.findElement(By.linkText("Generate Token")).click();
        String s3 = driver.findElement(By.id("token")).getText();
        s3 = "Token="+s3.substring(7,s3.length());
        Cookie name = new Cookie("mycookie",s3);
		driver.manage().addCookie(name);
        driver.findElement(By.linkText("Proceed")).click();
        
        driver.close();
    }
    
}
