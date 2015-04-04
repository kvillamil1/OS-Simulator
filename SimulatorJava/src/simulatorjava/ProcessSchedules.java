/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simulatorjava;

import java.util.Collection;
import java.util.PriorityQueue;
import java.util.*;
import java.util.Arrays;

/**
 *
 * @author JPerry1120
 */
public class ProcessSchedules {

//    int proceessArrivalTime;
//    int waitingTime;
//    double avgWaitingTime;
//    double avgTurnAroundTime;
    
    //First Come First Serve Function that returns clock time
    public static int firstcomefirstserve(Queue<ProcessControlBlock> myQueue, int fcfsclockTime) {
        //while the queue still contains process objects, run first come first serve schedule algorithm
        while (!myQueue.isEmpty()) {
             //grab first process object off of the queue
            ProcessControlBlock temp = myQueue.poll();
            
            //get the io time for each process
            int io = temp.getiotime();
            int ioclockTime = 0;
            
            //if io time > 0, send to IOProcessing
            if(io>0)
                ioclockTime = IOProcessing.processIO(temp,ioclockTime);
            
            //set the variable burst to the burst time that is within the process object
            int burst = temp.getbursttime();

            //while the process burst time is not 0, decrement the burst time by one and increase clock time by one
            while (burst != 0) {
                burst--;
                fcfsclockTime++;
            }
            //When the process is done running (burst time = 0), remove it from the queue
            myQueue.remove(0);
        }
        return fcfsclockTime;
    }

     //Round Robin Function with time quantum of 1 that returns clock time
    public static int rr1(Queue<ProcessControlBlock> myQueue, int rrclockTime) {
        //while the queue still contains process objects, run round robin schedule algorithm
        while (!myQueue.isEmpty()) {
             //grab first process object off of the queue
            ProcessControlBlock temp = myQueue.poll();
            
             //get the io time for each process
            int io = temp.getiotime();
            int ioclockTime = 0;
            
            //if io time > 0, send to IOProcessing
            if(io>0)
                ioclockTime = IOProcessing.processIO(temp,ioclockTime);
            
            //set the variable burst to the burst time that is within the process object
            int burst = temp.getbursttime();
            for (int i = 0; i < 1; i++) {
                burst--;
                rrclockTime++;
            }
            //Checks if process is done running (burst time = 0) and if it is, remove the process object from the queue
            //else if the burst time is not 0, reset the burst time in the process object to the new burst time and add it to the end of the queue
            if (burst == 0) {
                myQueue.remove(0);
            } else {
                temp.setburst(burst);
                myQueue.add(temp);
            }
        }
        return rrclockTime;
    }

    //Round Robin Function with time quantum of 10 that returns clock time
    public static int rr10(Queue<ProcessControlBlock> myQueue, int rr10clockTime) {
        //while the queue still contains process objects, run round robin schedule algorithm
        while(!myQueue.isEmpty())
        {
            //grab first process object off of the queue
            ProcessControlBlock temp = myQueue.poll();
            
             //get the io time for each process
            int io = temp.getiotime();
            int ioclockTime = 0;
            
            //if io time > 0, send to IOProcessing
            if(io>0)
                ioclockTime = IOProcessing.processIO(temp,ioclockTime);
            
            //set the variable burst to the burst time that is within the process object
            int burst = temp.getbursttime();
            //run the process for 10 "clock time seconds" for round robin 10
            for(int i = 0; i < 10; i++)
            {
                //if process burst time is 0, get out of the for loop
                if(burst==0)
                {
                    myQueue.remove(0);
                    break;
                }
                //if the process burst time is not 0, decrease the burst time and increase clock time
                else
                {
                    burst--;
                    rr10clockTime++;
                }      
            }
            //if the burst time is not 0, set the new burst time for the process and add the process to the end of the queue
            if (burst != 0) {
             temp.setburst(burst);
             myQueue.add(temp);
            }
        }
        return rr10clockTime;
    }

    public static int shortestnext(Queue<ProcessControlBlock> myQueue, int spnclockTime) {
        ArrayList <ProcessControlBlock> spn = new ArrayList <ProcessControlBlock>();
        int counter = myQueue.size();

        // empties queue into array 
        while (!myQueue.isEmpty()) {

            for (int i = 0; i < counter; i++) {
                ProcessControlBlock temp = myQueue.remove();
                spn.add(temp);
            }
        }

        //sort through array and find shortest burst time
        while (!spn.isEmpty()) {
            
            ProcessControlBlock tempshortest = spn.get(0);
            
            for (int i = 1; i < spn.size(); i++) {

                if (spn.get(i).getbursttime() < tempshortest.getbursttime()) {
                    tempshortest = spn.get(i);
                    
                }
            }
            
             //get the io time for each process
            int io = tempshortest.getiotime();
            int ioclockTime = 0;
            
            //if io time > 0, send to IOProcessing
            if(io>0)
                ioclockTime = IOProcessing.processIO(tempshortest,ioclockTime);
            
            //set shortest burst time to burst
            int burst = tempshortest.getbursttime();
            
            //execute shortest process (decrement shortest burst time, increment clock & 
            //remove process when finished)
            while (burst != 0) {
                burst--;
                spnclockTime++;
            }
            spn.remove(tempshortest);
        }


        return spnclockTime;
    }

}
