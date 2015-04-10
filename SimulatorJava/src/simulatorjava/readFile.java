/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simulatorjava;

import java.util.*;
import java.io.*;

/**
 * Reads in file containing processes
 * @author JPerry1120
 */
public class readFile {

    //Reads a random process control block that is created from random 
    public static Queue<ProcessControlBlock> theTable = new LinkedList<ProcessControlBlock>();
    
    
    //Load the file into a vector that will store each object as a PCB
    public static Vector<Vector<String>> load() {
        Vector<Vector<String>> loadEvent = new Vector<Vector<String>>();
        //File nf = new File("TEST_VALUES.txt");
        File nf = new File("PCB_Values.txt");
        String Line;
        String[] newline;

        //Try catch lope to read file and then sort through each line.
        try {
            BufferedReader br = new BufferedReader(new FileReader(nf));
            while ((Line = br.readLine()) != null) {
                newline = Line.split(",");
                Vector<String> tmp = new Vector<String>();
                //for loop to move through each line.
                for (int i = 0; i < newline.length; i++) {
                    tmp.add(newline[i]);
                }
                loadEvent.add(tmp);
            }
            br.close();
        } catch (Exception e) {
            System.out.println("Did not read in File");
        }

        return loadEvent;
    }

    public static Object setPCB() {
        Vector<Vector<String>> newvect = load();//loads the objects into a PCB

        //These are temp variables that match the PCB Constructor.
        int tPid = 0;
        int tprioritynum = 0;
        int tparrival = 0;
        int tpbursttime = 0;
        int tpriotime = 0;
        int tpcontextswitch = 0;

        ProcessSchedules ps = new ProcessSchedules();
        //Hard coded values for now they have the ablility to change
        for (int i = 0; i < newvect.size(); i++) {
            tPid = Integer.parseInt(newvect.get(i).get(0));
            tprioritynum = Integer.parseInt(newvect.get(i).get(1));
            tparrival = Integer.parseInt(newvect.get(i).get(2));
            tpbursttime = Integer.parseInt(newvect.get(i).get(3));
            tpriotime = Integer.parseInt(newvect.get(i).get(4));
            tpcontextswitch = Integer.parseInt(newvect.get(i).get(5));

            //Assigns the a PCB object 
            ProcessControlBlock temp
                    = new ProcessControlBlock(tPid, tprioritynum, tparrival, tpbursttime, tpriotime, tpcontextswitch);

            theTable.add(temp);//Assign the temp variable PCB to the Queue(Process Table)
            
        }
        return theTable;
    }

    
      public static void save(ArrayList<String> list) {
        File file = new File("PCB_Values.txt");
        
        try {
            BufferedWriter buffer = new BufferedWriter(new FileWriter(file, true));
            FileOutputStream f = new FileOutputStream(file, false);
            for (int i = 0; i < list.size(); i++) {
                buffer.write(list.get(i));
                buffer.newLine();

            }
            buffer.close();
            f.close();
        } catch (Exception e) {
            System.out.print("There was a problem with the output file");
        }
        
    }
    
    public static void randomList()
    {
        ArrayList<String> values = new ArrayList();
        
        Random randnum = new Random();
        
        int id = 0;
        int randompriority =0;
        int arrivaltimes = 0;
        int randomBurst = 0 ; 
        int randomIO = 0;
        int context = 0;
        String tmplist = "";
        
        
        for(int i = 0; i < 500; i++)
        {
            id = i;
            randompriority = randnum.nextInt(50);
            arrivaltimes = 0;
            randomBurst = randnum.nextInt(99) + 1;
            randomIO = randnum.nextInt(50);
            context = 1;
            
            tmplist = id + "," + randompriority + "," + arrivaltimes + "," +
                    randomBurst + "," + randomIO + "," + context;
            
            values.add(tmplist);
        }
        
        
        save(values);
        
        
        
        
    }
    
    
    
    
    
}
