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
 * Setup for Multiprocessor algorithms
 * @author JPerry1120
 */
public class MultiProcessor {

    public static void movepintoqueue(Queue<ProcessControlBlock> myQueue) {
        int i = 1;
        int throughput = 0;

        //create 4 cpu process Queues
        Queue<ProcessControlBlock> cpuqueue1 = new LinkedList();
        Queue<ProcessControlBlock> cpuqueue2 = new LinkedList();
        Queue<ProcessControlBlock> cpuqueue3 = new LinkedList();
        Queue<ProcessControlBlock> cpuqueue4 = new LinkedList();

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
            } else if (i == 5) {
                cpuqueue1.add(temp);
                i = 2;
            }
        }

        //prompt user which scheudling algorithm to do
        int choose;
        do {
            choose = Integer.parseInt(JOptionPane.showInputDialog("Select An Option:\n1. FCFS\n2. RR1\n3. RR10\n4. SPN\n5. Return to Menu"));

            //call scheduling algorithms...runs processes in cpuqueue1 first then cpuqueue2...etc
            switch (choose) {
                
                //FCFS
                case 1:
                    //run the first come first serve schedule algorithm on all (4) CPU queus 
                    Queue<ProcessControlBlock> TimeQueue = ProcessSchedules.firstcomefirstserve(cpuqueue1);
                    Queue<ProcessControlBlock> TimeQueue1 = ProcessSchedules.firstcomefirstserve(cpuqueue2);
                    Queue<ProcessControlBlock> TimeQueue2 = ProcessSchedules.firstcomefirstserve(cpuqueue3);
                    Queue<ProcessControlBlock> TimeQueue3 = ProcessSchedules.firstcomefirstserve(cpuqueue4);

                    //get all of the process objects from each CPU queue on one time queue to be sent to Excel
                    while (!TimeQueue1.isEmpty()) 
                    {
                        TimeQueue.add(TimeQueue1.poll());
                    }
                    while (!TimeQueue2.isEmpty()) 
                    {
                        TimeQueue.add(TimeQueue2.poll());
                    }
                    while (!TimeQueue3.isEmpty()) 
                    {
                        TimeQueue.add(TimeQueue3.poll());
                    }

                    //send the TimeQueue that contains all of the process information to Excel & send the name of the schedule method
                    String name = "First Come First Serve Multiprocessor";
                    ExcelExport.exceltest(name, TimeQueue);

                    break;
                
                //RR1
                case 2:
                    //run the Round Robin schedule algorithm on all (4) CPU queus 
                    Queue<ProcessControlBlock> TimeQueueRR = ProcessSchedules.rr1(cpuqueue1);
                    Queue<ProcessControlBlock> TimeQueue1RR = ProcessSchedules.rr1(cpuqueue2);
                    Queue<ProcessControlBlock> TimeQueue2RR = ProcessSchedules.rr1(cpuqueue3);
                    Queue<ProcessControlBlock> TimeQueue3RR = ProcessSchedules.rr1(cpuqueue4);

                    //get all of the process objects from each CPU queue on one time queue to be sent to Excel
                    while (!TimeQueue1RR.isEmpty()) 
                    {
                        TimeQueueRR.add(TimeQueue1RR.poll());
                    }
                    while (!TimeQueue2RR.isEmpty()) 
                    {
                        TimeQueueRR.add(TimeQueue2RR.poll());
                    }
                    while (!TimeQueue3RR.isEmpty()) 
                    {
                        TimeQueueRR.add(TimeQueue3RR.poll());
                    }

                    //send the TimeQueue that contains all of the process information to Excel & send the name of the schedule method
                    String nameRR = "Round Robin Multiprocessor";
                    ExcelExport.exceltest(nameRR, TimeQueueRR);
                    break;
                    
                //RR10
                case 3:
                    //run the Round Robin schedule algorithm on all (4) CPU queus 
                    Queue<ProcessControlBlock> TimeQueue10RR = ProcessSchedules.rr10(cpuqueue1);
                    Queue<ProcessControlBlock> TimeQueue102RR = ProcessSchedules.rr10(cpuqueue2);
                    Queue<ProcessControlBlock> TimeQueue103RR = ProcessSchedules.rr10(cpuqueue3);
                    Queue<ProcessControlBlock> TimeQueue104RR = ProcessSchedules.rr10(cpuqueue4);

                    //get all of the process objects from each CPU queue on one time queue to be sent to Excel
                    while (!TimeQueue102RR.isEmpty()) 
                    {
                        TimeQueue10RR.add(TimeQueue102RR.poll());
                    }
                    while (!TimeQueue103RR.isEmpty()) 
                    {
                        TimeQueue10RR.add(TimeQueue103RR.poll());
                    }
                    while (!TimeQueue104RR.isEmpty()) 
                    {
                        TimeQueue10RR.add(TimeQueue104RR.poll());
                    }

                    //send the TimeQueue that contains all of the process information to Excel & send the name of the schedule method
                    String nameRR10 = "Round Robin (Q=10) Multiprocessor";
                    ExcelExport.exceltest(nameRR10, TimeQueue10RR);
                    break;

                //SPN
                case 4:
                    System.out.println("Shortest Process Next");
                    Queue<ProcessControlBlock> TimeQueueSPN = ProcessSchedules.shortestnext(cpuqueue1);
                    Queue<ProcessControlBlock> TimeQueueSPN1 = ProcessSchedules.shortestnext(cpuqueue2);
                    Queue<ProcessControlBlock> TimeQueueSPN2 = ProcessSchedules.shortestnext(cpuqueue3);
                    Queue<ProcessControlBlock> TimeQueueSPN3 = ProcessSchedules.shortestnext(cpuqueue4);
                    
                    //get all of the process objects from each CPU queue on one time queue to be sent to Excel
                    while (!TimeQueueSPN1.isEmpty()) 
                    {
                        TimeQueueSPN.add(TimeQueueSPN1.remove());
                    }
                    while(!TimeQueueSPN2.isEmpty())
                    {
                        TimeQueueSPN.add(TimeQueueSPN2.remove());
                    }
                    while(!TimeQueueSPN3.isEmpty())
                    {
                        TimeQueueSPN.add(TimeQueueSPN3.remove());
                    }
                    
                     //send the TimeQueue that contains all of the process information to Excel & send the name of the schedule method
                    String nameSPN = "SPN Multiprocessor";
                    ExcelExport.exceltest(nameSPN, TimeQueueSPN);
                    
                    break;
                    
                //Return to menu
                case 5:
                    return;
            }
        } while (choose <= 4); //loops through until user decided to return to menu
    }
}
