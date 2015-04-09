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

        //readFile.randomList(); !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
        readFile.load();
        //User Input Options
        
        int select;
        do {
            select = Integer.parseInt(JOptionPane.showInputDialog("Select An Option:\n1. Uniprocessor\n2. Multiprocessor\n3. Export to Excel Test\n4. Exit"));

            switch (select) {
                case 1:
                    
                    System.out.println("Uniprocessor");
                    System.out.println("-------------------");
                    readFile.setPCB();
                    Queue<ProcessControlBlock> TimeQueue = ProcessSchedules.firstcomefirstserve(readFile.theTable);
                    String Name = "First Come First Serve";
                    ExcelExport.exceltest(Name, TimeQueue);
                    readFile.setPCB();
                    ProcessSchedules.rr1(readFile.theTable);
                    readFile.setPCB();
                    ProcessSchedules.rr10(readFile.theTable);
                    readFile.setPCB();
                    //ProcessSchedules.shortestnext(readFile.theTable);
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
        } while (select <= 2);
    }
}
