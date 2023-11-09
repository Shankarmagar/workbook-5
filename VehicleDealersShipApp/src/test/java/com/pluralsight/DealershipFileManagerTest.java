package com.pluralsight;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DealershipFileManagerTest {

    @Test
    void getDealership_ReadCsv_InfoFromCsv() {
        DealershipFileManager m = new DealershipFileManager();
        Dealership d1 = m.getDealership();

        assertEquals("D & B Used Cars", d1.getName());
        assertEquals("111 Old Benbrook Rd", d1.getAddress());
        assertEquals("817-555-5555", d1.getPhone());

        assertEquals(3, d1.getInventory().size());

        assertEquals(995.00, d1.getInventory().get(0).getPrice());
        assertEquals(6995.00, d1.getInventory().get(2).getPrice());
    }
}