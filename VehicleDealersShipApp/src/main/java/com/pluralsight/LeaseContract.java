package com.pluralsight;

public class LeaseContract extends Contract{
    public LeaseContract(String date, String name, String email, Vehicle sold, double totalPrice, double monthlyPayment) {
        super(date, name, email, sold, totalPrice, monthlyPayment);
    }

    @Override
    public double getTotalPrice() {
        return this.getVehicleSold().getPrice()+leaseFee;
    }

    double expectedEndedValue = (50/100) * this.getVehicleSold().getPrice();
    double leaseFee = (7/100) * this.getVehicleSold().getPrice();

    @Override
    public double getMonthlyPayment() {
        // Assuming the monthly payment is calculated for 36 months at 4.0% interest
        double interestRate = 4.0 / 100;
        int loanTermMonths = 36;

        double loanAmount = getTotalPrice();
        double monthlyInterestRate = interestRate / 12 / 100;
        double monthly_Payment = (loanAmount * monthlyInterestRate) /
                (1 - Math.pow(1 + monthlyInterestRate, -loanTermMonths));

        return monthly_Payment;
    }



}
