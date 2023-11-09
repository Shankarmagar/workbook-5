package com.pluralsight;

import javax.lang.model.type.ArrayType;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class UserInterface {
    Scanner scanner = new Scanner(System.in);
    Dealership dealership;

    UserInterface() {

    }


    public void display() {
        init();


        while (true) {
            System.out.printf("""
                    WELCOME TO SHASAELI INC.
                    choose the following options for further process:
                    1. Add Vehicles
                    2. Remove Vehicles
                    3. Customize search
                    4. Sale Contract Vehicle
                    5. Lease Vehicle
                    6. Exit
                    """);
            int answer = scanner.nextInt();

            switch (answer) {
                case 1 -> processAddVehicleRequest();
                case 2 -> processRemoveVehicleRequest();
                case 3 -> processAllVehiclesRequest();
                //writing for sell and lease
                case 4 -> processSaleContractVehicle();
                case 6 -> System.exit(0);
                default -> System.out.println("Please re-enter valid input.");
            }

        }
    }

    private void processSaleContractVehicle() {

        System.out.println("""
                Please provide following information for Sale:
             
                """);
        System.out.println("Enter date: ");
        String date = scanner.nextLine();

        System.out.println("Enter the name: ");
        String name = scanner.nextLine();

        System.out.println("Enter the email: ");
        String mail= scanner.nextLine();

        System.out.println("Enter the Vin for the vehicle: ");
        int vin = scanner.nextInt();
        scanner.nextLine();


    }

    private void processRemoveVehicleRequest() {

    }

    private void init() {
        DealershipFileManager manager = new DealershipFileManager();
        dealership = manager.getDealership();
    }

    private void displayVehicles(ArrayList<Vehicle> listsOfVehicles) {
        while (true) {
            System.out.println("""
                    WELCOME To the customize search menu
                    Follow the following instructions for further process:
                    1. Get all Vehicles
                    2. Get by Price
                    3. Get by Model
                    4. Get by Year
                    5. Get by Color
                    6. Get by Mileage
                    7. Get by VehicleType
                    8. Return to previous menu
                    """);

            int ans = scanner.nextInt();

            switch (ans) {
                case 1 -> processGetAllVehiclesRequest();
                case 2 -> processGetByPriceRequest();
                case 3 -> processGetByMakeModelRequest();
                case 4 -> processGetByYearRequest();
                case 5 -> processGetByColorRequest();
                case 6 -> processGetByMileageRequest();
                case 7 -> processGetByVehicleType();

                default -> System.out.println("Please re-enter the valid input: ");

            }
        }
    }

    private void processGetAllVehiclesRequest() {
        ArrayList<Vehicle> showListOfVehicles = this.dealership.getAllVehicles();
        showOutput(showListOfVehicles);
    }

    private void processGetByMileageRequest() {
        System.out.println("Enter min mileage: ");
        int minMileage = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Enter Max Mileage: ");
        int maxMileage = scanner.nextInt();
        scanner.nextLine();

        showOutput(dealership.getVehiclesByMileage(minMileage, maxMileage));
    }

    private void processGetByVehicleType() {
        System.out.println("Enter Vehicle Type: ");
        String type = scanner.nextLine();

        showOutput(dealership.getVehiclesByType(type));
    }


    private void processGetByColorRequest() {
        System.out.println("Red: ");
        String color = scanner.nextLine();

        showOutput(dealership.getVehiclesByColor(color));
    }

    private void processGetByYearRequest() {
        // prompt
        System.out.println("Enter the min year: ");
        // read user input (int)
        int minYear = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Enter the max year: ");
        int maxYear = scanner.nextInt();
        scanner.nextLine();
        // iterate through all vehicles to get the user's desired year
        showOutput(dealership.getVehiclesByYear(minYear, maxYear));
    }

    private void processGetByMakeModelRequest() {
        System.out.println("Enter the make: ");
        String make = scanner.nextLine();

        System.out.println("Enter the model: ");
        String model = scanner.nextLine();

        showOutput(dealership.getVehiclesByMakeModel(make, model));


    }

    private void processGetByPriceRequest() {
        System.out.println("Enter Maximum Price");
        double max = scanner.nextDouble();
        System.out.println("Enter minimum Price: ");
        double min = scanner.nextDouble();

        ArrayList<Vehicle> res = dealership.getVehiclesByPrice(max, min);
        System.out.println("""
                Vehicles list based on provided price:
                                
                """);
        for (Vehicle v : res) {
            System.out.println("Make: " + v.getMake() + " Type: " + v.getVehicleType() + " Price: " + v.getPrice());
        }

    }

    private void processAllVehiclesRequest() {
        displayVehicles(dealership.getAllVehicles());

    }

    public void processAddVehicleRequest() {
        System.out.println("Enter Vehicle Vin number: ");
        int Vin = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Enter the year of Vehicle: ");
        int year = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Enter the make of Vehicle: ");
        String make = scanner.nextLine();

        System.out.println("Enter the model of Vehicle: ");
        String model = scanner.nextLine();

        System.out.println("Enter the Type of Vehicle: ");
        String Type = scanner.nextLine();

        System.out.println("Enter the color of Vehicle: ");
        String color = scanner.nextLine();

        System.out.println("Enter the odometer of Vehicle: ");
        int odometer = scanner.nextInt();

        System.out.println("Enter the price of Vehicle: ");
        double price = scanner.nextDouble();

        dealership.addVehicle(Vin, year, make, model, Type, color, odometer, price);


        // Adding vehicle types to ArrayList


    }

    public void showOutput(ArrayList<Vehicle> l) {

        for (Vehicle vehicle : l) {
            System.out.println("Vin number: " + vehicle.getVin() + " Year: " + vehicle.getYear() + " Make: " + vehicle.getMake() + " Type: " + vehicle.getVehicleType() + " Model: " + vehicle.getModel()
                    + " Color: " + vehicle.getColor() + " Odometer: " + vehicle.getOdometer() + "Price: " + vehicle.getPrice());
        }
    }
}
