package stepDefinitions.base;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.sql.Timestamp;

import static drivers.DriverFactory.cleanUpDriver;
import static drivers.DriverFactory.getDriver;

public class hooks {

    @Before
    public void setUp() throws Exception {
        getDriver();

    }

    @AfterStep
    public void captureExceptionImage(Scenario scenario) throws Exception {
        if (scenario.isFailed()) {
            Timestamp timestamp = new Timestamp(System.currentTimeMillis());
            String timeMilliseconds = Long.toString(timestamp.getTime());

            byte[] screenshot = ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", timeMilliseconds);

        }

    }

    @After
    public void tearDown() {
        cleanUpDriver();

    }

}
