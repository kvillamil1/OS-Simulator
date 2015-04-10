/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simulatorjava;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Calculates all throughput times associated with processes
 * @author JPerry1120
 */
public class TimeCalculations {
    
//this function counts how many processes ran in a given time (in our case we decided all of them will run)
    public static Queue calculatethroughput(Queue<ProcessControlBlock> myQueue)
    {
       Queue<ProcessControlBlock> newQueue = new LinkedList();
       Queue<ProcessControlBlock> newQueue1 = new LinkedList();
       
      int counter=0;
      
      //while the queue is not empty, count each process object that myQueue contains
      while(!myQueue.isEmpty())
      {
        ProcessControlBlock temp1 = myQueue.poll();
        newQueue.add(temp1);
        counter++;
      }
      
      while(!newQueue.isEmpty())
      {
          ProcessControlBlock temp2 = newQueue.poll();
          temp2.setthroughputtime(counter);
          newQueue1.add(temp2);
      }
      
      return newQueue1;
    }
}
