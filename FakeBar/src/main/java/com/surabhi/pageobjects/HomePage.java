package com.surabhi.pageobjects;

import com.surabhi.util.Page;
import com.surabhi.util.TestCaseBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.Alert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;


public class HomePage extends Page {
    @FindBy(id = "weigh")
    public WebElement weighButton;

    @FindBy(id = "reset")
    public WebElement resetButton;

    WebDriverWait wait = new WebDriverWait(TestCaseBase.driver, 5);

    public HomePage openPage() {
        //Navigate to the application
        TestCaseBase.driver.navigate().to("http://ec2-54-208-152-154.compute-1.amazonaws.com/");

        return this;
    }

    public HomePage findTheFake() throws InterruptedException {
        WebElement left;
        WebElement right;
        //Lets find the fake
        String[] numbers = {"0", "1", "2", "3", "4", "5", "6", "7", "8"};
        int j = 1;
        Boolean found = false;
        for (int i = 0; i < 8; i += 2) {

            TestCaseBase.driver.findElement(By.id("left_" + i)).sendKeys(numbers[i]);
            TestCaseBase.driver.findElement(By.id("right_" + i)).sendKeys(numbers[i + 1]);
            weighButton.click();
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='game-info']/ol/li[" + (j) + "]")));
            //  System.out.println("Text Is "+TestCaseBase.driver.findElement(By.xpath("//*[@class=\"game-info\"]/ol/li["+(j)+"]")).getText());

            if (TestCaseBase.driver.findElement(By.xpath("//*[@class=\"game-info\"]/ol/li[" + (j) + "]")).getText().contains("<")) {

                TestCaseBase.driver.findElement(By.id("coin_" + i)).click();
                Alert alert = TestCaseBase.driver.switchTo().alert();

                // Capturing alert message.
                String alertMessage = TestCaseBase.driver.switchTo().alert().getText();
                Assert.assertTrue(alertMessage.contains("Yay!"));
                found = true;
                //  System.out.println("Fake bar is "+i);
                break;
            } else if (TestCaseBase.driver.findElement(By.xpath("//*[@class=\"game-info\"]/ol/li[" + j + "]")).getText().contains(">")) {

                TestCaseBase.driver.findElement(By.id("coin_" + (i + 1))).click();
                Alert alert = TestCaseBase.driver.switchTo().alert();

                // Capturing alert message.
                String alertMessage = TestCaseBase.driver.switchTo().alert().getText();
                Assert.assertTrue(alertMessage.contains("Yay!"));
                found = true;
                //System.out.println("Fake bar is "+(i+1));
                break;
            }
            j++;
        }
        if (!found) {
            TestCaseBase.driver.findElement(By.id("coin_8")).click();
            Alert alert = TestCaseBase.driver.switchTo().alert();

            // Capturing alert message.
            String alertMessage = TestCaseBase.driver.switchTo().alert().getText();
            Assert.assertTrue(alertMessage.contains("Yay!"));
            // System.out.println("Fake bar is 8");
        }

        return this;
    }
}
