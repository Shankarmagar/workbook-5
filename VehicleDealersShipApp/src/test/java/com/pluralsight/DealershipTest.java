package com.pluralsight;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DealershipTest {
    @Test
    void Dealership_ConstructorFunctionality_ReturnObject() {
        //Arrange

        Dealership d = new Dealership("Shsaeli Organization", "New York NY", "777-999-7654");

        //Act
        String name = d.getName();

        //Assert

        assertEquals("Shsaeli Organization", name);
    }
}