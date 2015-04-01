/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simulatorjava;

/**
 *
 * @author stephenthoen
 */
public class ProcessControlBlock {
    
    private int pid;
    private int prioritynum;
    private int parrival;
    private int pbursttime;
    private int piotime;
    private int context_switch;
    private int turnaroundtime;
    private int throughputtime;
    private int waittime;
    
    
    
    
    ProcessControlBlock(int id, int pnum, int arrivaltime, int burst, int iotime, int con_switch){
        pid = id;
        prioritynum = pnum;
        parrival = arrivaltime;
        pbursttime = burst; 
        piotime = iotime;
        context_switch = con_switch;
        
        turnaroundtime = 0;
        throughputtime = 0;
        waittime = 0;
        
    }
    

}
