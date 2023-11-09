package com.pluralsight;

public class SalesContract extends Contract {

    public void setProcessingFee(double processingFee) {
        this.processingFee = processingFee;
    }

    public double getSaleTax() {
        return saleTax;
    }

    public void setSaleTax(double saleTax) {
        this.saleTax = saleTax;
    }

    public double getRecording_fee() {
        return recording_fee;
    }

    public void setRecording_fee(double recording_fee) {
        this.recording_fee = recording_fee;
    }

    public boolean isFinance() {
        return isFinance;
    }

    public void setFinance(boolean finance) {
        isFinance = finance;
    }

    private double processingFee;
    private double saleTax;
    private double recording_fee = 100.00;
    private boolean isFinance;

    public SalesContract(String date, String customerName, String customerEmail, Vehicle sold) {
        super(date, customerName, customerEmail, sold);
    }


    public double getProcessingFee() {
        return processingFee;
    }

    @Override
    public double getTotalPrice() {
     if(this.getVehicleSold().getPrice()> 10000)
     {
         this.processingFee = 495.00;
     }
     else{
         this.processingFee = 295;
     }

     this.saleTax = (5.00/100) * this.getVehicleSold().getPrice();
     return getVehicleSold().getPrice() + processingFee + saleTax + recording_fee;
    }

    @Override
    public double getMonthlyPayment() {
        double loanPrice = 0.00;

        if (isFinance) {
            int loanTermMonths;
            double interestRate;

            if (getVehicleSold().getPrice() >= 10000) {
                // Loan for 10,000 or more at 4.25% for 48 months
                interestRate = 4.25 / 100;
                loanTermMonths = 48;
            } else {
                // Loan for less than 10,000 at 5.25% for 24 months
                interestRate = 5.25 / 100;
                loanTermMonths = 24;
            }

            loanPrice = interestRate * this.getTotalPrice();

            double monthlyInterestRate = interestRate / 12 / 100;
            double monthlyPayment = (loanPrice * monthlyInterestRate) /
                    (1 - Math.pow(1 + monthlyInterestRate, -loanTermMonths));

            return monthlyPayment;
        }

        return 0.00;
    }


}
