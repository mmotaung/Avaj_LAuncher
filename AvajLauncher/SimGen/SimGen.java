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
            } else {
				FileWriter fw = new FileWriter("simulation.txt");
            	PrintWriter pw = new PrintWriter(fw);
				pw.print("");
				pw.close();
            }
          } catch (Exception e) {
            System.out.println("Could not create file.");
          }

		try {
			if (args.length == 0) {
				System.out.println("File not included");
				System.exit(1);
			} else {

				BufferedReader br = null;
				br = new BufferedReader(new FileReader(args[0]));

				String line;

				int numOfSimulations = 0;

				try {
					line = br.readLine();
					numOfSimulations = Integer.parseInt(line.split(" ")[0]);

					if (numOfSimulations < 0) {
						System.out.println("Invalid scenario file, no of simulations cannot be a negative number");// check for negitives
						System.exit(1);
					}

				} catch (Exception e) {
					System.out.println("Invalid scenario file");
					System.exit(1);
				}

				try {

					WeatherTower tower = new WeatherTower();
					ArrayList<Flyable> flyables = new ArrayList<>();

					while ((line = br.readLine()) != null) {
						line = line.trim();
						line = line.replaceAll("\\s+", " ");
						String[] values = line.split(" ");
						if (values.length != 5) {
							System.out.println("Fields missing in scenario file");
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

					for (int i = 1; i <= numOfSimulations; i++) {
						tower.changeWeather();
					}

					System.out.println("Simulation ran " + numOfSimulations + " times");

				} catch (Exception e) {
					System.out.println("error occured");
					System.exit(1);
				}
				br.close();
			}
		} catch (Exception e) {
			System.out.println("Couldn't read from file");
			System.exit(1);
		}

	}

}
