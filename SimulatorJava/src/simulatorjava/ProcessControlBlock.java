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
    private int pbursttimerr;
    private int piotime;
    private int pcontext_switch;
    
    private int turnaroundtime;
    private int throughputtime;
    private int waittime;
    private int presponsetime;
    
    ProcessControlBlock(int id, int pnum, int arrivaltime, int burst, int iotime, int context_switchtime)
    {
        pid = id;
        prioritynum = pnum;
        parrival = arrivaltime;
        pbursttime = burst; 
        pbursttimerr = burst;
        piotime = iotime;
        pcontext_switch = context_switchtime;
        
        turnaroundtime = 0;
        throughputtime = 0;
        waittime = 0;   
    }
    
    public void setburst(int burstr)
    {
        pbursttime = burstr;
    }
    public void setburstrr(int burstrr)
    {
        pbursttimerr = burstrr;
    }
    
    //get method for processor id
    public int getpid(){
        return pid;
    }
    
    //get method for processor priority number
    public int getprioritynum()
    {
        return prioritynum;
    }
    
    //get method for processor arrival time
    public int getparrival()
    {
        return parrival;
    }
    
    //get method for process CPU burst time
    public int getbursttime()
    {
        return pbursttime;
    }
    
     //get method for process CPU burst time for Round Robin
    public int getbursttimerr()
    {
        return pbursttimerr;
    }
    
    //get method for process io time
    public int getiotime()
    {
        return piotime;
    }
    
    //set method for iotime
    public void setiotime(int iotime)
    {
        piotime = iotime;
    }
    
    //get method for context switch time
    public int getcontextswitchtime()
    {
        return pcontext_switch;
    }
    
    //get method for turnaround time
    public int getturnaroundtime()
    {
        return turnaroundtime;
    }
    
    //get method for response time
    public int getresponsetime()
    {
        return presponsetime;
    }
    
    //get method for throughput time
    public int getthroughputtime()
    {
        return throughputtime;
    }
    
    //get method for wait time
    public int getwaittime()
    {
        return waittime;
    }
    
    //set method for context swithc time
    public void setcontextswitchtime(int contextswitchtime)
    {
        pcontext_switch = contextswitchtime;
    }
    
    //set method for turnaround time
    public void setturnaroundtime(int turnaround)
    {
        turnaroundtime = turnaround;
    }
    
    //set method for throughput time
    public void setthroughputtime(int tp)
    {
        throughputtime = tp;
    }
    
    //set method for wait time
    public void setwaittime(int wt)
    {
        waittime = wt;
    }
    
    //set method for reponse time
    public void setresponsetime(int rt)
    {
        presponsetime = rt;
    }

}
 
   
    
   