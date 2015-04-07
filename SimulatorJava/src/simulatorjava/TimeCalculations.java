/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simulatorjava;

import java.util.Queue;

/**
 *
 * @author JPerry1120
 */
public class TimeCalculations {
   
    public void calculateturnaround(ProcessControlBlock temp)
    {
        
    }
    public void calculatewait(ProcessControlBlock temp)
    {
        
    }
    public void calculateresponse(ProcessControlBlock temp)
    {
        
    }
    public void calculatethroughput(Queue<ProcessControlBlock> myQueue)
    {
      int counter=0;
      while(!myQueue.isEmpty())
      {
        ProcessControlBlock temp1 = myQueue.poll();
        counter++;
      }
      
    }
}
