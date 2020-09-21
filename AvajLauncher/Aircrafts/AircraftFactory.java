package AvajLauncher.Aircrafts;

import AvajLauncher.Interface.*;

public abstract class AircraftFactory {
    public static Flyable newAircraft(String type, String name, int longitude, int latitude, int height){
        Flyable flyable = null;

        
        Coordinates coordinates = new Coordinates(longitude, latitude, height);
        
        if(coordinates.getLongitude() < 0 || coordinates.getLatitude() < 0 || coordinates.getHeight() < 0){
            System.out.println("Coordinates cannot be negative");
            System.exit(1);
        }
        if (type.equals("Helicopter")){
            flyable = new Helicopter(name, coordinates);
        }else if (type.equals("JetPlane")){
            flyable = new JetPlane(name, coordinates);
        }else if (type.equals("Baloon")){
            flyable = new Baloon(name, coordinates);
        }else{
            System.out.println("Aircraft not recognised " + type);
        }
        return(flyable);
    }
}