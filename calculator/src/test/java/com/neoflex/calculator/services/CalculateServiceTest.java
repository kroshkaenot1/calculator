package com.neoflex.calculator.services;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CalculateServiceTest {

    @Test
    void calculateVacationPay() {
        CalculateService cs = new CalculateService();
        assertEquals("4778,157",cs.calculateVacationPay(10000,14,""));
    }
    @Test
    void calculateVacationPayWithHolidays(){
        CalculateService cs = new CalculateService();
        assertEquals("1706,485",cs.calculateVacationPay(10000,14,"2022-01-01"));
    }
}