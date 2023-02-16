package others;

import org.testng.annotations.Test;


public class excelDataTest {
    
	@Test(dataProvider="getDataExcel", dataProviderClass=common1.testdata.class)
	public void uberMethod1(String url, String user, String psw) {
		System.out.println("URL ["+ url +"] | User ID [" + user + "] | Password [" + psw+"]");
	}
		
}
