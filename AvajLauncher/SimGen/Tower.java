package AvajLauncher.SimGen;

import java.util.*;
import AvajLauncher.Interface.Flyable;

public abstract class Tower {
    private List<Flyable> observers = new ArrayList<Flyable>();

    public void register(Flyable flyable){
        try {
            this.observers.add(flyable);     
        } catch (Exception e) {
            System.out.println("failed to register flyable");
        }
        }

    public void unregister(Flyable flyable){
        try {
       this.observers.remove(flyable);    
        } catch (Exception e) {
            System.out.println("failed to unregister");
        }
    }
    protected void conditionsChanged(){
        try {
            int i = 0;
            while ( i < observers.size())
            {
                observers.get(i).updateConditions();
                i++;
            }
        } catch (Exception e) {
            System.out.println("Couldn't update conditions");        }
    }
}
