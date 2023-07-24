package utilities;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ExcelReader {
    Workbook workbook;
    Sheet sheet;
    public ExcelReader(String dosyaYolu,String SayfaIsmi)  {

        try {
            FileInputStream fis=new FileInputStream(dosyaYolu);
            workbook= WorkbookFactory.create(fis);
            sheet=workbook.getSheet(SayfaIsmi);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }

    public String getCellData(int satir,int sutun){
        Cell cell=sheet.getRow(satir).getCell(sutun);
        return cell.toString();
    }
    //Exceldeki satir sayisi returneder
    public int rowCount(){return sheet.getLastRowNum();

    }
}
