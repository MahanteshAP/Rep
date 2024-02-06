package Testing1;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Base.BaseTest;
import SusceDemo.LoginPage;

public class DataDrivenTesting extends BaseTest
{
	@Test(dataProvider ="Dname")
	public void VerifyUserUsingDatadriven(String username,String password) throws InterruptedException
	{
		LoginPage loginpage=new LoginPage(webDriver);
		loginpage.setUsername(username);
		loginpage.setPassword(password);
		loginpage.clickonbutton();
		Thread.sleep(2000);
		
		String CuurentURL=webDriver.getCurrentUrl();
		String ExpctdURL="https://www.saucedemo.com/inventory.html";
		Assert.assertEquals(CuurentURL, ExpctdURL);
		webDriver.navigate().back();
		
		
	}
	
	@DataProvider(name="Dname")
	public Object[][] testdata()
	{
		return new Object[][] 
		{
			{"standard_user","secret_sauce"},
			{"locked_out_user","secret_sauce"},
		
		};
	}
}