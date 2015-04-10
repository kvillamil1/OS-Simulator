/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simulatorjava;

import java.util.*;

import java.io.*;
import javax.swing.*;

import java.util.Locale;

import java.io.File;
import java.io.IOException;

/**
 *
 * @author stephenthoen
 */
public class SimulatorJava {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //Test for read in file
        //System.out.println(readFile.load());        

        //readFile.randomList(); 
        readFile.load();
        //User Input Options

        int select1;
        int select2;
        do {
            select1 = Integer.parseInt(JOptionPane.showInputDialog("Select An Option:"
                    + "\n1. Uniprocessor\n2. Multiprocessor\n3. Export to Excel Test\n4. Exit"));

            switch (select1) {
                case 1:
                    System.out.println("Uniprocessor");
                    System.out.println("-------------------");
                    do {
                        select2 = Integer.parseInt(JOptionPane.showInputDialog("Select An Option:"
                                + "\n1. FCFS\n2. RR1\n3. RR10"
                                + "\n4. SPN\n5. Return to Menu"));
                        switch (select2) {
                            case 1:
                                readFile.setPCB();
                                Queue<ProcessControlBlock> TimeQueue = ProcessSchedules.firstcomefirstserve(readFile.theTable);
                                String Name = "First Come First Serve";
                                ExcelExport.exceltest(Name, TimeQueue);

                                System.out.println("FCFS");
                                break;

                            case 2:
                                readFile.setPCB();
                                Queue<ProcessControlBlock> TimeQueueRR1 = ProcessSchedules.rr1(readFile.theTable);
                                String NameRR1 = "Round Robin (Q=1)";
                                ExcelExport.exceltest(NameRR1, TimeQueueRR1);

                                System.out.println("RR1");
                                break;

                            case 3:
                                readFile.setPCB();
                                Queue<ProcessControlBlock> TimeQueueRR10 = ProcessSchedules.rr10(readFile.theTable);
                                String NameRR10 = "Round Robin (Q=10)";
                               ExcelExport.exceltest(NameRR10, TimeQueueRR10);

                                System.out.println("RR10");
                                break;

                            case 4:
                                readFile.setPCB();
                                Queue<ProcessControlBlock> TimeQueueSPN = ProcessSchedules.shortestnext(readFile.theTable);
                                String NameSPN = "SPN";
                                ExcelExport.exceltest(NameSPN, TimeQueueSPN);

                                System.out.println("SPN");
                                break;

                            case 5:
                                break;
                        }
                    } while (select2 <= 4);

                    break;

                case 2:
                    System.out.println("Multiprocessor");
                    System.out.println("-------------------");

                    //read text file and create Process Objects containing attributes from file
                    readFile.setPCB();

                    //moves processes from process table into multiple queues
                    MultiProcessor.movepintoqueue(readFile.theTable);

                    break;
                case 3:
                    //ExcelExport.exceltest();
                    break;

            }
        } while (select1 <= 2);
    }
}
