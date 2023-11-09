package com.pluralsight;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class SalesContractTest {

    @Test
    public void testing() {
        Vehicle s = new Vehicle(10112, 1993, "Ford", "Explorer", "SUV", "Red", 525123, 995.00);
        SalesContract p = new SalesContract("01/23/2023", "Shankar", "shankar@gmail.com", s);

        // Your test logic goes here
        // You can perform assertions or other actions to test your SalesContract class
        assertEquals(1439.75, p.getTotalPrice());
        assertEquals(0.00, p.getMonthlyPayment());

    }
}
