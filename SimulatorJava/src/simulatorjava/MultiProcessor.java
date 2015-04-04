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
import javax.swing.JOptionPane;

/**
 *
 * @author JPerry1120
 */
public class MultiProcessor {

    public static void movepintoqueue(Queue<ProcessControlBlock> myQueue) {
        int i = 1;

        //create 4 cpu process Queues
        Queue cpuqueue1 = new LinkedList();
        Queue cpuqueue2 = new LinkedList();
        Queue cpuqueue3 = new LinkedList();
        Queue cpuqueue4 = new LinkedList();

        //move processes from process table into cpu queues (Deidicated Processor Approach)
        while (!myQueue.isEmpty()) {
            ProcessControlBlock temp = myQueue.poll();
            if (i == 1) {
                cpuqueue1.add(temp);
                i++;
            } else if (i == 2) {
                cpuqueue2.add(temp);
                i++;
            } else if (i == 3) {
                cpuqueue3.add(temp);
                i++;
            } else if (i == 4) {
                cpuqueue4.add(temp);
                i++;
            } else if (i < 4) {
                i = 1;
            }
        }

        //prompt user which scheudling algorithm to do
        int choose;
        do {
            choose = Integer.parseInt(JOptionPane.showInputDialog("Select An Option:\n1. FCFS\n2. RR1\n3. RR10\n4. SPN\n5. Exit"));

            //call scheduling algorithms...runs processes in cpuqueue1 first then cpuqueue2...etc
            switch (choose) {
                case 1:
                    int fcfsclockTime = 0;
                    ProcessSchedules.firstcomefirstserve(cpuqueue1, fcfsclockTime);
                    ProcessSchedules.firstcomefirstserve(cpuqueue2, fcfsclockTime);
                    ProcessSchedules.firstcomefirstserve(cpuqueue3, fcfsclockTime);
                    ProcessSchedules.firstcomefirstserve(cpuqueue4, fcfsclockTime);
                case 2:
                    int rr1clockTime = 0;
                    ProcessSchedules.rr1(cpuqueue1, rr1clockTime);
                    ProcessSchedules.rr1(cpuqueue2, rr1clockTime);
                    ProcessSchedules.rr1(cpuqueue3, rr1clockTime);
                    ProcessSchedules.rr1(cpuqueue4, rr1clockTime);
                case 3:
                    int rr10clockTime = 0;
                    ProcessSchedules.rr10(cpuqueue1, rr10clockTime);
                    ProcessSchedules.rr10(cpuqueue2, rr10clockTime);
                    ProcessSchedules.rr10(cpuqueue3, rr10clockTime);
                    ProcessSchedules.rr10(cpuqueue4, rr10clockTime);
                case 4:
                    int SPNclockTime = 0;
                    ProcessSchedules.shortestnext(cpuqueue1, SPNclockTime);
                    ProcessSchedules.shortestnext(cpuqueue2, SPNclockTime);
                    ProcessSchedules.shortestnext(cpuqueue3, SPNclockTime);
                    ProcessSchedules.shortestnext(cpuqueue4, SPNclockTime);

//                case 5:
//                    return;
            }
        } while (choose < 5);
        return;
    }
}
