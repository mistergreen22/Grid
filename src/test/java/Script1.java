import org.testng.annotations.Test;

public class Script1 extends DriverManager {


    @Test
    public void openMainPage(){
        driver.navigate().to(Properties.getBaseUrl());

    }
}
