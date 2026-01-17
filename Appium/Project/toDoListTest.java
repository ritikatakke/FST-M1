

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

public class toDoListTest {

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

    // -------------------- TEST 1 --------------------
    
    @Test(priority = 1)
    public void addTask() {

        createTask("Activity1", "High");
        createTask("Activity2", "Medium");
        createTask("Activity3", "Low");

        Assert.assertTrue(isTaskDisplayed("Activity1"));
        Assert.assertTrue(isTaskDisplayed("Activity2"));
        Assert.assertTrue(isTaskDisplayed("Activity3"));
    }

    // -------------------- TEST 2 --------------------
    @Test(priority = 2 )
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

    // -------------------- TEST 3 --------------------
    @Test(priority = 3) 
    		//dependsOnMethods = "editThirdTaskAndAddDeadline")
    

    public void addTaskCompleteAndCheckProgress() {

        Dimension dims = driver.manage().window().getSize();

        Point longPressPoint =
                new Point((int) (dims.getWidth() * 0.5),
                          (int) (dims.getHeight() * 0.28));

        Point sliderStart =
                new Point((int) (dims.getWidth() * 0.283),
                          (int) (dims.getHeight() * 0.54));

        Point sliderEnd =
                new Point((int) (dims.getWidth() * 0.60),
                          (int) (dims.getHeight() * 0.54));

        
        ActionBase.doLongPress(driver, longPressPoint);

        driver.findElement(
                AppiumBy.xpath("//android.widget.TextView[@text='Edit To-Do Task']")
        ).click();

        ActionBase.doSwipe(driver, sliderStart, sliderEnd, 2000);
        driver.findElement(AppiumBy.id("com.app.todolist:id/bt_new_task_ok")).click();
       
        List<WebElement> checkBoxes =
                driver.findElements(
                        AppiumBy.id("com.app.todolist:id/cb_task_done")
                );

        checkBoxes.get(0).click();
        checkBoxes.get(1).click();
        driver.findElement(AppiumBy.accessibilityId("More options")).click();
        wait.until(ExpectedConditions.elementToBeClickable(
        	    AppiumBy.xpath("//android.widget.ListView/android.widget.LinearLayout[3]")
        	)).click();

        List<WebElement> taskList = driver.findElements(AppiumBy.xpath("//android.widget.TextView[@resource-id=\"com.app.todolist:id/tv_exlv_task_name\"]"));
        Assert.assertEquals(taskList.size(), 2);       


        
    }

    // -------------------- REUSABLE METHODS --------------------

    public void createTask(String taskName, String priority) {

        driver.findElement(AppiumBy.id("fab_new_task")).click();

        WebElement taskNameField =
                wait.until(ExpectedConditions.elementToBeClickable(
                        AppiumBy.id("et_new_task_name")
                ));
        taskNameField.sendKeys(taskName);

        driver.findElement(AppiumBy.id("tv_new_task_priority")).click();

        driver.findElement(
                AppiumBy.xpath(
                        "//android.widget.TextView[@resource-id='android:id/title' and @text='" + priority + "']"
                )
        ).click();

        driver.findElement(AppiumBy.id("bt_new_task_ok")).click();
    }

    public boolean isTaskDisplayed(String taskName) {
        return driver.findElement(
                AppiumBy.xpath(
                        "//android.widget.TextView[@resource-id='com.app.todolist:id/tv_exlv_task_name' " +
                        "and @text='" + taskName + "']"
                )
        ).isDisplayed();
    }
}
