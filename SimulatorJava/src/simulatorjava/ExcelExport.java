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

    public static void exceltest(Queue<ProcessControlBlock> TimeQueue) {
        try {
            File exlFile = new File("OSSimulationTestResults.xls");
            WritableWorkbook writableWorkbook = Workbook.createWorkbook(exlFile);

            WritableSheet writableSheet = writableWorkbook.createSheet(
                    "Operating Systems Simulation Test Results", 0);

            //Create Cells with contents of different data types.
            //Also specify the Cell coordinates in the constructor
            Label label = new Label(0, 0, "Simulation");
            DateTime date = new DateTime(10, 0, new Date());
             // Boolean bool = new Boolean(2, 0, true);
            // Number num = new Number(3, 0, 9.99);

            //DONT FORGET TO SEND METHOD NAME!!!!!!!!!!!
            //Label header names
            //Label schedulemethod = new Label(0, 2, method);
            Label pid = new Label(0, 3, "Process ID");
            Label arrival = new Label(1,3, "Arrival Time");
            Label burst = new Label(2, 3, "Burst Time");
            Label io = new Label(3, 3, "I/O Time");
            Label context = new Label(4, 3, "Context Switch Time");
            Label turnaround = new Label(5, 3, "Turnaround Time");
            Label throughput = new Label(6, 3, "Throughput Time");
            Label response = new Label(7, 3, "Response Time");
            Label wait = new Label(8, 3, "Wait Time");

            //Add the created Cells to the sheet
            writableSheet.addCell(label);
            writableSheet.addCell(date);
            //writableSheet.addCell(bool);  <---for reference
            //  writableSheet.addCell(num); <---for reference
           // writableSheet.addCell(schedulemethod);
            writableSheet.addCell(pid);
            writableSheet.addCell(arrival);
            writableSheet.addCell(burst);
            writableSheet.addCell(io);
            writableSheet.addCell(context);
            writableSheet.addCell(turnaround);
            writableSheet.addCell(throughput);
            writableSheet.addCell(response);
            writableSheet.addCell(wait);

//            //Write out test results
//            Number throughputresult = new Number(6,4,counter);
//            writableSheet.addCell(throughputresult);
            
            //Test
            int j = 10;
            for (int i = 0; i < 10; i++) {
                Label labelTest = new Label(0, j, "Jordanne");
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
