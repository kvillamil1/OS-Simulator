/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simulatorjava;

import java.util.*;
import java.io.*;
import javax.swing.*;

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

        //User Input Options
        int select;
        do {
            select = Integer.parseInt(JOptionPane.showInputDialog("Select An Option:\n1. Uniprocessor\n2. Multiprocessor\n3. Exit"));

            switch (select) {
                case 1:
                    int fcfsclockTime = 0;
                    int rr1clockTime = 0;
                    int rr10clockTime = 0;
                    int spnclockTime = 0;

                    System.out.println("Uniprocessor");
                    System.out.println("-------------------");
                    readFile.setPCB();
                    fcfsclockTime = ProcessSchedules.firstcomefirstserve(readFile.theTable, fcfsclockTime);
                    readFile.setPCB();
                    rr1clockTime = ProcessSchedules.rr1(readFile.theTable, rr1clockTime);
                    readFile.setPCB();
                    rr10clockTime = ProcessSchedules.rr10(readFile.theTable, rr10clockTime);
                    readFile.setPCB();
                    spnclockTime = ProcessSchedules.shortestnext(readFile.theTable, spnclockTime);

                    System.out.println("First Come First Serve = " + fcfsclockTime);
                    System.out.println("RR1 = " + rr1clockTime);
                    System.out.println("RR10 = " + rr10clockTime);
                    System.out.println("Shortest Process Next = " + spnclockTime);
                    System.out.printf("\n");
                    break;

                case 2:
                    System.out.println("Multiprocessor");
                    System.out.println("-------------------");
                    break;
                case 3:
                    break;
            }
        } while (select <= 2);
    }
}
