package TestActivity;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.*;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Test
public class Activity10 {

    String path = "C:\\Users\\RitikaTakke\\Documents\\DataProviderFile.xlsx";
    ChromeDriver driver;

    @BeforeClass
    public void initiate() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://training-support.net/webelements/simple-form");
        Reporter.log("Opening Chrome Browser", true);
    }

    @AfterClass
    public void close() {
        driver.quit();
        Reporter.log("Closing Browser", true);
    }

    @Test(dataProvider = "dataProvidermethod")
    public void registerTest(List<String> dataList) {

        driver.findElement(By.id("full-name")).sendKeys(dataList.get(0));
        driver.findElement(By.id("email")).sendKeys(dataList.get(1));
        driver.findElement(By.name("event-date")).sendKeys(dataList.get(2));
        driver.findElement(By.id("additional-details")).sendKeys(dataList.get(3));
        driver.findElement(By.xpath("//button[text()='Submit']")).click();

        String message = driver.findElement(By.id("action-confirmation")).getText();
        Assert.assertEquals(message, "Your event has been scheduled!");

        driver.navigate().refresh();
    }

    // Read Excel file
    public static List<List<String>> readExcel(String filePath) throws IOException {

        List<List<String>> data = new ArrayList<>();

        FileInputStream file = new FileInputStream(filePath);
        XSSFWorkbook workbook = new XSSFWorkbook(file);
        XSSFSheet sheet = workbook.getSheetAt(0);

        for (Row row : sheet) {
            List<String> rowData = new ArrayList<>();
            for (Cell cell : row) {
                rowData.add(cell.toString());
            }
            data.add(rowData);
        }

        workbook.close();
        file.close();
        return data;
    }

    @DataProvider
    public Object[][] dataProvidermethod() throws IOException {

        List<List<String>> excelData = readExcel(path);
        Object[][] data = new Object[excelData.size() - 1][1];

        for (int i = 1; i < excelData.size(); i++) {
            data[i - 1][0] = excelData.get(i);
        }
        return data;
    }
}
