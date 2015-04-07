/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simulatorjava;

import java.io.*;
import jxl.*;
import java.util.*;
import jxl.Workbook;
import jxl.write.DateFormat;
import jxl.write.Number;
import jxl.write.Boolean;
import jxl.write.biff.RowsExceededException;
import jxl.write.*;
import java.text.SimpleDateFormat;

/**
 *
 * @author JPerry1120
 */
public class ExcelExport {
    
    public static void exceltest(){
         try {
            File exlFile = new File("OSSimulationTestResults.xls");
            WritableWorkbook writableWorkbook = Workbook.createWorkbook(exlFile);
 
            WritableSheet writableSheet = writableWorkbook.createSheet(
                    "Test Sheet", 0);
 
            //Create Cells with contents of different data types.
            //Also specify the Cell coordinates in the constructor
            Label label = new Label(0, 0, "Operating Systems Simulation");
            DateTime date = new DateTime(1, 0, new Date());
             // Boolean bool = new Boolean(2, 0, true);
           // Number num = new Number(3, 0, 9.99);
           
              //Add the created Cells to the sheet
            writableSheet.addCell(label);
            writableSheet.addCell(date);
          //  writableSheet.addCell(bool);
          //  writableSheet.addCell(num);
            
            
            //Test
           int j=3;
            for(int i=0; i<10; i++)
            {
                Label labelTest = new Label(0, j, "Jordanne" );
                writableSheet.addCell(labelTest);
                j++;
            }
          
 
          
 
            //Write and close the workbook
            writableWorkbook.write();
            writableWorkbook.close();
 
        } catch (IOException e) {
            e.printStackTrace();
        } catch (RowsExceededException e) {
            e.printStackTrace();
        } catch (WriteException e) {
            e.printStackTrace();
        }

    }
}

