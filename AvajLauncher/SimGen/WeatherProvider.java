package AvajLauncher.SimGen;

import AvajLauncher.Aircrafts.*;
import java.util.Random;

public class WeatherProvider {
    private static WeatherProvider weatherProvider = new WeatherProvider();
    private String weather[] = { "RAIN", "FOG", "SUN", "SNOW" };

    public static WeatherProvider getProvider() {
        if (weatherProvider == null){
            weatherProvider = new WeatherProvider();
    }
    return weatherProvider;
}


    public String getCurrentWeather(Coordinates coordinates){
        int rand = new Random().nextInt(4);

        return (weather[rand]);
    }
}
