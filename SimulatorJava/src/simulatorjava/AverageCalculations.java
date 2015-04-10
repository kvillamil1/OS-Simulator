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
public class AverageCalculations {
    
    public static Queue<ProcessControlBlock> averageTurnaround(Queue<ProcessControlBlock> TimeQueue) {
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
        
        averageTurn = (sumT/numT);
        averageResponse = (sumR/numR);
        averageWait = (sumW/numW);
        System.out.println("Average Turnaround: " + averageTurn);
        System.out.println("Average Response: " + averageResponse);
        System.out.println("Average Wait: " + averageWait);
        
        return newTimeQueue;
    }
    
}
