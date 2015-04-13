/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simulatorjava;
import java.util.*;
import java.math.*;
import java.text.DecimalFormat;
import javax.swing.*;

/**
 * Calculate average turnaroud, response and wait for each algorithm and cpu
 * @author Kat
 */
public class AverageCalculations {
    
    public static Queue<ProcessControlBlock> average(Queue<ProcessControlBlock> TimeQueue) {
        
        double sumT = 0;
        double sumR = 0;
        double sumW = 0;
        double numT = 0;
        double numR = 0;
        double numW = 0;
        double averageTurn;
        double averageResponse;
        double averageWait;
        Queue<ProcessControlBlock> newTimeQueue = new LinkedList();
        
        //takes out each process in queue and gets their turnaround, response and wait times
        //and sums them; also sums the total number of processes in CPU
        while(!TimeQueue.isEmpty()) {
           ProcessControlBlock temp = TimeQueue.poll();
           sumT += temp.getturnaroundtime();
           sumR += temp.getresponsetime();
           sumW += temp.getwaittime();
           numT++;
           numR++;
           numW++;
           newTimeQueue.add(temp);
        }
        
        //Formatting for decimal places in final average ouput
        DecimalFormat round = new DecimalFormat("#.##");
        
        //Calculate averages
        averageTurn = (sumT/numT);
        averageResponse = (sumR/numR);
        averageWait = (sumW/numW);
        
        //Print averages in a message dialog window
        JOptionPane.showMessageDialog(null,"Average Turnaround: " 
                + round.format(averageTurn) + "\nAverage Response: " 
                + round.format(averageResponse) + "\nAverage Wait: " 
                + round.format(averageWait), "CPU", JOptionPane.INFORMATION_MESSAGE);
        
        //Calculate averages (TESTING PURPOSES)
//        averageTurn = (sumT/numT);
//        averageResponse = (sumR/numR);
//        averageWait = (sumW/numW);
//        System.out.println("Average Turnaround: " + averageTurn);
//        System.out.println("Average Response: " + averageResponse);
//        System.out.println("Average Wait: " + averageWait + "\n");
          
        
        return newTimeQueue;
    }
    
}
