package com.pluralsight;

import java.io.FileWriter;
import java.io.IOException;

public class ContractDataManager {
    public void saveContract(Contract contract)
    {
     String fileName = "Contract_record.csv";

     try(FileWriter writer = new FileWriter(fileName)){
       if(contract instanceof LeaseContract)
       {
           LeaseContract leaseContract = (LeaseContract) contract;
           writer.write(String.format("LEASE|%s|%s|%s|%s|%s|%s|%s|%s|%s|%s|%s|%s|%s|%s\n",
                   leaseContract.getDate(),
                   leaseContract.getCustomerName(),
                   leaseContract.getCustomerEmail(),
                   leaseContract.getVehicleSold().getYear(),
                   leaseContract.getVehicleSold().getMake(),
                   leaseContract.getVehicleSold().getModel(),
                   leaseContract.getVehicleSold().getVehicleType(),
                   leaseContract.getVehicleSold().getColor(),
                   leaseContract.getVehicleSold().getOdometer(),
                   leaseContract.getVehicleSold().getPrice(),
                   leaseContract.expectedEndedValue,
                   leaseContract.leaseFee,
                   leaseContract.getTotalPrice(),
                   leaseContract.getMonthlyPayment()));
       }
       else if (contract instanceof SalesContract) {
           // Save SalesContract specific information
           SalesContract salesContract = (SalesContract) contract;
           writer.write(String.format("SALE|%s|%s|%s|%s|%s|%s|%s|%s|%s|%s|%s|%s|%s|%s|%s|%s\n",
                   salesContract.getDate(),
                   salesContract.getCustomerName(),
                   salesContract.getCustomerEmail(),
                   salesContract.getVehicleSold().getYear(),
                   salesContract.getVehicleSold().getMake(),
                   salesContract.getVehicleSold().getModel(),
                   salesContract.getVehicleSold().getVehicleType(),
                   salesContract.getVehicleSold().getColor(),
                   salesContract.getVehicleSold().getOdometer(),
                   salesContract.getVehicleSold().getPrice(),
                   salesContract.getProcessingFee(),
                   salesContract.getSaleTax(),
                   salesContract.getRecording_fee(),
                   salesContract.getTotalPrice(),
                   salesContract.isFinance() ? "YES" : "NO",
                   salesContract.getMonthlyPayment()));
       }
     }
     catch(IOException e)
     {
         e.printStackTrace();
     }
    }
}
