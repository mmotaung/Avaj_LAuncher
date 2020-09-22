package AvajLauncher.Aircrafts;

import AvajLauncher.Interface.Flyable;
//import AvajLauncher.Aircrafts.Aircraft;
import AvajLauncher.SimGen.*;
import AvajLauncher.Messenger.*;

public class Helicopter extends Aircraft implements Flyable{
	
	private WeatherTower weatherTower;
	
	Helicopter(String name, Coordinates coordinates){
		super(name, coordinates);
	}
	
	public void updateConditions(){
        String weather = this.weatherTower.getWeather(this.coordinates);
        
        int longitude = this.coordinates.getLongitude();
        int latitude = this.coordinates.getLatitude();
        int height = this.coordinates.getHeight();

        Messenger log = new Messenger();

        if(height > 100){
            height = 100;
        }

        if (weather == "SUN"){
            this.coordinates = new Coordinates(longitude + 10, latitude, height + 2);
            log.messenger("Helicopter#"+ this.name + "(" + this.id +")" + " Sunny day, let's get this party started ");
        }else if(weather == "RAIN"){
            this.coordinates = new Coordinates(longitude + 5, latitude, height);
            log.messenger("Helicopter#"+ this.name + "(" + this.id +")" + " So much rain after a very long time ");
        }else if(weather == "FOG"){
            this.coordinates = new Coordinates(longitude + 1, latitude, height);
            log.messenger("Helicopter#"+ this.name + "(" + this.id +")" + " oh Fog, let's place hide and seek ");
        }else if(weather == "SNOW"){
            this.coordinates = new Coordinates(longitude, latitude, height - 12);
            log.messenger("Helicopter#"+ this.name + "(" + this.id +")" + " Snow after so long, wonder if it's still white ");
        }else{
            System.out.println("Weather unavailable");
        }

        if(height > 100){
            height = 100;
        }

        if(height <= 0){
            log.messenger("Tower says: Helicopter#"+ this.name + "(" + this.id +")" + " has landed at " + latitude + " " + longitude + " " + height + " ______________");
            log.messenger("Tower says: Helicopter#"+ this.name + "(" + this.id +")" + " unregistered from weather tower" );
            this.weatherTower.unregister(this);
        }
	}
	
	public void registerTower(WeatherTower weatherTower){
        Messenger log = new Messenger();

         this.weatherTower = weatherTower;
         this.weatherTower.register(this);
         log.messenger("Tower says: Helicopter#"+ this.name + "(" + this.id +")" + " registered to weather tower" );
	}
}

