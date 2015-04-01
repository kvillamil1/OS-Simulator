/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simulatorjava;

import java.util.*;
import java.io.*;

/**
 *
 * @author JPerry1120
 */
public class readFile {

    public static Vector<Vector<String>> load() {
        Vector<Vector<String>> loadEvent = new Vector<Vector<String>>();
        File nf = new File("PCB_Values.txt");

        String Line;
        String[] newline;

        try {
            BufferedReader br = new BufferedReader(new FileReader(nf));
            while ((Line = br.readLine()) != null) {
                newline = Line.split(",");
                Vector<String> tmp = new Vector<String>();
                for (int i = 0; i < newline.length; i++) {
                    tmp.add(newline[i]);
                }
                loadEvent.add(tmp);
            }
            br.close();
        } catch (Exception e) {
            System.out.println("Did not read in File");
        }

        Iterator i = loadEvent.iterator();
        while (i.hasNext()) {

            //Vector<String> temp = new Vector<String>();
            System.out.println(i.next());

        }

        return loadEvent;
    }

    public static void setPCB() {
        Vector<Vector<String>> newvect = load();

        int tPid = 0;
        int tprioritynum = 0;
        int tparrival = 0;
        int tpbursttime = 0;
        int tpriotime = 0;

        //Hard coded values for now they have the ablility to change
        for (int i = 0; i < 5; i++) {
            tPid = Integer.parseInt(newvect.get(i).get(0));
            tprioritynum = Integer.parseInt(newvect.get(i).get(1));
            tparrival = Integer.parseInt(newvect.get(i).get(2));
            tpbursttime = Integer.parseInt(newvect.get(i).get(3));
            tpriotime = Integer.parseInt(newvect.get(i).get(4));
        }

        //I was able to pass values using this no problem.  
        //Will need to determine where each process control block is stored
        //Could be stored in a vector of objects and then referenced.
        ProcessControlBlock temp = new ProcessControlBlock(tPid, tprioritynum, tparrival, tpbursttime, tpriotime);
        
        
        //Testing Features
        //System.out.println(temp.getpid());

    }

}
