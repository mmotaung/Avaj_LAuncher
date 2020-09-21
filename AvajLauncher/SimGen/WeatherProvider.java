package AvajLauncher.SimGen;

import AvajLauncher.Aircrafts.*;
import java.util.Random;

public class WeatherProvider {
    private static WeatherProvider weatherProvider = new WeatherProvider();
    private String weather[] = { "RAIN", "FOG", "SUN", "SNOW" };

    private WeatherProvider() {

    }

    public static WeatherProvider getProvider() {
        return weatherProvider;
    }

    public String getCurrentWeather(Coordinates coordinates){
        int rand = new Random().nextInt(4);

        return (weather[rand]);
    }
}
