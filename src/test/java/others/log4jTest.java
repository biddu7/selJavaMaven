package others;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

public class log4jTest {
    
	public Logger log = LogManager.getLogger(log4jTest.class.getName());
	
	@Test
	public void test1() {
		System.out.println("Hello, this is log4j test 1");
		
		log.info("logging an info step");
		log.debug("logging a debug step");
		log.error("logging an error step");
		log.trace("logging a trace step");
		log.fatal("logging a fatal step");
		log.warn("logging a warning step");
	}

	
	@Test(dependsOnMethods={"test1"}, enabled=true, timeOut=400)
	public void test2() {
		System.out.println("Hello, this is log4j test 2");
		log.info("logging an info step");
		log.debug("logging a debug step");
		log.error("logging an error step");
		log.trace("logging a trace step");
		log.fatal("logging a fatal step");
		log.warn("logging a warning step");
	}
}
