package AvajLauncher.Interface;

import AvajLauncher.SimGen.*;

public interface Flyable {
    void updateConditions();
    void registerTower(WeatherTower WeatherTower);
}
