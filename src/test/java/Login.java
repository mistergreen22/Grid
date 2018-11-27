import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Login extends DriverManager{
    @DataProvider
    public Object[][] getLoginData(){
        return new String[][]{
                {"webinar.test@gmail.com","Xcg7299bnSmMuRLp9ITw"}
        };
    }

    @Test(dataProvider = "getLoginData")
    public void userLogin(String login, String password){
        CustomReporter.logAction("User Login");
        driver.navigate().to(Properties.getBaseAdminUrl());
        driver.findElement(By.id("email")).sendKeys(login);
        driver.findElement(By.id("passwd")).sendKeys(password);
        driver.findElement(By.name("submitLogin")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("main")));

    }
}
