package Utilities;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Set;

public class BrowserUtilities {

    public static void switchToWindow(String targetTitle){

        String origin=DriverUtilities.getDriver().getWindowHandle();
        Set<String> listWindows=DriverUtilities.getDriver().getWindowHandles();

        for(String handle:listWindows){

            DriverUtilities.getDriver().switchTo().window(handle);

            if(DriverUtilities.getDriver().getTitle().equals(targetTitle)){

                return;
            }

        }

        DriverUtilities.getDriver().switchTo().window(origin);

    }

    public static void hover(WebElement element){

        Actions action=new Actions(DriverUtilities.getDriver());

        action.moveToElement(element);

    }

    public static void selectByText( WebElement element, String text){

        Select select=new Select(element);

        select.selectByVisibleText(text);

    }


    public static void selectByIndex( WebElement element, int index){

        Select select=new Select(element);

        select.selectByIndex(index);

    }


    public static WebElement waitForVisibility(WebElement element, int timeUnit){

        WebDriverWait wait=new WebDriverWait(DriverUtilities.getDriver(),timeUnit);

        return wait.until(ExpectedConditions.visibilityOf(element));


    }

    public static WebElement waitForClickable(WebElement element , int timeUnit){

        WebDriverWait wait=new WebDriverWait(DriverUtilities.getDriver(),timeUnit);

        return wait.until(ExpectedConditions.elementToBeClickable(element));
    }


    public static String getScreenShot(String name) throws IOException {

        String date=new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());

        TakesScreenshot screenshot=(TakesScreenshot)DriverUtilities.getDriver();

        File source=screenshot.getScreenshotAs(OutputType.FILE);

        String target=System.getProperty("user.dir")+"/ScreenShots"+name+date+".jpg";

        File destionation=new File(target);

        FileUtils.copyFile(source,destionation);

        return target;


    }
}
