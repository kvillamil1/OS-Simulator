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
        int throughput = 0;

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
                throughput++;
                i++;
            } else if (i == 2) {
                cpuqueue2.add(temp);
                throughput++;
                i++;
            } else if (i == 3) {
                cpuqueue3.add(temp);
                throughput++;
                i++;
            } else if (i == 4) {
                cpuqueue4.add(temp);
                throughput++;
                i++;
            } else if (i == 5) {
                cpuqueue1.add(temp);
                throughput++;
                i = 2;
            }
        }

        //prompt user which scheudling algorithm to do
        int choose;
        do {
            choose = Integer.parseInt(JOptionPane.showInputDialog("Select An Option:\n1. FCFS\n2. RR1\n3. RR10\n4. SPN\n5. Return to Menu"));

            //call scheduling algorithms...runs processes in cpuqueue1 first then cpuqueue2...etc
            switch (choose) {
                case 1:
                    System.out.println("First Come First Serve");
                    int fcfsclockTime = 0;
                    fcfsclockTime = ProcessSchedules.firstcomefirstserve(cpuqueue1, fcfsclockTime);
                    System.out.println(fcfsclockTime);
                    fcfsclockTime = ProcessSchedules.firstcomefirstserve(cpuqueue2, fcfsclockTime);
                    System.out.println(fcfsclockTime);
                    fcfsclockTime = ProcessSchedules.firstcomefirstserve(cpuqueue3, fcfsclockTime);
                    System.out.println(fcfsclockTime);
                    fcfsclockTime = ProcessSchedules.firstcomefirstserve(cpuqueue4, fcfsclockTime);
                    System.out.println(fcfsclockTime);
                    System.out.println("Throughput Time: " + throughput);
                    break;
                case 2:
                    System.out.println("Round Robin (1)");
                    int rr1clockTime = 0;
                    ProcessSchedules.rr1(cpuqueue1, rr1clockTime);
                    ProcessSchedules.rr1(cpuqueue2, rr1clockTime);
                    ProcessSchedules.rr1(cpuqueue3, rr1clockTime);
                    ProcessSchedules.rr1(cpuqueue4, rr1clockTime);
                    System.out.println("Throughput Time: " + throughput);
                    break;
                case 3:
                    System.out.println("Round Robin (10)");
                    int rr10clockTime = 0;
                    ProcessSchedules.rr10(cpuqueue1, rr10clockTime);
                    ProcessSchedules.rr10(cpuqueue2, rr10clockTime);
                    ProcessSchedules.rr10(cpuqueue3, rr10clockTime);
                    ProcessSchedules.rr10(cpuqueue4, rr10clockTime);
                    System.out.println("Throughput Time: " + throughput);
                    break;

                case 4:
                    System.out.println("Shortest Process Next");
                    int SPNclockTime = 0;
                    ProcessSchedules.shortestnext(cpuqueue1, SPNclockTime);
                    ProcessSchedules.shortestnext(cpuqueue2, SPNclockTime);
                    ProcessSchedules.shortestnext(cpuqueue3, SPNclockTime);
                    ProcessSchedules.shortestnext(cpuqueue4, SPNclockTime);
                    System.out.println("Throughput Time: " + throughput);
                    break;
                case 5:
                    return;
            }
        } while (choose <= 4);
    }
}

