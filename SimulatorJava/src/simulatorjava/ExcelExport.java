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
import java.util.logging.Level;
import java.util.logging.Logger;
import jxl.read.biff.BiffException;
import jxl.Sheet;

/**
 * Exports all data to Excel file
 * @author JPerry1120
 */
public class ExcelExport {
    
    public static void exceltest(String nameofmethod, Queue<ProcessControlBlock> TimeQueue) {
        try {
            File exlFile = new File("Simulation.xls");
            WritableWorkbook writableWorkbook = Workbook.createWorkbook(exlFile);

            WritableSheet writableSheet = writableWorkbook.createSheet(
                    "Simulation Test Results", 0);
            
            WritableSheet writableSheet1 = writableWorkbook.createSheet(
                    "Simulation Average", 1);
            

            //Create Cells with contents of different data types.
            //Also specify the Cell coordinates in the constructor
            Label label = new Label(0, 0, "Simulation");
            DateTime date = new DateTime(10, 0, new Date());

            //DONT FORGET TO SEND METHOD NAME!!!!!!!!!!!
            //Label header names
            Label schedulemethod = new Label(0, 2, nameofmethod);
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
            writableSheet.addCell(schedulemethod);
            writableSheet.addCell(pid);
            writableSheet.addCell(arrival);
            writableSheet.addCell(burst);
            writableSheet.addCell(io);
            writableSheet.addCell(context);
            writableSheet.addCell(turnaround);
            writableSheet.addCell(throughput);
            writableSheet.addCell(response);
            writableSheet.addCell(wait);

            
           int j=5;
            while(!TimeQueue.isEmpty())
            {
                int i=0;
                ProcessControlBlock stuff = TimeQueue.poll();
                
                Number processid = new Number(i,j,stuff.getpid());
                writableSheet.addCell(processid);
                i++;
                
                Number arrivaltime = new Number(i,j,stuff.getparrival());
                writableSheet.addCell(arrivaltime);
                i++;
                
                Number bursttime = new Number(i,j,stuff.getbursttime());
                writableSheet.addCell(bursttime);
                i++;
                
                Number iotime = new Number(i,j,stuff.getiotime());
                writableSheet.addCell(iotime);
                i++;
                
                Number contextswitch = new Number(i,j,stuff.getcontextswitchtime());
                writableSheet.addCell(contextswitch);
                i++;
                
                Number turn = new Number(i,j,stuff.getturnaroundtime());
                writableSheet.addCell(turn);
                i++;
                
                Number through = new Number(i,j,stuff.getthroughputtime());
                writableSheet.addCell(through);
                i++;
                
                Number respond = new Number(i,j,stuff.getresponsetime());
                writableSheet.addCell(respond);
                i++;
                
                Number waiter = new Number(i,j,stuff.getwaittime());
                writableSheet.addCell(waiter);
                i++;
                
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
