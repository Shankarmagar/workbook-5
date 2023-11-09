package com.pluralsight;

import java.util.ArrayList;

public class Dealership {
    private String name;
    private String address;
    private String phone;
    private ArrayList<Vehicle> inventory = new ArrayList<>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setInventory(ArrayList<Vehicle> inventory) {
        this.inventory = inventory;
    }

    public ArrayList<Vehicle> getInventory() {
        return inventory;
    }

    //Constructor
    public Dealership(String name, String address, String phone, ArrayList<Vehicle> s) {
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.inventory = s;
    }
    public Dealership()
    {

    }

    public Dealership(String name, String address, String phone)
    {
        this.name = name;
        this.address = address;
        this.phone = phone;
    }

    public ArrayList<Vehicle> getVehiclesByPrice(double max, double min) {
        ArrayList<Vehicle> res = new ArrayList<>();
        for(Vehicle v: getInventory())
        {
            if(v.getPrice()>=min && v.getPrice()<=max)
            {
                res.add(v);
            }
        }
        return res;
    }

    public ArrayList<Vehicle> getVehiclesByMakeModel(String make, String model) {
        ArrayList<Vehicle> res = new ArrayList<>();
        for(Vehicle v: getInventory())
        {
            if(make.equals(v.getMake()) && model.equals(v.getModel()))
            {
                res.add(v);
            }
        }
        return res;
    }

    public ArrayList<Vehicle> getVehiclesByYear(int min, int max) {
        ArrayList<Vehicle> res = new ArrayList<>();
        for(Vehicle v: getInventory())
        {
            if(v.year>=min && v.year<=max)
            {
                res.add(v);
            }
        }
        return res;
    }

    public ArrayList<Vehicle> getVehiclesByColor(String color) {
        ArrayList<Vehicle> res = new ArrayList<>();
        for(Vehicle v: getInventory())
        {
            if(v.getColor().equals(color))
            {
                res.add(v);
            }
        }
        return res;
    }

    public ArrayList<Vehicle> getVehiclesByMileage(int min, int max) {
        ArrayList<Vehicle> res = new ArrayList<>();
        for(Vehicle v: getInventory())
        {
            if(v.getOdometer()>= min && v.getOdometer()<=max)
            {
                res.add(v);
            }
        }
        return res;
    }

    public ArrayList<Vehicle> getVehiclesByType(String vehicleType) {
        
        ArrayList<Vehicle> res = new ArrayList<>();
        for(Vehicle v: getInventory())
        {
            if(v.getVehicleType().equals(vehicleType))
            {
                res.add(v);
            }
        }
        return res;
    }

    public ArrayList<Vehicle> getAllVehicles() {

        return this.getInventory();
    }

    public void addVehicle(int Vin, int year, String make, String model, String vehicleType, String color, int odometer, double price) {
       Vehicle newVehicle = new Vehicle(Vin, year, make, model, vehicleType, color, odometer, price);
       this.getInventory().add(newVehicle);
       // write in a csv file

        

    }

    public void removeVehicle(Vehicle b) {
        if (b == null){
            return;
        }
        int index = this.getInventory().indexOf(b);
        if(index >= 0){
            this.inventory.remove(index);
        }
    }
}
