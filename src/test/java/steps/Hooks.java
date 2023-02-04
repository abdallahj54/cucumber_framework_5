package steps;

import cucumber.api.java.After;
import utils.Driver;

public class Hooks {


    @After
    public void teardown(){
        Driver.quitDriver();
    }
}
