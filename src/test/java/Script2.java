import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;
import java.util.List;

public class Script2 extends DriverManager {

    @Test
    public void openMainPage(){
        driver.navigate().to(Properties.getBaseUrl());
        wait.until(ExpectedConditions.visibilityOfElementLocated(By
                .xpath("//a[@class='all-product-link pull-xs-left pull-md-right h4']")));
        driver.findElement(By.xpath("//a[@class='all-product-link pull-xs-left pull-md-right h4']")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//section[@id = 'products']")));
        selectRandomProduct();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@class='nav-link']")));
        driver.findElement(By.xpath("//a[@class='nav-link']")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='product-quantities']//span")));
        String beforeOrder = driver.findElement(By.xpath("//div[@class='product-quantities']//span")).getText();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By
                .xpath("//button[@class='btn btn-primary add-to-cart']")));
        driver.findElement(By.xpath("//button[@class='btn btn-primary add-to-cart']")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@class='btn btn-primary']")));
        driver.findElement(By.xpath("//a[@class='btn btn-primary']")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By
                .xpath("//span[@class='product-image media-middle']//img")));
        String nameOfProduct = driver.findElement(By
                .xpath("//span[@class='product-image media-middle']//img")).getAttribute("alt");
        softAssert.assertTrue( CustomerData.getListOfProducts().contains(nameOfProduct));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='value']")));
        String summ = driver.findElement(By.xpath("//span[@class='value']")).getText();
        softAssert.assertNotEquals(summ,"0,00 ₴");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='label js-subtotal']")));
        String quantity = driver.findElement(By.xpath("//span[@class='label js-subtotal']")).getText();
        softAssert.assertEquals(quantity,"1 шт.");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@class = 'btn btn-primary']")));
        driver.findElement(By.xpath("//a[@class = 'btn btn-primary']")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name = 'firstname']")));
        driver.findElement(By.xpath("//input[@name = 'firstname']"))
                .sendKeys(CustomerData.generateRandomString(8));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name = 'lastname']")));
        driver.findElement(By.xpath("//input[@name = 'lastname']"))
                .sendKeys(CustomerData.generateRandomString(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name = 'email']")));
        driver.findElement(By.xpath("//input[@name = 'email']"))
                .sendKeys(CustomerData.generateRandomString(8)+"@gmail.com");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By
                .xpath("//button[@data-link-action = 'register-new-customer']")));
        driver.findElement(By.xpath("//button[@data-link-action = 'register-new-customer']")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name = 'address1']")));
        driver.findElement(By.xpath("//input[@name = 'address1']")).sendKeys(CustomerData
                .generateRandomString(9)+" street "+CustomerData.getHouseNumber()+ " house ");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name = 'postcode']")));
        driver.findElement(By.xpath("//input[@name = 'postcode']")).sendKeys(CustomerData.getPostCode());
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name = 'city']")));
        driver.findElement(By.xpath("//input[@name = 'city']")).sendKeys(CustomerData.getRandomCity());
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@name = 'confirm-addresses']")));
        driver.findElement(By.xpath("//button[@name = 'confirm-addresses']")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By
                .xpath("//button[@name = 'confirmDeliveryOption']")));
        driver.findElement(By.xpath("//button[@name = 'confirmDeliveryOption']")).click();
        driver.findElement(By.xpath("//span[@class='custom-radio pull-xs-left']//input[@id='payment-option-2']"))
                .click();
        driver.findElement(By
                .xpath("//div[@class='content']//form[@id='conditions-to-approve']//div[@class='pull-xs-left']"))
                .click();
        driver.findElement(By.xpath("//button[@class='btn btn-primary center-block']")).click();
        String str = driver.findElement(By.xpath("//h3[@class='h1 card-title']")).getText();
        softAssert.assertEquals(str,"\uE876ВАШ ЗАКАЗ ПОДТВЕРЖДЁН");
        String str2 = driver.findElement(By.xpath("//div[@class='col-xs-2']")).getText();
        softAssert.assertEquals(str2,"1");
        String str3 = driver.findElement(By.xpath("//div[@class='col-sm-4 col-xs-9 details']//span")).getText();
        softAssert.assertTrue(str3.startsWith(nameOfProduct));
        String str4 = driver.findElement(By.xpath("//div[@class='col-xs-5 text-xs-right bold']")).getText();
        softAssert.assertEquals(str4,summ);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name = 's']")));
        driver.findElement(By.xpath("//input[@name = 's']")).sendKeys(nameOfProduct);
        driver.findElement(By.xpath("//button[@type = 'submit']//i")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[@itemprop='name']")));
        driver.findElement(By.xpath("//h1[@itemprop='name']")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@class='nav-link']")));
        driver.findElement(By.xpath("//a[@class='nav-link']")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='product-quantities']//span")));
        String afterOrder = driver.findElement(By.xpath("//div[@class='product-quantities']//span")).getText();
        softAssert.assertNotEquals(beforeOrder,afterOrder);

    }


    public void selectRandomProduct(){
        List<WebElement> allProducts = driver.findElements(By.xpath("//a[@class='thumbnail product-thumbnail']"));
        int randomProduct = CustomerData.randomGenerator.nextInt(allProducts.size());
        allProducts.get(randomProduct).click();
    }


}
