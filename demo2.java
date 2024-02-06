package Testing;

import org.testng.Assert;
import org.testng.annotations.Test;

import Base.BaseTest;
import SusceDemo.LoginPage;
import SusceDemo.LoginPageFacory;
import utility.ReadXlsData;

public class DataDrivenUsingXL extends BaseTest
{
	@Test(dataProviderClass=ReadXlsData.class,dataProvider ="logintestdata")
	public void VerifyUserUsingDatadriven(String username,String password) throws InterruptedException
	{
		//LoginPageFacory
		LoginPageFacory loginpage=new LoginPageFacory(webDriver);
		loginpage.setUsername(username);
		loginpage.setPassword(password);
		loginpage.clickonbutton();
		webDriver.navigate().refresh();
		Thread.sleep(2000);
		
		String CuurentURL=webDriver.getCurrentUrl();
		String ExpctdURL="https://www.saucedemo.com/inventory.html";
		Assert.assertEquals(CuurentURL, ExpctdURL);
		webDriver.navigate().back();
		
		
	}
}
