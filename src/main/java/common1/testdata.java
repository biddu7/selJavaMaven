package common1;
import java.io.IOException;
import org.testng.ITestNGMethod;
import org.testng.annotations.DataProvider;

public class testdata {

	@DataProvider(name="getDataExcel")
	public Object[][] method2(ITestNGMethod method) throws IOException {
		String xlPath = System.getProperty("user.dir") + "\\ExternalData\\SeleniumSuite.xlsx";
		String className = method.getTestClass().getRealClass().getSimpleName();
		
		myExcel xl = new myExcel();
		return xl.loadXlData2Array(xlPath, className);
	}
	
	
	@DataProvider(name="getData")
	public static Object[][] method1() {
		Object[][] data = { 
							{"amazon.com","joydeep","12346789"}, 
							{"flipkart.com","paromita","475714314"},
							{"snapdeal.com","tiana","8765999"}
						  };
		return data;
	}
	
}
