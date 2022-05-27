package com.example.primecalc.primecalculator;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class PrimeCalculatorUnitTest {

    @Test
    public void isPrime_testPrimeNumbers_boolean(){
        PrimeCalculator primeCalculator = new PrimeCalculator();
        assertTrue(primeCalculator.isPrime(7));
    }
    @Test
    public void isPrime_testPrimeNumbers_false(){
        PrimeCalculator primeCalculator = new PrimeCalculator();
        assertFalse(primeCalculator.isPrime(20));
    }

    @Test
    public void calculatePrime_returnPrimeNumber_arrayList(){
        PrimeCalculator primeCalculator = new PrimeCalculator();
        ArrayList<Integer> list = primeCalculator.calculatePrime(4,8);
        assertEquals(2,list.size());
    }
}
