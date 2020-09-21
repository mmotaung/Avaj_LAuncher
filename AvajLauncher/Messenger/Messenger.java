package AvajLauncher.Messenger;

import java.io.FileWriter;
import java.io.PrintWriter;

public class Messenger {
   public void messenger(String message){
        try {
            FileWriter fw = new FileWriter("simulation.txt", true);
            PrintWriter pw = new PrintWriter(fw);
            pw.println(message);
           pw.close();
          } catch (Exception e) {
            System.out.println("Could not write to file.");
          }
    }
}
