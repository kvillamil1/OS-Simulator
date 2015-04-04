/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simulatorjava;
import java.util.*;

/**
 *
 * @author Kat
 */
public class IOProcessing {
    
    public static int processIO(ProcessControlBlock p, int ioclockTime) {
        int ioTime = p.getiotime();
        while(ioTime!=0) {
            ioTime --;
            ioclockTime ++;
        }
        
        return ioclockTime;
    }
}