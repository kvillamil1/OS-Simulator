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
    private int pcontext_switch;
    
    private int turnaroundtime;
    private int throughputtime;
    private int waittime;
    private int presponsetime;
    
    
    
    //, int con_switch 
    //Took this out for testing
    
    ProcessControlBlock(int id, int pnum, int arrivaltime, int burst, int iotime, int context_switchtime)
    {
        pid = id;
        prioritynum = pnum;
        parrival = arrivaltime;
        pbursttime = burst; 
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
    
    public int getpid(){
        return pid;
    }
    
    public int getprioritynum()
    {
        return prioritynum;
    }
    
    public int getparrival()
    {
        return parrival;
    }
    public int getbursttime()
    {
        return pbursttime;
    }
    public int getiotime()
    {
        return piotime;
    }
    public void setiotime(int iotime)
    {
        piotime = iotime;
    }
    public int getcontextswitchtime()
    {
        return pcontext_switch;
    }
    public void setcontextswitchtime(int contextswitchtime)
    {
        pcontext_switch = contextswitchtime;
    }
    public int getturnaroundtime()
    {
        return turnaroundtime;
    }
    public void setturnaroundtime(int turnaround)
    {
        turnaroundtime = turnaround;
    }
    public int getthroughputtime()
    {
        return throughputtime;
    }
    public void setthroughputtime(int tp)
    {
        throughputtime = tp;
    }
    public int getwaittime()
    {
        return waittime;
    }
    public void setwaittime(int wt)
    {
        waittime = wt;
    }
    public int getresponsetime()
    {
        return presponsetime;
    }
    public void setresponsetime(int rt)
    {
        presponsetime = rt;
    }

}
 
   
    
   