package com.pluralsight;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LeaseContractTest {

    @Test
    public void testing() {
        Vehicle s = new Vehicle(10112, 1993, "Chevrolet", "Silverado", "truck", "Black", 2750, 31995.00);
        LeaseContract p = new LeaseContract("01/23/2023", "Shankar", "shankar@gmail.com", s);

        // Your test logic goes here
        // You can perform assertions or other actions to test your SalesContract class
        assertEquals(15997.50, p.expectedEndedValue);
        assertEquals(2239.65, p.leaseFee);
        assertEquals(18337.15, p.getMonthlyPayment());
        assertEquals(541.39, p.getTotalPrice());




    }
}