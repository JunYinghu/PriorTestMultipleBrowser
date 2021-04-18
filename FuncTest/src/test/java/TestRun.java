import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import cucumber.api.testng.CucumberFeatureWrapper;
import cucumber.api.testng.TestNGCucumberRunner;
import org.junit.runner.RunWith;
import org.testng.annotations.*;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src\\test\\resources\\demoTest.feature",
        plugin = {
                "pretty",
                "html:target/cucumber-reports/cucumber-pretty",
                "json:target/cucumber-reports/CucumberTestReport.json",
                "rerun:target/cucumber-reports/rerun.txt"
        }
)
public class TestRun extends WebPageDriver {
    private TestNGCucumberRunner testNGCucumberRunner;

    @BeforeClass(alwaysRun = true)
    @Parameters({"Browser"})
    public void setUpClass(String browserType) {
        testNGCucumberRunner = new TestNGCucumberRunner(this.getClass());
        setDriver(browserType);
    }

    @Test(description = "Runs Cucumber Feature", dataProvider = "features")
    public void feature(CucumberFeatureWrapper cucumberFeature) {
        testNGCucumberRunner.runCucumber(cucumberFeature.getCucumberFeature());
    }

    @DataProvider
    public Object[][] features() {
        return testNGCucumberRunner.provideFeatures();
    }

    @AfterClass(alwaysRun = true)
    public void tearDownClass() {
        testNGCucumberRunner.finish();
        driver.quit();
    }
}
