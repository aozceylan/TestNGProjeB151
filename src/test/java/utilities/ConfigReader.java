package utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
    /*
    .prperties uzantili dosyaya erisebilmemiz icin Properties class indan onje olusturmamiz gerekir
    bu olusturdugumuz obje ile akisa aladigimiz dosya yolunu  load(fis) metodu ile properties dosyasindaki key
    degerini return edebiliriz
     */
    static Properties properties;
    static {String dosyaYolu = "configuration.properties";
        try {
            FileInputStream fis = new FileInputStream(dosyaYolu);
            properties = new Properties();
            properties.load(fis);  //fis in okudugu bilgileri properties yukler

        } catch (IOException e) {
            throw new RuntimeException(e);

        }}
    public static String getProperty(String Key) {


       String value=properties.getProperty((Key)) ;//properties dosyasindaki key degerini veriri
        return value;
    }

}
