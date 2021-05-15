package surabhi.fakebar.testcase;

import com.surabhi.pageobjects.HomePage;
import com.surabhi.util.TestCaseBase;
import org.testng.annotations.Test;

public class TC_1_Fakebar extends TestCaseBase {

    @Test
    public void findFakeBar() throws InterruptedException {

        HomePage homePage = new HomePage();
        //Open the website
        homePage.openPage();
        //Find the fake
        homePage.findTheFake();


    }
}
