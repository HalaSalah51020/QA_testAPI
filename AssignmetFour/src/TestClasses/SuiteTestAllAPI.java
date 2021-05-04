package TestClasses;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;


@RunWith(Suite.class)

@Suite.SuiteClasses({
	
	TestDeleteRestAPI.class,
	TestGetRestAPI.class,
	TestPostRestAPI.class,
	TestPutRestAPI.class
})

public class SuiteTestAllAPI {

}
