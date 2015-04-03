/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simulatorjava;
import java.util.*;
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
        int clockTime = 0;
        
        
       readFile.setPCB();
       clockTime = ProcessSchedules.firstcomefirstserve(readFile.theTable, clockTime);
      
       System.out.println("First Come First Serve = " + clockTime);
        
        
    }
    
}
