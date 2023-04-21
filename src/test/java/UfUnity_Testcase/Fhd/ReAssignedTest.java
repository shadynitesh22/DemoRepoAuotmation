package UfUnity_Testcase.Fhd;

import BaseClass.TestBase;
import Intake_Setup.IntakeSetup;
import UfUnity_Pages.FHD.ReAssigned;
import Utility.AccountVerification;
import Utility.ReadJsonData;
import helper.Verification.WaitHelper;
import org.json.simple.parser.ParseException;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;


public class ReAssignedTest extends TestBase {
    ReadJsonData readJsonData;
    ReAssigned reAssigned;
    @BeforeClass
    public void Setup() throws IOException, ParseException {
        LaunchBrowser(new ReadJsonData().ReadJSONData("browser_name"));
        driver.get(new ReadJsonData().ReadJSONData("website"));
        new WaitHelper(driver).waitForElement(driver,new AccountVerification(driver).TextLoginPage,10);
        new AccountVerification(driver).Login_to_Application(new ReadJsonData().ReadJSONData("unityFhdUsername"),new ReadJsonData().ReadJSONData("unityFhdPassword"));
        reAssigned=new ReAssigned(driver);
    }

    @Test(priority = 1)
    public void Go_To_As_ReAssigned_Tab_Test() throws IOException, ParseException, InterruptedException {
        reAssigned.Go_To_As_Re_Assigned_Tab();
        reAssigned.Enter_Date_Birth();
        reAssigned.Insured_Policy_Number();
    }

    @Test(priority = 2)
    public void Middle_Initial_Test() throws IOException, ParseException, InterruptedException {
        reAssigned.Insured_First_Name();
        reAssigned.Insured_Middle_Name();
        reAssigned.Last_Initial();
        reAssigned.Insured_Maiden_Name();
        reAssigned.Social_security_Number();
        reAssigned.Enter_Date_Death();
        reAssigned.Handling_Drop_Down();
        reAssigned.Insured_Street_address();
        reAssigned.Insured_City();
        reAssigned.State_of_Residence_Drop_Down();
        reAssigned.Enter_Zip_Code();
        reAssigned.Medicaid_Drop_Down();
        reAssigned.Enter_Home_Phone_Number();

    }



}
