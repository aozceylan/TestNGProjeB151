package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.time.Duration;

/*
POM(page object model):ataest senaryolarinin daha az kod ile yazilmasinave bakiminin daha kolay yapilmasina olanak
saglayan yazilim test yöntemidir .TestNG de ve CUCUMBER da POM kalibini kullaniriz
 */
public class Driver {
    private Driver(){};//  //Obje olusumun önune gecmek icin default construcktor private yaparsak bunun önune geceriz
    //buna singleton patter denir
    static WebDriver driver;
    public static WebDriver getDriver(){
        /*
        driver her calistirdigimizda yeni bir pencere acilmasinin önune gecmek icin if blogu icinde
        Eger driver a deger atanmissa deger ata ,eger atanmissa Driver ayni sayfada return et
         */
        if (driver == null) {  switch (ConfigReader.getProperty("browser")){
            case "chrome":
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                break;
            case "edge":
                WebDriverManager.edgedriver().setup();
                driver = new EdgeDriver();
                break;
            case "safari":
                WebDriverManager.safaridriver().setup();
                driver = new SafariDriver();
                break;
            default:
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
        }
       driver=new ChromeDriver();
       driver.manage().window().maximize();
       driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15)) ;
        }
       return driver;


    }
 public  static void closeDriver(){ if(driver!=null){
        driver.close();
        driver=null;//bunu belirtmem gerekiyor tekrar driver in calisabilmesi icin ,yani drive bosaltiyoruz
 }

 }
    public  static void quitDriver(){ if(driver!=null){
        driver.quit();
        driver=null;
    }
    }

}
