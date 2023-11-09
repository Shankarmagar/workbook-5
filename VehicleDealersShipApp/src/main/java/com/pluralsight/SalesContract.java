package com.pluralsight;

public class SalesContract extends Contract {

    private double processingFee;
    private double saleTax;
    private double recording_fee = 100.00;
    private boolean isFinance;

    public SalesContract(String date, String customerName, String customerEmail, Vehicle sold, double totalPrice, double monthlyPayment) {
        super(date, customerName, customerEmail, sold, totalPrice, monthlyPayment);
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

     this.saleTax = (5/100) * this.getVehicleSold().getPrice();
     return processingFee + saleTax + recording_fee;
    }

    @Override
    public double getMonthlyPayment() {
        double loanPrice = 0.00;
        if(isFinance)
        {
            if(getVehicleSold().getPrice()>=10000)
            {
              loanPrice = 4.25/100 * this.getTotalPrice();
            }
            else{
                loanPrice = 2.25/100 * this.getTotalPrice();
            }
        }
        return loanPrice;
    }


}
