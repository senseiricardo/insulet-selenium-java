package pom;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import utils.DriverFactory;
import utils.RetryAnalyzer;
import utils.UserData;

public class TestSuitesExamplesTests extends BaseTests{

    @Parameters({"username", "password"})
    @Test
    public void testSuiteParameter(String user, String pwd){
        loginPage.login(user, pwd);
        Assert.assertEquals(invPage.getProductLabel(), "Products");
    }

    @DataProvider(name = "users", parallel = true)
    public Object[][] users(){
        return new Object[][] {
                {"standard_user", "secret_sauce"},
                {"locked_out_user", "secret_sauce"},
                {"problem_user", "secret_sauce"}
        };
    }

    @Test(dataProvider = "users")
    public void testSuiteDataProvider(String username, String password){
        System.out.println("User: "+username);
        System.out.println("Password: "+password);
    }

    @Test(retryAnalyzer = RetryAnalyzer.class)
    public void testSuiteRetry(){
        Assert.assertTrue(Math.random() < 0.5);
    }


}
