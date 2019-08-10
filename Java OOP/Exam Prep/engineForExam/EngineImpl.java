package motocrossWorldChampionship.core;

import motocrossWorldChampionship.core.interfaces.Engine;
import motocrossWorldChampionship.entities.interfaces.Motorcycle;
import motocrossWorldChampionship.entities.interfaces.Race;
import motocrossWorldChampionship.entities.interfaces.Rider;
import motocrossWorldChampionship.repositories.MotorcycleRepository;
import motocrossWorldChampionship.repositories.interfaces.Repository;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class EngineImpl implements Engine {
    private BufferedReader reader;
    private ChampionshipControllerImpl controller;
    private Repository<Motorcycle> motorcycleRepository;
    private Repository<Race> raceRepository;
    private Repository<Rider> riderRepository;


    public EngineImpl(Repository<Motorcycle> motorcycleRepository, Repository<Race> raceRepository, Repository<Rider> riderRepository) {
        this.reader = new BufferedReader(new InputStreamReader(System.in));
        this.controller = new ChampionshipControllerImpl(riderRepository, motorcycleRepository, raceRepository);
    }

    @Override
    public void run() {
        while (true) {
            String result = null;
            try {
                result = processInput();
                if ("End".equals(result)) {
                    break;
                }
            } catch (IOException | IllegalArgumentException e) {
                result = e.getMessage();
            }
            System.out.println(result);
        }
    }

    private String processInput() throws IOException {
        String input = reader.readLine();
        String[] tokens = input.split("\\s+");
        String[] data = Arrays.stream(tokens).skip(1).toArray(String[]::new);
        String command = tokens[0];
        String result = null;

        switch (command) {
            case "CreateRider":
                result = CreateRider(data);
                break;
            case "CreateMotorcycle":
                result = CreateMotorcycle(data);
                break;
            case "AddMotorcycleToRider":
                result = AddMotorcycleToRider(data);
                break;
            case "AddRiderToRace":
                result = AddRiderToRace(data);
                break;
            case "CreateRace":
                result = CreateRace(data);

                break;
            case "StartRace":
                result = StartRace(data);
                break;
            case "End":
                result = "End";

                break;

        }

        return result;
    }

    private String StartRace(String[] data) {
        String result = this.controller.startRace(data[0]);
        return result;
    }

    private String CreateRace(String[] data) {
        String result = this.controller.createRace(data[0], Integer.parseInt(data[1]));
        return result;
    }

    private String AddRiderToRace(String[] data) {
        String result = this.controller.addRiderToRace(data[0], data[1]);
        return result;
    }

    private String AddMotorcycleToRider(String[] data) {
        String result = this.controller.addMotorcycleToRider(data[0], data[1]);
        return result;
    }

    private String CreateMotorcycle(String[] data) {
        String result = this.controller.createMotorcycle(data[0], data[1], Integer.parseInt(data[2]));
        return result;
    }

    private String CreateRider(String[] data) {
        String result = this.controller.createRider(data[0]);
        return result;
    }
}

