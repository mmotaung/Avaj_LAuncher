package AvajLauncher.Aircrafts;

import AvajLauncher.Interface.Flyable;
import AvajLauncher.SimGen.*;
import AvajLauncher.Messenger.*;

public class Baloon extends Aircraft implements Flyable{
	
	private WeatherTower weatherTower;
	
	Baloon(String name, Coordinates coordinates){
		super(name, coordinates);
	}
	
	public void updateConditions(){
        String weather = weatherTower.getWeather(this.coordinates);
        int longitude = this.coordinates.getLongitude();
        int latitude = this.coordinates.getLatitude();
        int height = this.coordinates.getHeight();

        Messenger log = new Messenger();

        if(height > 100){
            height = 100;
        }
        
        if (weather == "SUN"){
            this.coordinates = new Coordinates(longitude + 2, latitude, height + 4);
            log.messenger("Baloon#"+ this.name + "(" + this.id +")" + " The sun is out let me get my beer ");
        }else if(weather == "RAIN"){
            this.coordinates = new Coordinates(longitude, latitude, height - 5);
            log.messenger("Baloon#"+ this.name + "(" + this.id +")" + " Oh what a rainy day, let it rain on me ");
        }else if(weather == "FOG"){
            this.coordinates = new Coordinates(longitude, latitude, height - 3);
            log.messenger("Baloon#"+ this.name + "(" + this.id +")" + " So much fog, let me put my fog lights on ");
        }else if(weather == "SNOW"){
            this.coordinates = new Coordinates(longitude, latitude, height - 15);
            log.messenger("Baloon#"+ this.name + "(" + this.id +")" + " Snow Snow Snow, hold my beer i'm going for a swim. haha ");
        }else{
            System.out.println(" Weather unavailable ");
        }

        if(height > 100){
            height = 100;
        }

        if(height <= 0){
            log.messenger("Tower says: Baloon#"+ this.name + "(" + this.id +")" + " has landed at " + latitude + " " + longitude + " " + height );
            log.messenger("Tower says: Baloon#"+ this.name + "(" + this.id +")" + " unregistered from weather tower" );
            this.weatherTower.unregister(this);
        }


	}
	
	public void registerTower(WeatherTower weatherTower){
        Messenger log = new Messenger();

        weatherTower.register(this);
         this.weatherTower = weatherTower;
         log.messenger("Tower says: Baloon#"+ this.name + "(" + this.id +")" + " registered to weather tower" );
	}
}