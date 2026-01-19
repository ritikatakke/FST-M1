

package Project;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

public class Activity2 {

    AndroidDriver driver;
    WebDriverWait wait;

    // -------------------- SETUP --------------------
    @BeforeClass
    public void setUp() throws MalformedURLException, URISyntaxException {

        File appFile = new File("src/test/resources/ts-todo-list-v1.apk");

        UiAutomator2Options options = new UiAutomator2Options();
        options.setPlatformName("android");
        options.setAutomationName("UiAutomator2");
        options.setApp(appFile.getAbsolutePath());
        options.noReset();

        URL serverURL = new URI("http://127.0.0.1:4723").toURL();
        driver = new AndroidDriver(serverURL, options);

        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

      @Test()
    public void editThirdTaskAndAddDeadline() {

        Dimension dims = driver.manage().window().getSize();
        Point longPressPoint =
                new Point((int) (dims.getWidth() * 0.5),
                          (int) (dims.getHeight() * 0.28));

        ActionBase.doLongPress(driver, longPressPoint);

        driver.findElement(
                AppiumBy.xpath("//android.widget.TextView[@text='Edit To-Do Task']")
        ).click();

        wait.until(ExpectedConditions.elementToBeClickable(
                AppiumBy.id("com.app.todolist:id/tv_todo_list_deadline")
        )).click();

        LocalDate nextSaturday = LocalDate.now()
                .with(java.time.temporal.TemporalAdjusters.next(DayOfWeek.SATURDAY));

        DateTimeFormatter formatter =
                DateTimeFormatter.ofPattern("d MMMM yyyy");
        String fullDate = nextSaturday.format(formatter);

        driver.findElement(AppiumBy.accessibilityId(fullDate)).click();
        driver.findElement(AppiumBy.id("com.app.todolist:id/bt_deadline_ok")).click();
        driver.findElement(AppiumBy.id("bt_new_task_ok")).click();

        String expectedDay =
                String.valueOf(nextSaturday.getDayOfMonth());

        WebElement deadline =
                driver.findElement(
                        AppiumBy.xpath(
                                "//android.widget.TextView[@resource-id='com.app.todolist:id/tv_exlv_task_deadline' " +
                                "and contains(@text,'" + expectedDay + "')]"
                        )
                );

        Assert.assertTrue(deadline.isDisplayed());
        Assert.assertTrue(deadline.getText().contains(expectedDay));
    }

   }
