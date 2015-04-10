/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simulatorjava;
import java.util.*;

/**
 * Deals with processes that have IO times
 * @author Kat
 */
public class IOProcessing {
    
    //IO times for processes are decremented (executed) and ioclockTime is incremented
    //returns the ioclockTime
    public static int processIO(ProcessControlBlock p, int ioclockTime) {
        int ioTime = p.getiotime();
        while(ioTime!=0) {
            ioTime --;
            ioclockTime ++;
        }
        
        return ioclockTime;
    }
}