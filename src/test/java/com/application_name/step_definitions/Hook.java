package com.application_name.step_definitions;

import com.application_name.utilities.ConfigurationReader;
import com.application_name.utilities.Driver;
import io.cucumber.java.*;
import org.apache.log4j.Logger;
import org.openqa.selenium.*;

public class Hook {
    private static Logger logger = Logger.getLogger(Hook.class);

    @Before
    public void setup(){
        logger.info("##############################");
        logger.info("Test setup!");
        if(!ConfigurationReader.getProperty("browser").contains("remote")) {
        Driver.get().manage().window().maximize();
        }
    }

    @After
    public void teardown(Scenario scenario){
        //if test failed - do this
        if(scenario.isFailed()){
            logger.error("Test failed!");
            byte[] screenshot = ((TakesScreenshot)Driver.get()).getScreenshotAs(OutputType.BYTES);
            scenario.embed(screenshot, "image/png");
        }else{
            logger.info("Cleanup!");
            logger.info("Test completed!");
        }
        logger.info("##############################");
        //after every test, we gonna close browser
        Driver.close();
    }
}
