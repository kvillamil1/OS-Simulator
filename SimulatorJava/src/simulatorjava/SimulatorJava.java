/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simulatorjava;

import java.util.*;
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
        int fcfsclockTime = 0;
        int rr1clockTime = 0;
        int rr10clockTime = 0;
        int spnclockTime = 0;
        
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

        
    }
    
}
