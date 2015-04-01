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

            while((Line = br.readLine()) !=null )
            {
                newline = Line.split(",");
                
                Vector<String> tmp = new Vector<String>();
                
                for(int i = 0; i < newline.length; i++)
                {
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

}
