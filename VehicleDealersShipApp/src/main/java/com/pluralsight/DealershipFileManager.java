package com.pluralsight;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class DealershipFileManager {
    public Dealership getDealership() {

        Dealership d = new Dealership();
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader("inventory.csv"));

            String firstLine = bufferedReader.readLine();

            String [] dealershipInfo = firstLine.split("\\|");


            ArrayList<Vehicle> ListOfVehicle = new ArrayList<> ();

            while((firstLine =bufferedReader.readLine())!=null)
            {
                String [] vehicleInfo = firstLine.split("\\|");
                Vehicle v = new Vehicle(Integer.parseInt(vehicleInfo[0]), Integer.parseInt(vehicleInfo[1]),vehicleInfo[2],vehicleInfo[3],vehicleInfo[4], vehicleInfo[5],Integer.parseInt(vehicleInfo[6]),Double.parseDouble(vehicleInfo[7]));
                ListOfVehicle.add(v);
            }
            d = new Dealership(dealershipInfo[0],dealershipInfo[1],dealershipInfo[2], ListOfVehicle);

            bufferedReader.close();


        } catch (Exception e) {
            e.printStackTrace();
        }
        return d;
    }

    public void saveDealership(Dealership d1) {


    }
}

