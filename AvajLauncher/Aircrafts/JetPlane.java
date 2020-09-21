package AvajLauncher.Aircrafts;

import AvajLauncher.Interface.Flyable;
import AvajLauncher.SimGen.*;
import AvajLauncher.Messenger.*;

public class JetPlane extends Aircraft implements Flyable {

    private WeatherTower weatherTower;

    JetPlane(String name, Coordinates coordinates) {
        super(name, coordinates);
    }

    public void updateConditions() {
        String weather = this.weatherTower.getWeather(this.coordinates);

        int longitude = this.coordinates.getLongitude();
        int latitude = this.coordinates.getLatitude();
        int height = this.coordinates.getHeight();

        Messenger log = new Messenger();

        if(height > 100){
            height = 100;
        }

        if (weather == "SUN") {
            this.coordinates = new Coordinates(longitude, latitude + 10, height + 2);
            log.messenger("JetPlane#"+ this.name + "(" + this.id +")" + " The Sun is way too hot for me, my skin is itching");
        } else if (weather == "RAIN") {
            this.coordinates = new Coordinates(longitude, latitude + 5, height);
            log.messenger("JetPlane#"+ this.name + "(" + this.id +")" + " Rain, awesome... let me go take a shower outside ");
        } else if (weather == "FOG") {
            this.coordinates = new Coordinates(longitude, latitude + 1, height);
            log.messenger("JetPlane#"+ this.name + "(" + this.id +")" + "Fog! Oh flip, can't even see my eyes. haha");
        } else if (weather == "SNOW") {
            this.coordinates = new Coordinates(longitude, latitude, height - 7);
            log.messenger("JetPlane#"+ this.name + "(" + this.id +")" + " What a cold morning! ");
        } else {
            System.out.println("Weather unavailable");
        }

        if(height > 100){
            height = 100;
        }

        if(height <= 0){
            log.messenger("Tower says: JetPlane#"+ this.name + "(" + this.id +")" + " has landed at " + latitude + " " + longitude + " " + height );
            log.messenger("Tower says: JetPlane#"+ this.name + "(" + this.id +")" + " unregistered from weather tower" );
            this.weatherTower.unregister(this);
        }
    }

    public void registerTower(WeatherTower weatherTower) {
        Messenger log = new Messenger();

        weatherTower.register(this);
        this.weatherTower = weatherTower;
        log.messenger("Tower says: JetPlane#"+ this.name + "(" + this.id +")" + " registered to weather tower");
    }

}
