package AvajLauncher.SimGen;

import AvajLauncher.Interface.*;
import AvajLauncher.Aircrafts.*;
import java.io.*;
import java.util.ArrayList;

public class SimGen {
	public static void main(String[] args) throws FileNotFoundException {

		try {
            File simulation = new File("simulation.txt");
            if (simulation.createNewFile()) {
				System.out.println("File created: " + simulation.getName());
            } else {
				FileWriter fwriter = new FileWriter("simulation.txt");
            	PrintWriter pwriter = new PrintWriter(fwriter);
				pwriter.print("");										
				pwriter.close();
				System.out.println("Empty File recreated.");
            }
          } catch (Exception e) {
            System.out.println("File could not be created.");
          }

		try {
			if (args.length == 0) {
				System.out.println("File not included");
				System.exit(1);
			} else {

				BufferedReader reader = null;
				reader = new BufferedReader(new FileReader(args[0]));

				String line;

				int SimNumber = 0;

				try {
					line = reader.readLine();
					SimNumber = Integer.parseInt(line.split(" ")[0]);

					if (SimNumber < 0) {
						System.out.println("Number of simulations cannot be negative");
						System.exit(1);
					}

				} catch (Exception e) {
					System.out.println("Invalid scenario file");
					System.exit(1);
				}

				try {

					WeatherTower tower = new WeatherTower();
					ArrayList<Flyable> flyables = new ArrayList<>();

					while ((line = reader.readLine()) != null) {
						line = line.trim();
						line = line.replaceAll("\\s+", " ");
						String[] values = line.split(" ");
						if (values.length != 5) {
							System.out.println("Missing Fields in scenario file");
							System.exit(1);
						}

						Flyable flyable = AircraftFactory.newAircraft(
								values[0], values[1], Integer.parseInt(values[2]), Integer.parseInt(values[3]),
								Integer.parseInt(values[4]));
						flyables.add(flyable);

					}
					
					for (Flyable aircraft : flyables) {
						aircraft.registerTower(tower);
					}
					int	i = 1;
					while(i <= SimNumber)
					{
						tower.changeWeather();
						i++;
					}

					System.out.println("Simulation ran " + SimNumber + " times");

				} catch (Exception e) {
					System.out.println("Encountered an error");
					System.exit(1);
				}
				reader.close();
			}
		} catch (Exception e) {
			System.out.println("Failed to read from file.");
			System.exit(1);
		}

	}

}
