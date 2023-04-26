package UfUnity_Testcase.Fhd;

import BaseClass.TestBase;
import Intake_Setup.IntakeSetup;
import UfUnity_Pages.FHD.ChildProtectionPlan;
import Utility.AccountVerification;
import Utility.ReadJsonData;
import helper.Verification.WaitHelper;
import org.json.simple.parser.ParseException;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;

public class ChildProtectionPlanTest extends TestBase {
    ChildProtectionPlan childProtectionPlan;
    ReadJsonData readJsonData;
    WaitHelper waitHelper;
    IntakeSetup intakeInitialization;
    int increment  = 1;

    @BeforeClass
    public void Setup() throws IOException, ParseException {
        LaunchBrowser(new ReadJsonData().ReadJSONData("browser_name"));
        driver.get(new ReadJsonData().ReadJSONData("website"));
        new WaitHelper(driver,10).waitForElement(new AccountVerification(driver).TextLoginPage);
        new AccountVerification(driver).Login_to_Application(new ReadJsonData().ReadJSONData("unityFhdUsername"),new ReadJsonData().ReadJSONData("unityFhdPassword"));
        childProtectionPlan=new ChildProtectionPlan(driver);
        readJsonData=new ReadJsonData();

    }
    @Test(priority = 1)
    public void Go_to_Child_Protection_Tab_Test() throws IOException, ParseException, InterruptedException {
        childProtectionPlan.Go_to_Child_Protection_Tab();
        childProtectionPlan.Begin_Participant(readJsonData.Read_JSON_Data("CHILD_PROTECTION_PLAN"));
    }

//    @Test(priority = 2)
//    public void Print_Confirmation(){
//        childProtectionPlan.Request_Confirmation();
//    }
//    @Test(priority = 3)
//    public void LogoutFromApplication(){
//        new AccountVerification(driver).Logout_from_Application();
//    }

   // @AfterClass
    public void AfterClass(){
        driver.quit();
    }

}
