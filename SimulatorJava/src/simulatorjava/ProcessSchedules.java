/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simulatorjava;

import java.util.Collection;
import java.util.PriorityQueue;
import java.util.*;

/**
 *
 * @author JPerry1120
 */
public class ProcessSchedules {

//    int temp;
//    int proceessArrivalTime;
//    int waitingTime;
//    double avgWaitingTime;
//    double avgTurnAroundTime;
    public static int firstcomefirstserve(Queue<ProcessControlBlock> myQueue, int clockTime) {
        while (!myQueue.isEmpty()) {
            //myQueue.get(Object.get(pbursttime));
            ProcessControlBlock temp = myQueue.poll();
            int burst = temp.getbursttime();
            while (burst != 0) {
                burst--;
                clockTime++;
            }
            myQueue.remove(0);
        }
        return clockTime;
    }

    public static int rr1(Queue<ProcessControlBlock> myQueue, int rrclockTime) {
        while (!myQueue.isEmpty()) {
            ProcessControlBlock temp = myQueue.poll();
            int burst = temp.getbursttime();
            for (int i = 0; i < 1; i++) {
                burst--;
                rrclockTime++;
            }

            if (burst == 0) {
                myQueue.remove(0);
            } else {
                temp.setburst(burst);
                myQueue.add(temp);
            }
        }
        return rrclockTime;
    }

    public static void rr10(Queue<ProcessControlBlock> myQueue, int clockTime) {

    }

    public static void shortestnext(Queue<ProcessControlBlock> myQueue, int clockTime) {

    }

}
