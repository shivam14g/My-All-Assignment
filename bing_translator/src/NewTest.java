

import java.io.FileInputStream;
import java.io.IOException;

import org.json.JSONException;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class NewTest {
  
@BeforeTest
public void before_test() throws IOException, InterruptedException, JSONException
{
	 testselenium obj= new testselenium();
	 obj.selenium_code();
	 
	 
	 (new test_api()).api_code();

}
	
	@Test
      public void f() throws IOException {
		
		FileInputStream f1=new FileInputStream("/home/shivamtiwari1/workspace/file.txt");
		FileInputStream f2=new FileInputStream("/home/shivamtiwari1/workspace/file2.txt");
		  
		  
		  while((f1.read()!=-1)&&(f2.read()!=-1))
		  {
			  Assert.assertTrue(f1.read()==f2.read());  
			  
		  }
		  
		  f1.close();
		  f2.close();
		
		
  }
}
