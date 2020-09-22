package AvajLauncher.Messenger;

import java.io.FileWriter;
import java.io.PrintWriter;

public class Messenger {
   public void messenger(String message){
        try {
            FileWriter fwriter = new FileWriter("simulation.txt", true);
            PrintWriter pwriter = new PrintWriter(fwriter);
            pwriter.println(message);
           pwriter.close();
          } catch (Exception e) {
            System.out.println("Failed to write to file.");
          }
    }
}
